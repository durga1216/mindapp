<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mind Pulpy</title>
<script src="js/jquery-latest.js"></script>
<link rel="shortcut icon" href="favicon.ico" />
</head>
<style>
.head{
    color:#ffffff;
    font-family:verdana;
    font-size:35px;
    font-weight:bold;
}
body{
background-color:#ff9900;

}
option{
font-size:20px;
background-color:#ff9900;
}
select{
border-color:#ff9900;
color:#ffffff;
font-size:20px;
margin-left:80px;
background-color:#ff9900;
font-family:verdana;
width:440px;
height:60px;
padding:10px;
}

input[type="text"]{
color:#ff9900;
font-size:17px;
background-color:#ffffff;
margin-left:80px;
font-family:verdana;
width:400px;
height:25px;
padding:10px;
} 
#pa{
  font-family:verdana;
  font-size:20px;
  color:#FFFFFF;
  margin-left:80px;
  }
  th{
  padding:10px;
  text-align:left;
  font-size:25px;
  font-weight:bold;
  }
  tr{
  font-size:20px;
  padding:13px;}
  a{
   color:#ffffff;
   font-size:25px;
  }
  #oth{
  float:right;
  margin-right:100px;
  }
  
  p{
  font-size:25px;
  margin-left:550px;
  font-weight:bold;
  }
#na{
color:#ff9900;
margin-left:1px;
font-size:20px;
background-color:#ffffff;
font-family:verdana;
width:200px;
height:15px;
padding:10px;
}
input[type="submit"]{

color:#ffffff;
font-size:20px;
background-color:#ff9900;
font-family:verdana;
width:140px;
height:50px;
border:solid 2px;
border-color:#ffffff;
border-radius:50px;
padding:10px;
}
th,td,p{
color:#ffffff;
}
</style>
<script>
function myFunction() {
    var x = document.getElementById('apid').value;
    var ur="prebuild.jsp?ai="+x+"";
	window.location=""+ur+"";


}
</script>
<body><div class="head">

<center>Developer Console</center></div>
<form >
<%@page import="com.mindots.util.Utils"%>
<%@page import=" java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%
response.setHeader("Content-Type","text/html;charset=UTF-8");%>

<select id='apid' name='appid' onchange='myFunction()'><option value='dummy'>--Choose Your APP_ID Here--</option>
<%
String id1=(String) session.getAttribute("id");
try{
Class.forName("com.mysql.jdbc.Driver");
Connection cn=DriverManager.getConnection("jdbc:mysql://127.6.250.130:3306/mpulpy","adminPQ1iFfN","J5JhBL-XC9NG");
//Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/mpulpy","root","root");
PreparedStatement st1=cn.prepareStatement("SELECT * FROM authen1 WHERE id=?");
st1.setString(1,"MP_0021");
ResultSet rs1 = st1.executeQuery();
while(rs1.next()){
	String ap=rs1.getString("appid");
	String nme=rs1.getString("appname");
    out.println("<option value='"+ap+"'>"+nme+"</option>");

}
out.println("</select><br>");
String xx=request.getParameter("ai");
session.setAttribute("xx",xx);
PreparedStatement st2=cn.prepareStatement("SELECT * FROM config WHERE appid=?");
st2.setString(1,xx);
ResultSet rs2 = st2.executeQuery();
boolean empty = true;
%>
<br><br><br><br>
<table align='center'  border='0' bordercolor='#ffffff' style='width:700px;'>
<tr><th>Parameter</th><th>Example_Value</th><th>Param_Value</th></tr>
<%
String el=request.getParameter("au");
session.setAttribute("el",el);
while(rs2.next()){
	String pa1=rs2.getString("p1");String pva1=rs2.getString("pv1");
    String pa2=rs2.getString("p2");String pva2=rs2.getString("pv2");
    String pa3=rs2.getString("p3");String pva3=rs2.getString("pv3");
    String pa4=rs2.getString("p4");String pva4=rs2.getString("pv4");
    String pa5=rs2.getString("p5");String pva5=rs2.getString("pv5");
    String pa6=rs2.getString("p6");String pva6=rs2.getString("pv6");
    String pa7=rs2.getString("p7");String pva7=rs2.getString("pv7");
    String pa8=rs2.getString("p8");String pva8=rs2.getString("pv8");
    String pa9=rs2.getString("p9");String pva9=rs2.getString("pv9");
    String pa10=rs2.getString("p10");String pva10=rs2.getString("pv10");

if(!pa1.equals("null")){%><tr><td><%=rs2.getString("p1") %></td><td><%=rs2.getString("pv1") %></td><td><input type="text" id="na" name="p1" placeholder="value"></td></tr>
<%}if(!pa2.equals("null")){%><tr><td><%=rs2.getString("p2") %></td><td><%=rs2.getString("pv2") %></td><td><input type="text" id="na" name="p2" placeholder="value"></td></tr>
<%}if(!pa3.equals("null")){%><tr><td><%=rs2.getString("p3") %></td><td><%=rs2.getString("pv3") %></td><td><input type="text" id="na" name="p3" placeholder="value"></td></tr>
<%}if(!pa4.equals("null")){%><tr><td><%=rs2.getString("p4") %></td><td><%=rs2.getString("pv4") %></td><td><input type="text" id="na" name="p4" placeholder="value"></td></tr>
<%}if(!pa5.equals("null")){%><tr><td><%=rs2.getString("p5") %></td><td><%=rs2.getString("pv5") %></td><td><input type="text" id="na" name="p5" placeholder="value"></td></tr>
<%}if(!pa6.equals("null")){%><tr><td><%=rs2.getString("p6") %></td><td><%=rs2.getString("pv6") %></td><td><input type="text" id="na" name="p6" placeholder="value"></td></tr>
<%}if(!pa7.equals("null")){%><tr><td><%=rs2.getString("p7") %></td><td><%=rs2.getString("pv7") %></td><td><input type="text" id="na" name="p7" placeholder="value"></td></tr>
<%}if(!pa8.equals("null")){%><tr><td><%=rs2.getString("p8") %></td><td><%=rs2.getString("pv8") %></td><td><input type="text" id="na" name="p8" placeholder="value"></td></tr>
<%}if(!pa9.equals("null")){%><tr><td><%=rs2.getString("p9") %></td><td><%=rs2.getString("pv9") %></td><td><input type="text" id="na" name="p9" placeholder="value"></td></tr>
<%}if(!pa10.equals("null")){%><tr><td><%=rs2.getString("p10") %></td><td><%=rs2.getString("pv10") %></td><td><input type="text" id="na" name="p10" placeholder="value"></td></tr>
<% 
}
rs2.close();
}


}
catch(Exception e)
{
	//out.println(e);
}
%>
</table>
</select><br><br>

<center>
<input type="submit" name="submit" value="result" formAction="MobiClient" formmethod="post"></center>
</body>
</html>