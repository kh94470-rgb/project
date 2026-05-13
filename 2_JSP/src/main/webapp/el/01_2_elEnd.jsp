<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="person.model.vo.Person"%>
<%
// 	Person person = (Person)request.getAttribute("p");
// 	String beverage = (String)request.getAttribute("beverage");
// 	int year = (int)request.getAttribute("year");
// 	String[] products = (String[])request.getAttribute("products");
// 	String book = (String)request.getAttribute("book");
// 	String movie = (String)request.getAttribute("movie");
	
// 	String realBook = (String)session.getAttribute("book");
// 	String realMovie = (String)application.getAttribute("movie");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>scriptlet을 통해 request객체에 저장된 데이터 출력하기</h2>
<%-- 	<h4>개인정보(<%= year %>)</h4> --%>
<%-- 	이름 : <%= person.getName() %><br/> --%>
<%-- 	성별 : <%= person.getGender() %><br/> --%>
<%-- 	나이 : <%= person.getAge() %><br/> --%>
<!-- 	<h4>취향정보</h4> -->
<%-- 	<%= person.getName() %>님이 가장 좋아하는 음료 : <%= beverage %><br/> --%>
<%-- 	<%= person.getName() %>님이 가장 좋아하는 물건 : <%= products[0] %>, <%= products[1] %>, <%= products[2] %> <br/> --%>
<%-- 	<%= person.getName() %>님이 가장 좋아하는 도서 : <%= book %>, <%= realBook %><br/> --%>
<%-- 	<%= person.getName() %>님이 가장 좋아하는 영화 : <%= movie %>, <%= realMovie %> --%>
	
	<hr/>
	
	<h2>el의 내장객체 XXXScope를 통해 저장된 데이터 출력하기</h2>
	<p>
		el의 내장객체인 pageScope, requestScope, sessionScope, applicationScope를 명시하여 해당 영역에 있는 데이터 출력<br/>
		데이터 가져올 때 각 내장객체인 scope들은 생략 가능
		scope가 생략되면 pageScope => requestScope -> sessionScope -> applicationScope 순으로 찾음<br/>
		여러 scope에 동일한 속성을 기록하고 이름 충돌이 의심되면 명시적으로 scope를 지정해야 함
	</p>
	<h4>개인정보(${ year })</h4>
	이름 : ${ p.name }<br/>
	성별 : ${ p.gender }<br/>
	나이 : ${ p.age }<br/>
	<h4>취향정보</h4>
	${ p.name }님이 가장 좋아하는 음료 : ${ beverage }<br/>
	${ p.name }님이 가장 좋아하는 물건 : ${ products[0] } , ${products[1] } , ${products[2]} <br/>
	${ p.name }님이 가장 좋아하는 도서 : ${ book }<br/>
	${ p.name }님이 가장 좋아하는 영화 : ${ movie }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>