package spring.mvc.service.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import spring.mvc.Until.Until;
import spring.mvc.entity.CustomerJPA;
import spring.mvc.entity.FlashsaleJPA;
import spring.mvc.repositoryJpa.CustomerJPARepository;
@Service
public class CustomerLoginService implements InterCustomerService{
	@Autowired
	private CustomerJPARepository customerJPARepository; 

	@Override
	public CustomerJPA findCustomerJPA(String customerEmail, String customerPass) {
		String pass = Until.generateMD5(customerPass);
		CustomerJPA customer = customerJPARepository.findCustomerLogin(customerEmail, pass);
		if(customer != null) {
			return customer;
		}
		return null;
	}
	@Override
	public CustomerJPA findCustomerExit(String email) {
		return customerJPARepository.findCustomerIsExist(email);
	}

	@Override
	public void registerCustomer(CustomerJPA customerJPA) {
		customerJPARepository.save(customerJPA);
	}
	
}
