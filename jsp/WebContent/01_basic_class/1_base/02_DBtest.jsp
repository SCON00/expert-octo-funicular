<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8"%>

<%
	// 1. 드라이버 로딩
	// 2. 연결객체 얻어오기
	// 3. sql 문장 만들기
	// 4. 전송 객체 얻어오기
	// 5. 전송
%>


<!DOCTYPE html>
<html><head><title> 디비 테스트 </title>
</head>
<body>
 
<div align=center>
<table border=2 cellSpacing=3>

  <tr class="title">
    <td>사번</td>
    <td>사원명</td>
    <td>업무</td>
    <td>관리자사번</td>
    <td>입사일</td></tr>


	  <tr>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
	  </tr>


</table>
</div>
</body>
</html>
