<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/js/jquery-3.7.1.min.js"></script>
<script>
$(document).ready(function(){
		alert($("#writer").val());
	$("#writerInformBtn").on('click', function() {
// 		alert('${sessionid } : '${sessionid});
		$.ajax({
			url: "getWriter",
			data: { writer: $("#writer").val()},
			type: 'get',
			dataType: 'json',
// 			url: "getWriter",
// 		    data: { writer: $("#writer").val()},
// 		    type: 'get',
// 		    dataType: 'json',
			success: function(response){
				/*
				String memberid;
				String pw;
				String membername;
				String phone;
				String email;
				String regdate;
				*/
				//writer 해당 이름, 이메일,폰번호, 가입일 
				//alert(response.memberid);
				alert(response);
				$("#writeinform").html(
					"<h3>이름 : " + response.membername + "</h3>" +
					"<h3>이름 : " + response.email + "</h3>" +
					"<h3>이름 : " + response.phone + "</h3>" +
					"<h3>이름 : " + response.regdate + "</h3>"
				);
				//$("#result").html("<h3>" + response.loginresult+"</h3>");
			},
			error: function(request, e){
				alert("코드="+request.status + " 메시지=" + request.responseText + " 오류=" + e);
			},
		});//ajax
	});
});
</script>
</head>
<body>
<form action="boardwrite" method="post">
제목<input type=text name="title"><br>
작성자<input type=text id="writer" name="writer" value="${sessionid }" readonly="readonly"><br>
글암호<input type=number name="pw"><br>
내용<textarea name="contents" rows="5" cols="50"></textarea><br>
<input type=submit value="글쓰기">
<input type=button id="writerInformBtn"  value="작성자정보보기">
</form>
<div id="writeinform"></div>
<!-- 
작성자정보보기 버튼 클릭시 writer 해당 이름, 이메일, 폰번호, 가입일 
getwriter url 호출 - writer value (get|post) 전송-ajax 요청
(컨트롤러 메소드
@RequestMapping("getWriter")
@xxxx
??? 메소드(???) - MemberDTO 객체 리턴
)

writer 해당 이름, 이메일,폰번호, 가입일 
ajax 요청 - ajax응답
-->
</body>
</html>