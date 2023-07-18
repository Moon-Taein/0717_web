<%@page import="country.CountryDTO"%>
<%@page import="country.CountryService"%>
<%@page import="country.CountryDAOMySQL"%>
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
		String pageStr = request.getParameter("page");
		Integer pageNum = pageStr == null? 1 : Integer.valueOf(pageStr);
		final int pagePer = 10;
		
		CountryService service = new CountryService();
		CountryDTO dto = service.getPage(pageNum, pagePer);
			
		request.setAttribute("list", dto.getList());
		request.setAttribute("wholePages", dto.getTotalPage());
		request.getRequestDispatcher("/WEB-INF/countryView.jsp").forward(request, response);
		
	} catch (Exception e){
		response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		out.println("요청 처리 중 에러 발생, 관리자에게 문의하세요");
	}
%>
