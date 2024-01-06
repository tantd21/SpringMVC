package spring.mvc.repositoryJpa;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import spring.mvc.entity.DistrictJPA;

public interface DistrictJPARepository extends JpaRepository<DistrictJPA, Long>{

	@Transactional
	@Query("SELECT d FROM DistrictJPA d WHERE d.city.maTp=:maTp")
	public List<DistrictJPA> getDistrictFromCity(@Param("maTp") Long matp);
}
