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

public class SecondXmlConfig extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public SecondXmlConfig() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
	   	 response.setHeader("Content-Type","text/html;charset=UTF-8");
		 Map<String, String> config = Utils.getConfigFromFile(getServletContext(), "config.properties");
		HttpSession session=request.getSession(true);
		HttpSession session4=request.getSession(true);
		String id=(String) session.getAttribute("id");
		String appid=(String) session.getAttribute("appid");
		String submit=request.getParameter("submit");

		String secroot=request.getParameter("secroot"); String secparent=request.getParameter("secparent");
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
		String sx21=request.getParameter("sx21");String sxv21=request.getParameter("sxv21");
		String sx22=request.getParameter("sx22");String sxv22=request.getParameter("sxv22");
		String sx23=request.getParameter("sx23");String sxv23=request.getParameter("sxv23");
		String sx24=request.getParameter("sx24");String sxv24=request.getParameter("sxv24");
		String sx25=request.getParameter("sx25");String sxv25=request.getParameter("sxv25");
		String sx26=request.getParameter("sx26");String sxv26=request.getParameter("sxv26");
		String sx27=request.getParameter("sx27");String sxv27=request.getParameter("sxv27");
		String sx28=request.getParameter("sx28");String sxv28=request.getParameter("sxv28");
		String sx29=request.getParameter("sx29");String sxv29=request.getParameter("sxv29");
		String sx30=request.getParameter("sx30");String sxv30=request.getParameter("sxv30");
		session4.setAttribute("secroot",secroot);session4.setAttribute("secparent",secparent);
		session4.setAttribute("sx1",sx1);session4.setAttribute("sxv1",sxv1);
	      session4.setAttribute("sx2",sx2);session4.setAttribute("sxv2",sxv2);
	      session4.setAttribute("sx3",sx3);session4.setAttribute("sxv3",sxv3);
	      session4.setAttribute("sx4",sx4);session4.setAttribute("sxv4",sxv4);
	      session4.setAttribute("sx5",sx5);session4.setAttribute("sxv5",sxv5);
	      session4.setAttribute("sx6",sx6);session4.setAttribute("sxv6",sxv6);
	      session4.setAttribute("sx7",sx7);session4.setAttribute("sxv7",sxv7);
	      session4.setAttribute("sx8",sx8);session4.setAttribute("sxv8",sxv8);
	      session4.setAttribute("sx9",sx9);session4.setAttribute("sxv9",sxv9);
	      session4.setAttribute("sx10",sx10);session4.setAttribute("sxv10",sxv10);
	      session4.setAttribute("sx11",sx11);session4.setAttribute("sxv11",sxv11);
	      session4.setAttribute("sx12",sx12);session4.setAttribute("sxv12",sxv12);
	      session4.setAttribute("sx13",sx13);session4.setAttribute("sxv13",sxv13);
	      session4.setAttribute("sx14",sx14);session4.setAttribute("sxv14",sxv14);
	      session4.setAttribute("sx15",sx15);session4.setAttribute("sxv15",sxv15);
		Connection con=null;
   	 try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = (Connection) DriverManager.getConnection(config.get("URL"),config.get("USER"),config.get("PASS"));
            PreparedStatement st=con.prepareStatement("insert into secxmlconfig(id,appid,secroot,secparent,sx1,sxv1,sx2,sxv2,sx3,sxv3,sx4,sxv4,sx5,sxv5,sx6,sxv6,sx7,sxv7,sx8,sxv8,sx9,sxv9,sx10,sxv10,sx11,sxv11,sx12,sxv12,sx13,sxv13,sx14,sxv14,sx15,sxv15,sx16,sxv16,sx17,sxv17,sx18,sxv18,sx19,sxv19,sx20,sxv20,sx21,sxv21,sx22,sxv22,sx23,sxv23,sx24,sxv24,sx25,sxv25,sx26,sxv26,sx27,sxv27,sx28,sxv28,sx29,sxv29,sx30,sxv30) values ('"+id+"','"+appid+"','"+secroot+"','"+secparent+"','"+sx1+"','"+sxv1+"','"+sx2+"','"+sxv2+"','"+sx3+"','"+sxv3+"','"+sx4+"','"+sxv4+"','"+sx5+"','"+sxv5+"','"+sx6+"','"+sxv6+"','"+sx7+"','"+sxv7+"','"+sx8+"','"+sxv8+"','"+sx9+"','"+sxv9+"','"+sx10+"','"+sxv10+"','"+sx11+"','"+sxv11+"','"+sx12+"','"+sxv12+"','"+sx13+"','"+sxv13+"','"+sx14+"','"+sxv14+"','"+sx15+"','"+sxv15+"','"+sx16+"','"+sxv16+"','"+sx17+"','"+sxv17+"','"+sx18+"','"+sxv18+"','"+sx19+"','"+sxv19+"','"+sx20+"','"+sxv20+"','"+sx21+"','"+sxv21+"','"+sx22+"','"+sxv22+"','"+sx23+"','"+sxv23+"','"+sx24+"','"+sxv24+"','"+sx25+"','"+sxv25+"','"+sx26+"','"+sxv26+"','"+sx27+"','"+sxv27+"','"+sx28+"','"+sxv28+"','"+sx29+"','"+sxv29+"','"+sx30+"','"+sxv30+"')");                
            st.executeUpdate();
            st.close();
            st=con.prepareStatement("SELECT * FROM secxmlconfig where appid=?");
            st.setString(1, appid);
      
            ResultSet rs = st.executeQuery();
	         while(rs.next()){
             out.println("<h2><center><font color='green'>Processing...</font></center></h3>");
             if(submit.equals("Continue"))
            response.setHeader("Refresh", "1; URL=third_config.jsp");
             else if(submit.equals("Finish")){
	     		    RequestDispatcher disp = getServletContext().getRequestDispatcher("/final.jsp");
                disp.forward( request, response );    }  
           }}
    catch(Exception e){}


	}

}
