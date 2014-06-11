package com.roobi.pulpy;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mindots.util.Utils;

public class LoginCheckPulpy extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con=null; 

    public LoginCheckPulpy() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> config = Utils.getConfigFromFile(getServletContext(), "config.properties");
	    PrintWriter out=response.getWriter();
	    String t1=request.getParameter("t1");
	    String t2=request.getParameter("t2");
	    String id=null;
	    String mail=null;
	    String pwd=null;
	    try{
	    Class.forName("com.mysql.jdbc.Driver").newInstance();
        con = (Connection) DriverManager.getConnection(config.get("URL"),config.get("USER"),config.get("PASS"));
         PreparedStatement st=null;
         st=con.prepareStatement("SELECT * From login where email='"+t1+"' and pwd='"+t2+"'");
         ResultSet rs = st.executeQuery();
         while(rs.next()){
	          id=rs.getString("id");
              mail=rs.getString("email");
              pwd=rs.getString("pwd");
         }
         st=con.prepareStatement("SELECT * From authen1 where id='"+id+"'");
       
             if(t1.equals(mail) && t2.equals(pwd)){
            	 
            	 HttpSession session=request.getSession(true);
                 session.setAttribute("id", id);
                 session.setAttribute("mail", mail);
                 request.getSession().setAttribute("user", "mind");
    		     response.setHeader("Refresh", "1; URL=logsucess.jsp");
                 }
             else if(t1.equals("") && t2.equals("")){
             String alert="Please Enter UserName and Password!!";
    	     RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
             request.setAttribute("alert", alert); // set your String value in the attribute
             dispatcher.forward( request, response ); 
             }
             else{
         String alert="Incorrect UserName and Password!! Try Again";
    	 RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
         request.setAttribute("alert", alert); // set your String value in the attribute
         dispatcher.forward( request, response );  	 }
	     
         
         }
         catch(Exception e){
        	 out.println(e);
         }
	
	}

}
