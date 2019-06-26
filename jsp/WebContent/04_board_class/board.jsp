<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String projectName = "/jsp";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
<meta name="viewport" content="width=device-width" />
<link href="/jsp/bootstrap4/css/bootstrap.css" rel="stylesheet" />
<link href="/jsp/bootstrap4/css/bootstrap-theme.css" rel="stylesheet" />
<link href="/jsp/bootstrap4/css/font-awesome.css" rel="stylesheet" />
<script type="text/javascript" src='/jsp/jquery/jquery-3.4.1.min.js'></script>
<script type="text/javascript" src='/jsp/bootstrap4/js/bootstrap.min.js'></script>
</head>
<body>
<a href='<%=projectName %>/board?cmd=input-page' class="mt-2 btn btn-outline-primary btn-block">게시글 쓰기</a>

<a href='<%=projectName %>/board?cmd=article-page&article_id=2' class="mt-2 btn btn-outline-secondary btn-block">2번글 내용보기</a>

<a href='<%=projectName %>/board?cmd=list-page' class="mt-2 btn btn-outline-info btn-block">목록보기</a>
</body>
</html>