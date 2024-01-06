package spring.mvc.controller.admin;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.entity.CategoryJPA;
import spring.mvc.service.admin.ImpCategoryJPAService;

@Controller
@RequestMapping("/admin")
@Secured({"ROLE_admin", "ROLE_manager"})
public class HomeAdminController {
	
	@RequestMapping(value = {"", "/"})
	public String Admin() {
		System.out.println("haha");
		Principal auth = (Principal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(auth != null) {
			return "redirect:/admin/home";		
		}else {
			return "redirect:/auth/admin-login";
		}
	}
	
	@RequestMapping(value = {"/home"})
	public ModelAndView viewAdmin() {
		ModelAndView modelAndView = new ModelAndView("/admin/home");
		return modelAndView;
	}
}
