package spring.mvc.service.admin;

import java.util.Optional;

import org.springframework.data.domain.Page;

import spring.mvc.entity.CouponJPA;

public interface ImpCouponJPAService {
	public Page<CouponJPA> getAllCoupons(Optional<Integer> p);
	public CouponJPA findCouponById(Long couponId);
	public boolean saveCoupon(CouponJPA coupon);

	public boolean updateCoupon(CouponJPA coupon);
	void deletedCouponJPA(Long couponId);
}
