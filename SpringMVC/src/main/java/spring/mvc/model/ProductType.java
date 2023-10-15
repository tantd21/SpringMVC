package spring.mvc.model;

public class ProductType {
	private int product_type_id;
	private String product_type_name;
	private int product_type_price;
	private int product_type_status;
	
	public ProductType() {
		
	}

	public ProductType(int product_type_id, String product_type_name, int product_type_price, int product_type_status) {
		super();
		this.product_type_id = product_type_id;
		this.product_type_name = product_type_name;
		this.product_type_price = product_type_price;
		this.product_type_status = product_type_status;
	}

	public int getProduct_type_id() {
		return product_type_id;
	}

	public void setProduct_type_id(int product_type_id) {
		this.product_type_id = product_type_id;
	}

	public String getProduct_type_name() {
		return product_type_name;
	}

	public void setProduct_type_name(String product_type_name) {
		this.product_type_name = product_type_name;
	}

	public int getProduct_type_price() {
		return product_type_price;
	}

	public void setProduct_type_price(int product_type_price) {
		this.product_type_price = product_type_price;
	}

	public int getProduct_type_status() {
		return product_type_status;
	}

	public void setProduct_type_status(int product_type_status) {
		this.product_type_status = product_type_status;
	}
	
}
