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
}
select{
color:#ff9900;
font-size:20px;
margin-left:80px;
background-color:#ffffff;
font-family:verdana;
width:440px;
height:60px;
padding:10px;
}

input[type="text"]{
color:#ff9900;
font-size:20px;
background-color:#ffffff;
margin-left:80px;
font-family:verdana;
width:400px;
height:25px;
padding:20px;
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
  padding:13px;
  
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
margin-left:280px;
font-family:verdana;
width:140px;
height:50px;
border:solid 2px;
border-color:#ffffff;
border-radius:50px;
padding:10px;
}
</style>
<script>
function myFunction() {
    var x = document.getElementById('apid').value;
    var y = document.getElementById('eurl').value;
    var ur="mobile_client.jsp?ai="+x+"&au="+y+"";
	window.location=""+ur+"";


}

</script>
<body><div class="head">

<center>Mobile App</center></div>
<form >
<%@page import="com.mindots.util.Utils"%>
<%@page import=" java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%
response.setHeader("Content-Type","text/html;charset=UTF-8");%>

<select id='apid' name='appid' ><option value='dummy'>--Choose Your APP_ID Here--</option>
<%
String id1=(String) session.getAttribute("id");
try{
Class.forName("com.mysql.jdbc.Driver");
Connection cn=DriverManager.getConnection("jdbc:mysql://127.6.250.130:3306/mpulpy","adminPQ1iFfN","J5JhBL-XC9NG");
//Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/mpulpy","root","root");
PreparedStatement st1=cn.prepareStatement("SELECT appid FROM authen1 WHERE id=?");
st1.setString(1,id1);
ResultSet rs1 = st1.executeQuery();
while(rs1.next()){
	String ap=rs1.getString("appid");
    out.println("<option value='"+ap+"'>"+ap+"</option>");

}
out.println("</select><br><br>");
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
PreparedStatement st5=cn.prepareStatement("SELECT * FROM secondconfig t2 JOIN thirdconfig t3 ON t2.appid=t3.appid  WHERE t2.appid=?");
st5.setString(1,xx);
ResultSet rs5 = st5.executeQuery();
boolean empty = true;
%>
<select id='eurl' name='eurl' onchange='myFunction()'><option value='dummy'>--Choose Your config Here--</option>
<option value='1'>First configuration</option>
<option value='2'>Second configuration</option>
<option value='3'>Third configuration</option>
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
		String pa1=rs4.getString("t1");String pva1=rs4.getString("s1");
	    String pa2=rs4.getString("t2");String pva2=rs4.getString("s2");
	    String pa3=rs4.getString("t3");String pva3=rs4.getString("s3");
	    String pa4=rs4.getString("t4");String pva4=rs4.getString("s4");
	    String pa5=rs4.getString("t5");String pva5=rs4.getString("s5");
	    String pa6=rs4.getString("t6");String pva6=rs4.getString("s6");
	    String pa7=rs4.getString("t7");String pva7=rs4.getString("s7");
	    String pa8=rs4.getString("t8");String pva8=rs4.getString("s8");
	    String pa9=rs4.getString("t9");String pva9=rs4.getString("s9");
	    String pa10=rs4.getString("t10");String pva10=rs4.getString("s10");
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