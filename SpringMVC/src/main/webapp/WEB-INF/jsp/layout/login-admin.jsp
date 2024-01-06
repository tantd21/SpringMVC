<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Đăng Nhập Vào Hệ Thống Quản Trị</title>
<link rel="stylesheet"
	href="<c:url value="/assets/admin/vendors/mdi/css/materialdesignicons.min.css"></c:url>">
<link rel="stylesheet"
	href="<c:url value="/assets/admin/vendors/css/vendor.bundle.base.css"/>">
<link rel="stylesheet"
	href="<c:url value="/assets/admin/css/style.css"></c:url>">
<!-- End layout styles -->
<link rel="shortcut icon"
	href="<c:url value="/assets/admin/images/favicon.ico"/>" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"
	integrity="sha512-aVKKRRi/Q/YV+4mjoKBsE4x3H+BkegoM/em46NNlCqNTmUYADjBbeNefNxYV7giUp0VxICtqdrbqU7iVaeZNXA=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"
	integrity="sha512-aVKKRRi/Q/YV+4mjoKBsE4x3H+BkegoM/em46NNlCqNTmUYADjBbeNefNxYV7giUp0VxICtqdrbqU7iVaeZNXA=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>
<script>
	function message_toastr(type, content) {
		Command: toastr[type](content)
		toastr.options = {
			"closeButton" : true,
			"debug" : true,
			"newestOnTop" : false,
			"progressBar" : true,
			"positionClass" : "toast-top-right",
			"preventDuplicates" : true,
			"showDuration" : "300",
			"hideDuration" : "1000",
			"timeOut" : "5000",
			"extendedTimeOut" : "1000",
			"showEasing" : "swing",
			"hideEasing" : "linear",
			"showMethod" : "fadeIn",
			"hideMethod" : "fadeOut"
		}
	}
</script>
</head>

<body>
	<div class="container-scroller">
		<div class="container-fluid page-body-wrapper full-page-wrapper">
			<div class="content-wrapper d-flex align-items-center auth">
				<div class="row flex-grow">
					<div class="col-lg-4 mx-auto">
						<div class="auth-form-light text-left p-5">
							<div class="brand-logo">
								<!-- <img src=" {{ asset('public/backend/assets/images/logo.svg') }}"> -->
								<img src="<c:url value="/assets/admin/images/logo.svg"/>">
							</div>
							<h4>Chào Mừng Quản Trị Viên Đến Với Hệ Thống !</h4>
							<h6 class="font-weight-light">Đăng Nhập Tài Khoản Quản Trị
								Để Tiếp Tục.</h6>
							<form class="pt-3" action="/SpringMVC/login-admin"
								method="post">
								<div class="form-group">
									<input type="email" name="adminEmail"
										class="form-control form-control-lg" id="exampleInputEmail1"
										placeholder="Email..." value="">
								</div>
								<div class="form-group">
									<input type="password" name="adminPassword"
										class="form-control form-control-lg"
										id="exampleInputPassword1" placeholder="Password"
										value="">
								</div>
								<div class="mt-3">
									<input type="submit"
										class="btn btn-block btn-gradient-primary btn-lg font-weight-medium auth-form-btn"
										value="Đăng nhập">
								</div>
								<div
									class="my-2 d-flex justify-content-between align-items-center">
									<div class="form-check">
										<label class="form-check-label text-muted"> <input
											type="checkbox" class="form-check-input"
											name="SaveLoginCooke" value="ON">Lưu Phiên Đăng Nhập
										</label>
									</div>
									<a href="#" style="text-decoration: none;"
										class="auth-link text-black ">Bạn Quên Mật Khẩu?</a>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
			<!-- content-wrapper ends -->
		</div>
		<!-- page-body-wrapper ends -->
	</div>

	<script src='<c:url value="/assets/admin/js/vendor.bundle.base.js"/>'
		type="text/javascript"></script>
	<script src='<c:url value="/assets/admin/js/off-canvas.js"/>'
		type="text/javascript"></script>
	<script src='<c:url value="/assets/admin/js/hoverable-collapse.js"/>'
		type="text/javascript"></script>
	<script src='<c:url value="/assets/admin/js/misc.js"/>'
		type="text/javascript"></script>
</body>
</html>
