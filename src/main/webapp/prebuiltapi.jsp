<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
    pageEncoding="ISO-8859-1"%>  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>File Upload</title>  
</head>  
<body>  
<form action="">
<table><tr>
<%@page import="com.mindots.util.Utils"%>
<%@page import=" java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%
try{
Class.forName("com.mysql.jdbc.Driver");
Connection cn=DriverManager.getConnection("jdbc:mysql://127.6.250.130:3306/mpulpy","adminPQ1iFfN","J5JhBL-XC9NG");
//Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/mpulpy","root","root");
PreparedStatement st1=cn.prepareStatement("SELECT * FROM authen1 WHERE id='MP_0102'");
ResultSet rs1 = st1.executeQuery();
while(rs1.next()){
	String ap=rs1.getString("appid");
	%>
<td><a href="prebuilt.jsp"><img alt="<%=rs1.getString("appid") %>" src="Apilogo?idl=<%=rs1.getString("appid") %>" width='100' height='100'></a></td>
	<% 
}
}
catch(Exception e)
{
	}
%>
</tr>
</table>
</form>
</body>  
</html>  