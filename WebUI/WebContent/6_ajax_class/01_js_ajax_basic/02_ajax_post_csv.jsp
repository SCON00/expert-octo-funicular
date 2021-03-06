<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script>
	var xmlHttp;
	window.onload = function() {
		// 1. 브라우저에 따른 XMLHttpRequest생성하기.
		xmlHttp = new XMLHttpRequest();
		// 2. 요청에 대한 응답처리 이벤트 리스너 등록.
		xmlHttp.onreadystatechange = on_ReadyStateChange;
		// 3.서버로 보낼 데이터 생성.
		// 3.데이터 생성.
		var data = "cate=book&name=hong";
		//###########################################################
		// 4. POST 방식으로 데이터 보내기, 응답은 비동기로 클라이언트<->서버간의 연결 요청준비.
		xmlHttp.open("POST", "02_server.jsp", true);
		xmlHttp.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded");
		// 5. 실제 데이터 전송.
		xmlHttp.send(data);

		//####			
		// T. 동기/비동기 실행 테스트를 위한 부분.
		alert("전송 시작!");
	}

	// 6.응답처리.
	function on_ReadyStateChange() {
		if (xmlHttp.readyState == 4) {
			if (xmlHttp.status == 200) { // 정상적으로 응답 받은 상태
				parseData(xmlHttp.responseText);
			} else {
				alert('에러');
			}
		}
	}

	//#################################################
	//7. CSV포맷  데이터 처리.
	function parseData(strText) {
		var arr = strText.split('|');
		for (var i = 0; i < arr.length; i++) {
			var param = arr[i].split('=');
			if (param[0].trim() == 'cate') {
				document.getElementById("cate").value = param[1];
			}
			if (param[0].trim() == 'name') {
				document.getElementById("name").value = param[1];
			}
		}

	}
</script>
</head>

<body>
	서버로부터 넘겨받은 데이터
	<br /> 첫번째 데이터 :
	<input type="text" name="" id="cate" />
	<br /> 두번째 데이터 :
	<input type="text" name="" id="name" />
	<br />
</body>
</html>


