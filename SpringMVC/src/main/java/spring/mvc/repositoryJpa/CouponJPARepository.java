package spring.mvc.repositoryJpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import spring.mvc.entity.CouponJPA;
import spring.mvc.entity.FlashsaleJPA;


@Repository
public interface CouponJPARepository extends JpaRepository<CouponJPA, Long> {
	@Transactional
	@Query("SELECT c FROM CouponJPA c WHERE c.couponId =:couponId")
	CouponJPA findCouponById(@Param("couponId") Long couponId);
	
	@Transactional
	@Modifying
	@Query("DELETE FROM CouponJPA c WHERE c.couponId =:couponId")
	void deleteCouponJPA(@Param("couponId") Long couponId);
}