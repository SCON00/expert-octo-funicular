<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	// 네이버 버튼이 눌렸을 때
	$('#naver').click(function(){
		$.ajax({
			type : "POST",
			url : "./jsp/proxy_naver.jsp",
			success : function(data){
				var rank = $('._PM_timesquare_wrapper', data);
				$('#result').empty();
				$('#result').append(rank);
			}
		});
	});
});
</script>
</head>
<body>
<h1>선택</h1>
<button id='naver'>네이버</button>
<button id='melon'>멜론</button>
<button id='daum'>다음</button>
<button id='kma'>날씨</button>
<br/>
<hr/>
<br/>
<div id='result'></div>
</body>
</html>