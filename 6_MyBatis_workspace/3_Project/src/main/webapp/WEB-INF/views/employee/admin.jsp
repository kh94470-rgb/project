<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	html, body{width: 99%; height: 98%;}
	#container{width: 99%; height: 75%; display: flex;}
 	#adminDiv{height: 100%; width: 15%; background: #111; display: inline-block;}
	.adminMenu{
		width: 95%; height: 60px; background: #888; text-align: center; margin: auto; 
		line-height: 60px; font-size: 20px; color: #eee;
	}
	.adminMenu:hover{font-weight: bold; cursor: pointer;}
	
	.menuContent{margin-left: 10px; width: 85%; height: 100%; display: none;} 
	
	#enrollDiv{margin: auto; padding: 130px;}
	#enrollDiv td{text-align: right;}
	.enrollInput{height: 30px; width: 200px;}
	.enrollInput.select{width: 208px;}
	#enrollButton{border: 1px solid black; width: 300px; padding: 15px; border-radius: 15px; background: white;}
	#enrollButton:hover{background: black; color: white; cursor: pointer;}

	#adminDiv+div{height: 92%; width: 80%; padding: 30px; overflow: scroll;}
	#adminDiv+div>table{width: 100%; text-align: center;}
	th{border-bottom: 1px solid black;}
	#adminDiv+div>table td{height: 35px;}
	
	#adminDiv+div>table td>div{
		border: 1px solid black; height: 80%; width: 45%; display: inline-block;
		padding-top: 3%; cursor: pointer;
	}
	.selectState{background: lightgray;}
	.unselectState{background: none;}
