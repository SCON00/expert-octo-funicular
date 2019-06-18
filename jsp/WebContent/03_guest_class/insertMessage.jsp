<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 방명록 </title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	$('#postMessage').click(function(){
		var ip = $('form > [required]');
		for(var i = 0; i < ip.length; i++){
			if(ip.eq(i).val()==''){
				ip.eq(i).focus();
				return;
			}
		}
		$('form[name="frm"]').submit();
	});
});
</script>
</head>

<body>

	<form action="saveMessage.jsp" name="frm" method="post">
		이름 : <input type="text" name="guestName" required /><br/><br/>
		암호 : <input type="password" name="password" required /><br/><br/>
		메세지 : <textarea name="message" rows="3" cols="30" required></textarea><br/><br/>
		<input type="button" id='postMessage' value="메세지 남기기">
	</form>
</body>
</html>