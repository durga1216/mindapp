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

public class ThirdConfig extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ThirdConfig() {
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
		String respf3=request.getParameter("select3");
		String thirdurl=request.getParameter("thrdurl"); String thirdcycle=request.getParameter("thirdcycle"); String thrd1=request.getParameter("thrd1");String thrd2=request.getParameter("thrd2");
		String t1=request.getParameter("t1");  String tv1=request.getParameter("tv1"); String t2=request.getParameter("t2"); String tv2=request.getParameter("tv2");
		String t3=request.getParameter("t3");  String tv3=request.getParameter("tv3"); String t4=request.getParameter("t4"); String tv4=request.getParameter("tv4");
		String t5=request.getParameter("t5");  String tv5=request.getParameter("tv5"); String t6=request.getParameter("t6"); String tv6=request.getParameter("tv6");
		String t7=request.getParameter("t7");  String tv7=request.getParameter("tv7"); String t8=request.getParameter("t8"); String tv8=request.getParameter("tv8");
		String t9=request.getParameter("t9");  String tv9=request.getParameter("tv9"); String t10=request.getParameter("t10"); String tv10=request.getParameter("tv10");
	   String al=request.getParameter("alabel"); String ak=request.getParameter("akey");
	   session4.setAttribute("thirdurl",thirdurl);session4.setAttribute("thirdcycle",thirdcycle);
	   session4.setAttribute("a2label",al);session4.setAttribute("a2key",ak);
		session4.setAttribute("t1",t1);session4.setAttribute("tv1",tv1);
	      session4.setAttribute("t2",t2);session4.setAttribute("tv2",tv2);
	      session4.setAttribute("t3",t3);session4.setAttribute("tv3",tv3);
	      session4.setAttribute("t4",t4);session4.setAttribute("tv4",tv4);
	      session4.setAttribute("t5",t5);session4.setAttribute("tv5",tv5);
	      session4.setAttribute("t6",t6);session4.setAttribute("tv6",tv6);
	      session4.setAttribute("t7",t7);session4.setAttribute("tv7",tv7);
	      session4.setAttribute("t8",t8);session4.setAttribute("tv8",tv8);
	      session4.setAttribute("t9",t9);session4.setAttribute("tv9",tv9);
	      session4.setAttribute("t10",t10);session4.setAttribute("tv10",tv10);
		Connection con=null;
   	        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = (Connection) DriverManager.getConnection(config.get("URL"),config.get("USER"),config.get("PASS"));
            PreparedStatement st=con.prepareStatement("insert into thirdconfig(id,appid,thrdurl,thrdcycle,alabel,akey,thrd1,thrd2,t1,tv1,t2,tv2,t3,tv3,t4,tv4,t5,tv5,t6,tv6,t7,tv7,t8,tv8,t9,tv9,t10,tv10,resf3) values ('"+id+"','"+appid+"','"+thirdurl+"','"+thirdcycle+"','"+al+"','"+ak+"','"+thrd1+"','"+thrd2+"','"+t1+"','"+tv1+"','"+t2+"','"+tv2+"','"+t3+"','"+tv3+"','"+t4+"','"+tv4+"','"+t5+"','"+tv5+"','"+t6+"','"+tv6+"','"+t7+"','"+tv7+"','"+t8+"','"+tv8+"','"+t9+"','"+tv9+"','"+t10+"','"+tv10+"','"+respf3+"')");                
            st.executeUpdate();
            st.close();
            out.println("INsert sucess");
            st=con.prepareStatement("SELECT * FROM authen1 t1 JOIN config t2 ON t1.appid = t2.appid JOIN thirdconfig t3 on t1.appid=t3.appid WHERE t1.appid=?");
            st.setString(1, appid);
      
