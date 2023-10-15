package spring.mvc.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import spring.mvc.mapper.ProductMapper;
import spring.mvc.model.Product;

@Repository
public class ProductRepository extends BaseRepository{
	
	public List<Product> getListProduct(){
		List<Product> pList = new ArrayList<>();
		String sqlString = "SELECT product.*, category.category_name, f.*\r\n"
				+ "FROM `tbl_product` AS product\r\n"
				+ "INNER JOIN `tbl_category` AS category ON product.category_id = category.category_id\r\n"
				+ "LEFT JOIN tbl_flashsale AS f ON f.product_id = product.product_id\r\n"
				+ "";
		pList = jdbcTemplate.query(sqlString, new ProductMapper());
		return pList;
	}
	
	public List<Product> getListProductPopular(){
		List<Product> pList = new ArrayList<>();
		String sqlString = "SELECT product.*, category.category_name, f.* FROM tbl_category AS category, tbl_product AS product\r\n"
				+ "INNER JOIN (SELECT product_id FROM tbl_order_details GROUP BY product_id ORDER BY COUNT(product_id) DESC LIMIT 5) AS popular_products ON product.product_id = popular_products.product_id\r\n"
				+ "LEFT JOIN tbl_flashsale AS f ON f.product_id = product.product_id\r\n"
				+ "WHERE product.category_id = category.category_id;";
		pList = jdbcTemplate.query(sqlString, new ProductMapper());
		return pList;	
	}
	
	public Product getProductById(int product_id) {
		Product product = new Product();
		String sqlString = "SELECT product.*, category.category_name, f.* FROM tbl_category AS category, tbl_product AS product \r\n"
				+ "				LEFT JOIN tbl_flashsale AS f ON f.product_id = product.product_id\r\n"
				+ "				WHERE category.category_id = product.category_id  AND product.product_id = ?";
		product = jdbcTemplate.queryForObject(sqlString, new Object[]{product_id}, new ProductMapper());
		return product;
	}
	
	public List<Product> getListProductCategory(int category_id){
		List<Product> products = new ArrayList<>();
		String sqString = "SELECT p.*, c.category_name, f.* FROM  tbl_category AS c, tbl_product AS p "
				+ "LEFT JOIN tbl_flashsale AS f ON f.product_id = p.product_id "
				+ "WHERE p.category_id = ? GROUP BY p.product_id";
		products = jdbcTemplate.query(sqString,new Object[] {category_id} , new ProductMapper());
		return products;
	}
}
