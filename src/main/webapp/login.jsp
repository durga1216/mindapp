<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>MindPulpy</title>
<link rel="shortcut icon" href="favicon.ico" />

	<script src="http://code.jquery.com/jquery-latest.js"></script><head>
<style>
body{background-color:#FF9900;}
.head{
    color:#FFFFFF;
    font-family:verdana;
    font-size:40px;}
    
    
input[type="text"]{
color:#FF9900;
font-size:20px;
background-color:#FFFFFF;
margin-left:80px;
font-family:verdana;
width:400px;
height:25px;
padding:10px;
} 

input[type="password"]{
color:#FF9900;
font-size:20px;
background-color:#FFFFFF;
margin-left:80px;
font-family:verdana;
width:400px;
height:25px;
padding:10px;
} 

 input[type="submit"]{

color:#FFFFFF;
font-size:20px;
background-color:#FF9900;
font-family:verdana;
width:140px;
height:50px;
border:solid 2px;
border-color:#FFFFFF;
border-radius:50px;
padding:10px;
}

.result{
color:#FFFFFF;
    font-family:verdana;
    font-size:25px;}
    
</style>
</head>
<body>
<form action="LoginCheckPulpy" method="post">
<br><br><div class="head"><center>Mind Pulpy</center></h2></div><br><br>
<center>&nbsp;&nbsp;&nbsp;&nbsp;<div class="result">${alert}</div></center><br><br>
<center><input type=text name="t1" id='t1' placeholder="Email"><br><br>
<input type=password name="t2" id='t2'  placeholder="Password"><br><br><br></center>
<center>&nbsp;&nbsp;<input type="submit" name="submit" id='Login' value="Login"><center><br>

</form>
</body>
</html>