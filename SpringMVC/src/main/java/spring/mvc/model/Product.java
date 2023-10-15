package spring.mvc.model;

public class Product {
	private int product_id;
	private String product_name;
	private int category_id;
	private String category_name;
	private String product_desc;
	private String product_image;
	private int product_price;
	private int product_status;
	private int flashsale_status;
	private int product_view;
//	private GalleryProduct galleryProduct;
	private String created_at;
	private String updated_at;
	private String deleted_at;
	private Flashsale flashsale;
	public Product() {
		
	}
	
	public Product(int product_id, String product_name, int category_id, String category_name, String product_desc,
			String product_image, int product_price, int product_status, int flashsale_status, int product_view,
			String created_at, String updated_at, String deleted_at, Flashsale flashsale) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.category_id = category_id;
		this.category_name = category_name;
		this.product_desc = product_desc;
		this.product_image = product_image;
		this.product_price = product_price;
		this.product_status = product_status;
		this.flashsale_status = flashsale_status;
		this.product_view = product_view;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.deleted_at = deleted_at;
		this.flashsale = flashsale;
	}
	
	public int getProduct_id() {
		return product_id;
	}
	
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	
	public String getProduct_name() {
		return product_name;
	}
	
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	
	public int getCategory_id() {
		return category_id;
	}
	
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	
	public String getCategory_name() {
		return category_name;
	}
	
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	
	public Flashsale getFlashsale() {
		return flashsale;
	}

	public void setFlashsale(Flashsale flashsale) {
		this.flashsale = flashsale;
	}

	public String getProduct_desc() {
		return product_desc;
	}
	
	public void setProduct_desc(String product_desc) {
		this.product_desc = product_desc;
	}
	
	public String getProduct_image() {
		return product_image;
	}
	
	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}
	
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	public int getProduct_status() {
		return product_status;
	}
	public void setProduct_status(int product_status) {
		this.product_status = product_status;
	}
	public int getFlashsale_status() {
		return flashsale_status;
	}
	public void setFlashsale_status(int flashsale_status) {
		this.flashsale_status = flashsale_status;
	}
	public int getProduct_view() {
		return product_view;
	}
	public void setProduct_view(int product_view) {
		this.product_view = product_view;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	public String getDeleted_at() {
		return deleted_at;
	}
	public void setDeleted_at(String deleted_at) {
		this.deleted_at = deleted_at;
	}

//	public GalleryProduct getGalleryProduct() {
//		return galleryProduct;
//	}
//
//	public void setGalleryProduct(GalleryProduct galleryProduct) {
//		this.galleryProduct = galleryProduct;
//	}
//	
}