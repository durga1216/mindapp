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
    color:#000000;
    font-family:verdana;
    font-size:35px;
    font-weight:bold;
}
body{
background-color:#33FF99;

}
option{
font-size:20px;
}
select{
color:#33FF99;
font-size:20px;
margin-left:80px;
background-color:#000000;
font-family:verdana;
width:440px;
height:60px;
padding:10px;
}

input[type="text"]{
color:#33FF99;
font-size:20px;
background-color:#000000;
margin-left:80px;
font-family:verdana;
width:400px;
height:25px;
padding:20px;
} 
input[type="submit"]{

color:#000000;
font-size:20px;
background-color:#33FF99;
margin-left:280px;
font-family:verdana;
width:140px;
height:50px;
border:solid 2px;
border-color:#000000;
border-radius:50px;
padding:10px;
}
</style>
<script>
function myFunction() {
    var x = document.getElementById('apid').value;
    var ur="mobile_client.jsp?ai="+x+"";
   
	window.location=""+ur+"";

}

</script>
<body><div class="head">

<center>Mobile App</center></div>
<form action="AuthXmlPulpy" method="post">
<%@page import="com.mindots.util.Utils"%>
<%@page import=" java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%
response.setHeader("Content-Type","text/html;charset=UTF-8");%>

<select id='apid' name='appid' onchange="myFunction()"><option value='dummy'>***Choose Your APP_ID Here***</option>
<%
String id1=(String) session.getAttribute("id");
try{
Class.forName("com.mysql.jdbc.Driver");
//Connection cn=DriverManager.getConnection("jdbc:mysql://127.6.250.130:3306/mpulpy","adminPQ1iFfN","J5JhBL-XC9NG");
Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/mpulpy","root","root");
PreparedStatement st1=cn.prepareStatement("SELECT appid FROM authen1 WHERE id=?");
st1.setString(1,"MP_0021");
ResultSet rs1 = st1.executeQuery();
while(rs1.next()){
	String ap=rs1.getString("appid");
    out.println("<option value='"+ap+"'>"+ap+"</option>");

}%>
</select><br><br>
<select id='apid' name='appid' ><option value='dummy'>***Choose Your END_URL Here***</option>
<% 
String rd=request.getParameter("ai");
PreparedStatement st2=cn.prepareStatement("SELECT config.endurl FROM config where config.appid=?");
st2.setString(1,rd);
ResultSet rs2 = st2.executeQuery();
while(rs2.next()){
	String ap1=rs2.getString("endurl");
    out.println("<option value='"+ap1+"'>"+ap1+"</option>");
  
}
PreparedStatement st3=cn.prepareStatement("SELECT secondconfig.securl FROM secondconfig where secondconfig.appid=?");
st3.setString(1,rd);
ResultSet rs3 = st3.executeQuery();
while(rs3.next()){
	String ap2=rs3.getString("securl");
    out.println("<option value='"+ap2+"'>"+ap2+"</option>");
   
}
PreparedStatement st4=cn.prepareStatement("SELECT thirdconfig.thrdurl FROM thirdconfig where thirdconfig.appid=?");
st4.setString(1,rd);
ResultSet rs4 = st4.executeQuery();
while(rs4.next()){
	String ap4=rs4.getString("thrdurl");
    out.println("<option value='"+ap4+"'>"+ap4+"</option>");
   
}
%>
</select>
<% }
catch(Exception e)
{out.println(e);
}
%>
<br><br>
<input type="text" name="p1"  placeholder="Param1"><br><br>
<input type="text" name="p2" value="" placeholder="Param2"><br><br>
<input type="text" name="p3" value="" placeholder="Param3"><br><br>
<input type="text" name="p4" value="" placeholder="Param4"><br><br>
<input type="text" name="p5" value="" placeholder="Param5"><br><br>
<input type="text" name="p6" value="" placeholder="Param6"><br><br>
<input type="text" name="p7" value="" placeholder="Param7"><br><br>
<input type="text" name="p8" value="" placeholder="Param8"><br><br>
<input type="text" name="p9" value="" placeholder="Param9"><br><br>
<input type="text" name="p10" value="" placeholder="Param10"><br><br>

<input type="submit" name="submit" value="submit"></form>
</body>
</html>