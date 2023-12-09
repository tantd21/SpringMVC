package spring.mvc.service.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import spring.mvc.entity.OrderJPA;
import spring.mvc.repositoryJpa.OrderJPARepository;
@Service
public class OrderJPAService implements ImpOrderJPAService{
	@Autowired
	private OrderJPARepository orderJPARepository; 
	@Override
	public List<OrderJPA> getAllOrderJPAs() {
		// TODO Auto-generated method stub
		return orderJPARepository.findAll();
	}
	
	public Page<OrderJPA> getAllOrders(Optional<Integer> p){
		PageRequest pageRequest = new PageRequest(p.orElse(0), 5);
		Pageable pageable = pageRequest;
		Page<OrderJPA> page = orderJPARepository.findAll(pageable);
		return page;
	}
	
	@Override
	public void saveOrder(OrderJPA orderJPA) {
		orderJPARepository.save(orderJPA);
	}
	
	@Override
	public void updateOrder(OrderJPA orderJPA) {
		orderJPARepository.save(orderJPA);
	}
	
	@Override
	public OrderJPA findOrderJPAById(Long orderID) {
		return orderJPARepository.findOne(orderID);
	}
	
	@Override
	public void deletedOrderJPA(Long orderID) {
		orderJPARepository.deleteOrderJPA(orderID);
	}



}
