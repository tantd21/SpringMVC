package spring.mvc.repositoryJpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import spring.mvc.entity.CustomerJPA;

public interface CustomerJPARepository extends JpaRepository<CustomerJPA, Long> {
	
	@Transactional
	@Query("SELECT c FROM CustomerJPA c WHERE c.customerId =:customerId")
	CustomerJPA findCustomerById(@Param("customerId") Long CustomerId);
	
	@Transactional
	@Query("SELECT c FROM CustomerJPA c WHERE c.customerEmail = :customerEmail")
	CustomerJPA findByCustomerEmail(@Param("customerEmail") String customerEmail);
	
	@Transactional
	@Query("SELECT c FROM CustomerJPA c WHERE c.customerPassword = :customerPassword")
	CustomerJPA findByCustomerPassword(@Param("customerPassword") String customerPassword);
}
