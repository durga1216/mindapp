<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
body{background-color:#FF9900;}
.head{
color:#FFFFFF;
    font-family:verdana;
    font-size:40px;}
input[type="text"]{
color:#FF9900;
font-size:17px;
background-color:#FFFFFF;
font-family:verdana;
width:200px;
height:15px;
padding:5px;
} 
input[type="submit"]{

color:#FFFFFF;
font-size:15px;
background-color:#FF9900;
font-family:verdana;
width:140px;
height:50px;
border:solid 2px;
border-color:#FFFFFF;
border-radius:50px;
}
.main{
color:#FFFFFF;
    font-family:verdana;
    font-size:27px;
}
.result{
color:#FFFFFF;
    font-family:verdana;
    font-size:10px;
    margin-top:60px;
}
#na{
margin-top:0;
color:#FFFFFF;
font-size:18px;
font-family:verdana;
text-align:right;}
th,td
{
padding:7px;
text-align:left;
color:#FF9900;
font-weight:bold;
}
a{ 
padding:5px;
font-size:20px;
background-color:#ffffff;
color:#ff9900;
border:solid 1px #ccc;
border-radius:10px;
text-decoration:none;
}
sup { vertical-align: 3.5ex; 
padding:2px;
font-size:15px;
background-color:blue;
color:#ffffff;
box-shadow:2px 2px 5px 1px #000;
border-radius:5px;}
</style>
<script type="text/javascript">
function load2(){
	window.open("https://mindtools-inputs.rhcloud.com/index.jsp", '_blank');
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
    <br>
<div id=na><a href='logsucess.jsp'>Home</a>&nbsp;&nbsp;<a id="indiv" href='mobile_client.jsp'>API Console</a><sup>Check Result.!</sup>&nbsp;&nbsp;&nbsp;<a id="indiv" href='ApiDoc.jsp'>API Documentation</a>&nbsp;&nbsp;<a id="indiv" href='javascript:load2()'>Apps Builder</a><sup>Try it.!</sup>&nbsp;&nbsp;&nbsp;<a id="indiv" href= 'logout.jsp'> Sign Out </a></div>
<br><hr><form action="Edit" method="post"><br>
<center><div class="main">Configuration completed..! &nbsp; Your App_Id :   <%=session.getAttribute("appid")%></div></center><br>
<c:if test="${sessionScope.appid!=null}">
<center><h2 style='color:#ffffff;font-family:verdana;'>You Can Also Edit Here</h2></center>
<center><h2 style='color:#ffffff;font-family:verdana;'>First Configuration Details</h2></center>
<table align='center' bgcolor='white' border='0' bordercolor='#000000' style='width:700px;'>
<tr>
<th>Your_App_ID</th>
<th>: <input type="text"  name="id" value= <%=session.getAttribute("appid")%> readonly></th>
</tr><tr><td>App_Name</td>
<td>: <%=session.getAttribute("appname")%></td></tr>
<tr><td>Auth_Type</td>
<td>: <%=session.getAttribute("authtype")%></td></tr>
<c:if test="${sessionScope.authtype=='API keys'}">
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
<td>: <input type="text"  name="p1" value= <%=session.getAttribute("p1")%>></td>
</tr><tr><td>Param_1_value</td>
<td>: <input type="text"  name="pv1" value= <%=session.getAttribute("pv1")%>></td>
</tr></c:if>
<c:if test="${sessionScope.p2!=null}">
<tr><td>Param_2_label</td>
<td>: <input type="text"  name="p2" value= <%=session.getAttribute("p2")%>></td>
</tr><tr><td>Param_2_value</td>
<td>: <input type="text"  name="pv2" value= <%=session.getAttribute("pv2")%>></td>
</tr></c:if>
<c:if test="${sessionScope.p3!=null}">
<tr><td>Param_3_label</td>
<td>: <input type="text"  name="p3" value= <%=session.getAttribute("p3")%>></td>
</tr><tr><td>Param_3_value</td>
<td>: <input type="text"  name="pv3" value= <%=session.getAttribute("pv3")%>></td>
</tr></c:if>
<c:if test="${sessionScope.p4!=null}">
<tr><td>Param_4_label</td>
<td>: <input type="text"  name="p4" value= <%=session.getAttribute("p4")%>></td>
</tr><tr><td>Param_4_value</td>
<td>: <input type="text"  name="pv4" value= <%=session.getAttribute("pv4")%>></td>
</tr></c:if>
<c:if test="${sessionScope.p5!=null}">
<tr><td>Param_5_label</td>
<td>: <input type="text"  name="p5" value= <%=session.getAttribute("p5")%>></td>
</tr><tr><td>Param_5_value</td>
<td>: <input type="text"  name="pv5" value= <%=session.getAttribute("pv5")%>></td>
</tr></c:if>
<c:if test="${sessionScope.p6!=null}">
<tr><td>Param_6_label</td>
<td>: <input type="text"  name="p6" value= <%=session.getAttribute("p6")%>></td>
</tr><tr><td>Param_6_value</td>
<td>: <input type="text"  name="pv6" value= <%=session.getAttribute("pv6")%>></td>
</tr></c:if>
<c:if test="${sessionScope.p7!=null}">
<tr><td>Param_7_label</td>
<td>: <input type="text"  name="p7" value= <%=session.getAttribute("p7")%>></td>
</tr><tr><td>Param_7_value</td>
<td>: <input type="text"  name="pv7" value= <%=session.getAttribute("pv7")%>></td>
</tr></c:if>
<c:if test="${sessionScope.p8!=null}">
<tr><td>Param_8_label</td>
<td>: <input type="text"  name="p8" value= <%=session.getAttribute("p8")%>></td>
</tr><tr><td>Param_8_value</td>
<td>: <input type="text"  name="pv8" value= <%=session.getAttribute("pv8")%>></td>
</tr></c:if>
<tr><td>Parent_tag</td>
<td>: <input type="text"  name="partag" value= <%=session.getAttribute("partag")%>></td></tr>
<c:if test="${sessionScope.x1!=null}">
<tr><td>xml_1_label</td>
<td>: <input type="text"  name="x1" value= <%=session.getAttribute("x1")%>></td>
</tr><tr><td>Param_1_value</td>
<td>: <input type="text"  name="xv1" value= <%=session.getAttribute("xv1")%>></td>
</tr></c:if>
<c:if test="${sessionScope.x2!=null}">
<tr><td>xml_2_label</td>
<td>: <input type="text"  name="x2" value= <%=session.getAttribute("x2")%>></td>
</tr><tr><td>Param_2_value</td>
<td>: <input type="text"  name="xv2" value= <%=session.getAttribute("xv2")%>></td>
</tr></c:if>
<c:if test="${sessionScope.x3!=null}">
<tr><td>xml_3_label</td>
<td>: <input type="text"  name="x3" value= <%=session.getAttribute("x3")%>></td>
</tr><tr><td>xml_3_value</td>
<td>: <input type="text"  name="xv3" value= <%=session.getAttribute("xv3")%>></td>
</tr></c:if>
<c:if test="${sessionScope.x4!=null}">
<tr><td>xml_4_label</td>
<td>: <input type="text"  name="x4" value= <%=session.getAttribute("x4")%>></td>
</tr><tr><td>xml_4_value</td>
<td>: <input type="text"  name="xv4" value= <%=session.getAttribute("xv4")%>></td>
</tr></c:if>
<c:if test="${sessionScope.x5!=null}">
<tr><td>xml_5_label</td>
<td>: <input type="text"  name="x5" value= <%=session.getAttribute("x5")%>></td>
</tr><tr><td>xml_5_value</td>
<td>: <input type="text"  name="xv5" value= <%=session.getAttribute("xv5")%>></td>
</tr></c:if>
<c:if test="${sessionScope.x6!=null}">
<tr><td>xml_6_label</td>
<td>: <input type="text"  name="x6" value= <%=session.getAttribute("x6")%>></td>
</tr><tr><td>xml_6_value</td>
<td>: <input type="text"  name="xv6" value= <%=session.getAttribute("xv6")%>></td>
</tr></c:if>
<c:if test="${sessionScope.x7!=null}">
<tr><td>xml_7_label</td>
<td>: <input type="text"  name="x7" value= <%=session.getAttribute("x7")%>></td>
</tr><tr><td>xml_7_value</td>
<td>: <input type="text"  name="xv7" value= <%=session.getAttribute("xv7")%>></td>
</tr></c:if>
<c:if test="${sessionScope.x8!=null}">
<tr><td>xml_8_label</td>
<td>: <input type="text"  name="x8" value= <%=session.getAttribute("x8")%>></td>
</tr><tr><td>xml_8_value</td>
<td>: <input type="text"  name="xv8" value= <%=session.getAttribute("xv8")%>></td>
</tr></c:if>
<c:if test="${sessionScope.x9!=null}">
<tr><td>xml_9_label</td>
<td>: <input type="text"  name="x9" value= <%=session.getAttribute("x9")%>></td>
</tr><tr><td>xml_9_value</td>
<td>: <input type="text"  name="xv9" value= <%=session.getAttribute("xv9")%>></td>
</tr></c:if>
<c:if test="${sessionScope.x10!=null}">
<tr><td>xml_10_label</td>
<td>: <input type="text"  name="x10" value= <%=session.getAttribute("x10")%>></td>
</tr><tr><td>xml_10_value</td>
<td>: <input type="text"  name="xv10" value= <%=session.getAttribute("xv10")%>></td>
</tr></c:if>
</table>

<c:if test="${sessionScope.securl!=null}">
<center><h2 style='color:#ffffff'>Second Configuration Details</h2></center>
<table align='center' bgcolor='white' border='0' bordercolor='#000000' style='width:700px;'>
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
<center><h2 style='color:#ffffff'>Third Configuration Details</h2></center>
<table align='center' bgcolor='white' border='0' bordercolor='#000000' style='width:700px;'>
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
<br><br><br><center><input name="edt" type="submit" value="Done"></center>
</c:if>
</form>
</body>
</html>