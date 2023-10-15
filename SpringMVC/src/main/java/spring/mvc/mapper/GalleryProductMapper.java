package spring.mvc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import spring.mvc.model.GalleryProduct;

public class GalleryProductMapper implements RowMapper<GalleryProduct> {
	@Override
	public GalleryProduct mapRow(ResultSet rs, int arg1) throws SQLException {
		GalleryProduct galleryProduct = new GalleryProduct();
		galleryProduct.setGallery_id(rs.getInt("gallery_id"));
		galleryProduct.setProduct_id(rs.getInt("product_id"));
		galleryProduct.setGallery_image_content(rs.getString("gallery_image_content"));
		galleryProduct.setGallery_image_name(rs.getString("gallery_image_name"));
		galleryProduct.setGallery_image_product(rs.getString("gallery_image_product"));
		return galleryProduct;
	}
}
