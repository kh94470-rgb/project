<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#loginDiv{border: 1px solid black; margin: auto; margin-top: 150px; padding: 150px; width: 500px;}
	#loginDiv>label:hover{font-weight: bold; text-decoration: underline; cursor: pointer;}
	input{height: 30px;}
</style>
</head>
<body>
	<jsp:include page="../common/top.jsp"/>
	<form action="${ contextPath }/login.me" method="post" id="loginForm">
		<div align="center" id="loginDiv">
			<table>
				<tr>
					<td align="right"><label for="id">사원번호</label></td>
					<td><input type="text" name="id" id="id" size="25" autofocus></td>
				</tr>
				<tr>
					<td align="right"><label for="pwd">비밀번호</label></td>
					<td><input type="password" name="pwd" id="pwd" size="25"></td>
				</tr>
			</table>
			<br>
			<label onclick="doLoginLabel();">로그인</label>&nbsp;&nbsp;&nbsp;&nbsp;
			<label id="findIdPwdLabel">ID/PW 찾기</label>&nbsp;&nbsp;&nbsp;&nbsp;
		</div>
	</form>
	
	<script>
		const doLoginLabel = () => {
			const id = document.getElementById('id');
			const pwd = document.getElementById('pwd');
			// 사원 번호가 비어있으면 "사원번호를 입력하세요" 알림창 후 해당 필드로 커서 올라가기
			// 비밀번호가 비어있으면 "비밀번호를 입력하세요" 알림창 후 해당 필드로 커서 올라가기
			// 모든 값이 들어가 있으면 해당 form 제출
			
			if(id.value.trim() == '' ){
				alert('사원번호를 입력하세요');
				id.focus();
			}else if(pwd.value.trim() == ''){
				alert('비밀번호를 입력하세요');
				pwd.focus();
			}else{
				document.getElementById('loginForm').submit();
			}
			
		}
		
		window.onload = () => {
			// 사원번호 필드 혹은 비밀번호 필드에서 엔터를 치면 제출되는 코드 작성
			const inputIdPw = document.getElementsByTagName('input');
			for(const elm of inputIdPw){
// 				console.log(elm);
				elm.addEventListener('keyup', (e) => {
// 					console.log(e.key);
					if(e.key == 'Enter'){
						doLoginLabel();
					}
				})
			}
			
		}
	
	
	
	
	
	
	
	
	
	
	
	
	</script>
</body>
</html>