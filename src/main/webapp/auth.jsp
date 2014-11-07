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
width:350px;
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
#txt{
margin-left:80px;
font-size:20px;
font-family:verdana;
width:500px;
height:200px;
color:#FF9900;
padding:10px;
}
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
newTBDiv.innerHTML = "<input type='text' id='p" + intTextBox + "'    name='p" + intTextBox + "' placeholder='Param_Label'/>" + "<input type='text' id='pv"+ intTextBox + " ' name='pv"+intTextBox+"' placeholder='Param_Value'/><input type='radio' name='field"+intTextBox+"'  value='Optional'><label for='rd"+intTextBox+"'>Optional</label><input type='radio' name='field"+intTextBox+"'   value='Mandatory'><label for='rd"+intTextBox+"'>Mandatory</label>";
  contentID.appendChild(newTBDiv);
}

function removeParent(){
	var contentID = document.getElementById('content');
    contentID.removeChild(document.getElementById('strText'+intTextBox));
    intTextBox = intTextBox-1;
}
function addParent1()
{
  intTextBox = intTextBox + 1;
  var contentID = document.getElementById('content1');
  var newTBDiv = document.createElement('div');
      newTBDiv.setAttribute('id','strText'+intTextBox);
newTBDiv.innerHTML = "<input type='text' id='j" + intTextBox + "'    name='j" + intTextBox + "' placeholder='KEY'/>" + "<input type='text' id='jv"+ intTextBox + " ' name='jv"+intTextBox+"' placeholder='Value'/>";
  contentID.appendChild(newTBDiv);
}

function removeParent1(){
	var contentID = document.getElementById('content1');
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
$(document).ready(function(){
	$('#select2').on('change', function() {
	    if (this.value == 'GET') {
	    $('#jrpc').hide();
 	   $('#json').hide();

	}
	    else if(this.value == 'POST_JSON'){
	    	   $('#jrpc').show();
	    	   $('#json').show();

	    	   }
	   else if(this.value == 'POST'){
	   $('#jrpc').hide();	    	   $('#json').show();

	   }
	   
	   else if(this.value == 'PUT'){
	   $('#jrpc').hide();	    	   $('#json').show();

	   }
	   
	   else if(this.value == 'DELETE'){
	   $('#jrpc').hide();	    	   $('#json').show();

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

<div id=na><%=session.getAttribute("mail")%>|<a id="indiv" href='ApiDoc.jsp'>API Documentation</a>&nbsp;|&nbsp;<a id='indiv' href = 'mobile_client.jsp'> API Console </a>&nbsp;|&nbsp;<a id="indiv" href='<%=request.getContextPath()%>/ApiPulpy'>API Usage</a>|<a id="indiv" href= 'logout.jsp'> Sign Out </a></div>

<br><br><div class="head"><center>Mind Pulpy</center></h2></div><br><br>

<br>
<div class="rmethod"><center>Request Method</center></div>
<select name="select2"  id="select2" onchange="change()">
    <option value="GET">GET</option>
    <option value="POST">POST</option>
    <option value="POST-JSON">POST-JSON</option>
    <option value="PUT">PUT</option>
    <option value="DELETE">DELETE</option>
</select><br/><br/>

<div id="json" style="display:none">
<textarea id="txt" name="txt" placeholder="Enter Valid JSON String" required></textarea><br><br>
</div>

<div class="resformat"><center>Response Format</center></div>
<select name="select3" id="select3">
     <option value="XML">XML</option>
     <option value="JSON">JSON</option>
     <option value="XML-RPC">XML-RPC</option>
    <option value="SOAP">SOAP</option>
</select><br><br>
<div id='mnote' style="display:none">* Enter Base-URL inside of End_Point_URL and also enter appropriate Method Name</div><br>
<div id=eg>Eg:&nbsp; </div><div id=hlt> &nbsp;http://abc.com/search &nbsp;</div><div id=eg1>&nbsp;?api_key=xxxxxxxxx & params1=bangalore</div><br><br>
<input type="text" name="endurl" placeholder="End_Point_URL*"><br><br>
<input type="text" name="method" id="method" placeholder="Method_name" style="display:none">
<div id=jrpc style='display:none;'><a id='pa' href="javascript:addParent1();">Add Key-value</a>&nbsp;&nbsp;<a id='pa' href="javascript:removeParent1();">Remove Key-value</a><br>
<br><div id="content1"></div></div><br><br>
<div class="link"><center>Add Parameters</center></div><br><br>
<div id='mnote' >* If parameters join with Url, then leave Param-label field</div><br>
<a id='pa' href="javascript:addParent();">Add Params</a>&nbsp;&nbsp;<a id='pa' href="javascript:removeParent();">Remove Params</a><br>
<br><div id=eg>Eg: http://ABC.com/search?api_key=xxx& </div><div id=hlt> &nbsp;param1 &nbsp;</div><div id=eg1>&nbsp;=bangalore</div>
<div id=eg>Eg: http://ABC.com/search?api_key=xxx& param1=</div><div id=hlt>&nbsp; bangalore &nbsp;</div><br><br>
<div id="content"></div><br><br>
<input type="submit" name="first" value="Continue">
</form>
</body>
</html>

