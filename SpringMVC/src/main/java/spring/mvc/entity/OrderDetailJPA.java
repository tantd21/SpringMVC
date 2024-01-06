package spring.mvc.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "tbl_order_details")
public class OrderDetailJPA {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_details_id")
	private Long orderDetailsId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	ProductJPA product;
	
	@Column(name = "order_code")
	private String orderCode;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id")
	OrderJPA order;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "product_price")
	private double productPrice;

	@Column(name = "product_sales_quantity")
	private int productSalesQuantity;

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

	

	public Long getOrderDetailsId() {
		return orderDetailsId;
	}

	public void setOrderDetailsId(Long orderDetailsId) {
		this.orderDetailsId = orderDetailsId;
	}

//	public String getOrderCode() {
//		return orderCode;
//	}
//
//	public void setOrderCode(String orderCode) {
//		this.orderCode = orderCode;
//	}

	public String getProductName() {
		return productName;
	}

	public ProductJPA getProduct() {
		return product;
	}

	public void setProduct(ProductJPA product) {
		this.product = product;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductSalesQuantity() {
		return productSalesQuantity;
	}

	public void setProductSalesQuantity(int productSalesQuantity) {
		this.productSalesQuantity = productSalesQuantity;
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

	public OrderJPA getOrder() {
		return order;
	}

	public void setOrder(OrderJPA order) {
		this.order = order;
	}

}
