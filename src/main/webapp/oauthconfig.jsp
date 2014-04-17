<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
body{
background-color:#FF9900;}
.head{
    color:#FFFFFF;
    font-family:verdana;
    font-size:35px;
    margin-top:60px;
    }
.heading{font-family:verdana;
font-weight:bold;
font-size: 20px;
color:#FF9900;
width:25%;
height:30%;
background-color:#FFFFFF;
border-radius:50px;
padding:15px;}
input[type="text"]{
color:#FF9900;
font-size:20px;
background-color:#FFFFFF;
font-family:verdana;
width:300px;
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
.redirect{
font-size:20px;
font-family:verdana;
color:#FFFFFF;

}
</style>
</head>
<body>
<center><div class=head>Mind Pulpy OAuth Authentication</div></center><br><br>
<center><div class='heading'>OAUTH2 Authentication</div></center><br><br>
<form action="OauthLoginServlet" action="get">
<center><div id="container">
<center><div class='redirect'>Redirect URI=http://localhost:8080/MindPulpy1/OauthCallBackServlet</div></center><br><br>
<input type="text" name="cname" value="" placeholder="Client_ID_Label">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="ckey" value="" placeholder="Client_ID_KEY"><br><br>
<input type="text" name="csecname" value="" placeholder="Client_Secret_Label">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="cseckey" value="" placeholder="Client_Secret_Key"><br><br>
<input type="text" name="sname" value="" placeholder="Scope_Label">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="svalue" value="" placeholder="Scope_Value"><br><br>
<input type="text" name="aurl" value="" placeholder="Authorization_URL">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="tokenurl" value="" placeholder="Access_Token_URL"><br><br>
<input type="text" name="tlabel" value="" placeholder="Access_Token_Label">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="treplace" value="" placeholder="Access_Token_Replacement"><br><br>
<input type="text" name="el" value="" placeholder="Extra_Field_Label">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="ev" value="" placeholder="Extra_Field_Value"><br><br><br>
<input type="submit" name="submit" value="Save"></form>
</div></center>
</body>
</html>