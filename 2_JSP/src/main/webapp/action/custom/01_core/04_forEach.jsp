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
	<h3>c:forEach</h3>
<!-- 	for(int i = 1; i <= 6; i++){ => 변수 i, 시작 값 1, 끝 값 6 -->
	<c:forEach var="i" begin="1" end="6">
		<h${ i }>반복문 ${ i }</h${ i }>
	</c:forEach>
	
	<c:forEach var="i" begin="1" end="6" step="2">
		<h${ i }>반복문 ${ i }</h${ i }>
	</c:forEach>
	
	<c:forEach var="i" begin="1" end="6" >
		<h${ 7-i }>반복문 ${ 7-i }</h${ 7-i }>
	</c:forEach>
	
	<hr/>
	
	<h4>배열에 forEach 적용</h4>
	<%
		String[] nameArr = {"신형만", "봉미선", "신짱구", "신짱아"};
		request.setAttribute("family", nameArr);
	%>
	<h1>우리 가족 = scriptlet</h1>
	<ol>
		<% for(String str : nameArr){ %>
			<li><%= str %></li>
		<% } %>
	</ol>
	
	<h1>우리 가족 - custom Action Tag</h1>
	<ol>
		<c:forEach items="${ family }" var="str" varStatus="vs">
			<li>
				${ str }
				
			<!-- varStatus는 forEach에서 유용하게 사용할 만한 것들을 모아놓은 객체 -->
				<ul>
					<li>vs.first : ${ vs.first }</li>
					<li>vs.last : ${ vs.last }</li>
					<li>vs.index : ${ vs.index }</li>
					<li>vs.count : ${ vs.count }</li>
					<li>vs.current : ${ vs.current }</li>
				</ul>
			
			</li>
			
		</c:forEach>
	</ol>
	
	<h3>c:forTokens</h3>
	<c:set var="names" value="강건강,남나눔,도대담,류라라"/>
	<ul>
		<c:forTokens items="${ names }" delims="," var="n">
			<li>${ n }</li>
		</c:forTokens>
	</ul>
	
	<c:set var="multipleNames" value="문미미.박보배/송성실-윤예의 정재주.차청춘"/>
	<ul>
		<c:forTokens items="${ multipleNames }" delims="./- " var="n">
			<li>${ n }</li>
		</c:forTokens>
	</ul>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>