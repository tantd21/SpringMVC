package spring.mvc.entity;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbl_coupon")
public class CouponJPA {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "coupon_id")
	private Long couponId;

//	@Column(name = "product_id")
//	private Long productId;

	@OneToOne
	@JoinColumn(name = "product_id")
	private ProductJPA product;
	
	@Column(name = "coupon_name")
	private String couponName;

	@Column(name = "coupon_name_conde")
	private String couponNameCode;

	@Column(name = "coupon_decs")
	private String couponDecs;

	@Column(name = "coupon_qty_code")
	private int couponQty;
	
	@Column(name = "coupon_price_sale")
	private int couponPrice;

	@Column(name = "coupon_date_start")
	private String couponStart;

	@Column(name = "coupon_date_end")
	private String couponEnd;

	@Column(name = "created_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	@Column(name = "updated_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;

	@Column(name = "deleted_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date deletedAt;

	@PrePersist
	protected void onCreate() {
		createdAt = new Date();
	}
	


	public Long getCouponId() {
		return couponId;
	}

	public void setCouponId(Long couponId) {
		this.couponId = couponId;
	}

	public String getCouponName() {
		return couponName;
	}

	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}

	public String getCouponNameCode() {
		return couponNameCode;
	}

	public void setCouponNameCode(String couponNameCode) {
		this.couponNameCode = couponNameCode;
	}

	public String getCouponDecs() {
		return couponDecs;
	}

	public void setCouponDecs(String couponDecs) {
		this.couponDecs = couponDecs;
	}

	public int getCouponQty() {
		return couponQty;
	}

	public void setCouponQty(int couponQty) {
		this.couponQty = couponQty;
	}

	public int getCouponPrice() {
		return couponPrice;
	}

	public void setCouponPrice(int couponPrice) {
		this.couponPrice = couponPrice;
	}

	public String getCouponStart() {
		return couponStart;
	}

	public void setCouponStart(String couponStart) {
		this.couponStart = couponStart;
	}

	public String getCouponEnd() {
		return couponEnd;
	}

	public void setCouponEnd(String couponEnd) {
		this.couponEnd = couponEnd;
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

	@PreUpdate
	protected void onUpdate() {
		updatedAt = new Date();
	}
	
	public ProductJPA getProduct() {
		return product;
	}

	public void setProduct(ProductJPA product) {
		this.product = product;
	}


	
}
