<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="mvc.board.model.*" %>
<%@ page import="java.util.List" %>
 
<%  //웹브라우저가 게시글 목록을 캐싱할 경우 새로운 글이 추가되더라도 새글이 목록에 안 보일 수 있기 때문에 설정
	response.setHeader("Pragma","No-cache");		// HTTP 1.0 version
	response.setHeader("Cache-Control","no-cache");	// HTTP 1.1 version
	response.setHeader("Cache-Control","no-store"); // 일부 파이어폭스 버스 관련
	response.setDateHeader("Expires", 1L);			// 현재 시간 이전으로 만료일을 지정함으로써 응답결과가 캐쉬되지 않도록 설정
%>

<%
	String projectName = "/jsp";
	// 페이지 수를 얻어오기
	//int pageCount = (Integer)request.getAttribute("pageCount");
	// 전체 메세지 레코드 검색 
	List <BoardRec> mList =  (List<BoardRec>)request.getAttribute("param");
 	
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 게시글 목록 </title>
</head>

<BODY>

	<h3> 게시판 목록 </h3>
	
	<table border="1" bordercolor="darkblue">
	<tr>
		<td> 글번호 </td>
		<td> 제 목 </td>
		<td> 작성자 </td>
		<td> 작성일 </td>
		<td> 조회수 </td>
	</tr>
	

	<% if( mList.isEmpty() ) { %>
		<tr><td colspan="5"> 등록된 게시물이 없습니다. </td></tr>
	<% 
		} else { 
			for(BoardRec b : mList){
	%>		
		<tr>
			<td><%=b.getArticleId() %></td>
			<td>
				<% for(int i=0; i<b.getLevel(); i++) { %> 
					&nbsp;
				<% } %>
				<% if(b.getLevel() > 0){ %>
					<img alt="" src="/jsp/04_board_class/imgs/board_re.gif">
				<% } %>
				<a href='<%=projectName%>/board?cmd=article-page&article_id=<%=b.getArticleId()%>'><%=b.getTitle() %></a>
			</td>
			<td><%=b.getWriterName() %></td>		
			<td><%=b.getPostingDate() %></td>
			<td><%=b.getReadCount() %></td>
		</tr>

	<%
			} // end for
		} // end else 
	%>
	
		<tr>
			<td colspan="5">
				<a href="<%=projectName%>/board?cmd=input-page">글쓰기</a>
			</td>
		</tr>
	</table>
	<%-- 
	<!-- 페이지 번호 출력 -->
	<% for(int i = 1; i <= pageCount; i++) { %>
		<a href="<%=projectName%>/board?cmd=list-page&page=<%=i%>">[<%=i %>]</a>
	<% } // end of for %>
	 --%>
</BODY>
</HTML>
