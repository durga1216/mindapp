<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
try{
	HttpSession session1=request.getSession(true);
    String appid=(String)session1.getAttribute("apid");
    String id=(String)session.getAttribute("id");
String name=request.getParameter("name");
PreparedStatement st2=cn.prepareStatement("SELECT * FROM  secondconfig  WHERE appid=?");
st2.setString(1,appid);
ResultSet rs2 = st2.executeQuery();
while(rs2.next()){
	   String a1=rs2.getString("alabel1"); String a2=rs2.getString("akey1");
	   String endurl=rs2.getString("securl");
	   String cycle=rs2.getString("cycle");
      String sa1=rs2.getString("s1"); String sva1=rs2.getString("sv1");
      String sa2=rs2.getString("s2"); String sva2=rs2.getString("sv2");
      String sa3=rs2.getString("s3"); String sva3=rs2.getString("sv3");
      String sa4=rs2.getString("s4"); String sva4=rs2.getString("sv4");
      String sa5=rs2.getString("s5"); String sva5=rs2.getString("sv5");
      String sa6=rs2.getString("s6"); String sva6=rs2.getString("sv6");
      String sa7=rs2.getString("s7"); String sva7=rs2.getString("sv7");
      String sa8=rs2.getString("s8"); String sva8=rs2.getString("sv8");
      String sa9=rs2.getString("s9"); String sva9=rs2.getString("sv9");
      String sa10=rs2.getString("s10"); String sva10=rs2.getString("sv10");
     // String  rmethod=rs2.getString("rm");
      String  rf=rs2.getString("resf2");
      session1.setAttribute("a1",a1);session1.setAttribute("cycle",cycle);
      session1.setAttribute("sa1",sa1); session1.setAttribute("sa2",sa2);session1.setAttribute("sa3",sa3);
      session1.setAttribute("sa4",sa4);session1.setAttribute("sa5",sa5);session1.setAttribute("sa6",sa6);
      session1.setAttribute("sa7",sa7);session1.setAttribute("sa8",sa8);session1.setAttribute("sa9",sa9);
      session1.setAttribute("sa10",sa10);
%>
<table color='#FFFFFF' height=100%>
<%if(!a2.equals("")){%><tr><td>API Key</label></td><td><input type='text' name='a2' value='<%=a2%>' placeholder='Enter your API_KEY here' style='width:350px;'required></td></tr><%} %>
<tr><td>Request Method</td><td><input  type="text" name="fff" id="rf" value="Get" placeholder="Request Method"></td></tr>
<tr><td>Response Format</td><td><input type="text" name="rf" id="rm" value="<%=rf%>" placeholder="Response Format"></td></tr>
<tr><td>End Point URL</td><td><input  type="text" name="securl" id="endurl" value="<%=endurl %>" placeholder="End_Point_URL" style="width:600px;"></td></tr><br>
</table>
<div class="Param"><center>Parameters</center></div><br>
<table color='#FFFFFF' height=100%>
<tr><th>Parameter_name</th><th>Example_Value</th><th>Scope</th></tr>
    <%if(!sa1.equals("null")){%><tr><td><%=rs2.getString("s1") %></td><td><%=rs2.getString("sv1") %></td><td><input  type="text"  name="p1" placeholder="value"></td></tr>
	<%}if(!sa2.equals("null")){%><tr><td><%=rs2.getString("s2") %></td><td><%=rs2.getString("sv2") %></td><td><input type="text"  name="p2" placeholder="value"></td></tr>
	<%}if(!sa3.equals("null")){%><tr><td><%=rs2.getString("s3") %></td><td><%=rs2.getString("sv3") %></td><td><input type="text"  name="p3" placeholder="value"></td></tr>
	<%}if(!sa4.equals("null")){%><tr><td><%=rs2.getString("s4") %></td><td><%=rs2.getString("sv4") %></td><td><input type="text"  name="p4" placeholder="value"></td></tr>
	<%}if(!sa5.equals("null")){%><tr><td><%=rs2.getString("s5") %></td><td><%=rs2.getString("sv5") %></td><td><input type="text"  name="p5" placeholder="value"></td></tr>
	<%}if(!sa6.equals("null")){%><tr><td><%=rs2.getString("s6") %></td><td><%=rs2.getString("sv6") %></td><td><input type="text"  name="p6" placeholder="value"></td></tr>
	<%}if(!sa7.equals("null")){%><tr><td><%=rs2.getString("s7") %></td><td><%=rs2.getString("sv7") %></td><td><input type="text"  name="p7" placeholder="value"></td></tr>
	<%}if(!sa8.equals("null")){%><tr><td><%=rs2.getString("s8") %></td><td><%=rs2.getString("sv8") %></td><td><input type="text" name="p8" placeholder="value"></td></tr>
	<%}if(!sa9.equals("null")){%><tr><td><%=rs2.getString("s9") %></td><td><%=rs2.getString("sv9") %></td><td><input type="text" name="p9" placeholder="value"></td></tr>
	<%}if(!sa10.equals("null")){%><tr><td><%=rs2.getString("s10") %></td><td><%=rs2.getString("sv10") %></td><td><input type="text"  name="p10" placeholder="value"></td></tr>
	<% }
%>
</table><br><br>
<center><input type="submit" name="submit" value="Continue" formAction="PreSecPulpy" formmethod="post"></center>

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
