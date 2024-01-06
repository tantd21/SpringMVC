package spring.mvc.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.entity.CouponJPA;
import spring.mvc.service.admin.CouponJPAService;

@Controller
@RequestMapping(value = "/admin/coupons")
public class CouponAdminController {
	@Autowired
	CouponJPAService couponJPAService;
	
	@RequestMapping(value = "")
	public ModelAndView viewListCoupon() {
		ModelAndView mav = new ModelAndView("/admin/coupons/list_coupons");
		mav.addObject("coupons", couponJPAService.getAllCouponJPAs());
		return mav;
	}
	
	@RequestMapping(value = "/add-coupon")
	public ModelAndView viewAddCoupon() {
		ModelAndView mav = new ModelAndView("/admin/coupons/add_coupon");
		return mav;
 	}
	
	@RequestMapping(value = "/edit-coupon")
	public ModelAndView viewEditCoupon(@RequestParam("couponId") Long id) {
		ModelAndView mav = new ModelAndView("/admin/coupons/edit_coupon");
		mav.addObject("coupon", couponJPAService.getCouponJPAById(id));
		return mav;
	}
	
	@PostMapping(value = "/update-coupon")
	public String updateCoupon(@ModelAttribute("coupon") CouponJPA coupon, HttpServletRequest request) {
		if(couponJPAService.saveCoupon(coupon)) {
			return "redirect:/admin/coupons";			
		}else {
			String referer = request.getHeader("Referer");
	        return "redirect:" + referer;
		}
	}
	
	@PostMapping(value = "/save-coupon")
	public String saveCoupon(@ModelAttribute("coupon") CouponJPA coupon, HttpServletRequest request) {
		if(couponJPAService.saveCoupon(coupon)) {
			return "redirect:/admin/coupons";			
		}else {
			String referer = request.getHeader("Referer");
	        return "redirect:" + referer;
		}
	}
	
	@DeleteMapping(value = "/delete-coupon")
	@ResponseBody
	public String deleteCoupon(@RequestParam("deleteId") Long deletedId) {
		couponJPAService.deleteCoupon(deletedId);
		return "Thành công";
	}
}
