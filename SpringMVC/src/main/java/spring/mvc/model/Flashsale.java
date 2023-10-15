package spring.mvc.model;

public class Flashsale {
	private Product product;
	private int flashsale_id;
	private int flashsale_condition;
	private int flashsale_percent;
	private int flashsale_price_sale;
	private int flashsale_status;
	
	public Flashsale() {
		
	}
	
	public Flashsale(Product product, int flashsale_id, int flashsale_condition, int flashsale_percent,
			int flashsale_price_sale, int flashsale_status) {
		super();
		this.product = product;
		this.flashsale_id = flashsale_id;
		this.flashsale_condition = flashsale_condition;
		this.flashsale_percent = flashsale_percent;
		this.flashsale_price_sale = flashsale_price_sale;
		this.flashsale_status = flashsale_status;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getFlashsale_id() {
		return flashsale_id;
	}
	public void setFlashsale_id(int flashsale_id) {
		this.flashsale_id = flashsale_id;
	}
	public int getFlashsale_condition() {
		return flashsale_condition;
	}
	public void setFlashsale_condition(int flashsale_condition) {
		this.flashsale_condition = flashsale_condition;
	}
	public int getFlashsale_percent() {
		return flashsale_percent;
	}
	public void setFlashsale_percent(int flashsale_percent) {
		this.flashsale_percent = flashsale_percent;
	}
	public int getFlashsale_price_sale() {
		return flashsale_price_sale;
	}
	public void setFlashsale_price_sale(int flashsale_price_sale) {
		this.flashsale_price_sale = flashsale_price_sale;
	}
	public int getFlashsale_status() {
		return flashsale_status;
	}
	public void setFlashsale_status(int flashsale_status) {
		this.flashsale_status = flashsale_status;
	}
	
}
