package spring.mvc.service.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import spring.mvc.entity.CategoryJPA;
import spring.mvc.entity.CouponJPA;
import spring.mvc.repositoryJpa.CouponJPARepository;


@Service
public class CouponJPAService implements ImpCouponJPAService {
	@Autowired
	CouponJPARepository couponJPARepository;
	



	
	public Page<CouponJPA> getAllCoupons(Optional<Integer> p) {
		PageRequest pageRequest = new PageRequest(p.orElse(0), 5);
		Pageable pageable = pageRequest;
		Page<CouponJPA> page = couponJPARepository.findAll(pageable);
		return page;
	}

	@Override
	public void saveCoupon(CouponJPA couponJPA) {
		couponJPARepository.save(couponJPA);
		
	}
	@Override
	public void updateCoupon(CouponJPA couponJPA) {
		couponJPARepository.save(couponJPA);
	
	}
	
	@Override
	public CouponJPA findCouponById(Long couponId) {
		return couponJPARepository.findCouponById(couponId);
	}
	@Override
	public void deletedCouponJPA(Long couponId) {
		couponJPARepository.deleteCouponJPA(couponId);
	}

}
