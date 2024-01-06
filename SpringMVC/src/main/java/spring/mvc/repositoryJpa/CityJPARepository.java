package spring.mvc.repositoryJpa;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.mvc.entity.CityJPA;

public interface CityJPARepository extends JpaRepository<CityJPA, Long>{

}
