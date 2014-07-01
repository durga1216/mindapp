    <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
    <html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title></title>
     <style>
     body{
background-color:#ff9900;

}
option{
font-size:20px;
background-color:#ff9900;
}
select{
border-color:#ff9900;
color:#ffffff;
font-size:20px;
margin-left:80px;
background-color:#ff9900;
font-family:verdana;
width:440px;
height:60px;
padding:10px;
}
input[type="submit"]{

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

     </style>
    </head>
    <body><center>
 <form method="post" action="Fortest" enctype="multipart/form-data">  
      <%@page import="com.mindots.util.Utils"%>
      <%@page import=" java.sql.PreparedStatement"%>
      <%@page import="java.sql.ResultSet"%>
      <%@page import="java.sql.DriverManager"%>
      <%@page import="java.sql.Connection"%>
      <select id='apid' name='no' ><option value='dummy'>--Choose API--</option>
      <%
      String id1=(String) session.getAttribute("id");
      try{
      Class.forName("com.mysql.jdbc.Driver");
      Connection cn=DriverManager.getConnection("jdbc:mysql://127.6.250.130:3306/mpulpy","adminPQ1iFfN","J5JhBL-XC9NG");
      //Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/mpulpy","root","root");
      PreparedStatement st1=cn.prepareStatement("SELECT * FROM addapi");
      ResultSet rs1 = st1.executeQuery();
      while(rs1.next()){
      	String ap=rs1.getString("no");
      	String nme=rs1.getString("pname");
          out.println("<option value='"+ap+"'>"+ap+",&nbsp;&nbsp;&nbsp;  "+nme+"</option>");

      }
      out.println("</select><br>");
      }
      catch(Exception e)
      {}
      %>
      <br><br>
      <div style="color:#ffffff;font-size:25px;">Select Logo:</div><input style="color:#ffffff;" type="file" name="logo" placeholder="image location"><br><br>
     <input type="submit" name="submit" value="update"></input>
     </center> </form>
    </body>
    </html>