package spring.mvc.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import spring.mvc.mapper.GalleryProductMapper;
import spring.mvc.mapper.ProductMapper;
import spring.mvc.model.GalleryProduct;

@Repository
public class GalleryProductRepository extends BaseRepository{
	
	public List<GalleryProduct> getListGalleryProducts(int product_id){
		List<GalleryProduct> galleryProducts = new ArrayList<>();
		String sqlString = "SELECT * FROM `tbl_gallery_product` AS gallery_product WHERE gallery_product.product_id = " + product_id;
		galleryProducts = jdbcTemplate.query(sqlString, new GalleryProductMapper());
		return galleryProducts;
	}
	
}
