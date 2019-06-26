<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 
	1. import
	2. 이전 화면에서 넘어오는 cId 값을 얻어오기
	3. Service 에 함수를 호출
 -->
<%@ page import="mybatis.guest.service.*" %>

<%
	String cId = request.getParameter("cId");
	int result = CommentService.getInstance().deleteComment(cId);
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% if(result > 0){ %>
삭제성공
<% } else { %>
삭제실패
<% } %>
<hr/>
<a href="listComment.jsp">목록보기</a>
</body>
</html>