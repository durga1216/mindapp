<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Cache-Control", "no-store");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MindPulpy</title>
<link rel="shortcut icon" href="favicon.ico" />
<script type="text/javascript">
function load(){
	window.open("<%=request.getContextPath()%>/PreXmlPulpy", "tese", "toolbar=no, menubar=no,location=no, directories=no, status=no, scrollbars=yes, resizable=yes, top=500, left=500, width=400, height=400");
	
}
</script>
<style>
body{background-color:#FF9900;}
.head{
color:#FFFFFF;
    font-family:verdana;
    font-size:40px;
    margin-top:20px;
}
.main{
font-family:verdana;
 font-size:30px;
 color:#FFFFFF;
    
}
     
#pa{
font-size:15px;
margin-left:500px;
color:#FFFFFF;
font-family:verdana;
}

#result{
color:#FFFFFF;
    font-family:verdana;
    font-size:30px;
}
</style>
</head>
<body>
<%
HttpSession session1=request.getSession(true);
%>
<center><div class="head">Mind Pulpy</div></center><br><br>
<div class="main"><center>Configuration completed! With PRE-BUILD APP</center></div><br><br>
<div id="result"><center>Your Appid is : <%=session1.getAttribute("appid1")%></center><br><br>
<a id='pa' href='javascript:load()' >Check your Simplified Output here</a><br><br>
</body>
</html>