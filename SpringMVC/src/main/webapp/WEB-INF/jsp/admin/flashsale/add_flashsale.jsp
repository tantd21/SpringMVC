<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<div class="col-12 grid-margin stretch-card">
		<div class="card">
			<div class="card-body">
				<h4 style="margin-top: -15px" class="card-title">Add Flashsale</h4>
				<s:form action="/SpringMVC/admin/products/flashsales/save-flashsale" modelAttribute="flashsale" method="post">
					<div class="form-group">
						<label for="">Product</label> <select
							class="form-control m-bot15" name="productId"> 
							
							<c:forEach items="${ products }" var="product">
							<option value="${ product.productId }">${ product.productName }</option> 							
							</c:forEach>
						</select>
					</div>

					<div class="form-group">
						<label for="">Type Discount</label> <select class="form-control"
							id="flashsale_condition" name="flashsaleCondition">
							<option value="0">Discount for %</option>
							<option selected value="1">Discount for $</option>
						</select>
					</div>

					<div class="form-group">
						<label for="">Level Discount</label> <input type="number"
							class="form-control mb-2" name="flashsalePercent" id="price"
							placeholder="Số Tiền Giảm Giá"> <span
							class="form-message text-danger"></span>
					</div>

					<div class="form-group">
						<label for="">Flashsale Status</label> <select class="form-control"
							name="flashsale_status">
							<option value="0">Hidden</option>
							<option value="1">Present</option>
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
</body>
