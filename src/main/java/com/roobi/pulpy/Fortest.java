package com.roobi.pulpy;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.mindots.util.Utils;

/**
 * Servlet implementation class Fortest
 */
@WebServlet("/Fortest")
@MultipartConfig(maxFileSize = 16177215) // upload file up to 16MB  
public class Fortest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Fortest() {
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
		 response.setHeader("Content-Type","text/html;charset=UTF-8");
		 Map<String, String> config = Utils.getConfigFromFile(getServletContext(), "config.properties");
			String no=request.getParameter("no");
			InputStream inputStream=null;
        Part filePart = request.getPart("logo"); 
		if (filePart != null) {  
        inputStream = filePart.getInputStream();}
		Connection con=null;
		PrintWriter out=response.getWriter();
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = (Connection) DriverManager.getConnection(config.get("URL"),config.get("USER"),config.get("PASS"));
	        PreparedStatement st=null;
			 st=con.prepareStatement("update addapi set photo=? where no=?");
			 if (inputStream != null) {  
			        st.setBlob(1, inputStream);  
			}
			 st.setString(2, no);
			 st.executeUpdate();
			 st.close();
		     out.println("<br><br><br><br><html><body bgcolor='#FF9900'><center><h2 style='color:#ffffff'>UPDATE SUCCESSFULLY</h2></center></body></html>");
			 response.setHeader("Refresh", "1; URL=test.jsp");
			
		}
		catch(Exception e)
		{
			out.println(e);
		}
		
	}

}
