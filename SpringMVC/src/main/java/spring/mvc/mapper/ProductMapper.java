package spring.mvc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import spring.mvc.model.Flashsale;
import spring.mvc.model.GalleryProduct;
import spring.mvc.model.Product;

public class ProductMapper implements RowMapper<Product>{
	
	@Override
	public Product mapRow(ResultSet rs, int arg1) throws SQLException {
		Product product = new Product();
		product.setProduct_id(rs.getInt("product_id"));
		product.setProduct_name(rs.getString("product_name"));
		product.setCategory_id(rs.getInt("category_id"));
		product.setCategory_name(rs.getString("category_name"));
		product.setProduct_desc(rs.getString("product_desc"));
		product.setProduct_image(rs.getString("product_image"));
		product.setProduct_price(rs.getInt("product_price"));
		product.setProduct_status(rs.getInt("product_status"));
		product.setFlashsale_status(rs.getInt("flashsale_status"));
		product.setProduct_view(rs.getInt("product_view"));
		product.setCreated_at(rs.getString("created_at"));
		product.setUpdated_at(rs.getString("updated_at"));
		product.setDeleted_at(rs.getString("deleted_at"));
		Flashsale flashsale = new Flashsale();
		flashsale.setFlashsale_id(rs.getInt("flashsale_id"));
		flashsale.setFlashsale_condition(rs.getInt("flashsale_condition"));
		flashsale.setFlashsale_percent(rs.getInt("flashsale_percent"));
		flashsale.setFlashsale_price_sale(rs.getInt("flashsale_price_sale"));
		flashsale.setFlashsale_status(rs.getInt("flashsale_status"));
		product.setFlashsale(flashsale);
//		GalleryProduct galleryProduct = new GalleryProduct();
//		galleryProduct.setGallery_id(rs.getInt("gallery_id"));
//		galleryProduct.setGallery_image_content(rs.getString("gallery_image_content"));
//		galleryProduct.setGallery_image_name(rs.getString("gallery_image_name"));
//		galleryProduct.setGallery_image_product(rs.getString("gallery_image_product"));
//		galleryProduct.setProduct_id(rs.getInt("product_id"));
//		product.setGalleryProduct(galleryProduct);
		return product;
	}
}
