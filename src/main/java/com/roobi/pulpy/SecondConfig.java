package com.roobi.pulpy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SecondConfig extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public SecondConfig() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setHeader("Content-Type","text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession(true);
		String appid=(String) session.getAttribute("id");
		String securl=request.getParameter("securl"); String cycle=request.getParameter("cycle"); String sec1=request.getParameter("sec1");String sec2=request.getParameter("sec2");
		String s1=request.getParameter("s1");  String sv1=request.getParameter("sv1"); String s2=request.getParameter("s2"); String sv2=request.getParameter("sv2");
		String s3=request.getParameter("s3");  String sv3=request.getParameter("sv3"); String s4=request.getParameter("s4"); String sv4=request.getParameter("sv4");
		String s5=request.getParameter("s5");  String sv5=request.getParameter("sv5"); String s6=request.getParameter("s6"); String sv6=request.getParameter("sv6");
		String s7=request.getParameter("s7");  String sv7=request.getParameter("sv7"); String s8=request.getParameter("s8"); String sv8=request.getParameter("sv8");
		String s9=request.getParameter("s9");  String sv9=request.getParameter("sv9"); String s10=request.getParameter("s10"); String sv10=request.getParameter("sv10");
	   String al=request.getParameter("alabel"); String ak=request.getParameter("akey");
		Connection con=null;
   	 try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            String url = "jdbc:mysql://127.6.250.130:3306/mpulpy";
            final String USER = "adminPQ1iFfN";
            final String PASS = "J5JhBL-XC9NG";

            con = DriverManager.getConnection(url,USER,PASS);
            PreparedStatement st=con.prepareStatement("insert into secondconfig(id,securl,cycle,sec1,sec2,alabel1,akey1,s1,sv1,s2,sv2,s3,sv3,s4,sv4,s5,sv5,s6,sv6,s7,sv7,s8,sv8,s9,sv9,s10,sv10) values ('"+appid+"','"+securl+"','"+cycle+"','"+sec1+"','"+sec2+"','"+al+"','"+ak+"','"+s1+"','"+sv1+"','"+s2+"','"+sv2+"','"+s3+"','"+sv3+"','"+s4+"','"+sv4+"','"+s5+"','"+sv5+"','"+s6+"','"+sv6+"','"+s7+"','"+sv7+"','"+s8+"','"+sv8+"','"+s9+"','"+sv9+"','"+s10+"','"+sv10+"')");                
            st.executeUpdate();
            st.close();
            st=con.prepareStatement("SELECT * FROM authen t1 JOIN config t2 ON t1.id = t2.id JOIN secondconfig t3 on t1.id=t3.id WHERE t1.id=?");
            st.setString(1, appid);

            ResultSet rs = st.executeQuery();
	         while(rs.next()){
   	         String id=rs.getString("id");	 String appname1=rs.getString("appname");
             String authen1=rs.getString("auth");String ba1=rs.getString("b1");String ba2=rs.getString("b2");
             String ba3=rs.getString("b3");String ba4=rs.getString("b4");
             String oriapilabel=rs.getString("a1");String oriapikey=rs.getString("a2"); 
             
             String rf1=rs.getString("rf");String rm1=rs.getString("rm");
             String resf1=rs.getString("resf");//String eurl=rs.getString("endurl");
            /* String se1=rs.getString("p1");String sev1=rs.getString("pv1");
             String se2=rs.getString("p2");String sev2=rs.getString("pv2");  // retrieve all valued from config table
             String se3=rs.getString("p3");String sev3=rs.getString("pv3");
             String se4=rs.getString("p4");String sev4=rs.getString("pv4");
             String se5=rs.getString("p5");String sev5=rs.getString("pv5");
             String se6=rs.getString("p6");;String sev6=rs.getString("pv6"); */
              
             
             //here will go to fetch second-config values
             String securl1=rs.getString("securl");String cycle1=rs.getString("cycle");String secid=rs.getString("sec1"); String secval=rs.getString("sec2");
             String ak1=rs.getString("alabel1");String ak2=rs.getString("akey1");String se1=rs.getString("s1"); String sev1=rs.getString("sv1");String se2=rs.getString("s2"); String sev2=rs.getString("sv2");
             String se3=rs.getString("s3"); String sev3=rs.getString("sv3");String se4=rs.getString("s4"); String sev4=rs.getString("sv4");
             String se5=rs.getString("s5"); String sev5=rs.getString("sv5");String se6=rs.getString("s6"); String sev6=rs.getString("sv6");
             String se7=rs.getString("s7"); String sev7=rs.getString("sv7");String se8=rs.getString("s8"); String sev8=rs.getString("sv8");
             String se9=rs.getString("s9"); String sev9=rs.getString("sv9");String se10=rs.getString("s10"); String sev10=rs.getString("sv10");

            String secdurl=null;
          //  out.println(id+"<br>"+securl1+"<br>"+ak1);
            if(authen1.equals("No Auth")){ //No Authentication
    	         if(rf1.equals("REST") && rm1.equals ("GET") && resf1.equals("XML")){  //No Auth GET XML

    	        	 if(!"null".equals(se1) && !"null".equals(se2) && !"null".equals(se3) && !"null".equals(se4) && !"null".equals(se5) && !"null".equals(se6)&& "entity".equals(cycle1)){
    	        		 secdurl=securl1+"?"+se1+"="+sev1+"&"+se2+"="+sev2+"&"+se3+"="+sev3+"&"+se4+"="+sev4+"&"+se5+"="+sev5+"&"+se6+"="+sev6;}
    	        		 
    	        		 else if(!"null".equals(se1) && !"null".equals(se2) && !"null".equals(se3) && !"null".equals(se4) && !"null".equals(se5)&& "entity".equals(cycle1)){
    		        		 secdurl=securl1+"?"+se1+"="+sev1+"&"+se2+"="+sev2+"&"+se3+"="+sev3+"&"+se4+"="+sev4+"&"+se5+"="+sev5;}
    	        		 
    	        		 else if(!"null".equals(se1) && !"null".equals(se2) && !"null".equals(se3) && !"null".equals(se4)&& "entity".equals(cycle1)){
    		        		 secdurl=securl1+"?"+se1+"="+sev1+"&"+se2+"="+sev2+"&"+se3+"="+sev3+"&"+se4+"="+sev4;}
    	        		 
    	        	      
    	        		 else if(!"null".equals(se1) && !"null".equals(se2) && !"null".equals(se3)&& "entity".equals(cycle1)){
    		        		 secdurl=securl1+"?"+se1+"="+sev1+"&"+se2+"="+sev2+"&"+se3+"="+sev3;}
    	        		 
    	        		 else if(!"null".equals(se1) && !"null".equals(se2)&& "entity".equals(cycle1)){
    		        		 secdurl=securl1+"?"+se1+"="+sev1+"&"+se2+"="+sev2;}
    	        		 
    	        		 else if(!"null".equals(se1)&& "entity".equals(cycle1)){
    		        		 secdurl=securl1+"?"+se1+"="+sev1;}
    	        		 else if("null".equals(se1)&& "entity".equals(cycle1))
    	        			secdurl=securl1;
    	        		 else if("null".equals(secid) && "null".equals(secval) && "flow".equals(cycle1))
    	        		     secdurl=securl1+"/"+secval;
    	        	 
    	        		 else if(!"null".equals(se1) && !"null".equals(se2) && !"null".equals(se3)&& "flow".equals(cycle1)){
    		        		 secdurl=securl1+"?"+secid+"="+secval+"&"+se1+"="+sev1+"&"+se2+"="+sev2+"&"+se3+"="+sev3;}
    	        		 
    	        		 else if(!"null".equals(se1) && !"null".equals(se2)&& "flow".equals(cycle1)){
    		        		 secdurl=securl1+"?"+secid+"="+secval+"&"+se1+"="+sev1+"&"+se2+"="+sev2;}
    	        		 
    	        		 else if(!"null".equals(se1)&& "flow".equals(cycle1)){
    		        		 secdurl=securl1+"?"+secid+"="+secval+"&"+se1+"="+sev1;}
    	        		 else if("null".equals(se1)&& "entity".equals(cycle1))
    	        			secdurl=securl1;
    	        		 
    	        		 else if(!"null".equals(secid)&& !"null".equals(secval) && "null".equals(ak1) && "null".equals(ak2)&& "flow".equals(cycle1))
    	        			 secdurl=securl1+"?"+secid+"="+secval;
    	        		 else if(!"null".equals(ak1) && !"null".equals(ak2)&& "entity".equals(cycle1))
    	        			 secdurl=securl1+"?"+ak1+"="+ak2;
    	        	 out.println(secdurl);
    	        	 URL secdurl1=new URL(secdurl);
            		 URLConnection uconn = secdurl1.openConnection();
            	     HttpURLConnection conn = (HttpURLConnection) uconn;
            	     conn.connect();
            	     Object content = conn.getContent();
            	     InputStream stream = (InputStream) content;
            	     String line=null;
            	     String str=null;
            	     BufferedReader br=new BufferedReader(new InputStreamReader(stream));
         	         PrintWriter pw1=new PrintWriter("xml/det.xml");
            	     while((line=br.readLine())!=null){
            	    	 pw1.write(line);
     	       		     pw1.flush();
     	        	   //out.println(line);
            	      }
    	        	    pw1.close();
    	        	   	     		
                   	 //   Runtime.getRuntime().exec("notepad F:/workspace/MindPulpy1/WebContent/det.xml");
                   	 out.println("<html><h1><center><font color='green'>Processing...</font></center></h2><html>");
        		     response.setHeader("Refresh", "1; URL=sec_xml_config.jsp"); 
                   	 }}
             
             else if(authen1.equals("API keys")){  //API Keys
	        	 if(rf1.equals("REST") && rm1.equals ("GET") && resf1.equals("XML")){  //API XML get
	        		 

	        		 if(!"null".equals(se1) && !"null".equals(se2) && !"null".equals(se3) && !"null".equals(se4) && !"null".equals(se5) && !"null".equals(se6)&& "entity".equals(cycle1)){
	        		     secdurl=securl1+"?"+ak1+"="+ak2+"&"+se1+"="+sev1+"&"+se2+"="+sev2+"&"+se3+"="+sev3+"&"+se4+"="+sev4+"&"+se5+"="+sev5+"&"+se6+"="+sev6;}
	        		 
	        		 else if(!"null".equals(se1) && !"null".equals(se2) && !"null".equals(se3) && !"null".equals(se4) && !"null".equals(se5)&& "entity".equals(cycle1)){
		        		 secdurl=securl1+"?"+ak1+"="+ak2+"&"+se1+"="+sev1+"&"+se2+"="+sev2+"&"+se3+"="+sev3+"&"+se4+"="+sev4+"&"+se5+"="+sev5;}
	        		 
	        		 else if(!"null".equals(se1) && !"null".equals(se2) && !"null".equals(se3) && !"null".equals(se4)&& "entity".equals(cycle1)){
		        		 secdurl=securl1+"?"+ak1+"="+ak2+"&"+se1+"="+sev1+"&"+se2+"="+sev2+"&"+se3+"="+sev3+"&"+se4+"="+sev4;}
	        		 
	        		 else if(!"null".equals(se1) && !"null".equals(se2) && !"null".equals(se3)&& "entity".equals(cycle1)){
		        		 secdurl=securl1+"?"+ak1+"="+ak2+"&"+se1+"="+sev1+"&"+se2+"="+sev2+"&"+se3+"="+sev3;}
	        		 
	        		 else if(!"null".equals(se1) && !"null".equals(se2)&& "entity".equals(cycle1)){
		        		 secdurl=securl1+"?"+ak1+"="+ak2+"&"+se1+"="+sev1+"&"+se2+"="+sev2;}
	        		 
	        		 else if(!"null".equals(se1)&& "entity".equals(cycle1)){
		        		 secdurl=securl1+"?"+ak1+"="+ak2+"&"+se1+"="+sev1;}
	        		 
	        		 else if(!"null".equals(se1) && !"null".equals(se2) && !"null".equals(se3) && "flow".equals(cycle1)){
		        		 secdurl=securl1+"?"+oriapilabel+"="+oriapikey+"&"+se1+"="+sev1+"&"+se2+"="+sev2+"&"+se3+"="+sev3;}
	        		 
	        		 else if(!"null".equals(se1) && !"null".equals(se2)&& "flow".equals(cycle1)){
		        		 secdurl=securl1+"?"+oriapilabel+"="+oriapikey+"&"+se1+"="+sev1+"&"+se2+"="+sev2;}
	        		 
	        		 else if(!"null".equals(se1)&& "flow".equals(cycle1)){
		        		 secdurl=securl1+"?"+oriapilabel+"="+oriapikey+"&"+se1+"="+sev1;}
	        		 
	        		 else if(!"null".equals(secid)&& !"null".equals(secval) && "flow".equals(cycle1))
	        			 secdurl=securl1+"?"+secid+"="+secval;
	        		 else if("null".equals(secid) && "null".equals(secval) && "flow".equals(cycle1))
	        		     secdurl=securl1+"/"+secval;
	        		 else if(!"null".equals(ak1) && !"null".equals(ak2)&& "entity".equals(cycle1))
       			      secdurl=securl1+"?"+ak1+"="+ak2;
	        		 else if("null".equals(ak1) && "null".equals(ak2) && "entity".equals(cycle1))
	        			      secdurl=securl1;
	        		 
	        		 out.println(secdurl);
	        		 URL secdurl1=new URL(secdurl);
	        		 URLConnection uconn = secdurl1.openConnection();
	        	     HttpURLConnection conn = (HttpURLConnection) uconn;
	        	     conn.connect();
	        	     Object content = conn.getContent();
	        	     InputStream stream = (InputStream) content;
	        	     String line=null;
	        	     String str=null;
	        	     BufferedReader br=new BufferedReader(new InputStreamReader(stream));
	     	         PrintWriter pw1=new PrintWriter("xml/det.xml");
	        	     while((line=br.readLine())!=null){
	        	    	 pw1.write(line);
	 	       		     pw1.flush();
	 	        	   // out.println(line);

	        	      }
		        	   // pw1.close();
		        	  	       		
	               //	Runtime.getRuntime().exec("notepad F:/workspace/MindPulpy1/WebContent/det.xml");
	               	out.println("<html><h1><center><font color='green'>Processing...</font></center></h2><html>");
	   		        response.setHeader("Refresh", "1; URL=sec_xml_config.jsp");
	               	}}

             
             
	         
	         }
           
           }
   	 catch(Exception e){}

	}

}
