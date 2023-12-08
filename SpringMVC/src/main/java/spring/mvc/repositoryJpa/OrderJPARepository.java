package spring.mvc.repositoryJpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spring.mvc.entity.OrderJPA;
import spring.mvc.entity.ProductJPA;

@Repository
public interface OrderJPARepository extends JpaRepository<OrderJPA, Long> {
	
	@Transactional
	@Query("SELECT c FROM OrderJPA c WHERE c.orderId =:orderId")
	OrderJPA findCategoryById(@Param("orderId") Long orderId);
	
	@Transactional
	@Modifying
	@Query("DELETE FROM OrderJPA c WHERE c.orderId =:orderId")
	void deleteOrderJPA(@Param("orderId") Long orderId);
}
