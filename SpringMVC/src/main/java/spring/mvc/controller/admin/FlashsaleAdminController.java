package spring.mvc.controller.admin;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.entity.FlashsaleJPA;
import spring.mvc.service.admin.ImpFlashsaleJPAService;
import spring.mvc.service.admin.ImpProductService;

@Controller
@RequestMapping("/admin/products/flashsales")
public class FlashsaleAdminController {
	@Autowired
	ImpFlashsaleJPAService impFlashsaleJPAService;
	@Autowired
	ImpProductService impProductService;
	@RequestMapping("")
	public ModelAndView viewListFlashsale(@RequestParam("p") Optional<Integer> p) {
		ModelAndView mav = new ModelAndView("/admin/flashsale/list_flashsale");
		mav.addObject("flashsales", impFlashsaleJPAService.getAllFlashsales(p));
		return mav;
	} 
	
	@RequestMapping("/edit-flashsale")
	public ModelAndView viewEditFlashsale(@RequestParam("flashsaleId") Long flashsaleLong) {
		ModelAndView mav = new ModelAndView("/admin/flashsale/edit_flashsale");
		mav.addObject("flashsale", impFlashsaleJPAService.findFlashsaleById(flashsaleLong));
		return mav;
	}
	@RequestMapping("/add-flashsale")
	public ModelAndView viewAddFlashsale() {
		ModelAndView mav = new ModelAndView("/admin/flashsale/add_flashsale");
		mav.addObject("products", impProductService.getProductNotInFlashsale());
		return mav;
	}
	
	@PostMapping("/save-flashsale")
	public String saveFlashsale(@ModelAttribute("flashsale") FlashsaleJPA flashsale, @RequestParam("productId") Long productId) {
		impFlashsaleJPAService.saveFlashsale(flashsale, productId);
		return "redirect:/admin/products/flashsales";
	}
	
	@PostMapping("/update-flashsale")
	public String updateFlashsale(@ModelAttribute("flashsale") FlashsaleJPA flashsaleJPA, @RequestParam("productId") Long prodLong, @RequestParam("productPrice") double productPrice) {
		impFlashsaleJPAService.updateFlashsale(flashsaleJPA, prodLong, productPrice);
		return "redirect:/admin/products/flashsales";
	}
	
	@DeleteMapping("/delete-flashsale")
	@ResponseBody
	public String deleteFlashsale(@RequestParam("flashsaleId") Long flashsaleId, @RequestParam("productId") Long productId) {
		impFlashsaleJPAService.deleteFlashsale(flashsaleId, productId);
		return "Thành Công";
	}
}
