package spring.mvc.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.service.admin.ImpCustomerJPAService;

@Controller
@RequestMapping("/admin/customers")
public class CustomerAdminController {
	
	@Autowired
	ImpCustomerJPAService impCustomerJPAService;
	
	@RequestMapping(value = "")
	public ModelAndView viewCustomers() {
		ModelAndView modelAndView = new ModelAndView("/admin/users/list_customers");
		modelAndView.addObject("customers", impCustomerJPAService.getCustomerJPAs());
		return modelAndView;
	}
	
	@RequestMapping(value = "/customer-detail")
	public ModelAndView viewCustomerDetail(@RequestParam("customerId") Long customerId) {
		ModelAndView mav = new ModelAndView("/admin/users/detail_customer");
		mav.addObject("customer", impCustomerJPAService.getCustomerJPA(customerId));
		return mav;
	}

	
}
