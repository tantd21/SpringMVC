<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<div class="header">
	<div class="videoContainer">
		<video type="video/mp4" autoplay="" muted="" loop="">
			<source src='<c:url value="/assets/web/video/videobanner.mp4"/>' />
			Your browser does not support the video tag.
		</video>

		<div class="ContentInVideo">

			<nav class="navbar">

				<div class="navbar-logo">
					<a class="navbar-item-link" href="{{ url('/') }}"> <img
						style="width: 60px; height: 45px; object-fit: cover;"
						src='<c:url value="/assets/web/iconlogo/logo1.png"/>' alt="">
					</a>
				</div>

				<ul class="navbar-list navbar-list--left">
					<li class="navbar-item res-navbar-item-589"><a
						class="navbar-item-link" href="{{ url('/') }}"> <i
							class="fa-solid fa-house"></i>
					</a> <a class="navbar-item-link res-navbar-item-589"
						href="{{ url('/') }}"><span>Trang Chủ</span></a></li>
					<li class="navbar-item"><a
						class="navbar-item-link res-navbar-item-589"
						href="{{ url('/cua-hang') }}"><span>Shop Coffee</span></a></li>
					<li class="navbar-item res-navbar-item-1230"><a
						class="navbar-item-link" href=""><span>Hệ Thống Cửa
								Hàng</span></a></li>
					<li class="navbar-item res-navbar-item-1297"><a
						class="navbar-item-link" href=""><span>Thông Tin & Sự
								Kiện</span></a></li>
				</ul>

				<ul class="navbar-list navbar-list--right">

					<li class="navbar-item res-navbar-item-1120"><a
						class="navbar-item-link" href=""> <i class="fa-solid fa-gift"></i>
					</a> <a class="navbar-item-link" href="gioithieunhanqua.html"> Giới
							Thiệu Nhận Quà </a></li>
					<li class="navbar-item res-navbar-item-768">
						<%-- <c:if test=""> --%> <%-- </c:if> <a class="navbar-item-link"
							href="{{ url('user/order?customer_id='.session()->get('customer_id').'') }}">
								<i class="fa-solid fa-bus"></i> --%> </a> <!-- @else <a class="navbar-item-link"
							href="{{ url('user/order?customer_id=-1') }}"> <i
								class="fa-solid fa-bus"></i>
						</a> @endif --> <a class="navbar-item-link"
						href="{{ url('user/order?customer_id=-1') }}"> <i
							class="fa-solid fa-bus"></i>
					</a>
					</li>
					<li class="navbar-item res-navbar-item-589"><a
						href="{{ url('/gio-hang') }}" style="cursor: pointer;"
						for="Notification-input" class="navbar-item-link cart"> <i
							class="fa-solid fa-cart-shopping"></i> <span class="count-cart">
								10 </span>
					</a></li>
					<!-- <span class="user_info"> @if (session()->get('customer_id')
							!= null) <label class="navbar-item"> <a
								href="{{ url('user/order?customer_id='.session()->get('customer_id').'') }}">
									<label class="navbar-item-link"> <i
										class="fa-solid fa-user"></i>
								</label> <label class="navbar-item-link"> {{
										session()->get('customer_name') }} </label>
							</a>
						</label> <a href="{{ url('user/logout') }}"> <label
								class="navbar-item"> <label class="navbar-item-link">
										<i class="fa-solid fa-right-from-bracket"></i>
								</label> <label class="navbar-item-link"> Đăng Xuất </label>
							</label>
						</a> @else <label for="nav-login-logout" class="navbar-item">
								<label for="nav-login-logout" class="navbar-item-link">
									<i class="fa-solid fa-user"></i>
							</label> <label for="nav-login-logout" class="navbar-item-link">
									<i class="fa-solid fa-caret-down"></i>
							</label>
						</label> @endif -->
					<label for="nav-login-logout" class="navbar-item"> <label
						for="nav-login-logout" class="navbar-item-link"> <i
							class="fa-solid fa-user"></i>
					</label> <label for="nav-login-logout" class="navbar-item-link"> <i
							class="fa-solid fa-caret-down"></i>
					</label>
					</label>
					</span>
					<li class="navbar-item "><label style="cursor: pointer;"
						for="nav-input" class="navbar-item-link"> <i
							class="fa-solid fa-bars"></i>
					</label></li>
				</ul>

				<input type="checkbox" hidden class="Notification-input-select"
					name="" id="Notification-input"> <label
					class="nooverlay-Notification" for="Notification-input"> </label> <label
					for="Notification-input" class="Notification">
					<div class="Notification-img">
						<img src="assets/img/trangchu/icon_notification_empty.svg" alt="">
					</div>
					<div class="Notification-text">
						<span>Không có thông báo nào!</span>
					</div>
				</label> <input type="checkbox" hidden class="nav-login-logout-select"
					name="" id="nav-login-logout"> <label
					class="nooverlay-login-logout" for="nav-login-logout"> </label>
				<div class="nav-login-logout">
					<div class="nav-login-logout-box">
						<label id="dangnhap" for="input-fromlogin"
							class="nav-login-logout-box-item"> <span
							class="nav-login-logout-box-text">Đăng Nhập</span>
						</label> <label id="dangky" for="input-fromsignup"
							class="nav-login-logout-box-item"> <span
							class="nav-login-logout-box-text">Đăng Ký</span>
						</label>
					</div>
				</div>

				<!-- 	@include('pages.Login_Register.login')
					@include('pages.Login_Register.register')
					@include('pages.Login_Register.verycode')
					@include('pages.Login_Register.recoverypw')
					@include('pages.Login_Register.code_confirmation')
					@include('pages.Login_Register.confirmpassword') -->

				<div class="fromsignup-overlay" id="overlay"></div>

				<input type="checkbox" hidden class="nav-input-select" name=""
					id="nav-input"> <label for="nav-input" class="nav-overlay">
				</label>

				<div class="nav-menu">
					<div class="nav-menu-box">
						<label for="nav-input" class="nav-menu-close"> <i
							class="nav-menu-close fa-solid fa-xmark"></i>
						</label>
						<ul>
							<li class="nav-menu-item"><i style="color: #00b6f3;"
								class="fa-solid fa-house"></i><span class="nav-menu-item-text"><a
									href="{{ url('/') }}">Trang Chủ</a></span></li>
							<li class="nav-menu-item nav-menu-item-boder"><i
								style="color: #00b6f3;" class="fa-solid fa-heart"></i><span
								class="nav-menu-item-text">Yêu Thích</span></li>
							<li class="nav-menu-item"><i style="color: #ffc043;"
								class="fa-solid fa-hotel"></i><span class="nav-menu-item-text">Khách
									Sạn</span></li>
							<li class="nav-menu-item"><i style="color: #ff2890;"
								class="fa-solid fa-plane"></i><span class="nav-menu-item-text">Vé
									Máy Bay</span></li>
							<li class="nav-menu-item"><i style="color: #ff2890;"
								class="fa-solid fa-hand-holding-heart"></i><span
								class="nav-menu-item-text">The Memories</span></li>
							<li class="nav-menu-item"><i style="color: #00b6f3;"
								class="fa-solid fa-briefcase"></i><span
								class="nav-menu-item-text">Tour & Sự Kiện</span></li>
							<li class="nav-menu-item nav-menu-item-boder"><i
								style="color: #48bb78;" class="fa-solid fa-book"></i><span
								class="nav-menu-item-text">Cẩm Năng Du Lịch</span></li>
							<li class="nav-menu-item"><i style="color: #00b6f3;"
								class="fa-solid fa-briefcase"></i><span
								class="nav-menu-item-text">Tuyển Dụng</span></li>
							<li class="nav-menu-item"><i style="color: #00b6f3;"
								class="fa-solid fa-headphones-simple"></i><span
								class="nav-menu-item-text">Hỗ Trợ</span></li>
							<li class="nav-menu-item nav-menu-item-boder"><i
								style="color: #00b6f3;" class="fa-solid fa-sack-dollar"></i><span
								class="nav-menu-item-text">Trở Thành Đối Tác Liên Kết</span></li>
							<li class="nav-menu-item"><i style="color: #00b6f3;"
								class="fa-solid fa-handshake"></i><span
								class="nav-menu-item-text">Hợp Tác Với Chúng Tôi</span></li>
							<li class="nav-menu-item"><i style="color: #00b6f3;"
								class="fa-solid fa-mobile"></i><span class="nav-menu-item-text">Tải
									Ứng Dụng MyHotel</span></li>
							<li class="nav-menu-item"><i style="color: #00b6f3;"
								class="fa-solid fa-share-nodes"></i><span
								class="nav-menu-item-text">Giới Thiệu Bạn Bè</span></li>
						</ul>
					</div>
				</div>
			</nav>

			<input type="checkbox" name="" hidden class="input_suports_select"
				id="input_suports"> <label for="input_suports"
				class="suportsone">
				<div class="suportsone-layout">
					<div class="suportsone-title">
						<span>Hỗ Trợ & Tư Vấn</span>
					</div>
					<div class="suportsone-icon">
						<span><i class="fa-solid fa-angle-up"></i></span>
					</div>
				</div>
			</label>
			<div class="suportstwo">
				<label for="input_suports" class="suportstwo-top">
					<div class="suportstwo-layout">
						<div class="suportsone-title">
							<span>Hỗ Trợ & Tư Vấn</span>
						</div>
						<div class="suportsone-icon">
							<i class="fa-solid fa-angle-down"></i>
						</div>
					</div>
				</label>
				<div class="suportstwo-header">
					<div class="suportstwo-header-box">
						<div class="suportstwo-header-icon">
							<i style="color: #ff3366; font-size: 20px;"
								class="fa-solid fa-headphones-simple"></i>
						</div>
						<div class="suportstwo-header-name">
							<div class="suportstwo-header-name-top">
								<span>Nguyễn Văn Vĩnh Nguyên</span>
							</div>
							<div class="suportstwo-header-name-bottom">
								<span>Chuyên viên CSKH</span>
							</div>
						</div>
						<div class="suportstwo-header-feel">
							<div class="suportstwo-header-feel-like">
								<i class="suportstwo-header-feel-like fa-solid fa-thumbs-up"></i>
							</div>
							<div class="suportstwo-header-feel-dislike">
								<i
									class="suportstwo-header-feel-dislike fa-solid fa-thumbs-down"></i>
							</div>
						</div>
					</div>
				</div>
				<div class="suportstwo-content">
					<div class="suportstwo-content-img">
						<img style="object-fit: cover;" src="assets/img/trangchu/cskh.png"
							alt="">
					</div>
					<div class="suportstwo-content-text">
						<span> Xin chào <b>Quý khách!</b> <br> mình là <b>Nguyên
								Vĩnh</b>, chuyên viên <br> chăm sóc khách hàng. mình có thể
							giúp gì <br> được cho bạn?
						</span>
					</div>
				</div>
				<div class="suportstwo-end">
					<div class="suportstwo-end-box">
						<div class="suportstwo-end-box-text">Chát Ngay Bây Giờ!</div>
					</div>
				</div>
			</div>

			<div class="BoxSearch">

				<div class="BoxSearch-title">
					<ul class="BoxSearch-list">
						<li class="BoxSearch-item"><span class="BoxSearch-link"
							href=""><i class="fa-solid fa-mug-saucer"></i></span> <span
							class="BoxSearch-link" href="">Tìm Kiếm Tên Sản Phẩm</span></li>
					</ul>
				</div>

				<div class="BoxSearch-Bottom">
					<div class="BoxSearch-Bottom-One">
						<div class="BoxSearch-Bottom-One-Title">Nhập dô để tìm kiếm!</div>
						<form class="BoxSearch-Bottom-One-Input">
							<input class="BoxSearch-Bottom-One-input-size" type="text"
								placeholder="Cà phê, trà sữa,...">
							<div class="inputsearchhotel"></div>
						</form>
					</div>
					<a href="thongtinkhachsan.html">
						<div class="BoxSearch-Bottom-BtnSrearch">
							<div class="BoxSearch-Bottom-BtnSrearch-Box">
								<i
									class="fa-solid fa-magnifying-glass BoxSearch-Bottom-BtnSrearch-Box-Icon"></i>
							</div>
						</div>
					</a>
				</div>
			</div>
		</div>
	</div>
</div>

