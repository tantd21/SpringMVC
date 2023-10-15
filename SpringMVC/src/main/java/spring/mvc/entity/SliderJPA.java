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
@Table(name = "tbl_slider")
public class SliderJPA {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "slider_id")
	private Long sliderId;

	@Column(name = "slider_name")
	private String sliderName;

	@Column(name = "slider_image")
	private String sliderImage;

	@Column(name = "slider_status")
	private int sliderStatus;

	@Column(name = "slider_desc")
	private String sliderDesc;

	/*
	 * @Column(name = "created_at", nullable = true)
	 * 
	 * @Temporal(TemporalType.TIMESTAMP) private Date createdAt;
	 * 
	 * @Column(name = "updated_at", nullable = true)
	 * 
	 * @Temporal(TemporalType.TIMESTAMP) private Date updatedAt;
	 * 
	 * @Column(name = "deleted_at", nullable = true)
	 * 
	 * @Temporal(TemporalType.TIMESTAMP) private Date deletedAt;
	 */

	/*
	 * @PrePersist protected void onCreate() { createdAt = new Date(); }
	 * 
	 * @PreUpdate protected void onUpdate() { updatedAt = new Date(); }
	 */

	public Long getSliderId() {
		return sliderId;
	}

	public void setSliderId(Long sliderId) {
		this.sliderId = sliderId;
	}

	public String getSliderName() {
		return sliderName;
	}

	public void setSliderName(String sliderName) {
		this.sliderName = sliderName;
	}

	public String getSliderImage() {
		return sliderImage;
	}

	public void setSliderImage(String sliderImage) {
		this.sliderImage = sliderImage;
	}

	public int getSliderStatus() {
		return sliderStatus;
	}

	public void setSliderStatus(int sliderStatus) {
		this.sliderStatus = sliderStatus;
	}

	public String getSliderDesc() {
		return sliderDesc;
	}

	public void setSliderDesc(String sliderDesc) {
		this.sliderDesc = sliderDesc;
	}

	/*
	 * public Date getCreatedAt() { return createdAt; }
	 * 
	 * public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }
	 * 
	 * public Date getUpdatedAt() { return updatedAt; }
	 * 
	 * public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; }
	 * 
	 * public Date getDeletedAt() { return deletedAt; }
	 * 
	 * public void setDeletedAt(Date deletedAt) { this.deletedAt = deletedAt; }
	 */

}
