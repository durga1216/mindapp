<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
body{background-color:#FF9900;}
.head{
color:#FFFFFF;
    font-family:verdana;
    font-size:40px;
    margin-top:50px;
}
.main{
color:#FFFFFF;
    font-family:verdana;
    font-size:30px;
    margin-top:100px;
}
.result{
color:#FFFFFF;
    font-family:verdana;
    font-size:25px;
    margin-top:100px;
}
</style>
</head>

<body>
<%request.getSession().setAttribute("user", null);%>
<center><div class="head">Mind Pulpy</div></center>
<center><div class="main">Configuration completed! Check With Mobile App</div></center>
<center><div class="result">Your App ID  : &nbsp;<%=request.getAttribute("id")%></div></center>
</body>
</html>