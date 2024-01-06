package spring.mvc.repositoryJpa;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import spring.mvc.entity.DistrictJPA;
import spring.mvc.entity.WardJPA;

public interface WardRepository extends JpaRepository<WardJPA, Long>{
	@Transactional
	@Query("SELECT d FROM WardJPA d WHERE d.district.maQh=:maQh")
	public List<WardJPA> getWardFromDistrict(@Param("maQh") Long matp);
}
