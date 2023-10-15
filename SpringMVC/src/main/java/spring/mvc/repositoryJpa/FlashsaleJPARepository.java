package spring.mvc.repositoryJpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import spring.mvc.entity.FlashsaleJPA;
import spring.mvc.entity.ProductJPA;

public interface FlashsaleJPARepository extends JpaRepository<FlashsaleJPA, Long>{
	@Transactional
	@Query("SELECT p FROM FlashsaleJPA p WHERE p.flashsaleId =:flashsaleId")
	FlashsaleJPA findFlashsaleById(@Param("flashsaleId") Long flashsaleId);
}
