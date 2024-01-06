package spring.mvc.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_tinhthanhpho")
public class CityJPA {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "matp")
	Long maTp;
	
	@Column(name = "name_city")
	String nameCity;
	
	@Column(name = "type")
	String type;
	
	@OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
	List<DistrictJPA> districtJPAs;
	
	@OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
	private List<FeeJPA> fees;

	public Long getMaTp() {
		return maTp;
	}

	public void setMaTp(Long maTp) {
		this.maTp = maTp;
	}

	public String getNameCity() {
		return nameCity;
	}

	public void setNameCity(String nameCity) {
		this.nameCity = nameCity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<DistrictJPA> getDistrictJPAs() {
		return districtJPAs;
	}

	public void setDistrictJPAs(List<DistrictJPA> districtJPAs) {
		this.districtJPAs = districtJPAs;
	}

	public List<FeeJPA> getFees() {
		return fees;
	}

	public void setFees(List<FeeJPA> fees) {
		this.fees = fees;
	}
	
}
