package com.roobi.pulpy;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mindots.util.Utils;

/**
 * Servlet implementation class PreThrdXmlPulpy
 */
@WebServlet("/PreThrdXmlPulpy")
public class PreThrdXmlPulpy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreThrdXmlPulpy() {
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
		HttpSession session=request.getSession(true);
		String id=(String) session.getAttribute("id");
		String appid1=(String) session.getAttribute("appid1");
		String txr=request.getParameter("txrv");
			String tx1=request.getParameter("tx1");String txv1=request.getParameter("txv1");
			String tx2=request.getParameter("tx2");String txv2=request.getParameter("txv2");
			String tx3=request.getParameter("tx3");String txv3=request.getParameter("txv3");
			String tx4=request.getParameter("tx4");String txv4=request.getParameter("txv4");
			String tx5=request.getParameter("tx5");String txv5=request.getParameter("txv5");
			String tx6=request.getParameter("tx6");String txv6=request.getParameter("txv6");
			String tx7=request.getParameter("tx7");String txv7=request.getParameter("txv7");
			String tx8=request.getParameter("tx8");String txv8=request.getParameter("txv8");
			String tx9=request.getParameter("tx9");String txv9=request.getParameter("txv9");
			String tx10=request.getParameter("tx10");String txv10=request.getParameter("txv10");
			String tx11=request.getParameter("tx11");String txv11=request.getParameter("txv11");
			String tx12=request.getParameter("tx12");String txv12=request.getParameter("txv12");
			String tx13=request.getParameter("tx13");String txv13=request.getParameter("txv13");
			String tx14=request.getParameter("tx14");String txv14=request.getParameter("txv14");
			String tx15=request.getParameter("tx15");String txv15=request.getParameter("txv15");
			String tx16=request.getParameter("tx16");String txv16=request.getParameter("txv16");
			String tx17=request.getParameter("tx17");String txv17=request.getParameter("txv17");
			String tx18=request.getParameter("tx18");String txv18=request.getParameter("txv18");
			String tx19=request.getParameter("tx19");String txv19=request.getParameter("txv19");
			String tx20=request.getParameter("tx20");String txv20=request.getParameter("txv20");
		
		Connection con=null;
    	 try {
    		 Map<String, String> config = Utils.getConfigFromFile(getServletContext(), "config.properties");
             Class.forName("com.mysql.jdbc.Driver").newInstance();
	             con = (Connection) DriverManager.getConnection(config.get("URL"),config.get("USER"),config.get("PASS"));
             PreparedStatement st=con.prepareStatement("insert into prethrdxml(id,appid,txr,tx1,txv1,tx2,txv2,tx3,txv3,tx4,txv4,tx5,txv5,tx6,txv6,tx7,txv7,tx8,txv8,tx9,txv9,tx10,txv10,tx11,txv11,tx12,txv12,tx13,txv13,tx14,txv14,tx15,txv15,tx16,txv16,tx17,txv17,tx18,txv18,tx19,txv19,tx20,txv20) values ('"+id+"','"+appid1+"','"+txr+"','"+tx1+"','"+txv1+"','"+tx2+"','"+txv2+"','"+tx3+"','"+txv3+"','"+tx4+"','"+txv4+"','"+tx5+"','"+txv5+"','"+tx6+"','"+txv6+"','"+tx7+"','"+txv7+"','"+tx8+"','"+txv8+"','"+tx9+"','"+txv9+"','"+tx10+"','"+txv10+"','"+tx11+"','"+txv11+"','"+tx12+"','"+txv12+"','"+tx13+"','"+txv13+"','"+tx14+"','"+txv14+"','"+tx15+"','"+txv15+"','"+tx16+"','"+txv16+"','"+tx17+"','"+txv17+"','"+tx18+"','"+txv18+"','"+tx19+"','"+txv19+"','"+tx20+"','"+txv20+"')");                
             st.executeUpdate();
             st.close();
           
             RequestDispatcher disp = getServletContext().getRequestDispatcher("/mashup.jsp");
             disp.forward( request, response );  
    	 }
    	 catch(Exception e){out.println(e);}
}

}
