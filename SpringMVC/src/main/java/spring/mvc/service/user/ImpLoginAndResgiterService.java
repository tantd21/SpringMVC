package spring.mvc.service.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.mvc.Until.Until;
import spring.mvc.entity.CustomerJPA;
import spring.mvc.repositoryJpa.CustomerJPARepository;
@Service
public class ImpLoginAndResgiterService implements LoginAndResgiterService {
	@Autowired
	CustomerJPARepository customerJPARepository;
	
	@Override
	public CustomerJPA findCustomerJPALogin(String email, String pass) {
		String pasString = Until.convertMD5(pass);
		System.out.println(pasString);
		CustomerJPA customerJPA = customerJPARepository.findCustomerLogin(email, pasString);
		if(customerJPA != null) {
			return customerJPA;
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
