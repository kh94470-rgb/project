<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="person.model.vo.Person, java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String str1 = "안녕";
		String str2 = new String("안녕");
		
		int big = 10;
		int small = 3;
		
		Person p1 = new Person("강건강", '남', 20);
		Person p2 = new Person("강건강", '남', 20);
		
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add(str1);
		ArrayList<String> list2 = new ArrayList<String>();
		ArrayList<String> list3 = null;
		
		// page scope에 데이터 담기
		pageContext.setAttribute("str1", str1);
		pageContext.setAttribute("str2", str2);
		pageContext.setAttribute("big", big);
		pageContext.setAttribute("small", small);
		pageContext.setAttribute("p1", p1); 
		pageContext.setAttribute("p2", p2);
		pageContext.setAttribute("list1", list1);
		pageContext.setAttribute("list2", list2);
		pageContext.setAttribute("list3", list3);
		
	%>
	<h2>EL 연산</h2>
	\${ 10 * 7 } = ${ 10 * 7 }<br/>
	${ 100 / 3 } = ${ 100 div 3 }<br/>
	${ 15 % 4 } = ${ 15 mod 4 }<br/>
	
	<br/>
	
	스크립팅 : <%= str1 == str2 %><br/>
	el : ${ str1 == str2 } = ${ str1 eq str2 } = ${ str1.equals(str2) }<br/>
	el : ${ str1 != str2 } = ${ str1 ne str2 }
	
	<br/>
	
	${ big > small } = ${ big gt small }<br/>	
	${ big < small } = ${ big lt small }<br/>
	${ big >= small } = ${ big ge small }<br/>
	${ big <= small } = ${ big le small }<br/>
	
	<br/>
	
	스크립팅 : <%= p1 == p2 %><br/>
	el : ${ p1 == p2 } = ${ p1 eq p2 } 
	
	<br/>
	
	${ empty list1 }<br/>
	${ empty list2 } / ${ list2 == null }<br/>
	${ empty list3 } / ${ list3 == null }
	
	<br/>
	
	${ true && true } = ${ true and true }<br/>
	${ false || true } = ${ false or true }<br/>
	${ !true } = ${ not true }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>