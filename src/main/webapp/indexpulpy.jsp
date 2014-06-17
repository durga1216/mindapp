<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mind Pulpy</title>
<link rel="shortcut icon" href="favicon.ico" />

</head>
<style>
body{
background-color:#FF9900;}
.head{
    color:#FFFFFF;
    font-family:verdana;
    font-size:40px;}
#indiv{color:#FFFFFF;
}
#na{
margin-top:0;
color:#FFFFFF;
font-size:20px;
font-family:verdana;
text-align:right;}
</style>
 <script type="text/javascript">
function load1(){
	window.open("MindPulpy_FAQ.pdf", '_blank');
}
</script>
<body>
<form>
<div id=na><a id="indiv" href= 'javascript:load1()'>FAQ</a>&nbsp;&nbsp;&nbsp;<a id='indiv' href='<%=request.getContextPath()%>/ApiDoc'> API Documentation </a>&nbsp;|&nbsp;<a id="indiv" href='API_promotion.jsp'>API Promotion</a>&nbsp;&nbsp;&nbsp;<a id="indiv" href= 'APIthon.jsp'>APIthon</a>&nbsp;&nbsp;&nbsp;<a id="indiv" href= 'index.jsp'>Sign up/ Sign in</a>&nbsp;&nbsp;&nbsp;<a id="indiv" href= 'apidisp.jsp'>Other API's</a>&nbsp;&nbsp;&nbsp;<a id="indiv" href= 'addapi.jsp'>Add API's</a>&nbsp;&nbsp;&nbsp;<a id="indiv" href='<%=request.getContextPath()%>/Viewapi?category=Search'>View API's</a></div>
<br><div class="head"><center>Mind Pulpy</center></h2></div><br>
<center><img src="images/front.png" style="width:100; height:250;"></center>


</form>


</body>
</html>