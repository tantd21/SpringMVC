package spring.mvc.service.user;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

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
import spring.mvc.repository.ConfigWebRepository;
import spring.mvc.repository.CouponRepository;
import spring.mvc.repository.FlashsaleRepository;
import spring.mvc.repository.ProductRepository;
import spring.mvc.repository.ProductTypeRepository;
import spring.mvc.repository.SlideRepository;
import spring.mvc.repositoryJpa.CategoryJPARepository;
import spring.mvc.repositoryJpa.CouponJPARepository;
import spring.mvc.repositoryJpa.FlashsaleJPARepository;
import spring.mvc.repositoryJpa.ProductJPARepository;
import spring.mvc.repositoryJpa.ProductTypeJPARepository;
import spring.mvc.repositoryJpa.SlideJPARepository;
import spring.mvc.specification.ProductSpecifications;

@Service
public class ImpHomeService implements HomeService {
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
	@Autowired
	SlideJPARepository slideJPARepository;
	@Autowired
	ProductJPARepository productJPARepository;
	@Autowired
	FlashsaleJPARepository flashsaleJPARepository;
	@Autowired
	CouponJPARepository couponJPARepository;
	@Autowired
	ProductTypeJPARepository productTypeJPARepository;
	@Autowired
	CategoryJPARepository categoryJPARepository;
	@PersistenceContext
    private EntityManager entityManager;

	@Override
	public List<SliderJPA> getDataSliders() {
		return slideJPARepository.findAll();
	}

	@Override
	public List<ConfigWeb> getDataConfigWebs() {
		return configWebRepository.getConfigWebList();
	}
	
	@Override
	public List<FlashsaleJPA> getDataFlashsales() {
		return flashsaleJPARepository.findAll();
	}
	
	@Override
	public List<Product> getDataProductPopulars() {
		return productRepository.getListProductPopular();
	}
	
	@Override
	public List<CouponJPA> getDataCoupons() {
		return entityManager.createQuery("SELECT coupon FROM CouponJPA coupon ORDER BY coupon.couponId DESC",
		          CouponJPA.class).setMaxResults(2).getResultList();
	}
	
	@Override
	public ProductJPA getProductById(Long product_id) {
		// TODO Auto-generated method stub
		return productJPARepository.findOne(product_id);
	}
	
	@Override
	public List<ProductJPA> getDataProducts() {
		// TODO Auto-generated method stub
		return productJPARepository.findAll();
	}
	
	@Override
	public List<ProductTypeJPA> getDataPeoProductTypes() {
		// TODO Auto-generated method stub
		return productTypeJPARepository.findAll();
	}
	@Override
	public ProductTypeJPA getProductTypeJPA(Long productTypeId) {
		
		return productTypeJPARepository.findOne(productTypeId);
	}
	
	@Override
	public ProductJPA findProductWithMaxPrice() {
		// TODO Auto-generated method stub
		return entityManager.createQuery(
		            "SELECT product FROM ProductJPA product ORDER BY product.productPrice DESC", ProductJPA.class)
		            .setMaxResults(1)
		            .getSingleResult();
	}
	
	@Override
	public ProductJPA findProductWithMinPrice() {
		// TODO Auto-generated method stub
		return entityManager.createQuery(
	            "SELECT product FROM ProductJPA product ORDER BY product.productPrice ASC", ProductJPA.class)
	            .setMaxResults(1)
	            .getSingleResult();
	}
	
	public List<ProductJPA> searchProducts(int priceMin, int priceMax, String text, String valueOption, String typeOption, List<Integer> categoryIdList) {
        Specification<ProductJPA> spec = ProductSpecifications.filterProducts(priceMin, priceMax, text, valueOption, typeOption, categoryIdList);
        return productJPARepository.findAll(spec);
    }

	@Override
	public List<CategoryJPA> getCategoryJPAs() {
		// TODO Auto-generated method stub
		return categoryJPARepository.findAll();
	}
}
