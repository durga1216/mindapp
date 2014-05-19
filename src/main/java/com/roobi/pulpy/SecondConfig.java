package com.roobi.pulpy;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
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

import net.sf.json.JSON;
import net.sf.json.JSONSerializer;
import net.sf.json.xml.XMLSerializer;

public class SecondConfig extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public SecondConfig() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		 Map<String, String> config = Utils.getConfigFromFile(getServletContext(), "config.properties");
			HttpSession session=request.getSession(true);
			HttpSession session4=request.getSession(true);
		String id=(String) session.getAttribute("id");
		String appid=(String) session.getAttribute("appid");
		String respf2=request.getParameter("select3");
		String securl=request.getParameter("securl"); String cycle=request.getParameter("cycle"); String sec1=request.getParameter("sec1");String sec2=request.getParameter("sec2");
		String s1=request.getParameter("s1");  String sv1=request.getParameter("sv1"); String s2=request.getParameter("s2"); String sv2=request.getParameter("sv2");
		String s3=request.getParameter("s3");  String sv3=request.getParameter("sv3"); String s4=request.getParameter("s4"); String sv4=request.getParameter("sv4");
		String s5=request.getParameter("s5");  String sv5=request.getParameter("sv5"); String s6=request.getParameter("s6"); String sv6=request.getParameter("sv6");
		String s7=request.getParameter("s7");  String sv7=request.getParameter("sv7"); String s8=request.getParameter("s8"); String sv8=request.getParameter("sv8");
		String s9=request.getParameter("s9");  String sv9=request.getParameter("sv9"); String s10=request.getParameter("s10"); String sv10=request.getParameter("sv10");
	   String al=request.getParameter("alabel"); String ak=request.getParameter("akey");
	   session4.setAttribute("securl",securl);session4.setAttribute("cycle",cycle);
	   session4.setAttribute("alabel",al);session4.setAttribute("akey",ak);
		session4.setAttribute("s1",s1);session4.setAttribute("sv1",sv1);
	      session4.setAttribute("s2",s2);session4.setAttribute("sv2",sv2);
	      session4.setAttribute("s3",s3);session4.setAttribute("sv3",sv3);
	      session4.setAttribute("s4",s4);session4.setAttribute("sv4",sv4);
	      session4.setAttribute("s5",s5);session4.setAttribute("sv5",sv5);
	      session4.setAttribute("s6",s6);session4.setAttribute("sv6",sv6);
	      session4.setAttribute("s7",s7);session4.setAttribute("sv7",sv7);
	      session4.setAttribute("s8",s8);session4.setAttribute("sv8",sv8);
	      session4.setAttribute("s9",s9);session4.setAttribute("sv9",sv9);
	      session4.setAttribute("s10",s10);session4.setAttribute("sv10",sv10);
		Connection con=null;
   	 try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = (Connection) DriverManager.getConnection(config.get("URL"),config.get("USER"),config.get("PASS"));
            PreparedStatement st=con.prepareStatement("insert into secondconfig(id,appid,securl,cycle,sec1,sec2,alabel1,akey1,s1,sv1,s2,sv2,s3,sv3,s4,sv4,s5,sv5,s6,sv6,s7,sv7,s8,sv8,s9,sv9,s10,sv10,resf2) values ('"+id+"','"+appid+"','"+securl+"','"+cycle+"','"+sec1+"','"+sec2+"','"+al+"','"+ak+"','"+s1+"','"+sv1+"','"+s2+"','"+sv2+"','"+s3+"','"+sv3+"','"+s4+"','"+sv4+"','"+s5+"','"+sv5+"','"+s6+"','"+sv6+"','"+s7+"','"+sv7+"','"+s8+"','"+sv8+"','"+s9+"','"+sv9+"','"+s10+"','"+sv10+"','"+respf2+"')");                
            st.executeUpdate();
            st.close();
            st=con.prepareStatement("SELECT * FROM authen1 t1 JOIN config t2 ON t1.appid = t2.appid JOIN secondconfig t3 on t1.appid=t3.appid WHERE t1.appid=?");
            st.setString(1, appid);
