<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${id }회원님 ${age }살입니다.</h1>
<h1>시청 가능 영화 목록</h1>
<c:forEach var="movie" items="${moviemap}">
	<h3>${movie.key }</h3>
</c:forEach>
<video src="resources/multimedia/chrome.mp4" controls="controls" width=600 height=400 poster="resources/multimedia/chrome.jpg"></video>
</body>
</html>