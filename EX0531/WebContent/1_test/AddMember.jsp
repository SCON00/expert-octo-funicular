<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*, model.service.*, com.google.gson.*, java.util.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	JsonParser jsonParser = new JsonParser();
	JsonObject jo = jsonParser.parse(request.getParameter("param")).getAsJsonObject();

	TestModel tm = new TestModel();
	tm.setTestName(jo.get("testName").getAsString());
	tm.setTestNum(jo.get("testNumber").getAsInt());
	tm.setTestCate(jo.get("testCate").getAsString());
	
	List<TestModel> result = TestService.getInstance().getList();
	
	String str = new Gson().toJson(result);
	out.write(str);
%>