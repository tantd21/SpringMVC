<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="spring.mvc.Until.Until"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
					<div class="card-title col-sm-4">Bảng Danh Sách Đơn Hàng</div>
					<div class="col-sm-3">
						<div class="input-group">
							<select name="" id="filter" class="btn btn-outline-secondary">
								<option class="btn btn-outline-secondary" value="">Bộ
									lọc</option>
								<option class="btn btn-outline-secondary" value="1">Đã
									Duyệt</option>
								<option class="btn btn-outline-secondary" value="0">Chờ
									Duyệt</option>
								<option class="btn btn-outline-secondary" value="-1">Đã
									Từ Chối</option>
								<option class="btn btn-outline-secondary" value="2">Hoàn
									Thành</option>
								<option class="btn btn-outline-secondary" value="3">Hoàn
									Trả</option>
							</select>
						</div>
					</div>
					<div class="col-sm-2">
						<div class="input-group">
							<input type="text" class="form-control" name="searchbyname"
								placeholder="Tìm Mã Đơn Hàng">
						</div>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<a style="text-decoration: none"
								href="{{ URL::to('admin/order-manager/trash-order') }}">
								<button type="button" class="btn btn-outline-secondary">
									Thùng Rác {{-- ( {{ $countDelete }} ) --}} <span
										class="count-delete" style="color: red; font-weight: 700"></span>
								</button>
							</a>
						</div>
					</div>
				</div>
				<table style="margin-top: 20px" class="table table-bordered">
					<thead>
						<tr>
							<th>#ID Đơn Hàng</th>
							<th>Sản phẩm</th>
							<th>Tổng tiền</th>
							<!-- <th>Hình thức</th> -->
							<th>Thanh toán</th>
							<th>Trạng thái</th>
							<th>Ngày đặt đơn</th>
							<th>Thao Tác</th>
						</tr>
					</thead>
					<tbody id="loading-order-manager">
						<c:forEach items="${ orders.content }" var="order">
							<tr id="order${ order.orderId }">
								<td>${ order.orderCode }</td>
								<td><c:forEach items="${ order.orderDetails }"
										var="orderDetail">
										<img style="object-fit: cover;" width="30px" height="30px"
											src='<c:url value="/assets/web/img/product/${ orderDetail.product.productImage }"/>' />
									</c:forEach></td>
								<td>${ Until.convertNumber(order.totalPrice) }đ</td>
								<%-- <td><c:choose>
										<c:when test="${ order.payment.paymentMethod == 4 }">
											Tiền mặt
										</c:when>
										<c:otherwise>
											Chuyển khoản
										</c:otherwise>
									</c:choose></td> --%>
								<td><c:choose>
										<c:when test="${ order.payment.paymentStatus == 1 }">
											<span class="text-success">Đã thanh toán</span>
										</c:when>
										<c:otherwise>
											<span class="text-danger">Chưa thanh toán</span>
										</c:otherwise>
									</c:choose></td>
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
								<td>${ order.createdAt }</td>
								<td><c:choose>
										<c:when test="${ order.orderStatus == 0 }">
											<button style="margin-top: 10px"
												class="btn-sm btn-gradient-success btn-rounded btn-fw btn-order-status"
												data-order_code="${ order.orderId }" data-order_status="1">
												Duyệt Đơn <i class="mdi mdi-calendar-check"></i>
											</button>
											<br>
											<button style="margin-top: 10px"
												class="btn-sm btn-gradient-danger btn-fw btn-order-status"
												data-order_code="${ order.orderId }" data-order_status="-1">
												Từ Chối <i class="mdi mdi-calendar-remove"></i>
											</button>
											<br>
										</c:when>
										<c:when test="${ order.orderStatus == 1 }">
											<button style="margin-top: 10px"
												class="btn-sm btn-gradient-success btn-order-status"
												data-order_code="${ order.orderId }" data-order_status="2">
												Hoàn Thành <i class="mdi mdi-calendar-check"></i>
											</button>
											<br>
											<button style="margin-top: 10px"
												class="btn-sm btn-gradient-danger btn-fw btn-order-status"
												data-order_code="${ order.orderId }" data-order_status="3">
												Hoàn Trả <i class="mdi mdi-calendar-remove"></i>
											</button>
											<br>
										</c:when>
										<c:when test="${ order.orderStatus == 4 }">
											<button style="margin-top: 10px"
												class="btn-sm btn-gradient-success btn-order-status"
												data-order_code="${ order.orderId }" data-order_status="2">
												Xem đánh giá <i class="mdi mdi-calendar-check"></i>
											</button>
											<br>
										</c:when>
									</c:choose> <a
									href="/SpringMVC/admin/orders/order-detail?orderId=${ order.orderId }"><button
											style="margin-top: 10px"
											class="btn-sm btn-gradient-info btn-rounded btn-fw">
											Xem Đơn <i class="mdi mdi-eye"></i>
										</button></a> <br></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<nav aria-label="Page navigation example">
		<ul class="pagination">
			<c:if test="${ orders.number != 0 }">
				<li class="page-item"><a class="page-link"
					href="/SpringMVC/admin/orders?p=${ orders.number - 1 }">Previous</a></li>
			</c:if>
			<c:forEach begin="0" end="${ orders.totalPages - 1 }" var="number">
				<c:choose>
					<c:when test="${ number == orders.number }">
						<li class="page-item active" value="${ number }"><a
							class="page-link" href="/SpringMVC/admin/orders?p=${ number }">${ number + 1 }</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item" value="${ number }"><a
							class="page-link" href="/SpringMVC/admin/orders?p=${ number }">${ number + 1 }</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${ orders.number < orders.totalPages - 1 }">
				<li class="page-item"><a class="page-link"
					href="/SpringMVC/admin/orders?p=${ orders.number + 1 }">Next</a></li>
			</c:if>
		</ul>
	</nav>

	<div class="modal fade" id="order" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Thông báo</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">Bạn có chắc chắn muốn xóa đơn hàng này
					không?</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary "
						data-dismiss="modal">Cancel</button>
					<button type="button"
						class="btn btn-primary btn-danger btn_deleted"
						data-dismiss="modal">Xóa</button>
				</div>
			</div>
		</div>
	</div>

	<script>
	$(document).on('click', '.btn-order-status', function() {
	    var order_Id = $(this).data('order_code');
	    var order_status = $(this).data('order_status');
	 	alert(order_Id);
	    $.ajax({
	        url: '/SpringMVC/admin/orders/edit-order?orderId=' + order_Id + '&order_status=' + order_status,
	        method: 'post',
	        data: {
	        },
	        success: function(data) {
	        	if(data == "error"){
	        		message_toastr("error", "Đã xảy ra sự cố!");
	        	}else{
	        		$('#order' + order_Id).html(data);
	        		if (order_status == -1) {
		                message_toastr("success", "Đơn Hàng Đã Bị Từ Chối !");
		            } else if (order_status == 1) {
		                message_toastr("success", "Đơn Hàng Đã Được Duyệt !");
		            } else if (order_status == 2) {
		                message_toastr("success", "Đơn Hàng Đã Giao Thành Công !");
		            } else if (order_status == 3) {
		                message_toastr("success", "Đơn Hàng Đã Bị Bom Huhu :< Icon Mếu");
		            }
	        	}
	            // $('#loading-order-manager').html(data);
/* 	            load_order_list();
	            if (data == "refuse") {
	                message_toastr("success", "Đơn Hàng Đã Bị Từ Chối !");
	            } else if (data == "browser") {
	                message_toastr("success", "Đơn Hàng Đã Được Duyệt !");
	            } else if (data == "success") {
	                message_toastr("success", "Đơn Hàng Đã Giao Thành Công !");
	            } else if (data == "return") {
	                message_toastr("success", "Đơn Hàng Đã Bị Bom Huhu :< Icon Mếu");
	            }
 */
	        },
	        error: function() {
	            alert("Bug Huhu :<<");
	        }
	    }) 
	})
		//message_toastr("success", "Đơn Hàng Đã Bị Từ Chối !");
		/*  load_order_list();
		 load_count_delete() */

		/* function load_order_list() {
		    $.ajax({
		        url: '{{ url('/admin/order-manager/loading-order-manager') }}',
		        method: 'get',
		        data: {},
		        success: function(data) {
		            $('#loading-order-manager').html(data);
		        },
		        error: function() {
		            alert("Bug Huhu :<<");
		        }
		    })
		}

		function load_count_delete(){
		    $.ajax({
		        url: '{{ url('/admin/order-manager/count-delete-soft') }}',
		        method: 'get',
		        data: {},
		        success: function(data) {
		            $('.count-delete').html(data);
		        },
		        error: function() {
		            alert("Bug Huhu :<<");
		        }
		    })
		}


		

		$(document).on('click', '.btn-delete-order', function() {
		    var order_id = $(this).data('order_id');
		    
		    $('.btn_deleted').click(function(){
		        // alert(order_id);
		        // alert('click');
		        $.ajaxSetup({
		            headers: {
		                'X-CSRF-TOKEN': $('meta[name="csrf-token"]').attr('content')
		            }
		        });
		        $.ajax({
		            url: '{{ url('/admin/order-manager/delete-soft-order') }}',
		            method: 'post',
		            data: {
		                order_id: order_id,
		            },
		            success: function(data) {
		                // $('#loading-order-manager').html(data);
		                load_order_list();
		                load_count_delete();
		                message_toastr('success', 'Xóa đơn hàng thành công!!')
		            },
		            error: function() {
		                alert("Bug Huhu :<<");
		            }
		        })
		    })
		})

		$('#filter').change(function(){
		    var value = $(this).val();
		    $.ajax({
		            url: '{{ url('/admin/order-manager/filer-order') }}',
		            method: 'get',
		            data: {
		                value: value,
		            },
		            success: function(data) {
		                $('#loading-order-manager').html(data);
		                // load_order_list();
		                // load_count_delete();
		                // message_toastr('success', 'Xóa đơn hàng thành công!!')

		            },
		            error: function() {
		                alert("Bug Huhu :<<");
		            }
		        })
		}) */
	</script>
</body>
