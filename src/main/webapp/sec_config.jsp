<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script src="js/jquery-latest.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MindPulpy</title>
<%response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Cache-Control", "no-store");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);%>
<link rel="shortcut icon" href="favicon.ico" /></head>
<style>
body{
background-color:#FF9900;}
#head{
    color:#FFFFFF;
    font-family:verdana;
    font-size:40px;
    margin-top:50px;}
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

 input[type="radio"]
 {
   width:20px; 
   height: 20px;
   color:#FFFFFF;
   font-size:20px;
   font-family:verdana;
   margin-left:80px;
 }
 #note{
 color:#FFFFFF;
font-size:10px;
font-family:verdana;
margin-left:100px;
 }
 #not{
 color:#FFFFFF;
font-size:10px;
font-family:verdana;
margin-left:100px;
 }
input[type="submit"]{

color:#FFFFFF;
font-size:20px;
background-color:#FF9900;
margin-left:620px;
font-family:verdana;
width:140px;
height:50px;
border:solid 2px;
border-color:#FFFFFF;
border-radius:50px;
padding:10px;
}
  #pa{
  font-family:verdana;
  font-size:20px;
  color:#FFFFFF;
  margin-left:80px;
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
label{
font-family:verdana;
font-size: 20px;
color:#FFFFFF;
}

select{color:#FF9900;
font-size:20px;
background-color:#FFFFFF;
margin-left:80px;
font-family:verdana;
width:250px;
height:50px;
padding:10px;}

.resformat{font-family:verdana;
font-size: 20px;
font-weight:bold;
color:#FF9900;
margin-left:480px;
width:25%;
height:30%;
background-color:#FFFFFF;
border-radius:50px;
padding:15px;}

#indiv{color:#FFFFFF;
font-size:15px;
font-family:verdana;
text-align:right;}

#na{
color:#FFFFFF;
font-size:15px;
font-family:verdana;
text-align:right;}
</style>

<script type="text/javascript">
$(document).ready(function(){
	$('input[name=cycle]').click(function(){
		    if($('input:radio[name=cycle]:checked').val() == "flow"){
			$('#ent').hide();
		    $('#flo').show();
			    }
		    else if($('input:radio[name=cycle]:checked').val() == "entity"){
		     $('#ent').show();
			$('#flo').hide();

		    }
});
});
var intTextBox=0;
function addParent()
{
	intTextBox = intTextBox + 1;
   var contentID = document.getElementById('content');
    var newTBDiv = document.createElement('div');
    newTBDiv.setAttribute('id','strText'+intTextBox);
    newTBDiv.innerHTML = "<input type='text' id='s" + intTextBox + "'    name='s" + intTextBox + "' placeholder='Param_Label'/>" + "<input type='text' id='sv"+ intTextBox + " ' name='sv"+intTextBox+"' placeholder='Param_Value'/>";
    contentID.appendChild(newTBDiv);
}

function removeParent(){
	var contentID = document.getElementById('content');
    contentID.removeChild(document.getElementById('strText'+intTextBox));
    intTextBox = intTextBox-1;
}
</script>
<body>
<%String u = (String) request.getSession().getAttribute("user");
    if (u != null ) {
   // System.out.println("user != null");
    //out.print("Welcome "+u);
    }else{
   // System.out.println("user == null");
    response.sendRedirect("logout.jsp");
    }%>
<div id=na><%=session.getAttribute("mail")%>|<a id="indiv" href='ApiDoc.jsp'>API Documentation</a>&nbsp;|&nbsp;<a id='indiv' href = 'mobile_client.jsp'> API Console </a>&nbsp;|&nbsp;<a id='indiv' href='<%=request.getContextPath()%>/ApiPulpy'>API Usage</a>|<a id='indiv' href='logout.jsp'> Sign Out </a></div>
<div id="head"><center>Mind Pulpy<center></center></div><br><br>
<form action="SecondConfig" method="post">
<center><div class='heading'>Second Step Configuration</div></center>
<br><br><input type="text" name="securl" value="" placeholder="Second_End_Point_Url*"><br><br>
<div id="inline_content">
<input type="radio" name="cycle"  value="flow">
<label for="rd1">Flow Based</label>
<input type="radio" name="cycle"   value="entity">
<label for="rd1">Entity Based</label>
</div><br><br>

<div id="ent" style="display:none">
<input type="text" name="alabel" value="" placeholder="Key_Label">
<input type="text" name="akey" value="" placeholder="Key_value">
<div id='note'>Note:Re-enter API key or token again, or can also enter different key or token including No-Authentication,If avail</div></center>

</div><br>

<div id="flo" style="display:none">
<input type="text" name="sec1" value="" placeholder="Flow_Id_Label">
<input type="text" name="sec2" value="" placeholder="Flow_Id_value">
<div id='not'>Note:To complete whole cycle,connect with unique ID</div></div>

<div class="resformat"><center>Response Format</center></div><br>
<select name="select3" id="select3">
     <option value="XML">XML</option>
     <option value="JSON">JSON</option>
     <option value="XML-RPC">XML-RPC</option>
    <option value="SOAP">SOAP</option>
</select> <br><br><br>
<a id='pa' href="javascript:addParent();">Add Params</a>&nbsp;&nbsp;<a id='pa' href="javascript:removeParent();">Remove Params</a><br><br>
<div id="content"></div><br><br>
<input type="submit" name="submit" value="Continue"></form>
</body>
</html>