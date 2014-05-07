<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="js/jquery-latest.js"></script>
	 <%response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Cache-Control", "no-store");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);%>
<script type="text/javascript">
var intTextBox=0;
function addParam(){
	intTextBox = intTextBox + 1;
	  var contentID = document.getElementById('content');
	  var newTBDiv = document.createElement('div');
	      newTBDiv.setAttribute('id','strText'+intTextBox);
	  newTBDiv.innerHTML = "<input type='text' id='x" + intTextBox + "'    name='x" + intTextBox + "' placeholder='Tag_Label'/>" + "<input type='text' id='xv"+ intTextBox + " ' name='xv"+intTextBox+"' placeholder='Tag_Value'/>";
	  contentID.appendChild(newTBDiv);
}
function removeParam()
{
	var contentID = document.getElementById('content');
    contentID.removeChild(document.getElementById('strText'+intTextBox));
    intTextBox = intTextBox-1;
	}
</script>
<style>
body{
background-color:#FF9900;}
.head{
    color:#FFFFFF;
    font-family:verdana;
    font-size:40px;
    margin-top:50px;}
  a{
  font-family:verdana;
  font-size:20px;
  color:#FFFFFF;
  margin-left:100px;
  
  }
  input[type="text"]{
color:#FF9900;
font-size:20px;
background-color:#FFFFFF;
margin-left:80px;
font-family:verdana;
width:250px;
height:20px;
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
input[type="button"]{
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

.heading{
font-family:verdana;
font-size: 20px;
font-weight:bold;
color:#FF9900;
width:25%;
height:30%;
background-color:#FFFFFF;
border:solid 2px;
border-color:#FF9900;
border-radius:25px;
padding:15px;
}
</style>

<script>
function validateform()
{
	var x1=document.forms["auth1"]["xr"].value;
	if(x1==null||x1=="")
		{
		alert("***please fill that parant tag***");
		return false;
		}
	var x2=document.forms["auth1"]["xrv"].value;
	if(x2=null||x2=="")
		{
		alert("***please fill the root tag**");
		return false;
		}
	}


</script>
</head>
<body>
 <%String u = (String) request.getSession().getAttribute("user");
    if (u != null ) {
   // System.out.println("user != null");
    out.print("Welcome "+u);
    }else{
   // System.out.println("user == null");
    response.sendRedirect("logout.jsp");
    }%>
<br><br><div class="head"><center>Mind Pulpy</center></h2></div><br><br>
<form name="auth1"action="AuthPulpy1" method="post" onsubmit="return validateform()">
<center><div class="heading">M-Pulpy XML Structure</div></center><br><br>
<center><TEXTAREA  NAME=SpecialRequest ROWS=30 COLS=70 readonly>"${PassingObj}"</TEXTAREA></center><br><br>
<center><div="text"></div><input type="text" name="xr" value="" placeholder="Parent_Tag">
<input type="text" name="xrv" value="" placeholder="Root_Tag"></div></center>
<br><br><center><div class="href"></div><a href="javascript:addParam()">Add_XML_Tags</a>
<a href="javascript:removeParam()">Remove_XML_Tags</a><div></center></div><br><br>
<br><center><div id="content"></div></center><br><br>
<center><div id="but"><input type="submit" value="Continue" name="submit"></div></center>
<center><input type='button' value='log out' onClick="javascript:location.href = 'logout.jsp'"/></center>

</form>
</body>
</html>