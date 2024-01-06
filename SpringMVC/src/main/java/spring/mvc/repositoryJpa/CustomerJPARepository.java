package spring.mvc.repositoryJpa;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import spring.mvc.entity.CustomerJPA;
@Repository
public interface CustomerJPARepository extends JpaRepository<CustomerJPA, Long>{

	@Transactional
	@Query("SELECT c FROM CustomerJPA c WHERE c.customerEmail = :email AND c.customerPassword = :pass")
	CustomerJPA findCustomerLogin(@Param("email") String email,@Param("pass") String pass);
	
	@Transactional
	@Query("SELECT c FROM CustomerJPA c WHERE c.customerEmail = :email")
	CustomerJPA findCustomerIsExist(@Param("email") String email);
}
