<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page"%>
<%@ page import="spring.mvc.Until.Until"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="vn">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="csrf-token" content="{{ csrf_token() }}">
<title>Trang Chủ</title>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
	integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link REL="SHORTCUT ICON"
	href='<c:url value="/assets/web/iconlogo/logo1.png"/>'>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css"
	integrity="sha384-r4NyP46KrjDleawBgD5tp8Y7UzmLA05oM1iAEQ17CSuDqnUK2+k9luXQOfXJCJ4I"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
	integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet"
	href='<c:url value="/assets/web/css/owl.carousel.min.css"/>'>
<link rel="stylesheet"
	href='<c:url value="/assets/web/css/owl.theme.default.min.css"/>'>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css">

<link rel="stylesheet"
	href='<c:url value="/assets/web/css/style.css" />'>

<link rel="stylesheet"
	href='<c:url value="/assets/web/css/thongtinkhachsan.css" />'>

<link rel="stylesheet"
	href='<c:url value="/assets/web/css/trangchu.css" />'>

<link rel="stylesheet"
	href='<c:url value="/assets/web/css/resTrangchu.css" />'>
<link rel="stylesheet"
	href='<c:url value="/assets/web/css/banner.css" />'>


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.css">
<script src="https://codeseven.github.io/toastr/build/toastr.min.js"></script>

<script>
        function message_toastr(type, content) {
            Command: toastr[type](content)
            toastr.options = {
                "closeButton": true,
                "debug": false,
                "newestOnTop": true,
                "progressBar": true,
                "positionClass": "toast-top-right",
                "preventDuplicates": true,
                "showDuration": "300",
                "hideDuration": "1000",
                "timeOut": "5000",
                "extendedTimeOut": "1000",
                "showEasing": "swing",
                "hideEasing": "linear",
                "showMethod": "fadeIn",
                "hideMethod": "fadeOut"
            }
        }
    </script>
</head>

<style>
</style>

