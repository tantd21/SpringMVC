package spring.mvc.service.admin;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import spring.mvc.entity.OrderJPA;
import spring.mvc.entity.PaymentJPA;
import spring.mvc.entity.ShippingJPA;

public interface ImpOrderJPAService {
	List<OrderJPA> getOrderJPAs();
	OrderJPA getOrderJPAById(Long id);
	void deleteOrderJPAById(Long id);
	Page<OrderJPA> getOrderJPAsPagination(Pageable page);
	boolean editOrder(Long orderId, int orderStauts);
	void saveOrder(OrderJPA order);
	void saveShipping(ShippingJPA shipping);
	void savePayment(PaymentJPA payment);
	ShippingJPA getShippingFindId();
	PaymentJPA getPaymentFindId();
}
