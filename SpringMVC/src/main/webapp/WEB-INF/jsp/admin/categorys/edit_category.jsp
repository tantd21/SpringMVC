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
			</span> Category Manage
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
				<h4 style="margin-top: -15px" class="card-title">Add Category</h4>
				<s:form class="forms-product" modelAttribute="category"
					action="/SpringMVC/admin/categorys/update-category" method="post"
					enctype="multipart/form-data">
					<input type="text" name="categoryId" value="${category.categoryId }" hidden>
					<div class="form-group">
						<label for="exampleInputName1">Category Name</label> <input
							type="text" name="categoryName" class="form-control mb-2"
							id="name" placeholder="Name" value="${ category.categoryName }">
						<span class="text-danger form-message pt-2"></span>
					</div>
					<div class="form-group">
						<label for="exampleTextarea1">Category Description</label>
						<textarea rows="8" class="form-control mb-2" name="categoryDesc"
							id="desc">${ category.categoryDesc }</textarea>
						<br> <span class="text-danger form-message"></span>
					</div>
					<div class="form-group">
						<label for="">Status</label> <select class="form-control"
							name="categoryStatus">
							<c:choose>
								<c:when test="${ category.categoryStatus == 0 }">
									<option selected="selected" value="0">Ẩn</option>
									<option value="1">Hiện</option>
								</c:when>
								<c:otherwise>
									<option value="0">Ẩn</option>
									<option selected="selected" value="1">Hiện</option>
								</c:otherwise>
							</c:choose>
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
