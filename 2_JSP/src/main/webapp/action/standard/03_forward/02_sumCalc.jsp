<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int first = Integer.parseInt(request.getParameter("firstNum"));
		int second = Integer.parseInt(request.getParameter("secondNum"));
		
		int result = 0;
		for(int i = first; i <= second; i++){
			result += i;
		}
		
		request.setAttribute("result", result);
		
		
	%>
	<jsp:forward page="03_sumView.jsp"></jsp:forward>
<!-- 	forward : 요청을 다른 페이지로 넘겨서 처리 -->
<!-- 	request, response 객체(영역)를 보존하면서 전달 -->
</body>
</html>