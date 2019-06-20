<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.service.MemberService" %>
<%

	//# 1."id"로 저장된 세션값을 얻어온다.
	//# 2. 값이 null이라면 LoginForm.jsp로 페이지 이동
	//# 3. null이 아니라면 String 형변환하여 변수에 지정
	Object obj = session.getAttribute("id");
	
	if(obj == null){
		response.sendRedirect("/jsp/01_basic_class/5_session/01_login/LoginForm.jsp");
		return;
	}
	String user = (String)obj;
	
	// 멤버 이름 검색
	String mName = MemberService.getInstance().selectName(user);
%>
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
		이름 : <input type="text" name="guestName" required value='<%=mName %>' /><br/><br/>
		암호 : <input type="password" name="password" required /><br/><br/>
		메세지 : <textarea name="message" rows="3" cols="30" required></textarea><br/><br/>
		<input type="button" id='postMessage' value="메세지 남기기">
	</form>
</body>
</html>