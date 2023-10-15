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



<div class="menumin">
    <h2>Login</h2>
    <form action="#" method="post">
        <div class="form-group">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" placeholder="Enter your username">
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" placeholder="Enter your password">
        </div>
        <button type="submit">Login</button>
    </form>
</div>




</body>
