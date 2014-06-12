<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MindPulpy</title>
<link rel="shortcut icon" href="favicon.ico" />
	<script src="js/jquery-latest.js"></script>
	 <%response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Cache-Control", "no-store");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);%>
    
 <style>
 body{
background-color:#FF9900;}
.head{
    color:#FFFFFF;
    font-family:verdana;
    font-size:40px;}
 input[type="text"]{
color:#FF9900;
font-size:20px;
background-color:#FFFFFF;
margin-left:500px;
font-family:verdana;
width:400px;
height:25px;
padding:10px;
} 
.au{
font-family:verdana;
font-weight:bold;
font-size: 20px;
color:#FF9900;
margin-left:500px;
width:25%;
height:30%;
background-color:#FFFFFF;
border-radius:50px;
padding:15px;
}
input[type="submit"]{

color:#FFFFFF;
font-size:15px;
background-color:#FF9900;
margin-left:610px;
font-family:verdana;
width:140px;
height:40px;
border:solid 2px;
border-color:#FFFFFF;
border-radius:50px;
padding:10px;
}
#na{
margin-top:0;
color:#FFFFFF;
font-size:15px;
font-family:verdana;
text-align:right;}

#doc{
font-size:15px;
font-family:verdana;
color:#FFFFFF;
margin-left:200px;
}
a{
margin-top:0;
color:#FFFFFF;
font-size:15px;
font-family:verdana;
text-align:right;
}
 </style>
<script type="text/javascript">
</script>
<body>
 <%String u = (String) request.getSession().getAttribute("user");
    if (u != null ) {
   // System.out.println("user != null");.
   // out.print("Welcome "+u);
    }else{
   // System.out.println("user == null");
    response.sendRedirect("logout.jsp");
    }%>
<div id=na><%=session.getAttribute("mail")%> &nbsp;|&nbsp;<a id='indiv' href = 'apidoc.jsp'> API Documentation </a>&nbsp;|&nbsp;<a id='indiv' href = 'mobile_client.jsp'> API Test </a>&nbsp;|&nbsp;<a id='indiv' href='<%=request.getContextPath()%>/ApiPulpy'>API Usage</a>&nbsp;|&nbsp;<a id='indiv' href = 'logout.jsp'> Sign Out </a></div>

<br><br><div class="head"><center>Mind Pulpy</center></h2></div><br><br>
<form action="ApiDoc" method="post">
<div class="au"><center>MPulpy Documentation</center></div><br><br>
<input type="text" name="appid" id="appid" value="" placeholder="Enter Appid To check documentation*"><br/><br/> 
<input type="submit" name="submit" value="check">
<div id="doc">Appname&nbsp;&nbsp;&nbsp;&nbsp;<%=session.getAttribute("appname")%>
              Authentication&nbsp;&nbsp;&nbsp;&nbsp;<%=session.getAttribute("appid")%>
              URL for ClientSide&nbsp;&nbsp;&nbsp;&nbsp;https://mindapp-pulpy.rhcloud.com/AuthXmlPulpy
              Request Method&nbsp;&nbsp;&nbsp;&nbsp;POST
              Parameters
              <table><tr><td><%=session.getAttribute("pa1")%></td><td><%=session.getAttribute("pva1")%></td></tr>
              <tr><td><%=session.getAttribute("pa2")%></td><td><%=session.getAttribute("pva2")%></td></tr>
              <tr><td><%=session.getAttribute("pa3")%></td><td><%=session.getAttribute("pva3")%></td></tr>
              <tr><td><%=session.getAttribute("pa4")%></td><td><%=session.getAttribute("pva4")%></td></tr>
              <tr><td><%=session.getAttribute("pa5")%></td><td><%=session.getAttribute("pva5")%></td></tr>
              <tr><td><%=session.getAttribute("pa6")%></td><td><%=session.getAttribute("pva6")%></td></tr></table>
              
</div>
</form>
</body>
</html>