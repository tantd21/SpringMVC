package spring.mvc.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "tbl_order")
public class OrderJPA {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_id")
	private Long orderId;

//	@Column(name = "customer_id")
//	private Long customerId;
	
	@ManyToOne	
	@JoinColumn(name = "customer_id")
	private CustomerJPA customer;
//	@Column(name = "shipping_id")
//	private Long shippingId;
	
	@OneToOne
	@JoinColumn(name = "shipping_id")
	private ShippingJPA shipping;
	
	@OneToOne
	@JoinColumn(name = "payment_id")
	private PaymentJPA payment;

//	@Column(name = "payment_id")
//	private Long paymentId;

	@Column(name = "order_status")
	private int orderStatus;

	@Column(name = "order_code")
	private String orderCode;

	@Column(name = "product_coupon")
	private String productCoupon;
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<OrderDetailJPA> orderDetails;

	@Column(name = "coupon_sale")
	private double couponSale;

	@Column(name = "product_fee")
	private double productFee;

	@Column(name = "total_price")
	private double totalPrice;

	@Column(name = "total_quantity")
	private int totalQuantity;

	@Column(name = "order_date", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderDate;

	@Column(name = "created_at", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	@Column(name = "updated_at", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;

	@Column(name = "deleted_at", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date deletedAt;

	@PrePersist
	protected void onCreate() {
		createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		updatedAt = new Date();
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public CustomerJPA getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerJPA customer) {
		this.customer = customer;
	}

	public List<OrderDetailJPA> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetailJPA> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public ShippingJPA getShipping() {
		return shipping;
	}

	public void setShipping(ShippingJPA shipping) {
		this.shipping = shipping;
	}

	public PaymentJPA getPayment() {
		return payment;
	}

	public void setPayment(PaymentJPA payment) {
		this.payment = payment;
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getProductCoupon() {
		return productCoupon;
	}

	public void setProductCoupon(String productCoupon) {
		this.productCoupon = productCoupon;
	}

	public double getCouponSale() {
		return couponSale;
	}

	public void setCouponSale(double couponSale) {
		this.couponSale = couponSale;
	}

	public double getProductFee() {
		return productFee;
	}

	public void setProductFee(double productFee) {
		this.productFee = productFee;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Date getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}
	
}
