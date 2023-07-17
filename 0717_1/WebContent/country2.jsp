<%@page import="country.CountryDAO"%>
<%@page import="country.CountryDAOMySQL"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="country.Country"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%
	try{
		String continent = request.getParameter("continent");
	
		CountryDAO dao = new CountryDAOMySQL();
		List<Country> list = dao.getByContinent(continent);
	
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/countryView.jsp").forward(request, response);
	} catch(Exception e) {
		response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		out.println("요청 처리 중 에러 발생, 관리자에게 문의하세요");
	}
	%>
