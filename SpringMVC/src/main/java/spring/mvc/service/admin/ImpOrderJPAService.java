package spring.mvc.service.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import spring.mvc.entity.OrderJPA;

public interface ImpOrderJPAService {
    public List<OrderJPA> getAllOrderJPAs();
    public Page<OrderJPA> getAllOrderJPAs(Optional<Integer> p);
    public void saveOrder(OrderJPA orderJPA);
    public void updateOrder(OrderJPA orderJPA);
    public OrderJPA findOrderJPAById(Long orderId);
    public void deletedOrderJPA(Long orderId);
}
