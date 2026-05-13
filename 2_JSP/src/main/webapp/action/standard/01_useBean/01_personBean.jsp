<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>JSP 표준 액션 중 useBean을 사용하여 VO클래스 객체 정보 불러와보기</h2>
<%-- 	<% Person person1 = new Person(); %> --%>
	<jsp:useBean id="person1" class="person.model.vo.Person" scope="request"/>
	<%= person1 %>
	
	<br/>
	
	이름 : <jsp:getProperty property="name" name="person1"/><br/>
	성별 : <jsp:getProperty property="gender" name="person1"/><br/>
	나이 : <jsp:getProperty property="age" name="person1"/><br/>
	
	<br/>
	
	<jsp:setProperty property="name" name="person1" value="강건강"/>
	<jsp:setProperty property="gender" name="person1" value="남"/>
	<jsp:setProperty property="age" name="person1" value="20"/>
	${ person1 }
	
	<hr/>
	
	<h2>view -> view 데이터 넘기기</h2>
	<form method="post" action="02_personEnd.jsp">
		<table>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"/></td>
			</tr>
			<tr>
				<td>성별</td>
				<td>
					남<input type="radio" name="gender" value="남"/>
					여<input type="radio" name="gender" value="여"/>
				</td>
			</tr>
			<tr>
				<td>나이</td>
				<td><input type="number" name="age"/></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="전송"/></td>
			</tr>
		</table>
	</form>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>