<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="mvc.board.model.*" %>
<%
	// 1. 프로젝트 경로
	String projectName = "/jsp";
	// 2. Service에 getArticleById()함수를 호출하여 그 게시글번호의 레코드를 검색
	BoardRec rec = (BoardRec)request.getAttribute("param");
	 
%>   
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 수정하기</title>
</head>
 <body>
	
<div class="container">

	<h4 class="display-4 mt-1 mb-1"> 게시판 글 수정하기 </h4>
	<p class="lead">나중에 이쁘게 만드시오</p>
	<form name='frm' method='post' action="<%=projectName%>/board?cmd=modify-do">
	<input type="hidden" name='articleId' value='<%=rec.getArticleId()%>'/>
	
	<div class="form-group row">
	<label for="article_title" class="col-sm-3 col-form-label">제 목</label><input type='text' class="form-control col-sm-9" id="article_title" name="title" value='<%=rec.getTitle()%>'>
	</div>
	
	<div class="form-group row">
	<label for="article_content" class="col-sm-3 col-form-label">내 용</label><textarea rows='7' class="form-control col-sm-9" id="article_content" name='content'><%=rec.getContent() %></textarea>
	</div>
	
	<div class="form-group row">
	<label for="article_password" class="col-sm-3 col-form-label">암호(수정/삭제시)</label><input type='password' class="form-control col-sm-9" id="article_password" name="password">
	</div>
	<div class="form-group row">
	<input type='submit' class="btn btn-outline-primary col-sm-6" value='수정하기'>
	<input type='reset' class="btn btn-outline-secondary col-sm-6" value='목록보기' onclick="window.location='<%=projectName%>/board?cmd=list-page'">
	</div>
	</form>
</div>	
</body>
</html>