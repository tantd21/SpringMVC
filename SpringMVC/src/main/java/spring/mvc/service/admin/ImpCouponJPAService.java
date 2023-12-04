package spring.mvc.service.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import spring.mvc.entity.CategoryJPA;
import spring.mvc.entity.CouponJPA;

public interface ImpCouponJPAService {
	
	public Page<CouponJPA> getAllCoupons(Optional<Integer> p);
	public CouponJPA findCouponById(Long couponId);
	public void saveCoupon(CouponJPA couponJPA);
	public void updateCoupon(CouponJPA couponJPA);
	public void deletedCouponJPA(Long couponId);
}
