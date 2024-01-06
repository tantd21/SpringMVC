package spring.mvc.service.admin;

import java.util.List;

import spring.mvc.entity.CouponJPA;

public interface ImpCouponJPAService {
	List<CouponJPA> getAllCouponJPAs();
	CouponJPA getCouponJPAById(Long id);
	void deleteCoupon(Long idLong);
	boolean saveCoupon(CouponJPA coupon);
	void updateConpon(CouponJPA couponJPA, Long id);
	CouponJPA checkCoupon(String couponName);
}
