package spring.mvc.repositoryJpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import spring.mvc.entity.SliderJPA;

@Repository
public interface SlideJPARepository extends JpaRepository<SliderJPA, Long>{
//	@Query( value = "SELECT slider FROM SliderJPA slider ORDER BY slider.sliderId DESC LIMIT 2")
//    List<SliderJPA> findTop2Sliders();
}
