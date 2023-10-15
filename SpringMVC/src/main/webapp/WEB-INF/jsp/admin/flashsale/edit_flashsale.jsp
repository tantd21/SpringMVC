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
				<s:form action="/SpringMVC/admin/products/flashsales/update-flashsale"
					modelAttribute="flashsale" method="post">
					<input type="hidden" name="flashsaleId"
						value="${ flashsale.flashsaleid }">
					<input type="hidden" name="productId"
						value="${ flashsale.product.productId }">
					<input type="hidden" name="productPrice"
						value="${ flashsale.product.productPrice }">
					<div class="form-group">
						<label for="">Sản Phẩm ${ flashsale.product.productName }</label>
					</div>

					<div class="form-group">
						<label for="">Loại Giảm Giá</label> <select class="form-control"
							name="flashsaleCondition">
							<c:choose>
								<c:when test="${ flashsale.flashsaleCondition }">
									<option selected value="0">Giảm Giá Theo %</option>
									<option value="1">Giảm Giá Theo Số Tiền</option>
								</c:when>
								<c:otherwise>
									<option selected value="1">Giảm Giá Theo Số Tiền</option>
									<option value="0">Giảm Giá Theo %</option>
								</c:otherwise>
							</c:choose>
						</select>
					</div>
					<div class="form-group">
						<label for="">Level Discount</label> <input type="number"
							class="form-control mb-2" name="flashsalePercent" id="price"
							placeholder="Số Tiền Giảm Giá" value="${ flashsale.flashsalePercent }"> <span
							class="form-message text-danger"></span>
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
