package spring.mvc.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_quanhuyen")
public class DistrictJPA {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "maqh")
	Long maQh;
	
	@Column(name = "name_province")
	String nameProvince;
	
	@Column(name = "type")
	String type;

	@ManyToOne
	@JoinColumn(name = "matp")
	CityJPA city;
	
	@OneToMany(mappedBy = "district", cascade = CascadeType.ALL)
	List<WardJPA> wardJPAs;
	
	@OneToMany(mappedBy = "district", cascade = CascadeType.ALL)
	List<FeeJPA> fees;

	public Long getMaQh() {
		return maQh;
	}

	public void setMaQh(Long maQh) {
		this.maQh = maQh;
	}

	public String getNameProvince() {
		return nameProvince;
	}

	public void setNameProvince(String nameProvince) {
		this.nameProvince = nameProvince;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public CityJPA getCity() {
		return city;
	}

	public void setCity(CityJPA city) {
		this.city = city;
	}

	public List<WardJPA> getWardJPAs() {
		return wardJPAs;
	}

	public void setWardJPAs(List<WardJPA> wardJPAs) {
		this.wardJPAs = wardJPAs;
	}

	public List<FeeJPA> getFees() {
		return fees;
	}

	public void setFees(List<FeeJPA> fees) {
		this.fees = fees;
	}
}
