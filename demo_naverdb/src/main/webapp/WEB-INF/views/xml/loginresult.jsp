<%@page import="springmvc.LoginDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
LoginDTO dto = (LoginDTO)request.getAttribute("dto");
%>
<h3>입력받은 id는 <%=dto.getId()%></h3>
<h3>입력받은 pw는 <%=dto.getPw()%></h3>
<hr>
<h3>입력받은 id는 ${login.id }</h3>
<h3>입력받은 pw는 ${login.pw }</h3>
</body>
</html>