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
width:300px;
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
#na1{
margin-top:0;
color:#FFFFFF;
font-size:18px;
font-family:verdana;
text-align:right;}
input[type="submit"]{

color:#ffffff;
font-size:20px;
background-color:#ff9900;
margin-left:280px;
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
a{ 
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
box-shadow:2px 2px 5px 1px #000;
border-radius:5px;}
.arrow_box:after, .arrow_box:before {
	top: 100%;
	left: 50%;
	border: solid transparent;
	content: " ";
	height: 0;
	width: 0;
	pointer-events: none;
}

.arrow_box:after {
	border-color: rgba(136, 183, 213, 0);
	border-top-color: #88b7d5;
	border-width: 10px;
	margin-left: -10px;
}
.arrow_box:before {
	border-color: rgba(194, 225, 245, 0);
	border-top-color: #c2e1f5;
	border-width: 16px;
	margin-left: -16px;
}
</style>
<script type="text/javascript">
function load2(){
	window.open("https://mindtools-inputs.rhcloud.com/index.jsp", '_blank');
}
</script>
<script>
function myFunction() {
    var x = document.getElementById('apid').value;
    var y = document.getElementById('eurl').value;
    var ur="mobile_client.jsp?ai="+x+"&au="+y+"";
	window.location=""+ur+"";


}
</script>
<body><br>
<div id=na1><%=session.getAttribute("mail")%> &nbsp;<a href='logsucess.jsp'>Home</a>&nbsp;&nbsp;<a id="indiv" href='ApiDoc.jsp'>API Documentation</a>&nbsp;&nbsp;<a id="indiv" href='javascript:load2()'>Apps Builder</a><sup>Try it.!</sup>&nbsp;&nbsp;&nbsp;<a id="indiv" href= 'logout.jsp'> Sign Out </a></div>
<br><hr><br><div class="head">
<center>Developer Console</center></div>
<form >
<%@page import="com.mindots.util.Utils"%>
<%@page import=" java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@include file="con.jsp" %>
<%
response.setHeader("Content-Type","text/html;charset=UTF-8");%>

<select id='apid' name='appid' ><option value='dummy'>--Choose Your APP_ID Here--</option>
<%
String id1=(String) session.getAttribute("id");
try{
Class.forName("com.mysql.jdbc.Driver");
PreparedStatement st1=cn.prepareStatement("SELECT * FROM authen1 WHERE id=?");
st1.setString(1,id1);
ResultSet rs1 = st1.executeQuery();
while(rs1.next()){
	String ap=rs1.getString("appid");
	String nme=rs1.getString("appname");
    out.println("<option value='"+ap+"'>"+ap+"   ("+nme+")</option>");

}

out.println("</select><br>");
String xx=request.getParameter("ai");
session.setAttribute("xx",xx);
PreparedStatement st2=cn.prepareStatement("SELECT * FROM config WHERE appid=?");
st2.setString(1,xx);
ResultSet rs2 = st2.executeQuery();
PreparedStatement st3=cn.prepareStatement("SELECT * FROM secondconfig WHERE appid=?");
st3.setString(1,xx);
ResultSet rs3 = st3.executeQuery();
PreparedStatement st4=cn.prepareStatement("SELECT * FROM thirdconfig WHERE appid=?");
st4.setString(1,xx);
ResultSet rs4 = st4.executeQuery();
PreparedStatement st6=cn.prepareStatement("SELECT * FROM fourthconfig WHERE appid=?");
st6.setString(1,xx);
ResultSet rs6 = st6.executeQuery();
PreparedStatement st5=cn.prepareStatement("SELECT * FROM secondconfig t2 JOIN thirdconfig t3 ON t2.appid=t3.appid  WHERE t2.appid=?");
st5.setString(1,xx);
ResultSet rs5 = st5.executeQuery();
boolean empty = true;
%>
<div id="oth"><a href="check.jsp">For Oauth Check Here</a></div><br>
<select id='eurl' name='eurl' onchange='myFunction()'><option value='dummy'>--Choose Your config Here--</option>
<option value='1'>First configuration</option>
<option value='2'>Second configuration</option>
<option value='3'>Third configuration</option>
<option value='4'>Fourth configuration</option>
<option value='mas'>Mashup Second and Third_config</option></select><br><br><br><br>
<table align='center'  border='0' bordercolor='#ffffff' style='width:700px;'>
<tr><th>Parameter</th><th>Example_Value</th><th>Param_Value</th></tr>
<%
String el=request.getParameter("au");
session.setAttribute("el",el);
if(el.equals("1")){
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
if( empty ) {
out.println("<p>First_Configuration Not Exist</p>");
	}
}
else if(el.equals("2"))
{	    

	while(rs3.next()){
		String pa1=rs3.getString("s1");String pva1=rs3.getString("sv1");
	    String pa2=rs3.getString("s2");String pva2=rs3.getString("sv2");
	    String pa3=rs3.getString("s3");String pva3=rs3.getString("sv3");
	    String pa4=rs3.getString("s4");String pva4=rs3.getString("sv4");
	    String pa5=rs3.getString("s5");String pva5=rs3.getString("sv5");
	    String pa6=rs3.getString("s6");String pva6=rs3.getString("sv6");
	    String pa7=rs3.getString("s7");String pva7=rs3.getString("sv7");
	    String pa8=rs3.getString("s8");String pva8=rs3.getString("sv8");
	    String pa9=rs3.getString("s9");String pva9=rs3.getString("sv9");
	    String pa10=rs3.getString("s10");String pva10=rs3.getString("sv10");
	    empty=true;
	if(!pa1.equals("null")){%><tr><td><%=rs3.getString("s1") %></td><td><%=rs3.getString("sv1") %></td><td><input type="text" id="na" name="p1" placeholder="value"></td></tr>
	<%}if(!pa2.equals("null")){%><tr><td><%=rs3.getString("s2") %></td><td><%=rs3.getString("sv2") %></td><td><input type="text" id="na" name="p2" placeholder="value"></td></tr>
	<%}if(!pa3.equals("null")){%><tr><td><%=rs3.getString("s3") %></td><td><%=rs3.getString("sv3") %></td><td><input type="text" id="na" name="p3" placeholder="value"></td></tr>
	<%}if(!pa4.equals("null")){%><tr><td><%=rs3.getString("s4") %></td><td><%=rs3.getString("sv4") %></td><td><input type="text" id="na" name="p4" placeholder="value"></td></tr>
	<%}if(!pa5.equals("null")){%><tr><td><%=rs3.getString("s5") %></td><td><%=rs3.getString("sv5") %></td><td><input type="text" id="na" name="p5" placeholder="value"></td></tr>
	<%}if(!pa6.equals("null")){%><tr><td><%=rs3.getString("s6") %></td><td><%=rs3.getString("sv6") %></td><td><input type="text" id="na" name="p6" placeholder="value"></td></tr>
	<%}if(!pa7.equals("null")){%><tr><td><%=rs3.getString("s7") %></td><td><%=rs3.getString("sv7") %></td><td><input type="text" id="na" name="p7" placeholder="value"></td></tr>
	<%}if(!pa8.equals("null")){%><tr><td><%=rs3.getString("s8") %></td><td><%=rs3.getString("sv8") %></td><td><input type="text" id="na" name="p8" placeholder="value"></td></tr>
	<%}if(!pa9.equals("null")){%><tr><td><%=rs3.getString("s9") %></td><td><%=rs3.getString("sv9") %></td><td><input type="text" id="na" name="p9" placeholder="value"></td></tr>
	<%}if(!pa10.equals("null")){%><tr><td><%=rs3.getString("s10") %></td><td><%=rs3.getString("sv10") %></td><td><input type="text" id="na" name="p10" placeholder="value"></td></tr>
	<% 
	}
	rs3.close();
	}
	if( empty ) {
out.println("<p>Second_Configuration Not Exist</p>");
	}
}
else if(el.equals("3"))
{	    

	while(rs4.next()){
		String pa1=rs4.getString("t1");String pa2=rs4.getString("t2");
	    String pa3=rs4.getString("t3");String pa4=rs4.getString("t4");
	    String pa5=rs4.getString("t5");String pa6=rs4.getString("t6");
	    String pa7=rs4.getString("t7");String pa8=rs4.getString("t8");
	    String pa9=rs4.getString("t9");String pa10=rs4.getString("t10");
	    empty=true;
	if(!pa1.equals("null")){%><tr><td><%=rs4.getString("t1") %></td><td><%=rs4.getString("tv1") %></td><td><input type="text" id="na" name="p1" placeholder="value"></td></tr>
	<%}if(!pa2.equals("null")){%><tr><td><%=rs4.getString("t2") %></td><td><%=rs4.getString("tv2") %></td><td><input type="text" id="na" name="p2" placeholder="value"></td></tr>
	<%}if(!pa3.equals("null")){%><tr><td><%=rs4.getString("t3") %></td><td><%=rs4.getString("tv3") %></td><td><input type="text" id="na" name="p3" placeholder="value"></td></tr>
	<%}if(!pa4.equals("null")){%><tr><td><%=rs4.getString("t4") %></td><td><%=rs4.getString("tv4") %></td><td><input type="text" id="na" name="p4" placeholder="value"></td></tr>
	<%}if(!pa5.equals("null")){%><tr><td><%=rs4.getString("t5") %></td><td><%=rs4.getString("tv5") %></td><td><input type="text" id="na" name="p5" placeholder="value"></td></tr>
	<%}if(!pa6.equals("null")){%><tr><td><%=rs4.getString("t6") %></td><td><%=rs4.getString("tv6") %></td><td><input type="text" id="na" name="p6" placeholder="value"></td></tr>
	<%}if(!pa7.equals("null")){%><tr><td><%=rs4.getString("t7") %></td><td><%=rs4.getString("tv7") %></td><td><input type="text" id="na" name="p7" placeholder="value"></td></tr>
	<%}if(!pa8.equals("null")){%><tr><td><%=rs4.getString("t8") %></td><td><%=rs4.getString("tv8") %></td><td><input type="text" id="na" name="p8" placeholder="value"></td></tr>
	<%}if(!pa9.equals("null")){%><tr><td><%=rs4.getString("t9") %></td><td><%=rs4.getString("tv9") %></td><td><input type="text" id="na" name="p9" placeholder="value"></td></tr>
	<%}if(!pa10.equals("null")){%><tr><td><%=rs4.getString("t10") %></td><td><%=rs4.getString("tv10") %></td><td><input type="text" id="na" name="p10" placeholder="value"></td></tr>
	
	<% 
	}
	rs4.close();
	}
	if( empty ) {
out.println("<p>Third_Configuration Not Exist</p>");
	}	
}
else if(el.equals("4"))
{	    

	while(rs6.next()){
		String pa1=rs6.getString("f1");String pa2=rs6.getString("f2");
	    String pa3=rs6.getString("f3");String pa4=rs6.getString("f4");
	    String pa5=rs6.getString("f5");String pa6=rs6.getString("f6");
	    String pa7=rs6.getString("f7");String pa8=rs6.getString("f8");
	    String pa9=rs6.getString("f9");String pa10=rs6.getString("f10");
	    empty=true;
	if(!pa1.equals("null")){%><tr><td><%=rs6.getString("f1") %></td><td><%=rs6.getString("fv1") %></td><td><input type="text" id="na" name="p1" placeholder="value"></td></tr>
	<%}if(!pa2.equals("null")){%><tr><td><%=rs6.getString("f2") %></td><td><%=rs6.getString("fv2") %></td><td><input type="text" id="na" name="p2" placeholder="value"></td></tr>
	<%}if(!pa3.equals("null")){%><tr><td><%=rs6.getString("f3") %></td><td><%=rs6.getString("fv3") %></td><td><input type="text" id="na" name="p3" placeholder="value"></td></tr>
	<%}if(!pa4.equals("null")){%><tr><td><%=rs6.getString("f4") %></td><td><%=rs6.getString("fv4") %></td><td><input type="text" id="na" name="p4" placeholder="value"></td></tr>
	<%}if(!pa5.equals("null")){%><tr><td><%=rs6.getString("f5") %></td><td><%=rs6.getString("fv5") %></td><td><input type="text" id="na" name="p5" placeholder="value"></td></tr>
	<%}if(!pa6.equals("null")){%><tr><td><%=rs6.getString("f6") %></td><td><%=rs6.getString("fv6") %></td><td><input type="text" id="na" name="p6" placeholder="value"></td></tr>
	<%}if(!pa7.equals("null")){%><tr><td><%=rs6.getString("f7") %></td><td><%=rs6.getString("fv7") %></td><td><input type="text" id="na" name="p7" placeholder="value"></td></tr>
	<%}if(!pa8.equals("null")){%><tr><td><%=rs6.getString("f8") %></td><td><%=rs6.getString("fv8") %></td><td><input type="text" id="na" name="p8" placeholder="value"></td></tr>
	<%}if(!pa9.equals("null")){%><tr><td><%=rs6.getString("f9") %></td><td><%=rs6.getString("fv9") %></td><td><input type="text" id="na" name="p9" placeholder="value"></td></tr>
	<%}if(!pa10.equals("null")){%><tr><td><%=rs6.getString("f10") %></td><td><%=rs6.getString("fv10") %></td><td><input type="text" id="na" name="p10" placeholder="value"></td></tr>
	
	<% 
	}
	rs6.close();
	}
	if( empty ) {
out.println("<p>Fourth_Configuration Not Exist</p>");
	}	
}
else if(el.equals("mas"))
{	    

	while(rs5.next()){
		String pa1=rs5.getString("t1");String pva1=rs5.getString("s1");
	    String pa2=rs5.getString("t2");String pva2=rs5.getString("s2");
	    String pa3=rs5.getString("t3");String pva3=rs5.getString("s3");
	    String pa4=rs5.getString("t4");String pva4=rs5.getString("s4");
	    String pa5=rs5.getString("t5");String pva5=rs5.getString("s5");
	    String pa6=rs5.getString("t6");String pva6=rs5.getString("s6");
	    String pa7=rs5.getString("t7");String pva7=rs5.getString("s7");
	    String pa8=rs5.getString("t8");String pva8=rs5.getString("s8");
	    String pa9=rs5.getString("t9");String pva9=rs5.getString("s9");
	    String pa10=rs5.getString("t10");String pva10=rs5.getString("s10");
	    empty=true;
	    if(!pva1.equals("null")){%><tr><td><%=rs5.getString("s1") %></td><td><%=rs5.getString("sv1") %></td><td><input type="text" id="na" name="p1" placeholder="value"></td></tr>
		<%}if(!pva2.equals("null")){%><tr><td><%=rs5.getString("s2") %></td><td><%=rs5.getString("sv2") %></td><td><input type="text" id="na" name="p2" placeholder="value"></td></tr>
		<%}if(!pva3.equals("null")){%><tr><td><%=rs5.getString("s3") %></td><td><%=rs5.getString("sv3") %></td><td><input type="text" id="na" name="p3" placeholder="value"></td></tr>
		<%}if(!pva4.equals("null")){%><tr><td><%=rs5.getString("s4") %></td><td><%=rs5.getString("sv4") %></td><td><input type="text" id="na" name="p4" placeholder="value"></td></tr>
		<%}if(!pva5.equals("null")){%><tr><td><%=rs5.getString("s5") %></td><td><%=rs5.getString("sv5") %></td><td><input type="text" id="na" name="p5" placeholder="value"></td></tr>
		<%}if(!pva6.equals("null")){%><tr><td><%=rs5.getString("s6") %></td><td><%=rs5.getString("sv6") %></td><td><input type="text" id="na" name="p6" placeholder="value"></td></tr>
		<%}if(!pva7.equals("null")){%><tr><td><%=rs5.getString("s7") %></td><td><%=rs5.getString("sv7") %></td><td><input type="text" id="na" name="p7" placeholder="value"></td></tr>
		<%}if(!pva8.equals("null")){%><tr><td><%=rs5.getString("s8") %></td><td><%=rs5.getString("sv8") %></td><td><input type="text" id="na" name="p8" placeholder="value"></td></tr>
		<%}if(!pva9.equals("null")){%><tr><td><%=rs5.getString("s9") %></td><td><%=rs5.getString("sv9") %></td><td><input type="text" id="na" name="p9" placeholder="value"></td></tr>
		<%}if(!pva10.equals("null")){%><tr><td><%=rs5.getString("s10") %></td><td><%=rs5.getString("sv10") %></td><td><input type="text" id="na" name="p10" placeholder="value"></td></tr>
	<%}if(!pa1.equals("null")){%><tr><td><%=rs5.getString("t1") %></td><td><%=rs5.getString("tv1") %></td><td><input type="text" id="na" name="pa1" placeholder="value"></td></tr>
	<%}if(!pa2.equals("null")){%><tr><td><%=rs5.getString("t2") %></td><td><%=rs5.getString("tv2") %></td><td><input type="text" id="na" name="pa2" placeholder="value"></td></tr>
	<%}if(!pa3.equals("null")){%><tr><td><%=rs5.getString("t3") %></td><td><%=rs5.getString("tv3") %></td><td><input type="text" id="na" name="pa3" placeholder="value"></td></tr>
	<%}if(!pa4.equals("null")){%><tr><td><%=rs5.getString("t4") %></td><td><%=rs5.getString("tv4") %></td><td><input type="text" id="na" name="pa4" placeholder="value"></td></tr>
	<%}if(!pa5.equals("null")){%><tr><td><%=rs5.getString("t5") %></td><td><%=rs5.getString("tv5") %></td><td><input type="text" id="na" name="pa5" placeholder="value"></td></tr>
	<%}if(!pa6.equals("null")){%><tr><td><%=rs5.getString("t6") %></td><td><%=rs5.getString("tv6") %></td><td><input type="text" id="na" name="pa6" placeholder="value"></td></tr>
	<%}if(!pa7.equals("null")){%><tr><td><%=rs5.getString("t7") %></td><td><%=rs5.getString("tv7") %></td><td><input type="text" id="na" name="pa7" placeholder="value"></td></tr>
	<%}if(!pa8.equals("null")){%><tr><td><%=rs5.getString("t8") %></td><td><%=rs5.getString("tv8") %></td><td><input type="text" id="na" name="pa8" placeholder="value"></td></tr>
	<%}if(!pa9.equals("null")){%><tr><td><%=rs5.getString("t9") %></td><td><%=rs5.getString("tv9") %></td><td><input type="text" id="na" name="pa9" placeholder="value"></td></tr>
	<%}if(!pa10.equals("null")){%><tr><td><%=rs5.getString("t10") %></td><td><%=rs5.getString("tv10") %></td><td><input type="text" id="na" name="pa10" placeholder="value"></td></tr>
	<% 
	}
	rs5.close();
	}
	if( empty ) {
out.println("<p>Mashup Not Exist</p>");
	}	
}
}
catch(Exception e)
{
	//out.println(e);
}
%>
</table>
</select><br><br>


<input type="submit" name="submit" value="Single" formAction="MobiClient" formmethod="post">
<input type="submit" name="submit" value="Mix/Mashup" formAction="MobiClient1" formmethod="post"></form>
</body>
</html>