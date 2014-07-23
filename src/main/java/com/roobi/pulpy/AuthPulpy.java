package com.roobi.pulpy;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.FlickrApi;
import org.scribe.builder.api.TumblrApi;
import org.scribe.builder.api.TwitterApi;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

import net.sf.json.JSON;
import net.sf.json.JSONSerializer;
import net.sf.json.xml.XMLSerializer;

import com.mindots.util.Utils;
import com.mysql.jdbc.Connection;
public class AuthPulpy extends HttpServlet {
	private static final long serialVersionUID = 1L;
  Connection con=null;
    public AuthPulpy() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   	 response.setHeader("Content-Type","text/html;charset=UTF-8");

		PrintWriter out=response.getWriter();
		 Map<String, String> config = Utils.getConfigFromFile(getServletContext(), "config.properties");

      String rf=request.getParameter("rf");String select2=request.getParameter("rm");
      String select=request.getParameter("select2");
      String select3=request.getParameter("select3");String burl=request.getParameter("method");String endurl=request.getParameter("endurl");
      String pv1=null;String pv2=null;String pv3=null;String pv4=null;
      String pv5=null;String pv6=null;String pv7=null;String pv8=null;
      String p1=request.getParameter("p1"); pv1=request.getParameter("pv1");
      String p2=request.getParameter("p2"); pv2=request.getParameter("pv2");
      String p3=request.getParameter("p3"); pv3=request.getParameter("pv3");
      String p4=request.getParameter("p4"); pv4=request.getParameter("pv4");
      String p5=request.getParameter("p5"); pv5=request.getParameter("pv5");
      String p6=request.getParameter("p6"); pv6=request.getParameter("pv6");
      String p7=request.getParameter("p7"); pv7=request.getParameter("pv7");
      String p8=request.getParameter("p8");  pv8=request.getParameter("pv8");
      String p9=request.getParameter("p9"); String pv9=request.getParameter("pv9");
      String p10=request.getParameter("p10");String pv10=request.getParameter("pv10");
              String field1=request.getParameter("field1");      String field2=request.getParameter("field2");
      String field3=request.getParameter("field3");      String field4=request.getParameter("field4");
      String field5=request.getParameter("field5");      String field6=request.getParameter("field6");
      String field7=request.getParameter("field7");      String field8=request.getParameter("field8");
      String field9=request.getParameter("field9");      String field10=request.getParameter("field10");
      HttpSession session=request.getSession(true);
      HttpSession session3=request.getSession(true);
	  String id=(String) session.getAttribute("id");
	  String appid=(String) session.getAttribute("appid"); 
	  session3.setAttribute("reqmeth",select);
      session3.setAttribute("resfor",select3);
      session3.setAttribute("endurl",endurl);
      session3.setAttribute("p1",p1);session3.setAttribute("pv1",pv1);
      session3.setAttribute("p2",p2);session3.setAttribute("pv2",pv2);
      session3.setAttribute("p3",p3);session3.setAttribute("pv3",pv3);
      session3.setAttribute("p4",p4);session3.setAttribute("pv4",pv4);
      session3.setAttribute("p5",p5);session3.setAttribute("pv5",pv5);
      session3.setAttribute("p6",p6);session3.setAttribute("pv6",pv6);
      session3.setAttribute("p7",p7);session3.setAttribute("pv7",pv7);
      session3.setAttribute("p8",p8);session3.setAttribute("pv8",pv8);
      session3.setAttribute("p9",p9);session3.setAttribute("pv9",pv9);
      session3.setAttribute("p10",p10);session3.setAttribute("pv10",pv10);
     // PrintWriter out=response.getWriter();
      Token requestToken=(Token) session.getAttribute("tok");
      String oauth_verifier=(String) session.getAttribute("oauth_verifier");
      String call="https://mindapp-pulpy.rhcloud.com/Oauth1Call";
     // String call="http://localhost:8071/mindapp/Oauth1Call";



