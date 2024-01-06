package spring.mvc.service.admin;

import java.util.Optional;

import org.springframework.data.domain.Page;

import spring.mvc.entity.FlashsaleJPA;

public interface ImpFlashsaleJPAService {
	public Page<FlashsaleJPA> getAllFlashsales(Optional<Integer> p);
	public FlashsaleJPA findFlashsaleById(Long flashsaleId);
	public boolean saveFlashsale(FlashsaleJPA flashsale, Long productId);
	public boolean updateFlashsale(FlashsaleJPA flashsale, Long productId, double productPrice);
	public boolean deleteFlashsale(Long flashsaleId, Long productId);
}
