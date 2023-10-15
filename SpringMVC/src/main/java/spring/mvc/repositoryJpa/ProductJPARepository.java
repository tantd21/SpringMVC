package spring.mvc.repositoryJpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spring.mvc.entity.ProductJPA;

@Repository
public interface ProductJPARepository extends JpaRepository<ProductJPA, Long> {

	@Transactional
	@Modifying
	@Query("DELETE FROM ProductJPA p WHERE p.productId =:productId")
	void deletedProduct(@Param("productId") Long productId);

	@Transactional
	@Modifying
	@Query("SELECT p FROM ProductJPA p WHERE p.productName LIKE %:productName%")
	List<ProductJPA> searchProductsJpas(@Param("productName") String productName);

	@Transactional
	@Query("SELECT p FROM ProductJPA p WHERE p.productId =:productId")
	ProductJPA findProductById(@Param("productId") Long productId);
	
	@Transactional
	@Modifying
	@Query("SELECT p FROM ProductJPA p WHERE p.flashsaleStatus = 0")
	List<ProductJPA> findProductsInNotFlashsale();
	
	
}
