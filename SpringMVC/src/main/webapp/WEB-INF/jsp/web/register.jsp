<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="spring.mvc.Until.Until"%>

<body>

	<link rel="stylesheet"
		href='<c:url value="/assets/web/css/owl.carousel.min.css" />'>
	<link rel="stylesheet"
		href='<c:url value="/assets/web/css/owl.theme.default.min.css" />'>
	<link rel="stylesheet"
		href='<c:url value="/assets/web/css/lightslider.css" />'>
	<link rel="stylesheet"
		href='<c:url value="/assets/web/css/prettify.css" />'>
	<link rel="stylesheet"
		href='<c:url value="/assets/web/css/thongtinkhachsan.css" />'>
	<link rel="stylesheet"
		href='<c:url value="/assets/web/css/resTrangchu.css" />'>
	<%-- <link rel="stylesheet"
		href='<c:url value="/assets/web/css/style.css" />'> --%>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="utf-8">
<title>Login / Sign Up Form</title>
<link rel="shortcut icon" href="/assets/favicon.ico">
<link rel="stylesheet" href="./src/main.css">
</head>
<body>
	<div class="login_form">
		<!-- <form class="form" id="login" action="">
			<h1 class="form__title">Register</h1>
			<div class="form__message form__message--error"></div>
			<div class="form__input-group">
				<input type="text" class="form__input" name="customerEmail"
					autofocus placeholder="Email">
				<div class="form__input-error-message"></div>
			</div>
			<div class="form__input-group">
				<input type="text" class="form__input" name="customerName"
					autofocus placeholder="Your Name">
				<div class="form__input-error-message"></div>
			</div>
			<div class="form__input-group">
				<input type="text" class="form__input" name="customerPhone"
					autofocus placeholder="Your Phone">
				<div class="form__input-error-message"></div>
			</div>
			
			<div class="form__input-group">
				<input type="password" class="form__input" name="customerPassword"
					autofocus placeholder="Password">
				<div class="form__input-error-message"></div>
			</div>
			<div class="form__input-group">
				<input type="password" class="form__input" name="customerPassword"
					autofocus placeholder="Retype Password">
				<div class="form__input-error-message"></div>
			</div>
			<button class="form__button" type="submit">Continue</button>
			<p class="form__text">
				<a href="#" class="form__link">Forgot your password?</a>
			</p>
			<p class="form__text">
				<a class="form__link" href="./" id="linkCreateAccount">Don't
					have an account? Create account</a>
			</p>
		</form> -->

		<form class="form " id="createAccount">
			<h1 class="form__title">Create Account</h1>
			<div class="form__message form__message--error"></div>
			<div class="form__input-group">
				<input type="text" id="signupUsername" name="customer_name_user" class="form__input" autofocus
					placeholder="Username">
				<div class="form__input-error-message"></div>
			</div>
			<div class="form__input-group">
				<input type="text" class="form__input" name="customer_email_user"autofocus
					placeholder="Email Address">
				<div class="form__input-error-message"></div>
			</div>
			<div class="form__input-group">
				<input type="password" class="form__input"  name="customer_password1_user" autofocus
					placeholder="Password">
				<div class="form__input-error-message"></div>
			</div>
			<div class="form__input-group">
				<input type="password" class="form__input" name="customer_password2_user" autofocus
					placeholder="Confirm password">
				<div class="form__input-error-message"></div>
				<div class="form__input-group">
				<input type="text" class="form__input" name="customer_phone_user"
					autofocus placeholder="Your Phone">
				<div class="form__input-error-message"></div>
			</div>
			</div>
			<button class="form__button btn-register" type="button">Continue</button>
			<p class="form__text">
				<a class="form__link" href="./" id="linkLogin">Already have an
					account? Sign in</a>
			</p>
		</form>
	</div>
	<script src="./src/main.js"></script>
</body>
</body>
