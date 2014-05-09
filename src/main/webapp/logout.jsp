<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
body{
background-color:#FF9900;
}
h1{
font-family:verdana;
color:#FFFFFF;
}
h2{
font-family:verdana;
color:#FFFFFF;
}
a{
font-family:verdana;
color:#FFFFFF;
}
</style>
</head>
<body>
    <%request.getSession().setAttribute("user", null);%>
<center><h1>Mind Pulpy</h1><center><br><br>

<center><h2>Successfully Signout!!</h2><center><br><br>
<h3><a href="index.jsp">click here to login</a></h3>
</body>
</html>