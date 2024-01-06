package spring.mvc.service.user;

import java.util.List;

import spring.mvc.entity.CategoryJPA;
import spring.mvc.entity.CouponJPA;
import spring.mvc.entity.FlashsaleJPA;
import spring.mvc.entity.ProductJPA;
import spring.mvc.entity.ProductTypeJPA;
import spring.mvc.entity.SliderJPA;
import spring.mvc.model.ConfigWeb;
import spring.mvc.model.Coupon;
import spring.mvc.model.Flashsale;
import spring.mvc.model.Product;
import spring.mvc.model.ProductType;
import spring.mvc.model.Slider;

public interface HomeService {
	
	public List<SliderJPA> getDataSliders();
	public List<ConfigWeb> getDataConfigWebs();
	public List<FlashsaleJPA> getDataFlashsales();
	public List<Product> getDataProductPopulars();
	public List<CouponJPA> getDataCoupons();
	public ProductJPA getProductById(Long product_id);
	public List<ProductJPA> getDataProducts();
	public List<CategoryJPA> getCategoryJPAs();
	public List<ProductTypeJPA> getDataPeoProductTypes();
	public ProductTypeJPA getProductTypeJPA(Long productTypeId);
	public ProductJPA findProductWithMaxPrice();
	public ProductJPA findProductWithMinPrice();
	public List<ProductJPA> searchProducts(int priceMin, int priceMax, String text, String valueOption, String typeOption, List<Integer> categoryIdList);
}
