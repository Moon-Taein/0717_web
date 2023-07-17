<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = (String) request.getParameter("id");
	String password = (String) request.getParameter("password");

	System.out.println("사용자 로그인 시도: " + id);
	System.out.println("사용자 로그인 시도: " + password);
	
	String adminId = (String) application.getInitParameter("adminId");
	String adminPassword = (String) application.getInitParameter("adminPassword");
	
	// 로그인 과정 성공했을때 쿠키 생성
	// 쿠키의 유무에 따라 로그인폼에 value 자동 생성 해주기?
	if(id.equals(adminId) && password.equals(adminPassword)){
		System.out.println("관리자 인증 성공");
		if(request.getParameter("remember") != null){
			Cookie cookie = new Cookie("lastId", id);
			response.addCookie(cookie);	
		} else {
			Cookie cookie = new Cookie("lastId", "");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		session.setAttribute("admin", id);
		System.out.println(session.getAttribute("admin"));
		
		response.sendRedirect("index.jsp");
	} else {
		System.out.println("관리자 인증 실패");
		
		response.sendRedirect("loginform.jsp");
	}

%>