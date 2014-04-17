<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
.head{
color:#000000;
    font-family:verdana;
    font-size:35px;
    font-weight:bold;
}
body{
background-color:#33FF99;

}
input[type="text"]{
color:#33FF99;
font-size:20px;
background-color:#000000;
margin-left:80px;
font-family:verdana;
width:400px;
height:25px;
padding:20px;
} 
input[type="submit"]{

color:#000000;
font-size:20px;
background-color:#33FF99;
margin-left:280px;
font-family:verdana;
width:140px;
height:50px;
border:solid 2px;
border-color:#000000;
border-radius:50px;
padding:10px;
}
</style>
<body><div class="head">
<center>Mobile App</center></div>
<form action="AuthXmlPulpy" method="post">
<input type="text" name="appid" value="" placeholder="App_Id"><br><br>
<input type="text" name="p1" value="" placeholder="Param1"><br><br>
<input type="text" name="p2" value="" placeholder="Param2"><br><br>
<input type="text" name="p3" value="" placeholder="Param3"><br><br>
<input type="text" name="p4" value="" placeholder="Param4"><br><br>
<input type="text" name="p5" value="" placeholder="Param5"><br><br>
<input type="text" name="p6" value="" placeholder="Param6"><br><br>
<input type="submit" name="submit" value="submit"></form>
</body>
</html>