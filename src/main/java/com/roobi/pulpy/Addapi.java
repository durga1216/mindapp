package com.roobi.pulpy;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.mindots.util.Utils;

/**
 * Servlet implementation class Addapi
 */
public class Addapi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addapi() {
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
		String name=request.getParameter("t1");
        InputStream is = null;  
	   	 response.setHeader("Content-Type","text/html;charset=UTF-8");
		 Map<String, String> config = Utils.getConfigFromFile(getServletContext(), "config.properties");
		String pname=request.getParameter("t2");
		String link=request.getParameter("t3");
		String des=request.getParameter("t4");
		String img=request.getParameter("t5");
		String cat=request.getParameter("t6");


		Connection con=null;
		PrintWriter out=response.getWriter();
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = (Connection) DriverManager.getConnection(config.get("URL"),config.get("USER"),config.get("PASS"));
	        PreparedStatement st=null;
			 st=con.prepareStatement("insert into addapi(name,pname,link,des,img,cat,photo) values ('"+name+"','"+pname+"','"+link+"','"+des+"','"+img+"','"+cat+"','"+is+"')");
			 st.executeUpdate();
		     st.close();
			
		}
		catch(Exception e)
		{
			
		}
		out.println("<br><br><br><br><html><body bgcolor='#FF9900'><center><h2>API ADDED SUCCESSFULLY</h2></center></body></html>");
	     response.setHeader("Refresh", "1; URL=indexpulpy.jsp");
	}

}
