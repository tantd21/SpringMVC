package spring.mvc.entity;

public class CartEntity {
	private Long customerId;
	private Long productId;
	private String productName;
	private String productImage;
	private double productPrice;
	private int productQuantity;
	private Long productTypeId;
	public CartEntity(Long customerId, Long productId, String productName, String productImage, double productPrice,
			int productQuantity, Long productTypeId) {
		super();
		this.customerId = customerId;
		this.productId = productId;
		this.productName = productName;
		this.productImage = productImage;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
		this.productTypeId = productTypeId;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public Long getProductTypeId() {
		return productTypeId;
	}
	public void setProductTypeId(Long productTypeId) {
		this.productTypeId = productTypeId;
	}
}
