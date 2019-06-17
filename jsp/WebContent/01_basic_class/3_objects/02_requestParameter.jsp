<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.Map" %>
<%
	// 0. 한글처리
	request.setCharacterEncoding("utf-8");
	// 1. 폼의 입력값을 얻어오기
	String name = request.getParameter("name");
	String address = request.getParameter("address");
	String[]pet = request.getParameterValues("pet");
%>
<!DOCTYPE html>
<html>
<head><title>요청 파라미터 출력</title></head>
<body>

<h5> 이전 화면에서 사용자의 입력값을 출력 </h5>
<%-- 3. 얻어온 입력값을 출력 --%>
이름 = <%= name %><br/>
주소 = <%= address %><br/>
펫 = <% for(String p : pet){ %>
&nbsp;<%= p %>
<% } %>
<h5> 방법 1 </h5>




<h5> 방법 2 </h5>



<h5> 방법 3 </h5>


</body>
</html>
