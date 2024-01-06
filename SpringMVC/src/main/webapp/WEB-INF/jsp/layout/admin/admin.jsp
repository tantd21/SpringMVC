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
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="_csrf" content="YOUR_CSRF_TOKEN_HERE">
<meta name="_csrf_header" content="X-CSRF-Token">
<title>Purple Admin</title>
<!-- plugins:css -->
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
	src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>
<script type="text/javascript">
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
		<div class="container-fluid page-body-wrapper">
			<!-- Header -->
			<%@include file="/WEB-INF/jsp/layout/admin/header.jsp"%>

			<!-- partial -->
			<div class="main-panel">

				<!-- content -->
				<div class="content-wrapper">


					<decorator:body></decorator:body>

				</div>
				<!-- footer -->

				<%@include file="/WEB-INF/jsp/layout/admin/footer.jsp"%>

				<!-- partial -->
			</div>
			<!-- main-panel ends -->
		</div>
	</div>

	<!-- <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script> -->
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
	<script
		src="<c:url value="/assets/admin/vendors/js/vendor.bundle.base.js" />"></script>
	<!-- endinject -->
	<!-- Plugin js for this page -->
	<script
		src='<c:url value="/assets/admin/vendors/chart.js/Chart.min.js" />'></script>
	<script src='<c:url value="/assets/admin/js/jquery.cookie.js"/>'
		type="text/javascript"></script>
	<script src='<c:url value="/assets/admin/js/off-canvas.js"/>'
		type="text/javascript"></script>
	<script src='<c:url value="/assets/admin/js/hoverable-collapse.js"/>'
		type="text/javascript"></script>
	<script src='<c:url value="/assets/admin/js/misc.js"/>'
		type="text/javascript"></script>
	<script src='<c:url value="/assets/admin/js/dashboard.js"/>'
		type="text/javascript"></script>
	<script src='<c:url value="/assets/admin/js/todolist.js"/>'
		type="text/javascript"></script>
	<script type="text/javascript">
		/* alert(100) */
	</script>

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
</body>
</html>