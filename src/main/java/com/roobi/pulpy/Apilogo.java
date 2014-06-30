package com.roobi.pulpy;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Apilogo
 */
@WebServlet("/Apilogo")
public class Apilogo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Apilogo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String logo=request.getParameter("idl");
		BufferedImage buffimg = null;PrintWriter out=response.getWriter();
			 response.setHeader("Content-Type","text/html;charset=UTF-8");
			  String imgLen="";
		out.println("<div>");
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		//	Connection con=DriverManager.getConnection("jdbc:mysql://localhost/mpulpy","root","root");
		Connection con=DriverManager.getConnection("jdbc:mysql://127.4.215.130:3306/glass", "adminejLNKKj", "SHcP4fCwMWqi");
		PreparedStatement ps=con.prepareStatement("select * addapi from  where name=?");
		ps.setString(1, logo);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			  imgLen = rs.getString("img").toString();
			int len = imgLen.length();
			  byte [] rb = new byte[len];
			  InputStream readImg = rs.getBinaryStream("img");
			  int index=readImg.read(rb, 0, len);  
			  response.reset();
			  response.setContentType("image/jpg");
			  response.getOutputStream().write(rb,0,len);
			  response.getOutputStream().flush(); 
		}
		}
		catch(Exception e)
		{ e.printStackTrace();
			}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
