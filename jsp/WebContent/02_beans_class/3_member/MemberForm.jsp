<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	function openWin(){
		var id = document.frm.id.value;
		window.open("CheckId.jsp?userId="+id,"","width=400, height=250");
	}
	
</script>
</head>
<body>

	<h1>회원가입서 작성하기</h1>

	<form action="InsertMember.jsp" method="post" name="frm">
		<table>
			<tr>
				<td width="100"><font color="blue">아이디</font></td>
				<td width="100"><input type="text" name="id"> <input
					type="button" value="중복확인" onclick="openWin()"><br /></td>
			</tr>
			<tr>
				<td width="100"><font color="blue">비밀번호</font></td>
				<td width="100"><input type="password" name="password" /><br />
				</td>
			</tr>
			<tr>
				<td width="100"><font color="blue">비밀번호학인</font></td>
				<td width="100"><input type="password" name="repassword" /><br />
				</td>
			</tr>
			<tr>
				<td width="100"><font color="blue">이름</font></td>
				<td width="100"><input type="text" name="name" /><br /></td>
			</tr>
			<tr>
				<td width="100"><font color="blue">전화번호</font></td>
				<td><input type="text" size="15" name="tel" /> <br /></td>
			</tr>
			<tr>
				<td width="100"><font color="blue">주소</font></td>
				<td><input type="text" size="50" name="addr" /><br /></td>
			</tr>
			<tr>				
				<td width="100">
					<input type="submit" value="회원가입">					
				</td>
				<td width="100"><input type="reset" name="cancel" value="취소"><br />
				</td>
				<td>
					<!--로그인 버튼--><a href="/jsp/01_basic_class/5_session/01_login/LoginForm.jsp">로그인</a> 
				</td>
			</tr>
		</table>
	</form>



</body>
</html>
