<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.beans.*" %>
<!-- 하나씩 천천히 도전합시다 -->
<!-- 1. 폼의 입력값을 빈즈의 멤버변수 지정 -->
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="member" class="member.beans.Member">
	<jsp:setProperty name="member" property="*"/>
</jsp:useBean>

<!-- 2. JDBC 연동 -->
<%
	MemberDao dao = MemberDao.getInstance();
	dao.insertMember(member);
	session.setAttribute("id", member.getId());
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 회원가입 확인  </title>
</head>
<body>
	아이디 : <%= member.getId() %><br>
	패스워드 : <%= member.getPassword() %><br>
	이름 : <%= member.getName() %><br>
	전화 : <%= member.getTel() %><br>
	주소 : <%= member.getAddr() %><br>
	<a href="/jsp/01_basic_class/5_session/01_login/MainPage.jsp">메인으로</a>
</body>
</html>