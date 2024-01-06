package spring.mvc.entity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_payment")
public class PaymentJPA {
	@Id
	@Column(name = "payment_id")
	private Long paymentId;

	@Column(name = "payment_method")
	private String paymentMethod;

	@Column(name = "payment_status")
	private int paymentStatus;
	
	@OneToOne(mappedBy = "payment", cascade = CascadeType.ALL)
	private OrderJPA order;

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public int getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(int paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public OrderJPA getOrder() {
		return order;
	}

	public void setOrder(OrderJPA order) {
		this.order = order;
	}
	
}
