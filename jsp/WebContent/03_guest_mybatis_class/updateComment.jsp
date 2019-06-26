<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="mybatis.guest.service.*, mybatis.guest.model.*" %>

<%
	request.setCharacterEncoding("UTF-8");
	Comment co = new Comment();
	co.setCommentNo(Integer.parseInt(request.getParameter("commentNo")));
	co.setUserId(request.getParameter("userId"));
	co.setCommentContent(request.getParameter("commentContent"));
	int result = CommentService.getInstance().updateComment(co);
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% if(result > 0){ %>
수정성공
<% } else { %>
수정실패
<% } %>
<hr/>
<a href="listComment.jsp">목록보기</a>
</body>
</html>