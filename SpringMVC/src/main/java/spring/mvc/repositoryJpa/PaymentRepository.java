package spring.mvc.repositoryJpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.mvc.entity.PaymentJPA;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentJPA, Long>{
	
}
