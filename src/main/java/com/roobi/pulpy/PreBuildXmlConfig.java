package com.roobi.pulpy;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mindots.util.Utils;


public class PreBuildXmlConfig extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public PreBuildXmlConfig() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession(true);
		String id=(String) session.getAttribute("id");
		String appid=(String) session.getAttribute("appid");  //change
		String xr=(String) session.getAttribute("xr");  //change
		String x1=(String) session.getAttribute("x1");  //change
		String x2=(String) session.getAttribute("x2");  //change
		String xv1=(String) session.getAttribute("xv1");  //change
		String xv2=(String) session.getAttribute("xv2");  //change
		HttpSession session4=request.getSession(true);

		String submit=request.getParameter("submit");
	//	String xr=request.getParameter("xr");
		String xrv=request.getParameter("xrv");
	//	String x1=request.getParameter("x1");String xv1=request.getParameter("xv1");
	//	String x2=request.getParameter("x2");String xv2=request.getParameter("xv2");
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
		session4.setAttribute("appid", appid);
		session4.setAttribute("partag",xr);session4.setAttribute("roottag",xrv);
		session4.setAttribute("x1",x1);session4.setAttribute("xv1",xv1);
	      session4.setAttribute("x2",x2);session4.setAttribute("xv2",xv2);
	      session4.setAttribute("x3",x3);session4.setAttribute("xv3",xv3);
	      session4.setAttribute("x4",x4);session4.setAttribute("xv4",xv4);
	      session4.setAttribute("x5",x5);session4.setAttribute("xv5",xv5);
	      session4.setAttribute("x6",x6);session4.setAttribute("xv6",xv6);
	      session4.setAttribute("x7",x7);session4.setAttribute("xv7",xv7);
	      session4.setAttribute("x8",x8);session4.setAttribute("xv8",xv8);
	      session4.setAttribute("x9",x9);session4.setAttribute("xv9",xv9);
	      session4.setAttribute("x10",x10);session4.setAttribute("xv10",xv10);
	      session4.setAttribute("x11",x11);session4.setAttribute("xv11",xv11);
	      session4.setAttribute("x12",x12);session4.setAttribute("xv12",xv12);
	      session4.setAttribute("x13",x13);session4.setAttribute("xv13",xv13);
	      session4.setAttribute("x14",x14);session4.setAttribute("xv14",xv14);
	      session4.setAttribute("x15",x15);session4.setAttribute("xv15",xv15);
	      session4.setAttribute("x16",x16);session4.setAttribute("xv16",xv16);
	      session4.setAttribute("x17",x17);session4.setAttribute("xv17",xv17);
	      session4.setAttribute("x18",x18);session4.setAttribute("xv18",xv18);
	      session4.setAttribute("x19",x19);session4.setAttribute("xv19",xv19);
	      session4.setAttribute("x20",x20);session4.setAttribute("xv20",xv20);
	      session4.setAttribute("x21",x21);session4.setAttribute("xv21",xv21);
	      session4.setAttribute("x22",x22);session4.setAttribute("xv22",xv22);
	      session4.setAttribute("x23",x23);session4.setAttribute("xv23",xv23);
	      session4.setAttribute("x24",x24);session4.setAttribute("xv24",xv24);
	      session4.setAttribute("x25",x25);session4.setAttribute("xv25",xv25);
	      session4.setAttribute("x26",x26);session4.setAttribute("xv26",xv26);
	      session4.setAttribute("x27",x27);session4.setAttribute("xv27",xv27);
	      session4.setAttribute("x28",x28);session4.setAttribute("xv28",xv28);
	      session4.setAttribute("x29",x29);session4.setAttribute("xv29",xv29);
	      session4.setAttribute("x30",x30);session4.setAttribute("xv30",xv30);
	    
         Connection con=null;
        	 try {
        			Map<String, String> config = Utils.getConfigFromFile(getServletContext(), "config.properties");

                 Class.forName("com.mysql.jdbc.Driver").newInstance();
   	            con = (Connection) DriverManager.getConnection(config.get("URL"),config.get("USER"),config.get("PASS"));
                 PreparedStatement st=con.prepareStatement("insert into prexmlconfig(id,appid,xr,x1,xv1,x2,xv2,x3,xv3,x4,xv4,x5,xv5,x6,xv6,x7,xv7,x8,xv8,x9,xv9,x10,xv10,x11,xv11,x12,xv12,x13,xv13,x14,xv14,x15,xv15,x16,xv16,x17,xv17,x18,xv18,x19,xv19,x20,xv20,x21,xv21,x22,xv22,x23,xv23,x24,xv24,x25,xv25,x26,xv26,x27,xv27,x28,xv28,x29,xv29,x30,xv30) values ('"+id+"','"+appid+"','"+xr+"','"+x1+"','"+xv1+"','"+x2+"','"+xv2+"','"+x3+"','"+xv3+"','"+x4+"','"+xv4+"','"+x5+"','"+xv5+"','"+x6+"','"+xv6+"','"+x7+"','"+xv7+"','"+x8+"','"+xv8+"','"+x9+"','"+xv9+"','"+x10+"','"+xv10+"','"+x11+"','"+xv11+"','"+x12+"','"+xv12+"','"+x13+"','"+xv13+"','"+x14+"','"+xv14+"','"+x15+"','"+xv15+"','"+x16+"','"+xv16+"','"+x17+"','"+xv17+"','"+x18+"','"+xv18+"','"+x19+"','"+xv19+"','"+x20+"','"+xv20+"','"+x21+"','"+xv21+"','"+x22+"','"+xv22+"','"+x23+"','"+xv23+"','"+x24+"','"+xv24+"','"+x25+"','"+xv25+"','"+x26+"','"+xv26+"','"+x27+"','"+xv27+"','"+x28+"','"+xv28+"','"+x29+"','"+xv29+"','"+x30+"','"+xv30+"')");                
                 st.executeUpdate();
                 st.close();
                 out.println(appid);
                 RequestDispatcher disp = getServletContext().getRequestDispatcher("/final.jsp");
	                // set your String value in the attribute
	                 disp.forward( request, response );  
        	 }
        	 catch(Exception e){out.println(e);}
	}

}
