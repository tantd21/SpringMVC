package spring.mvc.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.entity.ProductTypeJPA;
import spring.mvc.service.admin.ImpProductTypeJPAService;

@Controller 
@RequestMapping("/admin/product-types")
public class ProductTypeAdminController {
	
	@Autowired
	ImpProductTypeJPAService impProductTypeJPAService;
	
	@RequestMapping("")
	public ModelAndView viewListProductTypes() {
		ModelAndView mav = new ModelAndView("/admin/producttypes/list_product_types");
		mav.addObject("productTypes", impProductTypeJPAService.getAllProductTypeJPAs());
		return mav;
	}
	
	@RequestMapping("/add-product-type")
	public ModelAndView viewAddProductType() {
		return new ModelAndView("/admin/producttypes/add_product_type");
	}
	
	@RequestMapping("/edit-product-type")
	public ModelAndView viewEditProductType(@RequestParam("productTypeId") Long productTypeId) {
		ModelAndView mav = new ModelAndView("/admin/producttypes/edit_product_type");
		mav.addObject("productType", impProductTypeJPAService.findProductTypeJPAById(productTypeId));
		return mav;
	}
	
	@PostMapping("/save-product-type")
	public String saveProductType(@ModelAttribute("productType") ProductTypeJPA productTypeJPA) {
		impProductTypeJPAService.saveProductType(productTypeJPA);
		return "redirect:/admin/product-types";
	}
	
	@PostMapping("/update-product-type")
	public String updateProductType(@ModelAttribute("productType") ProductTypeJPA productTypeJPA) {
		impProductTypeJPAService.saveProductType(productTypeJPA);
		return "redirect:/admin/product-types";
	}
	
	@DeleteMapping("/deleted-product-type")
	@ResponseBody
	public String deleteProductType(@RequestParam("delete_id") Long id) {
		impProductTypeJPAService.deleteProductTypeJPA(id);
		return "Thành công";
	}
	
	@GetMapping("/un-active-product-type")
	@ResponseBody
	public String unActiveProductType(@RequestParam("productTypeId") Long productLong, @RequestParam("status") int status) {
		return impProductTypeJPAService.updateUnActiveProductType(productLong, status);
	}
}
