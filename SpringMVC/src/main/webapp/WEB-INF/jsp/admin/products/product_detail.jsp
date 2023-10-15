<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="spring.mvc.Until.Until"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<div class="card-body">
				<div style="display: flex; justify-content: space-between">
					<div class="card-title col-sm-9">Bảng Danh Sách Chi Tiết Sản
						Phẩm ${product.productName}</div>
					<div class="col-sm-3"></div>
				</div>

				<table class="table table-bordered">
					<tbody>
						<tr>
							<th>#ID</th>
							<td>${ product.productId }</td>
						</tr>
						<tr>
							<th>Product Name</th>
							<td>${ product.productName }</td>
						</tr>
						<tr>
							<th>Category</th>
							<td>${ product.category.categoryName }</td>
						</tr>
						<tr>
							<th>Price</th>
							<td>${ Until.convertNumber(product.productPrice) }đ</td>
						</tr>
						<tr>
							<th>Image Product</th>
							<td><img
								style="object-fit: cover; margin: 30px 0px 30px 0px"
								width="120px" height="120px"
								src='<c:url value="/assets/web/img/product/${ product.productImage }"/>' /></td>
						</tr>
						<!-- <tr>
							<th>Giảm giá</th> @if ($product->flashsale_status == 1)
							<td>Có</td> @else
							<td>Không</td> @endif
						</tr> -->
						<tr>
							<th>Product Description</th>

							<td><div class=""
									style="width: 660px; overflow: hidden; text-overflow: ellipsis">${ product.productDesc }</div></td>
						</tr>
						<tr>
							<th>Trạng Thái</th>
							<c:choose>
								<c:when test="${ product.productStatus == 1 }">
									<td>Hiển thị</td>
								</c:when>
								<c:otherwise>
									<td>Ẩn</td>
								</c:otherwise>
							</c:choose>
						</tr>
						<tr>
							<th>Ngày Thêm Vào</th>
							<td>${ product.createdAt }</td>
						</tr>
						<tr>
							<th>Cập Nhật Lần Cuối</th>
							<td>${ product.updatedAt }</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>


	<div class="col-lg-12 grid-margin stretch-card">
		<div class="card">
			<div class="card-body">
				<div style="display: flex; justify-content: space-between">
					<div class="card-title col-sm-9">Thư Viện Ảnh Của Sản Phẩm
						"${ product.productName }"</div>
					<div class="col-sm-3"></div>
				</div>
				<s:form action="/SpringMVC/admin/products/save-gallery"
					method="post" enctype="multipart/form-data">
					<div class="mb-3">
						<label for="formFile" class="form-label">Thêm Ảnh Vào Thư
							Viện Ảnh</label> <input class="form-control" type="file" name="image"
							id="formFile" accept="image/*" multiple>
					</div>
					<div>
						<input hidden value="${product.productId }" name="productId">
						<button type="submit" class="btn btn-primary">Submit</button>
					</div>
				</s:form>
				<table style="margin-top: 20px"
					class="table table-bordered tab-gallery">
					<form>
						<input type="hidden" value="{{ $product->product_id }}"
							id="pro_id" name="pro_id">
						<thead>
							<tr>
								<th>Tên Ảnh</th>
								<th>Hình Ảnh</th>
								<th>Nội Dung Ảnh</th>
								<th>Thao Tác</th>
							</tr>
						</thead>
						<tbody id="loading_gallery_product">
							<c:forEach items="${ product.galleryProducts }" var="gallery">
								<tr>

									<td contenteditable class="edit-content" data-type="1" data-gallery_id="${ gallery.galleryId }">${ gallery.galleryImageName }</td>
									<td><img style="object-fit: cover;" width="30px"
										height="30px"
										src='<c:url value="/assets/web/img/product/${ gallery.galleryImageProduct }"/>' /></td>
									<td contenteditable class="edit-content" data-type="2" data-gallery_id="${ gallery.galleryId }">${ gallery.galleryImageContent }</td>
									<td><button type="button"
											class="btn btn-inverse-danger btn-icon btn-delete-force"
											data-delete_id="${ gallery.galleryId }"
											data-photo="${ gallery.galleryImageProduct }"
											data-restore_id="0">
											<i class="mdi mdi-delete-forever"></i>
										</button></td>
								</tr>
							</c:forEach>
						</tbody>
					</form>
				</table>

			</div>
		</div>
	</div>
	<%-- <script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js" /> --%>
	<script type="text/javascript">
		$(".btn-delete-force").on("click", function() {
			var galleryId = $(this).data("delete_id");
			var galleryImage = $(this).data("photo");
			var row = $(this).closest("tr");
			alert(galleryId)
			 $.ajax({
			    url: "/SpringMVC/admin/products/delete-gallery?delete-id="+ galleryId + "&image="+ galleryImage, // Thay đổi đường dẫn dựa vào ứng dụng của bạn
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
		
		$('.tab-gallery #loading_gallery_product').on('blur', '.edit-content', function() {
            var gallery_id = $(this).data('gallery_id');
            var gallery_content = $(this).text();
            var type = $(this).data('type');
            $.ajax({
                url: '/SpringMVC/admin/products/update-gallery-content?galleryId=' + gallery_id + "&content=" + gallery_content + "&type="+ type,
                method: 'post',
                data: {
            
                },
                success: function(data) {
                    message_toastr("success", type + " Đã Được Cập Nhật !");
                    load_gallery_product();
                },
                error: function(data) {
                    alert("Nhân Ơi Fix Bug Huhu :<");
                },
            }); 
        });
	</script>
</body>
