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
 * Servlet implementation class PreFstXmlPulpy
 */
@WebServlet("/PreFstXmlPulpy")
public class PreFstXmlPulpy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreFstXmlPulpy() {
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
		HttpSession session1=request.getSession(true);
        int appid1=(Integer)session1.getAttribute("preid");
		String sxr=request.getParameter("fxrv");
			String sx1=request.getParameter("fx1");String sxv1=request.getParameter("fxv1");
			String sx2=request.getParameter("fx2");String sxv2=request.getParameter("fxv2");
			String sx3=request.getParameter("fx3");String sxv3=request.getParameter("fxv3");
			String sx4=request.getParameter("fx4");String sxv4=request.getParameter("fxv4");
			String sx5=request.getParameter("fx5");String sxv5=request.getParameter("fxv5");
			String sx6=request.getParameter("fx6");String sxv6=request.getParameter("fxv6");
			String sx7=request.getParameter("fx7");String sxv7=request.getParameter("fxv7");
			String sx8=request.getParameter("fx8");String sxv8=request.getParameter("fxv8");
			String sx9=request.getParameter("fx9");String sxv9=request.getParameter("fxv9");
			String sx10=request.getParameter("fx10");String sxv10=request.getParameter("fxv10");
			String sx11=request.getParameter("fx11");String sxv11=request.getParameter("fxv11");
			String sx12=request.getParameter("fx12");String sxv12=request.getParameter("fxv12");
			String sx13=request.getParameter("fx13");String sxv13=request.getParameter("fxv13");
			String sx14=request.getParameter("fx14");String sxv14=request.getParameter("fxv14");
			String sx15=request.getParameter("fx15");String sxv15=request.getParameter("fxv15");
			String sx16=request.getParameter("fx16");String sxv16=request.getParameter("fxv16");
			String sx17=request.getParameter("fx17");String sxv17=request.getParameter("fxv17");
			String sx18=request.getParameter("fx18");String sxv18=request.getParameter("fxv18");
			String sx19=request.getParameter("fx19");String sxv19=request.getParameter("fxv19");
			String sx20=request.getParameter("fx20");String sxv20=request.getParameter("fxv20");
		
		Connection con=null;
    	 try {
    		 Map<String, String> config = Utils.getConfigFromFile(getServletContext(), "config.properties");
             Class.forName("com.mysql.jdbc.Driver").newInstance();
	             con = (Connection) DriverManager.getConnection(config.get("URL"),config.get("USER"),config.get("PASS"));
             PreparedStatement st=con.prepareStatement("insert into prefstxml(id,appid,fxr,fx1,fxv1,fx2,fxv2,fx3,fxv3,fx4,fxv4,fx5,fxv5,fx6,fxv6,fx7,fxv7,fx8,fxv8,fx9,fxv9,fx10,fxv10,fx11,fxv11,fx12,fxv12,fx13,fxv13,fx14,fxv14,fx15,fxv15,fx16,fxv16,fx17,fxv17,fx18,fxv18,fx19,fxv19,fx20,fxv20) values ('"+id+"','"+appid1+"','"+sxr+"','"+sx1+"','"+sxv1+"','"+sx2+"','"+sxv2+"','"+sx3+"','"+sxv3+"','"+sx4+"','"+sxv4+"','"+sx5+"','"+sxv5+"','"+sx6+"','"+sxv6+"','"+sx7+"','"+sxv7+"','"+sx8+"','"+sxv8+"','"+sx9+"','"+sxv9+"','"+sx10+"','"+sxv10+"','"+sx11+"','"+sxv11+"','"+sx12+"','"+sxv12+"','"+sx13+"','"+sxv13+"','"+sx14+"','"+sxv14+"','"+sx15+"','"+sxv15+"','"+sx16+"','"+sxv16+"','"+sx17+"','"+sxv17+"','"+sx18+"','"+sxv18+"','"+sx19+"','"+sxv19+"','"+sx20+"','"+sxv20+"')");                
             st.executeUpdate();
             st.close();
           
             RequestDispatcher disp = getServletContext().getRequestDispatcher("/prebuilt2.jsp");
             disp.forward( request, response );  
    	 }
    	 catch(Exception e){out.println(e);}
}

}
