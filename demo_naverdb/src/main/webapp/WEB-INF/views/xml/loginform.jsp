<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1><%=request.getAttribute("title") %></h1>
<h1>${title}</h1>
<form action="/mvc/loginresult" method="post">
아이디<input type="text" name="id" id="id"><br>
비밀번호<input type="password" name="pw" id="pw"><br>
<input type="submit" value="저장">
</form>
</body>
</html>