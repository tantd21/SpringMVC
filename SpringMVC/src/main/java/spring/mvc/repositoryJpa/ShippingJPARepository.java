package spring.mvc.repositoryJpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.mvc.entity.ShippingJPA;

@Repository
public interface ShippingJPARepository extends JpaRepository<ShippingJPA, Long>{

}
