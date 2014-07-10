<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
var intTextBox=2;
function addParam(){
	intTextBox = intTextBox + 1;
	  var contentID = document.getElementById('content');
	  var newTBDiv = document.createElement('div');
	      newTBDiv.setAttribute('id','strText'+intTextBox);
	  newTBDiv.innerHTML = "<input type='text' id='sx" + intTextBox + "'    name='sx" + intTextBox + "' placeholder='Tag_Label'/>"+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+"<input type='text' id='sxv"+ intTextBox + " ' name='sxv"+intTextBox+"' placeholder='Tag_Value'/>";
	  contentID.appendChild(newTBDiv);
}
function removeParam()
{
	var contentID = document.getElementById('content');
    contentID.removeChild(document.getElementById('strText'+intTextBox));
    intTextBox = intTextBox-1;
	}
	
	function load(){
	window.open("<%=request.getContextPath()%>/XmlConvert", "tese", "toolbar=no, menubar=no,location=no, directories=no, status=no, scrollbars=yes, resizable=yes, top=500, left=500, width=400, height=400");
	
	
}
</script>
<style>
body{
background-color:#FF9900;}
.head{
    color:#FFFFFF;
    font-family:verdana;
    font-size:40px;}
    #pa1{
    font-family:verdana;
   font-size: 20px;
   margin-left:200px;
   color:#FFFFFF;
   
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
    .au{
font-family:verdana;
font-weight:bold;
font-size: 20px;
color:#FF9900;
margin-left:500px;
width:23%;
height:30%;
background-color:#FFFFFF;
border-radius:50px;
padding:15px;
}
input[type="submit"]{
	color:#FFFFFF;
	font-size:20px;
	background-color:#FF9900;
	margin-left:500px;
	font-family:verdana;
	width:140px;
	height:50px;
	border:solid 2px;
	border-color:#FFFFFF;
	border-radius:50px;
	padding:10px;
	}
 .param{
 font-family:verdana;
font-weight:bold;
font-size: 20px;
color:#FF9900;
margin-left:500px;
width:23%;
height:30%;
background-color:#FFFFFF;
border-radius:50px;
padding:15px;
 }
input[type="text"]{
color:#FF9900;
font-size:20px;
background-color:#FFFFFF;
margin-left:80px;
font-family:verdana;
height:20px;
padding:10px;
}
select{color:#FF9900;
font-size:20px;
background-color:#FFFFFF;
margin-left:80px;
font-family:verdana;
width:300px;
height:50px;
padding:10px;}

table{
font-size:20px;
font-family:verdana;
border-color:#FFFFFF;
color:#FFFFFF;
margin-left:80px;
border-spacing:20px;

}
#pa{
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
#content{margin-left:100px;}
</style>
</head>
<body>

<div id=na><%=session.getAttribute("mail")%> &nbsp;|<a id="indiv" href='ApiDoc.jsp'>API Documentation</a>&nbsp;|&nbsp;&nbsp;<a id='indiv' href = 'mobile_client.jsp'> API Console </a>&nbsp;|&nbsp;<a id='indiv' href='<%=request.getContextPath()%>/ApiPulpy'>API Usage</a>&nbsp;|&nbsp;<a id='indiv' href = 'logout.jsp'> Sign Out </a></div>
<form action="PreSecXmlPulpy" method="post">
<br><br>
<div class="au"><center>Second XML PreBuild API's</center></div><br><br>
<center><h2><a id='pa' href="javascript:load()">Click Here to view Xml</a></h2></center><%@page import="com.mindots.util.Utils"%>
<%@page import=" java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%
response.setHeader("Content-Type","text/html;charset=UTF-8");%>
<%
try{
	HttpSession session1=request.getSession(true);
    String appid=(String)session1.getAttribute("appid");
    String id=(String)session1.getAttribute("id");

    session1.setAttribute("appid",appid);
    session1.setAttribute("id",id);

Class.forName("com.mysql.jdbc.Driver");
//Connection cn=DriverManager.getConnection("jdbc:mysql://127.6.250.130:3306/mpulpy","adminPQ1iFfN","J5JhBL-XC9NG");
Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/mpulpy","root","root");
PreparedStatement st2=cn.prepareStatement("SELECT * FROM secxmlconfig WHERE appid=?");
st2.setString(1,"MPAPP_0507");
ResultSet rs2 = st2.executeQuery();
while(rs2.next()){
String appsam=rs2.getString("appid");
String secroot=rs2.getString("secroot"); String secparent=rs2.getString("secparent");
String sx1=rs2.getString("sx1");String sxv1=rs2.getString("sxv1");
String sx2=rs2.getString("sx2");String sxv2=rs2.getString("sxv2");
%>

<table><tr><td><input type='text' name='sxrv' value='' placeholder='Parent_Tag' style='width:300px; '></td><td><div class='pa'>Example:"<%=secroot %>"</div></td></tr><br>

<%if(!"null".equals(sx1)) {%>
	
	<tr><td><input type='text' name='sx1' value="<%=sx1 %>" placeholder='Tag_Label' style='height:20px;'></td><td><input type='text' name='sxv1' value='' placeholder='Tag_Value' style='height:15px;'></td><td><div class='pa'>Example:"<%=sxv1 %>"</div></td></tr><br>
	<%}
	if(!"null".equals(sx2)){%>
	<tr><td><input type='text' name='sx2' value="<%=sx2 %>" placeholder='Tag_Label' style='height:20px;'></td><td><input type='text' name='sxv2' value='' placeholder='Tag_Value' style='height:15px;'></td><td><div class='pa'>Example:"<%=sxv2%>"</div></td></tr><br>
	<%}
%>
</table>

<% }
}
catch(Exception e){}
%>
<br><a id='pa1' href="javascript:addParam()">Add_XML_Tags</a>
<a id='pa1' href="javascript:removeParam()">Remove_XML_Tags</a><div></center></div>
<br><div id="content"></div> 
<br><br>
<input type='submit' name='submit' value='Continue'>
</form>

</body>
</html>