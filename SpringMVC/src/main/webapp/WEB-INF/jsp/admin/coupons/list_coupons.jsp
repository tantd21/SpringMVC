<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<body>

	<div class="page-header">
		<h3 class="page-title">
			<span class="page-title-icon bg-gradient-primary text-white me-2">
				<i class="mdi mdi-crosshairs-gps"></i>
			</span> Coupon Manage
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

	<div class="col-lg-12 grid-margin stretch-card">
		<div class="card">
			<div class="card-body ">
				<div style="display: flex; justify-content: space-between">
					<div class="card-title col-sm-3">Table of Coupons</div>
					<div class="col-sm-3">
						<div class="input-group">
							<input id="search" type="text" class="form-control" name="search"
								placeholder="Tìm Kiếm Sản Phẩm">
						</div>
					</div>
					<div class="col-sm-2">

						<button type="button" width="100px"
							class="btn btn-outline-secondary dropdown-toggle"
							data-bs-toggle="dropdown">Coupon</button>
						<div class="dropdown-menu">
							<span class="dropdown-item" data-coupon_id="0">Tất Cả 1</span>
							<%-- <c:forEach items="${ coupons }" var="coupon">
								<span class="dropdown-item"
									data-coupon_id="${ coupon.couponId }">${ coupon.couponName }</span>
							</c:forEach> --%>
						</div>

					</div>
					<div class="col-sm-2">
						<div class="input-group">
							<a style="text-decoration: none"
								href="{{ URL::to('admin/product/trash-product') }}">
								<button type="button" class="btn btn-outline-secondary">
									Thùng Rác <span class="count-delete" style="color: red"></span>
								</button>
							</a>
						</div>
					</div>
				</div>

				<table style="margin-top: 20px" class="table table-bordered">
					<thead>
						<tr>
							<th><label for="product_name">Coupon Name <i
									style="font-size: 18px" class="mdi mdi-sort-alphabetical"></i></label></th>
									<th><label for="product_name">Coupon Code <i
									style="font-size: 18px" class="mdi mdi-sort-alphabetical"></i></label></th>
							<th><label for="product_name">Coupon Description <i
									style="font-size: 18px" class="mdi mdi-sort-alphabetical"></i></label>
								<input type="checkbox" hidden class="btn-sort" id="product_name"
								data-type='product'></th>
							<th>Status</th>
							<th>Operation</th>
						</tr>
					</thead>
					<tbody id="loading-table-product">
						<c:forEach items="${ coupons.content }" var="coupon">
							<tr>
								<td>${ coupon.couponName }</td>
								<td>${ coupon.couponQty }</td>
								<td>${ coupon.couponDesc }</td>
								<td> <a
									href="/SpringMVC/admin/coupons/edit-coupon?couponId=${ coupon.couponId }">
										<button type="button"
											class="btn btn-inverse-success btn-icon btn-detail"
											data-delete_id="${ coupon.couponId }"
											data-photo="${ product.productImage }" data-restore_id="0">
											<i class="mdi mdi-update"></i>
										</button>
								</a>
									<button type="button"
										class="btn btn-inverse-danger btn-icon btn-delete-force"
										data-delete_id="${ coupon.couponId }"
										 data-restore_id="0">
										<i class="mdi mdi-delete-forever"></i>
									</button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
		</div>
	</div>

	<nav aria-label="Page navigation example">
		<ul class="pagination">
			<c:if test="${ coupons.number != 0 }">
				<li class="page-item"><a class="page-link"
					href="/SpringMVC/admin/coupons?p=${ coupons.number - 1 }">Previous</a></li>
			</c:if>
			<c:forEach begin="0" end="${ coupons.totalPages - 1 }" var="number">
				<c:choose>
					<c:when test="${ number == coupons.number }">
						<li class="page-item active" value="${ number }"><a
							class="page-link" href="/SpringMVC/admin/coupons?p=${ number }">${ number + 1 }</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item" value="${ number }"><a
							class="page-link" href="/SpringMVC/admin/coupons?p=${ number }">${ number + 1 }</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${ coupons.number < coupons.totalPages - 1 }">
				<li class="page-item"><a class="page-link"
					href="/SpringMVC/admin/coupons?p=${ coupons.number + 1 }">Next</a></li>
			</c:if>
		</ul>
	</nav>
	
	<script type="text/javascript">
	$(".btn-delete-force").on("click", function() {
		var deleteId = $(this).data("delete_id");
		var row = $(this).closest("tr");
		alert(deleteId)
		 $.ajax({
		    url: "/SpringMVC/admin/coupons/delete-coupon?delete-id="+ deleteId, // Thay đổi đường dẫn dựa vào ứng dụng của bạn
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