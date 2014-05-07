package com.roobi.pulpy;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginPulpy extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public LoginPulpy() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con=null;  
	    PrintWriter out=response.getWriter(); 
		String s1=request.getParameter("s1");
		String s2=request.getParameter("s2");
		String s3=request.getParameter("s3");
		String s4=request.getParameter("s4");
		try{
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			 String url = "jdbc:mysql://127.6.250.130:3306/mpulpy";
		        final String USER = "adminPQ1iFfN";
		        final String PASS = "J5JhBL-XC9NG";
	        con = DriverManager.getConnection(url1,USER,PASS);
	        PreparedStatement st=null;
			 st=con.prepareStatement("insert into login(email,fn,ln,pwd) values ('"+s1+"','"+s2+"','"+s3+"','"+s4+"')");
			 st.executeUpdate();
		     st.close();
		     out.println("insert sucess");
		     response.setHeader("Refresh", "1; URL=login.jsp");

		}
		catch(Exception e){
			out.println(e);
		}
		

	}

}
