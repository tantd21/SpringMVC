package spring.mvc.service.admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import spring.mvc.entity.CategoryJPA;
import spring.mvc.entity.GalleryProductJPA;
import spring.mvc.entity.ProductJPA;
import spring.mvc.model.Product;
import spring.mvc.repository.ProductRepository;
import spring.mvc.repositoryJpa.GalleryProductJPARepository;
import spring.mvc.repositoryJpa.ProductJPARepository;

@Service
public class ProductService implements ImpProductService {
	@Autowired
	ProductRepository productRepository;
	@Autowired
	ProductJPARepository productJPARepository;
	@Autowired
	GalleryProductJPARepository galleryProductJPARepository;

	@Override
	public List<ProductJPA> getAllProducts() {
		// TODO Auto-generated method stub
		return productJPARepository.findAll();
	}

	@Override
	public Page<ProductJPA> getAllProductJPAs(Pageable pageable) {
		// TODO Auto-generated method stub
		return productJPARepository.findAll(pageable);
	}

	@Override
	public void deleteProduct(Long productId) {
		productJPARepository.deletedProduct(productId);
	}
	
	@Override
	public List<ProductJPA> getProductInNotFlashsale() {
		// TODO Auto-generated method stub
		return productJPARepository.findProductsInNotFlashsale();
	}

	@Override
	public boolean saveProduct(ProductJPA productJPA, MultipartFile file, Long catLong) {
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				String nameFile = UUID.randomUUID() + file.getOriginalFilename();
				System.out.println(productJPA.getProductName());
				productJPA.setProductImage(nameFile);
				productJPA.setFlashsaleStatus(0);
				CategoryJPA categoryJPA = new CategoryJPA();
				categoryJPA.setCategoryId(catLong);
				productJPA.setCategory(categoryJPA);
				productJPARepository.save(productJPA);
				Path path = Paths
						.get("E:\\eclipse-workspace-1\\SpringMVC\\src\\main\\webapp\\assets\\web\\img\\product\\"
								+ nameFile);
				Files.write(path, bytes);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Loi: " + e.getMessage());
				e.printStackTrace();
			}
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updateProduct(ProductJPA productJPA, MultipartFile file, String photo, Long catLong) {
		CategoryJPA categoryJPA = new CategoryJPA();
		categoryJPA.setCategoryId(catLong);
		productJPA.setCategory(categoryJPA);
		if (file.isEmpty()) {
			productJPA.setProductImage(photo);
			productJPARepository.save(productJPA);
		} else {
			byte[] bytes;
			String imageString = "E:\\eclipse-workspace-1\\SpringMVC\\src\\main\\webapp\\assets\\web\\img\\product\\"
					+ photo;
			File file1 = new File(imageString);
			if (file1.exists()) {
				if (file1.delete()) {
					System.out.println("File đã xóa khỏi thư mục!");
				} else {
					System.out.println("File chưa xóa!");
				}
			}
			try {
				bytes = file.getBytes();
				String nameFile = UUID.randomUUID() + file.getOriginalFilename();
				Path path = Paths.get(
						"E:\\eclipse-workspace-1\\SpringMVC\\src\\main\\webapp\\assets\\web\\img\\product\\" + nameFile);
//				File file2 = new File(path);
				productJPA.setProductImage(nameFile);
				Files.write(path, bytes);
				productJPARepository.save(productJPA);
			} catch (IOException e) {
				System.out.println("Đã có lỗi");
			}
		}
		return true;
	}

	@Override
	public ProductJPA findProductById(Long id) {
		// TODO Auto-generated method stub
		return productJPARepository.findProductById(id);
	}

	@Override
	public List<ProductJPA> searchProductJPAs(String productName, Optional<Integer> p) {
		List<ProductJPA> productJPAs = new ArrayList<>();
		if (productName.equals("")) {
			PageRequest pageRequest = new PageRequest(p.orElse(0), 6);
			Pageable pageable = pageRequest;
			Page<ProductJPA> page = productJPARepository.findAll(pageable);
			productJPAs = page.getContent();
		} else {
			productJPAs = productJPARepository.searchProductsJpas(productName);
		}
		return productJPAs;
	}

	@Override
	public void saveGallerys(List<MultipartFile> files, Long productId) {
		// TODO Auto-generated method stub
//		for(MultipartFile file: files) {
//			System.out.println(file.getOriginalFilename());
//		}
		ProductJPA productJPA = new ProductJPA();
		productJPA.setProductId(productId);
		for (MultipartFile file : files) {
			if (!file.isEmpty()) {
				byte[] bytes;
				try {
					bytes = file.getBytes();
					String nameFile = UUID.randomUUID() + file.getOriginalFilename();
					Path path = Paths
							.get("E:\\eclipse-workspace-1\\SpringMVC\\src\\main\\webapp\\assets\\web\\img\\product\\"
									+ nameFile);
					GalleryProductJPA galleryProductJPA = new GalleryProductJPA();
					galleryProductJPA.setGalleryImageContent("Nội dung ảnh");
					galleryProductJPA.setGalleryImageName("Tên ảnh");
					galleryProductJPA.setGalleryImageProduct(nameFile);
					galleryProductJPA.setProduct(productJPA);
					galleryProductJPARepository.save(galleryProductJPA);
					Files.write(path, bytes);
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}	
	@Override
	public boolean deleteGallery(Long deleteId, String filename) {
		String imageString = "E:\\eclipse-workspace-1\\SpringMVC\\src\\main\\webapp\\assets\\web\\img\\product\\"
				+ filename;
		File file = new File(imageString);
		if (file.exists()) {
			if (file.delete()) {
				System.out.println("File đã xóa khỏi thư mục!");
				galleryProductJPARepository.delete(deleteId);
			} else {
				System.out.println("File chưa xóa!");
			}
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public boolean updateGalleryContent(Long galleryId, String galleryContent, int type) {
		if(type == 1) {
			galleryProductJPARepository.updateGalleryName(galleryId, galleryContent);	
		}else {
			galleryProductJPARepository.updateGalleryContent(galleryId, galleryContent);
		}
		return true;
	}
}
