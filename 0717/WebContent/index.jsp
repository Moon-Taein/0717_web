<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
</head>
<body>
	<nav>
		<c:choose>
			<c:when test="${ empty admin }">
				<a href="loginform.jsp">로그인</a>
			</c:when>
			<c:otherwise>
				<p>관리자님 환영합니다.</p>
				<a href="logout.jsp">로그아웃</a>
			</c:otherwise>
		</c:choose>
		<a href="admin.jsp">관리자 페이지</a>
	</nav>
</body>
</html>