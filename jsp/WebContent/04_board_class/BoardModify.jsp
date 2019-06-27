<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="obs.board.model.*,obs.board.service.*" %>
 
<%
	// 0. 넘겨받는 데이타의 한글 처리
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("articleId");
	String projectName = "/jsp";
	// 2. Service에 update() 호출하여 레코드 수정
	int result = (Integer)request.getAttribute("result");
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판글수정</title>
<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
<meta name="viewport" content="width=device-width" />
<link href="/jsp/bootstrap4/css/bootstrap.css" rel="stylesheet" />
<script type="text/javascript" src='/jsp/jquery/jquery-3.4.1.min.js'></script>
<script type="text/javascript" src='/jsp/bootstrap4/js/bootstrap.min.js'></script>
</head>
<body>

<%  // 게시글 수정이 성공적으로 되었다면 그 해당 게시글을 보여주는 페이지로 이동하고
    // 그렇지 않다면, "암호가 잘못 입력되었습니다"를 출력
	if(result > 0){
		response.sendRedirect(projectName + "/board?cmd=article-page&article_id="+id);
	} else {
%>
암호가 잘못 입력되었습니다.<a href="<%=projectName%>/board?cmd=article-page&article_id=<%=id%>">뒤로</a> 
<% } // end if %>
</body>
</html>