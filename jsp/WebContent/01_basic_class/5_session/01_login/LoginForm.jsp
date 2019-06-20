<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<title> 로그인창 </title>
</head>
<body>

<h3>로그인 확인하기 </h3> 
<form action="LoginService.jsp" method="get">
사용자: <input name='User' type='text'><br/>
비밀번호: <input name='Pass' type='password'><br/>
<input type='submit' value='login'>&nbsp;<a href="/jsp/02_beans_class/3_member/MemberForm.jsp">회원가입</a>
</form>

</body>
</html>