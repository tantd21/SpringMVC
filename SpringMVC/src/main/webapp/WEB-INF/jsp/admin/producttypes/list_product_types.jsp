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
			</span> Quản Lý Loại Sản phẩm
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
					<div class="card-title col-sm-5">Bảng Danh Sách Loại Sản Phẩm
					</div>
					<div class="col-sm-3">
						<button class="btn btn-outline-success btn-fw">
							<a
								href="{{ url('admin/product/product-type/trash-product-type') }}"
								style="text-decoration: none; color: black"><i
								class="mdi mdi-delete-sweep"></i> Thùng rác <span
								class="count-delete" style="color: red"></span></a>
						</button>
					</div>
				</div>
				<table style="margin-top: 20px" class="table table-bordered">
					<thead>
						<tr>
							<th>Tên Loại Sản Phẩm</th>
							<th>Giá</th>
							<th>Hiển Thị</th>
							<th>Ngày Thêm</th>
							<th>Thao Tác</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ productTypes }" var="type">
							<tr>
								<td>${ type.productTypeName }</td>
								<td>${ Until.convertNumber(type.productTypePrice) }đ</td>
								<td id="un_active${ type.productTypeId }"><c:choose>
										<c:when test="${ type.productTypeStatus == 1 }">
											<i style="color: rgb(52, 211, 52); font-size: 30px"
												class="mdi mdi-toggle-switch btn-un-active"
												data-product_id="${ type.productTypeId }" data-status="0"></i>
										</c:when>
										<c:otherwise>
											<i style="color: rgb(196, 203, 196); font-size: 30px"
												class="mdi mdi-toggle-switch-off btn-un-active"
												data-product_id="${ type.productTypeId }" data-status="1"></i>
										</c:otherwise>
									</c:choose></td>
								<td>${ type.createdAt }</td>
								<td><a
									href="/SpringMVC/admin/product-types/edit-product-type?productTypeId=${ type.productTypeId }">
										<button type="button"
											class="btn btn-inverse-success btn-icon btn-detail"
											data-delete_id="${ type.productTypeId }"
											data-restore_id="0">
											<i class="mdi mdi-keyboard-return"></i>
										</button>
								</a>
									<button type="button"
										class="btn btn-inverse-danger btn-icon btn-delete-force"
										data-delete_id="${ type.productTypeId }"
										data-photo="${ product.productImage }" data-restore_id="0">
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

	$('tbody')
	.on('click','.btn-delete-force',function() {
				var delete_id = $(this).data('delete_id')
				var row = $(this).closest("tr");
				alert(delete_id);
				$.ajax({
							url : '/SpringMVC/admin/product-types/deleted-product-type?delete_id='
									+ delete_id + "&photo=" + photo,
							method : 'DELETE',
							data : {
							},
							success : function(data) {
								 row.fadeOut("slow", function() {
							            $(this).remove();
							        });
							},
							error : function(data) {
								alert("Fix Bug Huhu :<");
							},
						})
			})
$('tbody').on('click', '.btn-un-active', function() {
var product_id = $(this).data('product_id');
var status = $(this).data('status');
$.ajax({
    url: '/SpringMVC/admin/product-types/un-active-product-type?productTypeId=' + product_id + "&status=" + status,
    method: 'get',
    data: {
    },
    success: function(data) {
        $('#un_active' + product_id).html(data);
		
       /*  if (status == 0)
            message_toastr('success', 'Sản phẩm đã bị vô hiệu hóa');
        else
            message_toastr('success', 'Sản phẩm đã được kích hoạt');
*/
    },
    error: function(data) {
        alert("Fix Bug un-active Huhu :<");
    },
})
})
    </script>
</body>
