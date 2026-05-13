<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>fmt(fomatter)</h2>
	<p>날짜, 시간, 숫자 데이터의 출력 형식을 지정할 때 사용</p>
	
	<h3>숫자 데이터 포맷 지정 : formatNumber</h3>
	<fmt:formatNumber value="123456789"/><br/> 
	<fmt:formatNumber value="123456789" groupingUsed="true"/><br/>
	<fmt:formatNumber value="123456789" groupingUsed="false"/><br/>
	formatNumber에서 groupingUsed는 true가 기본 값, 천 단위로 구분 기호 적용
	
	<br/><br/>
	
	<b>실수값 소숫점 아래 자리수 지정 : pattern 속성</b><br/>
	<fmt:formatNumber value="1.234567"/><br/>
	<fmt:formatNumber value="1.234567" pattern="#.##"/><br/>
	<fmt:formatNumber value="1.2" pattern="#.##"/><br/>
	<fmt:formatNumber value="1.2" pattern="#.00"/><br/>
	<fmt:formatNumber value="1.2" pattern="#.55"/><br/> 
	
	<h3>type 속성으로 백분율, 통화기호 표시</h3>
	<fmt:formatNumber value="0.12" type="percent"/><br/>
	<fmt:formatNumber value="123456789" type="currency"/><br/>
	<fmt:formatNumber value="123456789" type="currency" currencySymbol="$"/>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>