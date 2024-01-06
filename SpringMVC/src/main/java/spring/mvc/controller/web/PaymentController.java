package spring.mvc.controller.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.entity.OrderJPA;
import spring.mvc.entity.PaymentJPA;
import spring.mvc.entity.ShippingJPA;
import spring.mvc.service.admin.ImpOrderJPAService;

@Controller
@RequestMapping("/thanh-toan")
public class PaymentController {
	@Autowired
	ImpOrderJPAService orderJPAService;
	
	@RequestMapping("")
	public ModelAndView goViewThanhToan(HttpSession session, @RequestParam("shippingName") String shippingName,
			@RequestParam("shippingEmail") String shippingEmail, @RequestParam("shippingPhone") String shippingPhone,
			@RequestParam("shippingAddress") String shippingAddress) {
		ModelAndView mav = new ModelAndView("/web/check_payment");
		ShippingJPA shipping = new ShippingJPA();
		shipping.setShippingName(shippingName);
		shipping.setShippingAddress(shippingAddress);
		shipping.setShippingEmail(shippingEmail);
		shipping.setShippingPhone(shippingPhone);
		OrderJPA order = (OrderJPA) session.getAttribute("order");
		order.setShipping(shipping);
		session.setAttribute("order", order);
		return mav;
	}
	
	
	@RequestMapping("/update-notes")
	public String updateNotes(@RequestParam("contentNote") String content, HttpSession session){
		OrderJPA order = (OrderJPA) session.getAttribute("order");
		ShippingJPA shippingJPA = order.getShipping();
		shippingJPA.setShippingNotes(content);
		order.setShipping(shippingJPA);
		session.setAttribute("order", order);
		return "Thành công";
	}
	
	@RequestMapping("/payment-thuong")
	public ModelAndView goViewPaymentThuong(HttpSession session) {
		ModelAndView mav = new ModelAndView("/web/hoadon");
		PaymentJPA payment = new PaymentJPA();
		payment.setPaymentMethod("4");
		payment.setPaymentStatus(0);
		orderJPAService.savePayment(payment);
		OrderJPA order = (OrderJPA) session.getAttribute("order");
		ShippingJPA shipping = order.getShipping();
		orderJPAService.saveShipping(shipping);
		ShippingJPA shipping_new = orderJPAService.getShippingFindId();
		PaymentJPA payment_new = orderJPAService.getPaymentFindId();
		order.setShipping(shipping_new);
		order.setPayment(payment_new);
		orderJPAService.saveOrder(order);
		return mav;
	}
	
	@RequestMapping("/")
	@ResponseBody
	public String unSetSession(HttpSession session) {
		session.removeAttribute("order");
		session.removeAttribute("cart");
		session.removeAttribute("fee");
		session.removeAttribute("coupon");
		return "Thành Công";
	}
	
}
