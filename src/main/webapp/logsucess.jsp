<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mind Pulpy</title>
<script src="js/jquery-latest.js"></script>
<link rel="shortcut icon" href="favicon.ico" />
<style>
body{
background-color:#FF9900;
}
.head{
    color:#FFFFFF;
    font-family:verdana;
    font-size:40px;}
    h3{
    color:#FFFFFF;
    font-family:verdana;
    }
    .con{
    color:#FFFFFF;
    font-family:verdana;
    font-size:25px;
    }
    #pa{
    color:#FFFFFF;
    font-family:verdana;
    font-size:20px;
    }
    #indiv{color:#FFFFFF;
}
a{color:#FFFFFF;}
#na{
margin-top:0;
color:#FFFFFF;
font-size:15px;
font-family:verdana;
text-align:right;}
input[type="button"]{

color:#FFFFFF;
font-size:15px;
background-color:#FF9900;
margin-left:20px;
font-family:verdana;
width:120px;
height:40px;
border:solid 2px;
border-color:#FFFFFF;
border-radius:20px;
padding:10px;
}
#dis{
margin-left:15px;
color:#FFFFFF;
font-size:20px;
font-family:verdana;
text-align:left;}
</style>
<script type="text/javascript">
function load(){
	window.open("https://www.youtube.com/watch?v=lqkEmqNi_10&feature=youtu.be", '_blank');
	
}
</script>
</head>
<body>
<%String u = (String) request.getSession().getAttribute("user");
    if (u != null ) {
   // System.out.println("user != null");
   // out.print("Welcome "+u);
    }else{
   // System.out.println("user == null");
    response.sendRedirect("logout.jsp");
    }%>
<div id=na><%=session.getAttribute("mail")%> &nbsp;|&nbsp;<a id="indiv" href='ApiDoc.jsp'>API Documentation</a>&nbsp;|&nbsp;<a id='indiv' href = 'mobile_client.jsp'> API Test </a>&nbsp;|&nbsp;<a id='indiv' href='<%=request.getContextPath()%>/ApiPulpy'>API Usage</a>&nbsp;|&nbsp;<a id='indiv' href='login.jsp'> Sign Out </a></div>

<br><br><div class="head"><center>Mind Pulpy</center></h2></div><br>
<div class='suc'><center><h3>Login Sucess!!</h3></center></div>
<br><br><div class='con'><center>Get Started From Here</center></div><br><br>
<center><div id='pa'><a href='firstauth.jsp'>Create Application here</a></div></center><br><br>
<center><div id='pa'><a href='<%=request.getContextPath()%>/EditPulpy' >Edit Your Application here</a></div></center><br><br>
<center><div id='pa'><img src="images/you.png" width="41" height="18"><a href="javascript:load()">YouTube Link For Help</a></div></center><br><br>
<center><div id='pa'><a href='mobile_client.jsp'>Mobile Client Application here</a></div></center><br><br>

</body>

</html>