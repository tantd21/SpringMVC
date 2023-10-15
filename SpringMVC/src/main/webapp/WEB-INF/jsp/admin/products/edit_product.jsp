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
			</span> Quản Lý Sản Phẩm
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
	<div class="col-12 grid-margin stretch-card">
		<div class="card">
			<div class="card-body">
				<h4 style="margin-top: -15px" class="card-title">Update Product</h4>
				<s:form class="forms-product" modelAttribute="product"
					action="/SpringMVC/admin/products/update-product" method="post"
					enctype="multipart/form-data">
					<div class="form-group">
						<label for="">Product Name</label> <input type="text"
							class="form-control" id="" name="productName"
							placeholder="Điền vào tên sản phẩm"
							value="${ product.productName }">
					</div>
					<div class="form-group">
						<label for="">Product Category</label> <select
							class="form-control" name="category_id">
							<!-- @foreach
							($data_category as $key => $dataCategory) @if
							($dataCategory->category_id == $product_old->category_id) -->
							<c:forEach items="${ categorys }" var="category">
								<c:choose>
									<c:when test="${ category.categoryId == product.category.categoryId }">
										<option selected value="${ category.categoryId }">${ category.categoryName }</option>
									</c:when>
									<c:otherwise>
										<option value="${ category.categoryId }">${ category.categoryName }</option>
									</c:otherwise>
								</c:choose>

							</c:forEach>

						</select>
					</div>

					<div class="form-group">
						<label for="exampleTextarea1">Product Description</label>
						<textarea class="form-control" name="productDesc"
							id="exampleTextarea1" rows="4">${ product.productDesc }</textarea>
					</div>

					<div class="form-group">
						<label for="">Price</label> <input type="number"
							class="form-control" name="productPrice" id="" placeholder="Giá"
							value="${ product.productPrice }">
					</div>
					<div class="form-group">
						<input name="productId" hidden="true"
							value="${ product.productId }"> <input name="photo"
							hidden value="${ product.productImage }"> <label>Image
							Product</label>	
						<div>
							<img style="object-fit: cover; margin: 30px 0px 30px 0px"
								width="120px" height="120px"
								src='<c:url value="/assets/web/img/product/${ product.productImage }"/>' />
						</div>
						<div class="mb-3">
							<input name="image" class="form-control" type="file"
								id="formFile">
						</div>
					</div>

					<button type="submit" class="btn btn-gradient-primary me-2">Submit</button>
					<button class="btn btn-light">Cancel</button>
				</s:form>
			</div>
		</div>
	</div>
</body>
