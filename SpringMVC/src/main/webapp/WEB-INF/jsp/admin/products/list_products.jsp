<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="spring.mvc.Until.Until"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta charset="UTF-8">
<body>

		<div class="page-header">
			<h3 class="page-title">
				<span class="page-title-icon bg-gradient-primary text-white me-2">
					<i class="mdi mdi-crosshairs-gps"></i>
				</span> Product Manage
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
						<div class="card-title col-sm-3">Table of Products</div>
						<div class="col-sm-3">
							<div class="input-group">
								<input id="search" type="text" class="form-control" name="search"
									placeholder="Tìm Kiếm Sản Phẩm">
							</div>
						</div>
						<div class="col-sm-2">
	
							<button type="button" width="100px"
								class="btn btn-outline-secondary dropdown-toggle"
								data-bs-toggle="dropdown">Category</button>
							<div class="dropdown-menu">
								<span class="dropdown-item" data-category_id="0">Tất Cả 1</span>
								<c:forEach items="${ categorys }" var="category">
									<span class="dropdown-item"
										data-category_id="${ category.categoryId }">${ category.categoryName }</span>
								</c:forEach>
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
								<th><label for="product_name">Product Name <i
										style="font-size: 18px" class="mdi mdi-sort-alphabetical"></i></label></th>
								<th><label for="product_name">Category Name <i
										style="font-size: 18px" class="mdi mdi-sort-alphabetical"></i></label>
									<input type="checkbox" hidden class="btn-sort" id="product_name"
									data-type='product'></th>
								<th><label for="product_category"> Price <i
										style="font-size: 18px" class="mdi mdi-sort-alphabetical"></i></label>
									<input type="checkbox" hidden class="btn-sort" id="category_id"
									data-type='category'></th>
	
								<th><label for="product_price">Image Product<i
										style="font-size: 18px" class="mdi mdi-sort-numeric"></i></label></th>
	
								<th>Status</th>
								<th>Operation</th>
							</tr>
						</thead>
						<tbody id="loading-table-product">
							<c:forEach items="${ products.content }" var="product">
								<tr>
									<td>${ product.productName }</td>
									<td>${ product.category.categoryName }</td>
									<td>${ Until.convertNumber(product.productPrice) }đ</td>
									<td><img
										src='<c:url value="/assets/web/img/product/${ product.productImage }"/>' /></td>
									<td><c:choose>
											<c:when test="${ product.productStatus == 1 }">
												<i style="color: rgb(52, 211, 52); font-size: 30px"
													class="mdi mdi-toggle-switch btn-un-active"
													data-product_id="${ product.productId }" data-status="0"></i>
											</c:when>
											<c:otherwise>
												<i style="color: rgb(196, 203, 196); font-size: 30px"
													class="mdi mdi-toggle-switch-off btn-un-active"
													data-product_id="${ product.productId }" data-status="1"></i>
											</c:otherwise>
										</c:choose></td>
									<td>
										<a href="/SpringMVC/admin/products/product-detail?productId=${ product.productId }">
										<button type="button"
											class="btn btn-inverse-info btn-icon btn-restore"
											data-restore_id="${ product.productId }" data-delete_id="-1">
											<i class="mdi mdi-information"></i>
										</button> 
										</a>
										<a
										href="/SpringMVC/admin/products/edit-product?productId=${ product.productId }">
											<button type="button"
												class="btn btn-inverse-success btn-icon btn-detail"
												data-delete_id="${ product.productId }"
												data-photo="${ product.productImage }" data-restore_id="0">
											<i class="mdi mdi-keyboard-return"></i>
											</button>
									</a>
										<button type="button"
											class="btn btn-inverse-danger btn-icon btn-delete-force"
											data-delete_id="${ product.productId }"
											data-photo="${ product.productImage }" data-restore_id="0">
											<i class="mdi mdi-delete-forever"></i>
										</button>
	
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
	
				</div>
			</div>
		</div>
	
		<nav aria-label="Page navigation example">
			<ul class="pagination">
				<c:if test="${ products.number != 0 }">
					<li class="page-item"><a class="page-link"
						href="/SpringMVC/admin/products?p=${ products.number - 1 }">Previous</a></li>
				</c:if>
				<c:forEach begin="0" end="${ products.totalPages - 1 }" var="number">
					<c:choose>
						<c:when test="${ number == products.number }">
							<li class="page-item active" value="${ number }"><a
								class="page-link" href="/SpringMVC/admin/products?p=${ number }">${ number + 1 }</a></li>
						</c:when>
						<c:otherwise>
							<li class="page-item" value="${ number }"><a
								class="page-link" href="/SpringMVC/admin/products?p=${ number }">${ number + 1 }</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:if test="${ products.number < products.totalPages - 1 }">
					<li class="page-item"><a class="page-link"
						href="/SpringMVC/admin/products?p=${ products.number + 1 }">Next</a></li>
				</c:if>
			</ul>
		</nav>

	<!-- <script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js" /> -->
	<script type="text/javascript">
		/* var notePage = 0;
		$('.pagination li').unbind('click').on('click', function(e) {
			e.preventDefault();
			var page = $(this).val();
			notePage = page;
			alert(notePage);
			// alert(notePage)
			//getPosts(page);
		});

		function load_list_product(page) {
			$.ajax({
				url : '/SpringMVC/admin/products/load-products?p=' + page,
				method : 'get',
				data : {
				},
				contentType : "application/json; charset=UTF-8",
				success : function(data) {
					$('tbody').html(data);
				},
				error : function(data) {
					alert("Fix Bug Huhu :<");
				},
			})
		}

		load_list_product(notePage); */

		$('#search').keyup(function() {

			var keysreach = $("#search").val();
			console.log("sss" + keysreach)
			$.ajax({
				url : '/SpringMVC/admin/products/search-products?text=' + keysreach + '&p=' + ${ products.number },
				method : 'GET',
				data : {
				/* key_sreach: key_sreach, */
				},
				success : function(data) {
					console.log(data)
					$('tbody').html(data);
				},
				error : function(data) {
					alert(data);
				}
			})
		});

		$('tbody')
				.on('click','.btn-delete-force',function() {
							var delete_id = $(this).data('delete_id')
							var photo = $(this).data('photo')
							alert(delete_id);
							$.ajax({
										url : '/SpringMVC/admin/products/deleted-product?delete_id='
												+ delete_id + "&photo=" + photo,
										method : 'DELETE',
										data : {
										},
										success : function(data) {
											window.location.reload();
										},
										error : function(data) {
											alert("Fix Bug Huhu :<");
										},
									})
						})

		/*  $('tbody').on('click', '.btn-restore', function() {
		     var category_id = $(this).data('update_id');
		     var type = $(this).data('delete_id');
		     // alert(category_id);
		     $.ajax({
		         url: '{{ url('admin/category/trash-category/delete-restore-category') }}',
		         method: 'get',
		         data: {
		             category_id: category_id,
		             type: type
		         },
		         success: function(data) {
		             // $('tbody').html(data);
		             load_delete_soft_category();
		             message_toastr('success', 'Thành công', 'Danh mục đã được khôi phục');
		         },
		         error: function(data) {
		             alert("Fix Bug Huhu :<");
		         },
		     })
		 })  */
	</script>
</body>
