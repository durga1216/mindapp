<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="DescPulpy" method="post">
<center><h1><font color="red"><b>Description EndPoint</b></font></h1></center>
<table align="center" width="600" height="300">
<tr><td><font color="blue">Description_URL</td><td><input type="text" name="t1"></font></td></tr>
<tr><td><font color="blue">Test param</td><td><input type="text" name="tp"></font></td></tr>
<tr><td><font color="blue">Test value</td><td><input type="text" name="tv"></font></td></tr>
<tr><td><center><input type="submit" name="first" value="XML Response"></center></td>
<td><center><input type="submit" name="second" value="JSON Response"></center></td></tr>
</table>
</body>
</html>