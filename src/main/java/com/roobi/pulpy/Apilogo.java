package com.roobi.pulpy;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
 * Servlet implementation class Apilogo
 */
@WebServlet("/Apilogo")
//@MultipartConfig(maxFileSize = 16177215) // upload file up to 16MB  
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
		Connection con=null;
		 Map<String, String> config = Utils.getConfigFromFile(getServletContext(), "config.properties");
		BufferedImage buffimg = null;PrintWriter out=response.getWriter();
			// response.setHeader("Content-Type","text/html;charset=UTF-8");
			  String imgLen="";
		out.println("<div>");
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = (Connection) DriverManager.getConnection(config.get("URL"),config.get("USER"),config.get("PASS"));
		PreparedStatement ps=con.prepareStatement("select * from authen1 where appid=?");
		ps.setString(1, logo);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			  imgLen = rs.getString("logo").toString();
			int len = imgLen.length();
			System.out.println(len);
			  byte [] rb = new byte[len];
			  InputStream readImg = rs.getBinaryStream("logo");
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
        String firstName = request.getParameter("firstName");  
        String lastName = request.getParameter("lastName");  
  PrintWriter out=response.getWriter();
        InputStream inputStream = null;  
  
        // obtains the upload file part in this multipart request  
        Part filePart = request.getPart("photo");  
        if (filePart != null) {  
            // debug messages  
            System.out.println(filePart.getName());  
            System.out.println(filePart.getSize());  
            System.out.println(filePart.getContentType());  
  
            // obtains input stream of the upload file  
            inputStream = filePart.getInputStream();  
        }  
  
        String message = null; // message will be sent back to client  
  
        try {  
        	Class.forName("com.mysql.jdbc.Driver").newInstance();
			//Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/mpulpy","root","root");
			Connection conn=DriverManager.getConnection("jdbc:mysql://127.4.215.130:3306/glass", "adminejLNKKj", "SHcP4fCwMWqi");
            String sql = "INSERT INTO contacts (first_name, last_name, photo) values (?, ?, ?)";  
            PreparedStatement statement = conn.prepareStatement(sql);  
            statement.setString(1, firstName);  
            statement.setString(2, lastName);  
  
            if (inputStream != null) {  
                // fetches input stream of the upload file for the blob column  
                statement.setBlob(3, inputStream);  
            }  
  
            // sends the statement to the database server  
            int row = statement.executeUpdate();  
            if (row > 0) {  
                message = "Image is uploaded successfully into the Database";  
            }  
        } catch (SQLException ex) {  
            message = "ERROR: " + ex.getMessage();  
            ex.printStackTrace();  
        } catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        // sets the message in request scope  
        request.setAttribute("Message", message);
        out.println(message);
	}

}