            ResultSet rs = st.executeQuery();
	         while(rs.next()){
   	        String id1=rs.getString("id");	 String appname1=rs.getString("appname");
             String authen1=rs.getString("auth");String ba1=rs.getString("b1");String ba2=rs.getString("b2");
             String ba3=rs.getString("b3");String ba4=rs.getString("b4");
             String oriapilabel=rs.getString("a1");String oriapikey=rs.getString("a2"); 
             
             String rf1=rs.getString("rf");String rm1=rs.getString("rm");
             String resf1=rs.getString("resf");//String eurl=rs.getString("endurl");
             /*String tp1=rs.getString("p1");String tpv1=rs.getString("pv1");
             String tp2=rs.getString("p2");String tpv2=rs.getString("pv2");  // retrieve all valued from config table
             String tp3=rs.getString("p3");String tpv3=rs.getString("pv3");
             String tp4=rs.getString("p4");String tpv4=rs.getString("pv4");
             String tp5=rs.getString("p5");String tpv5=rs.getString("pv5");
             String tp6=rs.getString("p6");;String tpv6=rs.getString("pv6"); */
              
            out.println("inside while");
             //here will go to fetch second-config values
             String thirdurl1=rs.getString("thrdurl");String thirdcycle1=rs.getString("thrdcycle"); String ak1=rs.getString("alabel");String ak2=rs.getString("akey");
             String thrdid=rs.getString("thrd1"); String thrdval=rs.getString("thrd2");
             String tp1=rs.getString("t1"); String tpv1=rs.getString("tv1");String tp2=rs.getString("t2"); String tpv2=rs.getString("tv2");
             String tp3=rs.getString("t3"); String tpv3=rs.getString("tv3");String tp4=rs.getString("t4"); String tpv4=rs.getString("tv4");
             String tp5=rs.getString("t5"); String tpv5=rs.getString("tv5");String tp6=rs.getString("t6"); String tpv6=rs.getString("tv6");
             String tp7=rs.getString("t7"); String tpv7=rs.getString("tv7");String tp8=rs.getString("t8"); String tpv8=rs.getString("tv8");
             String tp9=rs.getString("t9"); String tpv9=rs.getString("tv9");String tp10=rs.getString("t10"); String tpv10=rs.getString("tv10");     
             String resf3=rs.getString("resf3");
	         out.println(thirdurl1+"<br>"+ak1+"<br>"+ak2+"<br>"+authen1);
             String thirdurl11=null;
             if(authen1.equals("No Auth")){ //No Authentication
    	         if(rf1.equals("REST") && rm1.equals ("GET") && resf1.equals("XML")){  //No Auth GET XML

    	        	 if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3) && !"null".equals(tp4) && !"null".equals(tp5) && !"null".equals(tp6) && "entity".equals(thirdcycle1)){
    	        		 thirdurl11=thirdurl1+"?"+tp1+"="+tpv1+"&"+tp2+"="+tpv2+"&"+tp3+"="+tpv3+"&"+tp4+"="+tpv4+"&"+tp5+"="+tpv5+"&"+tp6+"="+tpv6;}
    	        		 
    	        		 else if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3) && !"null".equals(tp4) && !"null".equals(tp5)&& "entity".equals(thirdcycle1)){
    		        		 thirdurl11=thirdurl1+"?"+tp1+"="+tpv1+"&"+tp2+"="+tpv2+"&"+tp3+"="+tpv3+"&"+tp4+"="+tpv4+"&"+tp5+"="+tpv5;}
    	        		 
    	        		 else if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3) && !"null".equals(tp4)&& "entity".equals(thirdcycle1)){
    		        		 thirdurl11=thirdurl1+"?"+tp1+"="+tpv1+"&"+tp2+"="+tpv2+"&"+tp3+"="+tpv3+"&"+tp4+"="+tpv4;}
    	        		 
    	        		 else if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3)&& "entity".equals(thirdcycle1)){
    		        		 thirdurl11=thirdurl1+"?"+tp1+"="+tpv1+"&"+tp2+"="+tpv2+"&"+tp3+"="+tpv3;}
    	        		 
    	        		 else if(!"null".equals(tp1) && !"null".equals(tp2)&& "entity".equals(thirdcycle1)){
    		        		 thirdurl11=thirdurl1+"?"+tp1+"="+tpv1+"&"+tp2+"="+tpv2;}
    	        		 
    	        		 else if(!"null".equals(tp1)&& "entity".equals(thirdcycle1)){
    		        		 thirdurl11=thirdurl1+"?"+tp1+"="+tpv1;}
    	        		 else if("null".equals(tp1)&& "entity".equals(thirdcycle1))
    	        			thirdurl11=thirdurl1;
    	        	 
    	        		 else if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3)&& "flow".equals(thirdcycle1)){
    		        		 thirdurl11=thirdurl1+"?"+thrdid+"="+thrdval+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2+"&"+tp3+"="+tpv3;}
    	        		 
    	        		 else if(!"null".equals(tp1) && !"null".equals(tp2)&& "flow".equals(thirdcycle1)){
    		        		 thirdurl11=thirdurl1+"?"+thrdid+"="+thrdval+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2;}
    	        		 
    	        		 else if(!"null".equals(tp1)&& "flow".equals(thirdcycle1)){
    		        		 thirdurl11=thirdurl1+"?"+thrdid+"="+thrdval+"&"+tp1+"="+tpv1;}
    	        		 
    	        		 else if(!"null".equals(thrdid)&& !"null".equals(thrdval) && "null".equals(ak1) && "null".equals(ak2))
    	        			 thirdurl11=thirdurl1+"?"+thrdid+"="+thrdval;
    	        		 else if(!"null".equals(ak1) && !"null".equals(ak2))
    	        			 thirdurl11=thirdurl1+"?"+ak1+"="+ak2;
    	        	// out.println(thirdurl11);
    	        	 
    	        	 URL thirdurl2=new URL(thirdurl11);
            		 URLConnection uconn = thirdurl2.openConnection();
            	     HttpURLConnection conn = (HttpURLConnection) uconn;
            	     conn.connect();
            	     Object content = conn.getContent();
            	     InputStream stream = (InputStream) content;
            	     String line=null;
            	     String str="";
            	     BufferedReader br=new BufferedReader(new InputStreamReader(stream));
         	       //  FileWriter fw=new FileWriter("F:/workspace/MindPulpy1/WebContent/book.xml");
            	     while((line=br.readLine())!=null){
            	    	// fw.write(line);
            	    	 str+=line;
            	    	 //fw.flush();
            	      }
    	        	    //fw.close();
            	     session.setAttribute("xml1", str);
	     		        response.setHeader("Refresh", "1; URL=third_xml_config.jsp");	
                   	// Runtime.getRuntime().exec("notepad F:/workspace/MindPulpy1/WebContent/book.xml");
                   	 //out.println("<h2><center><font color='green'>Processing...</font></center></h3>");
        		     //response.setHeader("Refresh", "1; URL=third_xml_config.jsp"); 
                   	 }}
             
             else if(authen1.equals("API keys")){  //API Keys
	        	 if(rf1.equals("REST") && rm1.equals ("GET") && resf1.equals("XML")){  //API XML get
	        		 out.println("Inside API keys and GET");

	        		 if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3) && !"null".equals(tp4) && !"null".equals(tp5) && !"null".equals(tp6)&& "entity".equals(thirdcycle1))
	        		     thirdurl11=thirdurl1+"?"+ak1+"="+ak2+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2+"&"+tp3+"="+tpv3+"&"+tp4+"="+tpv4+"&"+tp5+"="+tpv5+"&"+tp6+"="+tpv6;
	        		 
	        		 else if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3) && !"null".equals(tp4) && !"null".equals(tp5)&& "entity".equals(thirdcycle1))
		        		 thirdurl11=thirdurl1+"?"+ak1+"="+ak2+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2+"&"+tp3+"="+tpv3+"&"+tp4+"="+tpv4+"&"+tp5+"="+tpv5;
	        		 
	        		 else if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3) && !"null".equals(tp4)&& "entity".equals(thirdcycle1))
		        		 thirdurl11=thirdurl1+"?"+ak1+"="+ak2+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2+"&"+tp3+"="+tpv3+"&"+tp4+"="+tpv4;
	        		 
	        		 else if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3)&& "entity".equals(thirdcycle1))
		        		 thirdurl11=thirdurl1+"?"+ak1+"="+ak2+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2+"&"+tp3+"="+tpv3;
	        		 
	        		 else if(!"null".equals(tp1) && !"null".equals(tp2)&& "entity".equals(thirdcycle1))
		        		 thirdurl11=thirdurl1+"?"+ak1+"="+ak2+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2;
	        		 
	        		 else if(!"null".equals(tp1)&& "entity".equals(thirdcycle1))
		        		 thirdurl11=thirdurl1+"?"+ak1+"="+ak2+"&"+tp1+"="+tpv1;
	        		 
	        		 else if(!"null".equals(thrdid)&& !"null".equals(thrdval) && "flow".equals(thirdcycle1)&&!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3))
		        		 thirdurl11=thirdurl1+"?"+oriapilabel+"="+oriapikey+"&"+thrdid+"="+thrdval+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2+"&"+tp3+"="+tpv3;
	        		 
	        		 else if(!"null".equals(thrdid)&& !"null".equals(thrdval) && "flow".equals(thirdcycle1)&&!"null".equals(tp1) && !"null".equals(tp2))
		        		 thirdurl11=thirdurl1+"?"+oriapilabel+"="+oriapikey+"&"+thrdid+"="+thrdval+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2;
	        		 
	        		 else if(!"null".equals(thrdid)&& !"null".equals(thrdval) && "flow".equals(thirdcycle1)&&!"null".equals(tp1))
		        		 thirdurl11=thirdurl1+"?"+oriapilabel+"="+oriapikey+"&"+thrdid+"="+thrdval+"&"+tp1+"="+tpv1;
	        		 
	        		 else if(!"null".equals(thrdid)&& !"null".equals(thrdval) && "flow".equals(thirdcycle1))
	        			 thirdurl11=thirdurl1+"?"+oriapilabel+"="+oriapikey+"&"+thrdid+"="+thrdval;
	        		
	        		 else if(!"null".equals(ak1) && !"null".equals(ak2)&& "entity".equals(thirdcycle1))
	        			      thirdurl11=thirdurl1+"?"+ak1+"="+ak2;
	        		// out.println(thirdurl11);
	        		
	        		 URL url1=new URL(thirdurl11);
     				 URLConnection uconn = url1.openConnection();
     				 String str="";
                      BufferedReader br = new BufferedReader(new InputStreamReader(uconn.getInputStream()));

          		     String line=null;
          		     FileWriter fw=null;
          		     
          		   while((line=br.readLine())!=null){
            	    	// pw1.write(line);
     	       		    // pw1.flush();
     	       		     str+=line;
     	        	   //out.println(line);
            	      }
    	        	    //pw1.close();
          		 session.setAttribute("xml1", str);
  		        response.setHeader("Refresh", "1; URL=third_xml_config.jsp");		
	               	}
	        	 
             
	        	 else if(rf1.equals("REST") && rm1.equals ("GET") && resf1.equals("JSON")){  //API XML get
	        		 out.println("Inside API keys and GET");

	        		 if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3) && !"null".equals(tp4) && !"null".equals(tp5) && !"null".equals(tp6)&& "entity".equals(thirdcycle1))
	        		     thirdurl11=thirdurl1+"?"+ak1+"="+ak2+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2+"&"+tp3+"="+tpv3+"&"+tp4+"="+tpv4+"&"+tp5+"="+tpv5+"&"+tp6+"="+tpv6;
	        		 
	        		 else if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3) && !"null".equals(tp4) && !"null".equals(tp5)&& "entity".equals(thirdcycle1))
		        		 thirdurl11=thirdurl1+"?"+ak1+"="+ak2+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2+"&"+tp3+"="+tpv3+"&"+tp4+"="+tpv4+"&"+tp5+"="+tpv5;
	        		 
	        		 else if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3) && !"null".equals(tp4)&& "entity".equals(thirdcycle1))
		        		 thirdurl11=thirdurl1+"?"+ak1+"="+ak2+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2+"&"+tp3+"="+tpv3+"&"+tp4+"="+tpv4;
	        		 
	        		 else if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3)&& "entity".equals(thirdcycle1))
		        		 thirdurl11=thirdurl1+"?"+ak1+"="+ak2+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2+"&"+tp3+"="+tpv3;
	        		 
	        		 else if(!"null".equals(tp1) && !"null".equals(tp2)&& "entity".equals(thirdcycle1))
		        		 thirdurl11=thirdurl1+"?"+ak1+"="+ak2+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2;
	        		 
	        		 else if(!"null".equals(tp1)&& "entity".equals(thirdcycle1))
		        		 thirdurl11=thirdurl1+"?"+ak1+"="+ak2+"&"+tp1+"="+tpv1;
	        		 
	        		 else if(!"null".equals(thrdid)&& !"null".equals(thrdval) && "flow".equals(thirdcycle1)&&!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3))
		        		 thirdurl11=thirdurl1+"?"+oriapilabel+"="+oriapikey+"&"+thrdid+"="+thrdval+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2+"&"+tp3+"="+tpv3;
	        		 
	        		 else if(!"null".equals(thrdid)&& !"null".equals(thrdval) && "flow".equals(thirdcycle1)&&!"null".equals(tp1) && !"null".equals(tp2))
		        		 thirdurl11=thirdurl1+"?"+oriapilabel+"="+oriapikey+"&"+thrdid+"="+thrdval+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2;
	        		 
	        		 else if(!"null".equals(thrdid)&& !"null".equals(thrdval) && "flow".equals(thirdcycle1)&&!"null".equals(tp1))
		        		 thirdurl11=thirdurl1+"?"+oriapilabel+"="+oriapikey+"&"+thrdid+"="+thrdval+"&"+tp1+"="+tpv1;
	        		 
	        		 else if(!"null".equals(thrdid)&& !"null".equals(thrdval) && "flow".equals(thirdcycle1))
	        			 thirdurl11=thirdurl1+"?"+oriapilabel+"="+oriapikey+"&"+thrdid+"="+thrdval;
	        		
	        		 else if(!"null".equals(ak1) && !"null".equals(ak2)&& "entity".equals(thirdcycle1))
	        			      thirdurl11=thirdurl1+"?"+ak1+"="+ak2;
	        		// out.println(thirdurl11);
	        		
	        		 URL url1=new URL(thirdurl11);
     				 URLConnection uconn = url1.openConnection();

                      BufferedReader in = new BufferedReader(new InputStreamReader(uconn.getInputStream()));

          		     String line=null;
          		     FileWriter fw=null;
          		     
          		    // fw=new FileWriter("F:/workspace/MindPulpy1/WebContent/book.xml");
                  	 while ((line = in.readLine()) != null) {
                  	 
                  		JSON json = JSONSerializer.toJSON( line );  
		     	          XMLSerializer xmlSerializer = new XMLSerializer();  
		     	          xmlSerializer.setTypeHintsEnabled(false);
		     	          xmlSerializer.setSkipWhitespace(true);
		     	          xmlSerializer.setTrimSpaces(true);
		     	          xmlSerializer.setRemoveNamespacePrefixFromElements(true);
		     	          xmlSerializer.removeNamespace(line);
		     	          xmlSerializer.setForceTopLevelObject(false);
		     		      String  xmlout = xmlSerializer.write( json );
		    			  //fw=new FileWriter("F:/workspace/MindPulpy1/Webcontent/book.xml");
		    			  //fw.write(xmlout);
		     		     session.setAttribute("xml1", xmlout);
		     		        response.setHeader("Refresh", "1; URL=third_xml_config.jsp");	

                  	 } // while
                  	// fw.close();
                  //	in.close();
                  	 
             }  //else  if

             }  //Main if API keys

             
             
             
	         } 	//while 
             
	         } // try

   	 catch(Exception e){}
	}

}
