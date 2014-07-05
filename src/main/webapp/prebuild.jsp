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
    
    .au{
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
	margin-left:300px;
	font-family:verdana;
	width:140px;
	height:50px;
	border:solid 2px;
	border-color:#FFFFFF;
	border-radius:50px;
	padding:10px;
	}
 .param{
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
margin-left:80px;
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
margin-left:80px;
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
<div id=na><%=session.getAttribute("mail")%> &nbsp;|<a id="indiv" href='ApiDoc.jsp'>API Documentation</a>&nbsp;|&nbsp;&nbsp;<a id='indiv' href = 'mobile_client.jsp'> API Console </a>&nbsp;|&nbsp;<a id='indiv' href='<%=request.getContextPath()%>/ApiPulpy'>API Usage</a>&nbsp;|&nbsp;<a id='indiv' href = 'logout.jsp'> Sign Out </a></div>
<br><br><div class="head"><center>Mind Pulpy</center></div><br><br>
<div class="au"><center>PreBuild API's</center></div><br><br>
<%@page import="com.mindots.util.Utils"%>
<%@page import=" java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%
response.setHeader("Content-Type","text/html;charset=UTF-8");%>
<%
try{
Class.forName("com.mysql.jdbc.Driver");
Connection cn=DriverManager.getConnection("jdbc:mysql://127.6.250.130:3306/mpulpy","adminPQ1iFfN","J5JhBL-XC9NG");
//Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/mpulpy","root","root");
String name=request.getParameter("name");
PreparedStatement st2=cn.prepareStatement("SELECT * FROM authen1 a1 JOIN config a2 ON a1.appid=a2.appid WHERE a1.appid=?");
st2.setString(1,name);
ResultSet rs2 = st2.executeQuery();
String appid="null";String uid="null";
String endurl="";String pa1="null";String pa2="null";String pa3="null";String pa4="null";String pa5="null";String pa6="null";String pa7="null";String pa8="null";String pa9="null";String pa10="null";
String pva1="null";String pva2="null";String pva3="null";String pva4="null";String pva5="null";String pva6="null";String pva7="null";String pva8="null";String pva9="null";String pva10="null";
String f1="null";String f2="null";String f3="null";String f4="null";String f5="";String f6="null";String f7="null";String f8="null";String f9="null";String f10="null";
String authen="";String appname="";String desc=""; String a1="null"; String a2="null";
String cname="null";String ckey="null";String csecname="null";String cseckey="null";String sname="null";String svalue="null";
String aurl="null";String tokenurl="null";String tlabel="null";String treplace="null";String el="null";String ev="null";String orm="null";
String rf="";String rmethod="";// change
HttpSession session1=request.getSession(true);
while(rs2.next()){
	   authen=rs2.getString("auth");
	   appname=rs2.getString("appname");  a1=rs2.getString("a1"); a2=rs2.getString("a2");
	    //change
      endurl=rs2.getString("endurl");
      appid=rs2.getString("appid");
      uid=rs2.getString("id");
      pa1=rs2.getString("p1"); pva1=rs2.getString("pv1");
      pa2=rs2.getString("p2"); pva2=rs2.getString("pv2");
      pa3=rs2.getString("p3"); pva3=rs2.getString("pv3");
      pa4=rs2.getString("p4"); pva4=rs2.getString("pv4");
      pa5=rs2.getString("p5"); pva5=rs2.getString("pv5");
      pa6=rs2.getString("p6"); pva6=rs2.getString("pv6");
      pa7=rs2.getString("p7"); pva7=rs2.getString("pv7");
      pa8=rs2.getString("p8"); pva8=rs2.getString("pv8");
      pa9=rs2.getString("p9"); pva9=rs2.getString("pv9");
      pa10=rs2.getString("p10"); pva10=rs2.getString("pv10");
      f1=rs2.getString("f1"); f2=rs2.getString("f2");
      f3=rs2.getString("f3"); f4=rs2.getString("f4");
      f5=rs2.getString("f5"); f6=rs2.getString("f6");
      f7=rs2.getString("f7"); f8=rs2.getString("f8");
      
      f9=rs2.getString("f9"); f10=rs2.getString("f10");rf=rs2.getString("resf");
 	  rmethod=rs2.getString("rm");cname=rs2.getString("cname");
 	 ckey=rs2.getString("ckey");
	 csecname=rs2.getString("csecname");
	 cseckey=rs2.getString("cseckey");
	 sname=rs2.getString("sname");
	 svalue=rs2.getString("svalue");
	 aurl=rs2.getString("aurl");
	 tokenurl=rs2.getString("tokenurl");
	 tlabel=rs2.getString("tlabel");
	 treplace=rs2.getString("treplace");
	 el=rs2.getString("el");
	 ev=rs2.getString("ev");orm=rs2.getString("rmethod");
 	  
	} 
	 
      session1.setAttribute("authen",authen);session1.setAttribute("appname",appname);
      session1.setAttribute("pa1",pa1); session1.setAttribute("pa2",pa2);session1.setAttribute("pa3",pa3);
      session1.setAttribute("pa4",pa4);session1.setAttribute("pa5",pa5);session1.setAttribute("pa6",pa6);
      session1.setAttribute("pa7",pa7);session1.setAttribute("pa8",pa8);session1.setAttribute("pa9",pa9);
      session1.setAttribute("pa10",pa10);session1.setAttribute("appid",appid);session1.setAttribute("id",uid);
      session1.setAttribute("f1",f1);      session1.setAttribute("f2",f2);      session1.setAttribute("f3",f3);
      session1.setAttribute("f4",f4);      session1.setAttribute("f5",f5);      session1.setAttribute("f6",f6);
      session1.setAttribute("f7",f7);      session1.setAttribute("f8",f8);      session1.setAttribute("f9",f9);
      session1.setAttribute("f10",f10); session1.setAttribute("orm",orm); session1.setAttribute("appid",appid);




%>
<div id="name">You Choose <%=appname%> Pre-Build APP and the Authentication for <b><%=appname %></b> is <b><%=authen %></b></div><br><br>
<%if(authen.equals("API keys")){
out.println("<div id='api'><a href='http://en.wikipedia.org/wiki/Application_programming_interface_key'>To Know More About API keys Click Here</a></div><br>");
out.println("<input type='text' name='a1' value='"+a1+"'>");
out.println("<input type='text' name='a2' value='' placeholder='Enter your API_KEY here' style='width:350px;'required><br><br>");
} 
else if(authen.equals("Oauth2")){
out.println("<div id='api'><a href='http://oauth.net'>To know more about Oauth Click here</a></div><br>");
out.println("<input type='text' name='ckey' style='width:300px' value='' placeholder='Enter Your API Key here' required>&nbsp;&nbsp;&nbsp;<input type='text' name='cseckey' value='' placeholder='Enter Your API Secret Key here' style='width:300px'required><br><br>");	
out.println("<input type='text' name='aurl' value='"+aurl+"' style='width:300px' required>&nbsp;&nbsp;&nbsp;<input type='text' name='tokenurl' value='"+tokenurl+"' style='width:300px'required ><br><br>");
out.println("<input type='text' name='sname' value='"+sname+"' placeholder='Scope_Label' style='width:300px' required>&nbsp;&nbsp;&nbsp;<input type='text' name='svalue'style='width:300px'  value='' placeholder='Scope_Value' required><br><br>");
out.println("<input type='text' name='tlabel' style='width:300px' value='"+tlabel+"' required><br><br>");
out.println("<div id='re'><center>Access Token Replacement</center></div><br><br>");
out.println("<input type='text' name='treplace' style='width:300px' value='"+treplace+"'required>");
out.println("<div id='re'><center>Access Token Method :"+orm+"</center></div>");
out.println("<div id='re'><center>Extra Fields(Optional)</center></div><br><br>");
out.println("<input type='text' name='el' value='"+el+"' placeholder='State_label'style='width:300px' required>&nbsp;&nbsp;&nbsp;<input type='text' name='ev' value='"+ev+"' placeholder='State_Value' style='width:300px' required><br><br>");
}%><br>
<div class="au"><center>Request Method</center></div><br>
<div class="text"><input type="text" name="rf" id="rf" value="<%=rf%>" placeholder="Request Method"></div><br><br>
<div class="au"><center>Response Format</center></div><br>
<div class="text"><input type="text" name="rm" id="rm" value="<%=rmethod%>" placeholder="Response Format"></div><br><br>
<div class="au"><center>End Point URL</center></div><br>
<div class="text"><input type="text" name="endurl" id="endurl" value="<%=endurl %>" placeholder="End_Point_URL" style="width:600px;"></div><br><br><br>
<div class="param"><center>Parameters</center></div><br><br>
<table color='#FFFFFF' height=100%>
<tr><th>Parameter_name</th><th>Parameter_Value</th><th>Scope</th></tr>
<%if(!"null".equals(pa1)) {
out.println("<tr><td>"+pa1+"</td><td><input type='text' name='pv1' value='' placeholder='Param_Value' style='height:15px;'></td><td>"+f1+"</td></tr>");
}
if(!"null".equals(pa2)){
out.println("<tr><td>"+pa2+"</td><td><input type='text' name='pv2' value='' placeholder='Param_Value' style='height:15px;'></td><td>"+f2+"</td></tr>");
}
 if(!"null".equals(pa3)){
	out.println("<tr><td>"+pa3+"</td><td><input type='text' name='pv3' value='' placeholder='Param_Value' style='height:15px;'></td><td>"+f3+"</td></tr>");
}
 if(!"null".equals(pa4)){
	out.println("<tr><td>"+pa4+"</td><td><input type='text' name='pv4' value='' placeholder='Param_Value' style='height:15px;'></td><td>"+f4+"</td></tr>");
}
 if(!"null".equals(pa5)){
	out.println("<tr><td>"+pa5+"</td><td><input type='text' name='pv5' value='' placeholder='Param_Value' style='height:15px;'></td><td>"+f5+"</td></tr>");
}
 if(!"null".equals(pa6)){
	out.println("<tr><td>"+pa6+"</td><td><input type='text' name='pv6' value='' placeholder='Param_Value' style='height:15px;'></td><td>"+f6+"</td></tr>");
}
 if(!"null".equals(pa7)){
	out.println("<tr><td>"+pa7+"</td><td><input type='text' name='pv7' value='' placeholder='Param_Value' style='height:15px;'></td><td>"+f7+"</td></tr>");
}
 if(!"null".equals(pa8)){
	out.println("<tr><td>"+pa8+"</td><td><input type='text' name='pv8' value='' placeholder='Param_Value' style='height:15px;'></td><td>"+f8+"</td></tr>");
}if(!"null".equals(pa9)){
	out.println("<tr><td>"+pa9+"</td><td><input type='text' name='pv9' value='' placeholder='Param_Value' style='height:15px;'></td><td>"+f9+"</td></tr>");
} if(!"null".equals(pa10)){
	out.println("<tr><td>"+pa10+"</td><td><input type='text' name='pv10' value='' placeholder='Param_Value' style='height:15px;'></td><td>"+f10+"</td></tr>");

} 
%>
</table><br><br>
<input type="submit" name="submit" value="Simplify O/P" formAction="PreAuthPulpy" formmethod="post">
</form>
<% 
}
catch(Exception e){
	out.println(e);
}
%>

</body>
</html>