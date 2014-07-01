package com.roobi.pulpy;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mindots.util.Utils;

/**
 * Servlet implementation class Viewapi
 */
public class Viewapi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Viewapi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		 Map<String, String> config = Utils.getConfigFromFile(getServletContext(), "config.properties");
		 Connection con=null;
			PrintWriter out=response.getWriter();
			String cat1=request.getParameter("category");
			String ser=request.getParameter("search");
          try
			{
				Class.forName("com.mysql.jdbc.Driver").newInstance();
	            con = (Connection) DriverManager.getConnection(config.get("URL"),config.get("USER"),config.get("PASS"));
		        PreparedStatement st=null;
		        PreparedStatement st1=null;
				 st=con.prepareStatement("select * from addapi where cat=?");
	               st.setString(1, cat1);
				 st1=con.prepareStatement("select * from addapi where pname like ?");
               st1.setString(1, ser+"%");
				    ResultSet rs = st.executeQuery();
				    ResultSet rs1 = st1.executeQuery();
				
				   out.println("<br><br><head><link rel='stylesheet' type='text/css' href='apidisp.css'></head><body bgcolor='#FF9900'><div id='re' style='color:#FFFFFF; font-family:verdana; font-size:40px;'><center>Mind Pulpy</center></div><br><div id='re1' style='color:#FFFFFF; font-family:verdana; font-size:25px;'><center>Free Public APIs<center><div><br><hr style='margin-left:400px; margin-right:250px;color:#FFFFFF;'>");
				out.println("<div style='padding: 9px 0;position: fixed;font-size: 18px;text-align:left;margin-left: 80px;top: 100px;width: 200px;bottom: 10px;min-height: 20px;padding: 19px;margin-bottom: 20px;background-color: #FF9900;border: 1px solid gainsboro; border-color:#FFFFFF;-webkit-border-radius: 4px;-moz-border-radius: 4px;border-radius: 4px;-webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,0.05);-moz-box-shadow: inset 0 1px 1px rgba(0,0,0,0.05);box-shadow: inset 0 1px 1px rgba(0,0,0,0.05);'>");
				   //out.println("<div style='padding:9px 0;font-size: 20px;margin-left: 50px;top: 100px;width:200px;bottom: 10px;padding: 19px;background-color: #FF9900;border: 1px solid gainsboro;-webkit-border-radius: 4px;-moz-border-radius: 4px;border-radius: 4px;-webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,0.05);-moz-box-shadow: inset 0 1px 1px rgba(0,0,0,0.05);box-shadow: inset 0 1px 1px rgba(0,0,0,0.05);'>");
out.println("<p style='font-weight:bold'>Category</p><a style='color:#ffffff' href='/Viewapi?category=Search'>Search</a><br>"
 		+"<a style='color:#ffffff' href='/Viewapi?category=General'>General</a><br>"
 		+"<a style='color:#ffffff' style='font-color:#FFFFFF;'href='/Viewapi?category=Social'>Social</a><br>"
 		+"<a style='color:#ffffff' href='/Viewapi?category=Tools'>Tools</a><br>"
 		+"<a style='color:#ffffff' href='/Viewapi?category=Enterprise'>Enterprise</a><br>"
 		+"<a style='color:#ffffff' href='/Viewapi?category=Entertainment'>Entertainment</a><br>"
 		+"<a style='color:#ffffff' href='/Viewapi?category=wearable'>Hardware/wearable</a><br>"
 		+"<a style='color:#ffffff' href='/Viewapi?category=Maps'>Maps</a><br>"
 		+"<a style='color:#ffffff' href='/Viewapi?category=Education'>Education</a><br>"
 		+"<a style='color:#ffffff' href='/Viewapi?category=Health'>Health</a><br>"
 		+"<a style='color:#ffffff' href='/Viewapi?category=Music'>Music</a> <br>"
 		+"<a style='color:#ffffff' href='/Viewapi?category=Shopping'>Shopping</a><br>"
 		+"<a style='color:#ffffff' href='/Viewapi?category=Photos'>Photos</a><br>"
 		+"<a style='color:#ffffff' href='/Viewapi?category=Messaging'>Messaging</a></div>");
out.println("<br><div style='padding: 9px 0;position: fixed;font-size: 18px;text-align:left;margin-left: 1150px;top: 30px;width: 70px;bottom:5px;min-height: 20px;padding: 19px;margin-bottom: 10px;background-color: #FF9900;border: 1px solid gainsboro; border-color:#FFFFFF;-webkit-border-radius: 4px;-moz-border-radius: 4px;border-radius: 4px;-webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,0.05);-moz-box-shadow: inset 0 1px 1px rgba(0,0,0,0.05);box-shadow: inset 0 1px 1px rgba(0,0,0,0.05);'>");
out.println("<a style='color:#ffffff' href='/Viewapi?search=A'>A</a>&nbsp;&nbsp;&nbsp;&nbsp;"
+"<a style='color:#ffffff' href='/Viewapi?search=B'>B</a><br><br>"
+"<a style='color:#ffffff' href='/Viewapi?search=C'>C</a>&nbsp;&nbsp;&nbsp;&nbsp;"
+"<a style='color:#ffffff' href='/Viewapi?search=D'>D</a><br><br>"
+"<a style='color:#ffffff' href='/Viewapi?search=E'>E</a>&nbsp;&nbsp;&nbsp;&nbsp;"
+"<a style='color:#ffffff' href='/Viewapi?search=F'>F</a><br><br>"
+"<a style='color:#ffffff' href='/Viewapi?search=G'>G</a>&nbsp;&nbsp;&nbsp;&nbsp;"
+"<a style='color:#ffffff' href='/Viewapi?search=H'>H</a><br><br>"
+"<a style='color:#ffffff' href='/Viewapi?search=I'>I</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
+"<a style='color:#ffffff' href='/Viewapi?search=J'>J</a><br><br>"
+"<a style='color:#ffffff' href='/Viewapi?search=K'>K</a>&nbsp;&nbsp;&nbsp;&nbsp;"
+"<a style='color:#ffffff' href='/Viewapi?search=L'>L</a><br><br>"
+"<a style='color:#ffffff' href='/Viewapi?search=M'>M</a>&nbsp;&nbsp;&nbsp;&nbsp;"
+"<a style='color:#ffffff' href='/Viewapi?search=N'>N</a><br><br>"
+"<a style='color:#ffffff' href='/Viewapi?search=O'>O</a>&nbsp;&nbsp;&nbsp;&nbsp;"
+"<a style='color:#ffffff' href='/Viewapi?search=P'>P</a><br><br>"
+"<a style='color:#ffffff' href='/Viewapi?search=Q'>Q</a>&nbsp;&nbsp;&nbsp;&nbsp;"
+"<a style='color:#ffffff' href='/Viewapi?search=R'>R</a><br><br>"
+"<a style='color:#ffffff' href='/Viewapi?search=S'>S</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
+"<a style='color:#ffffff' href='/Viewapi?search=T'>T</a><br><br>"
+"<a style='color:#ffffff' href='/Viewapi?search=U'>U</a>&nbsp;&nbsp;&nbsp;&nbsp;"
+"<a style='color:#ffffff' href='/Viewapi?search=V'>V</a><br><br>"
+"<a style='color:#ffffff' href='/Viewapi?search=W'>W</a>&nbsp;&nbsp;&nbsp;"
+"<a style='color:#ffffff' href='/Viewapi?search=X'>X</a><br><br>"
+"<a style='color:#ffffff' href='/Viewapi?search=Y'>Y</a>&nbsp;&nbsp;&nbsp;&nbsp;"
+"<a style='color:#ffffff' href='/Viewapi?search=Z'>Z</a></div>");
out.println("<div style='padding: 9px 0;position: fixed;font-size: 18px;text-align:left;margin-left:20px;top: 10px;width: 40px;min-height: 20px;padding: 19px;bottom:1200px;background-color: #FF9900;border: 1px solid gainsboro; border-color:#FFFFFF;-webkit-border-radius: 4px;-moz-border-radius: 4px;border-radius: 4px;-webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,0.05);-moz-box-shadow: inset 0 1px 1px rgba(0,0,0,0.05);box-shadow: inset 0 1px 1px rgba(0,0,0,0.05);'>");
out.println("<a style='color:#ffffff' href='index.jsp'>Back</a></div>");
			while(rs.next()){
				out.println("<div style='font-size:17px;height:110px; border:0px solid #FFFFFF;'>");
			        	String name=rs.getString("name");
			            String pname=rs.getString("pname");
			            String cat=rs.getString("cat");
			            String link=rs.getString("link");
			            String des=rs.getString("des");
			            out.println("<div style='width:10%;overflow:auto;margin-left:500px;height:100px;float:left; border:0px solid #FFFFFF;'><img src='Addapi?idl="+name+"' width='100' height='100'></div>"
			            		+ "<div style='width:40%;float:left;overflow:auto;border:0px solid #FFFFFF;'>Provider name:<br>"+pname+"<br><br>Links:<br><a style='color:#ffffff' href="+link+">"+link+"</a></div></div>");
			            
			           out.println("<div><hr style='margin-left:450px; margin-right:300px;color:#FFFFFF;'></div>");
				 }
			while(rs1.next()){
				out.println("<div style='font-size:17px;height:110px; border:0px solid #FFFFFF;'>");
	        	String name=rs1.getString("name");
	            String pname=rs1.getString("pname");
	            String cat=rs1.getString("cat");
	            String link=rs1.getString("link");
	            String des=rs1.getString("des");
	            out.println("<div style='width:10%;overflow:auto;margin-left:400px;height:100px;float:left; border:0px solid #FFFFFF;'><img src='Addapi?idl="+name+"' width='100' height='100'></div>"
	            		+ "<div style='width:40%;float:left;overflow:auto;border:0px solid #FFFFFF;'>Provider name:<br>"+pname+"<br><br>Links:<br><a style='color:#ffffff' href="+link+">"+link+"</a></div></div>");
	           out.println("<div><hr style='margin-left:400px; margin-right:250px;color:#FFFFFF;'></div>");
			}}
          catch(Exception e)
			{
				out.println(e);
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
