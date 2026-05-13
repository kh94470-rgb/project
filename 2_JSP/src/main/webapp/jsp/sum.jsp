<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, java.util.HashMap"
    errorPage="error/errorPage.jsp"%>
<%@ page import="java.util.HashSet" %>
<%--
	page 지시자 : 현재의 JSP페이지를 컨테이너에서 처리하는데 필요한 각종 속성 기술(보통 소스 맨 앞에 위치)
		language 	: 사용할 스크립트 언어 유형 지정
		contentType : 웹 브라우저가 받아올 페이지의 인코딩 방식
		pageEncoding: JSP파일에 기록된 소스코드 자체의 인코딩 방식
		import		: 자바의 import와 같음
		errorPage 	: 현재 페이지에서 오류가 발생할 경우 호출할 페이지 지정 
		isErrorPage	: 에러를 처리하는 페이지인지 기술, 기본 값 false이고 true로 두면 exception객체 사용 가능
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- HTML주석 : 페이지 소스보기에 노출 o = 클라이언트에 전달-->
	<%-- JSP 주석 : 페이지 소스보기에 노출 x = 클라이언트에 전달 안 됨 --%>
	<% // 자바코드를 기술할 수 있음
		int total = 0;
		for(int i = 1; i <= 10; i++){
			total += i;
	%>
			<h6 id="hehe">헤헤</h6>
	<% 
		}
		
		ArrayList<String> list = new ArrayList<String>();
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		HashSet<String> set = new HashSet<String>();
		
		list.add(null);
		System.out.println(list.get(0).charAt(0));
	%>
	expression 출력 : 1부터 10까지의 합은
	<span style='color: red;'><%= total %></span>입니다.
	<br/>
	scriptlet 출력 : 1부터 10까지의 합은
	<span style="color: blue;"><% out.println(total); %></span>입니다.
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>