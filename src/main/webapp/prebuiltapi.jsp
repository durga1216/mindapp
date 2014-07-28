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
#na{
margin-top:0;
color:#FFFFFF;
font-size:18px;
font-family:verdana;
text-align:right;}
h1{
color:#ffffff;
}
table,td{
padding:9px;
margin-left:100px;
}
#t2 td{
padding:10px;
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
#bak a{
color:#ffffff;
margin-left:50px;
font-size:25px;
border:solid 2px #ffffff;
padding:10px;
border-radius:20px;
width:70px;
}
input[type=text]{
color:#ff9900;
height:25px;
}
#cl{
height:20px;
color:#ffffff;
}
#oth{
border:solid 2px #ffffff;
width:200px;
}
#na a{ 
padding:5px;
font-size:20px;
background-color:#ffffff;
color:#ff9900;
border:solid 1px #ccc;
border-radius:10px;
text-decoration:none;
}
sup { vertical-align: 3.5ex; 
padding:2px;
font-size:15px;
background-color:blue;
color:#ffffff;
border-radius:5px;}
</style>
<script type="text/javascript">
function load2(){
	window.open("https://mindtools-inputs.rhcloud.com/index.jsp", '_blank');
}
</script>
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
<script>
$(document).ready(function(){
	$('img[name=tst]').click(function(){
		$('#oth').show();
	});
});
</script>
<body>  
<form action="">
<br>
<div id=na><%=session.getAttribute("mail")%> &nbsp;<a href='logsucess.jsp'>Home</a>&nbsp;&nbsp;<a id="indiv" href='ApiDoc.jsp'>API Documentation</a>&nbsp;&nbsp;<a id="indiv" href='javascript:load2()'>Apps Builder</a><sup>Try it.!</sup>&nbsp;&nbsp;&nbsp;<a id="indiv" href= 'logout.jsp'> Sign Out </a></div>
<br><hr><br>
<center><h1>Pre-Built API's</h1></center><br>
<table><tr>
<%@page import="com.mindots.util.Utils"%>
<%@page import=" java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@include file="con.jsp" %>
<%
try{
PreparedStatement st1=cn.prepareStatement("SELECT * FROM authen1 WHERE id='MP_0120'");
ResultSet rs1 = st1.executeQuery();
while(rs1.next()){
	String ap=rs1.getString("appid");
	%>
<td><a href="prebuild.jsp?name=<%=rs1.getString("appid") %>"><img  src="Apilogo?idl=<%=rs1.getString("appid") %>" data-toggle="tooltip" title="" data-original-title="<%=rs1.getString("appname") %>" width='100' height='100'></a></td>
	<% 
}
%>
</tr></table><br>
<center><h1>MashUp Pre-Built API's</h1></center>
<div id=t2><table><tr>
<td><a href="prebuilt1.jsp?name=MPAPP_0579"><img  src="images/p2.jpg" data-toggle="tooltip" title="" data-original-title="Upto75-Eventfull-Asklaila" width='120' height='120'></a></td>
<td><a href="prebuilt1.jsp?name=MPAPP_0613"><img  src="images/event.jpg" data-toggle="tooltip" title="" data-original-title="Eventbrite-Eventfull-Seatgeek" width='120' height='120'></a></td>
<td><a href="prebuilt1.jsp?name=MPAPP_0615"><img  src="images/jobs.jpg" data-toggle="tooltip" title="" data-original-title="Indeed-Careerbuilder-Glassdoor" width='120' height='120'></a></td>
<td><a href="semantics.jsp"><img  src="images/sem.jpg" data-toggle="tooltip" title="" data-original-title="Semantics 3" width='120' height='120'></a></td>
<td><center><div id=oth style="display:none"><div id=cl>EventFull city name</div><input type="text"><br>
<input type="submit" value="Tweet Events" onsubmit=""><br></div></center><img name="tst" src="images/social2.png" data-toggle="tooltip" title="" data-original-title="" width='120' height='120'></td></tr>
</table></div>
<
<%
}
catch(Exception e)
{
	}
%>

</form>
</body>  
</html>  