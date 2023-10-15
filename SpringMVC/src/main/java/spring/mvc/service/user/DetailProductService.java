package spring.mvc.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.mvc.model.GalleryProduct;
import spring.mvc.model.Product;
import spring.mvc.model.ProductType;
import spring.mvc.repository.GalleryProductRepository;
import spring.mvc.repository.ProductRepository;
import spring.mvc.repository.ProductTypeRepository;

@Service
public class DetailProductService implements InterDetailProductService{
	@Autowired
	GalleryProductRepository galleryProductRepository;
	@Autowired
	ProductTypeRepository productTypeRepository;
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public List<GalleryProduct> getDataGalleryProducts(int product_id) {
		// TODO Auto-generated method stub
		return galleryProductRepository.getListGalleryProducts(product_id);
	}
	
	public List<ProductType> getDataProductTypes(){
		return productTypeRepository.getListProdcuTypes();
	}
	
	@Override
	public List<Product> getDataProductCategoryList(int category_id) {
		// TODO Auto-generated method stub
		return productRepository.getListProductCategory(category_id);
	}
}
