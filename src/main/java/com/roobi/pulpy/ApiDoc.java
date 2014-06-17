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
public class ApiDoc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApiDoc() {
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
        out.println("<style>h2{margin-right:150px;color:#ffffff;}input[type='text']{ padding:7px;text-align:left;text-weight:bold;width:200px;color:#FF9900;font-weight:bold;}select,th,td{ padding:7px;text-align:left;text-weight:bold;width:250px;color:#FF9900;font-weight:bold;}input[type='submit']{color:#FFFFFF;background-color:#FF9900;border:solid 2px;border-radius:20px;padding:10px;width:120px;height:40px;font-family:verdana;font-size:17px;margin-left:50px;}</style>");
		 out.println("<html><body bgcolor='#FF9900'><br><center><h2>Enter Your APP_ID</h2><br><form action='EditPulpy' method='post'>"
			 		+ "<input type='text' name='usrid'>");
		
		    out.println("</select><input type='submit' value='submit'></form>");

	       

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
		out.println("<style>h2{margin-right:150px;color:#ffffff;}input[type='text']{ padding:7px;text-align:left;text-weight:bold;width:200px;color:#FF9900;font-weight:bold;}select,th,td{ padding:7px;text-align:left;text-weight:bold;width:250px;color:#FF9900;font-weight:bold;}input[type='submit']{color:#FFFFFF;background-color:#FF9900;border:solid 2px;border-radius:20px;padding:10px;width:120px;height:40px;font-family:verdana;font-size:17px;margin-left:50px;}</style>");
		 out.println("<html><body bgcolor='#FF9900'><br><center><h2>MPulpy Documentation</h2><br><br><center><h2>Enter Your APP_ID</h2><br><form action='ApiDoc' method='post'>"
			 		+ "<input type='text' name='usrid'>");
			 
			    out.println("</select><input type='submit' value='check'></form>");

