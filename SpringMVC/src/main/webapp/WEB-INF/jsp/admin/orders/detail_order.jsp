<%@page import="spring.mvc.entity.OrderJPA"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="spring.mvc.Until.Until"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<body>
	<div class="page-header">
		<h3 class="page-title">
			<span class="page-title-icon bg-gradient-primary text-white me-2">
				<i class="mdi mdi-clipboard-outline"></i>
			</span> Quản Lý Đơn Hàng
		</h3>
		<nav aria-label="breadcrumb">
			<ul class="breadcrumb">
				<li class="breadcrumb-item active" aria-current="page"><i
					class="mdi mdi-clipboard-outline"></i> <span> <?php
                    $today = date('d/m/Y');
                    echo $today;
                    ?>
				</span></li>
			</ul>
		</nav>
	</div>


	<?php
    $mesage = Session::get('mesage');
    if ($mesage) {
        echo $mesage;
        Session::put('mesage', null);
    }
    ?>

	<div class="col-lg-12 grid-margin stretch-card">
		<div class="card">
			<div class="card-body">
				<div style="display: flex; justify-content: space-between">
					<div class="card-title col-sm-9">Thông Tin Khách Hàng Đăng
						Nhập</div>
					<div class="col-sm-3"></div>
				</div>
				<c:choose>
					<c:when test="${ order.customer != null }">
						<table style="margin-top: 20px" class="table table-bordered">
							<thead>
								<tr>
									<th>Tên Khách Hàng</th>
									<th>Số Điện Thoại</th>
									<th>Email Khách Hàng</th>
								</tr>
							</thead>
							<tbody>
								<td>${ order.customer.customerName }</td>
								<td>${ order.customer.customerPhone }</td>
								<td>${ order.customer.customerEmail }</td>
							</tbody>

						</table>
					</c:when>
					<c:otherwise>
						<h6>Không Có Thông Tin - Khách Hàng Đặt Hàng Trực Tiếp Trên
							Hệ Thống Không Thông Qua Đăng Nhập !</h6>
					</c:otherwise>
				</c:choose>

			</div>
		</div>
	</div>

	<div class="col-lg-12 grid-margin stretch-card">
		<div class="card">
			<div class="card-body">
				<div style="display: flex; justify-content: space-between">
					<div class="card-title col-sm-9">Thông Tin Người Đặt Hàng</div>
					<div class="col-sm-3"></div>
				</div>
				<table style="margin-top: 20px" class="table table-bordered">

					<tr>
						<th>Tên Người Đặt Hàng</th>
						<td>${ order.shipping.shippingName }</td>
					</tr>

					<tr>
						<th>Số Điện Thoại</th>
						<td>${ order.shipping.shippingPhone }</td>
					</tr>

					<tr>
						<th>Email</th>
						<td>${ order.shipping.shippingEmail }</td>
					</tr>

					<tr>
						<th>Địa Chỉ</th>
						<td>${ order.shipping.shippingAddress }</td>
					</tr>

					<tr>
						<th>Ghi Chú</th>
						<td>${ order.shipping.shippingNotes }</td>
					</tr>
					<!-- 
					<tr>
						<th>Yêu Cầu Đặc Biệt</th>
						<td>@if ($shipping->shipping_special_requirements == 0) {{
							'Không' }} @elseif($shipping->shipping_special_requirements == 1)
							{{ 'Bỏ đá riêng' }} @endif</td>
					</tr> -->

					<tr>
						<th>Phương thức thanh toán</th>
						<td><c:choose>
								<c:when test="${ order.payment.paymentMethod == 4 }">
									<span class="text-success">Tiền mặt</span>
								</c:when>
								<c:otherwise>
									<span class="text-danger">Chuyển khoản</span>
								</c:otherwise>
							</c:choose></td>
					</tr>
					<tr>
						<th>Tình trạng</th>
						<td><c:choose>
								<c:when test="${ order.orderStatus == 0 }">
									<span class="text-info"><b>Đang chờ duyệt <i
											class="mdi mdi-camera-party-mode"></i></b></span>
								</c:when>
								<c:when test="${ order.orderStatus == -1 }">
									<span class="text-danger"><b>Đã từ chối đơn hàng <i
											class="mdi mdi-calendar-remove"></i>
									</b></span>
								</c:when>
								<c:when test="${ order.orderStatus == 1 }">
									<span class="text-warning"><b>Đang vận chuyển <i
											class="mdi mdi-car"></i></b></span>
								</c:when>
								<c:when test="${ order.orderStatus == 3 }">
									<span class="text-danger"><b>Đơn hàng Từ Chối <i
											class="mdi mdi-calendar-remove"></i></b></span>
								</c:when>
								<c:otherwise>
									<span class="text-success"><b>Hoàn thành <i
											class="mdi mdi-calendar-check"></i></b></span>
								</c:otherwise>
							</c:choose></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
	<div class="col-lg-12 grid-margin stretch-card">
		<div class="card">
			<div class="card-body">
				<div style="display: flex; justify-content: space-between">
					<div class="card-title col-sm-9">Chi Tiết Đơn Hàng</div>
					<div class="col-sm-3"></div>
				</div>
				<table style="margin-top: 20px" class="table table-bordered">
					<thead>
						<tr>
							<th>Tên Sản Phẩm</th>
							<th>Số Lượng</th>
							<th>Giá</th>
							<th>Tổng Tiền</th>
						</tr>
					</thead>
					<tbody>
						<c:set var="totalPrice" value="0" />
						<c:forEach items="${ order.orderDetails }" var="orderDetail">
							<c:set var="productTotalPrice"
								value="${orderDetail.productPrice * orderDetail.productSalesQuantity}" />
							<c:set var="totalPrice" value="${totalPrice + productTotalPrice}" />
							<tr>
								<td>${ orderDetail.productName }</td>
								<td>${ orderDetail.productSalesQuantity }</td>
								<td>${ Until.convertNumber(orderDetail.productPrice) }đ</td>
								<td>${ Until.convertNumber(orderDetail.productPrice * orderDetail.productSalesQuantity) }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<c:choose>
					<c:when test="${ order.couponSale > 100 }">
						<c:set var="priceCoupon" value="${ order.couponSale  }" />
					</c:when>
					<c:otherwise>
						<c:set var="priceCoupon"
							value="${ totalPrice * order.couponSale / 100 }" />
					</c:otherwise>
				</c:choose>

				<div style="margin-top: 40px">
					<table class="table table-bordered">
						<tr>
							<th>Tổng tiền</th>
							<td>${ Until.convertNumber(totalPrice) }</td>
						</tr>
						<tr>
							<th>Phí Ship</th>
							<td>+ ${ Until.convertNumber(order.productFee) }</td>
						</tr>
						<c:if test="${ order.couponSale != 0 }">
							<tr style="color: red">
								<th>Mã Giảm Giá</th>
								<td>${ order.productCoupon }-<c:choose>
										<c:when test="${ order.couponSale > 100 }">
											${ order.couponSale }đ
										</c:when>
										<c:otherwise>
											${ order.couponSale }%
										</c:otherwise>
									</c:choose>
								</td>
							</tr>
							<tr>
								<th>Số Tiền Giảm</th>
								<td>- ${ priceCoupon }đ</td>
							</tr>
						</c:if>
						<tr>
							<th>Tổng tiền</th>
							<td>${ order.totalPrice }đ</td>
						</tr>
					</table>
				</div>

			</div>
		</div>
	</div>
	<div>
		<div class="template-demo">
			<a target="_blank" style="text-decoration: none"
				href="{{ url('admin/order-manager/print-order?checkout_code=' . $orderdetails->order_code) }}">
				<button type="button" class="btn-lg btn-gradient-info btn-icon-text">
					Xuất Hóa Đơn PDF <i class="mdi mdi-printer btn-icon-append"></i>
				</button>
			</a> {{-- <a style="text-decoration: none" href="">
				<button type="button" class="btn btn-gradient-danger btn-icon-text">
					<i class="mdi mdi-upload btn-icon-prepend"></i> Upload
				</button>
			</a> --}} {{-- <a style="text-decoration: none" href="">
				<button type="button" class="btn btn-gradient-warning btn-icon-text">
					<i class="mdi mdi-reload btn-icon-prepend"></i> Reset
				</button>
			</a> --}}


		</div>
		{{-- @if($order->order_status == 0)
		<button style="margin-top: 10px"
			class="btn btn-gradient-success btn-fw btn-order-status"
			data-order_code="'.$order->order_code.'" data-order_status="1">
			Duyệt Đơn <i class="mdi mdi-calendar-check"></i>
		</button>
		<button style="margin-top: 10px"
			class="btn btn-gradient-danger btn-fw btn-order-status"
			data-order_code="'.$order->order_code.'" data-order_status="-1">
			Từ Chối <i class="mdi mdi-calendar-remove"></i>
		</button>
		@elseif($order->order_status == -1 || $order->order_status == 2 ||
		$order->order_status == 3 )
		<button style="margin-top: 10px"
			class="btn-sm btn-gradient-dark btn-rounded btn-fw btn-delete-order"
			data-toggle="modal" data-target="#order"
			data-order_id="'.$order->order_id.'">
			Xóa Đơn <i class="mdi mdi-delete-sweep"></i>
		</button>
		<br> @elseif($order->order_status == 1)
		<button style="margin-top: 10px"
			class="btn-sm btn-gradient-success btn-order-status"
			data-order_code="'.$order->order_code.'" data-order_status="2">
			Hoàn Thành <i class="mdi mdi-calendar-check"></i>
		</button>
		<button style="margin-top: 10px"
			class="btn-sm btn-gradient-danger btn-fw btn-order-status"
			data-order_code="'.$order->order_code.'" data-order_status="3">
			Hoàn Trả <i class="mdi mdi-calendar-remove"></i>
		</button>
		<br> @endif --}}
	</div>
</body>
