<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="mvc.board.model.*" %>
 
<%
	// 0. 넘겨받는 한글 깨지지 않도록 지정
	request.setCharacterEncoding("UTF-8");

	// 2. Service클래스에 write() 함수호출	
	BoardRec result = (BoardRec)request.getAttribute("param");

	// 3. 화면을 리다이렉트로 바꾸기
	response.sendRedirect("/jsp/board?cmd=article-page&article_id=" + result.getArticleId());
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판글저장</title>
</head>
<body>
입력되었는지 확인해보시구염...<br/>
만일 안되어도..환장하지 맙시다 !!! ^^<br/><br/>
</body>
</html>