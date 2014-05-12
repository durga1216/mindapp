<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
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
padding:7px;
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
<th>:<%=request.getAttribute("appid")%></th>
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
<td>:<%=session.getAttribute("endurl")%></td></tr>

<c:if test="${sessionScope.p1!=null}">
<tr><td>Param_1_label</td>
<td><%=session.getAttribute("p1")%></td>
</tr><tr><td>Param_1_value</td>
<td>:<%=session.getAttribute("pv1")%></td>
</tr></c:if>
<c:if test="${sessionScope.p2!=null}">
<tr><td>Param_2_label</td>
<td><%=session.getAttribute("p2")%></td>
</tr><tr><td>Param_2_value</td>
<td>:<%=session.getAttribute("pv2")%></td>
</tr></c:if>
<c:if test="${sessionScope.p3!=null}">
<tr><td>Param_3_label</td>
<td><%=session.getAttribute("p3")%></td>
</tr><tr><td>Param_3_value</td>
<td>:<%=session.getAttribute("pv3")%></td>
</tr></c:if>
<c:if test="${sessionScope.p4!=null}">
<tr><td>Param_4_label</td>
<td><%=session.getAttribute("p4")%></td>
</tr><tr><td>Param_4_value</td>
<td>:<%=session.getAttribute("pv4")%></td>
</tr></c:if>
<c:if test="${sessionScope.p5!=null}">
<tr><td>Param_5_label</td>
<td><%=session.getAttribute("p5")%></td>
</tr><tr><td>Param_5_value</td>
<td>:<%=session.getAttribute("pv5")%></td>
</tr></c:if>
<c:if test="${sessionScope.p6!=null}">
<tr><td>Param_6_label</td>
<td><%=session.getAttribute("p6")%></td>
</tr><tr><td>Param_6_value</td>
<td>:<%=session.getAttribute("pv6")%></td>
</tr></c:if>
<c:if test="${sessionScope.p7!=null}">
<tr><td>Param_7_label</td>
<td><%=session.getAttribute("p7")%></td>
</tr><tr><td>Param_7_value</td>
<td>:<%=session.getAttribute("pv7")%></td>
</tr></c:if>
<c:if test="${sessionScope.p8!=null}">
<tr><td>Param_8_label</td>
<td><%=session.getAttribute("p8")%></td>
</tr><tr><td>Param_8_value</td>
<td>:<%=session.getAttribute("pv8")%></td>
</tr></c:if>
<tr><td>Parent_tag</td>
<td>:<%=session.getAttribute("partag")%></td></tr>
<c:if test="${sessionScope.x1!=null}">
<tr><td>xml_1_label</td>
<td><%=session.getAttribute("x1")%></td>
</tr><tr><td>Param_1_value</td>
<td>:<%=session.getAttribute("xv1")%></td>
</tr></c:if>
<c:if test="${sessionScope.x2!=null}">
<tr><td>xml_2_label</td>
<td><%=session.getAttribute("x2")%></td>
</tr><tr><td>Param_2_value</td>
<td>:<%=session.getAttribute("xv2")%></td>
</tr></c:if>
<c:if test="${sessionScope.x3!=null}">
<tr><td>xml_3_label</td>
<td><%=session.getAttribute("x3")%></td>
</tr><tr><td>xml_3_value</td>
<td>:<%=session.getAttribute("xv3")%></td>
</tr></c:if>
<c:if test="${sessionScope.x4!=null}">
<tr><td>xml_4_label</td>
<td><%=session.getAttribute("x4")%></td>
</tr><tr><td>xml_4_value</td>
<td>:<%=session.getAttribute("xv4")%></td>
</tr></c:if>
<c:if test="${sessionScope.x5!=null}">
<tr><td>xml_5_label</td>
<td><%=session.getAttribute("x5")%></td>
</tr><tr><td>xml_5_value</td>
<td>:<%=session.getAttribute("xv5")%></td>
</tr></c:if>
<c:if test="${sessionScope.x6!=null}">
<tr><td>xml_6_label</td>
<td><%=session.getAttribute("x6")%></td>
</tr><tr><td>xml_6_value</td>
<td>:<%=session.getAttribute("xv6")%></td>
</tr></c:if>
<c:if test="${sessionScope.x7!=null}">
<tr><td>xml_7_label</td>
<td><%=session.getAttribute("x7")%></td>
</tr><tr><td>xml_7_value</td>
<td>:<%=session.getAttribute("xv7")%></td>
</tr></c:if>
<c:if test="${sessionScope.x8!=null}">
<tr><td>xml_8_label</td>
<td><%=session.getAttribute("x8")%></td>
</tr><tr><td>xml_8_value</td>
<td>:<%=session.getAttribute("xv8")%></td>
</tr></c:if>
<c:if test="${sessionScope.x9!=null}">
<tr><td>xml_9_label</td>
<td><%=session.getAttribute("x9")%></td>
</tr><tr><td>xml_9_value</td>
<td>:<%=session.getAttribute("xv9")%></td>
</tr></c:if>
<c:if test="${sessionScope.x10!=null}">
<tr><td>xml_10_label</td>
<td><%=session.getAttribute("x10")%></td>
</tr><tr><td>xml_10_value</td>
<td>:<%=session.getAttribute("xv10")%></td>
</tr></c:if>

</table>
</body>
</html>