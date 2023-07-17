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
	<c:if test="${ not empty param.fail }">
		<p>아이디 비밀번호를 확인해주세요.</p>
	</c:if>
	
	<c:if test="${ not empty cookie.lastId.value }" >
		<c:set var ="defaultChk">true</c:set>
	</c:if>
		
	<form action="loginprogress.jsp" method="post">
		<label>아이디<input type="text" name="id"  value="${ cookie.lastId.value }"/></label>
		<label>비밀번호<input type="password" name="password"/></label>
		<input type="checkbox" name="remember" id="remember" checked = ${ defaultChk ? "checked" : "" }/>
		<label for="remember">아이디 기억하기</label>
		<input type="submit" />
	</form>
	<a href="index.jsp">인덱스로</a>
</body>
</html>