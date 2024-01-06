package spring.mvc.service.admin;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.mvc.entity.CouponJPA;
import spring.mvc.repositoryJpa.CouponJPARepository;

@Service
public class CouponJPAService implements ImpCouponJPAService {
	@Autowired
	CouponJPARepository couponRepository;

	@Override
	public List<CouponJPA> getAllCouponJPAs() {
		// TODO Auto-generated method stub
		return couponRepository.findAll();
	}

	@Override
	public CouponJPA getCouponJPAById(Long id) {
		// TODO Auto-generated method stub
		return couponRepository.findCouponById(id);
	}

	@Override
	public void deleteCoupon(Long idLong) {
		// TODO Auto-generated method stub
		couponRepository.deleteCoupon(idLong);
	}

	@Override
	public boolean saveCoupon(CouponJPA coupon) {
		String couponDateEnd = coupon.getCouponDateEnd();
		LocalDate specifiedDate = LocalDate.parse(couponDateEnd);
		LocalDate currentDate = LocalDate.now();
		// So sánh thời gian chỉ định với thời gian hiện tại
		if (specifiedDate.isBefore(currentDate)) {
			System.out.println("Thời gian chỉ định đã qua.");
			return false;
		} else if (specifiedDate.isEqual(currentDate)) {
			System.out.println("Thời gian chỉ định là ngày hôm nay.");
			couponRepository.save(coupon);
			return true;
		} else {
			System.out.println("Thời gian chỉ định sẽ đến sau.");
			couponRepository.save(coupon);
			return true;
		}
	}

	@Override
	public void updateConpon(CouponJPA couponJPA, Long id) {
		couponJPA.setCouponId(id);
		couponRepository.save(couponJPA);
	}
	
	@Override
	public CouponJPA checkCoupon(String couponName) {
		CouponJPA couponJPA = couponRepository.findCouponByCouponNameCode(couponName);
		if(couponJPA != null) {
			return couponJPA;
		}
		return null;
	}
}
