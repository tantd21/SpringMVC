package spring.mvc.service.user;

import spring.mvc.entity.CustomerJPA;

public interface LoginAndResgiterService {
	public CustomerJPA findCustomerJPALogin(String email, String pass);
	public CustomerJPA findCustomerExit(String email);
	public void registerCustomer(CustomerJPA customerJPA);
}
