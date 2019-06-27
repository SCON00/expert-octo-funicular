<%@ page import="mvc.board.model.BoardRec"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
	String projectName = "/jsp";
%>
 
<%
	// 1. 부모게시물의 게시번호를 넘겨받기	
	String parentId = request.getParameter("parent_id");
	// 2. Service에 reply() 호출하여 답변글 등록하기
	BoardRec reRec = (BoardRec)request.getAttribute("result");

%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 답변 글 저장하기 </title>
<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
<meta name="viewport" content="width=device-width" />
<link href="/jsp/bootstrap4/css/bootstrap.css" rel="stylesheet" />
<script type="text/javascript" src='/jsp/jquery/jquery-3.4.1.min.js'></script>
<script type="text/javascript" src='/jsp/bootstrap4/js/bootstrap.min.js'></script>
</head>
<body>

답변글을 등록하였습니다. <br/><br/>

<a href="<%=projectName%>/board?cmd=list-page"> 목록보기 </a> &nbsp;
<a href="<%=projectName%>/board?cmd=article-page&article_id=<%=reRec.getArticleId()%>"> 게시글 읽기 </a>

</body>
</html>