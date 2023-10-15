package spring.mvc.repositoryJpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spring.mvc.entity.CategoryJPA;
import spring.mvc.entity.ProductJPA;

@Repository
public interface CategoryJPARepository extends JpaRepository<CategoryJPA, Long> {
	
	@Transactional
	@Query("SELECT c FROM CategoryJPA c WHERE c.categoryId =:categoryId")
	CategoryJPA findCategoryById(@Param("categoryId") Long categoryId);
	
	@Transactional
	@Modifying
	@Query("DELETE FROM CategoryJPA c WHERE c.categoryId =:categoryId")
	void deleteCategoryJPA(@Param("categoryId") Long categoryId);
}
