<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="resources/js/jquery-3.7.1.min.js"></script>
<script>
$(document).ready(function(){
	//deletebtn 버튼 클릭 시
	//prompt - 암호 입력하세요 - xxxx 리턴 저장
	//hiddenpw 값 읽어서 
	// 두개의 값 비교 같으면 delete sql
	// 두개의 값 비교 같지 않으면
	$("#deletebtn").on('click', function(){
		let rightPw = ${board.pw};
		//let rightPw = $("#hiddenpw").val();
		let userInput = prompt('암호를 입력하세요');
		
		if(rightPw == userInput) {
			window.location.href = 'boardupdate?seq=${board.seq}&title=${board.title}&contents=${board.contents}';
		} else {
			alert("암호를 확인하세요");
		}
	});
	
	$("#updatebtn").on('click', function(){
		let rightPw = ${board.pw};
		//let rightPw = $("#hiddenpw").val();
		let userInput = prompt('암호를 입력하세요');
		
		if(rightPw == userInput) {
			$("#f").attr("method", "post");
			$("#f").attr("action", "boardupdate");
			$("#f").submit();
		} else {
			alert("암호를 확인하세요");
		}
	});
});//ready
</script>
</head>
<body>
<!-- 1개 게시물 모델 (seq ~ writingtime) 출력 -->
<!-- 수정버튼 삭제버튼 -->
<form id="f">
<input name="seq" value="${board.seq}"><br>
<input name="title" value="${board.title}"><br>
<textarea cols=50 rows=5 name="contents">
${board.contents }
</textarea>
<input name="writer" value="${board.writer}"><br>
<input name="viewcount" value="${board.viewcount }"><br>
<input name="writingtime" value="${board.writingtime}"><br>
<input id="hiddenpw" type=hidden value="${board.pw}">

<input id="updatebtn" type=button value="수정버튼">
<input id="deletebtn" type=button value="삭제버튼">
</form>

</body>
</html>