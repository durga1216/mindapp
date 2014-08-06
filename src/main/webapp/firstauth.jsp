<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MindPulpy</title>
<link rel="shortcut icon" href="favicon.ico" />
	<script src="js/jquery-latest.js"></script>
	 <%response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Cache-Control", "no-store");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);%>
<script type="text/javascript">

var intTextBox=0;
function addParent(){
	  intTextBox = intTextBox + 1;
	  var contentID = document.getElementById('content');
	  var newTBDiv = document.createElement('div');
	  newTBDiv.setAttribute('id','strText'+intTextBox);
	  newTBDiv.innerHTML = "<input type='text' id='h" + intTextBox + "'    name='h" + intTextBox + "' placeholder='Header_Label'/>" + "<input type='text' id='hv"+ intTextBox + " ' name='hv"+intTextBox+"' placeholder='Header_Value'/>";
	  contentID.appendChild(newTBDiv);
}
function removeParent()
{
	var contentID = document.getElementById('content');
    contentID.removeChild(document.getElementById('strText'+intTextBox));
    intTextBox = intTextBox-1;
	}
	
$(document).ready(function(){

	 $('input[name=authen]').click(function(){
		    if($('input:radio[name=authen]:checked').val() == "No Auth"){
				$('#req').show();
				  $('#divid').hide();
				  $('#apiid').hide();			
				  $('#oauth2').hide();
				  $('.rmethod').hide();
					$('#select2').hide();
									$('#others').hide();
									$('#oauth1').hide();
					
				  
			    }
		    else if($('input:radio[name=authen]:checked').val() == "Basic Auth"){
		 $('#divid').show();
		  $('#apiid').hide();
			$('#req').hide();
			$('#oauth2').hide();
			$('.rmethod').hide();
			$('#select2').hide();
							$('#others').show();
							$('#oauth1').hide();
			

		    }
	    else if($('input:radio[name=authen]:checked').val() == "API keys"){
	    	$('#apiid').show();
			$('#divid').hide();
			$('#req').hide();
			$('#oauth2').hide();
			$('.rmethod').hide();
			$('#select2').hide();
							$('#others').hide();
							$('#oauth1').hide();
			
		    }

 else if($('input:radio[name=authen]:checked').val() == "Oauth1"){
	 $('#apiid').hide();
		$('#divid').hide();
		$('#req').hide();	
		$('#oauth2').hide();
		$('.rmethod').hide();
		$('#select2').hide();
						$('#others').hide();
						$('#oauth1').show();
		
	}

 else if($('input:radio[name=authen]:checked').val() == "Oauth2"){
	 $('#apiid').hide();
		$('#divid').hide();
		$('#req').hide();
				$('#others').hide();
		
		$('#oauth2').show();
		$('.rmethod').show();
		$('#select2').show();
		$('#oauth1').hide();}
 
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
input[type="text"],input[type="password"]{
color:#FF9900;
font-size:20px;
background-color:#FFFFFF;
margin-left:80px;
font-family:verdana;
width:400px;
height:25px;
padding:10px;
} 

 #pa{
  font-family:verdana;
  font-size:20px;
  color:#FFFFFF;
  margin-left:100px;
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
font-size:15px;
font-family:verdana;
margin-left:100px;
}
#others{color:#FFFFFF;
font-size:15px;
font-family:verdana;
margin-left:100px;}
#def{
color:#FFFFFF;
font-size:10px;
font-family:verdana;
}
.redirect{
font-size:20px;
font-family:verdana;
color:#FFFFFF;}
#indiv{color:#FFFFFF;
}
#na{
margin-top:0;
color:#FFFFFF;
font-size:15px;
font-family:verdana;
text-align:right;}
#tt{
font-size:25px;
color:#ffffff;
margin-left:100px;
}
#eg{
font-size:15px;
color:#ffffff;
margin-left:70px;
float:left;
}
#eg1{
font-size:15px;
color:#ffffff;
float:left;
}
#hlt{
color:#ffffff;
float:left;
font-size:20px;
box-shadow:2px 2px 5px 1px black;
border-radius:3px;
}
</style>
</head>
<body>
 <%String u = (String) request.getSession().getAttribute("user");
 String q = request.getParameter("q");
 session.setAttribute("q", q);
    if (u != null ) {
   // System.out.println("user != null");
   // out.print("Welcome "+u);
    }else{
   // System.out.println("user == null");
    response.sendRedirect("logout.jsp");
    }%>
