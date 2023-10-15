package spring.mvc.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.entity.CategoryJPA;
import spring.mvc.service.admin.ImpCategoryJPAService;

@Controller
@RequestMapping("/admin")
public class HomeAdminController {
	
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ModelAndView Admin() {
		ModelAndView modelAndView = new ModelAndView("/admin/home");
		return modelAndView;
	}
	
	
}
