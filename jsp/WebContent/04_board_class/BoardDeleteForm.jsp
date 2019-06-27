<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="obs.board.service.*,obs.board.model.*" %>
<%
	// 1. 삭제할 레코드의 게시글번호 넘겨받기
	String id = request.getParameter("article_id");
	String projectName = "/jsp";
%>       
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 게시글 삭제하기 </title>
<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
<meta name="viewport" content="width=device-width" />
<link href="/jsp/bootstrap4/css/bootstrap.css" rel="stylesheet" />
<script type="text/javascript" src='/jsp/jquery/jquery-3.4.1.min.js'></script>
<script type="text/javascript" src='/jsp/bootstrap4/js/bootstrap.min.js'></script>
</head>
<body>
<div class="container">
<form method="post" action="<%=projectName%>/board?cmd=delete-do">
	<!-- <p class="lead">삭제할 글암호를 입력하세요</p>
	<input type="password" name="password"> -->
	<!-- 게시글번호를 다음 페이지로 넘기기 위해 hidden 태그로 지정 -->
	<input type="hidden" name="article_id" value="<%=id %>"/>
	<input type="submit" class="btn btn-outline-primary" value="삭제하기">
	<div class="input-group">
  <input type="password" class="form-control" placeholder="Article Password" aria-label="Article's password" aria-describedby="button-addon2" name="password">
  <div class="input-group-append">
    <input class="btn btn-outline-secondary" type="submit" id="button-addon2" value='삭제하기'/>
  </div>
</div>
</form>
</div>
</body>
</html>