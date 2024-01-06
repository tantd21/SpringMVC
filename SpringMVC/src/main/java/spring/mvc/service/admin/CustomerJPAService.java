package spring.mvc.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.mvc.entity.CustomerJPA;
import spring.mvc.repositoryJpa.CustomerJPARepository;

@Service
public class CustomerJPAService implements ImpCustomerJPAService {

	@Autowired
	CustomerJPARepository customerJPARepository;

	@Override
	public List<CustomerJPA> getCustomerJPAs() {
		return customerJPARepository.findAll();
	}

	@Override
	public CustomerJPA getCustomerJPA(Long customerId) {
		return customerJPARepository.findOne(customerId);
	}
}
