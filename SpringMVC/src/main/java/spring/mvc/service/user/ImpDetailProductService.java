package spring.mvc.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.mvc.entity.GalleryProductJPA;
import spring.mvc.entity.ProductJPA;
import spring.mvc.entity.ProductTypeJPA;
import spring.mvc.model.GalleryProduct;
import spring.mvc.model.Product;
import spring.mvc.model.ProductType;
import spring.mvc.repository.GalleryProductRepository;
import spring.mvc.repository.ProductRepository;
import spring.mvc.repository.ProductTypeRepository;
import spring.mvc.repositoryJpa.GalleryProductJPARepository;
import spring.mvc.repositoryJpa.ProductJPARepository;
import spring.mvc.repositoryJpa.ProductTypeJPARepository;

@Service
public class ImpDetailProductService implements DetailProductService{
	@Autowired
	GalleryProductRepository galleryProductRepository;
	@Autowired
	ProductTypeRepository productTypeRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	GalleryProductJPARepository galleryProductJPARepository;
	@Autowired
	ProductTypeJPARepository productTypeJPARepository;
	@Autowired
	ProductJPARepository productJPARepository;
	@Override
	public List<GalleryProductJPA> getDataGalleryProducts(Long product_id) {
		// TODO Auto-generated method stub
		return galleryProductJPARepository.findGalleryProductJPAsById(product_id);
	}
	
	public List<ProductTypeJPA> getDataProductTypes(){
		return productTypeJPARepository.findAll();
	}
	
	@Override
	public List<ProductJPA> getDataProductCategoryList(Long category_id) {
		// TODO Auto-generated method stub
		return productJPARepository.findProductByCategoryId(category_id);
	}
}
