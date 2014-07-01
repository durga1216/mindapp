package com.roobi.pulpy;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;

public class PreBuild extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public PreBuild() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession(true);
	    String id=(String) session.getAttribute("id");
		String appid=(String) session.getAttribute("appid");String appname=(String)session.getAttribute("appname");String b1=request.getParameter("b1");String b2=request.getParameter("b2");
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
	      String p1=(String) session.getAttribute("p1");String pv1=request.getParameter("pv1");
	      String p2=(String) session.getAttribute("p2");String pv2=request.getParameter("pv2");
	      String p3=(String) session.getAttribute("p3");String pv3=request.getParameter("pv3");
	      String p4=(String) session.getAttribute("p4");String pv4=request.getParameter("pv4");
	      String p5=(String) session.getAttribute("p5");String pv5=request.getParameter("pv5");
	      String p6=(String) session.getAttribute("p6");String pv6=request.getParameter("pv6");
	      String p7=(String) session.getAttribute("p7");String pv7=request.getParameter("pv7");
	      String p8=(String) session.getAttribute("p8"); String pv8=request.getParameter("pv8");
	      String p9=(String) session.getAttribute("p9");String pv9=request.getParameter("pv9");
	      String p10=(String) session.getAttribute("p10");String pv10=request.getParameter("pv10");
	      String field1=(String) session.getAttribute("field1");      String field2=(String) session.getAttribute("field2");
	      String field3=(String) session.getAttribute("field3");      String field4=(String) session.getAttribute("field4");
	      String field5=(String) session.getAttribute("field5");      String field6=(String) session.getAttribute("field6");
	      String field7=(String) session.getAttribute("field7");      String field8=(String) session.getAttribute("field8");
	      String field9=(String) session.getAttribute("field9");      String field10=(String) session.getAttribute("field10");
	      try{
	    	  
	            Connection con;
				Class.forName("com.mysql.jdbc.Driver").newInstance();
	            String url = "jdbc:mysql://localhost/MPULPY";
	            final String USER = "root";
	            final String PASS = "root";
	            con = (Connection) DriverManager.getConnection(url,USER,PASS);
	            String sam=null;
	             PreparedStatement st=null;
				 st=con.prepareStatement("insert into authen2(id,appid,appname,auth,a1,a2,b1,b2,b3,b4,h1,hv1,h2,hv2,h3,hv3,h4,hv4,h5,hv5,cname,ckey,csecname,cseckey,sname,svalue,aurl,tokenurl,tlabel,treplace,el,ev,resf,rm,endurl,p1,pv1,p2,pv2,p3,pv3,p4,pv4,p5,pv5,p6,pv6,p7,pv7,p8,pv8,p9,pv9,p10,pv10,f1,f2,f3,f4,f5,f6,f7,f8,f9,f10) values ('"+id+"','"+appid+"','"+appname+"','"+authen+"','"+a1+"','"+a2+"','"+b1+"','"+b2+"','"+b3+"','"+b4+"','"+h1+"','"+hv1+"','"+h2+"','"+hv2+"','"+h3+"','"+hv3+"','"+h4+"','"+hv4+"','"+h5+"','"+hv5+"','"+cname+"','"+ckey+"','"+csecname+"','"+cseckey+"','"+sname+"','"+svalue+"','"+aurl+"','"+tokenurl+"','"+tlabel+"','"+treplace+"','"+el+"','"+ev+"','"+rf+"','"+rm+"','"+endurl+"','"+p1+"','"+pv1+"','"+p2+"','"+pv2+"','"+p3+"','"+pv3+"','"+p4+"','"+pv4+"','"+p5+"','"+pv5+"','"+p6+"','"+pv6+"','"+p7+"','"+pv7+"','"+p8+"','"+pv8+"','"+p9+"','"+pv9+"','"+p10+"','"+pv10+"','"+field1+"','"+field2+"','"+field3+"','"+field4+"','"+field5+"','"+field6+"','"+field7+"','"+field8+"','"+field9+"','"+field10+"')");
				 st.executeUpdate();
			     st.close();
			     st=con.prepareStatement("SELECT * FROM authen2  ORDER BY appid DESC LIMIT 1"); //change
                 ResultSet rs = st.executeQuery();
                 while(rs.next()){
                	 String appname1=rs.getString("appname");
                     String authen1=rs.getString("auth");String ba1=rs.getString("b1");String ba2=rs.getString("b2");
                     String ba3=rs.getString("b3");String ba4=rs.getString("b4");String ak1=rs.getString("a1");
                     String ak2=rs.getString("a2"); String cname1=rs.getString("cname");
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
                     String rf1=rs.getString("resf");String rm1=rs.getString("rm");
                     String resf1=rs.getString("resf");String endurl1=rs.getString("endurl");
                     String pa1=rs.getString("p1");String pva1=rs.getString("pv1");
                     String pa2=rs.getString("p2");String pva2=rs.getString("pv2");
                     String pa3=rs.getString("p3");String pva3=rs.getString("pv3");
                     String pa4=rs.getString("p4");String pva4=rs.getString("pv4");
                     String pa5=rs.getString("p5");String pva5=rs.getString("pv5");
                     String pa6=rs.getString("p6");;String pva6=rs.getString("pv6");
                     String pa7=rs.getString("p7");;String pva7=rs.getString("pv7");
                     String pa8=rs.getString("p8");;String pva8=rs.getString("pv8");
                     String pa9=rs.getString("p9");;String pva9=rs.getString("pv9");
                     String pa10=rs.getString("p10");;String pva10=rs.getString("pv10");
                    String he1=rs.getString("h1");String hva1=rs.getString("hv1");
                    String he2=rs.getString("h2");String hva2=rs.getString("hv2");
                    String he3=rs.getString("h3");String hva3=rs.getString("hv3");
                    String he4=rs.getString("h4");String hva4=rs.getString("hv4");
                    String he5=rs.getString("h5");String hva5=rs.getString("hv5");
                     String f1=rs.getString("f1"); String f2=rs.getString("f2");
                     String f3=rs.getString("f3"); String f4=rs.getString("f4");
                     String f5=rs.getString("f5"); String f6=rs.getString("f6");
                     String f7=rs.getString("f7"); String f8=rs.getString("f8");
                     String f9=rs.getString("f9"); String f10=rs.getString("f10");
                     
        	         String eurl=null;
        	        
                 }
	      }
	      catch(Exception e){
	    	  out.println(e);
	      }
	
	}

}