<body class="preloading">

	<%@include file="/WEB-INF/jsp/layout/web/header.jsp"%>



	<decorator:body></decorator:body>

	<%@include file="/WEB-INF/jsp/layout/web/footer.jsp"%>

	<div class="modal fade" id="shopping" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered modal-lg"
			role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">
						<span>Đặt Hàng Sản Phẩm</span>
					</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">

					<div class="row">
						<div class="col-lg-5 col-sm-12 img">
							<img class="flashsalehotel_img" width="284px" height="160px"
								style="object-fit: cover;"
								src="https://product.hstatic.net/1000075078/product/bg-cloudfee-roasted-almond_ac9a236a27274a568ac6c8630047859f_large.jpg"
								/.		alt="">
						</div>
						<div class="col-lg-7 col-sm-12">
							<div class="product_name">
								<h2>Sản phẩm</h2>
							</div>
							<div class="flashsalehotel_place">
								<div class="category_name">
									<i class="fa-solid fa-certificate"></i> Danh Mục Sản Phẩm
								</div>
								<br>
								<div class="price">39.000đ/29.000đ</div>
							</div>
							<hr width="100%">

							<div class="product-size-box">
								<div class="product-size">

									<div class="size-main">
										<label class="size-detail" for="nho"><i
											class="fas fa-coffee"></i> Nhỏ + 0đ</label> <input id="nho"
											type="radio" name="size" hidden>
									</div>
									<div class="size-main">
										<label class="size-detail" for="vua"><i
											class="fas fa-coffee"></i> Vừa + 6.000đ</label> <input id="vua"
											type="radio" name="size" hidden>
									</div>

									<div class="size-main">
										<label class="size-detail" for="lon"><i
											class="fas fa-coffee"></i> Lớn + 10.000đ</label> <input id="lon"
											type="radio" name="size" hidden>
									</div>
								</div>
							</div>
							<hr>
							<div class="row quantity_row">
								<div class="quantity-class">
									<span>Số lượng: </span> <input type="number" min="1" max="100"
										value="1">
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<div class="modal-button">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Đóng</button>
						<button type="button" class="btn btn-danger button_cart"
							data-dismiss="">
							<i class="fa-solid fa-cart-shopping"></i>Thêm vào giỏ
						</button>
					</div>
				</div>
			</div>
		</div>
	</div>


	<s:form id="login" class="fromlogin">
		<div class="fromlogin-box">
			<div class="fromlogin-title">
				<label for=""><span>Đăng nhập</span></label>
			</div>

			<a href="{{ URL::to('/user/login-facebook') }}">
				<div class="fromlogin-item">
					<div class="fromlogin-item-logo">
						<!-- <i class="fa-brands fa-facebook"></i> -->
						<img width="30px" height="30px"
							style="object-fit: cover; margin-left: -4px;"
							src="{{ asset('public/fontend/assets/img/icon/fb-login-icon.png') }}"
							alt="">
					</div>
					<div class="fromlogin-item-text">
						<span style="margin-left: -3px;">Đăng nhập bằng facebook</span>
					</div>
				</div>
			</a> <a href="{{ URL::to('/user/login-google') }}">
				<div class="fromlogin-item">
					<div class="fromlogin-item-logo">
						<!-- <i class="fa-brands fa-google"></i> -->
						<img width="24px" height="24px" style="object-fit: cover;"
							src="{{ asset('public/fontend/assets/img/icon/gg-login-icon.png') }}"
							alt="">
					</div>
					<div class="fromlogin-item-text">
						<span>Đăng nhập bằng Google</span>
					</div>
				</div>
			</a>
			<div style="margin-top: 16px" class="fromlogin-item-input-box">
				<input id="email" class="fromlogin-item-input mb-3" type="text"
					name="customerEmail" required> <label
					class="fromlogin-item-lable" for="">Tài khoản Hoặc Email</label> <span
					class="form-message mb-2"></span>
			</div>
			<div style="margin-top: 30px;" class="fromlogin-item-input-box">
				<input id="password" class="fromlogin-item-input mb-3"
					type="password" name="customerPassword" required> <label
					class="fromlogin-item-lable" for="">Mật khẩu</label> <span
					class="form-message mb-2"></span>
			</div>
			<input type="button" class="fromlogin-btn" value="Đăng nhập"
				id="btn-login-submit">
			<div style="cursor: pointer" id="recoverypassaccount"
				class="fromlogin-restore">
				<span>Khôi phục mật khẩu</span>
			</div>
			<div class="fromlogin-end">
				<span>Chưa có tài khoản?</span> <span id="registeraccount"
					style="cursor: pointer; color: #00b6f3;">Đăng ký tài khoản</span>
			</div>
		</div>
	</s:form>


	<form id="form-1" class="fromsignup" action="" method="post">
		<div class="fromsignup-box">
			<div style="padding-bottom: 20px" class="fromsignup-title">
				<label for=""><span>Đăng ký</span></label>
			</div>

			<div class="fromsignup-text">
				<span>Hoặc ký bằng số điện thoại</span>
			</div>
			<div style="margin: 0;" class="fromsignup-item-input-box">
				<input id="fullname" class="fromsignup-item-input" type="text"
					name="customer_name_user" required> <label for="fullname"
					class="fromsignup-item-lable">Nhập tên đăng nhập</label> <span
					class="form-message"></span>
			</div>
			<div class="fromsignup-item-input-box">
				<input id="phone" class="fromsignup-item-input" type="text"
					name="customer_phone_user" required> <label for=""
					class="fromsignup-item-lable">Nhập điện thoại</label> <span
					class="form-message"></span>
			</div>
			<div class="fromsignup-item-input-box">
				<input id="email" class="fromsignup-item-input" type="text"
					name="customer_email_user" required> <label for="email"
					class="fromsignup-item-lable">Nhập email</label> <span
					class="form-message"></span>
			</div>
			<div class="fromsignup-item-input-box">
				<input id="password1" class="fromsignup-item-input" type="text"
					name="customer_password1_user" required> <label
					for="password" class="fromsignup-item-lable">Nhập mật khẩu</label>
				<span class="form-message"></span>
			</div>
			<div class="fromsignup-item-input-box mb-5">
				<input id="password_confirmation" class="fromsignup-item-input"
					type="text" name="customer_password2_user" required> <label
					for="password_confirmation" class="fromsignup-item-lable">Nhập
					lại mật khẩu</label> <span class="form-message"></span>
			</div>

			<div>
				<input id="customer_checkbox_user" type="checkbox"
					name="customer_checkbox_user" value="on"> <label>Đồng
					ý với tất cả các Điều khoản</label> <span class="form-message"></span>
			</div>
			<input style="margin-top: 10px" class="fromsignup-btn" type="button"
				value="Đăng ký" id="btn-register-account">
			<div style="padding-top: 16px; padding-bottom: 40px;"
				class="fromsignup-end">
				<span>Bạn đã có tài khoản?</span> <span id="loginaccount"
					style="cursor: pointer; color: #00b6f3;">Đăng nhập</span>
			</div>
		</div>
	</form>

	<!-- Kết thúc Footer  -->

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"
		integrity="sha512-aVKKRRi/Q/YV+4mjoKBsE4x3H+BkegoM/em46NNlCqNTmUYADjBbeNefNxYV7giUp0VxICtqdrbqU7iVaeZNXA=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script src='<c:url value="/assets/web/js/owl.carousel.min.js"/>'></script>

	<script src='<c:url value="/assets/web/js/main.js"/>'></script>

	<script src='<c:url value="/assets/web/js/trangchu.js"/>'></script>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>

	<!-- Captcha gg -->
	<script src="https://www.google.com/recaptcha/api.js" async defer></script>

	<!-- Mess toastr -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>

	<script>
        new WOW().init();
    </script>

	<script>

