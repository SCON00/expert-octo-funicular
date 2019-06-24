<%@page import="org.json.simple.JSONObject"%>
<%@page import="com.google.gson.JsonArray"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="org.json.simple.*" %>
<%@ page import="com.google.gson.*" %>
<%@ page import="menu.model.*, menu.service.*" %>
<% 
	request.setCharacterEncoding("UTF-8");
	
	String str = request.getParameter("param");
    
    JsonParser jsonParser = new JsonParser();
    JsonArray jsonArray = (JsonArray) jsonParser.parse(str);
    
    int[]menuId = new int[jsonArray.size()];
    int[]menuCount = new int[jsonArray.size()];
    for(int k=0; k < jsonArray.size(); k++){
    	JsonObject jo = jsonArray.get(k).getAsJsonObject();
    	menuId[k] = jo.get("menuId").getAsInt();
    	menuCount[k] = jo.get("menuCount").getAsInt();
    }
    
    int result = MenuService.getInstance().insertOrder(menuId, menuCount);
    
	out.write(result);
%>