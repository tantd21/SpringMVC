package spring.mvc.service.user;

import java.util.List;

import spring.mvc.model.ConfigWeb;
import spring.mvc.model.Coupon;
import spring.mvc.model.Flashsale;
import spring.mvc.model.Product;
import spring.mvc.model.ProductType;
import spring.mvc.model.Slider;

public interface InterHomeService {
	
	public List<Slider> getDataSliders();
	public List<ConfigWeb> getDataConfigWebs();
	public List<Flashsale> getDataFlashsales();
	public List<Product> getDataProductPopulars();
	public List<Coupon> getDataCoupons();
	public Product getProductById(int product_id);
	public List<Product> getDataProducts();
	public List<ProductType> getDataPeoProductTypes();
}
