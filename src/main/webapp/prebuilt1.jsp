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
<%
String apid=request.getParameter("name");
String id=(String)session.getAttribute("id");
try{
String name=request.getParameter("name");
PreparedStatement st2=cn.prepareStatement("SELECT * FROM authen1 a1 JOIN config a2 ON a1.appid=a2.appid WHERE a1.appid=?");
st2.setString(1,apid);
ResultSet rs2 = st2.executeQuery();
PreparedStatement st3=cn.prepareStatement("insert into preid(appid) values(?)");
st3.setString(1,id);
st3.executeUpdate();
HttpSession session1=request.getSession(true);
session1.setAttribute("apid", apid);
while(rs2.next()){
	   String a1=rs2.getString("a1"); String a2=rs2.getString("a2");
	   String endurl=rs2.getString("endurl");
      String pa1=rs2.getString("p1"); String sva1=rs2.getString("pv1");
      String pa2=rs2.getString("p2"); String sva2=rs2.getString("pv2");
      String pa3=rs2.getString("p3"); String sva3=rs2.getString("pv3");
      String pa4=rs2.getString("p4"); String sva4=rs2.getString("pv4");
      String pa5=rs2.getString("p5"); String sva5=rs2.getString("pv5");
      String pa6=rs2.getString("p6"); String sva6=rs2.getString("pv6");
      String pa7=rs2.getString("p7"); String sva7=rs2.getString("pv7");
      String pa8=rs2.getString("p8"); String sva8=rs2.getString("pv8");
      String pa9=rs2.getString("p9"); String sva9=rs2.getString("pv9");
      String pa10=rs2.getString("p10"); String sva10=rs2.getString("pv10");
     // String  rmethod=rs2.getString("rm");
      String  rf=rs2.getString("resf");
      session1.setAttribute("a1",a1);
      session1.setAttribute("fa1",pa1); session1.setAttribute("fa2",pa2);session1.setAttribute("fa3",pa3);
      session1.setAttribute("fa4",pa4);session1.setAttribute("fa5",pa5);session1.setAttribute("fa6",pa6);
      session1.setAttribute("fa7",pa7);session1.setAttribute("fa8",pa8);session1.setAttribute("fa9",pa9);
      session1.setAttribute("fa10",pa10);
%>
<table color='#FFFFFF' height=100%>
<%if(!a2.equals("")){%><tr><td>API Key</label></td><td><input type='text' name='a2' value='<%=a2%>' placeholder='Enter your API_KEY here' style='width:350px;'required></td></tr><%} %>
<tr><td>Request Method</td><td><input  type="text" name="dff" id="rf" value="GET" placeholder="Request Method"></td></tr>
<tr><td>Response Format</td><td><input type="text" name="rf" id="rm" value="<%=rf%>" placeholder="Response Format"></td></tr>
<tr><td>End Point URL</td><td><input  type="text" name="endurl" id="endurl" value="<%=endurl %>" placeholder="End_Point_URL" style="width:600px;"></td></tr><br>
</table>
<div class="Param"><center>Parameters</center></div><br>
<table color='#FFFFFF' height=100%>
<tr><th>Parameter_name</th><th>Example_Value</th><th>Scope</th></tr>
    <%if(!pa1.equals("null")){%><tr><td><%=rs2.getString("p1") %></td><td><%=rs2.getString("pv1") %></td><td><input  type="text" name="p1" placeholder="value"></td></tr>
	<%}if(!pa2.equals("null")){%><tr><td><%=rs2.getString("p2") %></td><td><%=rs2.getString("pv2") %></td><td><input type="text"  name="p2" placeholder="value"></td></tr>
	<%}if(!pa3.equals("null")){%><tr><td><%=rs2.getString("p3") %></td><td><%=rs2.getString("pv3") %></td><td><input type="text"  name="p3" placeholder="value"></td></tr>
	<%}if(!pa4.equals("null")){%><tr><td><%=rs2.getString("p4") %></td><td><%=rs2.getString("pv4") %></td><td><input type="text"  name="p4" placeholder="value"></td></tr>
	<%}if(!pa5.equals("null")){%><tr><td><%=rs2.getString("p5") %></td><td><%=rs2.getString("pv5") %></td><td><input type="text"  name="p5" placeholder="value"></td></tr>
	<%}if(!pa6.equals("null")){%><tr><td><%=rs2.getString("p6") %></td><td><%=rs2.getString("pv6") %></td><td><input type="text"  name="p6" placeholder="value"></td></tr>
	<%}if(!pa7.equals("null")){%><tr><td><%=rs2.getString("p7") %></td><td><%=rs2.getString("pv7") %></td><td><input type="text"  name="p7" placeholder="value"></td></tr>
	<%}if(!pa8.equals("null")){%><tr><td><%=rs2.getString("p8") %></td><td><%=rs2.getString("pv8") %></td><td><input type="text"  name="p8" placeholder="value"></td></tr>
	<%}if(!pa9.equals("null")){%><tr><td><%=rs2.getString("p9") %></td><td><%=rs2.getString("pv9") %></td><td><input type="text" name="p9" placeholder="value"></td></tr>
	<%}if(!pa10.equals("null")){%><tr><td><%=rs2.getString("p10") %></td><td><%=rs2.getString("pv10") %></td><td><input type="text"  name="p10" placeholder="value"></td></tr>
	<% }
%>
</table><br><br>
<center><input type="submit" name="submit" value="Continue" formAction="PreFstPulpy" formmethod="post"></center>

</form>
<% 
}
}
catch(Exception e){
	out.println(e);
}
%>

</body>
</html>
