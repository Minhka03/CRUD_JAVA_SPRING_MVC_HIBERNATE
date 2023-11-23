<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title><tiles:insertAttribute name="title" /></title>

<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/css/bootstrap.min.css" />


<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/css/home.css" />
	
	<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/assets/css/style.css" />
	
	<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/assets/css/vendor.css" />


</head>

<body>

	<div id="container">

		<tiles:insertAttribute name="header" />

		<tiles:insertAttribute name="body" />

		<tiles:insertAttribute name="footer" />

	</div>

	<script
		src="${pageContext.servletContext.contextPath}/resources/js/jquery-3.3.1.slim.min.js"></script>

	<script
		src="${pageContext.servletContext.contextPath}/resources/js/popper.min.js" /></script>

	<script
		src="${pageContext.servletContext.contextPath}/resources/js/bootstrap.min.js" /></script>
		
		 <script src="${pageContext.servletContext.contextPath}/resources/assets/js/vendor.js"></script>
        <script src="${pageContext.servletContext.contextPath}/resources/assets/js/main.js"></script>

</body>

</html>