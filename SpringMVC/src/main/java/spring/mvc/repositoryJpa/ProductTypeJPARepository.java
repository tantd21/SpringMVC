package spring.mvc.repositoryJpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spring.mvc.entity.ProductTypeJPA;

@Repository
public interface ProductTypeJPARepository extends JpaRepository<ProductTypeJPA, Long> {
	@Transactional
	@Modifying
	@Query("DELETE FROM ProductTypeJPA p WHERE p.productTypeId =:producttypeId")
	void deletedProductType(@Param("producttypeId") Long productId);
	
	@Transactional
	@Modifying
	@Query("UPDATE ProductTypeJPA gp SET gp.productTypeStatus =:status WHERE gp.productTypeId = :productTypeId")
	void updateUnActiveProduct(@Param("productTypeId") Long galleryId, @Param("status") int status);
}
