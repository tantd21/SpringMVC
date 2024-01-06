<%@page import="spring.mvc.entity.CartEntity"%>
<%@page import="java.util.List"%>
<%@page import="spring.mvc.entity.ShippingJPA"%>
<%@page import="spring.mvc.entity.OrderJPA"%>
<%@page import="spring.mvc.entity.CouponJPA"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="spring.mvc.Until.Until"%>
<body>
	<link rel="stylesheet"
		href='<c:url value="/assets/web/css/bill.css" />'>
	<%
	CouponJPA coupon = (CouponJPA) session.getAttribute("coupon");
	OrderJPA order = (OrderJPA) session.getAttribute("order");
	ShippingJPA shipping = order.getShipping();
	List<CartEntity> cartList = (List<CartEntity>) session.getAttribute("cart");
	%>
	<div class="content">
		<div class="content-box">
			<div class="content-box-top"></div>
			<div class="content-box-bottom">
				<div class="content-box-bottom-img">
					<img width="70px" height="67px" style="object-fit: cover;"
						src="{{ asset('public/fontend/assets/img/thanhtoan/icon/check.png') }}"
						alt="">
				</div>
				<div class="content-box-bottom-title">
					<span>Đặt hàng thành công</span>
				</div>
				<div class="content-box-bottom-code">
					<span>Mã đơn hàng : </span>
				</div>
				<div class="content-box-bottom-text">
					<div class="content-box-bottom-text-one">
						<span>Đơn hàng của bạn đang chờ được phê duyệt !</span>
					</div>
					<%-- <div class="content-box-bottom-text-two">
						<c:if test="">
						
						</c:if>
						<span>Chúng tôi sẽ gửi thông tin về đơn hàng vào email <span
							style="color: #0fe22f; font-weight: bold;">{{
								$shipping['shipping_email'] }}</span></span>
					</div> --%>
					<div class="content-box-bottom-text-three">
						<span>Đơn hàng thường được xác nhận trong vòng 1h đến 2h.</span>
					</div>
				</div>
				<div class="content-box-bottom-bigbox">
					<div class="content-bottom-bigbox-box">
						<div class="content-bottom-bigbox-title">
							<span>Thông tin đơn hàng</span>
						</div>
						<c:forEach items="${ cartList }" var="cart">
							<div class="content-bottom-bigbox-infobank">
								<div style="width: 250px;"
									class="content-bottom-bigbox-infobank-left">
									<span>${ cart.productName }</span>
								</div>
								<div class="content-bottom-bigbox-infobank-left">
									<span>SL : ${ cart.productQuantity }</span>
								</div>
								<div class="content-bottom-bigbox-infobank-right">
									<span>${ Until.convertNumber(cart.productPrice) }</span>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>

			<div class="contentBox-Left-Bigcontent">

				<div class="inforom">
					<div class="inforom-box">
						<div class="inforom-layout">
							<div class="contentBox-Right-One-Box_Text">
								<div class="contentBox-Right-One-Box_Text-Title">
									<span>BonoDrinks Shop</span>
								</div>
								<div class="contentBox-Right-One-Box_Text-Content">
									<div class="contentBox-Right-One-Box_Text-Title-Item">
										<i class="fa-solid fa-star"></i> <i class="fa-solid fa-star"></i>
										<i class="fa-solid fa-star"></i> <i class="fa-solid fa-star"></i>
										<i class="fa-solid fa-star"></i>
									</div>

								</div>
								<div class="contentBox-Right-One-Box_Text-Content">
									<i class="fa-solid fa-location-pin"></i> <span
										style="margin-left: 4px;">KTX Phòng 210 Khu 2 Trường
										Việt Hàn</span>
								</div>
								<div class="contentBox-Right-One-Box_Text-Content">
									<span>Chilling Coffee And Tea</span>

								</div>
								<div class="contentBox-Right-One-Box_Text-Content">
									<span>Uy Tín - An Toàn - Chất Lượng</span>
								</div>

							</div>
							<div class="inforom-img">
								<img width="175px" height="128px"
									style="object-fit: cover; border-radius: 8px;"
									src="{{ asset('public/fontend/assets/iconlogo/logo1.png') }}"
									alt="">
							</div>
						</div>

						<div class="contentBox-Text-Bottom-Box">
							<div class="contentBox-Text-Bottom-Box-One">

								<div class="contentBox-Text-Bottom-Box-One-Box">
									<div class="contentBox-Text-Bottom-Box-One-Item">
										<span>Tổng giá tiền</span>
									</div>
									<div class="contentBox-Text-Bottom-Box-One-Item">
										<div class="contentBox-Text-Bottom-Box-One-Item-Top">

											<?php $price_all_product = filter_var(Cart::total(), FILTER_SANITIZE_NUMBER_FLOAT, FILTER_FLAG_ALLOW_FRACTION); ?>
											<span style="margin-left: 17px;">${ Until.convertNumber(order.totalPrice) }đ</span>

										</div>
									</div>
								</div>

								<div class="contentBox-Text-Bottom-Box-One-Box">
									<div class="contentBox-Text-Bottom-Box-One-Item">
										<span>Phí vận chuyển</span>
									</div>
									<div class="contentBox-Text-Bottom-Box-One-Item">
										<div class="contentBox-Text-Bottom-Box-One-Item-Top">
											@if (session()->get('fee') != null)
											<?php $fee = session()->get('fee');
                                                $fee_feeship = $fee['fee_feeship'];
                                                ?>
											<span style="margin-left: 17px;">{{ '+' .
												number_format($fee_feeship, 0, ',', '.') . 'đ' }}</span> @endif
										</div>
									</div>
								</div>
								@if (Session::get('coupon-cart') != null)
								<?php $coupon = session()->get('coupon-cart'); ?>
								<div class="contentBox-Text-Bottom-Box-One-Box">
									<div
										class="contentBox-Text-Bottom-Box-One-Item contentBox-Text-Bottom-Box-One-Item-Layout">
										<div class="contentBox-Text-Bottom-Box-One-Item-Layout-item">
											<span>Mã giảm giá</span>
										</div>
										<div
											class="contentBox-Text-Bottom-Box-One-Item-Layout-item-Sale">
											<span>{{ $coupon->coupon_name_code }}</span>
										</div>
									</div>
									<div class="contentBox-Text-Bottom-Box-One-Item">
										<div class="contentBox-Text-Bottom-Box-One-Item-Top">
											<?php
                                                
                                                $price_sale = 0;
                                                $coupon_condition = $coupon->coupon_condition;
                                                if ($coupon_condition == 1) {
                                                    $price_sale = ($price_all_product / 100) * $coupon->coupon_price_sale;
                                                } else {
                                                    $price_sale = $coupon->coupon_price_sale;
                                                }
                                                ?>
											<span style="color: #68c78f; margin-left: 17px;">{{
												'-' . number_format($price_sale, 0, ',', '.') . 'đ' }}</span>
										</div>
									</div>
								</div>
								@else
								<?php $price_sale = 0; ?>
								@endif

								<div class="Totalpayment">
									<div class="Totalpayment-left">
										<div class="Totalpayment-left-top">
											<span>Tổng tiền thanh toán</span>
										</div>
										<div class="Totalpayment-bottom">
											<span>Đã bao gồm thuế, phí, VAT</span>
										</div>
									</div>
									<div class="Totalpayment-right">
										<div class="Totalpayment-right-Top">
											<?php 
                                                if($price_all_product > $price_sale){
                                                    $totalpayment = $price_all_product + $fee_feeship - $price_sale; 
                                                }else{
                                                    $totalpayment = $fee_feeship;
                                                }
                                            ?>
											<span> {{ number_format($totalpayment, 0, ',', '.') .
												'đ' }}</span>
										</div>
									</div>
								</div>
								@if (session()->get('coupon-cart') != null)
								<div class="Content-end">
									<i class="fa-solid fa-money-bill"></i> <span
										style="margin-left: 5px;"> Chúc mừng! Bạn đã tiết kiệm
										được {{ number_format($price_sale, 0, ',', '.') . 'đ' }}</span>
								</div>
								@endif

							</div>
						</div>

					</div>
				</div>
				<div class="icon-bottom">
					<div class="icon-bottom-box">
						<i class="fa-solid fa-circle"></i> <i class="fa-solid fa-circle"></i>
						<i class="fa-solid fa-circle"></i> <i class="fa-solid fa-circle"></i>
						<i class="fa-solid fa-circle"></i> <i class="fa-solid fa-circle"></i>
						<i class="fa-solid fa-circle"></i> <i class="fa-solid fa-circle"></i>
						<i class="fa-solid fa-circle"></i> <i class="fa-solid fa-circle"></i>
						<i class="fa-solid fa-circle"></i> <i class="fa-solid fa-circle"></i>
						<i class="fa-solid fa-circle"></i> <i class="fa-solid fa-circle"></i>
						<i class="fa-solid fa-circle"></i> <i class="fa-solid fa-circle"></i>
						<i class="fa-solid fa-circle"></i> <i class="fa-solid fa-circle"></i>
						<i class="fa-solid fa-circle"></i> <i class="fa-solid fa-circle"></i>
						<i style="padding: 0;" class="fa-solid fa-circle"></i>
					</div>
				</div>
			</div>

		</div>
	</div>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"
		integrity="sha512-aVKKRRi/Q/YV+4mjoKBsE4x3H+BkegoM/em46NNlCqNTmUYADjBbeNefNxYV7giUp0VxICtqdrbqU7iVaeZNXA=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script>
        $(document).ready(function() {
            setTimeout(un_set_cart(), 10000);
            function un_set_cart() {
                $.ajax({
                    url: '{{ url('/thanh-toan/un-set-order') }}',
                    method: 'GET',
                    data: {},
                    success: function(data) {

                    },
                    error: function() {
                        alert("Bug Huhu :<<");
                    }
                })
            }
        });
    </script>
</body>
