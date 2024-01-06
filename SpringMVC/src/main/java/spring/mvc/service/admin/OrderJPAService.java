package spring.mvc.service.admin;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import spring.mvc.entity.CouponJPA;
import spring.mvc.entity.OrderJPA;
import spring.mvc.entity.PaymentJPA;
import spring.mvc.entity.ShippingJPA;
import spring.mvc.repositoryJpa.OrderJPARepository;
import spring.mvc.repositoryJpa.PaymentRepository;
import spring.mvc.repositoryJpa.ShippingJPARepository;

@Service
public class OrderJPAService implements ImpOrderJPAService {
	@Autowired
	OrderJPARepository orderJPARepository;
	@Autowired
	ShippingJPARepository shippingJPARepository;
	@Autowired
	PaymentRepository paymentRepository;
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Page<OrderJPA> getOrderJPAsPagination(Pageable pageable) {
		return orderJPARepository.findAll(pageable);
	}

	@Override
	public List<OrderJPA> getOrderJPAs() {
		// TODO Auto-generated method stub
		return orderJPARepository.findAll();
	}

	@Override
	public void deleteOrderJPAById(Long id) {
		// TODO Auto-generated method stub
		orderJPARepository.delete(id);
	}

	@Override
	public OrderJPA getOrderJPAById(Long id) {
		// TODO Auto-generated method stub
		return orderJPARepository.findOne(id);
	}

	@Override
	public boolean editOrder(Long orderId, int orderStatus) {
		OrderJPA orderJPA = orderJPARepository.findOne(orderId);
		orderJPA.setOrderStatus(orderStatus);
		if (orderStatus == 2) {
			PaymentJPA paymentJPA = orderJPA.getPayment();
			paymentJPA.setPaymentStatus(1);
			paymentRepository.save(paymentJPA);
		}
		return true;
	}

	@Override
	public void saveOrder(OrderJPA order) {
		orderJPARepository.save(order);
	}

	@Override
	public void saveShipping(ShippingJPA shipping) {
		shippingJPARepository.save(shipping);
	}

	@Override
	public void savePayment(PaymentJPA payment) {
		paymentRepository.save(payment);
	}

	@Override
	public ShippingJPA getShippingFindId() {
		return entityManager.createQuery("SELECT shipping FROM ShippingJPA shipping ORDER BY shipping.shippingId DESC",
				ShippingJPA.class).setMaxResults(1).getSingleResult();
	}

	@Override
	public PaymentJPA getPaymentFindId() {
		return entityManager.createQuery("SELECT payment FROM PaymentJPA payment ORDER BY payment.paymentId DESC",
				PaymentJPA.class).setMaxResults(1).getSingleResult();
	}
}
