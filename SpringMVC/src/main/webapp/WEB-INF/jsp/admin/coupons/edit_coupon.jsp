<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<body>

	<link rel="stylesheet"
		href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.13.2/themes/base/jquery-ui.min.css"
		integrity="sha512-ELV+xyi8IhEApPS/pSj66+Jiw+sOT1Mqkzlh8ExXihe4zfqbWkxPRi8wptXIO9g73FSlhmquFlUOuMSoXz5IRw=="
		crossorigin="anonymous" referrerpolicy="no-referrer" />

	<div class="page-header">
		<h3 class="page-title">
			<span class="page-title-icon bg-gradient-primary text-white me-2">
				<i class="mdi mdi-certificate"></i>
			</span> Quản Lý Mã Giảm Giá
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
				<h4 style="margin-top: -15px" class="card-title">Thêm Mã Giảm
					Giá</h4>
				<s:form class="forms-sample"
					action="/SpringMVC/admin/coupons/update-coupon" method="post"
					enctype="multipart/form-data" modelAttribute="coupon">
					<input type="hidden" name="couponId" value="${ coupon.couponId }">
					<input type="hidden" name="createdAt" value="${ coupon.createdAt }">
					<div class="form-group">
						<label for="exampleInputName1">Tên Mã Giảm Giá</label> <input
							type="text" name="couponName" value="${ coupon.couponName }"
							class="form-control" id="" placeholder="Nhập Tên Mã Giảm Giá">
					</div>

					<div class="form-group">
						<label for="exampleInputName1">Mã Giảm Giá</label> <input
							type="text" name="couponNameCode"
							value="${ coupon.couponNameCode }" class="form-control" id=""
							placeholder="Nhập Mã Giảm Giá">
					</div>

					<div class="form-group">
						<label for="exampleTextarea1">Mô Tả Mã Giảm Giá</label>
						<textarea rows="8" class="form-control" name="couponDesc" id="">${ coupon.couponDesc }</textarea>
					</div>

					<div class="form-group">
						<label for="exampleInputName1">Số Lượng Mã</label> <input
							type="text" name="couponQtyCode"
							value="${ coupon.couponQtyCode }" class="form-control" id=""
							placeholder="Nhập Số Lượng Mã">
					</div>

					<div class="form-group">
						<label for="">Tính Năng Của Mã</label> <select
							class="form-control" name="coupon_condition">

							<c:choose>
								<c:when test="${ coupon.couponCondition == 1 }">
									<option active value="1">Giảm Giá Theo %</option>
									<option value="2">Giảm Giá Theo Số Tiền</option>
								</c:when>

								<c:otherwise>
									<option active value="2">Giảm Giá Theo Số Tiền</option>
									<option value="1">Giảm Giá Theo %</option>
								</c:otherwise>
							</c:choose>
						</select>
					</div>
					<div class="form-group">
						<label for="exampleInputName1">Số Tiền Hoặc Số % Giảm Giá</label>
						<input type="text" name="couponPriceSale"
							value="${ coupon.couponPriceSale }" class="form-control" id=""
							placeholder="Nhập Số Tiền Hoặc Số % Giảm Giá">
					</div>

					<div class="form-group">
						<label for="exampleInputName1">Ngày bắt đầu</label> <input
							type="text" autocomplete="off" name="couponDateStart"
							class="form-control" id="date_start" placeholder="Ngày Bắt Đầu"
							value="${ coupon.couponDateStart }">
					</div>

					<div class="form-group">
						<label for="exampleInputName1">Ngày kết thúc</label> <input
							type="text" autocomplete="off" name="couponDateEnd"
							class="form-control" id="date_end" placeholder="Ngày Kết Thúc"
							value="${ coupon.couponDateEnd }">
					</div>

					<button type="submit" class="btn btn-gradient-primary me-2">Cập
						Nhật</button>
					<button class="btn btn-light">Cancel</button>
				</s:form>
			</div>
		</div>
	</div>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"
		integrity="sha512-aVKKRRi/Q/YV+4mjoKBsE4x3H+BkegoM/em46NNlCqNTmUYADjBbeNefNxYV7giUp0VxICtqdrbqU7iVaeZNXA=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.13.2/jquery-ui.min.js"
		integrity="sha512-57oZ/vW8ANMjR/KQ6Be9v/+/h6bq9/l3f0Oc7vn6qMqyhvPd1cvKBRWWpzu0QoneImqr2SkmO4MSqU+RpHom3Q=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.full.min.js"
		integrity="sha512-AIOTidJAcHBH2G/oZv9viEGXRqDNmfdPVPYOYKGy3fti0xIplnlgMHUGfuNRzC6FkzIo0iIxgFnr9RikFxK+sw=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script>
		$('#date_start').datepicker(
				{
					dateFormat : "yy-mm-dd",
					prevText : 'Tháng trước',
					nextText : 'Tháng sau',
					dayNamesMin : [ 'Thứ 2', 'Thứ 3', 'Thứ 4', 'Thứ 5',
							'Thứ 6', 'Thứ 7', 'Chủ Nhật' ],
					duration : 'slow',
				});
		$('#date_end').datepicker(
				{
					dateFormat : "yy-mm-dd",
					prevText : 'Tháng trước',
					nextText : 'Tháng sau',
					dayNamesMin : [ 'Thứ 2', 'Thứ 3', 'Thứ 4', 'Thứ 5',
							'Thứ 6', 'Thứ 7', 'Chủ Nhật' ],
					duration : 'slow',
				});
	</script>

</body>