<div id=na><%=session.getAttribute("mail")%> &nbsp;|&nbsp;<a id='indiv' href='ApiDoc.jsp'>API Documentation</a>&nbsp;|&nbsp;<a id='indiv' href = 'mobile_client.jsp'> API Console </a>&nbsp;|&nbsp;<a id='indiv' href='<%=request.getContextPath()%>/ApiPulpy'>API Usage</a>&nbsp;|&nbsp;<a id='indiv' href = 'logout.jsp'> Sign Out </a></div>

<br><br><div class="head"><center>Mind Pulpy</center></h2></div><br><br>
<form action="FirstAuthPulpy" method="post" enctype="multipart/form-data">
<input type="text" name="app1" value="" placeholder="Application Name*" required><br/><br>
<div id="tt">Select Logo:  &nbsp;&nbsp;&nbsp;&nbsp;<input style="color:#ffffff;" type="file" name="logo" placeholder="image location"></div><br><br>
<textarea id="txt" name="descr" placeholder="Description*" required></textarea><br><br>
<div class="au"><center>Authentication Scheme</center></div><div class="space"></div>
<div id="inline_content">
<input type="radio" name="authen"  value="No Auth">
<label for="rd1">No Auth</label>
<input type="radio" name="authen"   value="Basic Auth">

<label for="rd1">Basic Auth/Http headers</label>
<input type="radio" name="authen"   value="API keys" >

<label for="rd1">API keys</label>
<input type="radio" name="authen"  value="Oauth1">
<label for="rd1">OAuth1</label>

<input type="radio" name="authen"  value="Oauth2">
<label for="rd1">OAuth2</label>
</div>
<div id="req" style="display:none">Fine! Go ahead</div>
<br><div id="others" style="display:none">If Http headers, Please leave username & password fields and add your credentials in header</div>
<div id="divid" style="display:none"><br>
<input type="text" name="b2" value="" placeholder="UserName" >
<input type="password" name="b4" value="" placeholder="Password"><br><br><br>
<a id='pa' href="javascript:addParent();">Add Header</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a id='pa' href="javascript:removeParent();">Remove Header</a></center><br><br>
<br><div id="content"></div><br>
</div>


<div id="apiid" style="display:none"><br>
<br><div id=eg>Eg: http://ABC.com/search?</div><div id=hlt> &nbsp;api_key &nbsp;</div><div id=eg1>=xxxxxxxxx & params1=bangalore</div>
<div id=eg>Eg: http://ABC.com/search?api_key=</div><div id=hlt>&nbsp; xxxxxxxxx &nbsp;</div><div id=eg1> & param1=bangalore</div><br><br>
<input type="text" name="a1" value="" placeholder="APIkey_Label" >
<input type="text" name="a2" value="" placeholder="API_Key" >

</div>
<br><div id="oauth1" style="display:none"><br>
<input type="text" name="ockey" value="" placeholder="oauth_consumer_key">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="oskey" value="" placeholder="oauth_secret_key"><br><br>
<input type="text" name="ourl1" value="" placeholder="Request_token_Url">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="ourl2" value="" placeholder="Authorization_Url"><br><br>
<input type="text" name="ourl3" value="" placeholder="Access_Token_Url">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="osmeth" value="HMAC-SHA1" placeholder="Signature_Method"><br><br>
<select name="oreq">
<option value="dummy">Request Method</option>
    <option value="GET">GET</option>
    <option value="POST">POST</option>
    <option value="PUT">PUT</option>
    <option value="DELETE">DELETE</option>
</select><br/><br/>
</div>

<br><br><div id="oauth2" style="display:none"><br>
<center><div class='redirect'>Redirect URI=/OauthCallBackServlet</div></center><br><br>
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
<input type="text" name="ev" value="" placeholder="Extra_Field_Value"></div>

<div class="sselect" style="display:none">
<div class="rformat"><center>Request Format</center></div>
<select name="select1"  id="select1" onchange="change()">
    <option value="REST">REST</option>
    <option value="XML-RPC">XML-RPC</option>
    <option value="SOAP">SOAP</option>
    
</select></div><br/><br/>
<div class="rmethod" style="display:none"><center>Access Token Method</center></div>
<select name="select2"  id="select2" onchange="change()" style="display:none">
    <option value="GET">GET</option>
    <option value="POST">POST</option>
    <option value="PUT">PUT</option>
    <option value="DELETE">DELETE</option>
</select><br/><br/>

<input type="submit" name="submit" value="Continue">
</body>
</html>