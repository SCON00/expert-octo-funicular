<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<script  type="text/javascript"  src="libs/jquery-1.9.1.min.js"> </script>
<script type="text/javascript">
$(function(){
	var data = {cate : 'book', name : "홍"};
	$.post("02_server.jsp", data, parseData);
});

function parseData(strText){
	var arr = strText.split('|');
	for (var i = 0; i < arr.length; i++) {
		var param = arr[i].split('=');
		if (param[0].trim() == 'cate') {
			$("#cate").val(param[1]);
		}
		if (param[0].trim() == 'name') {
			$("#name").val(param[1]);
		}
	}
}
</script>

</head>


<body>
서버로부터 넘겨받은 데이터<br/>
첫번째 데이터 : <input type="text" name="" id="cate"/><br/>
두번째 데이터 : <input type="text" name="" id="name"/><br/>
</body>
</html>


