<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<script src="js/jquery-latest.js"></script>

<html>
<head>
 <%response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Cache-Control", "no-store");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MindPulpy</title>
<link rel="shortcut icon" href="favicon.ico" />
<style>
body{
background-color:#FF9900;}
.head{
    color:#FFFFFF;
    font-family:verdana;
    font-size:40px;}
  #pa{
  font-family:verdana;
  font-size:20px;
  color:#FFFFFF;
  margin-left:100px;
  }
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
.link{
font-family:verdana;
font-size: 20px;
font-weight:bold;
color:#FF9900;
margin-left:360px;
width:25%;
height:30%;
background-color:#FFFFFF;
border-radius:50px;
padding:15px;
}
.params{
font-family:verdana;
font-size: 20px;
color:#FF9900;
margin-left:360px;
width:25%;
height:30%;
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

input[type="password"]{
color:#FF9900;
font-size:20px;
background-color:#FFFFFF;
margin-left:150px;
font-family:verdana;
width:250px;
height:30px;
padding:10px;
}

input[type="submit"]{

color:#FFFFFF;
font-size:20px;
background-color:#FF9900;
margin-left:280px;
font-family:verdana;
width:140px;
height:50px;
border:solid 2px;
border-color:#FFFFFF;
border-radius:50px;
padding:10px;
}
}
.func{
margin-left:300px;
}
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

/*.select1{color:#FF9900;
font-size:20px;
background-color:#FFFFFF;
margin-left:80px;
font-family:verdana;
width:250px;
height:30px;
padding:10px;
}*/
select{color:#FF9900;
font-size:20px;
background-color:#FFFFFF;
margin-left:80px;
font-family:verdana;
width:250px;
height:50px;
padding:10px;}

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
margin-left:650px;
}
#mnote{
color:#FFFFFF;
font-size:15px;
margin-left:100px;
font-family:verdana;

}
#indiv{color:#FFFFFF;
}
#na{
margin-top:0;
color:#FFFFFF;
font-size:15px;
font-family:verdana;
text-align:right;}
</style>
<script type="text/javascript">
function basauth(){
	 /* var contentID = document.getElementById('content');
      var newTBDiv = document.createElement('div');
      newTBDiv.innerHTML = "<input type='text' name='b1' placeholder='username_label'><input type='text' name='b2' placeholder='username_key'><br><input type='password' name='b3' placeholder='password_label'><input type='text' name='b4' placeholder='password_key'><br><br><div class='func'><input type='submit' name='submit' value='Save'></div>";
      contentID.appendChild(newTBDiv);*/
    /*document.getElementById("b1").value=style.display='block';
    document.getElementById("b1").value=style.display='block';*/
    document.getElementById("b1").style.display='block';
    document.getElementById("b3").style.display='block';
    document.getElementById("b4").style.display='block';

    

}
var intTextBox=0;
function addParent()
{
  intTextBox = intTextBox + 1;
  var contentID = document.getElementById('content');
  var newTBDiv = document.createElement('div');
      newTBDiv.setAttribute('id','strText'+intTextBox);
  newTBDiv.innerHTML = "<input type='text' id='p" + intTextBox + "'    name='p" + intTextBox + "' placeholder='Param_Label'/>" + "<input type='text' id='pv"+ intTextBox + " ' name='pv"+intTextBox+"' placeholder='Param_Value'/>";
  contentID.appendChild(newTBDiv);
// alert( "Text "+intTextBox+":  id='p" + intTextBox + "'    name='p" + intTextBox + "'");
}

function removeParent(){
	var contentID = document.getElementById('content');
    contentID.removeChild(document.getElementById('strText'+intTextBox));
    intTextBox = intTextBox-1;
}
 function getApi(){
	/* var contentID = document.getElementById('content');
     var newTBDiv = document.createElement('div');
     newTBDiv.innerHTML = "<input type='text' name='a1' placeholder='API_label'><input type='text' name='a2' placeholder='API_key'><input type='submit' name='submit1' value='Save'>";
     contentID.appendChild(newTBDiv);*/

	 }
 function oauth1(){}
 function oauth2(){}

$(document).ready(function(){
$('#select3').on('change', function() {
    if (this.value == 'XML-RPC') {
    $('#method').show();
    $('#mnote').show();
    
}
   else if(this.value == 'XML'){
   $('#method').hide();
   $('#mnote').hide();
   }
   
   else if(this.value == 'JSON'){
   $('#method').hide();
   $('#mnote').hide();
   }
   
   else if(this.value == 'SOAP'){
   $('#method').hide();
   $('#mnote').hide();
   }
});
});

 </script>
</head>
<body>
 <%String u = (String) request.getSession().getAttribute("user");
    if (u != null ) {
   // System.out.println("user != null");
    //out.print("Welcome "+u);
    }else{
   // System.out.println("user == null");
    response.sendRedirect("logout.jsp");
    }%>
<form action="AuthPulpy" method="post">

<div id=na><%=session.getAttribute("mail")%>|<a id='indiv' href = 'mobile_client.jsp'> API Test </a>&nbsp;|&nbsp;<a id="indiv" href='<%=request.getContextPath()%>/ApiPulpy'>API Usage</a>|<a id="indiv" href= 'logout.jsp'> Sign Out </a></div>

<br><br><div class="head"><center>Mind Pulpy</center></h2></div><br><br>

<br>
<div class="rmethod"><center>Request Method</center></div>
<select name="select2"  id="select2" onchange="change()">
    <option value="GET">GET</option>
    <option value="POST">POST</option>
    <option value="PUT">PUT</option>
    <option value="DELETE">DELETE</option>
</select><br/><br/>

<div class="resformat"><center>Response Format</center></div>
<select name="select3" id="select3">
     <option value="XML">XML</option>
     <option value="JSON">JSON</option>
     <option value="XML-RPC">XML-RPC</option>
    <option value="SOAP">SOAP</option>
</select><br><br>
<div id='mnote' style="display:none">* Enter Base-URL inside of End_Point_URL and also enter appropriate Method Name</div><br>
<input type="text" name="endurl" placeholder="End_Point_URL*"><br><br>
<input type="text" name="method" id="method" placeholder="Method_name" style="display:none"><br><br>
<div class="link"><center>Add Parameters</center></div><br><br>
<a id='pa' href="javascript:addParent();">Add Params</a>&nbsp;&nbsp;<a id='pa' href="javascript:removeParent();">Remove Params</a><br><br>
<div id="content"></div><br><br>
<input type="submit" name="first" value="Continue">
</form>
</body>
</html>

