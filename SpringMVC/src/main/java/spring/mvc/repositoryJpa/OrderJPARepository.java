package spring.mvc.repositoryJpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.mvc.entity.OrderJPA;

@Repository
public interface OrderJPARepository extends JpaRepository<OrderJPA, Long>{

}
