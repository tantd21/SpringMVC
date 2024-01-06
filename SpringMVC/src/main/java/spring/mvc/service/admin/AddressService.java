package spring.mvc.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.mvc.entity.CityJPA;
import spring.mvc.entity.DistrictJPA;
import spring.mvc.entity.WardJPA;
import spring.mvc.repositoryJpa.CityJPARepository;
import spring.mvc.repositoryJpa.DistrictJPARepository;
import spring.mvc.repositoryJpa.WardRepository;
@Service
public class AddressService implements ImpAddressService{
	@Autowired
	CityJPARepository cityJPARepository;
	@Autowired
	DistrictJPARepository districtJPARepository;
	@Autowired
	WardRepository wardRepository;
	@Override
	public CityJPA getCityJPAById(Long id) {
		// TODO Auto-generated method stub
		return cityJPARepository.findOne(id);
	}

	@Override
	public DistrictJPA getDistrictJPAById(Long id) {
		// TODO Auto-generated method stub
		return districtJPARepository.findOne(id);
	}

	@Override
	public WardJPA getWardJPAById(Long id) {
		// TODO Auto-generated method stub
		return wardRepository.findOne(id);
	}

	@Override
	public List<CityJPA> getCityJPAs() {
		// TODO Auto-generated method stub
		return cityJPARepository.findAll();
	}

	@Override
	public List<DistrictJPA> getDistrictJPAs(Long id) {
		// TODO Auto-generated method stub
		return districtJPARepository.getDistrictFromCity(id);
	}

	@Override
	public List<WardJPA> getWardJPAs(Long id) {
		// TODO Auto-generated method stub
		return wardRepository.getWardFromDistrict(id);
	}

}
