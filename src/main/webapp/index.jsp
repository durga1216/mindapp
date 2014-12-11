<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>MindPulpy</title>
<link rel="shortcut icon" href="favicon.ico" />
<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-50928435-1', 'mindapp-pulpy.rhcloud.com');
  ga('send', 'pageview');

</script>
	<script src="js/jquery-latest.js"></script>
<%@ page import="java.io.*,java.util.*,javax.mail.*"%>
<%@ page import="javax.mail.internet.*,javax.activation.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>

<style>
 body{background-color:#FF9900;}					
.head{
    color:#FFFFFF;
    font-family:verdana;
    font-size:40px;}
#swp{
	width:20px;
	height:70px;
	color:#ff9900;
	font-size:22px;
	padding-top:40px;
	text-decoration:none;
	text-align:center;
	background-color:#fff;
	border-radius:2px;
	float:left;}    
input[type="text"]{
	color:#FF9900;
	font-size:20px;
	background-color:#FFFFFF;
	margin-left:80px;
	font-family:verdana;
	width:400px;
	height:25px;
	padding:8px;} 
input[type="password"]{
	color:#FF9900;
	font-size:20px;
	background-color:#FFFFFF;
	margin-left:80px;
	font-family:verdana;
	width:400px;
	height:25px;
	padding:8px;} 
input[type="submit"]{
	color:#FFFFFF;
	font-size:15px;
	background-color:#FF9900;
	margin-left:150px;
	font-family:verdana;
	width:150px;
	height:50px;
	border:solid 2px;
	border-color:#FFFFFF;
	border-radius:20px;
	padding:10px;}
input[type="button"]{
	color:#FFFFFF;
	font-size:15px;
	background-color:#FF9900;
	font-family:verdana;
	width:150px;
	height:50px;
	border:solid 2px;
	border-color:#FFFFFF;
	border-radius:20px;
	padding:10px;}
#indiv{
	color:#FFFFFF;}
#hed{
	color:#ffffff;
	margin-left:100px;
	font-size:50px;}
#na{
	margin-top:0;
	color:#FFFFFF;
	font-size:20px;
	font-family:verdana;
	text-align:right;}
.space{
	height:20px;}
.space1{
	height:30px;}
label{
	font-family:verdana;
	color:#FFFFFF;}
a{
	font-size:18px;
	font-family:verdana;
	color:#FFFFFF;}
#indiv{
	color:#FFFFFF;}
#na{
	margin-top:0;
	width:1300px;
	color:#FFFFFF;
	font-size:20px;
	font-family:verdana;
	text-align:right;}
	#na11{
	font-size:15px;
	color:#ffffff;
	margin-left:200px;}
sup { 
	vertical-align: 2.5ex; 
	padding:2px;
	font-size:15px;
	background-color:blue;
	color:#ffffff;
	box-shadow:2px 2px 5px 1px #000;
	border-radius:5px;}
img{
	height:50px;
	width:60px;}
#sec{
	width:49%;
	height:500px;
	background-color:#FF9900;
	float:left;}
#mcim{
	width:3000px;
	height:100px;}
#mcdiv{
	width:1100px;
	height:100px;
	overflow:hidden;
	height:100px;
	float:left;}
#imful{
	width:1200px;}
#inm{
	width:80px;
	height:80px;
	border-radius:8px;
	box-shadow:1px 1px 2px 1px #000;}
#imdv{
	width:49%;
	height:500px;
	background-color:#FF9900;
	float: left;}
#ful{
	width:1200px;
	height:500px;
	background:#FF9900;
	margin-left:80px;
	border:0px solid #FFFFFF;
	float:left;}
#err{
	color:#ffffff;
	font-size:20px;}
