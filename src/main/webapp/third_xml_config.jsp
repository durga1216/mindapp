<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MindPulpy</title>
<%response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Cache-Control", "no-store");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);%>
<link rel="shortcut icon" href="favicon.ico" />
	<script src="js/jquery-latest.js"></script>

<style>
body{
background-color:#FF9900;}
.head{
    color:#FFFFFF;
    font-family:verdana;
    font-size:40px;
    margin-top:50px;}
  #pa{
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
var intTextBox=0;
function addParam(){
	intTextBox = intTextBox + 1;
	  var contentID = document.getElementById('content');
	  var newTBDiv = document.createElement('div');
	      newTBDiv.setAttribute('id','strText'+intTextBox);
	  newTBDiv.innerHTML = "<input type='text' id='tx" + intTextBox + "'    name='tx" + intTextBox + "' placeholder='Tag_Label'/>" + "<input type='text' id='txv"+ intTextBox + " ' name='txv"+intTextBox+"' placeholder='Tag_Value'/>";
	  contentID.appendChild(newTBDiv);
}
function removeParam()
{
	var contentID = document.getElementById('content');
    contentID.removeChild(document.getElementById('strText'+intTextBox));
    intTextBox = intTextBox-1;
	}
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
<form action="ThirdXmlConfig" method="post">
<div id=na><%=session.getAttribute("mail")%> &nbsp;|<a id="indiv" href='<%=request.getContextPath()%>/ApiDoc1'>API Documentation</a>&nbsp;|&nbsp;&nbsp;<a id='indiv' href = 'mobile_client.jsp'> API Test </a>&nbsp;|&nbsp;<a id='indiv' href='<%=request.getContextPath()%>/ApiPulpy'>API Usage</a>&nbsp;|&nbsp;<a id='indiv' href='logout.jsp'> Sign Out </a></div>

<center><div class="head">Mind Pulpy</div></center><br><br>
<center><div class="heading">M-Pulpy XML Structure</div></center><br><br>
<center><h2><a id='pa' href="javascript:load()">Load_Xml</a></h2></center><br><br>
<center><div="text"></div><input type="text" name="thrdparent" value="" placeholder="Parent_Tag">
<input type="text" name="thrdroot" value="" placeholder="Root_Tag"></div></center>
<br><br><center><div class="href"></div><a id='pa' href="javascript:addParam()">Add_XML_Tags</a><a id='pa' href="javascript:removeParam()">Remove_XML_Tags</a><div></center></div><br><br>
<br><center><div id="content"></div></center><br><br>
<center><div id="but"><input type="submit" value="Continue" name="submit"></div></center>
</form>
<script type="text/javascript">
function load(){
	window.open("<%=request.getContextPath()%>/XmlConvert", "tese", "toolbar=no, menubar=no,location=no, directories=no, status=no, scrollbars=yes, resizable=yes, top=500, left=500, width=400, height=400");
	
	
}
</script>
</body>
</html>