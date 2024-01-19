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
<form action="login" method="post">
아이디<input type="text" name="id"><br>
암호<input type="password" name="pw"><br>
나이<input type="password" name="age"><br>
<input type="submit" value="저장">
</form>
</body>
</html>