package spring.mvc.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import spring.mvc.mapper.CouponMapper;
import spring.mvc.model.Coupon;

@Repository
public class CouponRepository extends BaseRepository{
	
	public List<Coupon> getListCoupon(){
		List<Coupon> list = new ArrayList<>();
		String sqlString = "SELECT * FROM `tbl_coupon` ORDER BY RAND() LIMIT 2;";
		list = jdbcTemplate.query(sqlString, new CouponMapper());
		return list;
	}
}
