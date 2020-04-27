<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>content.jsp</title>
</head>
<body>
	<table border="1">
		<tr><th>번호</th><th>이름</th></tr>
		<c:forEach items="${list }" var="dto">
			<tr><td>${dto.id }</td><td>${dto.name }</td></tr>
		</c:forEach>
		<tr><td colspan="2"><a href="save_view">등록</a></td></tr>
	</table>
</body>
</html>