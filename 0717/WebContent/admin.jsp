<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${ not empty admin }">
		<h1>관리자 페이지 메뉴</h1>
		<nav>
			<a href="#">어쩌구 저쩌구</a>
		</nav>
	</c:if>
	
	<c:if test="${ empty admin }">
		<p>로그인이 필요합니다.</p>
		<a href="loginform.jsp">로그인</a>
	</c:if>
	
	<a href="index.jsp">인덱스로</a>
</body>
</html>