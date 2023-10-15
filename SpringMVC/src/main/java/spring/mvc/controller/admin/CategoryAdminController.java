package spring.mvc.controller.admin;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.entity.CategoryJPA;
import spring.mvc.service.admin.ImpCategoryJPAService;

@Controller
@RequestMapping("/admin/categorys")
public class CategoryAdminController {
	@Autowired
	ImpCategoryJPAService impCategoryJPAService;
	
	@RequestMapping(value = "")
	public ModelAndView viewCategorys(@RequestParam("p") Optional<Integer> p) {
		ModelAndView mav = new ModelAndView("/admin/categorys/list_categorys");
		mav.addObject("categorys", impCategoryJPAService.getAllCategorys(p));
		return mav;
	}
	
	@RequestMapping("/add-category")
	public ModelAndView viewAddCategory() {
		return new ModelAndView("/admin/categorys/add_category");
	}
	
	@RequestMapping("/edit-category")
	public ModelAndView viewEditCategory(@RequestParam("categoryId") Long cateLong) {
		ModelAndView mav = new ModelAndView("/admin/categorys/edit_category");
		mav.addObject("category", impCategoryJPAService.findCategoryJPAById(cateLong));
		return mav;
	}
	
	@PostMapping("/save-category")
	public String saveCategory(@ModelAttribute("category") CategoryJPA categoryJPA) {
		System.out.println("hahaha");
		impCategoryJPAService.saveCategory(categoryJPA);
		return "redirect:/admin/categorys";
	}
	
	@PostMapping("/update-category")
	public String updateCategory(@ModelAttribute("category") CategoryJPA categoryJPA) {
		System.out.println("hahaha");
		impCategoryJPAService.updateCategory(categoryJPA);
		return "redirect:/admin/categorys";
	}
	
	@DeleteMapping("/delete-category")
	@ResponseBody
	public String deleteCategory(@RequestParam("delete-id") Long deleteLong) {
		impCategoryJPAService.deletedCategoryJPA(deleteLong);
		return "Thành Công";	
	}
	
}
