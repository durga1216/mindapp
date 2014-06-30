<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
    pageEncoding="ISO-8859-1"%>  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>pre-built</title>  
<style type="text/css">
body{
color:#ff9900;
}
img{
 width:100;
 height:100;
}
</style>
</head>  

<body>  
<form action="">
<%@page import="com.mindots.util.Utils"%>
<%@page import=" java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%
String imgLen="";

try{
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost/mpulpy","root","root");
	//Connection con=DriverManager.getConnection("jdbc:mysql://127.4.215.130:3306/glass", "adminejLNKKj", "SHcP4fCwMWqi");
PreparedStatement ps=con.prepareStatement("select * from storage");
ResultSet rs=ps.executeQuery();
while(rs.next()){
	  imgLen = rs.getString("photo");
	int len = imgLen.length();
	  byte [] rb = new byte[len];
	  InputStream readImg = rs.getBinaryStream("photo");
	  int index=readImg.read(rb, 0, len);  
	  System.out.println("index"+index);
	  response.reset();
	  response.setContentType("image/jpg");
	  response.getOutputStream().write(rb,0,len);
	  response.getOutputStream().flush(); 
}
}
catch(Exception e)
{ e.printStackTrace();
	}
%>
  <table>
  <tr><td><img alt="hjbjh" src="sample?idl=1"></td></tr>
  </table>
    </form>  
</body>  
</html>  