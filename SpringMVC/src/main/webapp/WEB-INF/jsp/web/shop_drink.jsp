<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="spring.mvc.Until.Until"%>
<body>
	<link rel="stylesheet"
		href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css"
		integrity="sha384-r4NyP46KrjDleawBgD5tp8Y7UzmLA05oM1iAEQ17CSuDqnUK2+k9luXQOfXJCJ4I"
		crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<link rel="stylesheet"
		href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
		integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
		crossorigin="anonymous" referrerpolicy="no-referrer" />

	<link rel="stylesheet"
		href='<c:url value="/assets/web/css/trangchu.css" />'>
	<link rel="stylesheet"
		href='<c:url value="/assets/web/css/resTrangchu.css" />'>
	<link rel="stylesheet"
		href='<c:url value="/assets/web/css/danhmuc.css" />'>

	<link rel="stylesheet"
		href="  https://cdn.jsdelivr.net/npm/pretty-checkbox@3.0/dist/pretty-checkbox.min.css">
	<!-- {{-- jquery --}} -->
	<!-- <script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"
		integrity="sha512-aVKKRRi/Q/YV+4mjoKBsE4x3H+BkegoM/em46NNlCqNTmUYADjBbeNefNxYV7giUp0VxICtqdrbqU7iVaeZNXA=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script> -->
	<link rel="stylesheet"
		href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.css">

	<link rel="stylesheet"
		href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.13.2/themes/base/jquery-ui.min.css"
		integrity="sha512-ELV+xyi8IhEApPS/pSj66+Jiw+sOT1Mqkzlh8ExXihe4zfqbWkxPRi8wptXIO9g73FSlhmquFlUOuMSoXz5IRw=="
		crossorigin="anonymous" referrerpolicy="no-referrer" />

	<div class="container-1">
		<div class="row show-all-product">
			<div class="col-md-3 category-menu leftSidebar">
				<div class="hello theiaStickySidebar">
					<span>The BoNoDrinks ${ products.size() }</span>
					<div class="box-search">
						<!-- <span>Tìm kiếm sản phẩm</span> -->
						<div class="box-search-item">
							<input id="input" class="search-input" type="text"
								placeholder="Tìm kiếm">
							<button id="search-btn" class="btn-search">
								<i class="fa-solid fa-microphone"></i>
							</button>
						</div>
					</div>

					<div class="filter_content">
						<div class="filter_content_box">
							<div style="display: flex;" class="filter_content_title">
								<div>Khoảng Giá</div>
								<div>
									<input type="text" id="amount" readonly
										style="border: 0; color: #f6931f; font-weight: bold; width: 110px; margin-left: 4px;">
								</div>
							</div>
							<div style="" id="slider-range"></div>
							<!-- <p>
                                                <label for="amount">Price range:</label>
                                                <input type="text" id="amount" readonly style="border:0; color:#f6931f; font-weight:bold;">
                                              </p>
                                               
                                              <div id="slider-range"></div> -->


						</div>

						<div class="option_filter_box">
							<select name="" id="option-filter">
								<option value="ASC" data-type="product_id">Chọn bộ lọc</option>
								<option value="DESC" data-type="product_price">Giá Giảm
									Dần</option>
								<option value="ASC" data-type="product_price">Giá Tăng
									Dần</option>
								<option value="ASC" data-type="product_name">Sắp xếp
									A-Z</option>
								<option value="DESC" data-type="product_name">Sắp xếp
									Z-A</option>

							</select>
						</div>

					</div>



					<!-- <ul class="category">
                                        <li class="category-item active"><a >Tất cả</a></li>
                                        <li class="category-item "><a >Cà phê</a></li>
                                        <li class="category-item "><a >Trà</a></li>
                                        <li class="category-item "><a >CloudFee</a></li>
                                        <li class="category-item "><a >CouldTea</a></li>
                                    </ul> -->

					<div class="category">
						<div class="category-list">

							@foreach ($dataCategory as $category)
							<div class="category-item">
								<input type="checkbox" name="category" class="action"
									id="category-item-{{ $category->category_id }}"
									data-category_id="{{ $category->category_id }}"> <label
									for="category-item-{{ $category->category_id }}">{{
									$category->category_name }}</label>
							</div>
							@endforeach {{--
							<div class="category-item">
								<input type="checkbox" name="category" id="category-item-5">
								<label for="category-item-5">Hi tea</label>

							</div>
							<div class="category-item">
								<input type="checkbox" name="category" id="category-item-5">
								<label for="category-item-5">Hi tea</label>

							</div>
							<div class="category-item">
								<input type="checkbox" name="category" id="category-item-5">
								<label for="category-item-5">Hi tea</label>

							</div>
							--}}
						</div>
					</div>


					<select name="" id="option-category">
						<option value="">Tất cả</option> @foreach ($dataCategory as
						$category)
						<option value="{{ $category->category_id }}">{{
							$category->category_name }}</option> @endforeach


					</select>
				</div>
			</div>
			<div class="col-md-9 all-product rightSidebar">

				<div class="row g-3 list-product loading-1 theiaStickySidebar">
					<div class="col-lg-4 col-md-6 col-sm-6">
						<a href="/thongtinkhachsan.html"
							class="flashsalehotel_boxcontent_hover">
							<div class="flashsalehotel_boxcontent item">
								<div class="flashsalehotel_boxcontent_img_text">
									<div class="flashsalehotel_img-box">
										<img class="flashsalehotel_img" width="284px" height="160px"
											style="object-fit: cover;"
											src="https://product.hstatic.net/1000075078/product/bg-cloudfee-roasted-almond_ac9a236a27274a568ac6c8630047859f_large.jpg"
											alt="">
										<!-- <span class="new">New</span> -->
									</div>
									<div class="flashsalehotel_text">
										<div class="flashsalehotel_text-title">
											<span>Tên Hải Sản</span>
										</div>
										<div class="flashsalehotel_place">
											<div>
												<i class="fa-solid fa-certificate"></i> Danh Mục Sản Phẩm
											</div>
										</div>
										<!-- <div class="flashsalehotel_text-evaluate">
                                                              <div class="flashsalehotel_text-evaluate-icon">
                                                                  <i class="fa-solid fa-star"></i>8.5
                                                              </div>
                                                              <div class="flashsalehotel_text-evaluate-text">
                                                                  Tuyệt vời <span style=" color:#4a5568;">(425 đánh giá)</span>
                                                              </div>
                                                          </div> -->
										<div class="flashsalehotel_text-time">
											<span>Sản phẩm mới</span>
										</div>
										<div class="flashsalehotel_text-box-price">
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
										</div>
									</div>
								</div>
							</div>
						</a>
					</div>

					<div class="col-lg-4 col-md-6 col-sm-6 ">
						<a href="/thongtinkhachsan.html"
							class="flashsalehotel_boxcontent_hover">
							<div class="flashsalehotel_boxcontent item">
								<div class="flashsalehotel_boxcontent_img_text">
									<div class="flashsalehotel_img-box">
										<img class="flashsalehotel_img" width="284px" height="160px"
											style="object-fit: cover;"
											src="https://product.hstatic.net/1000075078/product/bg-cloudfee-roasted-almond_ac9a236a27274a568ac6c8630047859f_large.jpg"
											alt="">
										<!-- <span class="new">New</span> -->
									</div>
									<div class="flashsalehotel_text">
										<div class="flashsalehotel_text-title">
											<span>Tên Hải Sản</span>
										</div>
										<div class="flashsalehotel_place">
											<div>
												<i class="fa-solid fa-certificate"></i> Danh Mục Sản Phẩm
											</div>
										</div>
										<!-- <div class="flashsalehotel_text-evaluate">
                                                              <div class="flashsalehotel_text-evaluate-icon">
                                                                  <i class="fa-solid fa-star"></i>8.5
                                                              </div>
                                                              <div class="flashsalehotel_text-evaluate-text">
                                                                  Tuyệt vời <span style=" color:#4a5568;">(425 đánh giá)</span>
                                                              </div>
                                                          </div> -->
										<div class="flashsalehotel_text-time">
											<span>Sản phẩm mới</span>
										</div>
										<div class="flashsalehotel_text-box-price">
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
										</div>
									</div>
								</div>
							</div>
						</a>
					</div>

					<div class="col-lg-4 col-md-6 col-sm-6 ">
						<a href="/thongtinkhachsan.html"
							class="flashsalehotel_boxcontent_hover">
							<div class="flashsalehotel_boxcontent item">
								<div class="flashsalehotel_boxcontent_img_text">
									<div class="flashsalehotel_img-box">
										<img class="flashsalehotel_img" width="284px" height="160px"
											style="object-fit: cover;"
											src="https://product.hstatic.net/1000075078/product/bg-cloudfee-roasted-almond_ac9a236a27274a568ac6c8630047859f_large.jpg"
											alt="">
										<!-- <span class="new">New</span> -->
									</div>
									<div class="flashsalehotel_text">
										<div class="flashsalehotel_text-title">
											<span>Tên Hải Sản</span>
										</div>
										<div class="flashsalehotel_place">
											<div>
												<i class="fa-solid fa-certificate"></i> Danh Mục Sản Phẩm
											</div>
										</div>
										<!-- <div class="flashsalehotel_text-evaluate">
                                                              <div class="flashsalehotel_text-evaluate-icon">
                                                                  <i class="fa-solid fa-star"></i>8.5
                                                              </div>
                                                              <div class="flashsalehotel_text-evaluate-text">
                                                                  Tuyệt vời <span style=" color:#4a5568;">(425 đánh giá)</span>
                                                              </div>
                                                          </div> -->
										<div class="flashsalehotel_text-time">
											<span>Sản phẩm mới</span>
										</div>
										<div class="flashsalehotel_text-box-price">
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
										</div>
									</div>
								</div>
							</div>
						</a>
					</div>

					<div class="col-lg-4 col-md-6 col-sm-6 ">
						<a href="/thongtinkhachsan.html"
							class="flashsalehotel_boxcontent_hover">
							<div class="flashsalehotel_boxcontent item">
								<div class="flashsalehotel_boxcontent_img_text">
									<div class="flashsalehotel_img-box">
										<img class="flashsalehotel_img" width="284px" height="160px"
											style="object-fit: cover;"
											src="https://product.hstatic.net/1000075078/product/bg-cloudfee-roasted-almond_ac9a236a27274a568ac6c8630047859f_large.jpg"
											alt="">
										<!-- <span class="new">New</span> -->
									</div>
									<div class="flashsalehotel_text">
										<div class="flashsalehotel_text-title">
											<span>Tên Hải Sản</span>
										</div>
										<div class="flashsalehotel_place">
											<div>
												<i class="fa-solid fa-certificate"></i> Danh Mục Sản Phẩm
											</div>
										</div>
										<!-- <div class="flashsalehotel_text-evaluate">
                                                              <div class="flashsalehotel_text-evaluate-icon">
                                                                  <i class="fa-solid fa-star"></i>8.5
                                                              </div>
                                                              <div class="flashsalehotel_text-evaluate-text">
                                                                  Tuyệt vời <span style=" color:#4a5568;">(425 đánh giá)</span>
                                                              </div>
                                                          </div> -->
										<div class="flashsalehotel_text-time">
											<span>Sản phẩm mới</span>
										</div>
										<div class="flashsalehotel_text-box-price">
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
										</div>
									</div>
								</div>
							</div>
						</a>
					</div>

					<div class="col-lg-4 col-md-6 col-sm-6 ">
						<a href="/thongtinkhachsan.html"
							class="flashsalehotel_boxcontent_hover">
							<div class="flashsalehotel_boxcontent item">
								<div class="flashsalehotel_boxcontent_img_text">
									<div class="flashsalehotel_img-box">
										<img class="flashsalehotel_img" width="284px" height="160px"
											style="object-fit: cover;"
											src="https://product.hstatic.net/1000075078/product/bg-cloudfee-roasted-almond_ac9a236a27274a568ac6c8630047859f_large.jpg"
											alt="">
										<!-- <span class="new">New</span> -->
									</div>
									<div class="flashsalehotel_text">
										<div class="flashsalehotel_text-title">
											<span>Tên Hải Sản</span>
										</div>
										<div class="flashsalehotel_place">
											<div>
												<i class="fa-solid fa-certificate"></i> Danh Mục Sản Phẩm
											</div>
										</div>
										<!-- <div class="flashsalehotel_text-evaluate">
                                                              <div class="flashsalehotel_text-evaluate-icon">
                                                                  <i class="fa-solid fa-star"></i>8.5
                                                              </div>
                                                              <div class="flashsalehotel_text-evaluate-text">
                                                                  Tuyệt vời <span style=" color:#4a5568;">(425 đánh giá)</span>
                                                              </div>
                                                          </div> -->
										<div class="flashsalehotel_text-time">
											<span>Sản phẩm mới</span>
										</div>
										<div class="flashsalehotel_text-box-price">
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
										</div>
									</div>
								</div>
							</div>
						</a>
					</div>

					<div class="col-lg-4 col-md-6 col-sm-6 ">
						<a href="/thongtinkhachsan.html"
							class="flashsalehotel_boxcontent_hover">
							<div class="flashsalehotel_boxcontent item">
								<div class="flashsalehotel_boxcontent_img_text">
									<div class="flashsalehotel_img-box">
										<img class="flashsalehotel_img" width="284px" height="160px"
											style="object-fit: cover;"
											src="https://product.hstatic.net/1000075078/product/bg-cloudfee-roasted-almond_ac9a236a27274a568ac6c8630047859f_large.jpg"
											alt="">
										<!-- <span class="new">New</span> -->
									</div>
									<div class="flashsalehotel_text">
										<div class="flashsalehotel_text-title">
											<span>Tên Hải Sản</span>
										</div>
										<div class="flashsalehotel_place">
											<div>
												<i class="fa-solid fa-certificate"></i> Danh Mục Sản Phẩm
											</div>
										</div>
										<!-- <div class="flashsalehotel_text-evaluate">
                                                              <div class="flashsalehotel_text-evaluate-icon">
                                                                  <i class="fa-solid fa-star"></i>8.5
                                                              </div>
                                                              <div class="flashsalehotel_text-evaluate-text">
                                                                  Tuyệt vời <span style=" color:#4a5568;">(425 đánh giá)</span>
                                                              </div>
                                                          </div> -->
										<div class="flashsalehotel_text-time">
											<span>Sản phẩm mới</span>
										</div>
										<div class="flashsalehotel_text-box-price">
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
										</div>
									</div>
								</div>
							</div>
						</a>
					</div>


				</div>
				{{--
				<div class="row mt-5">
					<div class="col-md-12 panigate">{!!
						$all_product->links('admin.ComponentPages.pagination') !!}</div>
				</div>
				--}}
			</div>
		</div>
	</div>






	<?php
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
						href="{{ url('/san-pham/san-pham-chi-tiet?product_id=' . $product['product_id'] . '') }}"
						class="flashsalehotel_boxcontent_hover">
						<div class="flashsalehotel_boxcontent item">
							<div class="flashsalehotel_boxcontent_img_text">
								<div class="flashsalehotel_img-box">
									<img class="flashsalehotel_img" width="284px" height="160px"
										style="object-fit: cover;"
										src="{{ url('public/fontend/assets/img/product/' . $product['product_image'] . '') }}"
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
	@endif

	<!-- Optional JavaScript -->
	<!-- Popper.js first, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script src='<c:url value="/assets/web/js/main.js"/>'></script>
	<script src='<c:url value="/assets/web/js/trangchu.js"/>'></script>
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous">
    </script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/js/bootstrap.min.js"
		integrity="sha384-oesi62hOLfzrys4LxRF63OJCXdXDipiYWBnvTl9Y9/TRlw5xlKIEHpNyvvDShgf/"
		crossorigin="anonymous">
    </script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.13.2/jquery-ui.min.js"
		integrity="sha512-57oZ/vW8ANMjR/KQ6Be9v/+/h6bq9/l3f0Oc7vn6qMqyhvPd1cvKBRWWpzu0QoneImqr2SkmO4MSqU+RpHom3Q=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>

	<script src='<c:url value="/assets/web/js/ResizeSensor.js"/>'></script>
	<script src='<c:url value="/assets/web/js/theia-sticky-sidebar.js"/>'></script>
	<script>
        $('.leftSidebar, .rightSidebar')
            .theiaStickySidebar({
                additionalMarginTop: 80
            });
    </script>
	<script src="https://code.jquery.com/jquery-3.6.0.js">
    
    function getPosts() {
        $.ajax({
            url: '/cua-hang/load-danh-sach-san-pham',
            method: 'get',
            data: {
            	
            },
            success: function(data) {
            	
                $('.all-product .list-product').html(data);
                $('.list-product').removeClass('loading-1');
            },
            error: function() {
                alert("Bug Huhu :<<");
            }
        })
    }
    getPosts();
    </script>
	<script>
		/* alert("100") */
        var viewportWidth = $(window).width();
        if (viewportWidth < 1280) {
            $('.hello').removeClass("theiaStickySidebar");
            $('.hello').attr('style', '');
            //   $('.hello').remove();
            $('.hello').css({
                "width": "100%",
                "display": "contents"
            })
        } else {
            // $('.hello').addClass("theiaStickySidebar");
        }

        function getPosts() {
            $.ajax({
                url: '/SpringMVC/cua-hang/load-danh-sach-san-pham',
                method: 'get',
                data: {
                	
                },
                success: function(data) {
                    $('.all-product .list-product').html(data);
                    $('.list-product').removeClass('loading-1');
                },
                error: function() {
                    alert("Bug Huhu :<<");
                }
            })
        }
        getPosts();


        /* var price_min = {{ $price_min }};
        var price_max = {{ $price_max }};

        // $(document).ready(function(){
        $("#slider-range").slider({
            range: true,
            min: {{ $price_min }},
            max: {{ $price_max }},
            values: [50, 100000],
            slide: function(event, ui) {
                $("#amount").val("" + ui.values[0] + "đ" + " - " + ui.values[1] + "đ");
                price_min = ui.values[0];
                price_max = ui.values[1];
                var text = $('.search-input').val();
                var value_option = $('#option-filter').val();
                var type_option = $('#option-filter option:selected').attr('data-type');
                var list_id = [];
                $.each($("input[name='category']:checked"), function() {
                    list_id.push($(this).attr('data-category_id'));
                    // alert("hih");
                });
                $.ajax({
                    url: '{{ url('/cua-hang/search-san-pham') }}',
                    method: 'get',
                    data: {
                        price_min: ui.values[0],
                        price_max: ui.values[1],
                        text: text,
                        value_option: value_option,
                        type_option: type_option,
                        list_id: list_id
                    },
                    success: function(data) {
                        $('.all-product .list-product').html(data);

                    },
                    error: function() {
                        // alert("Bug Huhu :<<");
                    }
                })
            }
        }); */
        $("#amount").val($("#slider-range").slider("values", 0) + "đ" +
            " - " + $("#slider-range").slider("values", 1) + "đ");
        // });
    </script>

	<script>
        // var notePage = 1;
        // $('.pagination a').unbind('click').on('click', function(e) {
        //     e.preventDefault();
        //     var page = $(this).attr('href').split('page=')[1];
        //     notePage = page;
        //     // alert(notePage)
        //     getPosts(page);
        // });

        



        // Thêm sản phẩm vào giỏ hàng
        $(document).on('click', '.cart-hover', function() {
            $('.modal').addClass('loading_product');
            var product_id = $(this).data('product_id');

            $.ajax({
                url: '{{ url('/trang-chu/show-detail-product') }}',
                method: 'get',
                data: {
                    product_id: product_id
                },
                success: function(data) {
                    $('.modal .modal-body').html(data);
                    $('.modal').removeClass('loading_product');

                },
                error: function() {
                    alert("Ngu sửa Bug đi con Huhu :<<");
                }
            })
        })


        // Search 
        $('.search-input').keyup(function() {
            var text = $(this).val();
            // console.log(text);
            var value_option = $('#option-filter').val();
            var type_option = $('#option-filter option:selected').attr('data-type');
            var list_id = [];
            $.each($("input[name='category']:checked"), function() {
                list_id.push($(this).attr('data-category_id'));
                // alert("hih");
            });
            $.ajax({
                url: '{{ url('/cua-hang/search-san-pham') }}',
                method: 'get',
                data: {
                    text: text,
                    price_min: price_min,
                    price_max: price_max,
                    value_option: value_option,
                    type_option: type_option,
                    list_id: list_id
                },
                success: function(data) {
                    // $(this).attr('data-target', '#shopping');
                    $('.all-product .list-product').html(data);
                },
                error: function() {
                    alert("Ngu sửa Bug đi con Huhu :<<");
                }
            })
        })

        // Option filter
        $('#option-filter').change(function() {
            var value_option = $(this).val();
            var type_option = $('#option-filter option:selected').attr('data-type');
            // alert(value_option + type_option);
            var list_id = [];
            $.each($("input[name='category']:checked"), function() {
                list_id.push($(this).attr('data-category_id'));
                // alert("hih");
            });
            var text = $('.search-input').val();
            $.ajax({
                url: '{{ url('/cua-hang/search-san-pham') }}',
                method: 'get',
                data: {
                    text: text,
                    price_min: price_min,
                    price_max: price_max,
                    value_option: value_option,
                    type_option: type_option,
                    list_id: list_id
                },
                success: function(data) {
                    // $(this).attr('data-target', '#shopping');
                    $('.all-product .list-product').html(data);
                },
                error: function() {
                    alert("Ngu sửa Bug đi con Huhu :<<");
                }
            })
        })


        $(".action").on("click", function() {
            var list_id = [];
            $.each($("input[name='category']:checked"), function() {
                list_id.push($(this).attr('data-category_id'));
            });
            var text = $('.search-input').val();
            var value_option = $('#option-filter').val();
            var type_option = $('#option-filter option:selected').attr('data-type');
            $.ajax({
                url: '{{ url('/cua-hang/search-san-pham') }}',
                method: 'get',
                data: {
                    list_id: list_id,
                    text: text,
                    value_option: value_option,
                    type_option: type_option,
                    price_min: price_min,
                    price_max: price_max,
                },
                success: function(data) {
                    $('.all-product .list-product').html(data);
                },
                error: function() {
                    alert("Bug Huhu :<<");
                }
            })
        });
    </script>


	<script>
        const input_search = document.querySelector('#input');
        const btn_mic = document.querySelector('#search-btn');
        const micIcon = document.querySelector('#search-btn i');

        const SpeachRecognition = window.SpeachRecognition || window.webkitSpeechRecognition;

        if (SpeachRecognition) {
            console.log("Your Browser supports speech ");

            const recognition = new SpeachRecognition();
            // recognition.continuous = true;
            recognition.lang = "vi-VN";
            btn_mic.addEventListener('click', micBtnClick)


            function micBtnClick() {
            	alert("huhu")
                if (micIcon.classList.contains('fa-microphone')) { // start speech

                    recognition.start();
                } else { // stop speech

                    recognition.stop();
                }
            }
            recognition.addEventListener('start', startSpeech);

            function startSpeech() {
                micIcon.classList.remove('fa-microphone');
                micIcon.classList.add('fa-microphone-slash');
                input_search.focus();
                message_toastr('success', 'Tìm Kiếm Bằng Giọng Nói Đã Được Kích Hoạt!');
                console.log('Speech active');
            }

            recognition.addEventListener('end', endSpeech);

            function endSpeech() {
                micIcon.classList.add('fa-microphone');
                micIcon.classList.remove('fa-microphone-slash');
                input_search.focus();
                message_toastr('success', 'Tìm Kiếm Bằng Giọng Nói Đã Bị Vô Hiệu!');
                console.log('Speech unactive');
            }

            recognition.addEventListener('result', resultSpeech);

            function resultSpeech(event) {
                const transcript = event.results[0][0].transcript;
                input_search.value = transcript;
                var list_id = [];
                $.each($("input[name='category']:checked"), function() {
                    list_id.push($(this).attr('data-category_id'));
                    // alert("hih");
                });
                // alert(list_id);
                var value_option = $('#option-filter').val();
                var type_option = $('#option-filter option:selected').attr('data-type');
                $.ajax({
                    url: '{{ url('/cua-hang/search-san-pham') }}',
                    method: 'get',
                    data: {
                        text: transcript,
                        price_min: price_min,
                        price_max: price_max,
                        value_option: value_option,
                        type_option: type_option,
                        list_id: list_id
                    },
                    success: function(data) {
                        // $(this).attr('data-target', '#shopping');
                        $('.all-product .list-product').html(data);
                    },
                    error: function() {
                        alert("Ngu sửa Bug đi con Huhu :<<");
                    }
                })
            }
        } else {
            console.log("Your Broswer not supports");
        }
    </script>

	{{-- Thêm vào giỏ hàng --}}
	<script>
        // $(document).on("click", '.button_cart', function() {
        //     var product_id = $("#product_id").val();
        //     // var _token = $('meta[name="csrf-token"]').attr('content');
            
        //     var product_qty = $('#quantity').val();
        //     var product_type = $("input[name='size']:checked").val();
        //     // alert('hihi');
        //     // $('.button_cart').attr('data-dismiss', '');
        //     // alert(product_id + " " + product_type + " " + product_qty);
        //     if($("input[name='size']").is(':checked') == false){
               
        //         message_toastr('warning', 'Bạn chưa chọn size đồ uống !!');

        //         $('.button_cart').attr('data-dismiss', 'modal');
        //     }else{
        //         $.ajax({
        //             url: '{{ url('/gio-hang/save-cart') }}',
        //             method: 'get',
        //             data: {
        //                 // _token: _token,
        //                 product_id: product_id,
        //                 product_qty: product_qty,
        //                 product_type: product_type
        //             },
        //             success: function(data) {
        //                 // load_cart();
        //                     message_toastr("success",
        //                         'Bạn đã thêm sản phẩm vào giỏ hàng!!!',
        //                         'Thành công');
        //             },
        //             error: function() {
        //                 alert("Bug Huhu :<<");
        //             }
        //         })

        //     }
        // });
    </script>


</body>
