package spring.mvc.service.admin;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import spring.mvc.entity.CouponJPA;
import spring.mvc.repositoryJpa.CouponJPARepository;


@Service
public class CouponJPAService implements ImpCouponJPAService {
	@Autowired
	CouponJPARepository couponJPARepository;



	@Override
	public Page<CouponJPA> getAllCoupons(Optional<Integer> p) {
		PageRequest pageRequest = new PageRequest(p.orElse(0), 5);
		Pageable pageable = pageRequest;
		Page<CouponJPA> page = couponJPARepository.findAll(pageable);
		return page;
	}

	@Override
	public boolean saveCoupon(CouponJPA coupon) {
		return false;
		
	}
	@Override
	public boolean updateCoupon(CouponJPA coupon) {
		return false;
	
	}
	
	@Override
	public CouponJPA findCouponById(Long couponId) {
		// TODO Auto-generated method stub
		return couponJPARepository.findCouponById(couponId);
	}
	@Override
	public void deletedCouponJPA(Long couponId) {
		couponJPARepository.deleteCouponJPA(couponId);
	}

}
