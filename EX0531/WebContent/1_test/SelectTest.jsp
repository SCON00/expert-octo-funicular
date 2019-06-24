<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*, model.service.*, java.util.*"%>

<%
	List<TestModel> tm = TestService.getInstance().getList();
	out.write(tm.toString());
%>
