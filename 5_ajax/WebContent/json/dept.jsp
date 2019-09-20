<%@page import="json_jdbc.JsonDB"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// String data = JsonDB.getALLJsonDept();
	String deptno = request.getParameter("deptno");
	String data = JsonDB.getJsonDept(deptno);
	
	// 자바스크립트로 함수를 만든 후 jsp에서는 함수만 호출
%>

<%= data %>