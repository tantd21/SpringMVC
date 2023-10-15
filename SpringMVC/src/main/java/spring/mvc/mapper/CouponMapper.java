package spring.mvc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import spring.mvc.model.Coupon;

public class CouponMapper implements RowMapper<Coupon>{
	@Override
	public Coupon mapRow(ResultSet rs, int arg1) throws SQLException {
		Coupon coupon = new Coupon();
		coupon.setCoupon_id(rs.getInt("coupon_id"));
		coupon.setCoupon_name(rs.getString("coupon_name"));
		coupon.setCoupon_desc(rs.getString("coupon_desc"));
		coupon.setCoupon_name_code(rs.getString("coupon_name_code"));
		coupon.setCoupon_condition(rs.getInt("coupon_condition"));
		coupon.setCoupon_price_sale(rs.getInt("coupon_price_sale"));
		coupon.setCoupon_qty_code(rs.getInt("coupon_qty_code"));
		coupon.setCoupon_date_start(rs.getString("coupon_date_start"));
		coupon.setCoupon_date_end(rs.getString("coupon_date_end"));
		return coupon;
	}
	
}
