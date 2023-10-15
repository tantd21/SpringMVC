package spring.mvc.model;

public class Coupon {
	private int coupon_id;
	private String coupon_name;
	private String coupon_name_code;
	private String coupon_desc;
	private int coupon_qty_code;
	private int coupon_condition;
	private int coupon_price_sale;
	private String coupon_date_start;
	private String coupon_date_end;
	
	public Coupon() {
	};
	
	
	public Coupon(int coupon_id, String coupon_name, String coupon_name_code, String coupon_desc, int coupon_qty_code,
			int coupon_condition, int coupon_price_sale, String coupon_date_start, String coupon_date_end) {
		super();
		this.coupon_id = coupon_id;
		this.coupon_name = coupon_name;
		this.coupon_name_code = coupon_name_code;
		this.coupon_desc = coupon_desc;
		this.coupon_qty_code = coupon_qty_code;
		this.coupon_condition = coupon_condition;
		this.coupon_price_sale = coupon_price_sale;
		this.coupon_date_start = coupon_date_start;
		this.coupon_date_end = coupon_date_end;
	}
	public int getCoupon_id() {
		return coupon_id;
	}
	public void setCoupon_id(int coupon_id) {
		this.coupon_id = coupon_id;
	}
	public String getCoupon_name() {
		return coupon_name;
	}
	public void setCoupon_name(String coupon_name) {
		this.coupon_name = coupon_name;
	}
	public String getCoupon_name_code() {
		return coupon_name_code;
	}
	public void setCoupon_name_code(String coupon_name_code) {
		this.coupon_name_code = coupon_name_code;
	}
	public String getCoupon_desc() {
		return coupon_desc;
	}
	public void setCoupon_desc(String coupon_desc) {
		this.coupon_desc = coupon_desc;
	}
	public int getCoupon_qty_code() {
		return coupon_qty_code;
	}
	public void setCoupon_qty_code(int coupon_qty_code) {
		this.coupon_qty_code = coupon_qty_code;
	}
	public int getCoupon_condition() {
		return coupon_condition;
	}
	public void setCoupon_condition(int coupon_condition) {
		this.coupon_condition = coupon_condition;
	}
	public int getCoupon_price_sale() {
		return coupon_price_sale;
	}
	public void setCoupon_price_sale(int coupon_price_sale) {
		this.coupon_price_sale = coupon_price_sale;
	}
	public String getCoupon_date_start() {
		return coupon_date_start;
	}
	public void setCoupon_date_start(String coupon_date_start) {
		this.coupon_date_start = coupon_date_start;
	}
	public String getCoupon_date_end() {
		return coupon_date_end;
	}
	public void setCoupon_date_end(String coupon_date_end) {
		this.coupon_date_end = coupon_date_end;
	}
}
