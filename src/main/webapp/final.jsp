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
#indiv{color:#FFFFFF;
}
#na{
margin-top:0;
color:#FFFFFF;
font-size:15px;
font-family:verdana;
text-align:right;}
th,td
{
padding:7px;
text-align:left;
}
</style>
</head>
<body>
<%request.getSession().setAttribute("user", null);%>
<div id=na><a id="indiv" href= 'logout.jsp'> Sign Out </a></div>
<center><div class="head">Mind Pulpy</div></center>
<center><div class="main">Configuration completed! Check With Mobile App</div></center><br><br>
<center><h2>First Configuration Details</h2></center>
<table align='center' bgcolor='white' border='none' bordercolor='#000000' width=100>
<tr>
<th>Your_App_ID</th>
<th>: <%=request.getAttribute("appid")%></th>
</tr><tr><td>App_Name</td>
<td>: <%=session.getAttribute("appname")%></td></tr>
<tr><td>Auth_Type</td>
<td>: <%=session.getAttribute("authtype")%></td></tr>
<c:if test="${sessionScope.authtype=='apikey'}">
<tr><td>Api_Name</td>
<td>: <%=session.getAttribute("apiname")%></td></tr>
<tr><td>Api_Key</td>
<td>: <%=session.getAttribute("apikey")%></td></tr>
</c:if>

<c:if test="${sessionScope.authtype=='Oauth2'}">
<tr><td>Client_ID_KEY</td>
<td>: <%=session.getAttribute("ckey")%></td></tr>
<tr><td>Client_Secret_Key</td>
<td>: <%=session.getAttribute("cseckey")%></td></tr>
<tr><td>Authorization_URL</td>
<td>: <%=session.getAttribute("aurl")%></td></tr>
<tr><td>Access_Token_Label</td>
<td>: <%=session.getAttribute("tlabel")%></td></tr>
<tr><td>Access_Token_URL</td>
<td>: <%=session.getAttribute("tokenurl")%></td></tr>
</c:if>

