<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
 body{background-color:#FF9900;}
.head{
    color:#FFFFFF;
    font-family:verdana;
    font-size:40px;}
    input[type="text"] {
    color:#FF9900;
    text-align:left;
    font-family:verdana;
     width: 350px; 
     height: 50px;
   border:2px solid;
   border-color:#FFFFFF;
   border:2px solid #FFFFFF;
    margin-right: auto;
    margin-bottom: 0;
    margin-left: 500px;
    border-radius:50px;
    padding:20px;
}
 input[type="submit"]
 {
 width:150px;
 height:40px;
 background-color:#FFFFFF;
 border:1px solid;
 font-weight:bold;
   border-color:#FFFFFF;
 text-align:center;
     margin-left: 600px;
     color:#FF9900;
 
 }
.space{
height:20px;
}
.space1
{height:30px;}
.label{
     margin-left: 660px;
font-family:verdana;
font-size:20px;
color:#FFFFFF;
}
 </style>
</head>
<body>
<form action="LoginPulpy" method="post">
<br><br><div class="head"><center>Mind Pulpy</center></h2></div><br><br>
<div class="sec">
<input  type=text name="s1" align="center" placeholder="Email"><div class="space"></div>
<input  type=text name="s2" align="center" placeholder="First Name"><div class="space"><br>
<input  type=text name="s3" align="center" placeholder="Last Name"><div class="space"><br>
<input type=text name="s4" align="center" placeholder="Password"><div class="space"><br>
<input type="submit" name="submit" value="Sign Up"><div class="space1">
<div class="label">OR</div>
<input type="submit" name="submit" value="Login"><div class="space1">



</div></form>
</body>
</html>