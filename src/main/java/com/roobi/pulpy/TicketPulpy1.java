package com.roobi.pulpy;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TicketPulpy1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public TicketPulpy1() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
        HttpSession session=request.getSession(true);
		String appid=(String) session.getAttribute("id");
		String ptag=request.getParameter("t");
		String tid=request.getParameter("t4");
		String ttype=request.getParameter("t5");
		String tdesc=request.getParameter("t6");
		String tprice=request.getParameter("t7");
		String edate=request.getParameter("t8");
		Connection con=null;
		try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://127.6.250.130:3306/mpulpy";
       final String USER = "adminPQ1iFfN";
           final String PASS = "J5JhBL-XC9NG";
            con = DriverManager.getConnection(url,USER,PASS);
            PreparedStatement st=con.prepareStatement("insert into table4(id,ptag4,tid,ttype,tdesc,tprice,edate) values ('"+appid+"','"+ptag+"','"+tid+"','"+ttype+"','"+tdesc+"','"+tprice+"','"+edate+"')");                
            st.executeUpdate();
            out.println("Insert Success");
        
		}
		catch(Exception e){
			out.println(e);
		}
		
	}

}
