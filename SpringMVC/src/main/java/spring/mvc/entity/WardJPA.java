package spring.mvc.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_xaphuongthitran")
public class WardJPA {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "xaid")
	Long xaid;
	
	@Column(name = "name_ward")
	String nameWard;
	
	@Column(name = "type")
	String type;
	
	@ManyToOne
	@JoinColumn(name = "maqh")
	DistrictJPA district;
	
	@OneToOne(mappedBy = "ward", cascade = CascadeType.ALL)
	FeeJPA fee;

	public Long getXaid() {
		return xaid;
	}

	public void setXaid(Long xaid) {
		this.xaid = xaid;
	}

	public String getNameWard() {
		return nameWard;
	}

	public void setNameWard(String nameWard) {
		this.nameWard = nameWard;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public DistrictJPA getDistrict() {
		return district;
	}

	public void setDistrict(DistrictJPA district) {
		this.district = district;
	}

	public FeeJPA getFee() {
		return fee;
	}

	public void setFee(FeeJPA fee) {
		this.fee = fee;
	}
}
