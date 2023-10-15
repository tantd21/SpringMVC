package spring.mvc.service.user;

import java.util.List;

import spring.mvc.model.GalleryProduct;
import spring.mvc.model.Product;
import spring.mvc.model.ProductType;

public interface InterDetailProductService {
	public List<GalleryProduct> getDataGalleryProducts(int product_id);
	public List<ProductType> getDataProductTypes();
	public List<Product> getDataProductCategoryList(int category_id);
}
