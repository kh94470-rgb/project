<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	꺄악 에러야~~~~<br/>
	<%= exception %><br/>
	<%= exception.getMessage() %><br/>
	<%= exception.getClass().getName() %>
	
	<hr/>
	
	<h2>
		에러가 발생한 날짜는
		<span style="color: yellowgreen;">
			<%@ include file="../today.jsp" %>
		</span>
	</h2>
	
	<% //String today = "맑음"; %>
</body>
</html>