$(document).on('click','.size-main',function(){
            $(this).addClass('active').siblings().removeClass('active');
        })

        Validator({
            form: '#form-1',
            errorSelector: '.form-message',
            rules: [
            Validator.isRequired('#fullname' , 'Vui lòng nhập tên đầy đủ của bạn'),
            Validator.isRequired('#email'),
            Validator.isEmail('#email'),
            Validator.isRequired('#phone'),
            Validator.minLength('#password',6),
            Validator.isRequired('#password_confirmation'),
            Validator.isConfirmed('#password_confirmation', function(){
                return document.querySelector('#form-1 #password').value;
            }, 'Mật khẩu nhập lại không chính xác')
            ]
        });


        Validator({
            form: '#login',
            errorSelector: '.form-message',
            rules: [
            Validator.isRequired('#email'),
            Validator.isEmail('#email'),
            Validator.minLength('#password',6),
            ]
        });

        

        function message_toastr(type, title, content) {
            Command: toastr[type](content, title)

            toastr.options = {
                "closeButton": false,
                "debug": false,
                "newestOnTop": false,
                "progressBar": true,
                "positionClass": "toast-top-right",
                "preventDuplicates": false,
                "onclick": null,
                "showDuration": "300",
                "hideDuration": "1000",
                "timeOut": "5000",
                "extendedTimeOut": "1000",
                "showEasing": "swing",
                "hideEasing": "linear",
                "showMethod": "fadeIn",
                "hideMethod": "fadeOut"
            }
        }

        //$(document).onload(function(){
            $('.fromsignup-btn').click(function(){
                if($('.form-message').text() != ''){
                  //  alert("dô");
                    $("#form-1").submit(function(e){
                        e.preventDefault();
                    });
                }
            })
        //})



        
    </script>
	<script>
        $('#overlay').click(function() {
            $("#form-1").css({
                "display": "none"
            });
            $("#from-verycode").css({
                "display": "none"
            });
            $("#overlay").css({
                "display": "none"
            });
            $(".fromlogin").css({
                "display": "none"
            });
            $(".form-vecovery-password").css({
                "display": "none"
            });
            $(".code_confirmation").css({
                "display": "none"
            });
            $(".password_confirmation").css({
                "display": "none"
            });
            $('#ShowImgHotel').hide();
        });
        $('.close-box').click(function() {
            $("#form-1").css({
                "display": "none"
            });
            $(".from-verycode").css({
                "display": "none"
            });
            $("#overlay").css({
                "display": "none"
            });
            $(".fromlogin").css({
                "display": "none"
            });
            $(".form-vecovery-password").css({
                "display": "none"
            });
            $(".code_confirmation").css({
                "display": "none"
            });
            $(".password_confirmation").css({
                "display": "none"
            });
        });

        $('#dangnhap').click(function() {
            $(".fromlogin").css({
                "display": "flex"
            });
            $("#overlay").css({
                "display": "flex"
            });
        });
        $('#dangky').click(function() {
            $("#form-1").css({
                "display": "flex"
            });
            $("#overlay").css({
                "display": "block"
            });
        });
        $('#loginaccount').click(function() {
            $("#form-1").css({
                "display": "none"
            });
            $(".fromlogin").css({
                "display": "block"
            });
        });
        $('#registeraccount').click(function() {
            $("#form-1").css({
                "display": "block"
            });
            $(".fromlogin").css({
                "display": "none"
            });
        });
        $('#recoverypassaccount').click(function() {
            $(".form-vecovery-password").css({
                "display": "block"
            });
            $(".fromlogin").css({
                "display": "none"
            });
        });
        $("#btn-login-submit").click(function() {
            var customer_email = $("input[name='customerEmail']").val();
            var customer_password = $("input[name='customerPassword']").val();
        $.ajax({
            url: '/SpringMVC/login?customerEmail=' + customer_email + "&customerPassword=" + customer_password,
            method: 'POST',
            data: {
            },
            success: function(data) {
                if(data == "true"){
                	window.location.reload();
                }else{
                	message_toastr("error", "Tài khoản hoặc mật khẩu sai!");
                }
            },
            error: function() {
                alert("Bug Huhu :<<");
            }
        })
        });
        
        $("#btn-register-account").click( function() {
	        if (document.getElementById("customer_checkbox_user").checked == true) {
	            var customer_name = $("input[name='customer_name_user']").val();
	            var customer_phone = $("input[name='customer_phone_user']").val();
	            var customer_email = $("input[name='customer_email_user']").val();
	            var customer_password = $("input[name='customer_password1_user']").val();
	            var customer_password2 = $("input[name='customer_password2_user']").val();
	        $.ajax({
	            url: '/SpringMVC/register?customerName=' + customer_name + '&customerPhone=' + customer_phone + "&customerEmail=" + customer_email + "&customerPassword=" + customer_password + "&customerPasswordConfirm=" + customer_password2,
	            method: 'POST',
	            data: {
	            },
	            success: function(data) {
	                if(data == 'confirm'){
	                    message_toastr("warning", "Mật khẩu không trùng khớp");
	                }else if(data == 'trung'){
	                	message_toastr("error", "Email này đã được sử dụng!");
	                }else{
	                	message_toastr("success", "Đăng kí tài khoản thành công!");
	                    $(".fromsignup").css({
	                        "display": "none"
	                    });
	                    $(".fromlogin").css({
	                        "display": "flex"
	                    });
	                }
	            },
	            error: function() {
	                alert("Bug Huhu :<<");
	            }
	        })
	    }});
        
        $('.modal').on('click', "input[name='size']", function(){
            var product_type_id = $(this).val();
            var product_id = $("#product_id").val();
            $.ajax({
                url: '/SpringMVC/load-price-product-type?productId=' + product_id + '&productTypeId=' + product_type_id,
                method: 'GET',
                data: {
                },
                success: function(data) {
                    // load_cart();
                    // $('#shopping').hide();
                    // $('.button_cart').attr('data-dismiss', 'modal');
                    $('.flashsalehotel_place .price').html(data);
                },
                error: function() {
                    alert("Bug Huhu :<<");
                }
            }) 
    })
    
    $(document).on("click", '.button_cart', function() {
        var product_id = $("#product_id").val();       
        var product_qty = $('#quantity').val();
        var product_type = $("input[name='size']:checked").val();
        if($("input[name='size']").is(':checked') == false){
           
            message_toastr('warning', 'Bạn chưa chọn size đồ uống !!');
         
            $('.button_cart').attr('data-dismiss', 'modal');
        }else{
            
            $.ajax({
                url: '/SpringMVC/save-cart?productId=' + product_id + '&productQuantity=' + product_qty + '&productTypeId=' + product_type,
                method: 'get',
                data: {
                 
                },
                success: function(data) {
                    // load_cart();
                    // $('#shopping').hide();
                    // $('.button_cart').attr('data-dismiss', 'modal');
                    //load_quantity_cart();
                    if(data == "customer"){
                    	message_toastr("error",
                                'Vui lòng đăng nhập để thêm sản phẩm vào giỏ hàng!',
                                'Thông tin');
                    }else{
                        message_toastr("success",
                            'Bạn đã thêm sản phẩm vào giỏ hàng!!!',
                            'Thành công');                    	
                    }
                },
                error: function() {
                    alert("Bug Huhu :<<");
                }
            })

        }
    });
        
        $("#cart").click(function(){
        	if(${customer != null}){
        		window.location.href = 'http://localhost:8080/SpringMVC/gio-hang/'
        	}else{
        		message_toastr("error",
                        'Vui lòng đăng nhập để sử dụng giỏ hàng!',
                        'Thông tin');
        	}
        })
    </script>

	<script>
	
	
	

    $("#submit_verycode").on("click", function() {
        var verycoderg = $("input[name='very_code']").val();
        var _token = $("input[name='_token']").val();

        $.ajax({
            url: '{{ url('/user/verification-code-rg') }}',
            method: 'POST',
            data: {
                verycoderg: verycoderg,
                _token: _token,
            },
            success: function(data) {
                if (data == "error_very_code") {
                    message_toastr("error", "Mã Xác Nhận Sai !!! Nhập Lại Nhé Ahihi :>", "Lỗi !");
                } else {
                    message_toastr("success", "Đăng Ký Tài Khoản Thành Công !", "Thành Công !");
                    $(".from-verycode").css({
                        "display": "none"
                    });
                    $("#overlay").css({
                        "display": "none"
                    });
                    $(".fromlogin").css({
                        "display": "block"
                    });

                }
            },
            error: function() {
                alert("Bug Huhu :<<");
            }
        })
    });
    
                  
