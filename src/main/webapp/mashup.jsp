<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mash Up</title>
<link rel="shortcut icon" href="favicon.ico" />
<style type="text/css">
body{
background-color:#ffffff;
}
#hd{
position: relative;
max-width: 1200px;
border-radius:10px;
margin: 0 auto;
box-shadow:3px 3px 6px 2px #000000;
background: #ff9900;
overflow: hidden;
}
h1{
color:#ffffff;}
h2{
color:#ffffff;
text-align:center;
}
a{
background-color:#ffffff;
padding:10px;
border-radius:8px;
text-decoration:none;
box-shadow:2px 2px 5px 1px #000000;
color:#ff9900;
}
#lt{
top-margin:50px;
float:left;
margin-left:50px;
font-size:20px;
}
#rt{
float:right;
margin-right:50px;
font-size:20px;
}
</style>
<script type="text/javascript">
function load1(){
	window.open("PreMashup?conf=1", '_blank');
}
function load2(){
	window.open("PreMashup?conf=2", '_blank');
}
function load3(){
	window.open("PreMashup?conf=3", '_blank');
}
function load4(){
	window.open("PreMashup1", '_blank');
}
</script>
</head>
<body>
<div id=hd><br><br><div id=lt><a href="prebuiltapi.jsp">Back</a></div><div id=rt><a href="logout.jsp">Sign Out</a></div><center><h1>Prebuilt MashUp Result</h1></center></div><br>
<div id=hd><br><br><br><h2><a href="javascript:load1()">Click Here for first configuration result</a></h2>
<br><br><h2><a href="javascript:load2()">Click Here for second configuration result</a></h2>
<br><br><h2><a href="javascript:load3()">Click Here for Third configuration result</a></h2>
<br><br><h2><a href="javascript:load4()">Click Here for Final MashUp result</a></h2><br><br></div>
</body>
</html>