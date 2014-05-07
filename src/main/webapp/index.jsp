<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>MindPulpy</title>
<link rel="shortcut icon" href="favicon.ico" />

	<script src="/jquery-latest.js"></script>

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

.space{
height:20px;
}
.space1
{height:30px;}
.label{
font-family:verdana;
font-size:20px;
color:#FFFFFF;
}
a{
    font-size:20px;
    font-family:verdana;
    color:#FFFFFF;
    
    }
 </style>
 
 <script>
 
  $(document).ready(function(){
      $('a').click(function() {
      $('#s2').hide();
         $('#s3').hide();
         $('#sign').hide();
          $('#s1').slideUp();
         $('#s4').slideUp();
         $('#login').slideUp();
         
       } ); 
         
   });
 </script>
 
</head>
<body>
<form action="LoginPulpy" method="post">
<br><br><div class="head"><center>Mind Pulpy</center></h2></div><br><br>
<div class="sec">
<center><input  type=text name="s1" id='s1' align="center" placeholder="Email"><br><br>
<input  type=text name="s2" id='s2' placeholder="First Name"><br><br>
<input  type=text name="s3" id='s3' placeholder="Last Name"><br><br>
<input type=password name="s4" id='s4'  placeholder="Password"><br><br><br></center>
<center><input type="submit" name="submit" id='sign' value="Sign Up"><center><br>
<center><div class="label">OR</div></center><br>
<center><a href="login.jsp">Click here to Login</a></center>
</form>
</body>
</html>