      try{
  		//out.println("start");
    	    response.setContentType("text/html");
			Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = (Connection) DriverManager.getConnection(config.get("URL"),config.get("USER"),config.get("PASS"));
            String sam=null;
             PreparedStatement st=null;
			 st=con.prepareStatement("insert into config(id,appid,resf,rm,baseurl,endurl,p1,pv1,p2,pv2,p3,pv3,p4,pv4,p5,pv5,p6,pv6,p7,pv7,p8,pv8,p9,pv9,p10,pv10,f1,f2,f3,f4,f5,f6,f7,f8,f9,f10) values ('"+id+"','"+appid+"','"+select3+"','"+select+"','"+burl+"','"+endurl+"','"+p1+"','"+pv1+"','"+p2+"','"+pv2+"','"+p3+"','"+pv3+"','"+p4+"','"+pv4+"','"+p5+"','"+pv5+"','"+p6+"','"+pv6+"','"+p7+"','"+pv7+"','"+p8+"','"+pv8+"','"+p9+"','"+pv9+"','"+p10+"','"+pv10+"','"+field1+"','"+field2+"','"+field3+"','"+field4+"','"+field5+"','"+field6+"','"+field7+"','"+field8+"','"+field9+"','"+field10+"')");
			 st.executeUpdate();
		     st.close();
		  		//out.println("start2");
		     st=con.prepareStatement("SELECT * FROM authen1 t1 JOIN config t2 ON t1.appid = t2.appid WHERE t1.appid=?");
		                 st.setString(1, appid);

	         ResultSet rs = st.executeQuery();
	         while(rs.next()){
   	         String id1=rs.getString("id");	 String appname1=rs.getString("appname");
             String authen1=rs.getString("auth");String ba1=rs.getString("b1");String b2=rs.getString("b2");
             String ba3=rs.getString("b3");String b4=rs.getString("b4");String ak1=rs.getString("a1");
             String ak2=rs.getString("a2"); String cname=rs.getString("cname");
        	 String ckey=rs.getString("ckey"); String rmethod=rs.getString("rmethod");
        	 String csecname=rs.getString("csecname");
        	 String cseckey=rs.getString("cseckey");
        	 String sname=rs.getString("sname");
        	 String svalue=rs.getString("svalue");
        	 String aurl=rs.getString("aurl");
        	 String tokenurl=rs.getString("tokenurl");
        	 String tlabel=rs.getString("tlabel");
        	 String treplace=rs.getString("treplace");
        	 String el=rs.getString("el");
        	 String ev=rs.getString("ev");
             String rf1=rs.getString("rf");String rm1=rs.getString("rm");
             String resf1=rs.getString("resf");String mname=rs.getString("baseurl");String endurl1=rs.getString("endurl");
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
             String oapp1=rs.getString("oapp"); String omethod1=rs.getString("omethod");
        	 String ockey1=rs.getString("ockey"); String oskey1=rs.getString("oskey");
        	 String RESOURCE_URL =endurl1; String apiKey= ockey1; String apiSecret = oskey1;
             String eurl=null;
	              
	         if(authen1.equals("No Auth")){
	        	 Object obj;
	        	 String str="";
	        	 	         
                  if(rf1.equals("REST") && rm1.equals ("GET") && resf1.equals("XML") || resf1.equals("JSON")){  //No Auth XML get
	        		 
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
	        		 
	   
	        			// out.println(eurl);
	        			 URL eurl1=new URL(eurl);
		        		 URLConnection uconn = eurl1.openConnection();
		        	     HttpURLConnection conn = (HttpURLConnection) uconn;
		        	     conn.connect();
		        	     Object content = conn.getContent();
		        	     InputStream stream = (InputStream) content;
		        	     String line=null;String strcon=null;
		        	     StringBuilder strb=new StringBuilder();
		        	     BufferedReader br=new BufferedReader(new InputStreamReader(stream));
	        	   if(resf1.equals("XML")){
	        	     while((line=br.readLine())!=null){
    	  	       	 str+=line;
    	  	       	 }
	        	   }
	        	    else if(resf1.equals("JSON")){
	        	    	 while ((line = br.readLine()) != null)    { 
	        	    	   strb.append(line);
	   	    			
	   	    		     }//while
	        	    	 strcon=strb.toString();
	        	    	 JSON json = JSONSerializer.toJSON(strb) ;
	   	     	          XMLSerializer xmlSerializer = new XMLSerializer();  
	   	     	          xmlSerializer.setTypeHintsEnabled(false);
	   	     	          xmlSerializer.setSkipWhitespace(true);
	   	     	          xmlSerializer.setTrimSpaces(true);
	   	     	          xmlSerializer.setRemoveNamespacePrefixFromElements(true);
	   	     	          xmlSerializer.removeNamespace(line);
	   	     	          xmlSerializer.setRootName("root");
	   	     	          xmlSerializer.setForceTopLevelObject(false);
	   	     		      str = xmlSerializer.write( json );
	        	     } // else if*/
	        	    session.setAttribute("xml1", str);
		          out.println("<h2><center><font color='green'>Processing...</font></center></h3>");
	     		        response.setHeader("Refresh", "1; URL=auth1.jsp");	
	        	     
	        	 } //XML and JSON get No Auth
	        	               
              else if(rf1.equals("REST") && rm1.equals ("GET") && resf1.equals("XML-RPC")) // No Auth XML-RPC
	        	     
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
	        		
	 	  
     			  session.setAttribute("xml1", resf1);
     			  session.setAttribute("token", token);
     			 out.println("<h2><center><font color='green'>Processing...</font></center></h3>");
	     		      response.setHeader("Refresh", "1; URL=auth1.jsp");	
  		   
	     			
   		        
      	 } //XML RPC        

               
               else  if(rf1.equals("REST") && rm1.equals ("POST")){  // No Auth XML post
	        		 
          		 String USER_AGENT = "Mozilla/5.0";
	        	 String url=endurl1;	 	        		         		
	        		//out.println(eurl);
	        		 try
	        		 {
	        			 HttpClient client = new DefaultHttpClient();
	        				HttpPost post = new HttpPost(url);
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
	        		 session.setAttribute("xml1", str);
	        		 out.println("<h2><center><font color='green'>Processing...</font></center></h3>");
	     		        response.setHeader("Refresh", "1; URL=auth1.jsp");	
	               	} //  post
	        	        	 
	         }    // No Auth  
	               
	         
	         if(authen1.equals("API keys")){  //API Keys
        	     String str="";
                 Object obj;
	        	 if(rf1.equals("REST") && rm1.equals ("GET") && resf1.equals("XML") || resf1.equals("JSON")){  //API XML get
	        		 
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
	        	     String line=null;String strcon=null;
	        	     BufferedReader br=new BufferedReader(new InputStreamReader(stream));
	        	     StringBuilder strb=new StringBuilder();
	        	    if(resf1.equals("XML")){
	        	     while((line=br.readLine())!=null){
    	  	       	 str+=line;
    	  	       	 }
	        	     }
	        	     else if(resf1.equals("JSON")){
	        	    	 while ((line = br.readLine()) != null)    { 
	        	    	      strb.append(line);
	   	    		     }//while
	        	    	 strcon=strb.toString();
	        	    	 XMLSerializer serializer = new XMLSerializer();
	     	            JSON json = JSONSerializer.toJSON(strcon);
	     	            serializer.setRootName("root");
	     	            serializer.setTypeHintsEnabled(false);
	     	            str = serializer.write(json);
	        	    	 
	        	     } // else if
	        	    session.setAttribute("xml1", str);
		            out.println("<h2><center><font color='green'>Processing...</font></center></h3>");
	     		        response.setHeader("Refresh", "1; URL=auth1.jsp");	
	        	     
	        	 } //XML and JSON get
	        	     
	        	     else if(rf1.equals("REST") && rm1.equals ("GET") && resf1.equals("XML-RPC"))
	        	     
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
		     			
		        		     	 	  
	        			  session.setAttribute("xml1", resf1);
	        			  session.setAttribute("token", token);
	          			 out.println("<h2><center><font color='green'>Processing...</font></center></h3>");

		     		      response.setHeader("Refresh", "1; URL=auth1.jsp");	
	     		        
	        	 } //XML RPC        */	 
	        	 if(rf1.equals("REST") && rm1.equals ("POST")){  // apikey XML post
	        		 
	          		 String USER_AGENT = "Mozilla/5.0";
		        	 String url=endurl1;
		        		 try
		        		 {
		        			 HttpClient client = new DefaultHttpClient();
		        				HttpPost post = new HttpPost(url);
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
		        		 session.setAttribute("xml1", str);
		     			 out.println("<h2><center><font color='green'>Processing...</font></center></h3>");

		     		        response.setHeader("Refresh", "1; URL=auth1.jsp");	
		               	}//post 
	        	 
	         }  // API keys  
	         
            //Basic Auth
	         
	         else if(authen1.equals("Basic Auth")){ //m15
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
	                 BufferedReader in   = new BufferedReader (new InputStreamReader (content));
	              if(resf1.equals("XML")){
	                    while((line=in.readLine())!=null){
	                    	str+=line;
	                    }} // while and xml
	              else if(resf1.equals("JSON")){
	            	  while((line=in.readLine())!=null){
	            		  JSON json = JSONSerializer.toJSON( line .replaceAll("\\s+","")  );  
		     	          XMLSerializer xmlSerializer = new XMLSerializer();  
		     	          xmlSerializer.setTypeHintsEnabled(false);
		     	          xmlSerializer.setSkipWhitespace(true);
		     	          xmlSerializer.setTrimSpaces(true);
		     	          xmlSerializer.setRemoveNamespacePrefixFromElements(true);
		     	          xmlSerializer.removeNamespace(line);
		     	          xmlSerializer.setForceTopLevelObject(false);
		     		      str = xmlSerializer.write( json );
	            	  }//while}
	              }//json
	              session.setAttribute("xml1", str);
	             out.println("<h2><center><font color='green'>Processing...</font></center></h3>");
     		        response.setHeader("Refresh", "1; URL=auth1.jsp");	
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
	            	  }//while
	            	  session.setAttribute("xml1", str);
		             out.println("<h2><center><font color='green'>Processing...</font></center></h3>");
	     		        response.setHeader("Refresh", "1; URL=auth1.jsp");	
	              }//post
	           
	                            
	                	
	              } //  else-if json
	             }//try
	              
	   	             catch(Exception e){
	   	            	// out.println(e);
	   	            	 }
	   	          
	        	 
	        	 
	         }// Basic Auth
	         //m15  //m16 //m17
	         //---------------------oauth1-----------------------
	         else if(authen1.equals("Oauth1")){
	        	 String res="";
	        	 if(rm1.equals ("GET")){
	        		 if (oapp1.equals("FlickrApi")){
	        		 OAuthService service = new ServiceBuilder().provider(FlickrApi.class).apiKey(apiKey).apiSecret(apiSecret).callback(call).build(); 
	     		    Verifier verifier = new Verifier(oauth_verifier);
	     		    Token accessToken = service.getAccessToken(requestToken, verifier);
	     		    OAuthRequest request1 = new OAuthRequest(Verb.GET,RESOURCE_URL);
	     		    request1.addQuerystringParameter("method", omethod1);
	     		    service.signRequest(accessToken, request1);
	     		    Response response1 = request1.send();
	     		    res=response1.getBody();}
	        		 else if (oapp1.equals("TumblrApi")){
		        		 OAuthService service = new ServiceBuilder().provider(TumblrApi.class).apiKey(apiKey).apiSecret(apiSecret).callback(call).build(); 
			     		    Verifier verifier = new Verifier(oauth_verifier);
			     		    Token accessToken = service.getAccessToken(requestToken, verifier);
			     		    OAuthRequest request1 = new OAuthRequest(Verb.GET,RESOURCE_URL);
			     		    service.signRequest(accessToken, request1);
			     		    Response response1 = request1.send();
			     		    res=response1.getBody();}
	        		 else if (oapp1.equals("TwitterApi")){
		        		 OAuthService service = new ServiceBuilder().provider(TwitterApi.SSL.class).apiKey(apiKey).apiSecret(apiSecret).callback(call).build(); 
			     		    Verifier verifier = new Verifier(oauth_verifier);
			     		    Token accessToken = service.getAccessToken(requestToken, verifier);
			     		    OAuthRequest request1 = new OAuthRequest(Verb.GET,RESOURCE_URL);
			     		    service.signRequest(accessToken, request1);
			     		    Response response1 = request1.send();
			     		    res=response1.getBody();}
	        	if( resf1.equals("XML")){
	        		session.setAttribute("xml1", res);
	  	          out.println("<h2><center><font color='green'>Processing...</font></center></h3>");
	     		        response.setHeader("Refresh", "1; URL=auth1.jsp");
	        	}
	        	else if( resf1.equals("JSON")){
	        		XMLSerializer serializer = new XMLSerializer();
     	            JSON json = JSONSerializer.toJSON(res);
     	            serializer.setRootName("root");
     	            serializer.setTypeHintsEnabled(false);
     	            String str = serializer.write(json);
	        		session.setAttribute("xml1", str);
	  	          out.println("<h2><center><font color='green'>Processing...</font></center></h3>");
	     		        response.setHeader("Refresh", "1; URL=auth1.jsp");
	        	}
	        	 }
	        	 else if(rm1.equals ("POST")){
	        		 
	 	        	if( resf1.equals("XML")){
	 	        		
	 	        	}
	 	        	else if( resf1.equals("JSON")){
	 	        		
	 	        	}
	 	        	 }
	        	 
	        	 
	         }

	         //=================oauth1 end====================
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
		     		HttpGet get=new HttpGet(endurl);
			       get.addHeader("Authorization", "Bearer "+access_token);
		     		HttpResponse response1 = client.execute(get);
		     		BufferedReader rd = new BufferedReader(
		     				new InputStreamReader(response1.getEntity().getContent()));
		     			while ((line = rd.readLine()) != null) {
		     				GetResponse=line;
		     				out.println(GetResponse);
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
		     		HttpPost post=new HttpPost(endurl);
		     		
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
   				out.println(xmlout);

   	           session.setAttribute("xml1", xmlout);
		        response.setHeader("Refresh", "1; URL=auth1.jsp");	
                 } // if
                 
                 else  if(authen1.equals("Oauth2") && resf1.equals("XML")){
	     				out.println(GetResponse);

                	 session.setAttribute("xml1", GetResponse);
         			 out.println("<h2><center><font color='green'>Processing...</font></center></h3>");

	     		        response.setHeader("Refresh", "1; URL=auth1.jsp");	
                 } // if
            
	         }//oauth	
	         
	         }//try
	         } // while database
	         
	         catch(Exception e){
	        	out.println(e);
	        	 // out.println("<h2><center><font color='green'> Please Enter correct values</font></center></h3>");
	        	 }
      
	} //post
	
} //class
	
