<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title> 고객관리 프로그램 </title>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript" >
$(function(){
	$('table:first input[type="button"]').click(function(){
		$.ajax({
			type : "post",
			data : {
				name : $('#name').val(),
				age : $('#age').val(),
				tel : $('#tel').val(),
				addr : $('#addr').val()
			},
			url : "DataInput.jsp",
			dataType : "text",
			success : function(result){
				if(result.trim() == "1"){
					$('#input_result').text(result.trim() + " 입력완료");
				} else {
					$('#input_result').text(result.trim() + " 결과값");
				}	
				getData();
			},
			error : function(e){
				$('#input_result').text(e.getText + " error");
			}
		});
	});
	
	$('table:nth-of-type(2) input').click(function(){
		getData();
	});
	
	function getData(){
		$.ajax({
			type : "post",
			url : "DataSelect.jsp",
			dataType : "xml",
			success : function(result){
				var person = $(result).find('person');
				var list = "<tr><td width='80'align='center'>Name</td><td width='50' align='center'>Age</td><td width='100' align='center'>Tel</td><td width='250' align='center'>Addr</td></tr>";
				
				for(var i=0; i<person.length; i++){
					list += "<tr>";
					list += "<td>" + person.eq(i).find('name').text() + "</td>";
					list += "<td>" + person.eq(i).find('age').text() + "</td>";
					list += "<td>" + person.eq(i).find('tel').text() + "</td>";
					list += "<td>" + person.eq(i).find('addr').text() + "</td>";
					list += "</tr>";
				}
				
				$('#listTable').html(list);
			}
		});
	}
});
</script>

</head>


<!-- <body> -->
<body>

<h2> 고객정보 입력 </h2>

<form name="inForm" method="post">
<table border = 1>
	<tr>
		<td width="80" align="center">Name</td>
		<td width="50" align="center">Age</td>
		<td width="100" align="center">Tel</td>	
		<td width="250" align="center">Addr</td>
	</tr>
	<tr>
		<td align="center"><input type="text" size="8" name="name" id="name"></td>
		<td align="center"><input type="text" size="4" name="age" id="age"></td>
		<td align="center"><input type="text" size="12" name="tel" id="tel"></td>
		<td align="center"><input type="text" size="30" name="addr" id="addr"></td>
	</tr>
	<tr>
		<td colspan="2" id="input_result"></td>
		<td colspan="2" align="center"> 
			<input type="button" value="입력">
		</td>
	</tr>
</table>

<br>

<hr>

<h2> 고객정보 목록보기  </h2>
<table border='0' width="510"> 
	<tr>
		<td align="right"><input type="button" value="가져오기"></td>
	</tr>
</table>
<table border = 1 id="listTable">
	<tr>
		<td width="80" align="center">Name</td>
		<td width="50" align="center">Age</td>
		<td width="100" align="center">Tel</td>	
		<td width="250" align="center">Addr</td>
	</tr>
</table>
<div id="myDiv"> </div>

</form>
</body>
</html>