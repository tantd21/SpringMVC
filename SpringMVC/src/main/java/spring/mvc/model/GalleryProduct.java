package spring.mvc.model;

public class GalleryProduct {
	private int gallery_id;
	private int product_id;
	private String gallery_image_product;
	private String gallery_image_name;
	private String gallery_image_content;
	
	public GalleryProduct() {
		// TODO Auto-generated constructor stub
	}
	
	public GalleryProduct(int gallery_id, int product_id, String gallery_image_product, String gallery_image_name,
			String gallery_image_content) {
		super();
		this.gallery_id = gallery_id;
		this.product_id = product_id;
		this.gallery_image_product = gallery_image_product;
		this.gallery_image_name = gallery_image_name;
		this.gallery_image_content = gallery_image_content;
	}
	public int getGallery_id() {
		return gallery_id;
	}
	public void setGallery_id(int gallery_id) {
		this.gallery_id = gallery_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getGallery_image_product() {
		return gallery_image_product;
	}
	public void setGallery_image_product(String gallery_image_product) {
		this.gallery_image_product = gallery_image_product;
	}
	public String getGallery_image_name() {
		return gallery_image_name;
	}
	public void setGallery_image_name(String gallery_image_name) {
		this.gallery_image_name = gallery_image_name;
	}
	public String getGallery_image_content() {
		return gallery_image_content;
	}
	public void setGallery_image_content(String gallery_image_content) {
		this.gallery_image_content = gallery_image_content;
	}
	
}

