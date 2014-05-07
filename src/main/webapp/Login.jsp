<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mind Pulpy</title>
	<script src="js/jquery-latest.js"></script>
	
<style>
input[type="text"]{
color:#FF9900;
font-size:20px;
background-color:#FFFFFF;
margin-left:350px;
font-family:verdana;
width:300px;
height:20px;
padding:10px;
} 
label{
font-family:verdana;
font-size: 20px;
color:#FFFFFF;
margin-left:20px;
}
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
margin-left:80px;
width:10%;
height:20%;
background-color:#FFFFFF;
border-radius:50px;
padding:15px;
}   
 
input[type="submit"]{
color:#FFFFFF;
font-size:20px;
background-color:#FF9900;
margin-left:380px;
font-family:verdana;
width:140px;
height:50px;
border:solid 2px;
border-color:#FFFFFF;
border-radius:50px;
padding:10px;
}
</style>	
</head>
<body>
 <%request.getSession().setAttribute("user", "mind");%>
<br><br><div class="head"><h2><center>Login form</center></h2></div><br><br>
<form action="Login" method="post">
<div class="au">Username</div><input type="text" name="app1" value="" placeholder="username*"><br/><br/> 
<div class="au">Password</div><input type="text" name="app2" value="" placeholder="password*"><br/><br/><br/><br/>  
<input type="submit" name="submit" value="LOGIN"><br><br>
<input type="submit" name="submit" value="SIGNUP">

</form>
</body>
</html>