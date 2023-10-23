package spring.mvc.service.user;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import spring.mvc.entity.CategoryJPA;
import spring.mvc.entity.CustomerJPA;
import spring.mvc.repositoryJpa.CustomerJPARepository;

public interface InterCustomerService {
	public CustomerJPA findCustomerJPA(String customerEmail, String customerPass);
//	public Page<CustomerJPA> getAllCustomers(Optional<Integer> p);
//	public CustomerJPA  findCustomerById(Long customerId);
//	public CustomerJPA  findByCustomerEmail(String customerEmail);
//	public CustomerJPA  findByCustomerPassword(String customerPassword);
	public CustomerJPA findCustomerExit(String email);
	public void registerCustomer(CustomerJPA customerJPA);

}