</script>

	<script>
    $("#submit_emailorname").on("click", function() {

        var customer_name_mail = $("input[name='emailorname']").val();
        var _token = $("input[name='_token']").val();

        $.ajax({
            url: '{{ url('/user/find-account-recovery-pw') }}',
            method: 'POST',
            data: {
                customer_name_mail: customer_name_mail,
                _token: _token,
            },
            success: function(data) {
                if (data == "account_not_found") {
                    message_toastr("error", "Không thành công", "Tài Khoản Không tồn tại trong hệ thống")
                    
                }else{
                    $(".code_confirmation").css({
                        "display": "block"
                    });
                    $(".form-vecovery-password").css({
                        "display": "block"
                    });
                }
            },
            error: function() {
                alert("Bug Huhu :<<");
            },
        })
    });


    $("#submit_code_confirmation").on("click", function() {
        var verycoderc = $("input[name='very_code_rc']").val();
        var _token = $("input[name='_token']").val();
        $.ajax({
            url: '{{ url('/user/verification-code-rc') }}',
            method: 'POST',
            data: {
                verycoderc: verycoderc,
                _token: _token,
            },
            success: function(data) {
                if (data == "error_very_code") {
                    message_toastr("error",  "Lỗi !","Mã Xác Nhận Sai !!! Nhập Lại Nhé");
                } else {
                    message_toastr("success", "Hãy Đặt Lại Mật Khẩu !", "Xác Nhận Thành Công !");
                    $(".code_confirmation").css({
                        "display": "none"
                    });
                    $(".password_confirmation").css({
                        "display": "block"
                    });
                }
            },
            error: function() {
                alert("Bug Huhu :<<");
            }
        })
    });
    $("#submit_password_confirmation").on("click", function() {
        var password1 = $("input[name='password1']").val();
        var password2 = $("input[name='password2']").val();
        var _token = $("input[name='_token']").val();

        $.ajax({
            url: '{{ url('/user/confirm-password') }}',
            method: 'POST',
            data: {
                password1: password1,
                password2: password2,
                _token: _token,
            },
            success: function(data) {
                if (data == 'success') {
                    message_toastr("success", "Mật Khẩu Đã Được Đặt Lại!", "Hoàn Thành !");

                    $(".password_confirmation").css({
                        "display": "none"
                    });
                    $("#overlay").css({
                        "display": "none"
                    });
                    $(".fromlogin").css({
                        "display": "block"
                    });
                    /* Bug Không Xác Định */
                    $(".form-vecovery-password").css({
                        "display": "none"
                    });

                } else if(data == 'error'){
                    message_toastr("error", "Mật Khẩu Không Khớp Nhau !", "Lỗi !");
                }else if(data == 'error1'){
                    message_toastr("error", "Đã xảy ra lỗi !", "Lỗi !");
                }
            },
            error: function() {
                alert("Bug Huhu :<<");
            }
        })
    });
