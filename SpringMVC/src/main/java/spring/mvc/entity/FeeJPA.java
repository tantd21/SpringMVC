package spring.mvc.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "tbl_feeship")
public class FeeJPA {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "fee_id")
    private Long feeId;

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "matp")
	CityJPA city;
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maqh")
	DistrictJPA district;

    @OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "xaid")
	private WardJPA ward;

    @Column(name = "fee_feeship")
    private double feeFeeship;

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

	public Long getFeeId() {
		return feeId;
	}

	public void setFeeId(Long feeId) {
		this.feeId = feeId;
	}

	public CityJPA getCity() {
		return city;
	}

	public void setCity(CityJPA city) {
		this.city = city;
	}

	public DistrictJPA getDistrict() {
		return district;
	}

	public void setDistrict(DistrictJPA district) {
		this.district = district;
	}

	public WardJPA getWard() {
		return ward;
	}

	public void setWard(WardJPA ward) {
		this.ward = ward;
	}

	public double getFeeFeeship() {
		return feeFeeship;
	}

	public void setFeeFeeship(double feeFeeship) {
		this.feeFeeship = feeFeeship;
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
