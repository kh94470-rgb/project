<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${ param.num1 } / ${ param.num2 }<br/>
	
	<c:if test="${ Integer.parseInt(param.num1) > Integer.parseInt(param.num2) }">
		${ param.num1 } 큽니다, ${ param.num2 }보다
	</c:if>
	<c:if test="${ Integer.parseInt(param.num1) < Integer.parseInt(param.num2) }">
		${ param.num2 } 큽니다, ${ param.num1 } 보다
	</c:if>
	
</body>
</html>