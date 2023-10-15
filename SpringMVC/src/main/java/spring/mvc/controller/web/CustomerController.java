package spring.mvc.controller.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.Until.Until;
import spring.mvc.model.Product;

@Controller

public class CustomerController {

	@RequestMapping(value = "/dang-nhap")
	public ModelAndView shopProduct() {
		ModelAndView mav = new ModelAndView("/web/login");
		List<Product> products = new ArrayList<>();
		products = Until.products;
		mav.addObject("products", products);
		
		return mav;
	}
}