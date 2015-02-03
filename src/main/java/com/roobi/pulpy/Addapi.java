package com.roobi.pulpy;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
 * Servlet implementation class Addapi
 */
@MultipartConfig(maxFileSize = 16177215)
// upload file up to 16MB
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> config = Utils.getConfigFromFile(
				getServletContext(), "config.properties");
		String logo = request.getParameter("idl");
		Connection con = null;
		BufferedImage buffimg = null;
		PrintWriter out = response.getWriter();
		// response.setHeader("Content-Type","text/html;charset=UTF-8");
		String imgLen = "";
		out.println("<div>");
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = (Connection) DriverManager.getConnection(config.get("URL"),
					config.get("USER"), config.get("PASS"));
			PreparedStatement ps = con
					.prepareStatement("select * from addapi where name=?");
			ps.setString(1, logo);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				imgLen = rs.getString("photo").toString();
				int len = imgLen.length();
				byte[] rb = new byte[len];
				InputStream readImg = rs.getBinaryStream("photo");
				int index = readImg.read(rb, 0, len);
				response.reset();
				response.setContentType("image/jpg");
				response.getOutputStream().write(rb, 0, len);
				response.getOutputStream().flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Content-Type", "text/html;charset=UTF-8");
		Map<String, String> config = Utils.getConfigFromFile(
				getServletContext(), "config.properties");
		String name = request.getParameter("t1");
		InputStream inputStream = null;
		String pname = request.getParameter("t2");
		String link = request.getParameter("t3");
		String des = request.getParameter("t4");
		String imn = request.getParameter("t5");
		Part filePart = request.getPart("t5");
		if (filePart != null) {
			inputStream = filePart.getInputStream();
		}
		String cat = request.getParameter("t6");
		Connection con = null;
		PrintWriter out = response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = (Connection) DriverManager.getConnection(config.get("URL"),
					config.get("USER"), config.get("PASS"));
			PreparedStatement st = null;
			st = con.prepareStatement("insert into addapi(name,pname,link,des,img,cat,photo) values (?,?,?,?,?,?,?)");
			st.setString(1, name);
			st.setString(2, pname);
			st.setString(3, link);
			st.setString(4, des);
			st.setString(5, imn);
			st.setString(6, cat);
			if (inputStream != null) {
				st.setBlob(7, inputStream);
			}
			st.executeUpdate();
			st.close();
			out.println("<br><br><br><br><html><body bgcolor='#FF9900'><center><h2 style='color:#ffffff'>API ADDED SUCCESSFULLY</h2></center></body></html>");
			response.setHeader("Refresh", "1; URL=addapi.jsp");

		} catch (Exception e) {
			out.println(e);
		}

	}

}
