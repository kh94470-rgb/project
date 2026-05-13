<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#detailDiv{border: 1px solid black; margin: auto; margin-top: 100px; padding: 130px; width: 500px;}
	select, input[name=title]{height: 30px;}
	button{border: 1px solid black; width: 120px; padding: 15px; border-radius: 15px; background: white;}
	button:hover{background: black; color: white; cursor: pointer;}
	
	#replyDiv{border: 1px solid black; margin: auto; margin-top: 10px; padding: 13px; width: auto;}
 	#submitReply{border: 1px solid black; width: 60px; border-radius: 15px; background: white; height: 50px;} 
</style>
</head>
<body>
	<jsp:include page="../common/top.jsp"/>
	<jsp:include page="../common/loginbar.jsp"/>
	<div align="center" id="detailDiv">
		<form action="${ contextPath }/updateBoardPage.bo" method="post" id="detailForm">
			<table>
				<tr>
					<td colspan="6"><b>${ b.isNotice == 'Y' ? '[공지]' : ''}</b><br><br></td>
				</tr>
				<tr style="text-align: center;">
					<th width="25px" style="border-right: 1px solid black;">제목</th>
					<td width="80px" style="border-right: 1px solid black;">${ b.title }</td>
					<th width="25px" style="border-right: 1px solid black;">작성일</th>
					<td width="50px" style="border-right: 1px solid black;">${ b.createDate }</td>
					<th width="25px" style="border-right: 1px solid black;">조회수</th>
					<td width="20px">${ b.count }</td>
				</tr>
				<tr>
					<td colspan="6">
						<input type="hidden" name="bId" value="${ b.boardNo }">
						<textarea name="content" cols="67" rows="10" style="resize: none;" readonly>${ b.content }</textarea>
					</td>
				</tr>
			</table>
			<br><br>
			<c:if test="${ loginUser.empNO == b.empNo }">
				<button>수정하기</button>&nbsp;&nbsp;&nbsp;&nbsp;
				<button type="button" id="deleteButton">삭제하기</button>&nbsp;&nbsp;&nbsp;&nbsp;
			</c:if>
			<button type="button" id="listButton">목록으로 가기</button>
		</form>
		
		<br>
		<br>
		
		<div id="replyDiv">
			<table>
				<tr>
					<td colspan="2">
						<textarea rows="3" cols="50" id="replyContent" style="resize: none;" <c:if test="${ empty loginUser }">readonly placeholder='로그인 후 이용하세요'</c:if>></textarea>
					</td>
					<td><button id="submitReply" <c:if test="${ empty loginUser }">disabled</c:if>>등록</button></td>
				</tr>
				<tbody id="replyList">
					<c:if test="${ empty list }">
						<tr>
							<td colspan="3" align="center">
								<br>등록된 댓글이 없습니다.
								<br>이 게시글의 첫 댓글이 되어주세요!
							</td>
						</tr>
					</c:if>
					<c:if test="${ !empty list }">
						<c:forEach items="${ list }" var="r">
							<tr>
								<td width="80px">${ r.writer }</td>
								<td>${ r.content }</td>
								<td>${ r.createDate }</td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
		</div>
	</div>
	
	<script>
		window.onload = ()=>{
			document.getElementById('listButton').addEventListener('click', ()=>{
				location.href='${contextPath}/list.bo';
			});
			
			const deleteBtn = document.getElementById('deleteButton');
			if(deleteBtn != null){
				deleteBtn.addEventListener('click', () => {
					if(confirm('정말 삭제하시겠습니까?')){
						// 삭제 방법 1. form태그 action 바꿔주기
						//document.getElementById('detailForm').action = '${contextPath}/deleteBoard.bo';
						//document.getElementById('detailForm').submit();
						//이전 버튼 누르고 수정하기 누르면 deleteBoard.bo로 가서 다시 updateBoardPage로 되돌려놓기
						
						// 삭제 방법 2. get방식으로 데이터 보내기
						location.href = '${contextPath}/deleteBoard.bo?bId=' + btoa(${b.boardNo});
					}
				});
			}
			
			document.getElementById('submitReply').addEventListener('click', () => {
				const content = document.getElementById('replyContent');
				$.ajax({
					url: '${contextPath}/insertReply.bo',
					data: {content:content.value, bId:${b.boardNo}},
					type: 'post',
					success: data => {
						//console.log(data)
						content.value = '';
						selectReplyList();
					},
					error: data  => console.log(data)
				});
			});
			
			setInterval(() => {
				selectReplyList();
			}, 1000); 
	
		}
		
		const selectReplyList = () => {
			$.ajax({
				url: '${contextPath}/selectReplyList.bo',
				data: {bId:${b.boardNo}},
				dataType: 'json',
				success: data => {
					console.log(data)
					const replyList = document.querySelector('#replyList');
					replyList.innerHTML = '';
					if(data.length == 0){
						const tr = document.createElement('tr');
						const td = document.createElement('td');
						td.setAttribute('colspan', 3);
						td.setAttribute('align', 'center');
						td.innerHTML = '<br>등록된 댓글이 없습니다.<br>이 게시글의 첫 댓글이 되어주세요!';
						
						tr.appenChild(td);
						replyList.appendChild(tr);
					} else {
						for(const elm of data){
							const writer = elm.writer;
							const content = elm.content;
							const date = elm.cDate;
							
							const tr = document.createElement('tr');
							
							const td1 = document.createElement('td');
							const td1Val = document.createTextNode(writer);
							td1.appendChild(td1Val);
							td1.style.width = '80px';
							
							const td2 = document.createElement('td');
							const td2Val = document.createTextNode(content);
							td2.appendChild(td2Val);
							
							const td3 = document.createElement('td');
							const td3Val = document.createTextNode(date);
							td3.appendChild(td3Val);
							
							tr.appendChild(td1);
							tr.appendChild(td2);
							tr.appendChild(td3);
							replyList.appendChild(tr);
						}
					}
				},
				error: data => console.log(data)
			});
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	</script>
</body>
</html>