</style>
</head>
<body>
	<jsp:include page="../common/top.jsp"/>
	<jsp:include page="../common/loginbar.jsp"/>

	<hr>
	
	<div id="container">
		<div id="adminDiv">
			<h2 style="margin-left: 5px;">
				<a href="${ contextPath }" style="color: white;">
					JSP&amp;Servlet<br>
					JDBC Project
				</a>
			</h2>
			<div class="adminMenu">사원 전체 보기</div>
			<br>
			<div class="adminMenu">사원 등록 하기</div>
		</div>
		
		<div class="menuContent">
			<table id="empList">
				<tr>
					<th width="6%">사번</th>
					<th width="10%">이름</th>
					<th width="10%">직업</th>
					<th width="10%">매니저</th>
					<th width="10%">입사일</th>
					<th width="10%">급여</th>
					<th width="10%">커미션</th>
					<th width="10%">부서</th>
					<th width="12%">관리자</th>
					<th width="12%">활동여부</th>
				</tr>
				<c:if test="${ empty list }">
					<tr>
						<td colspan="10">조회된 리스트가 없습니다.</td>
					</tr>
				</c:if>
				<c:if test="${ !empty list }">
					<c:forEach items="${ list }" var="e" >				
						<tr>
							<td>${ e.empNO }</td>
							<td>${ e.empName }</td>
							<td>${ e.job }</td>
							<td>${ empty e.mgr ? '-' : e.mgr }</td>
							<td>${ e.hireDate }</td>
							<td>${ e.sal }</td>
							<td>${ e.comm }</td>
							<td>${ e.dept }</td>
							<%-- <td>${ e.isAdmin }</td> --%>
							<td>
								<div class="${ e.isAdmin == 'Y' ? 'selectState' : 'unselectState' }">Y</div>
								<div class="${ e.isAdmin == 'N' ? 'selectState' : 'unselectState' }">N</div>
							</td>
							<%-- <td>${ e.status }</td> --%>
							<td>
								<div class="${ e.status == 'Y' ? 'selectState' : 'unselectState' }">Y</div>
								<div class="${ e.status == 'N' ? 'selectState' : 'unselectState' }">N</div>
							</td>
						</tr>
					</c:forEach>
				</c:if>
			</table>
		</div>
		<div class="menuContent">
			<form action="${ contextPath }/insertEmp.me" method="post" id="enrollForm" name="enrollFrm">
				<div align="center" id="enrollDiv">
					<table>
						<tr>
							<td><label for="id">사원번호</label></td>
							<td><input type="text" name="id" id="id" class="enrollInput" required autofocus></td>
						</tr>
						<tr>
							<td colspan="2"></td>
						</tr>
						<tr>
							<td><label for="name">이름</label></td>
							<td><input type="text" name="name" id="name" class="enrollInput" size="25" required></td>
						</tr>
						<tr>
							<td><label for="job">직업</label></td>
							<td><input type="text" name="job" id="job" class="enrollInput" size="25" required></td>
						</tr>
						<tr>
							<td><label for="mgr">매니저</label></td>
							<td>
								<select name="mgr" class="enrollInput select">
									<option>---------------------------------------</option>
									<c:forEach items="${ list }" var="e">
										<c:if test="${ e.status == 'Y' }">
											<option value="${ e.empNO }">${ e.empName }</option>
										</c:if>
									</c:forEach>
								</select>
							</td>
						</tr>
						<tr>
							<td><label for="sal">급여</label></td>
							<td><input type="number" name="sal" class="enrollInput" id="sal" size="25" value="0"></td>
						</tr>
						<tr>
							<td><label for="comm">커미션</label></td>
							<td><input type="number" name="comm" class="enrollInput" id="comm" size="25" value="0"></td>
						</tr>
						<tr>
							<td><label for="dept">부서</label></td>
							<td>
								<select name="dept" class="enrollInput select">
									<option>---------------------------------------</option>
									<option value="10">ACCOUNTING</option>
									<option value="20">RESEARCH</option>
									<option value="30">SALES</option>
									<option value="40">OPERATIONS</option>
								</select>
							</td>
						</tr>
						<tr>
							<td><label for="isAdmin">관리자 여부</label></td>
							<td>
								<input type="checkbox" name='isAdmin' id="isAdmin" value="Y">
							</td>
						</tr>
					</table>
					<br>
					<button id="enrollButton">사원등록</button>
				</div>
			</form>
		</div>
	</div>
	
	<script>
		window.onload = () => {
			// 사원 전체보기를 클릭하면 분홍색 div만 나오게, 사원 등록 하기를 클릭하면 연두색 div만 나오게
			const adminMenus = document.getElementsByClassName('adminMenu');
			const menuContents = document.getElementsByClassName('menuContent');
			let validate = false;
// 			console.log(adminMenus);
// 			console.log(menuContents);
			adminMenus[0].addEventListener('click', () => {
				menuContents[0].style.display = 'block';
				menuContents[1].style.display = 'none';
			});
			adminMenus[1].addEventListener('click', () => {
				menuContents[1].style.display = 'block';
				menuContents[0].style.display = 'none';
			});
			
			document.getElementById('enrollButton').onclick = (e) => {
				const dept = document.getElementsByName('dept')[0];
// 				console.log(dept);
				console.log(dept.value);
				if(dept.value.indexOf('-') == 0){
					alert('부서는 필수 선택 항목입니다.');
					e.preventDefault();
					dept.focus();
				}
				
				if(!validate){
					alert('사원번호를 확인하세요');
					document.getElementById('id').focus();
					e.preventDefault();
				}
			}
			
			const afterEnroll = '${ param.afterEnroll }';
			if(afterEnroll == 'Y'){
				menuContents[0].style.display = 'block';
				menuContents[1].style.display = 'none';
			}
			
			
			document.getElementById('id').addEventListener('focusout', function(){
					const value = this.value.trim();
					const targetTd = this.parentElement.parentElement.nextElementSibling.children[0];
					if(value == ''){
						targetTd.innerText = '';
						validate = false;
					} else{
						$.ajax({
							url: '${contextPath}/checkEmpNo.me',
							data: {value:value},
							success: (data) => {
// 								console.log(data);
								if(data == 0){
									targetTd.innerText = '사용 가능한 사원번호입니다.';
									targetTd.style.color = 'green';
									validate = true;
								} else {
									targetTd.innerText = '중복된 사원번호입니다.';
									targetTd.style.color = 'red';
									validate = false;
								}
								targetTd.style.fontSize = '12px';
							},
							error: (res) => {
								console.log(res);
							}
						});
					}
			});
			
			const table = document.getElementById('empList');
			const stateButtons = table.querySelectorAll('div');
			//console.log(stateButtons);
			for(const button of stateButtons){
				button.addEventListener('click', function(){
					if(this.className == 'unselectState'){
						const myTd = this.parentElement;
						const myTr = myTd.parentElement;
						const myTrChildren = myTr.children;
						const empNo = myTrChildren[0].innerText;
						
						let clickColumnIndex;
						for(const index in myTrChildren){
							if(myTd == myTrChildren[index]){
								clickColumnIndex = index;
							}
						}
						
						const ths = table.querySelectorAll('th');
						const clickItem = ths[clickColumnIndex].innerText;
						
						$.ajax({
							url: '${contextPath}/updateState.me',
							data: {empNo:empNo, column:clickItem, value:this.innerText},
							type: 'post',
							success: data => {
								//console.log(data);
								if(data == 'success'){
									this.className = 'selectState';
									for(const siblings of myTd.children){
										if(siblings != this){
											siblings.className = 'unselectState';
										}
									}
									
									if(empNo == ${ loginUser.empNO } && this.innerText == 'N'){
										if(clickItem == '관리자'){
											$.ajax({
												url: '${contextPath}/updateSession.me',
												type: 'post',
												success: date => {
													alert('권한이 없습니다. 메인 페이지로 이동합니다.')
													location.href = '${contextPath}';
													
												}
												
											});
										} else{
											alert('탈퇴한 회원입니다. 자동 로그아웃 됩니다.');
											location.href = '${contextPath}/Logout.me';
										}
									}
								} else{
									alert('상태 변경을 실패하였습니다.');
								}
							},
							error: data => console.log(data)
						});
					}
				})
			}
		}
	</script>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>