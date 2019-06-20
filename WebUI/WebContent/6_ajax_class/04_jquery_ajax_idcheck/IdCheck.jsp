<%@ page contentType="text/xml; charset=utf-8" %>
<%@ page language="java" import="java.sql.*"%>

<%
String driver="oracle.jdbc.driver.OracleDriver";
String user="team5";
String pass="1004";
String dbURL="jdbc:oracle:thin:@192.168.0.116:1521:orcl";


	Class.forName(driver);
	Connection connection=DriverManager.getConnection(dbURL,user,pass);
	
	String sql = "select * from membertest where name='" + request.getParameter("userid")+"'";
	System.out.println(sql);
	Statement stmt = connection.createStatement();
	ResultSet rs = stmt.executeQuery(sql);		

	String result="NO";
	if (rs.next()){		
		result = "YES";
	}
	rs.close();
	stmt.close();
	connection.close();
	out.print(result);
%>

