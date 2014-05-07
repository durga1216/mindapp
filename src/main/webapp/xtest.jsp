<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page import="java.io.*"  %>
<%
String str = "<test>vvghvhg</test>";
//always give the path from root. This way it almost always works.
String fileName=getServletContext().getRealPath("xtest.xml"); 
out.println(fileName);
try {   
    PrintWriter pw = new PrintWriter(new FileOutputStream(fileName));
    pw.println(str);
    //clean up
    pw.close();
    System.out.println("update");
} catch(IOException e) {
   out.println(e.getMessage());
}
%>
</body>
</html>