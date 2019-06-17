<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
		
<html>
<head><title>쿠키</title></head>
<body>

<b>Simple Cookie Example</b><hr>

<%	

	// 1. 해당하는 쿠키가 있다면 그 이름으로 새 쿠키를 만들고 유효시간을 0으로 지정하고 전송
	Cookie c = new Cookie("yourId","");
	c.setMaxAge(0);
	response.addCookie(c);
%>


<br><a href="01_GetCookie.jsp"> 쿠키검색 </a>

</body></html>