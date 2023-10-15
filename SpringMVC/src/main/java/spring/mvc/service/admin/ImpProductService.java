package spring.mvc.service.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import spring.mvc.entity.ProductJPA;
import spring.mvc.model.Product;

public interface ImpProductService {
	public List<ProductJPA> getAllProducts();
	public Page<ProductJPA> getAllProductJPAs(Pageable pageable);
	public ProductJPA findProductById(Long id);
	public void deleteProduct(Long productId);
	public boolean saveProduct(ProductJPA productJPA, MultipartFile file, Long catLong);
	public boolean updateProduct(ProductJPA productJPA, MultipartFile file, String photo, Long catLong);
	public List<ProductJPA> searchProductJPAs(String productName, Optional<Integer> p);
	
	public void saveGallerys(List<MultipartFile> files, Long productId);
	public boolean deleteGallery(Long deleteId, String filename);
	
	public boolean updateGalleryContent(Long galleryId, String galleryContent, int type);
	public List<ProductJPA> getProductInNotFlashsale();
}
