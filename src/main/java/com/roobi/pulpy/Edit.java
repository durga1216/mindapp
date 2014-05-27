package com.roobi.pulpy;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mindots.util.Utils;

/**
 * Servlet implementation class Edit
 */
@WebServlet("/Edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Edit() {
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
		PrintWriter out=response.getWriter();
	   	 response.setHeader("Content-Type","text/html;charset=UTF-8");
		 Map<String, String> config = Utils.getConfigFromFile(getServletContext(), "config.properties");
		 String id=request.getParameter("id");
String partag=request.getParameter("partag");
String p1=request.getParameter("p1");  String pv1=request.getParameter("pv1"); String p2=request.getParameter("p2"); String pv2=request.getParameter("pv2");
String p3=request.getParameter("p3");  String pv3=request.getParameter("pv3"); String p4=request.getParameter("p4"); String pv4=request.getParameter("pv4");
String p5=request.getParameter("p5");  String pv5=request.getParameter("pv5"); String p6=request.getParameter("p6"); String pv6=request.getParameter("pv6");
String p7=request.getParameter("p7");  String pv7=request.getParameter("pv7"); String p8=request.getParameter("p8"); String pv8=request.getParameter("pv8");
String x1=request.getParameter("x1");  String xv1=request.getParameter("xv1"); String x2=request.getParameter("x2"); String xv2=request.getParameter("xv2");
String x3=request.getParameter("x3");  String xv3=request.getParameter("xv3"); String x4=request.getParameter("x4"); String xv4=request.getParameter("xv4");
String x5=request.getParameter("x5");  String xv5=request.getParameter("xv5"); String x6=request.getParameter("x6"); String xv6=request.getParameter("xv6");
String x7=request.getParameter("x7");  String xv7=request.getParameter("xv7"); String x8=request.getParameter("x8"); String xv8=request.getParameter("xv8");
String x9=request.getParameter("x9");  String xv9=request.getParameter("xv9"); String x10=request.getParameter("x10"); String xv10=request.getParameter("xv10");

Connection con=null;
	 try {
       Class.forName("com.mysql.jdbc.Driver").newInstance();
       con = (Connection) DriverManager.getConnection(config.get("URL"),config.get("USER"),config.get("PASS"));
       PreparedStatement st=con.prepareStatement("update config,xmlconfig set config.p1='"+p1+"',config.p2='"+p2+"',config.p3='"+p3+"',config.p4='"+p4+"',config.p5='"+p5+"',config.p6='"+p6+"',config.p7='"+p7+"',config.p8='"+p8+"',config.pv1='"+pv1+"',config.pv2='"+pv2+"',config.pv3='"+pv3+"',config.pv4='"+pv4+"',config.pv5='"+pv5+"',config.pv6='"+pv6+"',config.pv7='"+pv7+"',config.pv8='"+pv8+"',xmlconfig.x1='"+x1+"',xmlconfig.x2='"+x2+"',xmlconfig.x3='"+x3+"',xmlconfig.x4='"+x4+"',xmlconfig.x5='"+x5+"',xmlconfig.x6='"+x6+"',xmlconfig.x7='"+x7+"',xmlconfig.x8='"+x8+"',xmlconfig.x9='"+x9+"',xmlconfig.x10='"+x10+"',xmlconfig.xv1='"+xv1+"',xmlconfig.xv2='"+xv2+"',xmlconfig.xv3='"+xv3+"',xmlconfig.xv4='"+xv4+"',xmlconfig.xv5='"+xv5+"',xmlconfig.xv6='"+xv6+"',xmlconfig.xv7='"+xv7+"',xmlconfig.xv8='"+xv8+"',xmlconfig.xv9='"+xv9+"',xmlconfig.xv10='"+xv10+"',xmlconfig.xr='"+partag+"' where config.appid=xmlconfig.appid and config.appid='"+id+"';");                
       st.executeUpdate();
       st.close();
       out.println("<html><body bgcolor='#FF9900'><br><br><br><br><h2 style='color:#ffffff;'><center>updated successfully</center></h2></body></html>");
       String ed=request.getParameter("edt");
       if(ed.equals("Done"))
       response.setHeader("Refresh", "1; URL=final.jsp");
       else
       response.setHeader("Refresh", "1; URL=logsucess.jsp");
	 }
	 catch(Exception e)
	 {
		 out.println(e);
		 
	 }
	}

}
