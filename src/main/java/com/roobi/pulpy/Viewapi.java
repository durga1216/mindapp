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
          try
			{
				Class.forName("com.mysql.jdbc.Driver").newInstance();
	            con = (Connection) DriverManager.getConnection(config.get("URL"),config.get("USER"),config.get("PASS"));
		        PreparedStatement st=null;
				 st=con.prepareStatement("select * from addapi where cat=?");
               st.setString(1, cat1);
				    ResultSet rs = st.executeQuery();
				
				   out.println("<br><br><head><link rel='stylesheet' type='text/css' href='apidisp.css'></head><body bgcolor='#FF9900'><div id='re' style='color:#FFFFFF; font-family:verdana; font-size:40px;'><center>Mind Pulpy</center></div><br><div id='re1' style='color:#FFFFFF; font-family:verdana; font-size:25px;'><center>ADDED API's<center><div><br><br><hr style='margin-left:450px; margin-right:300px;color:#FFFFFF;'>");
				out.println("<div style='padding: 9px 0;position: fixed;font-size: 18px;text-align:left;margin-left: 80px;top: 100px;width: 200px;bottom: 10px;min-height: 20px;padding: 19px;margin-bottom: 20px;background-color: #FF9900;border: 1px solid gainsboro; border-color:#FFFFFF;-webkit-border-radius: 4px;-moz-border-radius: 4px;border-radius: 4px;-webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,0.05);-moz-box-shadow: inset 0 1px 1px rgba(0,0,0,0.05);box-shadow: inset 0 1px 1px rgba(0,0,0,0.05);'>");
				   //out.println("<div style='padding:9px 0;font-size: 20px;margin-left: 50px;top: 100px;width:200px;bottom: 10px;padding: 19px;background-color: #FF9900;border: 1px solid gainsboro;-webkit-border-radius: 4px;-moz-border-radius: 4px;border-radius: 4px;-webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,0.05);-moz-box-shadow: inset 0 1px 1px rgba(0,0,0,0.05);box-shadow: inset 0 1px 1px rgba(0,0,0,0.05);'>");
out.println("<p>Category</p><a href='/Viewapi?category=Search'>Search</a><br>"
 		+"<a href='/Viewapi?category=General'>General</a><br>"
 		+"<a href='/Viewapi?category=Backend'>Backend</a><br>"
 		+"<a style='font-color:#FFFFFF;'href='/Viewapi?category=Social'>Social</a><br>"
 		+"<a href='/Viewapi?category=Tools'>Tools</a><br>"
 		+"<a href='/Viewapi?category=Enterprise'>Enterprise</a><br>"
 		+"<a href='/Viewapi?category=Entertainment'>Entertainment</a><br>"
 		+"<a href='/Viewapi?category=Security'>Security</a><br>"
 		+"<a href='/Viewapi?category=Database'>Database</a><br>"
 		+"<a href='/Viewapi?category=Maps'>Maps</a><br>"
 		+"<a href='/Viewapi?category=Education'>Education</a><br>"
 		+"<a href='/Viewapi?category=Health'>Health</a><br>"
 		+"<a href='/Viewapi?category=Music'>Music</a><br>"
 		+"<a href='/Viewapi?category=Shopping'>Shopping</a><br>"
 		+"<a href='/Viewapi?category=Blogging'>Blogging</a><br>"
 		+"<a href='/Viewapi?category=Photos'>Photos</a><br>"
 		+"<a href='/Viewapi?category=Messaging'>Messaging</a></div>");
			while(rs.next()){
				out.println("<div style='font-size:15px;'>");
			        	String name=rs.getString("name");
			            String pname=rs.getString("pname");
			            String cat=rs.getString("cat");
			            String link=rs.getString("link");
			            String des=rs.getString("des");
			            out.println("<br>Provider name:<br>"+pname+"<br><br>Links:<br><a href="+link+">"+link+"</a><hr style='margin-left:450px; margin-right:300px;'></div>");
			           // out.println("<tr><td>"+name+"</td><td>"+pname+"</td><td>"+cat+"</td><td>"+link+"</td><td>"+des+"</td></tr>");

				 }
			}
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
