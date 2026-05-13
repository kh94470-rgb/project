<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = (String)request.getAttribute("jName");
	String gender = (String)request.getAttribute("jGender");
	String age = (String)request.getAttribute("jAge");
	String city = (String)request.getAttribute("jCity");
	String height = (String)request.getAttribute("jHeight");
	String food = (String)request.getAttribute("jFood");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	h2{color: red;}
	span{font-weight: bold;}
	#name{color: orange;}
	#gender{color: yellow; background: black;}
	#age{color: green;}
	#city{color: blue;}
	#height{color: navy;}
	#food{color: purple;}
</style>
</head>
<body>
	<h2>개인 취향 테스트 결과(POST)</h2>
	<span id='name'><%= name %></span>님은 
	<span id='age'><%= age %></span>이시며,
	<span id='city'><%= city %></span>에 사는 
	키 <span id='height'><%= height %></span>cm인
	<span id="gender"><%= gender %></span>입니다.
	좋아하는 음식은 <span id="food"><%= food %></span>입니다.
	
</body>
</html>