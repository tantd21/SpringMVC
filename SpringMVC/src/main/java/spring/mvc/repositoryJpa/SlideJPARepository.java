package spring.mvc.repositoryJpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.mvc.entity.SliderJPA;

@Repository
public interface SlideJPARepository extends JpaRepository<SliderJPA, Long>{

}
