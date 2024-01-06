package spring.mvc.service.user;

import java.util.List;

import spring.mvc.entity.GalleryProductJPA;
import spring.mvc.entity.ProductJPA;
import spring.mvc.entity.ProductTypeJPA;
import spring.mvc.model.GalleryProduct;
import spring.mvc.model.Product;
import spring.mvc.model.ProductType;

public interface DetailProductService {
	public List<GalleryProductJPA> getDataGalleryProducts(Long product_id);
	public List<ProductTypeJPA> getDataProductTypes();
	public List<ProductJPA> getDataProductCategoryList(Long category_id);
}
