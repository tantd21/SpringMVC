<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="spring.mvc.Until.Until"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<body>
	<div class="page-header">
		<h3 class="page-title">
			<span class="page-title-icon bg-gradient-primary text-white me-2">
				<i class="mdi mdi-book-variant"></i>
			</span> Quản Lý Mã Giảm Giá
		</h3>
		<nav aria-label="breadcrumb">
			<ul class="breadcrumb">
				<li class="breadcrumb-item active" aria-current="page"><i
					class="mdi mdi-timetable"></i> <span> <?php
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
					<div class="card-title col-sm-6">Bảng Danh Sách Mã Giảm Giá</div>
					<div class="col-sm-6">
						<button class="btn btn-outline-success btn-fw">
							<a href="{{ url('admin/coupon/trash-coupon') }}"
								style="text-decoration: none; color: black"><i
								class="mdi mdi-delete-sweep"></i> Thùng rác <span
								class="count-delete" style="color: red"></span></a>
						</button>
					</div>
					<div class="col-sm-4"></div>
				</div>
				<table style="margin-top: 20px" class="table table-bordered">
					<thead>
						<tr>
							<th>Code Giảm Giá</th>
							<th>Loại Giảm Giá</th>
							<th>Mức Giảm</th>
							<th>Số Lượng</th>
							<th>Bắt Đầu</th>
							<th>Kết Thúc</th>
							<th>Thao Tác</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ coupons }" var="coupon">
							<tr>
								<td>${ coupon.couponName }</td>
								<td><c:choose>
										<c:when test="${ coupon.couponCondition == 1 }">
											Giảm giá theo %
										</c:when>
										<c:otherwise>
											Giảm giá theo đ
										</c:otherwise>
									</c:choose></td>
								<td><c:choose>
										<c:when test="${ coupon.couponCondition == 1 }">
											${ Until.convertNumber(coupon.couponPriceSale) }%
										</c:when>
										<c:otherwise>
											${ Until.convertNumber(coupon.couponPriceSale) }đ
										</c:otherwise>
									</c:choose></td>
								<td>${ coupon.couponQtyCode }</td>
								<td>${ coupon.couponDateStart }</td>
								<td>${ coupon.couponDateEnd }</td>
								<td><a
									href="/SpringMVC/admin/coupons/edit-coupon?couponId=${ coupon.couponId }">
										<button type="button"
											class="btn btn-inverse-success btn-icon btn-detail"
											data-delete_id="${ coupon.couponId }" data-restore_id="0">
											<i class="mdi mdi-update"></i>
										</button>
								</a>
									<button type="button"
										class="btn btn-inverse-danger btn-icon btn-delete-force"
										data-delete_id="${ coupon.couponId }" data-restore_id="0">
										<i class="mdi mdi-delete-forever"></i>
									</button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<script>
	$(".btn-delete-force").on("click", function() {
		var deleteId = $(this).data("delete_id");
		var row = $(this).closest("tr");
		alert(deleteId)
		 $.ajax({
		    url: "/SpringMVC/admin/coupons/delete-coupon?deleteId="+ deleteId, // Thay đổi đường dẫn dựa vào ứng dụng của bạn
		    type: "DELETE",
		    data: {
		        
		    },
		    success: function(data) {
		        // Xóa hàng khỏi bảng sau khi xóa thành công
		        row.fadeOut("slow", function() {
		            $(this).remove();
		        });
		    },
		    error: function() {
		        alert("Đã xảy ra lỗi khi xóa dữ liệu.");
		    }
		}); 
	});
        

  
    </script>
</body>
