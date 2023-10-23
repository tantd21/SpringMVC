package spring.mvc.controller.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.Until.Until;
import spring.mvc.entity.CustomerJPA;
import spring.mvc.model.Product;
import spring.mvc.repositoryJpa.CustomerJPARepository;
import spring.mvc.service.user.CustomerLoginService;
import spring.mvc.service.user.InterCustomerService;
import spring.mvc.service.user.InterDetailProductService;

@Controller
public class CustomerController {
	@Autowired
	InterCustomerService interCustomerService;

	@RequestMapping(value = "/dang-nhap")
	public ModelAndView loginPost() {
		ModelAndView mav = new ModelAndView("/web/login");
		return mav;
	}

	@RequestMapping(value = "/dang-ky")
	public ModelAndView registerPost() {
		ModelAndView mav = new ModelAndView("/web/register");
		return mav;
	}

	@RequestMapping(value = "/login")
	public String login(@RequestParam("customerEmail") String customerEmail,
			@RequestParam("customerPassword") String customerPass, HttpSession session) {
		CustomerJPA customer = interCustomerService.findCustomerJPA(customerEmail, customerPass);
		session.setMaxInactiveInterval(60 * 60);
		if (customer != null) {
			session.setAttribute("customer", customer);
			System.out.println("Đã có");
			return "redirect:/trang-chu";
		} else {
			System.out.println("huhuhu");
			return "redirect:/dang-nhap";
		}
	}

	@RequestMapping(value = "/register-customer", method = RequestMethod.POST)
	@ResponseBody
	public String register(@RequestParam("customerName") String customerName,
			@RequestParam("customerPhone") String customerPhone, @RequestParam("customerEmail") String customerEmail,
			@RequestParam("customerPass") String customerPassword,
			@RequestParam("customerPassConfirm") String customerPassword1) {
		String md5Password = Until.generateMD5(customerPassword1);
		if (!customerPassword.equals(customerPassword1)) {
			return "confirm";
		} else {
			CustomerJPA customerJPA = interCustomerService.findCustomerExit(customerEmail);
			if (customerJPA != null) {
				return "trung";
			} else {
				System.out.println("123");
				CustomerJPA customerJPA2 = new CustomerJPA();
				customerJPA2.setCustomerName(customerName);
				customerJPA2.setCustomerEmail(customerEmail);
				customerJPA2.setCustomerPhone(customerPhone);
				customerJPA2.setCustomerPassword(md5Password);	
				
				customerJPA2.setCustomerStatus(1+"");
				customerJPA2.setOrderBoom("0");
				customerJPA2.setTotalOrder(0+"");
				interCustomerService.registerCustomer(customerJPA2);
				return "success";
			}
		}
	}


	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		CustomerJPA customerJPA = new CustomerJPA();
		session.removeAttribute("customer");
		return "redirect:/trang-chu";
	}
}