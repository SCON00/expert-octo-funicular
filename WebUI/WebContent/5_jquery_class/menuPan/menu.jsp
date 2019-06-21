<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="menu.model.*, menu.service.*, java.util.*" %>

<%
	ArrayList<MenuRec> result = MenuService.getInstance().selectAll();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style.css">
<script type="text/javascript" src='../lib/jquery-3.4.1.min.js'></script>
<script type="text/javascript">
	$(function() {
		var total = 0;
		$('.menuCount').each(function() {
			$(this).change(function(){
				var count = $(this).val();
				var item = $(this).parent().find('span');
				var mId = $(this).parent().find('input').val();
				
				if(count != 0){
					$('#listTable').append('<tr class="menuList"><td>' + item.eq(0).text() +'</td><td>' + count 
							+ "</td><td><input type='hidden' name='menuId' value='" + mId 
							+ "'/><input type='button' value='삭제' /></td></tr>");
					
					total += count * item.eq(1).text();
					$('#total').val(total);
				}
			});
		});
		
		$('#listTable').on('click','input[value="삭제"]',function(){
			
			var menuItem = $(this).parent().siblings();
			var subt = menuItem.eq(1).text() * $('.menu').find('span:contains('+menuItem.eq(0).text()+')').next().text();
			
			total -= subt;
			$('#total').val(total);
			$(this).parent().parent().remove();
		});
		
		$('#btn').click(function(){
			var data = $('#listTable').find('tr:gt(2)');
			var list = new Array();
			for(var i=0; i < data.length; i++){
				var menuCount = (data.eq(i).find('td').eq(1).text());
				var menuId = data.eq(i).find('input[type="hidden"]').val();
				
				var rs = {'menuId' : menuId, 'menuCount' : menuCount};
				list.push(rs);
			}
			
			$.ajax({
				type : "POST",
				data : {'list' :list},
				url : "OrderMenu.jsp",
				success : function(result){
					alert(result);
				}
			});
		});
	});
</script>
</head>
<body>


	<div id="leftdiv">
		<table class="menutbl">
			<tr id="menutitle">
				<th colspan=3 id="titleText">M E N U</th>
			</tr>
			<% for (int i = 0, k = 0; i < 3; i++){ %>
			<tr class="menus">
				<% 
					for (int j = 0; j < 3; j++,k++){ 
						MenuRec rec = result.get(k);
				%>
				<td id='menu<%=k %>' class='menu'><img src="<%=rec.getMenuImg() %>" /> <br />
					<span id='label<%=k%>' value='<%=rec.getMenuName()%>'><%=rec.getMenuName()%></span> <span id='price<%=k%>'
					value='<%=rec.getMenuPrice()%>'><%=rec.getMenuPrice()%></span>원 <br /> <select name="menu<%=k%>Count"
					id="menu<%=k%>Count" class='menuCount'>
						<option value='0'>0</option>
						<option value='1'>1</option>
						<option value='2'>2</option>
						<option value='3'>3</option>
						<option value='4'>4</option>
						<option value='5'>5</option>
				</select><input type="hidden" value='<%=rec.getMenuId()%>'/></td>
				<% } // end of for j %>
			</tr>
			<% } // end of for i %>
			
		</table>
	</div>

	<div id="rightdiv">
		<table id="listTable">
			<tr id="listtitle">
				<th colspan=3 id="titleText">주문내역</th>
			</tr>
			<tr id="totallist">
				<td colspan='3'>총합 : <input type='text' id='total' /> 원 <input
					type='button' value='주문하기' id='btn' />
				</td>
			</tr>
			<tr id="listtr">
				
				<td width="150">목록</td>
				<td width="100">갯수</td>
				<td width="50">삭제</td>
			</tr>

		</table>
	</div>

</body>
</html>