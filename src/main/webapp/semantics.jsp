<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mash Up</title>
<link rel="shortcut icon" href="favicon.ico" />
<script src="http://code.jquery.com/jquery-latest.js"></script>
<style>
body{
background-color:#FF9900;}
.head{
    color:#FFFFFF;
    font-family:verdana;
    font-size:40px;}
    
label{
font-family:verdana;
font-weight:bold;
font-size: 20px;
color:#ffffff;
width:200px;
margin-left:200px;
}
 .au2{
font-family:verdana;
font-weight:bold;
font-size: 20px;
color:#FF9900;
margin-left:500px;
width:23%;
height:30%;
background-color:#FFFFFF;
border-radius:50px;
padding:15px;
}
input[type="submit"]{

	color:#FFFFFF;
	font-size:20px;
	background-color:#FF9900;
	font-family:verdana;
	width:140px;
	height:50px;
	border:solid 2px;
	border-color:#FFFFFF;
	border-radius:50px;
	padding:10px;
	}
 .Param{
 font-family:verdana;
font-weight:bold;
font-size: 20px;
color:#FF9900;
margin-left:500px;
width:23%;
height:30%;
background-color:#FFFFFF;
border-radius:50px;
padding:15px;
 }
 

input[type="text"]{
color:#FF9900;
font-size:20px;
background-color:#FFFFFF;
font-family:verdana;
height:25px;
padding:10px;
}
select{color:#FF9900;
font-size:20px;
background-color:#FFFFFF;
margin-left:80px;
font-family:verdana;
width:300px;
height:50px;
padding:10px;}

table{
font-size:20px;
font-family:verdana;
border-color:#FFFFFF;
color:#FFFFFF;
margin-left:200px;
border-spacing:20px;

}

#name{
font-size:15px;
color:#FFFFFF;
font-family:verdana;
margin-left:80px;
}

#api{
font-size:15px;
color:#FFFFFF;
font-family:verdana;
margin-left:80px;
}
a{color:#FFFFFF;}
.au1{
font-family:verdana;
font-weight:bold;
font-size: 20px;
color:#FF9900;
width:23%;
height:30%;
margin-left:80px;
background-color:#FFFFFF;
border-radius:50px;
padding:15px;}

#indiv{color:#FFFFFF;
}
#na{
margin-top:0;
color:#FFFFFF;
font-size:15px;
font-family:verdana;
text-align:right;}

#re{
color:#FFFFFF;
font-size:15px;
font-family:verdana;
}
</style>
</head>

<body><form>
<div id=na><%=session.getAttribute("mail")%> &nbsp;|<a id="indiv" href='ApiDoc.jsp'>API Documentation</a>&nbsp;||&nbsp;<a id='indiv' href = 'logout.jsp'> Sign Out </a></div>
<br><br><div class="head"><center>Mind Pulpy</center></div><br><br>
<div class="au2"><center>PreBuild API's</center></div><br><br>
<%@page import="com.mindots.util.Utils"%>
<%@page import=" java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@include file="con.jsp" %>
<%
response.setHeader("Content-Type","text/html;charset=UTF-8");%>

<table color='#FFFFFF' height=100%>
<tr><td>API Key</label></td><td><input type='text' name='a1' value='SEM3694554054990A563752AF2A49CEF2199' placeholder='Enter your API_KEY here' style='width:350px;'required></td></tr>
<tr><td>API secret</label></td><td><input type='text' name='a2' value='YzZmYjc0YWRmYjlkMGUzNzk3NDhmZDdmZTA2ODU2Yzg' placeholder='Enter your API_KEY here' style='width:350px;'required></td></tr>
<tr><td>Request Method</td><td><input  type="text" name="fff" id="rf" value="Get" placeholder="Request Method"></td></tr>
<tr><td>Response Format</td><td><input type="text" name="rf" id="rm" value="JSON" placeholder="Response Format"></td></tr>
<tr><td>End Point URL</td><td><input  type="text" name="securl" id="endurl" value="https://api.semantics3.com/v1/products" placeholder="End_Point_URL" style="width:600px;"></td></tr><br>
</table>
<div class="Param"><center>Parameters</center></div><br>
<table color='#FFFFFF' height=100%>
<tr><th>Parameter_name</th><th>Example_Value</th><th>Scope</th></tr>
<tr><td>cat_id</td><td>4992</td><td><input  type="text" value="4992" name="p1" placeholder="value"></td></tr>
<tr><td>brand</td><td>Toshiba</td><td><input  type="text" value="Toshiba" name="p2" placeholder="value"></td></tr>
</table><br><br>
<center><input type="submit" name="submit" value="Continue" formAction="Semantics" formmethod="post"></center>

</form>

</body>
</html>
