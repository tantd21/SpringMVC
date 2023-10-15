package spring.mvc.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import spring.mvc.mapper.FlashsaleMapper;
import spring.mvc.model.Flashsale;

@Repository
public class FlashsaleRepository extends BaseRepository{
	
	public List<Flashsale> getListFlashsale(){
		List<Flashsale> fList = new ArrayList<>();
		String sqlString = "SELECT * FROM `tbl_flashsale`, `tbl_product`, `tbl_category` WHERE tbl_product.product_id = tbl_flashsale.product_id AND tbl_category.category_id = tbl_product.category_id";
		fList = jdbcTemplate.query(sqlString, new FlashsaleMapper());
		return fList;
	}
}
