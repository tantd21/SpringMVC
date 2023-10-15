package spring.mvc.service.admin;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import spring.mvc.entity.FlashsaleJPA;
import spring.mvc.entity.ProductJPA;
import spring.mvc.repositoryJpa.FlashsaleJPARepository;
import spring.mvc.repositoryJpa.ProductJPARepository;

@Service
public class FlashsaleJPAService implements ImpFlashsaleJPAService {
	@Autowired
	FlashsaleJPARepository flashsaleJPARepository;

	@Autowired
	ProductJPARepository productJPARepository;

	@Override
	public Page<FlashsaleJPA> getAllFlashsales(Optional<Integer> p) {
		PageRequest pageRequest = new PageRequest(p.orElse(0), 5);
		Pageable pageable = pageRequest;
		Page<FlashsaleJPA> page = flashsaleJPARepository.findAll(pageable);
		return page;
	}

	@Override
	public boolean saveFlashsale(FlashsaleJPA flashsale, Long productId) {
		ProductJPA productJPA = productJPARepository.findOne(productId);
		flashsale.setProduct(productJPA);

		if (flashsale.getFlashsaleCondition() == 0) {
			if (flashsale.getFlashsalePercent() > 100) {
				return false;
			}
			double percentDescrease = (flashsale.getFlashsalePercent() * productJPA.getProductPrice()) / 100;
			flashsale.setFlashsalePriceSale(productJPA.getProductPrice() - percentDescrease);
		} else {
			if(flashsale.getFlashsalePercent() < 1000) {
				return false;
			}
			flashsale.setFlashsalePriceSale(productJPA.getProductPrice() - flashsale.getFlashsalePercent());
		}
		flashsaleJPARepository.save(flashsale);
		return true;
	}

	@Override
	public boolean updateFlashsale(FlashsaleJPA flashsale, Long productId, double productPrice) {
		ProductJPA productJPA = new ProductJPA();
		productJPA.setProductId(productId);
		flashsale.setProduct(productJPA);
		if (flashsale.getFlashsaleCondition() == 0) {
			if (flashsale.getFlashsalePercent() > 100) {
				return false;
			}
			double percentDescrease = (flashsale.getFlashsalePercent() * productPrice) / 100;
			flashsale.setFlashsalePriceSale(productPrice - percentDescrease);
		} else {
			if(flashsale.getFlashsalePercent() < 1000) {
				return false;
			}
			flashsale.setFlashsalePriceSale(productPrice - flashsale.getFlashsalePercent());
		}
		flashsaleJPARepository.save(flashsale);
		return true;
	}
	
	@Override
	public FlashsaleJPA findFlashsaleById(Long flashsaleId) {
		// TODO Auto-generated method stub
		return flashsaleJPARepository.findFlashsaleById(flashsaleId);
	}

}
