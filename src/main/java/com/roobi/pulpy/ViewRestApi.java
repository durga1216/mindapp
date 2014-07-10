package com.roobi.pulpy;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.HttpHeaders;

@Path ("/pulpy")

public class ViewRestApi {
	
	@GET
	
    @Produces(MediaType.TEXT_HTML)
	
	@Path("/viewapi")
	
	public Response getResult(@Context HttpServletRequest request,@Context HttpServletResponse response,@PathParam("category") String cat1) {

	try{
        response.setContentType("text/html");
		Connection con=null;
		 HttpSession session=request.getSession(true);
          PrintWriter out=response.getWriter();
		 Class.forName("com.mysql.jdbc.Driver").newInstance();
	    con=DriverManager.getConnection("jdbc:mysql://127.6.250.130:3306/mpulpy","adminPQ1iFfN","J5JhBL-XC9NG");
		String ser=request.getParameter("search");
        PreparedStatement st=null;

	        PreparedStatement st1=null;
			 st=con.prepareStatement("select * from addapi where cat=? ORDER BY pname");
               st.setString(1, cat1);
			 st1=con.prepareStatement("select * from addapi where pname like ? ORDER BY pname");
           st1.setString(1, ser+"%");
			    ResultSet rs = st.executeQuery();
			    ResultSet rs1 = st1.executeQuery();
			
			   out.println("<br><br><body bgcolor='#FF9900'><div id='re' style='color:#FFFFFF; font-family:verdana; font-size:40px;'><center>Mind Pulpy</center></div><br><div id='re1' style='color:#FFFFFF; font-family:verdana; font-size:25px;'><center>Free Public APIs<center><div><br><hr style='margin-left:400px; margin-right:250px;color:#FFFFFF;'>");
			out.println("<div style='position: fixed;font-size: 18px;text-align:left;margin-left: 80px;top: 100px;width: 200px;padding: 19px;background-color: #FF9900;border: 1px solid gainsboro; border-color:#FFFFFF;border-radius: 4px;'>");
out.println("<p style='font-weight:bold'>Category</p><a style='color:#ffffff' href='/rest/pulpy/viewapi?category=Search'>Search</a><br>"
		+"<a style='color:#ffffff' href='/pulpy/xml/viewapi?category=General'>General</a><br>"
		+"<a style='color:#ffffff' style='font-color:#FFFFFF;'href='/Viewapi?category=Social'>Social</a><br>"
		+"<a style='color:#ffffff' href='/pulpy/viewapi?category=Tools'>Tools</a><br>"
		+"<a style='color:#ffffff' href='/rest/pulpy/viewapi?category=Enterprise'>Enterprise</a><br>"
		+"<a style='color:#ffffff' href='/rest/pulpy/viewapi?category=Entertainment'>Entertainment</a><br>"
		+"<a style='color:#ffffff' href='/rest/pulpy/viewapi?category=wearable'>Hardware/wearable</a><br>"
		+"<a style='color:#ffffff' href='/rest/pulpy/viewapi?category=Maps'>Maps</a><br>"
		+"<a style='color:#ffffff' href='/rest/pulpy/viewapi?category=Education'>Education</a><br>"
		+"<a style='color:#ffffff' href='/rest/pulpy/viewapi?category=Health'>Health</a><br>"
		+"<a style='color:#ffffff' href='/rest/pulpy/viewapi?category=Music'>Music</a> <br>"
		+"<a style='color:#ffffff' href='/rest/pulpy/viewapi?category=Shopping'>Shopping</a><br>"
		+"<a style='color:#ffffff' href='/rest/pulpy/viewapi?category=Photos'>Photos</a><br>"
		+"<a style='color:#ffffff' href='/rest/pulpy/viewapi?category=Messaging'>Messaging</a></div>");
out.println("<br><div style='position: fixed;font-size: 18px;text-align:center;margin-left: 1150px;top: 30px;width: 70px;;padding: 15px;background-color: #FF9900;border: 1px solid gainsboro; border-color:#FFFFFF;border-radius: 4px;'>");
out.println("<a style='color:#ffffff' href='/rest/pulpy/viewapi?search=A'>A</a>&nbsp;&nbsp;&nbsp;&nbsp;"
+"<a style='color:#ffffff' href='/rest/pulpy/viewapi?search=B'>B</a><br><br>"
+"<a style='color:#ffffff' href='/rest/pulpy/viewapi?search=C'>C</a>&nbsp;&nbsp;&nbsp;&nbsp;"
+"<a style='color:#ffffff' href='/rest/pulpy/viewapi?search=D'>D</a><br><br>"
+"<a style='color:#ffffff' href='/rest/pulpy/viewapi?search=E'>E</a>&nbsp;&nbsp;&nbsp;&nbsp;"
+"<a style='color:#ffffff' href='/rest/pulpy/viewapi?search=F'>F</a><br><br>"
+"<a style='color:#ffffff' href='/rest/pulpy/viewapi?search=G'>G</a>&nbsp;&nbsp;&nbsp;&nbsp;"
+"<a style='color:#ffffff' href='/rest/pulpy/viewapi?search=H'>H</a><br><br>"
+"<a style='color:#ffffff' href='/rest/pulpy/viewapi?search=I'>I</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
+"<a style='color:#ffffff' href='/rest/pulpy/viewapi?search=J'>J</a><br><br>"
+"<a style='color:#ffffff' href='/rest/pulpy/viewapi?search=K'>K</a>&nbsp;&nbsp;&nbsp;&nbsp;"
+"<a style='color:#ffffff' href='/rest/pulpy/viewapi?search=L'>L</a><br><br>"
+"<a style='color:#ffffff' href='/rest/pulpy/viewapi?search=M'>M</a>&nbsp;&nbsp;&nbsp;&nbsp;"
+"<a style='color:#ffffff' href='/rest/pulpy/viewapi?search=N'>N</a><br><br>"
+"<a style='color:#ffffff' href='/rest/pulpy/viewapi?search=O'>O</a>&nbsp;&nbsp;&nbsp;&nbsp;"
+"<a style='color:#ffffff' href='/rest/pulpy/viewapi?search=P'>P</a><br><br>"
+"<a style='color:#ffffff' href='/rest/pulpy/viewapi?search=Q'>Q</a>&nbsp;&nbsp;&nbsp;&nbsp;"
+"<a style='color:#ffffff' href='/rest/pulpy/viewapi?search=R'>R</a><br><br>"
+"<a style='color:#ffffff' href='/rest/pulpy/viewapi?search=S'>S</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
+"<a style='color:#ffffff' href='/rest/pulpy/viewapi?search=T'>T</a><br><br>"
+"<a style='color:#ffffff' href='/rest/pulpy/viewapi?search=U'>U</a>&nbsp;&nbsp;&nbsp;&nbsp;"
+"<a style='color:#ffffff' href='/rest/pulpy/viewapi?search=V'>V</a><br><br>"
+"<a style='color:#ffffff' href='/rest/pulpy/viewapi?search=W'>W</a>&nbsp;&nbsp;&nbsp;"
+"<a style='color:#ffffff' href='/rest/pulpy/viewapi?search=X'>X</a><br><br>"
+"<a style='color:#ffffff' href='/rest/pulpy/viewapi?search=Y'>Y</a>&nbsp;&nbsp;&nbsp;&nbsp;"
+"<a style='color:#ffffff' href='/rest/pulpy/viewapi?search=Z'>Z</a></div>");
out.println("<div style='padding: 9px 0;position: fixed;font-size: 18px;text-align:left;margin-left:20px;top: 10px;width: 40px;min-height: 20px;padding: 19px;bottom:1200px;background-color: #FF9900;border: 1px solid gainsboro; border-color:#FFFFFF;-webkit-border-radius: 4px;-moz-border-radius: 4px;border-radius: 4px;-webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,0.05);-moz-box-shadow: inset 0 1px 1px rgba(0,0,0,0.05);box-shadow: inset 0 1px 1px rgba(0,0,0,0.05);'>");
out.println("<a style='color:#ffffff' href='index.jsp'>Back</a></div>");
		while(rs.next()){
			out.println("<div style='font-size:17px;height:110px; border:0px solid #FFFFFF;'>");
		        	String name=rs.getString("name");
		            String pname=rs.getString("pname");
		            String cat=rs.getString("cat");
		            String link=rs.getString("link");
		            String des=rs.getString("des");
		            out.println("<div style='width:10%;margin-left:450px;height:100px;float:left; border:0px solid #FFFFFF;'><img style='box-shadow: 5px 5px 15px 2px;color:#000000;border-radius: 4px;' src='Addapi?idl="+name+"' width='100' height='100'></div>"
		            		+ "<div style='width:40%;float:left;border:0px solid #FFFFFF;'>Provider name:<br>"+pname+"<br><br>Links:<br><a style='color:#ffffff' href="+link+">"+link+"</a></div></div>");
		            
		           out.println("<div><hr style='margin-left:400px; margin-right:250px;color:#FFFFFF;'></div>");
			 }
		while(rs1.next()){
			out.println("<div style='font-size:17px;height:110px; border:0px solid #FFFFFF;'>");
        	String name=rs1.getString("name");
            String pname=rs1.getString("pname");
            String cat=rs1.getString("cat");
            String link=rs1.getString("link");
            String des=rs1.getString("des");
            out.println("<div style='width:10%;margin-left:450px;height:100px;float:left; border:0px solid #FFFFFF;'><img style='box-shadow: 7px 7px 15px 3px;color:#000000;border-radius: 4px;' src='Addapi?idl="+name+"' width='100' height='100'></div>"
            		+ "<div style='width:40%;float:left;border:0px solid #FFFFFF;'>Provider name:<br>"+pname+"<br><br>Links:<br><a style='color:#ffffff' href="+link+">"+link+"</a></div></div>");
           out.println("<div><hr style='margin-left:400px; margin-right:250px;color:#FFFFFF;'></div>");
		}
		out.println("</div>");

	}
	catch(Exception e){}
	
	return Response.ok()
		      .header("Access-Control-Allow-Origin", "*")
		      .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
		      .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();	}
	

}
