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
 * Servlet implementation class PreSecXmlPulpy
 */
@WebServlet("/PreSecXmlPulpy")
public class PreSecXmlPulpy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreSecXmlPulpy() {
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
		String sxr=request.getParameter("sxrv");
			String sx1=request.getParameter("sx1");String sxv1=request.getParameter("sxv1");
			String sx2=request.getParameter("sx2");String sxv2=request.getParameter("sxv2");
			String sx3=request.getParameter("sx3");String sxv3=request.getParameter("sxv3");
			String sx4=request.getParameter("sx4");String sxv4=request.getParameter("sxv4");
			String sx5=request.getParameter("sx5");String sxv5=request.getParameter("sxv5");
			String sx6=request.getParameter("sx6");String sxv6=request.getParameter("sxv6");
			String sx7=request.getParameter("sx7");String sxv7=request.getParameter("sxv7");
			String sx8=request.getParameter("sx8");String sxv8=request.getParameter("sxv8");
			String sx9=request.getParameter("sx9");String sxv9=request.getParameter("sxv9");
			String sx10=request.getParameter("sx10");String sxv10=request.getParameter("sxv10");
			String sx11=request.getParameter("sx11");String sxv11=request.getParameter("sxv11");
			String sx12=request.getParameter("sx12");String sxv12=request.getParameter("sxv12");
			String sx13=request.getParameter("sx13");String sxv13=request.getParameter("sxv13");
			String sx14=request.getParameter("sx14");String sxv14=request.getParameter("sxv14");
			String sx15=request.getParameter("sx15");String sxv15=request.getParameter("sxv15");
			String sx16=request.getParameter("sx16");String sxv16=request.getParameter("sxv16");
			String sx17=request.getParameter("sx17");String sxv17=request.getParameter("sxv17");
			String sx18=request.getParameter("sx18");String sxv18=request.getParameter("sxv18");
			String sx19=request.getParameter("sx19");String sxv19=request.getParameter("sxv19");
			String sx20=request.getParameter("sx20");String sxv20=request.getParameter("sxv20");
		
		Connection con=null;
    	 try {
    		 Map<String, String> config = Utils.getConfigFromFile(getServletContext(), "config.properties");
             Class.forName("com.mysql.jdbc.Driver").newInstance();
	             con = (Connection) DriverManager.getConnection(config.get("URL"),config.get("USER"),config.get("PASS"));
             PreparedStatement st=con.prepareStatement("insert into presecxml(id,appid,sxr,sx1,sxv1,sx2,sxv2,sx3,sxv3,sx4,sxv4,sx5,sxv5,sx6,sxv6,sx7,sxv7,sx8,sxv8,sx9,sxv9,sx10,sxv10,sx11,sxv11,sx12,sxv12,sx13,sxv13,sx14,sxv14,sx15,sxv15,sx16,sxv16,sx17,sxv17,sx18,sxv18,sx19,sxv19,sx20,sxv20) values ('"+id+"','"+appid1+"','"+sxr+"','"+sx1+"','"+sxv1+"','"+sx2+"','"+sxv2+"','"+sx3+"','"+sxv3+"','"+sx4+"','"+sxv4+"','"+sx5+"','"+sxv5+"','"+sx6+"','"+sxv6+"','"+sx7+"','"+sxv7+"','"+sx8+"','"+sxv8+"','"+sx9+"','"+sxv9+"','"+sx10+"','"+sxv10+"','"+sx11+"','"+sxv11+"','"+sx12+"','"+sxv12+"','"+sx13+"','"+sxv13+"','"+sx14+"','"+sxv14+"','"+sx15+"','"+sxv15+"','"+sx16+"','"+sxv16+"','"+sx17+"','"+sxv17+"','"+sx18+"','"+sxv18+"','"+sx19+"','"+sxv19+"','"+sx20+"','"+sxv20+"')");                
             st.executeUpdate();
             st.close();
           
             RequestDispatcher disp = getServletContext().getRequestDispatcher("/prebuilt3.jsp");
             disp.forward( request, response );  
    	 }
    	 catch(Exception e){out.println(e);}
}

}
