package com.roobi.pulpy;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mindots.util.Utils;

/**
 * Servlet implementation class dummy
 */
@WebServlet("/dummy")
public class dummy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dummy() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setHeader("Content-Type","text/html;charset=UTF-8");
		Map<String, String> config = Utils.getConfigFromFile(getServletContext(), "config.properties");
		 Connection con=null;
		    HttpSession session=request.getSession(true);
			  String id1=(String) session.getAttribute("id");
			  try{
			    Class.forName("com.mysql.jdbc.Driver").newInstance();
		        con = (Connection) DriverManager.getConnection(config.get("URL"),config.get("USER"),config.get("PASS"));

			    PreparedStatement st=con.prepareStatement("SELECT appid FROM authen1 WHERE id=?");
			    st.setString(1,"MP_0021");
			    ResultSet rs = st.executeQuery();
			    out.println("<form><select name='usrid'>");
		        out.println("<option value='dummy'>--choose ur appid--</option>");
		        while(rs.next()){
		        	String ap=rs.getString("appid");
		        out.println("<option value='"+ap+"'>"+ap+"</option>");
		        
		        }
			    out.println("</select><input type='submit' value='submit'></form>");

		        }
	
		 catch(Exception e)
		 {
			 
		 }
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
}
}