<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MindPulpy</title>
<style>
body{background-color:#FF9900;}
.head{
color:#FFFFFF;
    font-family:verdana;
    font-size:40px;
    margin-top:20px;
}
.main{
color:#FFFFFF;
    font-family:verdana;
    font-size:30px;
    margin-top:50px;
}
.result{
color:#FFFFFF;
    font-family:verdana;
    font-size:10px;
    margin-top:60px;
}
th,td
{
padding:15px;
text-align:left;
}
</style>
</head>
<body>
<%request.getSession().setAttribute("user", null);%>
<center><div class="head">Mind Pulpy</div></center>
<center><div class="main">Configuration completed! Check With Mobile App</div></center><br><br>
<table align='center' bgcolor='white' border='none' bordercolor='#000000' width=100>
<tr>
<th>Your_App_ID</th>
<th>:<%=request.getAttribute("id")%></th>
</tr><tr><td>App_Name</td>
<td>:<%=session.getAttribute("appname")%></td>
</tr><tr><td>Auth_Type</td>
<td>:<%=session.getAttribute("authtype")%></td>
</tr><tr><td>Api_Name</td>
<td>:<%=session.getAttribute("apiname")%></td>
</tr><tr><td>Api_Key</td>
<td>:<%=session.getAttribute("apikey")%></td>
</tr><tr><td>Request_Method</td>
<td>:<%=session.getAttribute("reqmeth")%></td>
</tr><tr><td>Response_Type</td>
<td>:<%=session.getAttribute("resfor")%></td>
</tr><tr><td>End_point_url</td>
<td>:<%=session.getAttribute("endurl")%></td>
</tr><tr><td>Param_1_label</td>
<td>:<%=session.getAttribute("p1")%></td>
</tr><tr><td>Param_1_value</td>
<td>:<%=session.getAttribute("pv1")%></td></tr>
<tr><td>Parent_tag</td>
<td>:<%=session.getAttribute("partag")%></td></tr>
<tr><td>xml_tag_1</td>
<td>:<%=session.getAttribute("xv1")%></td></tr>
</table>
</body>
</html>