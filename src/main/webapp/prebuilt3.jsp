<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<style>
body{
background-color:#FF9900;}
.head{
    color:#FFFFFF;
    font-family:verdana;
    font-size:40px;}
    
label{
font-family:verdana;
font-weight:bold;
font-size: 20px;
color:#ffffff;
width:200px;
margin-left:200px;
}
 .au2{
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
	font-family:verdana;
	width:140px;
	height:50px;
	border:solid 2px;
	border-color:#FFFFFF;
	border-radius:50px;
	padding:10px;
	}
 .Param{
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
font-family:verdana;
height:25px;
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
margin-left:200px;
border-spacing:20px;

}

#name{
font-size:15px;
color:#FFFFFF;
font-family:verdana;
margin-left:80px;
}

#api{
font-size:15px;
color:#FFFFFF;
font-family:verdana;
margin-left:80px;
}
a{color:#FFFFFF;}
.au1{
font-family:verdana;
font-weight:bold;
font-size: 20px;
color:#FF9900;
width:23%;
height:30%;
margin-left:80px;
background-color:#FFFFFF;
border-radius:50px;
padding:15px;}

#indiv{color:#FFFFFF;
}
#na{
margin-top:0;
color:#FFFFFF;
font-size:15px;
font-family:verdana;
text-align:right;}

#re{
color:#FFFFFF;
font-size:15px;
font-family:verdana;
}
</style>
</head>

