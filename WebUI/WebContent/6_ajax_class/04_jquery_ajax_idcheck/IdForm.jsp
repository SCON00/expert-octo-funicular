<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title> 아이디 중복 검사 </title>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	//$('#id_check').click(function(){
	$('.userinput').keyup(function(){	
		$.ajax({
			type : "POST",
			url : "IdCheck.jsp",
			data : {userid : $('input[name="id"]').val()},
			dataType : 'text',
			success : function(result){
				if(result.trim() == "YES"){
					$('#idmessage').text("이미 존재하는 아이디 입니다.");
					$('#idmessage').show();
				} else if (result.trim() == "NO"){
					$('#idmessage').text("사용가능한 아이디 입니다.");
					$('#idmessage').show();
				}
			},
			error : function(e){
				alert('error' + e.getText);
			}
		});
	});
});
</script>

</head>
<body>

<input name="id" type="text" class="userinput" size="15" />
<button type="button" id="id_check">중복체크</button><br/><br/>
<div id="idmessage" style="display:none;"></div>

</body>
</html>