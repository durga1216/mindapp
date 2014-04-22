package com.roobi.pulpy;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class FirstAuthPulpy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public FirstAuthPulpy() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   	 response.setHeader("Content-Type","text/html; charset=UTF-8");

	   	 Connection con=null;  
	      PrintWriter out=response.getWriter();
	      String appname=request.getParameter("app1"); String descr=request.getParameter("descr"); String authen=request.getParameter("authen");
	      String select1=request.getParameter("select1"); String select2=request.getParameter("select2");

	      String b1=request.getParameter("b1");String b2=request.getParameter("b2");
	      String b3=request.getParameter("b3");String b4=request.getParameter("b4");
		  String a1=request.getParameter("a1");String a2=request.getParameter("a2");
		  String cname=request.getParameter("cname"); String ckey=request.getParameter("ckey"); String csecname=request.getParameter("csecname");
		  String cseckey=request.getParameter("cseckey");String sname=request.getParameter("sname"); String svalue=request.getParameter("svalue");
		  String aurl=request.getParameter("aurl"); String tokenurl=request.getParameter("tokenurl"); String tlabel=request.getParameter("tlabel");
		  String treplace=request.getParameter("treplace");String el=request.getParameter("el"); String ev=request.getParameter("ev");
		  try{
			  Class.forName("com.mysql.jdbc.Driver").newInstance();

			  String url = "jdbc:mysql://127.6.250.130:3306/mpulpy";
	            final String USER = "adminPQ1iFfN";
	            final String PASS = "J5JhBL-XC9NG";

	            con = (Connection) DriverManager.getConnection(url,USER,PASS);
	             PreparedStatement st=null;
				 st=con.prepareStatement("insert into authen(appname,descr,auth,rf,rmethod,a1,a2,b1,b2,b3,b4,cname,ckey,csecname,cseckey,sname,svalue,aurl,tokenurl,tlabel,treplace,el,ev) values ('"+appname+"','"+descr+"','"+authen+"','"+select1+"','"+select2+"','"+a1+"','"+a2+"','"+b1+"','"+b2+"','"+b3+"','"+b4+"','"+cname+"','"+ckey+"','"+csecname+"','"+cseckey+"','"+sname+"','"+svalue+"','"+aurl+"','"+tokenurl+"','"+tlabel+"','"+treplace+"','"+el+"','"+ev+"')");
				 st.executeUpdate();
out.println(con.isReadOnly());				 
			     st.close();
			     out.println("insert sucess");
			    st=con.prepareStatement("SELECT * From authen ORDER BY ID DESC LIMIT 1");
		         ResultSet rs = st.executeQuery();
		         while(rs.next()){
	   	         String id=rs.getString("id");
	   	         String authen1=rs.getString("auth");

	   	         HttpSession session=request.getSession(true);
	             session.setAttribute("id", id);
	             if("No Auth".equals(authen1) || "Basic Auth".equals(authen1) || "API keys".equals(authen1)){
	            	 
	                out.println("id:"+id);
	             out.println("<html><h2><center><font color='green'>Processing...</font></center></h2><html>");
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
	            	 if(sname1.equals(null))
	            		    response.sendRedirect(aurl+"?redirect_uri=https://mind-inputs.rhcloud.com/OauthCallBackServlet&response_type=code&client_id="+ckey1);
	            		    else
	            		    response.sendRedirect(aurl+"?redirect_uri=https://mind-inputs.rhcloud.com/OauthCallBackServlet&response_type=code&client_id="+ckey1+"&"+sname1+"="+svalue1);

	            	 
	            	 
	             }
		         }
		  }
		  catch(Exception e){
			  out.println(e);
		  }
	}

}
