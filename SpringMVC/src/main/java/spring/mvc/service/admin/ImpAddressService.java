package spring.mvc.service.admin;

import java.util.List;

import spring.mvc.entity.CityJPA;
import spring.mvc.entity.DistrictJPA;
import spring.mvc.entity.WardJPA;

public interface ImpAddressService {
	public CityJPA getCityJPAById(Long id);
	public DistrictJPA getDistrictJPAById(Long id);
	public WardJPA getWardJPAById(Long id);
	public List<CityJPA> getCityJPAs();
	public List<DistrictJPA> getDistrictJPAs(Long id);
	public List<WardJPA> getWardJPAs(Long id);
}