<tr><td>Request_Method</td>
<td>: <%=session.getAttribute("reqmeth")%></td>
</tr><tr><td>Response_Type</td>
<td>: <%=session.getAttribute("resfor")%></td></tr>
<tr><td>End_point_url</td>
<td>: <%=session.getAttribute("endurl")%></td></tr>
<c:if test="${sessionScope.p1!=null}">
<tr><td>Param_1_label</td>
<td>: <%=session.getAttribute("p1")%></td>
</tr><tr><td>Param_1_value</td>
<td>: <%=session.getAttribute("pv1")%></td>
</tr></c:if>
<c:if test="${sessionScope.p2!=null}">
<tr><td>Param_2_label</td>
<td>: <%=session.getAttribute("p2")%></td>
</tr><tr><td>Param_2_value</td>
<td>: <%=session.getAttribute("pv2")%></td>
</tr></c:if>
<c:if test="${sessionScope.p3!=null}">
<tr><td>Param_3_label</td>
<td>: <%=session.getAttribute("p3")%></td>
</tr><tr><td>Param_3_value</td>
<td>: <%=session.getAttribute("pv3")%></td>
</tr></c:if>
<c:if test="${sessionScope.p4!=null}">
<tr><td>Param_4_label</td>
<td>: <%=session.getAttribute("p4")%></td>
</tr><tr><td>Param_4_value</td>
<td>: <%=session.getAttribute("pv4")%></td>
</tr></c:if>
<c:if test="${sessionScope.p5!=null}">
<tr><td>Param_5_label</td>
<td>: <%=session.getAttribute("p5")%></td>
</tr><tr><td>Param_5_value</td>
<td>: <%=session.getAttribute("pv5")%></td>
</tr></c:if>
<c:if test="${sessionScope.p6!=null}">
<tr><td>Param_6_label</td>
<td>: <%=session.getAttribute("p6")%></td>
</tr><tr><td>Param_6_value</td>
<td>: <%=session.getAttribute("pv6")%></td>
</tr></c:if>
<c:if test="${sessionScope.p7!=null}">
<tr><td>Param_7_label</td>
<td>: <%=session.getAttribute("p7")%></td>
</tr><tr><td>Param_7_value</td>
<td>: <%=session.getAttribute("pv7")%></td>
</tr></c:if>
<c:if test="${sessionScope.p8!=null}">
<tr><td>Param_8_label</td>
<td>: <%=session.getAttribute("p8")%></td>
</tr><tr><td>Param_8_value</td>
<td>: <%=session.getAttribute("pv8")%></td>
</tr></c:if>
<tr><td>Parent_tag</td>
<td>: <%=session.getAttribute("partag")%></td></tr>
<c:if test="${sessionScope.x1!=null}">
<tr><td>xml_1_label</td>
<td>: <%=session.getAttribute("x1")%></td>
</tr><tr><td>Param_1_value</td>
<td>: <%=session.getAttribute("xv1")%></td>
</tr></c:if>
<c:if test="${sessionScope.x2!=null}">
<tr><td>xml_2_label</td>
<td>: <%=session.getAttribute("x2")%></td>
</tr><tr><td>Param_2_value</td>
<td>: <%=session.getAttribute("xv2")%></td>
</tr></c:if>
<c:if test="${sessionScope.x3!=null}">
<tr><td>xml_3_label</td>
<td>: <%=session.getAttribute("x3")%></td>
</tr><tr><td>xml_3_value</td>
<td>: <%=session.getAttribute("xv3")%></td>
</tr></c:if>
<c:if test="${sessionScope.x4!=null}">
<tr><td>xml_4_label</td>
<td>: <%=session.getAttribute("x4")%></td>
</tr><tr><td>xml_4_value</td>
<td>: <%=session.getAttribute("xv4")%></td>
</tr></c:if>
<c:if test="${sessionScope.x5!=null}">
<tr><td>xml_5_label</td>
<td>: <%=session.getAttribute("x5")%></td>
</tr><tr><td>xml_5_value</td>
<td>: <%=session.getAttribute("xv5")%></td>
</tr></c:if>
<c:if test="${sessionScope.x6!=null}">
<tr><td>xml_6_label</td>
<td>: <%=session.getAttribute("x6")%></td>
</tr><tr><td>xml_6_value</td>
<td>: <%=session.getAttribute("xv6")%></td>
</tr></c:if>
<c:if test="${sessionScope.x7!=null}">
<tr><td>xml_7_label</td>
<td>: <%=session.getAttribute("x7")%></td>
</tr><tr><td>xml_7_value</td>
<td>: <%=session.getAttribute("xv7")%></td>
</tr></c:if>
<c:if test="${sessionScope.x8!=null}">
<tr><td>xml_8_label</td>
<td>: <%=session.getAttribute("x8")%></td>
</tr><tr><td>xml_8_value</td>
<td>: <%=session.getAttribute("xv8")%></td>
</tr></c:if>
<c:if test="${sessionScope.x9!=null}">
<tr><td>xml_9_label</td>
<td>: <%=session.getAttribute("x9")%></td>
</tr><tr><td>xml_9_value</td>
<td>: <%=session.getAttribute("xv9")%></td>
</tr></c:if>
<c:if test="${sessionScope.x10!=null}">
<tr><td>xml_10_label</td>
<td>: <%=session.getAttribute("x10")%></td>
</tr><tr><td>xml_10_value</td>
<td>: <%=session.getAttribute("xv10")%></td>
</tr></c:if>
</table>

