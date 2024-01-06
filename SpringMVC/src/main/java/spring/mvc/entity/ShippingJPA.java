package spring.mvc.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "tbl_shipping")
public class ShippingJPA {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "shipping_id")
	private Long shippingId;

	@Column(name = "shipping_name")
	private String shippingName;

	@Column(name = "shipping_email")
	private String shippingEmail;

	@Column(name = "shipping_phone")
	private String shippingPhone;

	@Column(name = "shipping_address")
	private String shippingAddress;

	@Column(name = "shipping_notes")
	private String shippingNotes;

	@Column(name = "shipping_special_requirements")
	private String shippingSpecialRequirements;

	@Column(name = "shipping_receipt")
	private String shippingReceipt;

	@Column(name = "created_at", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	@Column(name = "updated_at", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;

	@Column(name = "deleted_at", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date deletedAt;
	
	@OneToOne(mappedBy = "shipping", cascade = CascadeType.ALL)
	private OrderJPA order;

	@PrePersist
	protected void onCreate() {
		createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		updatedAt = new Date();
	}

	public Long getShippingId() {
		return shippingId;
	}

	public void setShippingId(Long shippingId) {
		this.shippingId = shippingId;
	}

	public String getShippingName() {
		return shippingName;
	}

	public void setShippingName(String shippingName) {
		this.shippingName = shippingName;
	}

	public String getShippingEmail() {
		return shippingEmail;
	}

	public void setShippingEmail(String shippingEmail) {
		this.shippingEmail = shippingEmail;
	}

	public String getShippingPhone() {
		return shippingPhone;
	}

	public void setShippingPhone(String shippingPhone) {
		this.shippingPhone = shippingPhone;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getShippingNotes() {
		return shippingNotes;
	}

	public void setShippingNotes(String shippingNotes) {
		this.shippingNotes = shippingNotes;
	}

	public String getShippingSpecialRequirements() {
		return shippingSpecialRequirements;
	}

	public void setShippingSpecialRequirements(String shippingSpecialRequirements) {
		this.shippingSpecialRequirements = shippingSpecialRequirements;
	}

	public String getShippingReceipt() {
		return shippingReceipt;
	}

	public void setShippingReceipt(String shippingReceipt) {
		this.shippingReceipt = shippingReceipt;
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