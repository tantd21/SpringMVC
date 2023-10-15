<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!--<?php
    $recentlyviewed = session()->get('recentlyviewed');
    ?>
	@if ($recentlyviewed != null)
	<div class="recentlyviewed">
		<div class="recentlyviewed_box">
			<div class="recentlyviewed_title">
				<span class="recentlyviewed_title">Xem Gần Đây</span>
			</div>

			<div class="recentlyviewed_boxcontent-boxslider">
				<div class="recentlyviewed_boxcontent owl-carousel owl-theme">

					@foreach ($recentlyviewed as $key => $product) <a
						href="{{ url('/san-pham/san-pham-chi-tiet?product_id='.$product['product_id'].'') }}"
						class="flashsalehotel_boxcontent_hover">
						<div class="flashsalehotel_boxcontent item">
							<div class="flashsalehotel_boxcontent_img_text">
								<div class="flashsalehotel_img-box">
									<img class="flashsalehotel_img" width="284px" height="160px"
										style="object-fit: cover;"
										src="{{ url('public/fontend/assets/img/product/'.$product['product_image'].'') }}"
										alt="">

								</div>
								<div class="flashsalehotel_text">
									<div class="flashsalehotel_text-title">{{
										$product['product_name'] }}</div>


									<div class="flashsalehotel_text-time">
										<i class="fa-solid fa-certificate"></i> {{
										$product['category_name'] }}
									</div>
									<div class="flashsalehotel_place">
										{{--
										<div>
											<i class="fa-solid fa-certificate"></i> Danh Mục Sản Phẩm
										</div>
										--}}
									</div>
									{{--
									<div class="flashsalehotel_text-box-price">
										--}} {{--
										<div class="flashsalehotel_text-box-price-two">
											<span>874.070đ</span>
										</div>
										<div class="flashsalehotel_text-box-price-three bordernhay">
											<div style="margin-left: 8px;"
												class="flashsalehotel_text-box-price-three-l chunhay">
												<div class="cart-hover">
													<i class="fa-solid fa-heart"></i> <span
														style="font-size: 14px;">Yêu Thích</span>
												</div>
											</div>
											<div class="flashsalehotel_text-box-price-three-r chunhay">
												<div class="cart-hover">
													<i class="fa-solid fa-cart-shopping"></i> <span
														style="font-size: 14px;">Đặt Hàng</span>
												</div>
											</div>
										</div>
										--}} {{--
									</div>
									--}}
								</div>
							</div>
						</div>
					</a> @endforeach


				</div>
			</div>

		</div>
	</div>

	@endif -->

<div class="infohotel">
		<div class="BoxNhapSDT">
			<div class="BoxNhapSDT-left">
				<div class="BoxNhapSDT-left-img">
					<img src="assets/img/trangchu/icon_mail_red.svg" alt="">
				</div>
				<div class="BoxNhapSDT-left-text">
					<div class="BoxNhapSDT-left-text-title">
						<span>Bạn muốn tiết kiện 50% khi đặt hải sản ?</span>
					</div>
					<div class="BoxNhapSDT-left-text-content">
						<span>Nhập số điện thoại để Thế Giới Hải Sản có thể gửi đến
							bạn những chương trình khuyến mại mới nhất!</span>
					</div>
				</div>
			</div>
			<div class="BoxNhapSDT-right">
				<div class="BoxNhapSDT-right-Groupinput">
					<div class="BoxNhapSDT-right-input">
						<input type="text" placeholder="Nhập số điện thoại">
					</div>
					<label class="BoxNhapSDT-right-lable" for=""> <span>Đăng
							ký</span>
					</label>
				</div>
			</div>
		</div>
		<div class="infohotel-box">
			<div class="infohotel_logo">
				<!-- <img width="90px" height="55px" style="object-fit: cover;"
					src="{{ asset('public/fontend/assets/img/config/' . $config_logo_web->config_image) }}"
					alt=""> -->
					 <img width="90px" height="55px" style="object-fit: cover;"
					src='<c:url value="/assets/web/img/config/logo178.png"/>' alt=""> 
			</div>
			<div class="infohotel_content">
				<div class="infohotel_content_box">
					<div class="infohotel_content_title">{{
						$company_config->company_name }}</div>
					<div class="infohotel_content_text">
						Tổng đài chăm sóc: {{ $company_config->company_hostline }} <br>
						Email: {{ $company_config->company_mail }} <br> Văn phòng Đà
						Nẵng: {{ $company_config->company_address }} <br>
					</div>
				</div>
				<div class="infohotel_content_box">
					<div class="infohotel_content_title">Chính sách & Quy định</div>
					<div class="infohotel_content_text">
						Điều khoản và điều kiện <br> Quy định về thanh toán <br>
						Chính sách bảo mật thông tin <br> Quy chế hoạt động <br>
						Quy trình giải quyết tranh chấp, khiếu nại <br>
					</div>
				</div>
				<div class="infohotel_content_box">
					<div class="infohotel_content_title">Khách hàng và đối tác</div>
					<div class="infohotel_content_text">
						Đăng nhập HMS <br> Tuyển dụng <br> Liên hệ <br>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="footer">
		<div class="footer-content">
			<div class="footer-content">{{ $company_config->company_slogan
				}} {{-- BonoDrinks - Drinks Coffee and Chilling with Mucsic --}}</div>
			<div class="footer-content">
				<!-- @foreach ($config_brand_web as $brand) <a
					href="{{ $brand->config_content }}" target="_blank"><img
					width="100px" height="70px"
					style="border-radius: 8px; object-fit: cover; margin: 15px"
					src="{{ asset('public/fontend/assets/img/config/' . $brand->config_image) }}"
					alt=""></a> @endforeach -->
					
					<c:forEach begin="1" end="5">
					
					<a
					href="{{ $brand->config_content }}" target="_blank"><img
					width="100px" height="70px"
					style="border-radius: 8px; object-fit: cover; margin: 15px"
					src="{{ asset('public/fontend/assets/img/config/' . $brand->config_image) }}"
					alt=""></a> 
					
					</c:forEach>
			</div>
			<div class="footer-content">{{
				$company_config->company_copyright }} {{-- Copyright © 2022 - Đồ Án
				Cơ Sở 2 - Đề Tài Website Thương Mai BonoDrinks - Nguyễn Văn Vĩnh
				Nguyên - Trương Thanh Tùng - Website Bắt Đầu Thực Hiện Vào Ngày
				16/10 --}}</div>
		</div>
	</div>