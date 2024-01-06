package spring.mvc.controller.admin;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.Until.Until;
import spring.mvc.entity.OrderDetailJPA;
import spring.mvc.entity.OrderJPA;
import spring.mvc.entity.ProductJPA;
import spring.mvc.service.admin.ImpOrderJPAService;

@Controller
@RequestMapping(value = "/admin/orders")
public class OrderAdminController {

	@Autowired
	ImpOrderJPAService impOrderJPAService;

	@RequestMapping(value = "")
	public ModelAndView viewListOrders(@RequestParam("p") Optional<Integer> p) {
		ModelAndView mav = new ModelAndView("/admin/orders/list_orders");
//		Sort sort = Sort.by(Sort.Order.desc("orderId"));
		PageRequest pageRequest = new PageRequest(p.orElse(0), 6, new Sort(Direction.DESC, "orderId"));
		Pageable pageable = pageRequest;
		Page<OrderJPA> page = impOrderJPAService.getOrderJPAsPagination(pageable);
		mav.addObject("orders", page);
		return mav;
	}

	@RequestMapping(value = "/order-detail")
	public ModelAndView viewOrderDetail(@RequestParam("orderId") Long orderId) {
		ModelAndView mav = new ModelAndView("/admin/orders/detail_order");
		mav.addObject("order", impOrderJPAService.getOrderJPAById(orderId));
		return mav;
	}

	@RequestMapping(value = "/edit-order")
	@ResponseBody
	public String editOrder(@RequestParam("orderId") Long orderId, @RequestParam("order_status") int orderStatus) {
		if (impOrderJPAService.editOrder(orderId, orderStatus)) {
			return printOrderById(impOrderJPAService.getOrderJPAById(orderId));
		}else {
			return "error";			
		}
	}

	public String printOrderById(OrderJPA orderJPA) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("<td>" + orderJPA.getOrderId() + "</td>\r\n" + "<td>");
		for (OrderDetailJPA orderDetailJPA : orderJPA.getOrderDetails()) {
			stringBuilder.append("<img style=\"object-fit: cover;\" width=\"30px\" height=\"30px\"\r\n"
					+ "src='<c:url value=\"/assets/web/img/product/" + orderDetailJPA.getProduct().getProductImage()
					+ "\"/>' />");
		}
		stringBuilder.append("</td> <td>" + Until.convertNumber(orderJPA.getTotalPrice()) + "đ</td>");
		if (orderJPA.getPayment().getPaymentStatus() == 1) {
			stringBuilder.append("<td><span class=\"text-success\">Đã thanh toán</span></td>");
		} else {
			stringBuilder.append("<td><span class=\"text-danger\">Chưa thanh toán</span></td>");
		}
		stringBuilder.append("<td>");
		if (orderJPA.getOrderStatus() == 1) {
			stringBuilder.append("<span class=\"text-danger\"><b>Đã từ chối đơn hàng <i\r\n"
					+ "class=\"mdi mdi-calendar-remove\"></i>\r\n" + "</b></span>");
		} else if (orderJPA.getOrderStatus() == -1) {
			stringBuilder.append("<span class=\"text-danger\"><b>Đã từ chối đơn hàng <i\r\n"
					+ "class=\"mdi mdi-calendar-remove\"></i>\r\n" + "</b></span>");
		} else if (orderJPA.getOrderStatus() == 1) {
			stringBuilder.append("<span class=\"text-warning\"><b>Đang vận chuyển <i\r\n"
					+ "													class=\"mdi mdi-car\"></i></b></span>");
		} else if (orderJPA.getOrderStatus() == 3) {
			stringBuilder.append("<span class=\"text-danger\"><b>Đơn hàng Từ Chối <i\r\n"
					+ "													class=\"mdi mdi-calendar-remove\"></i></b></span>");
		} else {
			stringBuilder.append("<span class=\"text-success\"><b>Hoàn thành <i\r\n"
					+ "													class=\"mdi mdi-calendar-check\"></i></b></span>");
		}
		stringBuilder.append("</td> <td>" + orderJPA.getCreatedAt() + "</td>");
		stringBuilder.append("<td>");
		if (orderJPA.getOrderStatus() == 1) {
			stringBuilder.append("<button style=\"margin-top: 10px\"\r\n"
					+ "												class=\"btn-sm btn-gradient-success btn-order-status\"\r\n"
					+ "												data-order_code=\"${ order.orderId }\" data-order_status=\"2\">\r\n"
					+ "												Hoàn Thành <i class=\"mdi mdi-calendar-check\"></i>\r\n"
					+ "											</button>\r\n"
					+ "											<br>\r\n"
					+ "											<button style=\"margin-top: 10px\"\r\n"
					+ "												class=\"btn-sm btn-gradient-danger btn-fw btn-order-status\"\r\n"
					+ "												data-order_code=\"${ order.orderId }\" data-order_status=\"3\">\r\n"
					+ "												Hoàn Trả <i class=\"mdi mdi-calendar-remove\"></i>\r\n"
					+ "											</button>");
		} else if (orderJPA.getOrderStatus() == 4) {
			stringBuilder.append("<button style=\"margin-top: 10px\"\r\n"
					+ "												class=\"btn-sm btn-gradient-success btn-order-status\"\r\n"
					+ "												data-order_code=\"${ order.orderId }\" data-order_status=\"2\">\r\n"
					+ "												Xem đánh giá <i class=\"mdi mdi-calendar-check\"></i>\r\n"
					+ "											</button>");
		}
		stringBuilder.append("<a\r\n"
				+ "									href=\"/SpringMVC/admin/orders/order-detail?orderId=${ order.orderId }\"><button\r\n"
				+ "											style=\"margin-top: 10px\"\r\n"
				+ "											class=\"btn-sm btn-gradient-info btn-rounded btn-fw\">\r\n"
				+ "											Xem Đơn <i class=\"mdi mdi-eye\"></i>\r\n"
				+ "										</button></a> <br></td>");

		return stringBuilder.toString();
	}
}
