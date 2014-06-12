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
margin-left:100px;
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
margin-left:360px;
width:25%;
height:30%;
background-color:#FFFFFF;
border-radius:50px;
padding:15px;
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
<div class="au"><center>MPulpy Documentation</center></div>
<input type="text" name="appid" id="appid" value="" placeholder="Enter Appid To check documentation*"><br/><br/> 
<input type="submit" name="submit" value="check">
<div id="doc">AppName</div>
</form>
</body>
</html>