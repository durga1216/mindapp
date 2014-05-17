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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Map<String, String> config = Utils.getConfigFromFile(getServletContext(), "config.properties");
		 Connection con=null;
			PrintWriter out=response.getWriter();
			try
			{
				Class.forName("com.mysql.jdbc.Driver").newInstance();
	            con = (Connection) DriverManager.getConnection(config.get("URL"),config.get("USER"),config.get("PASS"));
		        PreparedStatement st=null;
				 st=con.prepareStatement("select * from addapi");
				    ResultSet rs = st.executeQuery();
				 out.println("<br><br><br><body bgcolor='#FF9900'><div id='re' style='color:#FFFFFF; font-family:verdana; font-size:40px;'><center>Mind Pulpy</center></div><br><br><div id='re1' style='color:#FFFFFF; font-family:verdana; font-size:25px;'><center>ADDED API's<center><div><br><br><table align='center' border='1' bordercolor='#FFFFFF' style='color:#FFFFFF; font-size:20px; font-family:verdana; width:100%;'><tr><th>Api Name</th><th>Provider Name</th><th>catagory</th><th>URL</th><th>Description</th></tr>");
			        while(rs.next()){
			        	String name=rs.getString("name");
			            String pname=rs.getString("pname");
			            String cat=rs.getString("cat");
			            String link=rs.getString("link");
			            String des=rs.getString("des");
			            out.println("<tr><td>"+name+"</td><td>"+pname+"</td><td>"+cat+"</td><td>"+link+"</td><td>"+des+"</td></tr>");

				
			}
			}
			catch(Exception e)
			{
				out.println(e);
			}
	}

}
