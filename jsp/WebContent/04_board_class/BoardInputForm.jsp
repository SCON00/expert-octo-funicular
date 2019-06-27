<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 글쓰기</title>
<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
<meta name="viewport" content="width=device-width" />
<link href="/jsp/bootstrap4/css/bootstrap.css" rel="stylesheet" />
<script type="text/javascript" src='/jsp/jquery/jquery-3.4.1.min.js'></script>
<script type="text/javascript" src='/jsp/bootstrap4/js/bootstrap.min.js'></script>
<script type="text/javascript">
$(function(){
	var frm = $('form[name="frm"]');
	// 작성 버튼이 눌렸을 때
	$('input[value="작성"]').click(function(){
		// 폼태그의 action 속성을 'BoardSave.jsp', submit() 호출
		frm.attr('action','/jsp/board?cmd=input-do').submit();
	});
});
</script>
</head>
 <body>
 <div class="container">

	<h4 class="display-4 mt-1 mb-1"> 게시판 글 쓰기 </h4>
	<p class="lead">나중에 이쁘게 만드시오</p>
	<form name='frm' method='post'>
	<div class="form-group row">
	<label for="writer_name" class="col-sm-3 col-form-label">작성자</label><input type='text' class="form-control col-sm-9" id="writer_name" name="writerName">
	</div>
	
	<div class="form-group row">
	<label for="article_title" class="col-sm-3 col-form-label">제 목</label><input type='text' class="form-control col-sm-9" id="article_title" name="title">
	</div>
	
	<div class="form-group row">
	<label for="article_content" class="col-sm-3 col-form-label">내 용</label><textarea rows='7' class="form-control col-sm-9" id="article_content" name='content'></textarea>
	</div>
	
	<div class="form-group row">
	<label for="article_password" class="col-sm-3 col-form-label">암호(수정/삭제시)</label><input type='password' class="form-control col-sm-9" id="article_password" name="password">
	</div>
	<div class="form-group row">
	<input type='button' class="btn btn-outline-primary col-sm-6" value='작성'>
	<input type='reset' class="btn btn-outline-secondary col-sm-6" value='취소'>
	</div>
	</form>
</div>	
</body>
</html>