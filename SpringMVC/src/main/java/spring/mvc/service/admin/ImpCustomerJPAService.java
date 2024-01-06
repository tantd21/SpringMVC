package spring.mvc.service.admin;

import java.util.List;

import spring.mvc.entity.CustomerJPA;

public interface ImpCustomerJPAService {
	public List<CustomerJPA> getCustomerJPAs();
	
	public CustomerJPA getCustomerJPA(Long customerId);
}
