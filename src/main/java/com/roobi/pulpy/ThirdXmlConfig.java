package com.roobi.pulpy;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mindots.util.Utils;

public class ThirdXmlConfig extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public ThirdXmlConfig() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Map<String, String> config = Utils.getConfigFromFile(getServletContext(), "config.properties");
	   	 response.setHeader("Content-Type","text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession(true);
		HttpSession session4=request.getSession(true);
		String id=(String) session.getAttribute("id");
		String appid=(String) session.getAttribute("appid");
		String submit=request.getParameter("submit");
		String thrdroot=request.getParameter("thrdroot"); String thrdparent=request.getParameter("thrdparent");
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
		String tx21=request.getParameter("tx21");String txv21=request.getParameter("txv21");
		String tx22=request.getParameter("tx22");String txv22=request.getParameter("txv22");
		String tx23=request.getParameter("tx23");String txv23=request.getParameter("txv23");
		String tx24=request.getParameter("tx24");String txv24=request.getParameter("txv24");
		String tx25=request.getParameter("tx25");String txv25=request.getParameter("txv25");
		String tx26=request.getParameter("tx26");String txv26=request.getParameter("txv26");
		String tx27=request.getParameter("tx27");String txv27=request.getParameter("txv27");
		String tx28=request.getParameter("tx28");String txv28=request.getParameter("txv28");
		String tx29=request.getParameter("tx29");String txv29=request.getParameter("txv29");
		String tx30=request.getParameter("tx30");String txv30=request.getParameter("txv30");
		session4.setAttribute("thrdroot",thrdroot);session4.setAttribute("thrdparent",thrdparent);
		session4.setAttribute("tx1",tx1);session4.setAttribute("txv1",txv1);
	      session4.setAttribute("tx2",tx2);session4.setAttribute("txv2",txv2);
	      session4.setAttribute("tx3",tx3);session4.setAttribute("txv3",txv3);
	      session4.setAttribute("tx4",tx4);session4.setAttribute("txv4",txv4);
	      session4.setAttribute("tx5",tx5);session4.setAttribute("txv5",txv5);
	      session4.setAttribute("tx6",tx6);session4.setAttribute("txv6",txv6);
	      session4.setAttribute("tx7",tx7);session4.setAttribute("txv7",txv7);
	      session4.setAttribute("tx8",tx8);session4.setAttribute("txv8",txv8);
	      session4.setAttribute("tx9",tx9);session4.setAttribute("txv9",txv9);
	      session4.setAttribute("tx10",tx10);session4.setAttribute("txv10",txv10);
	      session4.setAttribute("tx11",tx11);session4.setAttribute("txv11",txv11);
	      session4.setAttribute("tx12",tx12);session4.setAttribute("txv12",txv12);
	      session4.setAttribute("tx13",tx13);session4.setAttribute("txv13",txv13);
	      session4.setAttribute("tx14",tx14);session4.setAttribute("txv14",txv14);
	      session4.setAttribute("tx15",tx15);session4.setAttribute("txv15",txv15);
         Connection con=null;
        	 try {
                 Class.forName("com.mysql.jdbc.Driver").newInstance();
                 con = (Connection) DriverManager.getConnection(config.get("URL"),config.get("USER"),config.get("PASS"));
                 PreparedStatement st=con.prepareStatement("insert into thrdxmlconfig(id,appid,thrdroot,thrdparent,tx1,txv1,tx2,txv2,tx3,txv3,tx4,txv4,tx5,txv5,tx6,txv6,tx7,txv7,tx8,txv8,tx9,txv9,tx10,txv10,tx11,txv11,tx12,txv12,tx13,txv13,tx14,txv14,tx15,txv15,tx16,txv16,tx17,txv17,tx18,txv18,tx19,txv19,tx20,txv20,tx21,txv21,tx22,txv22,tx23,txv23,tx24,txv24,tx25,txv25,tx26,txv26,tx27,txv27,tx28,txv28,tx29,txv29,tx30,txv30) values ('"+id+"','"+appid+"','"+thrdroot+"','"+thrdparent+"','"+tx1+"','"+txv1+"','"+tx2+"','"+txv2+"','"+tx3+"','"+txv3+"','"+tx4+"','"+txv4+"','"+tx5+"','"+txv5+"','"+tx6+"','"+txv6+"','"+tx7+"','"+txv7+"','"+tx8+"','"+txv8+"','"+tx9+"','"+txv9+"','"+tx10+"','"+txv10+"','"+tx11+"','"+txv11+"','"+tx12+"','"+txv12+"','"+tx13+"','"+txv13+"','"+tx14+"','"+txv14+"','"+tx15+"','"+txv15+"','"+tx16+"','"+txv16+"','"+tx17+"','"+txv17+"','"+tx18+"','"+txv18+"','"+tx19+"','"+txv19+"','"+tx20+"','"+txv20+"','"+tx21+"','"+txv21+"','"+tx22+"','"+txv22+"','"+tx23+"','"+txv23+"','"+tx24+"','"+txv24+"','"+tx25+"','"+txv25+"','"+tx26+"','"+txv26+"','"+tx27+"','"+txv27+"','"+tx28+"','"+txv28+"','"+tx29+"','"+txv29+"','"+tx30+"','"+txv30+"')");                
                 st.executeUpdate();
                 st.close();
                 st=con.prepareStatement("SELECT * FROM authen1 t1 JOIN config t2 ON t1.appid = t2.appid JOIN thirdconfig t3 on t1.appid=t3.appid WHERE t1.appid=?");
                 st.setString(1, appid);
           
                 ResultSet rs = st.executeQuery();
                 while(rs.next()){
                     out.println("<h2><center><font color='green'>Processing...</font></center></h3>");
                     if(submit.equals("Continue"))
                    response.setHeader("Refresh", "1; URL=fourth_config.jsp");
                     else if(submit.equals("Finish")){
        	     		    RequestDispatcher disp = getServletContext().getRequestDispatcher("/final.jsp");
                        disp.forward( request, response );    }  
                   }}
         catch(Exception e){}
		
		
	}

}
