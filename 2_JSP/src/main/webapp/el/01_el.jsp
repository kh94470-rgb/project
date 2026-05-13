<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%= request.getContextPath() %>/myEl.do" method="post">
		<h2>개인 정보 입력</h2>
		이름 : <input type="text" name="name" id="name"/> <br/>
		성별 : <input type="radio" name="gender" id="male" value="남"/>남자
			  <input type="radio" name="gender" id="female" value="여"/>여자<br/>
		나이 : <input type="number" name="age"/>
		
		<hr/>
		
		<h2>당신이 가장 좋아하는 ____은?</h2>
		<span class="user">OOO</span>님이 가장 좋아하는 음료는?
		<input type="text" name="beverage"/><br/>
		
		<span class="user">OOO</span>님이 가장 좋아하는 물건1은?
		<input type="text" name="product"/><br/>
		
		<span class="user">OOO</span>님이 가장 좋아하는 물건2는?
		<input type="text" name="product"/><br/>
		
		<span class="user">OOO</span>님이 가장 좋아하는 물건3은?
		<input type="text" name="product"/><br/>
		
		<span class="user">OOO</span>님이 가장 좋아하는 책은?
		<input type="text" name="book"/><br/>
		
		<span class="user">OOO</span>님이 가장 좋아하는 영화는?
		<input type="text" name="movie"/><br/>
		
		<br/>
		
		<input type="submit" value="전송"/>
	</form>
	<script>
		window.onload = () => {
			const name = document.getElementById('name');
			name.addEventListener('blur', e => {
				const value = e.target.value.trim();
				const users = document.getElementsByClassName('user'); 
				for(const user of users){
					user.innerText = value.length == 0 ? 'OOO' : value;
				}
				
			})
		}
	</script>
	
</body>
</html>