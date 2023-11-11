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

import spring.mvc.entity.CouponJPA;
import spring.mvc.service.admin.ImpCouponJPAService;

@Controller
@RequestMapping("/admin/coupons")
public class CouponAdminController {
	@Autowired
	ImpCouponJPAService impCouponJPAService;
	
	@RequestMapping(value = "")
	public ModelAndView viewCoupons(@RequestParam("p") Optional<Integer> p) {
		ModelAndView mav = new ModelAndView("/admin/coupons/list_coupons");
		mav.addObject("coupons", impCouponJPAService.getAllCoupons(p));
		return mav;
	}
	
	@RequestMapping("/add-coupon")
	public ModelAndView viewAddCoupon() {
		return new ModelAndView("/admin/coupons/add_coupon");
	}
	
	@RequestMapping("/edit-coupon")
	public ModelAndView viewEditCoupon(@RequestParam("couponId") Long cateLong) {
		ModelAndView mav = new ModelAndView("/admin/coupons/edit_coupon");
		mav.addObject("coupon", impCouponJPAService.findCouponJPAById(cateLong));
		return mav;
	}
	
	@PostMapping("/save-coupon")
	public String saveCoupon(@ModelAttribute("coupon") CouponJPA couponJPA) {
		System.out.println("hahaha");
		impCouponJPAService.saveCoupon(couponJPA);
		return "redirect:/admin/coupons";
	}
	
	@PostMapping("/update-coupon")
	public String updateCoupon(@ModelAttribute("coupon") CouponJPA couponJPA) {
		System.out.println("hahaha");
		impCouponJPAService.updateCoupon(couponJPA);
		return "redirect:/admin/coupons";
	}
	
	@DeleteMapping("/delete-coupon")
	@ResponseBody
	public String deleteCoupon(@RequestParam("delete-id") Long deleteLong) {
		impCouponJPAService.deletedCouponJPA(deleteLong);
		return "Thành Công";	
	}
	
}
