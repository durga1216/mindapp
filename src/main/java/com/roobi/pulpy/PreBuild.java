package com.roobi.pulpy;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSON;
import net.sf.json.JSONSerializer;
import net.sf.json.xml.XMLSerializer;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import com.mindots.util.Utils;
import com.mysql.jdbc.Connection;
import com.xmlrpc.XmlRpcClient;
import com.xmlrpc.XmlRpcException;
import com.xmlrpc.XmlRpcFault;

public class PreBuild extends HttpServlet {
	private                                       static  final long serialVersionUID       = 1L;
       
    
    public PreBuild() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Map<String, String> config = Utils.getConfigFromFile(getServletContext(), "config.properties");
		HttpSession session=request.getSession(true);
		HttpSession session2=request.getSession(true);
	    String id=(String) session.getAttribute("id");
	    String appid=(String) session.getAttribute("appid");
	 response.setContentType("text/html");
	 String j1=(String) session.getAttribute("j1");      String j2=(String) session.getAttribute("j2");
     String j3=(String) session.getAttribute("j3");      String j4=(String) session.getAttribute("j4");
     String j5=(String) session.getAttribute("j5");      String j6=(String) session.getAttribute("j6");
     String j7=(String) session.getAttribute("j7");      String j8=(String) session.getAttribute("j8");
     String jv1=(String) session.getAttribute("jv1");      String jv2=(String) session.getAttribute("jv2");
     String jv3=(String) session.getAttribute("jv3");      String jv4=(String) session.getAttribute("jv4");
     String jv5=(String) session.getAttribute("jv5");      String jv6=(String) session.getAttribute("jv6");
     String jv7=(String) session.getAttribute("jv7");      String jv8=(String) session.getAttribute("jv8");
    //s out.println("inside"+j1+"---"+j2+"---"+j3);
	      try{
	    	  
	            Connection con;
				Class.forName("com.mysql.jdbc.Driver").newInstance();
	            con = (Connection) DriverManager.getConnection(config.get("URL"),config.get("USER"),config.get("PASS"));

	            String sam=null;
	             PreparedStatement st=null;
				 
			     st=con.prepareStatement("SELECT * FROM authen2  ORDER BY appid DESC LIMIT 1"); //change
                 ResultSet rs = st.executeQuery();
                 while(rs.next()){
                	 String appname1=rs.getString("appname");String appid1=rs.getString("appid");
                     String authen1=rs.getString("auth");String b1=rs.getString("b1");String b2=rs.getString("b2"); String mname=rs.getString("baseurl");
                     String b3=rs.getString("b3");String b4=rs.getString("b4");String ak1=rs.getString("a1");
                     String ak2=rs.getString("a2"); String cname1=rs.getString("cname");
                	 String ckey=rs.getString("ckey"); 
                	 String csecname=rs.getString("csecname");
                	 String cseckey=rs.getString("cseckey");
                	 String sname=rs.getString("sname");
                	 String svalue=rs.getString("svalue");
                	 String aurl=rs.getString("aurl");
                	 String tokenurl=rs.getString("tokenurl");
                	 String tlabel=rs.getString("tlabel");
                	 String treplace=rs.getString("treplace");
                	 String el1=rs.getString("el");
                	 String ev1=rs.getString("ev");
                     String rm1=rs.getString("rm");
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
                    String h1=rs.getString("h1");String hv1=rs.getString("hv1");
                    String h2=rs.getString("h2");String hv2=rs.getString("hv2");
                    String h3=rs.getString("h3");String hv3=rs.getString("hv3");
                    String h4=rs.getString("h4");String hv4=rs.getString("hv4");
                    String h5=rs.getString("h5");String hv5=rs.getString("hv5");
                     String f1=rs.getString("f1"); String f2=rs.getString("f2");
                     String f3=rs.getString("f3"); String f4=rs.getString("f4");
                     String f5=rs.getString("f5"); String f6=rs.getString("f6");
                     String f7=rs.getString("f7"); String f8=rs.getString("f8");
                     String f9=rs.getString("f9"); String f10=rs.getString("f10");
                     String eurl=null;
                     session2.setAttribute("appid", appid);
                     session2.setAttribute("appid1", appid1);
                    
                     if(authen1.equals("No Auth")){
        	        	 Object obj;
        	        	 String str="";
        	        	 	         
                          if( rm1.equals ("GET") && resf1.equals("XML") || resf1.equals("JSON")){  //No Auth XML get
        	        		 
        	        		 if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5) && !"null".equals(pa6) && !"null".equals(pa7) && !"null".equals(pa8) && !"null".equals(pa9) && !"null".equals(pa10)){
        		        		 eurl=endurl1+"?"+pa1+"="+pva1+"&"+pa2+"="+pva2+"&"+pa3+"="+pva3+"&"+pa4+"="+pva4+"&"+pa5+"="+pva5+"&"+pa6+"="+pva6+"&"+pa7+"="+pva7+"&"+pa8+"="+pva8+"&"+pa9+"="+pva9+"&"+pa10+"="+pva10;}
        	        		 
        	        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5) && !"null".equals(pa6) && !"null".equals(pa7) && !"null".equals(pa8) && !"null".equals(pa9)){
        		        		 eurl=endurl1+"?"+pa1+"="+pva1+"&"+pa2+"="+pva2+"&"+pa3+"="+pva3+"&"+pa4+"="+pva4+"&"+pa5+"="+pva5+"&"+pa6+"="+pva6+"&"+pa7+"="+pva7+"&"+pa8+"="+pva8+"&"+pa9+"="+pva9;}
        	        		 
        	        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5) && !"null".equals(pa6) && !"null".equals(pa7) && !"null".equals(pa8)){
        		        		 eurl=endurl1+"?"+pa1+"="+pva1+"&"+pa2+"="+pva2+"&"+pa3+"="+pva3+"&"+pa4+"="+pva4+"&"+pa5+"="+pva5+"&"+pa6+"="+pva6+"&"+pa7+"="+pva7+"&"+pa8+"="+pva8;}
        	        		 
        	        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5) && !"null".equals(pa6) && !"null".equals(pa7)){
        		        		 eurl=endurl1+"?"+pa1+"="+pva1+"&"+pa2+"="+pva2+"&"+pa3+"="+pva3+"&"+pa4+"="+pva4+"&"+pa5+"="+pva5+"&"+pa6+"="+pva6+"&"+pa7+"="+pva7;}
        	        		 
        	        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5) && !"null".equals(pa6)){
        	        		 eurl=endurl1+"?"+pa1+"="+pva1+"&"+pa2+"="+pva2+"&"+pa3+"="+pva3+"&"+pa4+"="+pva4+"&"+pa5+"="+pva5+"&"+pa6+"="+pva6;}
        	        		 
        	        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5)){
        		        		 eurl=endurl1+"?"+pa1+"="+pva1+"&"+pa2+"="+pva2+"&"+pa3+"="+pva3+"&"+pa4+"="+pva4+"&"+pa5+"="+pva5;}
        	        		 
        	        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4)){
        		        		 eurl=endurl1+"?"+pa1+"="+pva1+"&"+pa2+"="+pva2+"&"+pa3+"="+pva3+"&"+pa4+"="+pva4;}
        	        		 
        	        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3)){
        		        		 eurl=endurl1+"?"+pa1+"="+pva1+"&"+pa2+"="+pva2+"&"+pa3+"="+pva3;}
        	        		 
        	        		 else if(!"null".equals(pa1) && !"null".equals(pa2)){
        		        		 eurl=endurl1+"?"+pa1+"="+pva1+"&"+pa2+"="+pva2;}
        	        		 
        	        		 else if("".equals(pa1) && !"null".equals(pva1)){
        	        			  eurl=endurl1+"/"+pva1;}
        	        		 
        	        		 else if(!"null".equals(pa1)){
        		        		 eurl=endurl1+"?"+pa1+"="+pva1;}
        	        		 
        	           	        			 URL eurl1=new URL(eurl);
        		        		 URLConnection uconn = eurl1.openConnection();
        		        	     HttpURLConnection conn = (HttpURLConnection) uconn;
        		        	     conn.connect();
        		        	     Object content = conn.getContent();
        		        	     InputStream stream = (InputStream) content;
        		        	     String line=null;
        		        	     BufferedReader br=new BufferedReader(new InputStreamReader(stream));
        	        	   if(resf1.equals("XML")){
        	        	     while((line=br.readLine())!=null){
            	  	       	 str+=line;
            	  	       	 }
        	        	   }
        	        	    else if(resf1.equals("JSON")){
        	        	    	 while ((line = br.readLine()) != null)    { 
        	        	    	  JSON json = JSONSerializer.toJSON( line) ;
        	   	     	          XMLSerializer xmlSerializer = new XMLSerializer();  
        	   	     	          xmlSerializer.setTypeHintsEnabled(false);
        	   	     	          xmlSerializer.setSkipWhitespace(true);
        	   	     	          xmlSerializer.setTrimSpaces(true);
        	   	     	          xmlSerializer.setRemoveNamespacePrefixFromElements(true);
        	   	     	          xmlSerializer.removeNamespace(line);
        	   	     	          xmlSerializer.setRootName("root");
        	   	     	          xmlSerializer.setForceTopLevelObject(false);
        	   	     		      str = xmlSerializer.write( json );
        	   	    			
        	   	    		     }//while
        	        	    	 
        	        	     } // else if*/
        	        	    session2.setAttribute("xml1", str);
        		          out.println("<h2><center><font color='green'>Processing...</font></center></h3>");
        	     		        response.setHeader("Refresh", "1; URL=prebuild_xml.jsp");	
        	        	     
        	        	 } //XML and JSON get No Auth
        	        	               
                      else if(resf1.equals("REST") && rm1.equals ("GET") && resf1.equals("XML-RPC")) // No Auth XML-RPC
        	        	     
              	     {
                    	 
              	 		XmlRpcClient client = new XmlRpcClient( endurl1, false );
             	    	
              			HashMap mergeVars = new HashMap();
        	        		 if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5) && !"null".equals(pa6) && !"null".equals(pa7) && !"null".equals(pa8) && !"null".equals(pa9) && !"null".equals(pa10)){
        	        			 mergeVars.put(pa1,pva1);mergeVars.put(pa2,pva2);mergeVars.put(pa3,pva3);mergeVars.put(pa4,pva4);mergeVars.put(pa5,pva5);mergeVars.put(pa6,pva6);mergeVars.put(pa7,pva7);mergeVars.put(pa8,pva8);mergeVars.put(pa9,pva9);mergeVars.put(pa10,pva10);
        	        		 }
        	        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5) && !"null".equals(pa6) && !"null".equals(pa7) && !"null".equals(pa8) && !"null".equals(pa9)){
        	        			 mergeVars.put(pa1,pva1);mergeVars.put(pa2,pva2);mergeVars.put(pa3,pva3);mergeVars.put(pa4,pva4);mergeVars.put(pa5,pva5);mergeVars.put(pa6,pva6);mergeVars.put(pa7,pva7);mergeVars.put(pa8,pva8);mergeVars.put(pa9,pva9);}
        	        		 
        	        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5) && !"null".equals(pa6) && !"null".equals(pa7) && !"null".equals(pa8)){
        	        			 mergeVars.put(pa1,pva1);mergeVars.put(pa2,pva2);mergeVars.put(pa3,pva3);mergeVars.put(pa4,pva4);mergeVars.put(pa5,pva5);mergeVars.put(pa6,pva6);mergeVars.put(pa7,pva7);mergeVars.put(pa8,pva8);}
        	        		 
        	        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5) && !"null".equals(pa6) && !"null".equals(pa7)){
        	        			 mergeVars.put(pa1,pva1);mergeVars.put(pa2,pva2);mergeVars.put(pa3,pva3);mergeVars.put(pa4,pva4);mergeVars.put(pa5,pva5);mergeVars.put(pa6,pva6);mergeVars.put(pa7,pva7);}
              			
        	        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5) && !"null".equals(pa6)){
        	        			 mergeVars.put(pa1,pva1);mergeVars.put(pa2,pva2);mergeVars.put(pa3,pva3);mergeVars.put(pa4,pva4);mergeVars.put(pa5,pva5);mergeVars.put(pa6,pva6);}
        	        		 
        	        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5)){
        		        	    mergeVars.put(pa1,pva1);mergeVars.put(pa2,pva2);mergeVars.put(pa3,pva3);mergeVars.put(pa4,pva4);mergeVars.put(pa5,pva5);}
        	        		 
        	        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4)){
        	        			mergeVars.put(pa1,pva1);mergeVars.put(pa2,pva2);mergeVars.put(pa3,pva3);mergeVars.put(pa4,pva4);}
        	        		 
        	        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3)){
        	        			 mergeVars.put(pa1,pva1);mergeVars.put(pa2,pva2);mergeVars.put(pa3,pva3);}
        	        		 
        	        		 else if(!"null".equals(pa1) && !"null".equals(pa2)){
        	        			 mergeVars.put(pa1,pva1);mergeVars.put(pa2,pva2);}
              		 
        	        		 else if(!"null".equals(pa1)){
        	        			 mergeVars.put(pa1,pva1);}
        	        			 
        	        	     else if("null".equals(pa1)){mergeVars.put("", "");}
        	        		 Object token = null;
        	        			try {
        	        				token = client.invoke( mname,new Object[] {
        	        						mergeVars
        	        				});
        	        			} catch (XmlRpcException e) {
        	        				e.printStackTrace();
        	        			} catch (XmlRpcFault e) {
        	        				e.printStackTrace();
        	        			}
        	        		
        	 	  
             			  session2.setAttribute("xml1", resf1);
             			  session2.setAttribute("token", token);
             			 out.println("<h2><center><font color='green'>Processing...</font></center></h3>");
        	     		      response.setHeader("Refresh", "1; URL=prebuild_xml.jsp");	
          		   
        	     			
           		        
              	 } //XML RPC        

                       
                       else  if(resf1.equals("REST") && rm1.equals ("POST")){  // No Auth XML post
        	        		 
                  		 String USER_AGENT = "Mozilla/5.0";
        	        	 String url1=endurl1;	 	        		         		
        	        		//out.println(eurl);
        	        		 try
        	        		 {
        	        			 HttpClient client = new DefaultHttpClient();
        	        				HttpPost post = new HttpPost(url1);
        	        				post.setHeader("User-Agent", USER_AGENT);
        	        				List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        	        				urlParameters.add(new BasicNameValuePair(pa1, pva1));
        	        				urlParameters.add(new BasicNameValuePair(pa2, pva2));
        	        				urlParameters.add(new BasicNameValuePair(pa3, pva3));
        	        				urlParameters.add(new BasicNameValuePair(pa4, pva4));
        	        				urlParameters.add(new BasicNameValuePair(pa5, pva5));
        	        				urlParameters.add(new BasicNameValuePair(pa6, pva6));
        	        				urlParameters.add(new BasicNameValuePair(pa7, pva7));
        	        				urlParameters.add(new BasicNameValuePair(pa8, pva8));
        	        				urlParameters.add(new BasicNameValuePair(pa9, pva9));
        	        				urlParameters.add(new BasicNameValuePair(pa10, pva10));
        	        				post.setEntity(new UrlEncodedFormEntity(urlParameters));
        	        				HttpResponse response1 = client.execute(post);
        	        				BufferedReader br = new BufferedReader(
        	                                new InputStreamReader(response1.getEntity().getContent()));
        	         
        	        		StringBuffer result = new StringBuffer();
        	        		String line = "";
        	        	     if(resf1.equals("XML")){
        	        	     while((line=br.readLine())!=null){
        	         	 	  	       		     str+=line;}
        	        		 }
        	        		 else if(resf1.equals("JSON")){
        	        			 while ((line = br.readLine()) != null)    { 
        	 	        	    	
        	   	         		  JSON json = JSONSerializer.toJSON( line)  ;
        	   	     	          XMLSerializer xmlSerializer = new XMLSerializer();  
        	   	     	          xmlSerializer.setTypeHintsEnabled(false);
        	   	     	          xmlSerializer.setSkipWhitespace(true);
        	   	     	          xmlSerializer.setTrimSpaces(true);
        	   	     	          xmlSerializer.setRemoveNamespacePrefixFromElements(true);
        	   	     	          xmlSerializer.removeNamespace(line);
        	   	     	          xmlSerializer.setRootName("root");
        	   	     	          xmlSerializer.setForceTopLevelObject(false);
        	   	     		      str = xmlSerializer.write( json );
        	        		 } //while
        	        		 } //if
        	        		 }//try
        	         	     catch(Exception e){
        	 	    	    //  out.println(e);
        	 	    	      }	
        	        		 session2.setAttribute("xml1", str);
        	        		 out.println("<h2><center><font color='green'>Processing...</font></center></h3>");
        	     		        response.setHeader("Refresh", "1; URL=prebuild_xml.jsp");	
        	               	} //  post
        	        	        	 
        	         }    // No Auth  
        	               
        	         
        	         if(authen1.equals("API keys")){  //API Keys
                	     String str="";
                         Object obj;
        	        	 if(rm1.equals ("GET") && resf1.equals("XML") || resf1.equals("JSON")){  //API XML get
        	        		 
        	        		 if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5) && !"null".equals(pa6) && !"null".equals(pa7) && !"null".equals(pa8) && !"null".equals(pa9) && !"null".equals(pa10)){
        		        		 eurl=endurl1+"?"+ak1+"="+ak2+"&"+pa1+"="+pva1+"&"+pa2+"="+pva2+"&"+pa3+"="+pva3+"&"+pa4+"="+pva4+"&"+pa5+"="+pva5+"&"+pa6+"="+pva6+"&"+pa7+"="+pva7+"&"+pa8+"="+pva8+"&"+pa9+"="+pva9+"&"+pa10+"="+pva10;}
        	        		 
        	        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5) && !"null".equals(pa6) && !"null".equals(pa7) && !"null".equals(pa8) && !"null".equals(pa9)){
        		        		 eurl=endurl1+"?"+ak1+"="+ak2+"&"+pa1+"="+pva1+"&"+pa2+"="+pva2+"&"+pa3+"="+pva3+"&"+pa4+"="+pva4+"&"+pa5+"="+pva5+"&"+pa6+"="+pva6+"&"+pa7+"="+pva7+"&"+pa8+"="+pva8+"&"+pa9+"="+pva9;}
        	        		 
        	        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5) && !"null".equals(pa6) && !"null".equals(pa7) && !"null".equals(pa8)){
        		        		 eurl=endurl1+"?"+ak1+"="+ak2+"&"+pa1+"="+pva1+"&"+pa2+"="+pva2+"&"+pa3+"="+pva3+"&"+pa4+"="+pva4+"&"+pa5+"="+pva5+"&"+pa6+"="+pva6+"&"+pa7+"="+pva7+"&"+pa8+"="+pva8;}
        	        		 
        	        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5) && !"null".equals(pa6) && !"null".equals(pa7)){
        		        		 eurl=endurl1+"?"+ak1+"="+ak2+"&"+pa1+"="+pva1+"&"+pa2+"="+pva2+"&"+pa3+"="+pva3+"&"+pa4+"="+pva4+"&"+pa5+"="+pva5+"&"+pa6+"="+pva6+"&"+pa7+"="+pva7;}
        	        		 
        	        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5) && !"null".equals(pa6)){
        	        		 eurl=endurl1+"?"+ak1+"="+ak2+"&"+pa1+"="+pva1+"&"+pa2+"="+pva2+"&"+pa3+"="+pva3+"&"+pa4+"="+pva4+"&"+pa5+"="+pva5+"&"+pa6+"="+pva6;}
        	        		 
        	        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5)){
        		        		 eurl=endurl1+"?"+ak1+"="+ak2+"&"+pa1+"="+pva1+"&"+pa2+"="+pva2+"&"+pa3+"="+pva3+"&"+pa4+"="+pva4+"&"+pa5+"="+pva5;}
        	        		 
        	        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4)){
        		        		 eurl=endurl1+"?"+ak1+"="+ak2+"&"+pa1+"="+pva1+"&"+pa2+"="+pva2+"&"+pa3+"="+pva3+"&"+pa4+"="+pva4;}
        	        		 
        	        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3)){
        		        		 eurl=endurl1+"?"+ak1+"="+ak2+"&"+pa1+"="+pva1+"&"+pa2+"="+pva2+"&"+pa3+"="+pva3;}
        	        		 
        	        		 else if(!"null".equals(pa1) && !"null".equals(pa2)){
        		        		 eurl=endurl1+"?"+ak1+"="+ak2+"&"+pa1+"="+pva1+"&"+pa2+"="+pva2;}
        	        		 
        	        		 else if(!"null".equals(pa1)){
        		        		 eurl=endurl1+"?"+ak1+"="+ak2+"&"+pa1+"="+pva1;}
        	        		 else if("null".equals(pa1))
        	        			eurl=endurl1+"?"+ak1+"="+ak2;
        	        		 
        	        		 else if("null".equals(ak1) && "null".equals(ak2))
        	        			 eurl=endurl1;	        		
        	        		
        	        			 
        	        		 URL eurl1=new URL(eurl);
        	        		 URLConnection uconn = eurl1.openConnection();
        	        	     HttpURLConnection conn = (HttpURLConnection) uconn;
        	        	     conn.connect();
        	        	     Object content = conn.getContent();
        	        	     InputStream stream = (InputStream) content;
        	        	     String line=null;
        	        	     BufferedReader br=new BufferedReader(new InputStreamReader(stream));
        	        	    if(resf1.equals("XML")){
        	        	     while((line=br.readLine())!=null){
            	  	       	 str+=line;
            	  	       	 }
        	        	     }
        	        	     else if(resf1.equals("JSON")){
        	        	    	 while ((line = br.readLine()) != null)    { 
        	        	    	  JSON json = JSONSerializer.toJSON( line) ;
        	   	     	          XMLSerializer xmlSerializer = new XMLSerializer();  
        	   	     	          xmlSerializer.setTypeHintsEnabled(false);
        	   	     	          xmlSerializer.setSkipWhitespace(true);
        	   	     	          xmlSerializer.setTrimSpaces(true);
        	   	     	          xmlSerializer.setRemoveNamespacePrefixFromElements(true);
        	   	     	          xmlSerializer.removeNamespace(line);
        	   	     	          xmlSerializer.setRootName("root");
        	   	     	          xmlSerializer.setForceTopLevelObject(false);
        	   	     		      str = xmlSerializer.write( json );
        	   	    			
        	   	    		     }//while
        	        	    	 
        	        	     } // else if
        	        	    session2.setAttribute("xml1", str);
        		            out.println("<h2><center><font color='green'>Processing...</font></center></h3>");
        	     		        response.setHeader("Refresh", "1; URL=prebuild_xml.jsp");	
        	        	     
        	        	 } //XML and JSON get
        	        	     
        	        	     else if(resf1.equals("REST") && rm1.equals ("GET") && resf1.equals("XML-RPC"))
        	        	     
        	        	     {
        	        	 		XmlRpcClient client = new XmlRpcClient( endurl1, false );
        	        	    	HashMap mergeVars = new HashMap();
        		        		 if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5) && !"null".equals(pa6) && !"null".equals(pa7) && !"null".equals(pa8) && !"null".equals(pa9) && !"null".equals(pa10)){
        		        			 mergeVars.put(ak1, ak2);mergeVars.put(pa1,pva1);mergeVars.put(pa2,pva2);mergeVars.put(pa3,pva3);mergeVars.put(pa4,pva4);mergeVars.put(pa5,pva5);mergeVars.put(pa6,pva6);mergeVars.put(pa7,pva7);mergeVars.put(pa8,pva8);mergeVars.put(pa9,pva9);mergeVars.put(pa10,pva10);
        		        		 }
        		        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5) && !"null".equals(pa6) && !"null".equals(pa7) && !"null".equals(pa8) && !"null".equals(pa9)){
        		        			 mergeVars.put(ak1, ak2);mergeVars.put(pa1,pva1);mergeVars.put(pa2,pva2);mergeVars.put(pa3,pva3);mergeVars.put(pa4,pva4);mergeVars.put(pa5,pva5);mergeVars.put(pa6,pva6);mergeVars.put(pa7,pva7);mergeVars.put(pa8,pva8);mergeVars.put(pa9,pva9);}
        		        		 
        		        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5) && !"null".equals(pa6) && !"null".equals(pa7) && !"null".equals(pa8)){
        		        			 mergeVars.put(ak1, ak2);mergeVars.put(pa1,pva1);mergeVars.put(pa2,pva2);mergeVars.put(pa3,pva3);mergeVars.put(pa4,pva4);mergeVars.put(pa5,pva5);mergeVars.put(pa6,pva6);mergeVars.put(pa7,pva7);mergeVars.put(pa8,pva8);}
        		        		 
        		        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5) && !"null".equals(pa6) && !"null".equals(pa7)){
        		        			 mergeVars.put(ak1, ak2);mergeVars.put(pa1,pva1);mergeVars.put(pa2,pva2);mergeVars.put(pa3,pva3);mergeVars.put(pa4,pva4);mergeVars.put(pa5,pva5);mergeVars.put(pa6,pva6);mergeVars.put(pa7,pva7);}
        	        			
        		        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5) && !"null".equals(pa6)){
        		        			 mergeVars.put(ak1, ak2);mergeVars.put(pa1,pva1);mergeVars.put(pa2,pva2);mergeVars.put(pa3,pva3);mergeVars.put(pa4,pva4);mergeVars.put(pa5,pva5);mergeVars.put(pa6,pva6);}
        		        		 
        		        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5)){
        			        			 mergeVars.put(ak1, ak2);mergeVars.put(pa1,pva1);mergeVars.put(pa2,pva2);mergeVars.put(pa3,pva3);mergeVars.put(pa4,pva4);mergeVars.put(pa5,pva5);}
        		        		 
        		        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4)){
        		        			 mergeVars.put(ak1, ak2);mergeVars.put(pa1,pva1);mergeVars.put(pa2,pva2);mergeVars.put(pa3,pva3);mergeVars.put(pa4,pva4);}
        		        		 
        		        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3)){
        		        			 mergeVars.put(ak1, ak2);mergeVars.put(pa1,pva1);mergeVars.put(pa2,pva2);mergeVars.put(pa3,pva3);}
        		        		 
        		        		 else if(!"null".equals(pa1) && !"null".equals(pa2)){
        		        			 mergeVars.put(ak1, ak2);mergeVars.put(pa1,pva1);mergeVars.put(pa2,pva2);}
        	        		 
        		        		 else if(!"null".equals(pa1)){
        		        			 mergeVars.put(ak1, ak2);mergeVars.put(pa1,pva1);}
        		        			 
        		        			 else if("null".equals(pa1)){mergeVars.put(ak1, ak2);}
        		     			
        		        		
        		        		 Object token = null;
        		        			try {
        		        				token = client.invoke( mname,new Object[] {
        		        						mergeVars
        		        				});
        		        			} catch (XmlRpcException e) {
        		        				// TODO Auto-generated catch block
        		        				e.printStackTrace();
        		        			} catch (XmlRpcFault e) {
        		        				// TODO Auto-generated catch block
        		        				e.printStackTrace();
        		        			}
        		     			
        		        		     	 	  
        	        			  session2.setAttribute("xml1", resf1);
        	        			  session2.setAttribute("token", token);
        	          			 out.println("<h2><center><font color='green'>Processing...</font></center></h3>");

        		     		      response.setHeader("Refresh", "1; URL=prebuild_xml.jsp");	
        	     		        
        	        	 } //XML RPC        */	 
        	        	 if(resf1.equals("REST") && rm1.equals ("POST")){  // apikey XML post
        	        		 
        	          		 String USER_AGENT = "Mozilla/5.0";
        		        	 String url1=endurl1;
        		        		 try
        		        		 {
        		        			 HttpClient client = new DefaultHttpClient();
        		        				HttpPost post = new HttpPost(url1);
        		        				post.setHeader("User-Agent", USER_AGENT);
        		        				List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        		        				urlParameters.add(new BasicNameValuePair(ak1, ak2));
        		        				urlParameters.add(new BasicNameValuePair(pa1, pva1));
        		        				urlParameters.add(new BasicNameValuePair(pa2, pva2));
        		        				urlParameters.add(new BasicNameValuePair(pa3, pva3));
        		        				urlParameters.add(new BasicNameValuePair(pa4, pva4));
        		        				urlParameters.add(new BasicNameValuePair(pa5, pva5));
        		        				urlParameters.add(new BasicNameValuePair(pa6, pva6));
        		        				urlParameters.add(new BasicNameValuePair(pa7, pva7));
        		        				urlParameters.add(new BasicNameValuePair(pa8, pva8));
        		        				urlParameters.add(new BasicNameValuePair(pa9, pva9));
        		        				urlParameters.add(new BasicNameValuePair(pa10, pva10));
        		        				post.setEntity(new UrlEncodedFormEntity(urlParameters));
        		        				HttpResponse response1 = client.execute(post);
        		        				BufferedReader br = new BufferedReader(
        		                                new InputStreamReader(response1.getEntity().getContent()));
        		         
        		        		StringBuffer result = new StringBuffer();
        		        		String line = "";
        		        	     if(resf1.equals("XML")){
        		        	     while((line=br.readLine())!=null){
        		         	 	  	       		     str+=line;}
        		        		 }
        		        		 else if(resf1.equals("JSON")){
        		        			 while ((line = br.readLine()) != null)    { 
        		 	        	    	
        		   	         		  JSON json = JSONSerializer.toJSON( line)  ;
        		   	     	          XMLSerializer xmlSerializer = new XMLSerializer();  
        		   	     	          xmlSerializer.setTypeHintsEnabled(false);
        		   	     	          xmlSerializer.setSkipWhitespace(true);
        		   	     	          xmlSerializer.setTrimSpaces(true);
        		   	     	          xmlSerializer.setRemoveNamespacePrefixFromElements(true);
        		   	     	          xmlSerializer.removeNamespace(line);
        		   	     	          xmlSerializer.setRootName("root");
        		   	     	          xmlSerializer.setForceTopLevelObject(false);
        		   	     		      str = xmlSerializer.write( json );
        		        		 } //while
        		        		 } //if
        		        		 }//try
        		         	     catch(Exception e){
        		 	    	    //  out.println(e);
        		         	    	 }	
        		        		 session2.setAttribute("xml1", str);
        		     			 out.println("<h2><center><font color='green'>Processing...</font></center></h3>");

        		     		        response.setHeader("Refresh", "1; URL=prebuild_xml.jsp");	
        		               	}//post 
        	        	 
        	         }  // API keys  
        	         
                    //Basic Auth
        	         
        	         else if(authen1.equals("Basic Auth")){ //m15
        	        	// out.println("innnnn");
        	        	 if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5) && !"null".equals(pa6) && !"null".equals(pa7) && !"null".equals(pa8) && !"null".equals(pa9) && !"null".equals(pa10)){
        	        		 eurl=pa1+"="+pva1+"&"+pa2+"="+pva2+"&"+pa3+"="+pva3+"&"+pa4+"="+pva4+"&"+pa5+"="+pva5+"&"+pa6+"="+pva6+"&"+pa7+"="+pva7+"&"+pa8+"="+pva8+"&"+pa9+"="+pva9+"&"+pa10+"="+pva10;}
                		 
                		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5) && !"null".equals(pa6) && !"null".equals(pa7) && !"null".equals(pa8) && !"null".equals(pa9)){
        	        		 eurl=pa1+"="+pva1+"&"+pa2+"="+pva2+"&"+pa3+"="+pva3+"&"+pa4+"="+pva4+"&"+pa5+"="+pva5+"&"+pa6+"="+pva6+"&"+pa7+"="+pva7+"&"+pa8+"="+pva8+"&"+pa9+"="+pva9;}
                		 
                		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5) && !"null".equals(pa6) && !"null".equals(pa7) && !"null".equals(pa8)){
        	        		 eurl=pa1+"="+pva1+"&"+pa2+"="+pva2+"&"+pa3+"="+pva3+"&"+pa4+"="+pva4+"&"+pa5+"="+pva5+"&"+pa6+"="+pva6+"&"+pa7+"="+pva7+"&"+pa8+"="+pva8;}
                		 
                		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5) && !"null".equals(pa6) && !"null".equals(pa7)){
        	        		 eurl=pa1+"="+pva1+"&"+pa2+"="+pva2+"&"+pa3+"="+pva3+"&"+pa4+"="+pva4+"&"+pa5+"="+pva5+"&"+pa6+"="+pva6+"&"+pa7+"="+pva7;}
                		 
                		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5) && !"null".equals(pa6)){
                		 eurl=pa1+"="+pva1+"&"+pa2+"="+pva2+"&"+pa3+"="+pva3+"&"+pa4+"="+pva4+"&"+pa5+"="+pva5+"&"+pa6+"="+pva6;}
                		 
                		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5)){
        	        		 eurl=pa1+"="+pva1+"&"+pa2+"="+pva2+"&"+pa3+"="+pva3+"&"+pa4+"="+pva4+"&"+pa5+"="+pva5;}
                		 
                		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4)){
        	        		 eurl=pa1+"="+pva1+"&"+pa2+"="+pva2+"&"+pa3+"="+pva3+"&"+pa4+"="+pva4;}
                		 
                		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3)){
        	        		 eurl=pa1+"="+pva1+"&"+pa2+"="+pva2+"&"+pa3+"="+pva3;}
                		 
                		 else if(!"null".equals(pa1) && !"null".equals(pa2)){
        	        		 eurl=pa1+"="+pva1+"&"+pa2+"="+pva2;}
                		 
                		 else if(!"null".equals(pa1)){
        	        		 eurl=pa1+"="+pva1;}
                		 else if("null".equals(pa1))
                			eurl="filter=''";
        	        	 
        	        	 
        	        	 String str="";
        	        	 try{
        		          if(rm1.equals("GET")){ 
        		        		URL url1;

        		              if(!"".equals(eurl))
        	    	               url1 = new URL (endurl1+"?"+eurl);
        		              else
        		                   url1 =new URL(endurl1);
        	              HttpURLConnection connection = (HttpURLConnection) url1.openConnection();
                          connection.setDoOutput(true);
                          connection.setDoInput(true);
        	              connection.setRequestMethod("GET");
        	              String encoding=null;
        	            	 if(!"null".equals(b2)&& "null".equals(b4)){
        	            		 encoding = new String(
        	                    		 org.apache.commons.codec.binary.Base64.encodeBase64   
        	                    		    (org.apache.commons.codec.binary.StringUtils.getBytesUtf8(b2+":"+""))
        	                    		  );
        	   	              connection.setRequestProperty  ("Authorization", "Basic " + encoding);

        	            	 }
        	            	 else if(!"null".equals(b4) && "null".equals(b2)){encoding = new String(
                		 org.apache.commons.codec.binary.Base64.encodeBase64   
             		    (org.apache.commons.codec.binary.StringUtils.getBytesUtf8(""+":"+b4))
             		  );	              
        	            	 connection.setRequestProperty  ("Authorization", "Basic " + encoding);
        }
        	            	 else if(!"null".equals(b2) && !"null".equals(b4)){
        	            		 encoding = new String(
        	                    		 org.apache.commons.codec.binary.Base64.encodeBase64   
        	                    		    (org.apache.commons.codec.binary.StringUtils.getBytesUtf8(b2+":"+b4))
        	                    		  );
        	   	              connection.setRequestProperty  ("Authorization", "Basic " + encoding);

        	   	            	 } // else if encoding
        	            	 else if("null".equals(b2) && "null".equals(b4)){
        	            		 encoding=null;
        	            	 }
        	            	 
        	              if(!"".equals(h1) && !"".equals(h2) && !"".equals(h3) && !"".equals(h4) && !"".equals(h5)){
        	            	connection.setRequestProperty(h1, hv1);connection.setRequestProperty(h2, hv2); connection.setRequestProperty(h3, hv3);connection.setRequestProperty(h4, hv4);connection.setRequestProperty(h5, hv5);  
        	              }
        	              else if(!"".equals(h1) && !"".equals(h2) && !"".equals(h3) && !"".equals(h4)){
        	            	connection.setRequestProperty(h1, hv1);connection.setRequestProperty(h2, hv2); connection.setRequestProperty(h3, hv3);connection.setRequestProperty(h4, hv4);  
        	              }
        	              else if(!"".equals(h1) && !"".equals(h2) && !"".equals(h3)){
        		            	connection.setRequestProperty(h1, hv1);connection.setRequestProperty(h2, hv2); connection.setRequestProperty(h3, hv3);  
        		              }
        	              else if(!"".equals(h1) && !"".equals(h2)){
        		            	connection.setRequestProperty(h1, hv1);connection.setRequestProperty(h2, hv2);  
        		              }
        	              else if(!"".equals(h1)){
        		            	connection.setRequestProperty(h1, hv1);  
        		              }
        	              String line=null;
        	              InputStream content = (InputStream)connection.getInputStream();
        	              StringBuilder strb=new StringBuilder();String strcon="";
        	                 BufferedReader in   = new BufferedReader (new InputStreamReader (content));
        	              if(resf1.equals("XML")){
        	                    while((line=in.readLine())!=null){
        	                    	str+=line;
        	                    }} // while and xml
        	              else if(resf1.equals("JSON")){
        	            	  while ((line = in.readLine()) != null)    { 
    	        	    	      strb.append(line);
    	   	    		     }//while
    	        	    	 strcon=strb.toString();
    	        	    	 XMLSerializer serializer = new XMLSerializer();
    	     	            JSON json = JSONSerializer.toJSON(strcon);
    	     	            serializer.setRootName("root");
    	     	            serializer.setTypeHintsEnabled(false);
    	     	            str = serializer.write(json);
        	              }//json
        	              session.setAttribute("xml1", str);
        	              out.println("<html style='background-color:#ff9900;'><h2><center><font color='#000000;'>Processing...</font></center></h3><br><br><br><br>"
        		             		+ "<br><br><br><br><center><img style='height:100px;width:100px;' src='images/load.gif'></center><html>");
             		        response.setHeader("Refresh", "1; URL=prebuild_xml.jsp");	
        		          }//get
        	              else if(rm1.equals("POST")){ 
        	            	  URL url1 = new URL (endurl1);
        	            	  HttpURLConnection connection = (HttpURLConnection) url1.openConnection();
        	            	  connection.setDoInput(true);   
        	            	  connection.setDoOutput(true);  
        	            	  connection.setUseCaches(false);  
        		              connection.setRequestMethod("POST");
        	            	  connection.connect();  
        	                  DataOutputStream wr = new DataOutputStream(connection.getOutputStream ());
        		              wr.writeBytes(eurl);
        		              wr.flush();
        		              wr.close();
        	              String encoding=null;
        	            	 if(!"null".equals(b2)&& "null".equals(b4)){
        	            		 encoding = new String(
        	                    		 org.apache.commons.codec.binary.Base64.encodeBase64   
        	                    		    (org.apache.commons.codec.binary.StringUtils.getBytesUtf8(b2+":"+""))
        	                    		  );
        	   	              connection.setRequestProperty  ("Authorization", "Basic " + encoding);

        	            	 }
        	            	 else if(!"null".equals(b4) && "null".equals(b2)){encoding = new String(
                   		 org.apache.commons.codec.binary.Base64.encodeBase64   
                		    (org.apache.commons.codec.binary.StringUtils.getBytesUtf8(""+":"+b4))
                		    
                		  );	              connection.setRequestProperty  ("Authorization", "Basic " + encoding);
        }
        	            	 else if(!"null".equals(b2) && !"null".equals(b4)){
        	            		 encoding = new String(
        	                    		 org.apache.commons.codec.binary.Base64.encodeBase64   
        	                    		    (org.apache.commons.codec.binary.StringUtils.getBytesUtf8(b2+":"+b4))
        	                    		  );
        	   	              connection.setRequestProperty  ("Authorization", "Basic " + encoding);

        	   	            	 } 
        	            	 
        	            	 else if("null".equals(b2) && "null".equals(b4)){encoding=null;}
        	            	 out.println("inside...aaa");
        	            	 
        	              if(!"".equals(h1) && !"".equals(h2) && !"".equals(h3) && !"".equals(h4) && !"".equals(h5)){
        		            	connection.setRequestProperty(h1, hv1);connection.setRequestProperty(h2, hv2); connection.setRequestProperty(h3, hv3);connection.setRequestProperty(h4, hv4);connection.setRequestProperty(h5, hv5);  
        		              }
        		              else if(!"".equals(h1) && !"".equals(h2) && !"".equals(h3) && !"".equals(h4)){
        		            	connection.setRequestProperty(h1, hv1);connection.setRequestProperty(h2, hv2); connection.setRequestProperty(h3, hv3);connection.setRequestProperty(h4, hv4);  
        		              }
        		              else if(!"".equals(h1) && !"".equals(h2) && !"".equals(h3)){
        			            	connection.setRequestProperty(h1, hv1);connection.setRequestProperty(h2, hv2); connection.setRequestProperty(h3, hv3);  
        			              }
        		              else if(!"".equals(h1) && !"".equals(h2)){
        			            	connection.setRequestProperty(h1, hv1);connection.setRequestProperty(h2, hv2);  
        			              }
        		              else if(!"".equals(h1)){
        			            	connection.setRequestProperty(h1, hv1);  
        			              }
        	              InputStream content = (InputStream)connection.getInputStream();
        	              BufferedReader in   = new BufferedReader (new InputStreamReader (content));
                          
                         String line=null;
        	              if(resf1.equals("XML")){
        	                    while((line=in.readLine())!=null){
        	                    	str+=line;
        	                    }} // while and xml
        	              else if(resf1.equals("JSON")){
        	            	  while((line=in.readLine())!=null){
        	            		  JSON json = JSONSerializer.toJSON( line );  
        		     	          XMLSerializer xmlSerializer = new XMLSerializer();  
        		     	          xmlSerializer.setTypeHintsEnabled(false);
        		     	          xmlSerializer.setSkipWhitespace(true);
        		     	          xmlSerializer.setTrimSpaces(true);
        		     	          xmlSerializer.setRemoveNamespacePrefixFromElements(true);
        		     	          xmlSerializer.removeNamespace(line);
        		     	          xmlSerializer.setForceTopLevelObject(false);
        		     		      str = xmlSerializer.write( json );
        		     		      //out.println(xmlout);
        	            	  }}//while
        	            	  session.setAttribute("xml1", str);
        	            	  out.println("<html style='background-color:#ff9900;'><h2><center><font color='#000000;'>Processing...</font></center></h3><br><br><br><br>"
        	  	             		+ "<br><br><br><br><center><img style='height:100px;width:100px;' src='images/load.gif'></center><html>");
        	     		        response.setHeader("Refresh", "1; URL=prebuild_xml.jsp");	
        	              //post
        	           
        	                            
        	                	
        	              } //  else-if json
        	              else if(rm1.equals("POST_JSON")){
        	            	 //out.println("inside"+j1+"---"+j2+"---"+j3);
        	            		  DefaultHttpClient httpClient = new DefaultHttpClient();
        	            			HttpPost postRequest = new HttpPost(endurl1);
        	            			if(j1!=null && j2!=null && j3!=null && j4!=null && j5!=null && j6!=null && j7!=null && j8!=null ){
        			         			StringEntity input = new StringEntity("{\""+j1+"\":\""+jv1+"\",\""+j2+"\":\""+jv2+"\",\""+j3+"\":\""+jv3+"\",\""+j4+"\":\""+jv4+"\",\""+j5+"\":\""+jv5+"\",\""+j6+"\":\""+jv6+"\",\""+j7+"\":\""+jv7+"\",\""+j8+"\":\""+jv8+"\"}");
        			         			input.setContentType("application/json");
        			         			postRequest.setEntity(input);}
        	            			else if(j1!=null && j2!=null && j3!=null && j4!=null && j5!=null && j6!=null && j7!=null ){
        			         			StringEntity input = new StringEntity("{\""+j1+"\":\""+jv1+"\",\""+j2+"\":\""+jv2+"\",\""+j3+"\":\""+jv3+"\",\""+j4+"\":\""+jv4+"\",\""+j5+"\":\""+jv5+"\",\""+j6+"\":\""+jv6+"\",\""+j7+"\":\""+jv7+"\"}");
        			         			input.setContentType("application/json");
        			         			postRequest.setEntity(input);}
        	            			else if(j1!=null && j2!=null && j3!=null && j4!=null && j5!=null && j6!=null ){
        			         			StringEntity input = new StringEntity("{\""+j1+"\":\""+jv1+"\",\""+j2+"\":\""+jv2+"\",\""+j3+"\":\""+jv3+"\",\""+j4+"\":\""+jv4+"\",\""+j5+"\":\""+jv5+"\",\""+j6+"\":\""+jv6+"\"}");
        			         			input.setContentType("application/json");
        			         			postRequest.setEntity(input);}
        	            			else if(j1!=null && j2!=null && j3!=null && j4!=null && j5!=null){
        			         			StringEntity input = new StringEntity("{\""+j1+"\":\""+jv1+"\",\""+j2+"\":\""+jv2+"\",\""+j3+"\":\""+jv3+"\",\""+j4+"\":\""+jv4+"\",\""+j5+"\":\""+jv5+"\"}");
        			         			input.setContentType("application/json");
        			         			postRequest.setEntity(input);}
        	            			else if(j1!=null && j2!=null && j3!=null && j4!=null){
        			         			StringEntity input = new StringEntity("{\""+j1+"\":\""+jv1+"\",\""+j2+"\":\""+jv2+"\",\""+j3+"\":\""+jv3+"\",\""+j4+"\":\""+jv4+"\"}");
        			         			input.setContentType("application/json");
        			         			postRequest.setEntity(input);} // */
        	            			else if(j1!=null && j2!=null && j3!=null ){
        	            				StringEntity input = new StringEntity("{\""+j1+"\":\""+jv1+"\",\""+j2+"\":\""+jv2+"\",\""+j3+"\":\""+jv3+"\"}");
        		            		   input.setContentType("application/json");
        		            		   postRequest.setEntity(input); }
        		         		 
        		         		 else if(j1!=null && j2!=null){
        		         			StringEntity input = new StringEntity("{\""+j1+"\":\""+jv1+"\",\""+j2+"\":\""+jv2+"\"}");
        		         			input.setContentType("application/json");
        		         			postRequest.setEntity(input);}
        		         		 else if(j1!=null){
        		         			StringEntity input = new StringEntity("{\""+j1+"\":\""+jv1+"\"}");
        		         			input.setContentType("application/json");
        		         			postRequest.setEntity(input);}
        		            	   
        		            	   String encoding = new String(
        		          		   		 org.apache.commons.codec.binary.Base64.encodeBase64   
        		          		   		    (org.apache.commons.codec.binary.StringUtils.getBytesUtf8(b2+":"+b4))
        		          		   		  );
        		          		postRequest.setHeader("Authorization","Basic " + encoding);
        	            			
        	            	 
        	            			HttpResponse response1 = httpClient.execute(postRequest);
        	            	 
        	            			BufferedReader in = new BufferedReader(
        	            	                        new InputStreamReader((response1.getEntity().getContent())));
        	            			String line="";
        	            			if(resf1.equals("XML")){
        	    	                    while((line=in.readLine())!=null){
        	    	                    	str+=line;
        	    	                    }} // while and xml
        	    	              else if(resf1.equals("JSON")){
        	    	            	  while((line=in.readLine())!=null){
        	    	            		  JSON json = JSONSerializer.toJSON( line );  
        	    		     	          XMLSerializer xmlSerializer = new XMLSerializer();  
        	    		     	          xmlSerializer.setTypeHintsEnabled(false);
        	    		     	          xmlSerializer.setSkipWhitespace(true);
        	    		     	          xmlSerializer.setTrimSpaces(true);
        	    		     	          xmlSerializer.setRemoveNamespacePrefixFromElements(true);
        	    		     	          xmlSerializer.removeNamespace(line);
        	    		     	          xmlSerializer.setForceTopLevelObject(false);
        	    		     		      str = xmlSerializer.write( json );
        	    		     		      //out.println(xmlout);
        	    	            	  }}//while
        	            			httpClient.getConnectionManager().shutdown();
        	    	            	  session.setAttribute("xml1", str);
        	    	            	  out.println("<html style='background-color:#ff9900;'><h2><center><font color='#000000;'>Processing...</font></center></h3><br><br><br><br>"
        	    	  	             		+ "<br><br><br><br><center><img style='height:100px;width:100px;' src='images/load.gif'></center><html>");
        	    	     		        response.setHeader("Refresh", "1; URL=prebuild_xml.jsp");	
        	            	 
        	            			
        		            	  
        		              }
        	              
        	             }//try
        	              
        	   	             catch(Exception e){
        	   	            	 out.println(e);
        	   	            	 }
        	   	          
        	        	 
        	        	 
        	         }// Basic Auth
        	         //m15  //m16 //m17
        	         

        	         
        	         else if(authen1.equals("Oauth2")){
        		 			HttpClient client=new DefaultHttpClient();
        	                String Response=null;
        		        	HttpSession session1=request.getSession(true);
        			     	String access_token=(String)session1.getAttribute("access_token");
        			     	String GetResponse=null;
        		     		 StringBuilder result=new StringBuilder();
        		     			String line = "";


        			     	if(rm1.equals("GET")){ 
        			     	//GetMethod get=new GetMethod(tokenurl);
        			     	if("Authorization:Bearer".equals(treplace)){
        			     		HttpGet get=new HttpGet(endurl1);
        				       get.addHeader("Authorization", "Bearer "+access_token);
        			     		HttpResponse response1 = client.execute(get);
        			     		BufferedReader rd = new BufferedReader(
        			     				new InputStreamReader(response1.getEntity().getContent()));
        			     			while ((line = rd.readLine()) != null) {
        			     				GetResponse=line;
        			     			}
        		     	
        			     	}   // auth bearer treplace
        			     	else if("QueryString".equals(treplace)){
        			     		String param = null;
        			     	   List<NameValuePair> params = new LinkedList<NameValuePair>();

        			     		 if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5) && !"null".equals(pa6))
        			     			 param=tlabel+"="+access_token+"&"+pa1+"="+pva1+"&"+pa2+"="+pva2+"&"+pa3+"="+pva3+"&"+pa4+"="+pva4+"&"+pa5+"="+pva5+"&"+pa6+"="+pva6;
        			        		 
        			             else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5))
        	                         param=tlabel+"="+access_token+"&"+pa1+"="+pva1+"&"+pa2+"="+pva2+"&"+pa3+"="+pva3+"&"+pa4+"="+pva4+"&"+pa5+"="+pva5;

        			     	
        			              else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4))
        		                         param=tlabel+"="+access_token+"&"+pa1+"="+pva1+"&"+pa2+"="+pva2+"&"+pa3+"="+pva3+"&"+pa4+"="+pva4;

        			              else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3))
        		                         param=tlabel+"="+access_token+"&"+pa1+"="+pva1+"&"+pa2+"="+pva2+"&"+pa3+"="+pva3;

        			        	  else if(!"null".equals(pa1) && !"null".equals(pa2))
        		                         param=tlabel+"="+access_token+"&"+pa1+"="+pva1+"&"+pa2+"="+pva2;

        			              else if(!"null".equals(pa1))
        		                         param=tlabel+"="+access_token+"&"+pa1+"="+pva1;

        			        	  else if("null".equals(pa1))
        		                         param=tlabel+"="+access_token;
        			     		 String pointurl=endurl1+"?"+param;
        			     	    //String paramString = URLEncodedUtils.format(param, "utf-8");
        					     	HttpGet get=new HttpGet(pointurl);
        				            HttpResponse response1=client.execute(get);
        				            BufferedReader rd = new BufferedReader
        						    		  (new InputStreamReader(response1.getEntity().getContent()));
        						    		    
        						    		while ((line = rd.readLine()) != null) {
        	                                GetResponse=line;
        						    		} // while
        						    			
        						    		} // querystring
        			     	}   // Get

        			    	else if(rm1.equals("POST")){
        			     		HttpPost post=new HttpPost(endurl1);
        			     		
        			     		if("Authorization:Bearer".equals(treplace)){
        							post.addHeader("Authorization", "Bearer "+access_token);
        							HttpResponse response1=client.execute(post);
        							BufferedReader rd = new BufferedReader(
        				     				new InputStreamReader(response1.getEntity().getContent()));
        				     			while ((line = rd.readLine()) != null) {
        				     				GetResponse=line;
        			     			} // while
        			     	
        						    }   // Auth Bearer POST
        			     		
        			     		else if("QueryString".equals(treplace)){
        					    	 List <NameValuePair> cod = new ArrayList <NameValuePair>();
        				     		 if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5) && !"null".equals(pa6)){
        						    	 cod.add(new BasicNameValuePair(tlabel,access_token));
        					    	     cod.add(new BasicNameValuePair(pa1,pva1));
        					    	     cod.add(new BasicNameValuePair(pa2,pva2));
        					    	     cod.add(new BasicNameValuePair(pa3,pva3));
        					    	     cod.add(new BasicNameValuePair(pa4,pva4));
        					    	     cod.add(new BasicNameValuePair(pa5,pva5));
        					    	     cod.add(new BasicNameValuePair(pa6,pva6));}


        				     			 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5)){
        				     				  cod.add(new BasicNameValuePair(tlabel,access_token));
        						    	     cod.add(new BasicNameValuePair(pa1,pva1));
        						    	     cod.add(new BasicNameValuePair(pa2,pva2));
        						    	     cod.add(new BasicNameValuePair(pa3,pva3));
        						    	     cod.add(new BasicNameValuePair(pa4,pva4));
        						    	     cod.add(new BasicNameValuePair(pa5,pva5));	}    
        					     		
        				     			 
        				     			 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4)){cod.add(new BasicNameValuePair(tlabel,access_token));
        					    	     cod.add(new BasicNameValuePair(pa1,pva1));
        					    	     cod.add(new BasicNameValuePair(pa2,pva2));
        					    	     cod.add(new BasicNameValuePair(pa3,pva3));
        					    	     cod.add(new BasicNameValuePair(pa4,pva4));
        					    	     }
        						     		
        					     		 
        					     		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3)){cod.add(new BasicNameValuePair(tlabel,access_token));
        						    	     cod.add(new BasicNameValuePair(pa1,pva1));
        						    	     cod.add(new BasicNameValuePair(pa2,pva2));
        						    	     cod.add(new BasicNameValuePair(pa3,pva3));
        						    	     }
        							     		
        						     		 
        						     		 else if(!"null".equals(pa1) && !"null".equals(pa2)){cod.add(new BasicNameValuePair(tlabel,access_token));
        							    	     cod.add(new BasicNameValuePair(pa1,pva1));
        							    	     cod.add(new BasicNameValuePair(pa2,pva2));
        							    	     }
        								     		
        							     		 
        							     		 else if(!"null".equals(pa1)){
        								     			cod.add(new BasicNameValuePair(tlabel,access_token));
        									    	    cod.add(new BasicNameValuePair(pa1,pva1));
        									    	     
        								     		 }
        							     		 else if("null".equals(pa1)){
        								     			cod.add(new BasicNameValuePair(tlabel,access_token));

        							     		 }
        						        post.setEntity(new UrlEncodedFormEntity(cod));
        						        HttpResponse response1 = client.execute(post);
        						        BufferedReader rd = new BufferedReader(new InputStreamReader(response1.getEntity().getContent()));
        						        while ((line = rd.readLine()) != null) {
        						        	GetResponse=line;} // while
        	 		     		}  // query string
        			     		   
        			     	}  // POST
        	                 if(authen1.equals("Oauth2") && resf1.equals("JSON")){
        	                  JSON json = JSONSerializer.toJSON( GetResponse );  
        	   	              XMLSerializer xmlSerializer = new XMLSerializer();  
        	   	              xmlSerializer.setTypeHintsEnabled(false);
        	   	              xmlSerializer.setSkipWhitespace(true);
        	   	              xmlSerializer.setTrimSpaces(true);
        	   	              xmlSerializer.setRemoveNamespacePrefixFromElements(true);
        	   	              xmlSerializer.removeNamespace(GetResponse);
        	   	              xmlSerializer.setForceTopLevelObject(false);
        	   	              String xmlout=xmlSerializer.write(json);

        	   	           session.setAttribute("xml1", xmlout);
        			        response.setHeader("Refresh", "1; URL=prebuild_xml.jsp");	
        	                 } // if
        	                 
        	                 else  if(authen1.equals("Oauth2") && resf1.equals("XML")){

        	                	 session.setAttribute("xml1", GetResponse);
        	         			 out.println("<h2><center><font color='green'>Processing...</font></center></h3>");

        		     		        response.setHeader("Refresh", "1; URL=prebuild_xml.jsp");	
        	                 } // if
        	            
        		         }//oauth	                     
        	        
                 }//while
	      } //try
	      catch(Exception e){
	    	  out.println(e);
	      }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	}

}
