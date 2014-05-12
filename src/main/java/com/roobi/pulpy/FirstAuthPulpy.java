package com.roobi.pulpy;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mindots.util.Utils;


public class FirstAuthPulpy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public FirstAuthPulpy() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  Connection con=null;  
		   	 response.setHeader("Content-Type","text/html;charset=UTF-8");
			 Map<String, String> config = Utils.getConfigFromFile(getServletContext(), "config.properties");
	      PrintWriter out=response.getWriter();
	      String appname=request.getParameter("app1"); String descr=request.getParameter("descr"); String authen=request.getParameter("authen");
	      String select1=request.getParameter("select1"); String select2=request.getParameter("select2");
	      HttpSession session=request.getSession(true);
		  String id=(String) session.getAttribute("id");
	      String b1=request.getParameter("b1");String b2=request.getParameter("b2");
	      String b3=request.getParameter("b3");String b4=request.getParameter("b4");
		  String a1=request.getParameter("a1");String a2=request.getParameter("a2");
		  String cname=request.getParameter("cname"); String ckey=request.getParameter("ckey"); String csecname=request.getParameter("csecname");
		  String cseckey=request.getParameter("cseckey");String sname=request.getParameter("sname"); String svalue=request.getParameter("svalue");
		  String aurl=request.getParameter("aurl"); String tokenurl=request.getParameter("tokenurl"); String tlabel=request.getParameter("tlabel");
		  String treplace=request.getParameter("treplace");String el=request.getParameter("el"); String ev=request.getParameter("ev");
          HttpSession session2 = request.getSession(true);
          session2.setAttribute("appname",appname);
          session2.setAttribute("apikey",a2);
          session2.setAttribute("apiname",a1);
          session2.setAttribute("authtype",authen);
		  try{
			  Class.forName("com.mysql.jdbc.Driver").newInstance();
			  con = (Connection) DriverManager.getConnection(config.get("URL"),config.get("USER"),config.get("PASS"));
	             PreparedStatement st=null;
				 st=con.prepareStatement("insert into authen1(id,appname,descr,auth,rf,rmethod,a1,a2,b1,b2,b3,b4,cname,ckey,csecname,cseckey,sname,svalue,aurl,tokenurl,tlabel,treplace,el,ev) values ('"+id+"','"+appname+"','"+descr+"','"+authen+"','"+select1+"','"+select2+"','"+a1+"','"+a2+"','"+b1+"','"+b2+"','"+b3+"','"+b4+"','"+cname+"','"+ckey+"','"+csecname+"','"+cseckey+"','"+sname+"','"+svalue+"','"+aurl+"','"+tokenurl+"','"+tlabel+"','"+treplace+"','"+el+"','"+ev+"')");
				 st.executeUpdate();
			     st.close();
			   
			     //out.println("insert sucess");
			     
			    st=con.prepareStatement("SELECT * From authen1 ORDER BY appid DESC LIMIT 1");
		         ResultSet rs = st.executeQuery();
		         while(rs.next()){
	   	         String id1=rs.getString("id");
	   	         String appid=rs.getString("appid");
	   	         String authen1=rs.getString("auth");
	   	      session.setAttribute("appid", appid);
	   	         
	             if("No Auth".equals(authen1) || "Basic Auth".equals(authen1) || "API keys".equals(authen1)){
	            	 
	                out.println("Your id:"+appid);
	               
	             out.println("<html><h2><center><font color='green'>Processing...</font></center></h3><html>");
    		     response.setHeader("Refresh", "1; URL=auth.jsp");
	             }
	             else if("Oauth2".equals(authen1)){
	            	 String cname1=rs.getString("cname");
	            	 String ckey1=rs.getString("ckey");
	            	 String csecname1=rs.getString("csecname");
	            	 String cseckey1=rs.getString("cseckey");
	            	 String sname1=rs.getString("sname");
	            	 String svalue1=rs.getString("svalue");
	            	 String aurl1=rs.getString("aurl");
	            	 String tokenurl1=rs.getString("tokenurl");
	            	 String tlabel1=rs.getString("tlabel");
	            	 String treplace1=rs.getString("treplace");
	            	 String el1=rs.getString("el");
	            	 String ev1=rs.getString("ev");
	            	 String rf1=rs.getString("rf");
	            	 String rmethod1=rs.getString("rmethod");
	            	    session.setAttribute("cname", cname1);
	            	    session.setAttribute("ckey", ckey1);
	            	    session.setAttribute("csecname", csecname1);
	            	    session.setAttribute("cseckey", cseckey1);
	            	    session.setAttribute("sname", sname1);
	            	    session.setAttribute("svalue", svalue1);
	            	    session.setAttribute("aurl", aurl1);
	            	    session.setAttribute("tokenurl", tokenurl1);
	            	    session.setAttribute("tlabel", tlabel1);
	            	    session.setAttribute("treplace", treplace1);
	            	    session.setAttribute("el", el1);
	            	    session.setAttribute("ev", ev1);
	            	    session.setAttribute("rf1", rf1);
	            	    session.setAttribute("rm1", rmethod1);
	            	 if(sname1.equals("") && el1.equals(""))
	            		  response.sendRedirect(aurl+"?redirect_uri=https://mindapp-pulpy.rhcloud.com/OauthCallBackServlet&response_type=code&client_id="+ckey1);
	                 else if(!sname1.equals("")&& el1.equals(""))
	            		  response.sendRedirect(aurl+"?redirect_uri=https://mindapp-pulpy.rhcloud.com/OauthCallBackServlet&response_type=code&client_id="+ckey1+"&"+sname1+"="+svalue1);
	                 else if(!sname1.equals("")&& !el1.equals(""))
	            		  response.sendRedirect(aurl+"?redirect_uri=https://mindapp-pulpy.rhcloud.com/OauthCallBackServlet&response_type=code&client_id="+ckey1+"&"+sname1+"="+svalue1+"&"+el1+"="+ev1);
	                 else if(sname1.equals("")&& !el1.equals(""))
	            		  response.sendRedirect(aurl+"?redirect_uri=https://mindapp-pulpy.rhcloud.com/OauthCallBackServlet&response_type=code&client_id="+ckey1+"&"+el1+"="+ev1);
	            	 

	            	 
	            	 
	             }
		         }
		  }
		  catch(Exception e){
			  out.println("<html><body bgcolor='#FF9900'><h2><center>You can configure only one time with the same id</h2><h3><a href='logout.jsp'>signout</a></h3></center></body></html>");
		  }
	}

}
