<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
body{
background-color:#FF9900;}
</style>
</head>
<body>
    <%request.getSession().setAttribute("user", null);%>

<h1>you have been logout</h1>
<h3><a href="Login.jsp">click here to login</a></h3>
</body>
</html>