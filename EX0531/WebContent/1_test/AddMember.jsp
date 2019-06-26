<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*, model.service.*, com.google.gson.*, java.util.*" %>
<%
	request.setCharacterEncoding("UTF-8");

	TestModel tm = new TestModel();
	tm.setTestName(request.getParameter("testName"));
	tm.setTestNum(Integer.parseInt(request.getParameter("testNumber")));
	tm.setTestCate(request.getParameter("testCate"));
	
	int result = TestService.getInstance().addMember(tm);
	
	out.write(result);
%>