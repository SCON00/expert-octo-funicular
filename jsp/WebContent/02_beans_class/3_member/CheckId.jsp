<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.beans.*" %>
<% request.setCharacterEncoding("UTF-8"); %>

<%
	String id = request.getParameter("userId");
	boolean result = MemberDao.getInstance().isDuplicatedId(id);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 아이디 중복 확인 </title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	$('form > input[type="button"]').click(function(){
		var ck = <%= result %>;
		if(ck){
			$("input[name='userId']").focus();
		} else {
			$("input[name='id']",opener.document).val(<%=id%>);
			window.close();
		}
	});
});
</script>
</head>
<body>
<%
	if(  result ) {
%>
		사용중인 아이디가 있습니다. 다시 입력하여 주십시오.
<%  }else { %>
		사용할 수 있는 아이디입니다.
<%  } %>

<hr/>
<form>
	<input type='text' name='userId' value='<%=id%>' />
	<input type='submit' value='중복확인'/>
	<input type='button' value='아이디사용'/>
	
</form>
</body>
</html>