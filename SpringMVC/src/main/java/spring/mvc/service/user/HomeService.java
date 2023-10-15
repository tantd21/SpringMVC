package spring.mvc.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.mvc.model.ConfigWeb;
import spring.mvc.model.Coupon;
import spring.mvc.model.Flashsale;
import spring.mvc.model.Product;
import spring.mvc.model.ProductType;
import spring.mvc.model.Slider;
import spring.mvc.repository.ConfigWebRepository;
import spring.mvc.repository.CouponRepository;
import spring.mvc.repository.FlashsaleRepository;
import spring.mvc.repository.ProductRepository;
import spring.mvc.repository.ProductTypeRepository;
import spring.mvc.repository.SlideRepository;

@Service
public class HomeService implements InterHomeService {
	@Autowired
	private SlideRepository slideRepository;
	@Autowired
	private ConfigWebRepository configWebRepository;
	@Autowired
	private FlashsaleRepository flashsaleRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CouponRepository couponRepository;
	@Autowired
	private ProductTypeRepository productTypeRepository;
	
	@Override
	public List<Slider> getDataSliders() {
		return slideRepository.getSlideList();
	}

	@Override
	public List<ConfigWeb> getDataConfigWebs() {
		return configWebRepository.getConfigWebList();
	}
	
	@Override
	public List<Flashsale> getDataFlashsales() {
		return flashsaleRepository.getListFlashsale();
	}
	
	@Override
	public List<Product> getDataProductPopulars() {
		return productRepository.getListProductPopular();
	}
	
	@Override
	public List<Coupon> getDataCoupons() {
		return couponRepository.getListCoupon();
	}
	
	@Override
	public Product getProductById(int product_id) {
		// TODO Auto-generated method stub
		return productRepository.getProductById(product_id);
	}
	
	@Override
	public List<Product> getDataProducts() {
		// TODO Auto-generated method stub
		return productRepository.getListProduct();
	}
	
	@Override
	public List<ProductType> getDataPeoProductTypes() {
		// TODO Auto-generated method stub
		return productTypeRepository.getListProdcuTypes();
	}
}
