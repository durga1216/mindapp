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
 * Servlet implementation class EditPulpy
 */
@WebServlet("/EditPulpy")
public class EditPulpy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPulpy() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		response.setHeader("Content-Type","text/html;charset=UTF-8");
		Map<String, String> config = Utils.getConfigFromFile(getServletContext(), "config.properties");
		 Connection con1=null;
		 out.println("<a style='color:#ffffff;margin-left:1250px;font-size:22px;' href='logsucess.jsp'>Back</a></div>");
        out.println("<style>h2{margin-right:150px;color:#ffffff;}option{font-size:22px;}select,th,td,input[type='text']{ padding:7px;text-align:left;text-weight:bold;width:250px;color:#FF9900;font-weight:bold;}input[type='submit']{color:#FFFFFF;background-color:#FF9900;border:solid 2px;border-radius:20px;padding:10px;width:120px;height:40px;font-family:verdana;font-size:17px;margin-left:50px;}</style>");
		 out.println("<html><body bgcolor='#FF9900'><br><center><h2>Enter Your APP_ID</h2><br><form action='EditPulpy' method='post'>"
		 		+ "<select name='usrid'><option value='dummy'>***Choose Your APP_ID Here***</option>");
		 HttpSession session=request.getSession(true);
		  String id1=(String) session.getAttribute("id");
		  try{
			    Class.forName("com.mysql.jdbc.Driver").newInstance();
	        con1 = (Connection) DriverManager.getConnection(config.get("URL"),config.get("USER"),config.get("PASS"));

		    PreparedStatement st1=con1.prepareStatement("SELECT appid FROM authen1 WHERE id=?");
		    st1.setString(1,id1);
		    ResultSet rs1 = st1.executeQuery();
		    while(rs1.next()){
	        	String ap=rs1.getString("appid");
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
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		response.setHeader("Content-Type","text/html;charset=UTF-8");
		Map<String, String> config = Utils.getConfigFromFile(getServletContext(), "config.properties");
		 Connection con=null;
		 Connection con1=null;
		 out.println("<a style='color:#ffffff;margin-left:1250px;font-size:22px;' href='logsucess.jsp'>Back</a></div>");
		out.println("<style>h2{margin-right:150px;color:#ffffff;}option{font-size:22px;}select,th,td,input[type='text']{ padding:7px;text-align:left;text-weight:bold;width:250px;color:#FF9900;font-weight:bold;}input[type='submit']{color:#FFFFFF;background-color:#FF9900;border:solid 2px;border-radius:20px;padding:10px;width:120px;height:40px;font-family:verdana;font-size:17px;margin-left:50px;}</style>");
		 out.println("<html><body bgcolor='#FF9900'><br><center><h2>Enter Your APP_ID</h2><br><form action='EditPulpy' method='post'>"
			 		+ "<select name='usrid'><option value='dummy'>***Choose Your APP_ID Here***</option>");
			 HttpSession session=request.getSession(true);
			  String id1=(String) session.getAttribute("id");
			  try{
				    Class.forName("com.mysql.jdbc.Driver").newInstance();
		        con1 = (Connection) DriverManager.getConnection(config.get("URL"),config.get("USER"),config.get("PASS"));

			    PreparedStatement st1=con1.prepareStatement("SELECT appid FROM authen1 WHERE id=?");
			    st1.setString(1,id1);
			    ResultSet rs1 = st1.executeQuery();
			    while(rs1.next()){
		        	String ap=rs1.getString("appid");
		        out.println("<option value='"+ap+"'>"+ap+"</option>");
		        
		        }
			    out.println("</select><input type='submit' value='submit'></form>");

		        }

		 catch(Exception e)
		 {
			 
		 }
		String id=request.getParameter("usrid");
		 try{
		        con = (Connection) DriverManager.getConnection(config.get("URL"),config.get("USER"),config.get("PASS"));

			    PreparedStatement st=con.prepareStatement("SELECT * FROM authen1 t1 JOIN config t2 ON t1.appid = t2.appid JOIN xmlconfig t3 ON t1.appid=t3.appid  WHERE t1.appid=?");
			    st.setString(1,id);

		        ResultSet rs = st.executeQuery();
		        while(rs.next()){ // retrieve data from Database and join two tables namely(config&xmlconfig)
		        	String apppid=rs.getString("appid");

		        	 String ak2=rs.getString("a2");String appname1=rs.getString("appname");
		             String authen1=rs.getString("auth");String ak1=rs.getString("a1");
		        	String pa1=rs.getString("p1");String pva1=rs.getString("pv1");
		            String pa2=rs.getString("p2");String pva2=rs.getString("pv2");
		            String pa3=rs.getString("p3");String pva3=rs.getString("pv3");
		            String pa4=rs.getString("p4");String pva4=rs.getString("pv4");
		            String pa5=rs.getString("p5");String pva5=rs.getString("pv5");
		            String pa6=rs.getString("p6");String pva6=rs.getString("pv6");
		            String pa7=rs.getString("p7");String pva7=rs.getString("pv7");
		            String pa8=rs.getString("p8");String pva8=rs.getString("pv8");
		            String pa9=rs.getString("p9");String pva9=rs.getString("pv9");
		            String pa10=rs.getString("p10");String pva10=rs.getString("pv10");
		            String rm1=rs.getString("rm");
		        	String resf1=rs.getString("resf");String endurl1=rs.getString("endurl");
		            String xr=rs.getString("xr");String xrv=rs.getString("xrv");		            
		            String x1=rs.getString("x1"); String xv1=rs.getString("xv1");String x2=rs.getString("x2"); String xv2=rs.getString("xv2");
		            String x3=rs.getString("x3"); String xv3=rs.getString("xv3");String x4=rs.getString("x4"); String xv4=rs.getString("xv4");
		            String x5=rs.getString("x5"); String xv5=rs.getString("xv5");String x6=rs.getString("x6"); String xv6=rs.getString("xv6");
		            String x7=rs.getString("x7"); String xv7=rs.getString("xv7");String x8=rs.getString("x8"); String xv8=rs.getString("xv8");
		            String x9=rs.getString("x9"); String xv9=rs.getString("xv9");String x10=rs.getString("x10"); String xv10=rs.getString("xv10");
		            out.println("<form action='Edit' method='post'>");
		            out.println("<table align='center' bgcolor='white' border='0' bordercolor='#000000' style='width:500px;'>");
		            out.println("<tr><th>App_id</th><th><input type='text' name='id' value="+apppid+" readonly></th><tr>");
		            out.println("<tr><td>App_name</td><td>"+appname1+"</td><tr>");
		            out.println("<tr><td>Auth_type</td><td>"+authen1+"</td><tr>");
		            out.println("<tr><td>Api_label</td><td>"+ak1+"</td><tr>");
		            out.println("<tr><td>Api_key</td><td>"+ak2+"</td><tr>");
		            out.println("<tr><td>Request_method</td><td>"+rm1+"</td><tr>");
		            out.println("<tr><td>Response_Format</td><td>"+resf1+"</td><tr>");
		            out.println("<tr><td>End_Url</td><td>"+endurl1+"</td><tr>");
		            out.println("<tr><td>param_1_label</td><td><input type='text' name='p1' value="+pa1+"></td></tr>");
		            out.println("<tr><td>param_1_value</td><td><input type='text' name='pv1' value="+pva1+"></td></tr>");
		            out.println("<tr><td>param_2_label</td><td><input type='text' name='p2' value="+pa2+"></td></tr>");
		            out.println("<tr><td>param_2_value</td><td><input type='text' name='pv2' value="+pva2+"></td></tr>");
		            out.println("<tr><td>param_3_label</td><td><input type='text' name='p3' value="+pa3+"></td></tr>");
		            out.println("<tr><td>param_3_value</td><td><input type='text' name='pv3' value="+pva3+"></td></tr>");
		            out.println("<tr><td>param_4_label</td><td><input type='text' name='p4' value="+pa4+"></td></tr>");
		            out.println("<tr><td>param_4_value</td><td><input type='text' name='pv4' value="+pva4+"></td></tr>");
		            out.println("<tr><td>param_5_label</td><td><input type='text' name='p5' value="+pa5+"></td></tr>");
		            out.println("<tr><td>param_5_value</td><td><input type='text' name='pv5' value="+pva5+"></td></tr>");
		            out.println("<tr><td>param_6_label</td><td><input type='text' name='p6' value="+pa6+"></td></tr>");
		            out.println("<tr><td>param_6_value</td><td><input type='text' name='pv6' value="+pva6+"></td></tr>");
		            out.println("<tr><td>param_7_label</td><td><input type='text' name='p7' value="+pa7+"></td></tr>");
		            out.println("<tr><td>param_7_value</td><td><input type='text' name='pv7' value="+pva7+"></td></tr>");
		            out.println("<tr><td>xml_Parant_tag</td><td><input type='text' name='partag' value="+xr+"></td></tr>");
		            out.println("<tr><td>xml_1_label</td><td><input type='text' name='x1' value="+x1+"></td></tr>");
		            out.println("<tr><td>xml_1_value</td><td><input type='text' name='xv1' value="+xv1+"></td></tr>");
		            out.println("<tr><td>xml_2_label</td><td><input type='text' name='x2' value="+x2+"></td></tr>");
		            out.println("<tr><td>xml_2_value</td><td><input type='text' name='xv2' value="+xv2+"></td></tr>");
		            out.println("<tr><td>xml_3_label</td><td><input type='text' name='x3' value="+x3+"></td></tr>");
		            out.println("<tr><td>xml_3_value</td><td><input type='text' name='xv3' value="+xv3+"></td></tr>");
		            out.println("<tr><td>xml_4_label</td><td><input type='text' name='x4' value="+x4+"></td></tr>");
		            out.println("<tr><td>xml_4_value</td><td><input type='text' name='xv4' value="+xv4+"></td></tr>");
		            out.println("<tr><td>xml_5_label</td><td><input type='text' name='x5' value="+x5+"></td></tr>");
		            out.println("<tr><td>xml_5_value</td><td><input type='text' name='xv5' value="+xv5+"></td></tr>");
		            out.println("<tr><td>xml_6_label</td><td><input type='text' name='x6' value="+x6+"></td></tr>");
		            out.println("<tr><td>xml_6_value</td><td><input type='text' name='xv6' value="+xv6+"></td></tr>");
		            out.println("<tr><td>xml_7_label</td><td><input type='text' name='x7' value="+x7+"></td></tr>");
		            out.println("<tr><td>xml_7_value</td><td><input type='text' name='xv7' value="+xv7+"></td></tr></table>");
		            out.println("<br><br><input style='width:150px;height:50px;'type='submit' name='edt' value='Done Editing'></form>");
		           
		            
		rs.close();
		        }
	
		 }
	catch(Exception e)
	{
		}
	
	
	}

}