		String id=request.getParameter("usrid");
		 try{
			    Class.forName("com.mysql.jdbc.Driver").newInstance();

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
		            out.println("<form");
		            out.println("<table align='center' bgcolor='white' border='0' bordercolor='#000000' style='width:500px;'>");
		            out.println("<tr><th>App_id</th><th>"+apppid+"</th><tr>");
		            out.println("<tr><td>App_name</td><td>"+appname1+"</td><tr>");
		            out.println("<tr><td>Auth_type</td><td>"+authen1+"</td><tr>");
		            out.println("<tr><td>URL for ClientSidehttps:</td><td>mindapp-pulpy.rhcloud.com/AuthXmlPulpy</td><tr>");
		            if(!ak1.equals("")&&!ak1.equals("null")){
		            out.println("<tr><td>Api_label</td><td>"+ak1+"</td><tr>");
		            out.println("<tr><td>Api_key</td><td>"+ak2+"</td><tr>");}
		            out.println("<tr><td>Request_method</td><td>"+rm1+"</td><tr>");
		            out.println("<tr><td>Response_Format</td><td>"+resf1+"</td><tr>");
		            out.println("<tr><td>End_Url</td><td>"+endurl1+"</td><tr>");
		            if(!pa1.equals("")&&!pa1.equals("null")){
		            out.println("<tr><td>param_1_label</td><td>"+pa1+"></td></tr>");
		            out.println("<tr><td>param_1_value</td><td>"+pva1+"></td></tr>");}
		            if(!pa2.equals("")&&!pa2.equals("null")){
			            out.println("<tr><td>param_2_label</td><td>"+pa2+"></td></tr>");
			            out.println("<tr><td>param_2_value</td><td>"+pva2+"></td></tr>");}
		            if(!pa3.equals("")&&!pa3.equals("null")){
			            out.println("<tr><td>param_3_label</td><td>"+pa3+"></td></tr>");
			            out.println("<tr><td>param_3_value</td><td>"+pva3+"></td></tr>");}
		            if(!pa4.equals("")&&!pa4.equals("null")){
			            out.println("<tr><td>param_4_label</td><td>"+pa4+"></td></tr>");
			            out.println("<tr><td>param_4_value</td><td>"+pva4+"></td></tr>");}
		            if(!pa5.equals("")&&!pa5.equals("null")){
			            out.println("<tr><td>param_5_label</td><td>"+pa5+"></td></tr>");
			            out.println("<tr><td>param_5_value</td><td>"+pva5+"></td></tr>");}
		            if(!pa6.equals("")&&!pa6.equals("null")){
			            out.println("<tr><td>param_6_label</td><td>"+pa6+"></td></tr>");
			            out.println("<tr><td>param_6_value</td><td>"+pva6+"></td></tr>");}
		            if(!pa7.equals("")&&!pa7.equals("null")){
			            out.println("<tr><td>param_7_label</td><td>"+pa7+"></td></tr>");
			            out.println("<tr><td>param_7_value</td><td>"+pva7+"></td></tr>");}
		            if(!pa8.equals("")&&!pa8.equals("null")){
			            out.println("<tr><td>param_8_label</td><td>"+pa8+"></td></tr>");
			            out.println("<tr><td>param_8_value</td><td>"+pva8+"></td></tr>");}
		            if(!xr.equals("")&&!xr.equals("null")){
		            out.println("<tr><td>xml_Parant_tag</td><td>"+xr+"></td></tr>");}
		            if(!x1.equals("")&&!x1.equals("null")){
			            out.println("<tr><td>xml_1_label</td><td>"+x1+"></td></tr>");
			            out.println("<tr><td>xml_1_value</td><td>"+xv1+"></td></tr>");}
		            if(!x2.equals("")&&!x2.equals("null")){
			            out.println("<tr><td>xml_2_label</td><td>"+x2+"></td></tr>");
			            out.println("<tr><td>xml_2_value</td><td>"+xv2+"></td></tr>");}
		            if(!x3.equals("")&&!x3.equals("null")){
			            out.println("<tr><td>xml_3_label</td><td>"+x3+"></td></tr>");
			            out.println("<tr><td>xml_3_value</td><td>"+xv3+"></td></tr>");}
		            if(!x4.equals("")&&!x4.equals("null")){
			            out.println("<tr><td>xml_4_label</td><td>"+x4+"></td></tr>");
			            out.println("<tr><td>xml_4_value</td><td>"+xv4+"></td></tr>");}
		            if(!x5.equals("")&&!x5.equals("null")){
			            out.println("<tr><td>xml_5_label</td><td>"+x5+"></td></tr>");
			            out.println("<tr><td>xml_5_value</td><td>"+xv5+"></td></tr>");}
		            if(!x6.equals("")&&!x6.equals("null")){
			            out.println("<tr><td>xml_6_label</td><td>"+x6+"></td></tr>");
			            out.println("<tr><td>xml_6_value</td><td>"+xv6+"></td></tr>");}
		            if(!x7.equals("")&&!x7.equals("null")){
			            out.println("<tr><td>xml_7_label</td><td>"+x7+"></td></tr>");
			            out.println("<tr><td>xml_7_value</td><td>"+xv7+"></td></tr>");}
		            if(!x8.equals("")&&!x8.equals("null")){
			            out.println("<tr><td>xml_8_label</td><td>"+x8+"></td></tr>");
			            out.println("<tr><td>xml_8_value</td><td>"+xv8+"></td></tr>");}
		            if(!x9.equals("")&&!x9.equals("null")){
			            out.println("<tr><td>xml_9_label</td><td>"+x9+"></td></tr>");
			            out.println("<tr><td>xml_9_value</td><td>"+xv9+"></td></tr>");}
		            if(!x10.equals("")&&!x10.equals("null")){
			            out.println("<tr><td>xml_10_label</td><td>"+x10+"></td></tr>");
			            out.println("<tr><td>xml_10_value</td><td>"+xv10+"></td></tr>");}
		           out.println("</table>");
		            out.println("<br><br><input style='width:150px;height:50px;'type='submit' name='edt' value='Done Editing'></form>");
		           
		            
		rs.close();
		        }
	
		 }
	catch(Exception e)
	{
		}
	
	
	}

}
