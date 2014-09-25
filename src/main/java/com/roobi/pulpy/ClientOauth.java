package com.roobi.pulpy;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mindots.util.Utils;

public class ClientOauth extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ClientOauth() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con=null;  
	    PrintWriter out=response.getWriter();
		String appid=request.getParameter("appid");
	    String url=request.getParameter("url");
	    response.addHeader("Access-Control-Allow-Origin", "*");  	
		 Map<String, String> config = Utils.getConfigFromFile(getServletContext(), "config.properties");


	    //String appid="MP_199";
		try{
		    Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = (Connection) DriverManager.getConnection(config.get("URL"),config.get("USER"),config.get("PASS"));
		    PreparedStatement st=con.prepareStatement("SELECT * From authen1 t1 where t1.appid=?");
		    st.setString(1, appid);
	        ResultSet rs = st.executeQuery();
	        while(rs.next()){ 
	         String appid1=rs.getString("appid");
	         HttpSession session=request.getSession(true);
             session.setAttribute("id", appid1);
             
	   	     String authen1=rs.getString("auth");
	   	     String appname=rs.getString("appname");
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
           	session.setAttribute("url", url);
           	session.setAttribute("appname", appname);
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
           	 String clienturl=null;
        	 if(sname1.equals("") && el1.equals(""))
        		  clienturl=aurl1+"?redirect_uri=https://mindapp-pulpy.rhcloud.com/OauthCallBackServlet&response_type=code&client_id="+ckey1;
             else if(!sname1.equals("")&& el1.equals(""))
        		  clienturl=aurl1+"?redirect_uri=https://mindapp-pulpy.rhcloud.com/OauthCallBackServlet&response_type=code&client_id="+ckey1+"&"+sname1+"="+svalue1;
             else if(!sname1.equals("")&& !el1.equals(""))
        		  clienturl=aurl1+"?redirect_uri=https://mindapp-pulpy.rhcloud.com/OauthCallBackServlet&response_type=code&client_id="+ckey1+"&"+sname1+"="+svalue1+"&"+el1+"="+ev1;
             else if(sname1.equals("")&& !el1.equals(""))
        		  clienturl=aurl1+"?redirect_uri=https://mindapp-pulpy.rhcloud.com/OauthCallBackServlet&response_type=code&client_id="+ckey1+"&"+el1+"="+ev1;
        	 response.setContentType("text/plain");
        	 response.setCharacterEncoding("UTF-8");
             response.getWriter().print(clienturl);

	        }

	}
		catch(Exception e){}

}
}