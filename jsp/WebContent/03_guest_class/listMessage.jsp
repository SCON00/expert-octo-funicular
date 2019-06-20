<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="guest.model.*,guest.service.*"%>
<%@ page import="java.util.List"%>

<%
	
	ListMessageService lms = ListMessageService.getInstance();
	// 페이지 수를 얻어오기
	int pageCount = lms.getTotalPage();
	// 페이지 번호 받기
	String pNum = request.getParameter("page");
	// 전체 메세지 레코드 검색 
	List <Message> mList =  lms.getMessageList(pNum);
 	
%>
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
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록 목록</title>
<%-- <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	console.log(<%= mList.size() %>);
});
</script> --%>
</head>
<body>
	<%= user %>
	<% if(mList.isEmpty()) { %>
	남겨진 메세지가 하나도~~없습니다.
	<br>
	<% } else { %>
	<table border="1">

		<% for(Message m : mList){ %>
		<tr>
			<td><%= m.getMessageId() %></td>
			<td><%= m.getGuestName() %></td>
			<td><a href="deleteMessage.jsp?messageId=<%= m.getMessageId() %>">[삭제하기]</a></td>
		</tr>
		<tr>
			<td colspan='3'>
			<textarea cols=35 rows=3 style="font-family: '돋움', '돋움체'; font-size: 10pt; font-style: normal; line-height: normal; color: #003399; background-color: #D4EBFF; border: 1 solid #00009C;"><%= m.getMessage() %></textarea>
			</td>
		</tr>
		<% } // end of for %>
	</table>

	<% } // end if-else %>

	<a href="insertMessage.jsp">글쓰기</a><br/>
	<!-- 페이지 번호 출력 -->
	<% for(int i = 1; i <= pageCount; i++) { %>
		<a href="listMessage.jsp?page=<%=i%>">[<%=i %>]</a>
	<% } // end of for %>
	<%=pageCount %> 페이지
</body>
</html>