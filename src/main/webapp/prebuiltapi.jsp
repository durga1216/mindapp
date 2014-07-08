<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
    pageEncoding="ISO-8859-1"%>  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>Prebuilt api</title> 
<link rel="shortcut icon" href="favicon.ico" />
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
  <script src="js/bootstrap/bootstrap.min.js"></script>
  <script src="js/theme.js"></script>
<style type="text/css">
body{
background-color:#ff9900;
}
h1{
color:#ffffff;
}
table,td{
padding:9px;
margin-left:100px;
}
img{
box-shadow: 7px 7px 15px 3px;
color:#000000;
border-radius: 8px;
}
a{
color:#ffffff;
font-size:20px;
font-family:verdana;
align:center;
}
</style>
</head>  
<script>

  $(function() {
    $('[data-toggle="tooltip"]').tooltip();
    });

        (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-49334062-1', 'humanapi.co');
  ga('send', 'pageview');

</script>
<body>  
<form action=""><br>
<center><h1>Pre-Built API's</h1></center><br><br>
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
PreparedStatement st1=cn.prepareStatement("SELECT * FROM authen1 WHERE id='MP_0120'");
ResultSet rs1 = st1.executeQuery();
while(rs1.next()){
	String ap=rs1.getString("appid");
	%>
<td><a href="prebuild.jsp?name=<%=rs1.getString("appid") %>"><img  src="Apilogo?idl=<%=rs1.getString("appid") %>" data-toggle="tooltip" title="" data-original-title="<%=rs1.getString("appname") %>" width='100' height='100'></a></td>
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