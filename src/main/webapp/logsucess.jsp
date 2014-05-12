<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
</style>

</head>
<body>
<div id=na><%=session.getAttribute("mail")%> &nbsp;|&nbsp;<a id='indiv' href='<%=request.getContextPath()%>/ApiPulpy'>API Usage</a>&nbsp;|&nbsp;<a id='indiv' href='login.jsp'> Sign Out </a></div>

<br><br><div class="head"><center>Mind Pulpy</center></h2></div><br><br>
<div class='suc'><center><h3>Login Sucess!!</h3></center></div>
<br><br><div class='con'><center>Get Started From Here</center></div><br><br>
<center><div id='pa'><a href='firstauth.jsp'>Create Application here</a></div></center>
</body>
</html>