String str=null;
            ResultSet rs = st.executeQuery();
	         while(rs.next()){
   	         String id1=rs.getString("id");	 String appname1=rs.getString("appname");
             String authen1=rs.getString("auth");String ba1=rs.getString("b1");String ba2=rs.getString("b2");
             String ba3=rs.getString("b3");String ba4=rs.getString("b4");
             String oriapilabel=rs.getString("a1");String oriapikey=rs.getString("a2"); 
             String rf1=rs.getString("rf");String rm1=rs.getString("rm");
             String resf1=rs.getString("resf");//String eurl=rs.getString("endurl");
             String securl1=rs.getString("securl");String cycle1=rs.getString("cycle");String secid=rs.getString("sec1"); String secval=rs.getString("sec2");
             String ak1=rs.getString("alabel1");String ak2=rs.getString("akey1");String se1=rs.getString("s1"); String sev1=rs.getString("sv1");String se2=rs.getString("s2"); String sev2=rs.getString("sv2");
             String se3=rs.getString("s3"); String sev3=rs.getString("sv3");String se4=rs.getString("s4"); String sev4=rs.getString("sv4");
             String se5=rs.getString("s5"); String sev5=rs.getString("sv5");String se6=rs.getString("s6"); String sev6=rs.getString("sv6");
             String se7=rs.getString("s7"); String sev7=rs.getString("sv7");String se8=rs.getString("s8"); String sev8=rs.getString("sv8");
             String se9=rs.getString("s9"); String sev9=rs.getString("sv9");String se10=rs.getString("s10"); String sev10=rs.getString("sv10");
             String resf2=rs.getString("resf2");
            String secdurl=null;
          //  out.println(id+"<br>"+securl1+"<br>"+ak1);
            if(authen1.equals("No Auth")){ //No Authentication
    	         if(rf1.equals("REST") && rm1.equals ("GET")){  //No Auth GET XML

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
    	        	 
    	        	 URL secdurl1=new URL(securl);
            		 URLConnection uconn = secdurl1.openConnection();
            	     HttpURLConnection conn = (HttpURLConnection) uconn;
            	     conn.connect();
            	     Object content = conn.getContent();
            	     InputStream stream = (InputStream) content;
            	     String line=null;
            	     BufferedReader br=new BufferedReader(new InputStreamReader(stream));
    	        	 if(resf2.equals("XML")){
            	     while((line=br.readLine())!=null){
             	    	
      	       		     str+=line;
             	      }
    	        	 }
    	        	 else if(resf2.equals("JSON")){
    	        		  while((line=br.readLine())!=null){
    	        		 JSON json = JSONSerializer.toJSON( line );  
		     	          XMLSerializer xmlSerializer = new XMLSerializer();  
		     	          xmlSerializer.setTypeHintsEnabled(false);
		     	          xmlSerializer.setSkipWhitespace(true);
		     	          xmlSerializer.setTrimSpaces(true);
		     	          xmlSerializer.setRemoveNamespacePrefixFromElements(true);
		     	          xmlSerializer.removeNamespace(line);
		     	          xmlSerializer.setForceTopLevelObject(false);
		     		      str = xmlSerializer.write( json );

    	        	 }} // else-if and while
        	    	 session.setAttribute("xml1", str);
   	              out.println("<h2><center><font color='green'>Processing...</font></center></h3>");

	     		        response.setHeader("Refresh", "1; URL=sec_xml_config.jsp");	
                   	 }} //No auth and GET
             
             else if(authen1.equals("API keys")){  //API Keys
	        	 if(rf1.equals("REST") && rm1.equals ("GET")){  //API XML get
        		 
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
	        		 
	        		
	        		 URL secdurl1=new URL(secdurl);
	        		 URLConnection uconn = secdurl1.openConnection();
	        	     HttpURLConnection conn = (HttpURLConnection) uconn;
	        	     conn.connect();
	        	     Object content = conn.getContent();
	        	     InputStream stream = (InputStream) content;
	        	     String line=null;
	        	     BufferedReader br=new BufferedReader(new InputStreamReader(stream));
	        	     if(resf2.equals("XML")){
	        	        while((line=br.readLine())!=null){
	    	       		     str+=line;
	            	      }} //if and while
	        	     else if(resf2.equals("JSON")){
	        	          while ((line = br.readLine()) != null)    { 		  
		         		  JSON json = JSONSerializer.toJSON( line );  
		     	          XMLSerializer xmlSerializer = new XMLSerializer();  
		     	          xmlSerializer.setTypeHintsEnabled(false);
		     	          xmlSerializer.setSkipWhitespace(true);
		     	          xmlSerializer.setTrimSpaces(true);
		     	          xmlSerializer.setRemoveNamespacePrefixFromElements(true);
		     	          xmlSerializer.removeNamespace(line);
		     	          xmlSerializer.setForceTopLevelObject(false);
		     		      str = xmlSerializer.write( json );}} // else-if amd while
	    	    	 session.setAttribute("xml1", str);
		              out.println("<h2><center><font color='green'>Processing...</font></center></h3>");
	     		        response.setHeader("Refresh", "1; URL=sec_xml_config.jsp");	
	               	} //get
             }//api keys 
             
   	     } // database while
           
           } //try
   	 catch(Exception e){}

	}

}
