package com.roobi.pulpy;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class AuthPulpy1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession(true);
		String appid=(String) session.getAttribute("id");
		String xr=request.getParameter("xr"); String xrv=request.getParameter("xrv");
		String x1=request.getParameter("x1");String xv1=request.getParameter("xv1");
		String x2=request.getParameter("x2");String xv2=request.getParameter("xv2");
		String x3=request.getParameter("x3");String xv3=request.getParameter("xv3");
		String x4=request.getParameter("x4");String xv4=request.getParameter("xv4");
		String x5=request.getParameter("x5");String xv5=request.getParameter("xv5");
		String x6=request.getParameter("x6");String xv6=request.getParameter("xv6");
		String x7=request.getParameter("x7");String xv7=request.getParameter("xv7");
		String x8=request.getParameter("x8");String xv8=request.getParameter("xv8");
		String x9=request.getParameter("x9");String xv9=request.getParameter("xv9");
		String x10=request.getParameter("x10");String xv10=request.getParameter("xv10");
		String x11=request.getParameter("x11");String xv11=request.getParameter("xv11");
		String x12=request.getParameter("x12");String xv12=request.getParameter("xv12");
		String x13=request.getParameter("x13");String xv13=request.getParameter("xv13");
		String x14=request.getParameter("x14");String xv14=request.getParameter("xv14");
		String x15=request.getParameter("x15");String xv15=request.getParameter("xv15");
		String x16=request.getParameter("x16");String xv16=request.getParameter("xv16");
		String x17=request.getParameter("x17");String xv17=request.getParameter("xv17");
		String x18=request.getParameter("x18");String xv18=request.getParameter("xv18");
		String x19=request.getParameter("x19");String xv19=request.getParameter("xv19");
		String x20=request.getParameter("x20");String xv20=request.getParameter("xv20");
		String x21=request.getParameter("x21");String xv21=request.getParameter("xv21");
		String x22=request.getParameter("x22");String xv22=request.getParameter("xv22");
		String x23=request.getParameter("x23");String xv23=request.getParameter("xv23");
		String x24=request.getParameter("x24");String xv24=request.getParameter("xv24");
		String x25=request.getParameter("x25");String xv25=request.getParameter("xv25");
		String x26=request.getParameter("x26");String xv26=request.getParameter("xv26");
		String x27=request.getParameter("x27");String xv27=request.getParameter("xv27");
		String x28=request.getParameter("x28");String xv28=request.getParameter("xv28");
		String x29=request.getParameter("x29");String xv29=request.getParameter("xv29");
		String x30=request.getParameter("x30");String xv30=request.getParameter("xv30");
         Connection con=null;
        	 try {
                 Class.forName("com.mysql.jdbc.Driver").newInstance();

                 String url = "jdbc:mysql://127.6.250.130:3306/mpulpy";
                 final String USER = "adminPQ1iFfN";
                 final String PASS = "J5JhBL-XC9NG";

                 con = DriverManager.getConnection(url,USER,PASS);
                 PreparedStatement st=con.prepareStatement("insert into xmlconfig(id,xr,xrv,x1,xv1,x2,xv2,x3,xv3,x4,xv4,x5,xv5,x6,xv6,x7,xv7,x8,xv8,x9,xv9,x10,xv10,x11,xv11,x12,xv12,x13,xv13,x14,xv14,x15,xv15,x16,xv16,x17,xv17,x18,xv18,x19,xv19,x20,xv20,x21,xv21,x22,xv22,x23,xv23,x24,xv24,x25,xv25,x26,xv26,x27,xv27,x28,xv28,x29,xv29,x30,xv30) values ('"+appid+"','"+xr+"','"+xrv+"','"+x1+"','"+xv1+"','"+x2+"','"+xv2+"','"+x3+"','"+xv3+"','"+x4+"','"+xv4+"','"+x5+"','"+xv5+"','"+x6+"','"+xv6+"','"+x7+"','"+xv7+"','"+x8+"','"+xv8+"','"+x9+"','"+xv9+"','"+x10+"','"+xv10+"','"+x11+"','"+xv11+"','"+x12+"','"+xv12+"','"+x13+"','"+xv13+"','"+x14+"','"+xv14+"','"+x15+"','"+xv15+"','"+x16+"','"+xv16+"','"+x17+"','"+xv17+"','"+x18+"','"+xv18+"','"+x19+"','"+xv19+"','"+x20+"','"+xv20+"','"+x21+"','"+xv21+"','"+x22+"','"+xv22+"','"+x23+"','"+xv23+"','"+x24+"','"+xv24+"','"+x25+"','"+xv25+"','"+x26+"','"+xv26+"','"+x27+"','"+xv27+"','"+x28+"','"+xv28+"','"+x29+"','"+xv29+"','"+x30+"','"+xv30+"')");                
                 st.executeUpdate();
                 st.close();
	              out.println("<h2><center><font color='green'>Processing...</font></center></h3>");
                 response.setHeader("Refresh", "1; URL=sec_config.jsp");
                }
         catch(Exception e){}


		

	}

}
