package spring.mvc.controller.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.Until.Until;
import spring.mvc.entity.CustomerJPA;
import spring.mvc.model.Product;
import spring.mvc.repositoryJpa.CustomerJPARepository;

@Controller

public class CustomerController {

	@RequestMapping(value = "/dang-nhap")
	public ModelAndView loginPost(@RequestParam("customerEmail") String customerEmail, @RequestParam("customerPassword") String customerPassword) {
        ModelAndView mav = new ModelAndView("/web/login");;
        CustomerJPA customer = new CustomerJPA();
        if (customer != null && customer.getCustomerEmail().equals(customerEmail) && customer.getCustomerPassword().equals(customerPassword)) {
            // Đăng nhập thành công, chuyển hướng tới trang welcome hoặc trang khác
//            mav = new ModelAndView("redirect:/welcome");
        } else {
            // Đăng nhập không thành công, quay trở lại trang đăng nhập
//            mav = new ModelAndView("redirect:/dang-nhap");
        }

        return mav;
    }
}