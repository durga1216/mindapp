package com.roobi.pulpy;

import java.io.IOException;
import java.io.InputStream;
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
import javax.servlet.http.Part;

import com.mindots.util.Utils;

public class PreAuthPulpy extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PreAuthPulpy() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Map<String, String> config = Utils.getConfigFromFile(getServletContext(), "config.properties");
		HttpSession session=request.getSession(true);
		HttpSession session2=request.getSession(true);
	    String id=(String) session.getAttribute("id");
	    String appid=(String) session.getAttribute("appid");
	    session.setAttribute("appid", appid);
		String appname=(String)session.getAttribute("appname");String b1=request.getParameter("b1");String b2=request.getParameter("b2");
	    String authen=(String) session.getAttribute("authen"); 
		String b3=request.getParameter("b3");String b4=request.getParameter("b4");
	      String h1=request.getParameter("h1"); String hv1=request.getParameter("hv1");
	      String h2=request.getParameter("h2"); String hv2=request.getParameter("hv2");
	      String h3=request.getParameter("h3"); String hv3=request.getParameter("hv3");
	      String h4=request.getParameter("h4"); String hv4=request.getParameter("hv4");
	      String h5=request.getParameter("h5"); String hv5=request.getParameter("hv5");
		  String a1=request.getParameter("a1");String a2=request.getParameter("a2");
		  String cname=request.getParameter("cname"); String ckey=request.getParameter("ckey"); String csecname=request.getParameter("csecname");
		  String cseckey=request.getParameter("cseckey");String sname=request.getParameter("sname"); String svalue=request.getParameter("svalue");
		  String aurl=request.getParameter("aurl"); String tokenurl=request.getParameter("tokenurl"); String tlabel=request.getParameter("tlabel");
		  String treplace=request.getParameter("treplace");String el=request.getParameter("el"); String ev=request.getParameter("ev");
		String rf=request.getParameter("rf");String rm=request.getParameter("rm");
	    String endurl=request.getParameter("endurl");
	      String p1=(String) session.getAttribute("pa1");String pv1=request.getParameter("pv1");
	      String p2=(String) session.getAttribute("pa2");String pv2=request.getParameter("pv2");
	      String p3=(String) session.getAttribute("pa3");String pv3=request.getParameter("pv3");
	      String p4=(String) session.getAttribute("pa4");String pv4=request.getParameter("pv4");
	      String p5=(String) session.getAttribute("pa5");String pv5=request.getParameter("pv5");
	      String p6=(String) session.getAttribute("pa6");String pv6=request.getParameter("pv6");
	      String p7=(String) session.getAttribute("pa7");String pv7=request.getParameter("pv7");
	      String p8=(String) session.getAttribute("pa8"); String pv8=request.getParameter("pv8");
	      String p9=(String) session.getAttribute("pa9");String pv9=request.getParameter("pv9");
	      String p10=(String) session.getAttribute("p10");String pv10=request.getParameter("pv10");
	      String method=request.getParameter("method");String rm1=(String)session.getAttribute("orm");
	      String field1=(String) session.getAttribute("field1");      String field2=(String) session.getAttribute("field2");
	      String field3=(String) session.getAttribute("field3");      String field4=(String) session.getAttribute("field4");
	      String field5=(String) session.getAttribute("field5");      String field6=(String) session.getAttribute("field6");
	      String field7=(String) session.getAttribute("field7");      String field8=(String) session.getAttribute("field8");
	      String field9=(String) session.getAttribute("field9");      String field10=(String) session.getAttribute("field10");
	      try{
	    	  
	            Connection con;
				Class.forName("com.mysql.jdbc.Driver").newInstance();
	            con = (Connection) DriverManager.getConnection(config.get("URL"),config.get("USER"),config.get("PASS"));

	            String sam=null;
	             PreparedStatement st=null;
				 st=con.prepareStatement("insert into authen2(id,appid,appname,auth,a1,a2,b1,b2,b3,b4,h1,hv1,h2,hv2,h3,hv3,h4,hv4,h5,hv5,cname,ckey,csecname,cseckey,sname,svalue,aurl,tokenurl,tlabel,treplace,el,ev,resf,rm,endurl,baseurl,p1,pv1,p2,pv2,p3,pv3,p4,pv4,p5,pv5,p6,pv6,p7,pv7,p8,pv8,p9,pv9,p10,pv10,f1,f2,f3,f4,f5,f6,f7,f8,f9,f10) values ('"+id+"','"+appid+"','"+appname+"','"+authen+"','"+a1+"','"+a2+"','"+b1+"','"+b2+"','"+b3+"','"+b4+"','"+h1+"','"+hv1+"','"+h2+"','"+hv2+"','"+h3+"','"+hv3+"','"+h4+"','"+hv4+"','"+h5+"','"+hv5+"','"+cname+"','"+ckey+"','"+csecname+"','"+cseckey+"','"+sname+"','"+svalue+"','"+aurl+"','"+tokenurl+"','"+tlabel+"','"+treplace+"','"+el+"','"+ev+"','"+rf+"','"+rm+"','"+endurl+"','"+method+"','"+p1+"','"+pv1+"','"+p2+"','"+pv2+"','"+p3+"','"+pv3+"','"+p4+"','"+pv4+"','"+p5+"','"+pv5+"','"+p6+"','"+pv6+"','"+p7+"','"+pv7+"','"+p8+"','"+pv8+"','"+p9+"','"+pv9+"','"+p10+"','"+pv10+"','"+field1+"','"+field2+"','"+field3+"','"+field4+"','"+field5+"','"+field6+"','"+field7+"','"+field8+"','"+field9+"','"+field10+"')");
				 st.executeUpdate();
			     st.close();
			     out.println("Insert Sucess");
	    st=con.prepareStatement("SELECT * FROM authen2  ORDER BY appid DESC LIMIT 1"); //change
		
                 ResultSet rs = st.executeQuery();

		while(rs.next()){
   	         String id1=rs.getString("id");
   	         String appid1=rs.getString("appid");
   	         String authen1=rs.getString("auth");

   	      session.setAttribute("appid1", appid1);

             if("No Auth".equals(authen1) || "Basic Auth".equals(authen1) || "API keys".equals(authen1)){
            	 

               
             out.println("<html><h2><center><font color='green'>Processing...</font></center></h3><html>");
             RequestDispatcher disp = getServletContext().getRequestDispatcher("https://mindapp-pulpy.rhcloud.com/PreBuild");
             disp.forward( request, response );             }
             
             
              if("Oauth2".equals(authen1)){
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
            	    session.setAttribute("rm1", rm1);
            	  
            	 if(sname1.equals("") && el1.equals(""))
            		  response.sendRedirect(aurl+"?redirect_uri=https://mindapp-pulpy.rhcloud.com/OauthCallBackServlet&response_type=code&client_id="+ckey1);
                 else if(!sname1.equals("")&& el1.equals(""))
            		  response.sendRedirect(aurl+"?redirect_uri=https://mindapp-pulpy.rhcloud.com/OauthCallBackServlet&response_type=code&client_id="+ckey1+"&"+sname1+"="+svalue1);
                 else if(!sname1.equals("")&& !el1.equals(""))
            		  response.sendRedirect(aurl+"?redirect_uri=https://mindapp-pulpy.rhcloud.com/OauthCallBackServlet&response_type=code&client_id="+ckey1+"&"+sname1+"="+svalue1+"&"+el1+"="+ev1);
                 else if(sname1.equals("")&& !el1.equals(""))
            		  response.sendRedirect(aurl+"?redirect_uri=https://mindapp-pulpy.rhcloud.com/OauthCallBackServlet&response_type=code&client_id="+ckey1+"&"+el1+"="+ev1);
            	 
             } //while
            	 
            	 
             } //else-if*/
	  } //try
	  catch(Exception e){
out.println(e);	  }
	  }
}
