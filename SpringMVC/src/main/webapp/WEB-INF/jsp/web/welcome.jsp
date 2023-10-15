<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="spring.mvc.Until.Until"%>
<%
// Tạo một đối tượng Until
int price = 1000; // Số bạn muốn định dạng
String formattedPrice = Until.convertNumber(price); // Gọi method và lưu kết quả vào biến
%>
<body>
	<div class="slider">
		<div class="slider-box">
			<div class="slider-js owl-carousel owl-theme">
				<c:forEach items="${sliders}" var="slider">
					<div class="item">
						<img width="465px" height="195px"
							style="object-fit: cover; border-radius: 8px;"
							src='<c:url value="/assets/web/img/slider/${slider.slider_image}"/>'
							alt="${ slider.slider_name }" />
					</div>
				</c:forEach>


			</div>
		</div>
	</div>

	<div class="container">
		<div class="boxcontent">
			<!-- {{--
			<div class="boxcontent-layout">
				<div class="boxcontent-img">
					<img
						src="{{ asset('public/fontend/assets/img/icon/icon_total_hotel.svg')}}"
						alt="">
				</div>
				<div class="boxcontent-text">
					<div class="boxcontent-text-one">Hơn 10+ loại cà phê</div>
					<div class="boxcontent-text-two">Thức uống của chúng tôi cho
						phép bạn thoải mái lựa chọn,phong phú.</div>
				</div>
			</div>
			--}}  -->

			<c:forEach items="${ config_webs }" var="config">
				<div class="boxcontent-layout">
					<div class="boxcontent-img">
						<img
							src='<c:url value="/assets/web/img/config/${ config.config_image }"/>'
							alt="" />
					</div>
					<div class="boxcontent-text">
						<div class="boxcontent-text-one">${config.config_title}</div>
						<div class="boxcontent-text-two">${config.config_content}${ Until.productReviewList.size() }
						</div>
					</div>
				</div>
			</c:forEach>

		</div>
	</div>

	<hr width="80%" style="">

	<div class="contentflashsale">

		<div class="contentboxflashsale">
			<div class="flashsaletop-content">
				<div class="flashsaletop-left">
					<div class="flashsaletop-left-img">
						<img style="object-fit: cover;" width="198px" height="44px"
							src='<c:url value="/assets/web/img/icon/icon_flashSale_home_white_new.png"/>'
							alt="" />
					</div>
					<div class="flashsaletop-left-text chunhay">Chương trình sẽ
						diễn ra trong : 2 ngày</div>
				</div>
			</div>

			<div class="flashsaletop-right-content">

				<div class="flashsaletop-right">
					<div class="flashsaletop-right-top">Đang diễn ra</div>
					<div class="flashsaletop-right-bottom">Trong 6 tháng</div>
				</div>

			</div>
		</div>

		<div class="flashsalehotel-card-box">
			<div class="flashsalehotel flashsalehotel-js owl-carousel owl-theme">


				<!-- @foreach ($dataProduct_flashsale as $key => $flashsale) -->
				<c:forEach items="${ flashsales }" var="flashsale">

					<div class="flashsalehotel_boxcontent item">
						<div class="flashsalehotel_boxcontent_img_text">
							<div class="flashsalehotel_img-box">
								<a
									href="/SpringMVC/cua-hang/san-pham/san-pham-chi-tiet?product_id=${ flashsale.product.product_id }"
									class="flashsalehotel_boxcontent_hover"> <img
									class="flashsalehotel_img" width="284px" height="160px"
									style="object-fit: cover;"
									src='<c:url value="/assets/web/img/product/${ flashsale.product.product_image }"/>'
									alt="" />

								</a>
							</div>
							<div class="flashsalehotel_text">
								<div class="flashsalehotel_text-title">${ flashsale.product.product_name }</div>
								<div class="flashsalehotel_place">
									<div>
										<i class="fa-solid fa-certificate"></i>
										${flashsale.product.category_name}
									</div>
								</div>

								<div class="flashsalehotel_text-time">Giảm giá</div>
								<div class="flashsalehotel_text-box-price">
									<div style="display: flex;">
										<div class="flashsalehotel_text-box-price-two">
											<span>${ Until.convertNumber(flashsale.flashsale_price_sale) }đ</span>
										</div>
										<div class="flashsalehotel_text-box-price-one">
											<span>/</span>
										</div>
										<div class="flashsalehotel_text-box-price-one">
											<span style="text-decoration: line-through">${ Until.convertNumber(flashsale.product.product_price) }đ</span>
										</div>
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
											<div class="cart-hover" data-toggle="modal"
												data-target="#shopping"
												data-product_id="${ flashsale.product.product_id }">
												<i class="fa-solid fa-cart-shopping"></i> <span
													style="font-size: 14px;">Đặt Hàng</span>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>

				<!-- 	@endforeach -->

			</div>
		</div>
	</div>
	<!-- {{--
	<hr width="80%" style="margin-top: 30px;" align="center">
	--}}	 -->
	<div class="hottelcodesale">
		<div class="hottelcodesale_box">
			<div class="hottelcodesale_box-title">
				<span class="hottelcodesale_box-title">Mã giảm giá cho bạn</span>
			</div>

			<div class="hottelcodesale_box-content">
				<!-- @foreach ($dataCoupon as $key => $coupon) -->
				<c:forEach items="${ coupons }" var="coupon">


					<div class="hottelcodesale_box-content-left">
						<div class="hottelcodesale_box-content-left-content1">
							<div class="hottelcodesale_box-content-left-content1-text">
								<span>Nhập mã </span>
							</div>
							<div class="hottelcodesale_box-content-left-content1-block">
								<span>${ coupon.coupon_name }</span>
							</div>
						</div>
						<div class="hottelcodesale_box-content-left-content2">
							<div class="hottelcodesale_box-content-left-content2-l">
								<span>${ coupon.coupon_desc }</span>
							</div>
							<div class="hottelcodesale_box-content-left-content2-r">
								<span class="hottelcodesale_box-content-left-content2-r">Điều
									kiện và thể lệ chương trình</span>
							</div>
						</div>
						<div class="hottelcodesale_box-content-left-content3">
							<span class="hottelcodesale_box-content-left-content3">Từ
								Ngày ${ coupon.coupon_date_start } đến ${ coupon.coupon_date_end }
								| Nhập mã trước khi thanh toán</span>
						</div>
					</div>
				</c:forEach>
				<!-- @endforeach {{--
				<div class="hottelcodesale_box-content-right">
					<div class="hottelcodesale_box-content-left-content1">
						<div class="hottelcodesale_box-content-left-content1-text">
							<span>Nhập mã </span>
						</div>
						<div class="hottelcodesale_box-content-left-content1-block">
							<span>HELLOVKU</span>
						</div>
					</div>
					<div class="hottelcodesale_box-content-left-content2">
						<div class="hottelcodesale_box-content-left-content2-l">
							<span>Voucher ưu đãi cho sinh viên VKU</span>
						</div>
						<div class="hottelcodesale_box-content-left-content2-r">
							<span class="hottelcodesale_box-content-left-content2-r">Điều
								kiện và thể lệ chương trình</span>
						</div>
					</div>
					<div class="hottelcodesale_box-content-left-content3">
						<span class="hottelcodesale_box-content-left-content3">Hạn
							sử dụng 30/5-1/6 | Nhập mã trước khi thanh toán</span>
					</div>
				</div>
				--}} -->

			</div>
		</div>
	</div>

	<div class="hottelprices">
		<div class="hottelpricesbox">
			<div class="hottelpricesbox-contenttop">
				<div class="hottelpricesbox-contenttop-title">
					<div class="hottelpricesbox-contenttop-title">
						<!-- {{--
						<hr width="50%">
						--}} -->
						<h3>THE MILKTEA.</h3>
						<p>We scoured the world to find the best coffees a home.
							Yours.</p>

						<!-- 	<hr width="70%" align="center" height="20%">
					 -->
					</div>
				</div>

			</div>
			<div class="hottelpricesbox-contentbottom">
				<div class="layout_seafood">


					<div
						class="hottelpricesbox-contentbottom-layout hottelpricesbox-js owl-carousel owl-theme">
						<!-- @foreach ($dataProduct as $key => $product) -->
						<c:forEach items="${ productPopulars }" var="product">


							<div class="flashsalehotel_boxcontent item">
								<div class="flashsalehotel_boxcontent_img_text">
									<div class="flashsalehotel_img-box">
										<a
											href="/SpringMVC/cua-hang/san-pham/san-pham-chi-tiet?product_id= ${ product.product_id }"
											class="flashsalehotel_boxcontent_hover"> <img
											class="flashsalehotel_img" width="284px" height="160px"
											style="object-fit: cover;"
											src='<c:url value="/assets/web/img/product/${ product.product_image }"/>'
											alt="" />

										</a>
									</div>
									<div class="flashsalehotel_text">
										<div class="flashsalehotel_text-title">${ product.category_name }</div>
										<div class="flashsalehotel_place">
											<div>
												<i class="fa-solid fa-certificate"></i> ${
											product.product_name }
											</div>
										</div>

										<div class="flashsalehotel_text-time">Bán chạy</div>
										<div class="flashsalehotel_text-box-price">
											<c:if test="${ product.flashsale_status == 0 }">

												<div class="flashsalehotel_text-box-price-two">
													<span>${ Until.convertNumber(product.product_price) }đ</span>
												</div>
											</c:if>
											<c:if test="${ product.flashsale_status == 1 }">
												<div style="display: flex;">
													<div class="flashsalehotel_text-box-price-two">
														<span>${ Until.convertNumber(product.flashsale.flashsale_price_sale) }đ</span>
													</div>
													<div class="flashsalehotel_text-box-price-one">
														<span>/</span>
													</div>
													<div class="flashsalehotel_text-box-price-one">
														<span style="text-decoration: line-through">${ Until.convertNumber(product.product_price) }đ</span>
													</div>
												</div>
											</c:if>
											<div class="flashsalehotel_text-box-price-three bordernhay">
												<div style="margin-left: 8px;"
													class="flashsalehotel_text-box-price-three-l chunhay">
													<div class="cart-hover">
														<i class="fa-solid fa-heart"></i> <span
															style="font-size: 14px;">Yêu Thích</span>
													</div>
												</div>
												<div class="flashsalehotel_text-box-price-three-r chunhay">
													<div class="cart-hover" data-toggle="modal"
														data-target="#shopping"
														data-product_id="${ product.product_id }">
														<i class="fa-solid fa-cart-shopping"></i> <span
															style="font-size: 14px;">Đặt Hàng</span>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>

					</div>

				</div>

				<div class="button-see-more">

					<a href="/SpringMVC/cua-hang" class="btn-all-product">See more</a>
				</div>
				<div class="button-dang-nhap">

					<a href="/SpringMVC/dang-nhap" class="btn-all-product">đăng nhập</a>
				</div>
			</div>
		</div>
	</div>




	<c:if test="${ Until.productReviewList.size() != 0 }">
		<div class="recentlyviewed">
			<div class="recentlyviewed_box">
				<div class="recentlyviewed_title">
					<span class="recentlyviewed_title">Xem Gần Đây</span>
				</div>

				<div class="recentlyviewed_boxcontent-boxslider">
					<div class="recentlyviewed_boxcontent owl-carousel owl-theme">

						<c:forEach items="${ Until.productReviewList }" var="item">
							<a
								href="/cua-hang/san-pham/san-pham-chi-tiet?product_id= ${ item.product_id }"
								class="flashsalehotel_boxcontent_hover">
								<div class="flashsalehotel_boxcontent item">
									<div class="flashsalehotel_boxcontent_img_text">
										<div class="flashsalehotel_img-box">
											<img class="flashsalehotel_img" width="284px" height="160px"
												style="object-fit: cover;"
												src='<c:url value="/assets/web/img/product/${ item.product_image }"/>'
												"
										alt="" />

										</div>
										<div class="flashsalehotel_text">
											<div class="flashsalehotel_text-title">${ item.product_name }</div>


											<div class="flashsalehotel_text-time">
												<i class="fa-solid fa-certificate"></i> ${ item.category_name }
											</div>
											<div class="flashsalehotel_place">
												<!-- {{--
										<div>
											<i class="fa-solid fa-certificate"></i> Danh Mục Sản Phẩm
										</div>
										--}} -->
											</div>
											<!-- {{--
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
									--}} -->
										</div>
									</div>
								</div>
							</a>
						</c:forEach>


					</div>
				</div>

			</div>
		</div>
	</c:if>

	<!--	@endif


	<div class="inspiration">
		<div class="inspiration-box">
			<div class="inspiration-box-top">
				<div class="inspiration-box-top-title">
					<span>Có Thể Bạn Đã Biết</span>
				</div>
				<div class="inspiration-box-top-text">
					<span>Coffee chill, chia sẽ kinh nghiệm và những câu chuyện
						thú vị đang chờ đón bạn</span>
				</div>
			</div>
			<div class="row mt-4">
				<div class="col-lg-6 col-md-12 col-sm-12">
					<a
						href="{{ url('/newsPageContent?id_news='.$new_big->id_news.'') }}">
						<div class="inspiration-box-bottom-left-zoom">
							<div class="inspiration-box-bottom-left-img">

								<img width="586px" height="380px"
									style="object-fit: cover; border-radius: 8px;"
									src="{{ $new_big->news_image }}" alt="">
							</div>
						</div>
						<div class="inspiration-box-bottom-left-text">
							<span>{{ $new_big->news_title }}</span>
						</div>
					</a>
				</div>
				<div class="col-lg-6 col-md-12 col-sm-12">
					<!-- <div class=" inspiration-box-bottom-right"> 
					<div class="row">
						@foreach ($new_smalls as $value) <a
							href="{{ url('/newsPageContent?id_news='.$value->id_news.'') }}"
							class="col-sm-6 ms-1">
							<div class="inspiration-box-bottom-right-item ms-1">
								<div class="inspiration-box-bottom-right-item-zoom">
									<div class="inspiration-box-bottom-right-item-img">
										<img width="285px" height="152px"
											style="object-fit: cover; border-radius: 8px;"
											src="{{ $value->news_image }}" alt="">
									</div>
								</div>
								<div class="inspiration-box-bottom-right-item-text">
									<span>{{ $value->news_title }}</span>
								</div>
							</div>
						</a> @endforeach {{--
					</div>
					--}} {{--
					<div class="row mt-2">
						--}} {{-- <a href="" class="col-sm-6">
							<div class="inspiration-box-bottom-right-item ms-1">
								<div class="inspiration-box-bottom-right-item-zoom">
									<div class="inspiration-box-bottom-right-item-img">
										<img width="285px" height="152px"
											style="object-fit: cover; border-radius: 8px;" src="" alt="">
									</div>
								</div>
								<div class="inspiration-box-bottom-right-item-text">
									<span>Chủ nhật xanh - Giảm giá 10%</span>
								</div>
							</div>
						</a> <a href="" class="col-sm-6">
							<div class="inspiration-box-bottom-right-item">
								<div class="inspiration-box-bottom-right-item-zoom">
									<div class="inspiration-box-bottom-right-item-img">
										<img width="285px" height="152px"
											style="object-fit: cover; border-radius: 8px;" src="" alt="">
									</div>
								</div>
								<div class="inspiration-box-bottom-right-item-text">
									<span>"Hi-tea" thức uống tốt cho sức khỏe</span>
								</div>
							</div>
						</a> <a href="" class="col-sm-6">
							<div class="inspiration-box-bottom-right-item">
								<div class="inspiration-box-bottom-right-item-zoom">
									<div class="inspiration-box-bottom-right-item-img">
										<img width="285px" height="152px"
											style="object-fit: cover; border-radius: 8px;" src="" alt="">
									</div>
								</div>
								<div class="inspiration-box-bottom-right-item-text">
									<span>"Hi-tea" thức uống tốt cho sức khỏe</span>
								</div>
							</div>
						</a> --}}
					</div>
					<!-- </div> 
				</div>
			</div>
		</div>
	</div> -->
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script>
		$(document).on('click', '.cart-hover', function() {
			$('.modal').addClass('loading_product');
			var product_id = $(this).data('product_id');
			/* alert(product_id) */

			$("input[name='size']").click(function() {
				$('.button_cart').attr('data-dismiss', 'modal');
			});

			$.ajax({
				url : '/SpringMVC/watch-product',
				method : 'POST',
				data : {
					product_id : product_id
				},
				success : function(data) {
					$('.modal .modal-body').html(data);
					$('.modal .button_cart').attr('data-dismiss', '');
					$("input[name='size']").click(function() {
						$('.modal .button_cart').attr('data-dismiss', 'modal');
					});
					// $(this).attr('data-target', '#shopping');
					$('.modal').removeClass('loading_product');
				},
				error : function() {
					alert("Ngu sửa Bug đi con Huhu :<<");
				}
			})
		})
	</script>
</body>

