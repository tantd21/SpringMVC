package spring.mvc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import spring.mvc.model.ProductType;

public class ProductTypeMapper implements RowMapper<ProductType>{
	
	@Override
	public ProductType mapRow(ResultSet rs, int arg1) throws SQLException {
		ProductType productType = new ProductType();
		productType.setProduct_type_id(rs.getInt("product_type_id"));
		productType.setProduct_type_name(rs.getString("product_type_name"));
		productType.setProduct_type_price(rs.getInt("product_type_price"));
		productType.setProduct_type_status(rs.getInt("product_type_status"));
		return productType;
	}

}