<c:if test="${sessionScope.securl!=null}">
<center><h2>Second Configuration Details</h2></center>
<table align='center' bgcolor='white' border='none' bordercolor='#000000' width=100>
<tr><td>Sec_End_Url</td>
<td>: <%=session.getAttribute("securl")%></td></tr>
<tr><td>Cycle_Type</td>
<td>: <%=session.getAttribute("cycle")%></td></tr>
<tr><td>Sec_Api_Label</td>
<td>: <%=session.getAttribute("alabel")%></td></tr>
<tr><td>Sec_Api_Key</td>
<td>: <%=session.getAttribute("akey")%></td></tr>
<c:if test="${sessionScope.s1!=null}">
<tr><td>Param_1_label</td>
<td>: <%=session.getAttribute("s1")%></td>
</tr><tr><td>Param_1_value</td>
<td>: <%=session.getAttribute("sv1")%></td>
</tr></c:if>
<c:if test="${sessionScope.s2!=null}">
<tr><td>Param_2_label</td>
<td>: <%=session.getAttribute("s2")%></td>
</tr><tr><td>Param_2_value</td>
<td>: <%=session.getAttribute("sv2")%></td>
</tr></c:if>
<c:if test="${sessionScope.s3!=null}">
<tr><td>Param_3_label</td>
<td>: <%=session.getAttribute("s3")%></td>
</tr><tr><td>Param_3_value</td>
<td>: <%=session.getAttribute("sv3")%></td>
</tr></c:if>
<c:if test="${sessionScope.s4!=null}">
<tr><td>Param_4_label</td>
<td>: <%=session.getAttribute("s4")%></td>
</tr><tr><td>Param_4_value</td>
<td>: <%=session.getAttribute("sv4")%></td>
</tr></c:if>
<c:if test="${sessionScope.s5!=null}">
<tr><td>Param_5_label</td>
<td>: <%=session.getAttribute("s5")%></td>
</tr><tr><td>Param_5_value</td>
<td>: <%=session.getAttribute("sv5")%></td>
</tr></c:if>
<c:if test="${sessionScope.s6!=null}">
<tr><td>Param_6_label</td>
<td>: <%=session.getAttribute("s6")%></td>
</tr><tr><td>Param_6_value</td>
<td>: <%=session.getAttribute("sv6")%></td>
</tr></c:if>
<c:if test="${sessionScope.s7!=null}">
<tr><td>Param_7_label</td>
<td>: <%=session.getAttribute("s7")%></td>
</tr><tr><td>Param_7_value</td>
<td>: <%=session.getAttribute("sv7")%></td>
</tr></c:if>
<c:if test="${sessionScope.s8!=null}">
<tr><td>Param_8_label</td>
<td>: <%=session.getAttribute("s8")%></td>
</tr><tr><td>Param_8_value</td>
<td>: <%=session.getAttribute("sv8")%></td>
</tr></c:if>
<tr><td>Parent_tag</td>
<td>: <%=session.getAttribute("secparent")%></td></tr>
<c:if test="${sessionScope.sx1!=null}">
<tr><td>xml_1_label</td>
<td>: <%=session.getAttribute("sx1")%></td>
</tr><tr><td>Param_1_value</td>
<td>: <%=session.getAttribute("sxv1")%></td>
</tr></c:if>
<c:if test="${sessionScope.sx2!=null}">
<tr><td>xml_2_label</td>
<td>: <%=session.getAttribute("sx2")%></td>
</tr><tr><td>Param_2_value</td>
<td>: <%=session.getAttribute("sxv2")%></td>
</tr></c:if>
<c:if test="${sessionScope.sx3!=null}">
<tr><td>xml_3_label</td>
<td>: <%=session.getAttribute("sx3")%></td>
</tr><tr><td>xml_3_value</td>
<td>: <%=session.getAttribute("sxv3")%></td>
</tr></c:if>
<c:if test="${sessionScope.sx4!=null}">
<tr><td>xml_4_label</td>
<td>: <%=session.getAttribute("sx4")%></td>
</tr><tr><td>xml_4_value</td>
<td>: <%=session.getAttribute("sxv4")%></td>
</tr></c:if>
<c:if test="${sessionScope.sx5!=null}">
<tr><td>xml_5_label</td>
<td>: <%=session.getAttribute("sx5")%></td>
</tr><tr><td>xml_5_value</td>
<td>: <%=session.getAttribute("sxv5")%></td>
</tr></c:if>
<c:if test="${sessionScope.sx6!=null}">
<tr><td>xml_6_label</td>
<td>: <%=session.getAttribute("sx6")%></td>
</tr><tr><td>xml_6_value</td>
<td>: <%=session.getAttribute("sxv6")%></td>
</tr></c:if>
<c:if test="${sessionScope.sx7!=null}">
<tr><td>xml_7_label</td>
<td>: <%=session.getAttribute("sx7")%></td>
</tr><tr><td>xml_7_value</td>
<td>: <%=session.getAttribute("sxv7")%></td>
</tr></c:if>
<c:if test="${sessionScope.sx8!=null}">
<tr><td>xml_8_label</td>
<td>: <%=session.getAttribute("sx8")%></td>
</tr><tr><td>xml_8_value</td>
<td>: <%=session.getAttribute("sxv8")%></td>
</tr></c:if>
<c:if test="${sessionScope.sx9!=null}">
<tr><td>xml_9_label</td>
<td>: <%=session.getAttribute("sx9")%></td>
</tr><tr><td>xml_9_value</td>
<td>: <%=session.getAttribute("sxv9")%></td>
</tr></c:if>
<c:if test="${sessionScope.sx10!=null}">
<tr><td>xml_10_label</td>
<td>: <%=session.getAttribute("sx10")%></td>
</tr><tr><td>xml_10_value</td>
<td>: <%=session.getAttribute("sxv10")%></td>
</tr></c:if>
</table>
</c:if>


