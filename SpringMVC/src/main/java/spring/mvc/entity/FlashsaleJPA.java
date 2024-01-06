package spring.mvc.entity;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbl_flashsale")
public class FlashsaleJPA {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "flashsale_id")
	private Long flashsaleId;

	@OneToOne
	@JoinColumn(name = "product_id")
	private ProductJPA product;
	
	@Column(name = "flashsale_condition")
	private int flashsaleCondition;

	@Column(name = "flashsale_percent")
	private double flashsalePercent;

	@Column(name = "flashsale_price_sale")
	private double flashsalePriceSale;

	@Column(name = "flashsale_status")
	private int flashsaleStatus;

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

	public Long getFlashsaleId() {
		return flashsaleId;
	}

	public void setFlashsaleId(Long flashsaleId) {
		this.flashsaleId = flashsaleId;
	}

	public int getFlashsaleCondition() {
		return flashsaleCondition;
	}

	public void setFlashsaleCondition(int flashsaleCondition) {
		this.flashsaleCondition = flashsaleCondition;
	}

	public double getFlashsalePercent() {
		return flashsalePercent;
	}

	public void setFlashsalePercent(double flashsalePercent) {
		this.flashsalePercent = flashsalePercent;
	}

	public double getFlashsalePriceSale() {
		return flashsalePriceSale;
	}

	public void setFlashsalePriceSale(double flashsalePriceSale) {
		this.flashsalePriceSale = flashsalePriceSale;
	}

	public int getFlashsaleStatus() {
		return flashsaleStatus;
	}

	public void setFlashsaleStatus(int flashsaleStatus) {
		this.flashsaleStatus = flashsaleStatus;
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
