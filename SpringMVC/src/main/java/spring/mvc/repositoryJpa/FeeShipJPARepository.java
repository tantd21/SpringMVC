package spring.mvc.repositoryJpa;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import spring.mvc.entity.DistrictJPA;
import spring.mvc.entity.FeeJPA;

@Repository
public interface FeeShipJPARepository extends JpaRepository<FeeJPA, Long>{
	@Transactional
	@Query("SELECT d FROM FeeJPA d WHERE d.ward.xaid=:xaid")
	public FeeJPA getFeeJPAByIdXa(@Param("xaid") Long xaid);
	
}
