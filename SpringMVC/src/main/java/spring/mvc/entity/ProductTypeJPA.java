package spring.mvc.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "tbl_product_type")
public class ProductTypeJPA {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_type_id")
	private Long productTypeId;

	@Column(name = "product_type_name")
	private String productTypeName;

	@Column(name = "product_type_price")
	private double productTypePrice;

	@Column(name = "product_type_status")
	private int productTypeStatus;

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

	public Long getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(Long productTypeId) {
		this.productTypeId = productTypeId;
	}

	public String getProductTypeName() {
		return productTypeName;
	}

	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}

	public Double getProductTypePrice() {
		return productTypePrice;
	}

	public void setProductTypePrice(Double productTypePrice) {
		this.productTypePrice = productTypePrice;
	}

	public int getProductTypeStatus() {
		return productTypeStatus;
	}

	public void setProductTypeStatus(int productTypeStatus) {
		this.productTypeStatus = productTypeStatus;
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
