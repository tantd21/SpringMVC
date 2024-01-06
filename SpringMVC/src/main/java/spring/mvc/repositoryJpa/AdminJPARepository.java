package spring.mvc.repositoryJpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import spring.mvc.entity.AdminJPA;
@Repository
public interface AdminJPARepository extends JpaRepository<AdminJPA, Long>{
	
	@Query("SELECT a FROM AdminJPA a WHERE a.adminEmail =:adminEmail")
	AdminJPA findByAdminEmail(@Param("adminEmail") String adminEmail);
	
}