<c:if test="${sessionScope.thirdurl!=null}">
<center><h2>Third Configuration Details</h2></center>
<table align='center' bgcolor='white' border='none' bordercolor='#000000' width=100>
<tr><td>third_End_Url</td>
<td>: <%=session.getAttribute("thirdurl")%></td></tr>
<tr><td>Cycle_Type</td>
<td>: <%=session.getAttribute("thirdcycle")%></td></tr>
<tr><td>Third_Api_Label</td>
<td>: <%=session.getAttribute("a2label")%></td></tr>
<tr><td>Third_Api_Key</td>
<td>: <%=session.getAttribute("a2key")%></td></tr>
<c:if test="${sessionScope.t1!=null}">
<tr><td>Param_1_label</td>
<td>: <%=session.getAttribute("t1")%></td>
</tr><tr><td>Param_1_value</td>
<td>: <%=session.getAttribute("tv1")%></td>
</tr></c:if>
<c:if test="${sessionScope.t2!=null}">
<tr><td>Param_2_label</td>
<td>: <%=session.getAttribute("t2")%></td>
</tr><tr><td>Param_2_value</td>
<td>: <%=session.getAttribute("tv2")%></td>
</tr></c:if>
<c:if test="${sessionScope.t3!=null}">
<tr><td>Param_3_label</td>
<td>: <%=session.getAttribute("t3")%></td>
</tr><tr><td>Param_3_value</td>
<td>: <%=session.getAttribute("tv3")%></td>
</tr></c:if>
<c:if test="${sessionScope.t4!=null}">
<tr><td>Param_4_label</td>
<td>: <%=session.getAttribute("t4")%></td>
</tr><tr><td>Param_4_value</td>
<td>: <%=session.getAttribute("tv4")%></td>
</tr></c:if>
<c:if test="${sessionScope.t5!=null}">
<tr><td>Param_5_label</td>
<td>: <%=session.getAttribute("t5")%></td>
</tr><tr><td>Param_5_value</td>
<td>: <%=session.getAttribute("tv5")%></td>
</tr></c:if>
<c:if test="${sessionScope.t6!=null}">
<tr><td>Param_6_label</td>
<td>: <%=session.getAttribute("t6")%></td>
</tr><tr><td>Param_6_value</td>
<td>: <%=session.getAttribute("tv6")%></td>
</tr></c:if>
<c:if test="${sessionScope.t7!=null}">
<tr><td>Param_7_label</td>
<td>: <%=session.getAttribute("t7")%></td>
</tr><tr><td>Param_7_value</td>
<td>: <%=session.getAttribute("tv7")%></td>
</tr></c:if>
<c:if test="${sessionScope.t8!=null}">
<tr><td>Param_8_label</td>
<td>: <%=session.getAttribute("t8")%></td>
</tr><tr><td>Param_8_value</td>
<td>: <%=session.getAttribute("tv8")%></td>
</tr></c:if>
<tr><td>Parent_tag</td>
<td>: <%=session.getAttribute("thrdparent")%></td></tr>
<c:if test="${sessionScope.tx1!=null}">
<tr><td>xml_1_label</td>
<td>: <%=session.getAttribute("tx1")%></td>
</tr><tr><td>Param_1_value</td>
<td>: <%=session.getAttribute("txv1")%></td>
</tr></c:if>
<c:if test="${sessionScope.tx2!=null}">
<tr><td>xml_2_label</td>
<td>: <%=session.getAttribute("tx2")%></td>
</tr><tr><td>Param_2_value</td>
<td>: <%=session.getAttribute("txv2")%></td>
</tr></c:if>
<c:if test="${sessionScope.tx3!=null}">
<tr><td>xml_3_label</td>
<td>: <%=session.getAttribute("tx3")%></td>
</tr><tr><td>xml_3_value</td>
<td>: <%=session.getAttribute("txv3")%></td>
</tr></c:if>
<c:if test="${sessionScope.tx4!=null}">
<tr><td>xml_4_label</td>
<td>: <%=session.getAttribute("tx4")%></td>
</tr><tr><td>xml_4_value</td>
<td>: <%=session.getAttribute("txv4")%></td>
</tr></c:if>
<c:if test="${sessionScope.tx5!=null}">
<tr><td>xml_5_label</td>
<td>: <%=session.getAttribute("tx5")%></td>
</tr><tr><td>xml_5_value</td>
<td>: <%=session.getAttribute("txv5")%></td>
</tr></c:if>
<c:if test="${sessionScope.tx6!=null}">
<tr><td>xml_6_label</td>
<td>: <%=session.getAttribute("tx6")%></td>
</tr><tr><td>xml_6_value</td>
<td>: <%=session.getAttribute("txv6")%></td>
</tr></c:if>
<c:if test="${sessionScope.tx7!=null}">
<tr><td>xml_7_label</td>
<td>: <%=session.getAttribute("tx7")%></td>
</tr><tr><td>xml_7_value</td>
<td>: <%=session.getAttribute("txv7")%></td>
</tr></c:if>
<c:if test="${sessionScope.tx8!=null}">
<tr><td>xml_8_label</td>
<td>: <%=session.getAttribute("tx8")%></td>
</tr><tr><td>xml_8_value</td>
<td>: <%=session.getAttribute("txv8")%></td>
</tr></c:if>
<c:if test="${sessionScope.tx9!=null}">
<tr><td>xml_9_label</td>
<td>: <%=session.getAttribute("tx9")%></td>
</tr><tr><td>xml_9_value</td>
<td>: <%=session.getAttribute("txv9")%></td>
</tr></c:if>
<c:if test="${sessionScope.tx10!=null}">
<tr><td>xml_10_label</td>
<td>: <%=session.getAttribute("tx10")%></td>
</tr><tr><td>xml_10_value</td>
<td>: <%=session.getAttribute("txv10")%></td>
</tr></c:if>
</table>
</c:if>
</body>
</html>