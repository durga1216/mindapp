<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>MindPulpy</title>
<link rel="shortcut icon" href="favicon.ico" />

	<script src="js/jquery-latest.js"></script><head>
	<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-50928435-1', 'mindapp-pulpy.rhcloud.com');
  ga('send', 'pageview');

</script>
<style>
body{background-color:#FF9900;}
.head{
    color:#FFFFFF;
    font-family:verdana;
    font-size:40px;}
    .au{
font-family:verdana;
font-weight:bold;
font-size: 20px;
color:#FF9900;
width:25%;
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
width:300px;
height:25px;
padding:10px;
} 
input[type="button"],input[type="submit"]{

color:#FFFFFF;
font-size:15px;
background-color:#FF9900;
font-family:verdana;
width:150px;
height:50px;
border:solid 2px;
border-color:#FFFFFF;
border-radius:20px;
padding:10px;
}
input[type="password"]{
color:#FF9900;
font-size:20px;
background-color:#FFFFFF;
font-family:verdana;
width:300px;
height:25px;
padding:10px;
} 

 

.result{
color:#FFFFFF;
    font-family:verdana;
    font-size:25px;}
    
</style>
</head>
 <script type="text/javascript">
function add()
{
	window.location="index.jsp";
	}
function load(){
	window.open("terms.jsp", '_blank');
	
}
</script>
<body>
<form action="LoginCheckPulpy" method="post">
<br><br><div class="head"><center>Mind Pulpy</center></h2></div><br><br><center><div class='au'><center>Login Here</center></div></center>
<center>&nbsp;&nbsp;&nbsp;&nbsp;<div class="result">${alert}</div></center><br><br>
<center><input type=text name="t1" id='t1' placeholder="Email"><br><br>
<input type=password name="t2" id='t2'  placeholder="Password"><br><br><br></center>
<center><input type="submit" name="submit" id='Login' value="Login">&nbsp;&nbsp;&nbsp;&nbsp;
<input type="button" name="b2" value="Signup" Onclick="add()"><center><br>

</form>
</body>
</html>