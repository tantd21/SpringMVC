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

import spring.mvc.entity.OrderJPA;
import spring.mvc.service.admin.ImpOrderJPAService;

@Controller
@RequestMapping("/admin/orders")
public class OrderAdminController {
	@Autowired
	ImpOrderJPAService impOrderJPAService;
	
	@RequestMapping(value = "")
	public ModelAndView viewOrders(@RequestParam("p") Optional<Integer> p) {
		ModelAndView mav = new ModelAndView("/admin/orders/list_orders");
		mav.addObject("orders", impOrderJPAService.getAllOrders(p));
		return mav;
	}
	
	@RequestMapping("/add-order")
	public ModelAndView viewAddOrder() {
		return new ModelAndView("/admin/orders/add_order");
	}
	
	@RequestMapping("/edit-order")
	public ModelAndView viewEditCategory(@RequestParam("orderId") Long orderID) {
		ModelAndView mav = new ModelAndView("/admin/orders/edit_order");
		mav.addObject("order", impOrderJPAService.findOrderJPAById(orderID));
		return mav;
	}
	
	@PostMapping("/save-order")
	public String saveOrder(@ModelAttribute("order") OrderJPA orderJPA) {
		System.out.println("hahaha");
		impOrderJPAService.saveOrder(orderJPA);
		return "redirect:/admin/orders";
	}
	
	@PostMapping("/update-order")
	public String updateOrder(@ModelAttribute("order") OrderJPA orderJPA) {
		System.out.println("hahaha");
		impOrderJPAService.updateOrder(orderJPA);
		return "redirect:/admin/orders";
	}
	
	@DeleteMapping("/delete-order")
	@ResponseBody
	public String deleteOrder(@RequestParam("delete-id") Long deleteLong) {
		impOrderJPAService.deletedOrderJPA(deleteLong);
		return "Thành Công";	
	}
	
}
