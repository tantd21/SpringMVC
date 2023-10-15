package spring.mvc.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import spring.mvc.mapper.ProductTypeMapper;
import spring.mvc.model.ProductType;

@Repository
public class ProductTypeRepository extends BaseRepository{
	
	public List<ProductType> getListProdcuTypes(){
		List<ProductType> productTypes = new ArrayList<>();
		String sqString = "Select * from `tbl_product_type`";
		productTypes = jdbcTemplate.query(sqString, new ProductTypeMapper());
		return productTypes;
	}
}
