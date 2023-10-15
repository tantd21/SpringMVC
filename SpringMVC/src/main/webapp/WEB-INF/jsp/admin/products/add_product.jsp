<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
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
	<div class="col-12 grid-margin stretch-card">
		<div class="card">
			<div class="card-body">
				<h4 style="margin-top: -15px" class="card-title">Add Product</h4>
				<s:form class="forms-product" modelAttribute="product" action="/SpringMVC/admin/products/save-product"
					method="post" enctype="multipart/form-data">
					<div class="form-group">
						<label for="exampleInputName1">Product Name</label> <input
							type="text" name="productName" class="form-control mb-2"
							id="name" placeholder="Name" value=""> <span
							class="text-danger form-message pt-2"></span>
					</div>
					<div class="form-group">
						<label for="">Category Product</label> <select
							class="form-control m-bot15" id="category" name="categoryId">
							<c:forEach items="${ categorys }" var="category">
								<option  value="${ category.categoryId }">
									${category.categoryName }</option>
							</c:forEach>
						</select>
					</div>

					<div class="form-group">
						<label for="exampleTextarea1">Product Description</label>
						<textarea rows="8" class="form-control mb-2" name="productDesc"
							id="desc"></textarea>
						<br> <span class="text-danger form-message"></span>
					</div>

					<div class="form-group">
						<label>File upload</label>
						<div class="mb-3">
							<input name="image" class="form-control mb-2" type="file"
								id="formFile"> <br> <span
								class="text-danger form-message pt-2"></span>
						</div>

					</div>

					<div class="form-group">
						<label for="">Price</label> <input type="number"
							class="form-control mb-2" name="productPrice" id="price"
							placeholder="Giá" value=""> <span
							class="text-danger form-message mt-2"></span>
					</div>

					<div class="form-group">
						<label for="">Status</label> <select class="form-control"
							name="productStatus">
							<option value="0">Ẩn</option>
							<option value="1">Hiện</option>
						</select>
					</div>
					<button type="submit" class="btn btn-gradient-primary me-2">Submit</button>
					<button class="btn btn-light">Cancel</button>
				</s:form>
			</div>
		</div>
	</div>
	<script>
        ClassicEditor
            .create(document.querySelector('#editor'))
            .then(editor => {
                console.log(editor);
            })
            .catch(error => {
                console.error(error);
            });

        ClassicEditor
            .create(document.querySelector('#editor1'))
            .then(editor => {
                console.log(editor);
            })
            .catch(error => {
                console.error(error);
            });
    </script>
	<script>
        
    </script>
	<script src="{{ asset('public/fontend/assets/js/validate.js')}}"></script>

	<script>
             Validator({
                 form: '.forms-product',
                 errorSelector: '.form-message',
                 rules: [
                     Validator.isRequired('#name', 'Vui lòng nhập tên sản phẩm'),
                     Validator.isRequired('#formFile', 'Vui lòng tải lên ảnh Sản Phẩm'),
                     Validator.isRequired('#desc', 'Vui lòng nhập mô tả sản phẩm'),
                     Validator.minPrice('#price', 20000),
                     Validator.maxPrice('#price', 200000),
                 ]
             });
     
             $(':input[type="submit"]').prop('disabled', true);
     
             $('.form-control').blur(function(){
                 if ($('#name').val() != '' && $('#desc').val() != ''  && $('#price').val() != '' && $('#price').val() >= 20000 && $('#price').val() <= 200000) {
                     $(':input[type="submit"]').prop('disabled', false);
                 }
             })
    </script>
</body>