</script>

	<script>
    // Hàm search 
    $('.BoxSearch-Bottom-One-input-size').keyup(function(){
        var text = $(this).val();
        // console.log(text);
        // var _token = $('meta[name="csrf-token"]').attr('content');
        $.ajax({
            url: '{{ url('/trang-chu/search-product') }}',
            method: 'get',
            data: {
                text: text
                // _token: _token,
            },
            success: function(data) {
               $('.inputsearchhotel').html(data);
            },
            error: function() {
                alert("Search box Bug Huhu :<<");
            }
        })
    })  
</script>

	<script>
    load_quantity_cart();
    function load_quantity_cart(){
        $.ajax({
                url: '{{ url('/gio-hang/load-quantity-cart') }}',
                method: 'get',
                data: {
                    // _token: _token,
                
                },
                success: function(data) {
                    // load_cart();
                    $('.count-cart').html(data);
                },
                error: function() {
                    alert("Bug Huhu :<<");
                }
            })
    }
</script>

	<!-- {{-- Thêm vào giỏ hàng --}} -->
	<script>
    //  $(".size-main").click(function(){
    //         $('.button_cart').attr('data-dismiss', 'modal');
    //     })
    // load_user_login();

    // function load_user_login(){
    //     $.ajax({
    //             url: '{{ url('/user/load-login-customer') }}',
    //             method: 'get',
    //             data: {
    //                 // _token: _token,
                
    //             },
    //             success: function(data) {
    //                 // load_cart();
    //                 $('.user_info').html(data);
    //             },
    //             error: function() {
    //                 alert("Bug Huhu :<<");
    //             }
    //         })
    // }

    // $('#btn-login-submit').click(function(){
    //         var customer_name = $("input[name='customer_name']").val();
    //         var customer_password = $("input[name='customer_password']").val();
    //         var _token = $('meta[name="csrf-token"]').attr('content'); 
    //         if( customer_name == '' || customer_password == ''){
                
    //             if(customer_name == ''){
    //                 message_toastr('error', 'Tên tài khoản chưa được nhập!');
    //             }
    //             if(customer_password == ''){
    //                 message_toastr('error', 'Mật khẩu chưa được nhập');s
    //             }

    //         }
    //         else{
    //             $.ajax({
    //                 url: '{{ url('user/login-customer') }}',
    //                 method: 'post',
    //                 data: {
    //                     customer_name: customer_name,
    //                     customer_password: customer_password,
    //                     _token: _token, 
    //                 },
    //                 success: function(data) {
    //                     if(data == 'error'){
    //                         message_toastr("warning", "Tên Tài Khoản Hoặc Mật Khẩu Không Chính Xác !", "Cảnh Báo !");
    //                     }else{
    //                         load_user_login();
    //                         message_toastr("success", "Đăng Nhập Thành Công !", "Thành Công !");
    //                         $("#overlay").css({
    //                             "display": "none"
    //                         });
    //                         $(".fromlogin").css({
    //                             "display": "none"
    //                         });
    //                     }
    //                 },
    //                 error: function() {
    //                     alert("Bug Huhu :<<");
    //                 }
    //             })
    //         }


    //     });
    
    
    $(document).on("click", '.button_cart', function() {
        var product_id = $("#product_id").val();       
        var product_qty = $('#quantity').val();
        var product_type = $("input[name='size']:checked").val();
        // $('.button_cart').attr('data-dismiss', '');
        // alert(product_id + " " + product_type + " " + product_qty);
        // $("input[name='size']").click(function(){
        //     $('.button_cart').attr('data-dismiss', 'modal');
        // });
        if($("input[name='size']").is(':checked') == false){
           
            message_toastr('warning', 'Bạn chưa chọn size đồ uống !!');
         
            $('.button_cart').attr('data-dismiss', 'modal');
        }else{
            
            $.ajax({
                url: '{{ url('/gio-hang/save-cart') }}',
                method: 'get',
                data: {
                   
                    product_id: product_id,
                    product_qty: product_qty,
                    product_type: product_type
                },
               
                success: function(data) {
                    // load_cart();
                    // $('#shopping').hide();
                    // $('.button_cart').attr('data-dismiss', 'modal');
                    load_quantity_cart();
                        message_toastr("success",
                            'Bạn đã thêm sản phẩm vào giỏ hàng!!!',
                            'Thành công');
                },
                error: function() {
                    alert("Bug Huhu :<<");
                }
            })

        }
    });

   

    $(document).on('click', '.cart-hover', function(){
        $('.modal').addClass('loading_product');
        var product_id = $(this).data('product_id');
        
        $("input[name='size']").click(function(){
            $('.button_cart').attr('data-dismiss', 'modal');
        });

        $.ajax({
            url: '{{ url('/trang-chu/show-detail-product') }}',
            method: 'get',
            data: {
                product_id : product_id
            },
            success: function(data) {
                $('.modal .modal-body').html(data);
                $('.modal .button_cart').attr('data-dismiss', '');
                $("input[name='size']").click(function(){
                    $('.modal .button_cart').attr('data-dismiss', 'modal');
                });
                // $(this).attr('data-target', '#shopping');
        $('.modal').removeClass('loading_product');
            },
            error: function() {
                alert("Ngu sửa Bug đi con Huhu :<<");
            }
        })
    })
</script>
</body>

</html>
