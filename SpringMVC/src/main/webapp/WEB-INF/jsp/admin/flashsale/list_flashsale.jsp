<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="spring.mvc.Until.Until"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<body>
	<div class="page-header">
		<h3 class="page-title">
			<span class="page-title-icon bg-gradient-primary text-white me-2">
				<i class="mdi mdi-crosshairs-gps"></i>
			</span> Flashsale Manage
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
			<div class="card-body">
				<div style="display: flex; justify-content: space-between">
					<div class="card-title col-sm-5">Table of Flashsale</div>
					<div class="col-sm-7">
						<form
							action="{{ URL::to('admin/product/all-product-sreachbyname') }}"
							method="get">
							<div class="input-group">
								<input type="text" class="form-control" name="searchbyname"
									placeholder="Search"> <span class="input-group-btn">
									<button type="submit" class="btn btn-gradient-primary me-2">Search</button>
								</span>
							</div>
						</form>
					</div>
				</div>
				<table style="margin-top: 20px" class="table table-bordered">
					<thead>
						<tr>

							<th>Product Name <i style="font-size: 18px"
								class="mdi mdi-sort-alphabetical"></th>
							<th>Type sale</th>
							<th>Level sale</th>
							<th>Price Original</th>
							<th>Price sale</th>
							<th>Status</th>
							<th>Operation</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ flashsales.content }" var="flashsale">
							<tr>
								<td>${ flashsale.product.productName }</td>
								<td><c:choose>
										<c:when test="${ flashsale.flashsaleCondition == 0 }">
										Giảm giá theo %
									</c:when>
										<c:otherwise>
										Giảm giá theo đ
									</c:otherwise>
									</c:choose></td>
								<td>${ flashsale.flashsalePercent }</td>

								<td>${ Until.convertNumber(flashsale.product.productPrice) }đ</td>

								<td>${ Until.convertNumber(flashsale.flashsalePriceSale) }đ</td>

								<td><c:choose>
										<c:when test="${ flashsale.flashsaleStatus == 1 }">
											<i style="color: rgb(52, 211, 52); font-size: 30px"
												class="mdi mdi-toggle-switch btn-un-active"
												data-product_id="${ flashsale.flashsaleId }" data-status="0"></i>
										</c:when>
										<c:otherwise>
											<i style="color: rgb(196, 203, 196); font-size: 30px"
												class="mdi mdi-toggle-switch-off btn-un-active"
												data-product_id="${ flashsale.flashsaleId }" data-status="1"></i>
										</c:otherwise>
									</c:choose></td>

								<td><a
									href="/SpringMVC/admin/products/flashsales/edit-flashsale?flashsaleId=${ flashsale.flashsaleId }">
										<button type="button"
											class="btn btn-inverse-success btn-icon btn-detail"
											data-delete_id="${ flashsale.flashsaleId }"
											data-restore_id="0">
											<i class="mdi mdi-keyboard-return"></i>
										</button>
								</a>
									<button type="button"
										class="btn btn-inverse-danger btn-icon btn-delete-force"
										data-delete_id="${ flashsale.flashsaleId }"
										data-product_id="${ flashsale.product.productId }"
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
			<c:if test="${ flashsales.number != 0 }">
				<li class="page-item"><a class="page-link"
					href="/SpringMVC/admin/products/flashsales?p=${ flashsales.number - 1 }">Previous</a></li>
			</c:if>
			<c:forEach begin="0" end="${ flashsales.totalPages - 1 }"
				var="number">
				<c:choose>
					<c:when test="${ number == flashsales.number }">
						<li class="page-item active" value="${ number }"><a
							class="page-link"
							href="/SpringMVC/admin/products/flashsales?p=${ number }">${ number + 1 }</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item" value="${ number }"><a
							class="page-link"
							href="/SpringMVC/admin/products/flashsales?p=${ number }">${ number + 1 }</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${ flashsales.number < flashsales.totalPages - 1 }">
				<li class="page-item"><a class="page-link"
					href="/SpringMVC/admin/products/flashsales?p=${ flashsales.number + 1 }">Next</a></li>
			</c:if>
		</ul>
	</nav>
	<script type="text/javascript">
	$(".btn-delete-force").on("click", function() {
		var deleteId = $(this).data("delete_id");
		var productId = $(this).data("product_id")
		var row = $(this).closest("tr");
		alert(deleteId)
		 $.ajax({
		    url: "/SpringMVC/admin/products/flashsales/delete-flashsale?flashsaleId="+ deleteId + "&productId=" + productId, // Thay đổi đường dẫn dựa vào ứng dụng của bạn
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
