<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
$(document).ready(function(){

	 $('input[name=authen]').click(function(){
		    if($('input:radio[name=authen]:checked').val() == "No Auth"){
				$('#req').show();
				  $('#divid').hide();
				  $('#apiid').hide();			
				  $('#oauth2').hide();
				  
			    }
		    else if($('input:radio[name=authen]:checked').val() == "Basic Auth"){
		 $('#divid').show();
		  $('#apiid').hide();
			$('#req').hide();
			$('#oauth2').hide();
			

		    }
	    else if($('input:radio[name=authen]:checked').val() == "API keys"){
	    	$('#apiid').show();
			$('#divid').hide();
			$('#req').hide();
			$('#oauth2').hide();
		    }

 else if($('input:radio[name=authen]:checked').val() == "Oauth1"){
	 $('#apiid').hide();
		$('#divid').hide();
		$('#req').hide();			$('#oauth2').hide();
		
	}

 else if($('input:radio[name=authen]:checked').val() == "Oauth2"){
	 $('#apiid').hide();
		$('#divid').hide();
		$('#req').hide();
		$('#oauth2').show();
		$('.rmethod').show();
		$('#select2').show();	}
 
		});
});
</script>

<style>
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
margin-left:360px;
width:25%;
height:30%;
background-color:#FFFFFF;
border-radius:50px;
padding:15px;
}
#tit{
font-family:verdana;
font-size: 15px;
color:#FF9900;
width:20%;
height:20%;
background-color:#FFFFFF;
border-radius:50px;
padding:15px;
}
label{
font-family:verdana;
font-size: 20px;
color:#FFFFFF;
margin-left:20px;
}
select{color:#FF9900;
font-size:20px;
background-color:#FFFFFF;
margin-left:80px;
font-family:verdana;
width:250px;
height:50px;
padding:10px;}
.rformat{font-family:verdana;
font-size: 20px;
font-weight:bold;
color:#FF9900;
margin-left:360px;
width:25%;
height:30%;
background-color:#FFFFFF;
border-radius:50px;
padding:15px;}
.space{
height:50px;}
input[type="radio"]
 {
   width:20px; 
   height: 20px;
   color:#FFFFFF;
   font-size:20px;
   font-family:verdana;
   margin-left:60px;
 }
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

.resformat{font-family:verdana;
font-size: 20px;
font-weight:bold;
color:#FF9900;
margin-left:360px;
width:25%;
height:30%;
background-color:#FFFFFF;
border-radius:50px;
padding:15px;}
    .rmethod{
    font-family:verdana;
    font-weight:bold;
    font-size: 20px;
     color:#FF9900;
     margin-left:360px;
     width:25%;
height:30%;
background-color:#FFFFFF;
border-radius:50px;
padding:15px;
}

#txt{
margin-left:80px;
font-size:20px;
font-family:verdana;
width:500px;
height:200px;
color:#FF9900;
padding:10px;
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

#req{
color:#FFFFFF;
font-size:10px;
font-family:verdana;
margin-left:100px;
}
#def{
color:#FFFFFF;
font-size:10px;
font-family:verdana;
}
.redirect{
font-size:20px;
font-family:verdana;
color:#FFFFFF;
</style>
</head>
<body>
<br><br><div class="head"><center>Mind Pulpy</center></h2></div><br><br>
<form action="FirstAuthPulpy" method="post">
<input type="text" name="app1" value="" placeholder="Application Name*"><br/><br/> 
<textarea id="txt" name="descr" placeholder="Description*"></textarea><br><br>
<div class="au"><center>Authentication Scheme</center></div><div class="space"></div>
<div id="inline_content">
<input type="radio" name="authen"  value="No Auth">
<label for="rd1">No Auth</label>
<input type="radio" name="authen"   value="Basic Auth">

<label for="rd1">Basic Auth</label>
<input type="radio" name="authen"   value="API keys" >

<label for="rd1">API keys</label>
<input type="radio" name="authen"  value="Oauth1">
<label for="rd1">OAuth1</label>

<input type="radio" name="authen"  value="Oauth2">
<label for="rd1">OAuth2</label>
</div>
<div id="req" style="display:none">Fine! Go ahead</div>

<div id="divid" style="display:none"><br>
<br><br><input type="text" name="b1" value="" placeholder="UserName_Label" >
<input type="text" name="b2" value="" placeholder="UserName_Key" ><br/><br/>
<input type="text" name="b3" value="" placeholder="Password_Label">
<input type="text" name="b4" value="" placeholder="Password_Key">
</div>
<div id="apiid" style="display:none"><br>
<br><br><input type="text" name="a1" value="" placeholder="APIkey_Label" >
<input type="text" name="a2" value="" placeholder="API_Key" ><br/><br/>

</div>
<br><br><div id="oauth2" style="display:none"><br>
<center><div class='redirect'>Redirect URI=http://localhost:8080/MindPulpy1/OauthCallBackServlet</div></center><br><br>
<input type="text" name="cname" value="" placeholder="Client_ID_Label">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="ckey" value="" placeholder="Client_ID_KEY"><br><br>
<input type="text" name="csecname" value="" placeholder="Client_Secret_Label">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="cseckey" value="" placeholder="Client_Secret_Key"><br><br>
<input type="text" name="sname" value="" placeholder="Scope_Label">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="svalue" value="" placeholder="Scope_Value"><br><br>
<input type="text" name="aurl" value="" placeholder="Authorization_URL">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="tokenurl" value="" placeholder="Access_Token_URL"><br><br>
<input type="text" name="tlabel" value="" placeholder="Access_Token_Label">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br><br><br>
<center><div id="tit">Token Replacement</div></center><br>
<input type="radio" name="treplace"  value="Authorization:Bearer">
<label for="rd2">Authorization:Bearer</label>
<input type="radio" name="treplace"   value="Authorization:header">
<label for="rd2">Authorization:header</label>
<input type="radio" name="treplace"   value="Authorization:User&Pwd" >
<label for="rd2">Authorization:User&Pwd</label>
<input type="radio" name="treplace"   value="QueryString" >
<label for="rd2">Query String</label>

<center><div id="def">* Tokens placed in headers will look like Authorization: Bearer <token> and tokens in querystrings will look like ?access_token=token</div></center><br>
<input type="text" name="el" value="" placeholder="Extra_Field_Label">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="ev" value="" placeholder="Extra_Field_Value"></div><br><br>

<div class="sselect" style="display:none">
<div class="rformat"><center>Request Format</center></div>
<select name="select1"  id="select1" onchange="change()">
    <option value="REST">REST</option>
    <option value="XML-RPC">XML-RPC</option>
    <option value="SOAP">SOAP</option>
    
</select></div><br/><br/>
<div class="rmethod" style="display:none"><center>Request Method</center></div>
<select name="select2"  id="select2" onchange="change()" style="display:none">
    <option value="GET">GET</option>
    <option value="POST">POST</option>
    <option value="PUT">PUT</option>
    <option value="DELETE">DELETE</option>
</select><br/><br/>

<input type="submit" name="submit" value="Continue">
</body>
</html>