</style>
<%@page import=" java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@include file="con.jsp" %>
<script>
$(document).ready(function(){
	$.ajax({
		type:"GET",
		url:"https://bridge-minddotss.rhcloud.com/mindpulpy/get/appid",
		success: function result(xml){
			var code="<br><div id=mcim>";
			$(xml).find("root").each(function(){
				var aa=$(this).find("appid").text();
				code+="&nbsp;&nbsp;<img id='inm' src='https://bridge-minddotss.rhcloud.com/Title?appid="+aa+"'>&nbsp;&nbsp;&nbsp;";
				//apid.push(aa);
			});
			code+="</div>";
			document.getElementById("mcdiv").innerHTML=code;
		},
	});
});
var px101=0;
function scrollDiv(dir, px) {
    var scroller = document.getElementById('mcdiv');
    if (dir == 'l') {
    	if(px101>0)
        $("#mcdiv").animate({scrollLeft:px101-=px},700);
    }
    else if (dir == 'r') {
        //scroller.scrollLeft += px;
        $("#mcdiv").animate({scrollLeft:px101+=px},700);
    }
}
function validateForm(){
	if (myForm.agree.checked == false ){
		alert('Please read the Terms and Fill the check box.');
	 	return false;
	}
 	var x=document.forms["myForm"]["s1"].value;
 	var atpos=x.indexOf("@");
 	var dotpos=x.lastIndexOf(".");
 	if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length){
  		alert("Not a valid e-mail address");
   		return false;
   	}
 	var x1=document.forms["myForm"]["s2"].value;
 	if (x1==null || x1==""){
   		alert("First name must be filled out");
   		return false;
   	}
 	var x2=document.forms["myForm"]["s3"].value;
 	if (x2==null || x2==""){
   		alert("Last name must be filled out");
   		return false;
   	}
 	var x3=document.forms["myForm"]["s4"].value;
 	var passid_len = x3.length;  
 	var mx=6;
	var my=30;
	if (passid_len == 0 ||passid_len >= my || passid_len < mx)  {  
 		alert("Password should not be empty / length be between "+mx+" to "+my);  
 		return false;  
 	} 
}
</script>
<!-- <script>
$(document).ready(function(){
	$('a').click(function() {
    	$('#s2').hide();
       	$('#s3').hide();
        $('#sign').hide();
        $('#s1').slideUp();
        $('#s4').slideUp();
        $('#login').slideUp();   
	});      
});
 </script> -->
 <script type="text/javascript">
function add(){
	window.location="login.jsp";
}
function load(){
	window.open("terms.jsp", '_blank');
}
function load1(){
	window.open("https://bridge-minddotss.rhcloud.com/title.jsp", '_blank');
}
function load3(){
	window.open("https://bridge-minddotss.rhcloud.com/login.jsp", '_blank');
}
function load2(){
	window.open("https://mindtools-inputs.rhcloud.com/index.jsp", '_blank');
}

</script>
</head>
<body>
<form action="LoginPulpy" name="myForm" method="post" onsubmit="return validateForm()">
<div id=na>
	<a href="http://minddotss.com/"><img style="height:60px;width:200px;" src="images/log.png"></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a id="indiv" href='comments.jsp'>Discussion Forum</a>&nbsp;&nbsp;&nbsp;<a id="indiv" href= 'javascript:load1()'>Build Connectors</a>&nbsp;&nbsp;&nbsp;<a id="indiv" href='javascript:load3()'>Popular Connectors</a><sup> Hot.! </sup>&nbsp;&nbsp;&nbsp;<a id="indiv" href='ApiDoc.jsp'>API Documentation</a>&nbsp;&nbsp;&nbsp;<a id="indiv" href= 'javascript:load2()'>Apps Builder</a>&nbsp;&nbsp;&nbsp;<a id="indiv" href= 'addapi.jsp'>Add API's</a>&nbsp;&nbsp;&nbsp;<a id="indiv" href='<%=request.getContextPath()%>Viewapi?category=Search'>Search API's</a>
</div><br><hr>
<div class="head"><center>Mind Pulpy</center></div>
<div id=na11>
	<ul><li>Get your reports from all your cloud / Social media applications in Google spreasheet.</li>	
	<li>MindPulpy automates/ sync up the Data/ task between cloud applications.</li>
	<li>MindPulpy is a platform to aggregate, manipulate, simplify and mashup content from around the web api.</li>
	<li>Get data from any web protocol/ Authentication, method and convert into a developer friendly urls and built apps for multiple devices using Apps builder</li>
	<li>Combine many apis into one and Build custom connectors for cloud platform</li>
	</ul>
</div>
<div id=imful style="margin-left:80px;">
	<a href="javascript:scrollDiv('l', 300)" id=swp>&lt;</a>
	<div id="mcdiv"></div>
	<a href="javascript:scrollDiv('r', 300)" id=swp>&gt;</a>
</div>
<div id=ful><br><br>
	<div id=imdv>
		<img alt="logo" src="images/MindPulpy_Illustration.PNG"style="height:400px;width:500px;">
	</div>
	<div id="sec"><br>
		<center><div id=err>${alert}</div><br>
		<input  type=text name="s1" id='s1' align="center" placeholder="Email"><br><br>
		<input  type=text name="s5" id='s5' placeholder="Mobile Number"><br><br>
		<input  type=text name="s2" id='s2' placeholder="First Name"><br><br>
		<input  type=text name="s3" id='s3' placeholder="Last Name"><br><br>
		<input type=password name="s4" id='s4'  placeholder="Password"><br><br>
		<div style='color:#ffffff;margin-left:70px;font-size:15px;font-family:verdana;'><input type="checkbox" value="0" name="agree">I agree to the Minddots <a style='font-size:15px;'href="javascript:load()">Terms of service</a> and <a style='font-size:15px;'href="javascript:load()">Privacy Policy</a></div><br><br></center>
		<input type="submit" name="submit" id='sign' value="Sign Up">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" name="b2" value="Login" Onclick="add()"><br><br><br>
	</div>
</div>
</form>

</body>
</html>