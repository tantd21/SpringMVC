package spring.mvc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

	@Column(name = "coupon_name")
	private String couponName;

	@Column(name = "coupon_name_code")
	private String couponNameCode;

	@Column(name = "coupon_desc")
	private String couponDesc;

	@Column(name = "coupon_qty_code")
	private double couponQtyCode;

	@Column(name = "coupon_condition")
	private double couponCondition;

	@Column(name = "coupon_price_sale")
	private double couponPriceSale;

	@Column(name = "coupon_date_start")
	private String couponDateStart;

	@Column(name = "coupon_date_end")
	private String couponDateEnd;
	
	@Column(name = "created_at", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	@Column(name = "updated_at", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;

	@PrePersist
	protected void onCreate() {
		createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		updatedAt = new Date();
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

	public String getCouponDesc() {
		return couponDesc;
	}

	public void setCouponDesc(String couponDesc) {
		this.couponDesc = couponDesc;
	}

	public double getCouponQtyCode() {
		return couponQtyCode;
	}

	public void setCouponQtyCode(double couponQtyCode) {
		this.couponQtyCode = couponQtyCode;
	}

	public double getCouponCondition() {
		return couponCondition;
	}

	public void setCouponCondition(double couponCondition) {
		this.couponCondition = couponCondition;
	}

	public double getCouponPriceSale() {
		return couponPriceSale;
	}

	public void setCouponPriceSale(double couponPriceSale) {
		this.couponPriceSale = couponPriceSale;
	}

	public String getCouponDateStart() {
		return couponDateStart;
	}

	public void setCouponDateStart(String couponDateStart) {
		this.couponDateStart = couponDateStart;
	}

	public String getCouponDateEnd() {
		return couponDateEnd;
	}

	public void setCouponDateEnd(String couponDateEnd) {
		this.couponDateEnd = couponDateEnd;
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
}
