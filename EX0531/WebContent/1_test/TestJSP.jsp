<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.service.*, model.*, java.util.*"%>
<%
	List<TestModel> tm = TestService.getInstance().getList();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
	name='viewport' />
<meta name="viewport" content="width=device-width" />
<link href="../bootstrap4/css/bootstrap.css" rel="stylesheet" />
<link href="../bootstrap4/css/bootstrap-theme.css" rel="stylesheet" />
<link href="../bootstrap4/css/font-awesome.css" rel="stylesheet" />
<script type="text/javascript" src='../jquery/jquery-3.4.1.min.js'></script>
<script type="text/javascript" src='../bootstrap4/js/bootstrap.min.js'></script>
<script type="text/javascript">
$(function(){
	$('form').find('button').click(function(){
		
		$.ajax({
			type : "POST",
			data : {
				testName : $('#test_id').val(),
				testNumber : $('#test_number').val(),
				testCate : $('#test_category').val()
			},
			url : "AddMember.jsp",
			success : function(result){
				console.log(result);
				getData();
			},
			error : function(e){
				console.log(e);
			}
		});
	});
});
function getData(){
	$.ajax({
		type: "POST",
		url : "SelectTest.jsp",
		dataType : "json",
		success : function(result){
			var list = $('#member_list').empty();
			for(var i=0; i<result.length; i++){
				var data = "<tr><th scope='row'>";
				data += result[i].testId + "</th><td>";
				data += result[i].testName + "</td><td>";
				data += result[i].testNum + "</td><td>";
				data += result[i].testCate + "</td><td>";
				data += result[i].testDate + "</td></tr>";
				list.append(data);
				console.log(result[i]);
			}
			
		}
	});
}
</script>
</head>
<body class="bg-dark">

	<div class="container">
		<table class="table table-hover table-dark table-striped">
			<caption>List of users</caption>
			<thead>
				<tr>
					<th scope="row" colspan="5">
						<form class="form-inline">
							<div class="form-group mx-sm-3 mb-2">
								<label for="test_id" class="sr-only">Test ID</label>
								<input type="text" class="form-control" name="testName" id="test_id" placeholder="Test ID">
							</div>
							<div class="form-group mx-sm-3 mb-2">
								<label for="test_number" class="sr-only">Test Number</label>
								<input type="number" class="form-control" id="test_number" name="testNumber" placeholder="Test Number">
							</div>
							<div class="form-group mx-sm-3 mb-2">
								<label for="test_category" class="sr-only">Test Category</label>
								<input type="text" class="form-control" id="test_category" name="testCate" placeholder="Test Category">
							</div>
							<button type="button" class="btn btn-outline-light mx-sm-3 mb-2">등록</button>
						</form>
					</th>
				</tr>
				<tr>
					<th scope="col">Test ID</th>
					<th scope="col">Test NAME</th>
					<th scope="col">Test NUMBER</th>
					<th scope="col">Test CATEGORY</th>
					<th scope="col">Test DATE</th>
				</tr>
			</thead>
			<tbody id="member_list">

				<%
					for (TestModel t : tm) {
				%>
				<tr>
					<th scope="row"><%=t.getTestId()%></th>
					<td><%=t.getTestName()%></td>
					<td><%=t.getTestNum()%></td>
					<td><%=t.getTestCate()%></td>
					<td><%=t.getTestDate()%></td>
				</tr>
				<%
					} // end for
				%>
			</tbody>
		</table>
	</div>
</body>
</html>