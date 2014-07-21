<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MindPulpy</title>
<style>
body{
background-color:#FF9900;
}
h1{
font-family:verdana;
color:#FFFFFF;
}
h2{
font-family:verdana;
color:#FFFFFF;
}
a{
    font-size:18px;
    font-family:verdana;
    color:#FFFFFF;
    
    }
#indiv{color:#FFFFFF;
}
#na{
margin-top:0;
width:1300px;
color:#FFFFFF;
font-size:20px;
font-family:verdana;
text-align:right;}
img{
height:50px;
width:60px;
}
</style>
 <script type="text/javascript">
function add()
{
	window.location="login.jsp";
	}
function load(){
	window.open("terms.jsp", '_blank');
	
}
function load1(){
	window.open("MindPulpy_FAQ.pdf", '_blank');
}
function load2(){
	window.open("https://mindtools-inputs.rhcloud.com/index.jsp", '_blank');
}

</script>
</head>
<body>
    <%request.getSession().setAttribute("user", null);%>
    <div id=na><a href="http://minddotss.com/"><img style="height:60px;width:200px;" src="images/log.png"></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a id="indiv" href='comments.jsp'>Discussion Forum</a>&nbsp;&nbsp;&nbsp;<a id="indiv" href= 'javascript:load1()'>FAQ</a>&nbsp;&nbsp;&nbsp;<a id="indiv" href='API_promotion.jsp'>API Promotion</a>&nbsp;&nbsp;&nbsp;<a id="indiv" href= 'APIthon.jsp'>APIthon</a>&nbsp;&nbsp;&nbsp;<a id="indiv" href='ApiDoc.jsp'>API Documentation</a>&nbsp;&nbsp;&nbsp;<a id="indiv" href= 'javascript:load2()'>Apps Builder</a>&nbsp;&nbsp;&nbsp;<a id="indiv" href= 'addapi.jsp'>Add API's</a>&nbsp;&nbsp;&nbsp;<a id="indiv" href='<%=request.getContextPath()%>Viewapi?category=Search'>Search API's</a></div>
<br><hr>
<center><h1>Mind Pulpy</h1><center><br><br>

<center><h2>Successfully Signout!!</h2><center><br><br>
<h3><a href="login.jsp">click here to login</a></h3>
</body>
</html>