<body><form>
<div id=na><%=session.getAttribute("mail")%> &nbsp;|<a id="indiv" href='ApiDoc.jsp'>API Documentation</a>&nbsp;||&nbsp;<a id='indiv' href = 'logout.jsp'> Sign Out </a></div>
<br><br><div class="head"><center>Mind Pulpy</center></div><br><br>
<div class="au2"><center>PreBuild API's</center></div><br><br>
<%@page import="com.mindots.util.Utils"%>
<%@page import=" java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%
response.setHeader("Content-Type","text/html;charset=UTF-8");%>
<%
try{
Class.forName("com.mysql.jdbc.Driver");
Connection cn=DriverManager.getConnection("jdbc:mysql://127.6.250.130:3306/mpulpy","adminPQ1iFfN","J5JhBL-XC9NG");
//Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/mpulpy","root","root");
String name=request.getParameter("name");
PreparedStatement st2=cn.prepareStatement("SELECT * FROM  thirdconfig  WHERE appid=?");
st2.setString(1,"MPAPP_0507");
ResultSet rs2 = st2.executeQuery();
HttpSession session1=request.getSession(true);
while(rs2.next()){
	   String a1=rs2.getString("alabel"); String a2=rs2.getString("akey");
	   String endurl=rs2.getString("thrdurl");
	   String cycle=rs2.getString("thrdcycle");
      String ta1=rs2.getString("t1"); String sva1=rs2.getString("tv1");
      String ta2=rs2.getString("t2"); String sva2=rs2.getString("tv2");
      String ta3=rs2.getString("t3"); String sva3=rs2.getString("tv3");
      String ta4=rs2.getString("t4"); String sva4=rs2.getString("tv4");
      String ta5=rs2.getString("t5"); String sva5=rs2.getString("tv5");
      String ta6=rs2.getString("t6"); String sva6=rs2.getString("tv6");
      String ta7=rs2.getString("t7"); String sva7=rs2.getString("tv7");
      String ta8=rs2.getString("t8"); String sva8=rs2.getString("tv8");
      String ta9=rs2.getString("t9"); String sva9=rs2.getString("tv9");
      String ta10=rs2.getString("t10"); String sva10=rs2.getString("tv10");
     // String  rmethod=rs2.getString("rm");
      String  rf=rs2.getString("resf3");
      session1.setAttribute("a1",a1);session1.setAttribute("cycle",cycle);
      session1.setAttribute("ta1",ta1); session1.setAttribute("ta2",ta2);session1.setAttribute("ta3",ta3);
      session1.setAttribute("ta4",ta4);session1.setAttribute("ta5",ta5);session1.setAttribute("ta6",ta6);
      session1.setAttribute("ta7",ta7);session1.setAttribute("ta8",ta8);session1.setAttribute("ta9",ta9);
      session1.setAttribute("ta10",ta10);
%>
<table color='#FFFFFF' height=100%>
<%if(!a2.equals("")){%><tr><td>API Key</label></td><td><input type='text' name='a2' value='<%=a2%>' placeholder='Enter your API_KEY here' style='width:350px;'required></td></tr><%} %>
<tr><td>Request Method</td><td><input  type="text" name="rfdd" id="rf" value="Get" placeholder="Request Method"></td></tr>
<tr><td>Response Format</td><td><input type="text" name="rf" id="rm" value="<%=rf%>" placeholder="Response Format"></td></tr>
<tr><td>End Point URL</td><td><input  type="text" name="thrdurl" id="endurl" value="<%=endurl %>" placeholder="End_Point_URL" style="width:600px;"></td></tr><br>
</table>
<div class="Param"><center>Parameters</center></div><br>
<table color='#FFFFFF' height=100%>
<tr><th>Parameter_name</th><th>Example_Value</th><th>Scope</th></tr>
    <%if(!ta1.equals("null")){%><tr><td><%=rs2.getString("t1") %></td><td><%=rs2.getString("tv1") %></td><td><input  type="text" value="<%=rs2.getString("tv1") %>" name="p1" placeholder="value"></td></tr>
	<%}if(!ta2.equals("null")){%><tr><td><%=rs2.getString("t2") %></td><td><%=rs2.getString("tv2") %></td><td><input type="text" value="<%=rs2.getString("tv2") %>"  name="p2" placeholder="value"></td></tr>
	<%}if(!ta3.equals("null")){%><tr><td><%=rs2.getString("t3") %></td><td><%=rs2.getString("tv3") %></td><td><input type="text" value="<%=rs2.getString("tv3") %>" name="p3" placeholder="value"></td></tr>
	<%}if(!ta4.equals("null")){%><tr><td><%=rs2.getString("t4") %></td><td><%=rs2.getString("tv4") %></td><td><input type="text" value="<%=rs2.getString("tv4") %>"  name="p4" placeholder="value"></td></tr>
	<%}if(!ta5.equals("null")){%><tr><td><%=rs2.getString("t5") %></td><td><%=rs2.getString("tv5") %></td><td><input type="text" name="p5" placeholder="value"></td></tr>
	<%}if(!ta6.equals("null")){%><tr><td><%=rs2.getString("t6") %></td><td><%=rs2.getString("tv6") %></td><td><input type="text" name="p6" placeholder="value"></td></tr>
	<%}if(!ta7.equals("null")){%><tr><td><%=rs2.getString("t7") %></td><td><%=rs2.getString("tv7") %></td><td><input type="text"  name="p7" placeholder="value"></td></tr>
	<%}if(!ta8.equals("null")){%><tr><td><%=rs2.getString("t8") %></td><td><%=rs2.getString("tv8") %></td><td><input type="text"  name="p8" placeholder="value"></td></tr>
	<%}if(!ta9.equals("null")){%><tr><td><%=rs2.getString("t9") %></td><td><%=rs2.getString("tv9") %></td><td><input type="text"  name="p9" placeholder="value"></td></tr>
	<%}if(!ta10.equals("null")){%><tr><td><%=rs2.getString("t10") %></td><td><%=rs2.getString("tv10") %></td><td><input type="text"  name="p10" placeholder="value"></td></tr>
	<% }
%>
</table><br><br>
<center><input type="submit" name="submit" value="Continue" formAction="PreThrdPulpy" formmethod="post"></center>

</form>
<% 
}
}
catch(Exception e){
	out.println(e);
}
%>

</body>
</html>
