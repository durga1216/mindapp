<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>MindPulpy</title>
<link rel="shortcut icon" href="favicon.ico" />

	<script src="/jquery-latest.js"></script>
<%@ page import="java.io.*,java.util.*,javax.mail.*"%>
<%@ page import="javax.mail.internet.*,javax.activation.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>

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
 function validateForm()
 {
 var x=document.forms["myForm"]["s1"].value;
 var atpos=x.indexOf("@");
 var dotpos=x.lastIndexOf(".");
 if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length)
   {
   alert("Not a valid e-mail address");
   return false;
   }
 var x1=document.forms["myForm"]["s2"].value;
 if (x1==null || x1=="")
   {
   alert("First name must be filled out");
   return false;
   }
 var x2=document.forms["myForm"]["s3"].value;
 if (x2==null || x2=="")
   {
   alert("Last name must be filled out");
   return false;
   }
 var x3=document.forms["myForm"]["s4"].value;
 var passid_len = x3.length;  
 var mx=6;
var my=10;
if (passid_len == 0 ||passid_len >= my || passid_len < mx)  
 {  
 alert("Password should not be empty / length be between "+mx+" to "+my);  
 return false;  
 } 
 }
 </script>
 
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
<form action="LoginPulpy" name="myForm" method="post" onsubmit="return validateForm()">
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