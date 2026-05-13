<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-4.0.0.js"></script>
<style>
	h1>a{color: black; text-decoration: none;}
	h1>a:active{color: orangered;}
</style>
</head>
<body>
	<c:set var="contextPath" scope="application" value="${ pageContext.servletContext.contextPath }"/>
	<h1 align="center"><a href="${ contextPath }">JSP&amp;Servlet MyBatis Project</a></h1>
</body>
</html>