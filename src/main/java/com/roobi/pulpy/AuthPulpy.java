package com.roobi.pulpy;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.HttpsURLConnection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.FlickrApi;
import org.scribe.builder.api.FreelancerApi;
import org.scribe.builder.api.LinkedInApi;
import org.scribe.builder.api.TumblrApi;
import org.scribe.builder.api.TwitterApi;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.SignatureType;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

import net.sf.json.JSON;
import net.sf.json.JSONException;
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
		 HttpSession session1=request.getSession(true);
	     	String access_token=(String)session1.getAttribute("access_token");
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
     // pv1=pv1.replaceAll(" ","%20");
      String j1=request.getParameter("j1"); String jv1=request.getParameter("jv1");
      String j2=request.getParameter("j2"); String jv2=request.getParameter("jv2");
      String j3=request.getParameter("j3"); String jv3=request.getParameter("jv3");
      String j4=request.getParameter("j4"); String jv4=request.getParameter("jv4");
      String j5=request.getParameter("j5"); String jv5=request.getParameter("jv5");
      String j6=request.getParameter("j6"); String jv6=request.getParameter("jv6");
      String j7=request.getParameter("j7"); String jv7=request.getParameter("jv7");
      String j8=request.getParameter("j8"); String jv8=request.getParameter("jv8");
      String j9=request.getParameter("j9"); String jv9=request.getParameter("jv9");
      String j11=request.getParameter("j11"); String jv11=request.getParameter("jv11");
      String j12=request.getParameter("j12"); String jv12=request.getParameter("jv12");
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
      String call="https://mindapp-pulpy.rhcloud.com/Oauth1Call";
     // String call="http://localhost:8071/mindapp/Oauth1Call";
      String strcon=null;


      try
      {
  		//out.println("start");
    	    response.setContentType("text/html");
			Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = (Connection) DriverManager.getConnection(config.get("URL"),config.get("USER"),config.get("PASS"));
            String sam=null;
             PreparedStatement st=null;
			 st=con.prepareStatement("insert into config(id,appid,resf,rm,baseurl,endurl,p1,pv1,p2,pv2,p3,pv3,p4,pv4,p5,pv5,p6,pv6,p7,pv7,p8,pv8,p9,pv9,p10,pv10,f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,extoken) values ('"+id+"','"+appid+"','"+select3+"','"+select+"','"+burl+"','"+endurl+"','"+p1+"','"+pv1+"','"+p2+"','"+pv2+"','"+p3+"','"+pv3+"','"+p4+"','"+pv4+"','"+p5+"','"+pv5+"','"+p6+"','"+pv6+"','"+p7+"','"+pv7+"','"+p8+"','"+pv8+"','"+p9+"','"+pv9+"','"+p10+"','"+pv10+"','"+field1+"','"+field2+"','"+field3+"','"+field4+"','"+field5+"','"+field6+"','"+field7+"','"+field8+"','"+field9+"','"+field10+"','"+access_token+"')");
			 st.executeUpdate();
		     st.close();
		  		//out.println("start2");
		     st=con.prepareStatement("SELECT * FROM authen1 t1 JOIN config t2 ON t1.appid = t2.appid WHERE t1.appid=?");
		                 st.setString(1, appid);

	         ResultSet rs = st.executeQuery();
	         while(rs.next()){
             String authen1=rs.getString("auth");String ba1=rs.getString("b1");String b2=rs.getString("b2");
             String ba3=rs.getString("b3");String b4=rs.getString("b4");String ak1=rs.getString("a1");
             String ak2=rs.getString("a2"); 
        	 String tlabel=rs.getString("tlabel");
        	 String treplace=rs.getString("treplace");
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
             String sigckey=rs.getString("sigckey");
             String sigskey=rs.getString("sigskey");
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
	        		 
	        		 eurl=eurl.replaceAll(" ", "%20"); 
	        			// out.println(eurl);
	        			 URL eurl1=new URL(eurl);
		        		 URLConnection uconn = eurl1.openConnection();
		        	     HttpURLConnection conn = (HttpURLConnection) uconn;
		        	     conn.connect();
		        	     Object content = conn.getContent();
		        	     InputStream stream = (InputStream) content;
		        	     String line=null; strcon=null;
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
	        	    	 XMLSerializer serializer = new XMLSerializer();
	     	            JSON json = JSONSerializer.toJSON(strcon);
	     	            serializer.setRootName("root");
	     	            serializer.setTypeHintsEnabled(false);
	     	            str = serializer.write(json);
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
	        		 out.println("<html style='background-color:#ff9900;'><h2><center><font color='#000000;'>Processing...</font></center></h3><br><br><br><br>"
	 	             		+ "<br><br><br><br><center><img style='height:100px;width:100px;' src='images/load.gif'></center><html>");
	     		        response.setHeader("Refresh", "1; URL=auth1.jsp");	
	               	} //  post
	        	        	 
	         }    // No Auth  
	               
	         
	         else if(authen1.equals("API keys")){  //API Keys
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
	        		
	        			eurl=eurl.replaceAll(" ", "%20"); 
	        		 URL eurl1=new URL(eurl);
	        		 URLConnection uconn = eurl1.openConnection();
	        	     HttpURLConnection conn = (HttpURLConnection) uconn;
	        	     conn.connect();
	        	     Object content = conn.getContent();
	        	     InputStream stream = (InputStream) content;
	        	     String line=null; strcon=null;
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
	        	    out.println("<html style='background-color:#ff9900;'><h2><center><font color='#000000;'>Processing...</font></center></h3><br><br><br><br>"
		             		+ "<br><br><br><br><center><img style='height:100px;width:100px;' src='images/load.gif'></center><html>");
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
	        			  out.println("<html style='background-color:#ff9900;'><h2><center><font color='#000000;'>Processing...</font></center></h3><br><br><br><br>"
	      	             		+ "<br><br><br><br><center><img style='height:100px;width:100px;' src='images/load.gif'></center><html>");
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
		        		 out.println("<html style='background-color:#ff9900;'><h2><center><font color='#000000;'>Processing...</font></center></h3><br><br><br><br>"
		 	             		+ "<br><br><br><br><center><img style='height:100px;width:100px;' src='images/load.gif'></center><html>");

		     		        response.setHeader("Refresh", "1; URL=auth1.jsp");	
		               	}//post 
	        	 
	         }  // API keys  
	         
            //Basic Auth
	         else if(authen1.equals("Signed Auth")){  //API Keys
        	     String str="";
                 Object obj;
	        	 if(rf1.equals("REST") && rm1.equals ("GET") && resf1.equals("XML") || resf1.equals("JSON")){  //API XML get
	        		 
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
	        		 
	        			eurl=eurl.replaceAll(" ", "%20"); 
	        			 SignedRequestsHelper helper;
	        		        try {
	        		            helper = SignedRequestsHelper.getInstance(endurl1, sigckey, sigskey);
	        		        } catch (Exception e) {
	        		            e.printStackTrace();
	        		            return;
	        		        }
	        		 String sigurl= helper.sign(eurl);
	        		 URL eurl1=new URL(sigurl);
	        		 URLConnection uconn = eurl1.openConnection();
	        	     HttpURLConnection conn = (HttpURLConnection) uconn;
	        	     conn.connect();
	        	     Object content = conn.getContent();
	        	     InputStream stream = (InputStream) content;
	        	     String line=null; strcon=null;
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
	        	    out.println("<html style='background-color:#ff9900;'><h2><center><font color='#000000;'>Processing...</font></center></h3><br><br><br><br>"
		             		+ "<br><br><br><br><center><img style='height:100px;width:100px;' src='images/load.gif'></center><html>");
	     		        response.setHeader("Refresh", "1; URL=auth1.jsp");	
	        	     
	        	 }}
	         
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
	        	 
	        	 eurl=eurl.replaceAll(" ", "%20"); 
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
	              out.println("<html style='background-color:#ff9900;'><h2><center><font color='#000000;'>Processing...</font></center></h3><br><br><br><br>"
		             		+ "<br><br><br><br><center><img style='height:100px;width:100px;' src='images/load.gif'></center><html>");
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
	     		        response.setHeader("Refresh", "1; URL=auth1.jsp");	
	              //post
	           
	                            
	                	
	              } //  else-if json
	              else if(rm1.equals("POST_JSON")){
	            	 // out.println("inside");
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
		         		else if(j1!=null  && j11!=null && j12!=null){
		         			StringEntity input = new StringEntity("{\""+j1+"\":{\""+j11+"\":\""+jv11+"\",\""+j12+"\":\""+jv12+"\"}}");
		         			input.setContentType("application/json");
		         			postRequest.setEntity(input);}
		         		else if(j1!=null && j11!=null){
		         			StringEntity input = new StringEntity("{\""+j1+"\":{\""+j1+"\":{\""+j11+"\":\""+jv11+"\"}}");
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
	    	     		        response.setHeader("Refresh", "1; URL=auth1.jsp");	
	            	 
	            			
		            	  
		              }
	              
	             }//try
	              
	   	             catch(Exception e){
	   	            	 out.println(e);
	   	            	 }
	   	          
	        	 
	        	 
	         }// Basic Auth
	         //m15  //m16 //m17
	         //---------------------oauth1-----------------------
	         else if(authen1.equals("Oauth1")){
	        	 String res="";
	        	 String oauth_signature_method=rs.getString("osmeth");String url1=rs.getString("ourl1");
            	 String ourl21=rs.getString("ourl2");String ourl31=rs.getString("ourl3");
            	 String oauth_consumer_key=rs.getString("ockey"); String secret=rs.getString("oskey");
            	 String oreq1=rs.getString("oreq");
            	 String oauth_token=(String ) session.getAttribute("access_token1");
            	 String[] tok11=oauth_token.split("=");
            	 String oauthtk=tok11[1];
            	 String access_secret1=(String ) session.getAttribute("access_secret1");
         	    String[] tok1=access_secret1.split("=");
         	    String sec1=tok1[1];
	        	 if(rm1.equals ("GET")){
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
	        			eurl="null";
	        		// out.println(eurl);
	        		 //=========================
	        		 
	            	 //========initial=========
	            	 String uuid_string = UUID.randomUUID().toString();
	                 uuid_string = uuid_string.replaceAll("-", "");
	                 String oauth_nonce = uuid_string; 
	                 String enurl = URLEncoder.encode(endurl1, "UTF-8");
	                 String oauth_timestamp = (new Long(System.currentTimeMillis()/1000)).toString();
	                 String parameter_string ="";
	                   if(eurl.equals("null")){
	                    parameter_string ="oauth_consumer_key=" + oauth_consumer_key + "&oauth_nonce=" + oauth_nonce + "&oauth_signature_method=" + oauth_signature_method + "&oauth_timestamp=" + oauth_timestamp +"&"+oauth_token+"&oauth_version=1.0";        
	                  }
	                  else{
		                   parameter_string = eurl+"&oauth_consumer_key=" + oauth_consumer_key + "&oauth_nonce=" + oauth_nonce + "&oauth_signature_method=" + oauth_signature_method + "&oauth_timestamp=" + oauth_timestamp +"&"+oauth_token+"&oauth_version=1.0";        
	                  }
	                   String[] tst1=parameter_string.split("&");Arrays.sort(tst1);
	          		int no=tst1.length;String tst3="";
	          		for(int i=1;i<no;i++){
	          			tst3=tst3+"&"+tst1[i];
	          		}
	          		String tst4=tst1[0]+tst3;
	                  String signature_base_string = rm1+"&"+enurl+"&" + URLEncoder.encode(tst4, "UTF-8");
	                 //  System.out.println("signature_base_string=" + signature_base_string);
	                    String oauth_signature = "";String oauth_signature1 = "";
	                    try {
		                      oauth_signature = computeSignature(signature_base_string, secret+"&"+sec1);  // note the & at the end. Normally the user access_token would go here, but we don't know it yet for request_token
		                       oauth_signature1 = URLEncoder.encode(oauth_signature, "UTF-8");
		                  } catch (GeneralSecurityException e) {
		                     // TODO Auto-generated catch block
		                     out.println(e);
		                   }
		                  String actok=endurl1+"?"+tst4+"&oauth_signature="+oauth_signature1;
		                  //out.println(actok);
	        		 HttpClient httpclient = new DefaultHttpClient();
               	   HttpGet get1=new HttpGet(actok);
               	   HttpResponse response1=httpclient.execute(get1);
                  BufferedReader rd = new BufferedReader(
                              new InputStreamReader(response1.getEntity().getContent()));
        
       		StringBuffer result = new StringBuffer();
       		String line = "";
       		while ((line = rd.readLine()) != null) {
       			result.append(line);
       		}
       		strcon=result.toString();
       		//out.println(strcon);
	        	if( resf1.equals("XML")){
	        		session.setAttribute("xml1", strcon);
	        		out.println("<html style='background-color:#ff9900;'><h2><center><font color='#000000;'>Processing...</font></center></h3><br><br><br><br>"
		             		+ "<br><br><br><br><center><img style='height:100px;width:100px;' src='images/load.gif'></center><html>");
	     		        response.setHeader("Refresh", "1; URL=auth1.jsp");
	        	}
	        	else if( resf1.equals("JSON")){
	        		XMLSerializer serializer = new XMLSerializer();
     	            JSON json = JSONSerializer.toJSON(strcon);
     	            serializer.setRootName("root");
     	            serializer.setTypeHintsEnabled(false);
     	            String str = serializer.write(json);
	        		session.setAttribute("xml1", str);
	        		out.println("<html style='background-color:#ff9900;'><h2><center><font color='#000000;'>Processing...</font></center></h3><br><br><br><br>"
		             		+ "<br><br><br><br><center><img style='height:100px;width:100px;' src='images/load.gif'></center><html>");
	     		       response.setHeader("Refresh", "1; URL=auth1.jsp");
	        	}
	        	 }
	        	 else if(rm1.equals ("POST")){
	        		 eurl=null;
	        		 String uuid_string = UUID.randomUUID().toString();
	                 uuid_string = uuid_string.replaceAll("-", "");
	                 String oauth_nonce = uuid_string; 
	                 String enurl = URLEncoder.encode(endurl1, "UTF-8");
	                 String oauth_timestamp = (new Long(System.currentTimeMillis()/1000)).toString();
	                   String parameter_string ="";
	                   if(eurl.equals("null")){
	                    parameter_string ="oauth_consumer_key=" + oauth_consumer_key + "&oauth_nonce=" + oauth_nonce + "&oauth_signature_method=" + oauth_signature_method + "&oauth_timestamp=" + oauth_timestamp +"&"+oauth_token+"&oauth_version=1.0";        
	                  }
	                  else{
		                   parameter_string = eurl+"&oauth_consumer_key=" + oauth_consumer_key + "&oauth_nonce=" + oauth_nonce + "&oauth_signature_method=" + oauth_signature_method + "&oauth_timestamp=" + oauth_timestamp +"&"+oauth_token+"&oauth_version=1.0";        
	                  }
	                   String[] tst1=parameter_string.split("&");Arrays.sort(tst1);
	          		int no=tst1.length;String tst3="";
	          		for(int i=1;i<no;i++){
	          			tst3=tst3+"&"+tst1[i];
	          		}
	          		String tst4=tst1[0]+tst3;
	                  String signature_base_string = rm1+"&"+enurl+"&" + URLEncoder.encode(tst4, "UTF-8");
	                 //  System.out.println("signature_base_string=" + signature_base_string);
	                    String oauth_signature = "";String oauth_signature1 = "";
	                    try {
		                      oauth_signature = computeSignature(signature_base_string, secret+"&"+sec1);  // note the & at the end. Normally the user access_token would go here, but we don't know it yet for request_token
		                       oauth_signature1 = URLEncoder.encode(oauth_signature, "UTF-8");
		                  } catch (GeneralSecurityException e) {
		                     // TODO Auto-generated catch block
		                     out.println(e);
		                   }
	                    String authorization_header_string = "OAuth oauth_consumer_key=\"" + oauth_consumer_key + "\","
	                     		+ "oauth_nonce=\"" + oauth_nonce + "\",oauth_signature_method=\"HMAC-SHA1\",oauth_token=\""+oauthtk+"\",oauth_signature=\"" + URLEncoder.encode(oauth_signature, "UTF-8") + "\",oauth_timestamp=\"" + 
	                            oauth_timestamp + "\",oauth_version=\"1.0\"";
		                  String actok=endurl1+"?"+tst4+"&oauth_signature="+oauth_signature1;
		                  //out.println(actok);
	        		 HttpClient httpclient = new DefaultHttpClient();
	        		 HttpResponse response1=null;
	                 HttpPost post = new HttpPost(endurl1);
                     post.setHeader("Authorization", authorization_header_string);
     				 response1 = httpclient.execute(post);
                  BufferedReader rd = new BufferedReader(
                              new InputStreamReader(response1.getEntity().getContent()));
        
       		StringBuffer result = new StringBuffer();
       		String line = "";
       		while ((line = rd.readLine()) != null) {
       			result.append(line);
       		}
       		strcon=result.toString();
       		out.println(strcon);
	 	        	if( resf1.equals("XML")){
	 	        		session.setAttribute("xml1", res);
	 	        		out.println("<html style='background-color:#ff9900;'><h2><center><font color='#000000;'>Processing...</font></center></h3><br><br><br><br>"
	 		             		+ "<br><br><br><br><center><img style='height:100px;width:100px;' src='images/load.gif'></center><html>");
	 		     		        response.setHeader("Refresh", "1; URL=auth1.jsp");
	 	        	}
	 	        	else if( resf1.equals("JSON")){
	 	        		XMLSerializer serializer = new XMLSerializer();
	     	            JSON json = JSONSerializer.toJSON(res);
	     	            serializer.setRootName("root");
	     	            serializer.setTypeHintsEnabled(false);
	     	            String str = serializer.write(json);
		        		session.setAttribute("xml1", str);
		        		out.println("<html style='background-color:#ff9900;'><h2><center><font color='#000000;'>Processing...</font></center></h3><br><br><br><br>"
			             		+ "<br><br><br><br><center><img style='height:100px;width:100px;' src='images/load.gif'></center><html>");
		     		        response.setHeader("Refresh", "1; URL=auth1.jsp");
	 	        	}
	 	        	 }
	        	 
	        	 
	         }

	         //=================oauth1 end====================
	         else if(authen1.equals("Oauth2")){
	 			HttpClient client=new DefaultHttpClient();
                String Response=null;
	        	
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
		     				//out.println(GetResponse);
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
                	 strcon=GetResponse;
                  JSON json = JSONSerializer.toJSON( GetResponse );  
   	              XMLSerializer xmlSerializer = new XMLSerializer();  
   	              xmlSerializer.setTypeHintsEnabled(false);
   	              xmlSerializer.setSkipWhitespace(true);
   	              xmlSerializer.setTrimSpaces(true);
   	              xmlSerializer.setRemoveNamespacePrefixFromElements(true);
   	              xmlSerializer.removeNamespace(GetResponse);
   	              xmlSerializer.setForceTopLevelObject(false);
   	              String xmlout=xmlSerializer.write(json);
   				//out.println(xmlout);

   	           session.setAttribute("xml1", xmlout);
   	        out.println("<html style='background-color:#ff9900;'><h2><center><font color='#000000;'>Processing...</font></center></h3><br><br><br><br>"
	             		+ "<br><br><br><br><center><img style='height:100px;width:100px;' src='images/load.gif'></center><html>");
		        response.setHeader("Refresh", "1; URL=auth1.jsp");	
                 } // if
                 
                 else  if(authen1.equals("Oauth2") && resf1.equals("XML")){
	     				out.println(GetResponse);

                	 session.setAttribute("xml1", GetResponse);
                	 out.println("<html style='background-color:#ff9900;'><h2><center><font color='#000000;'>Processing...</font></center></h3><br><br><br><br>"
     	             		+ "<br><br><br><br><center><img style='height:100px;width:100px;' src='images/load.gif'></center><html>");

	     		        response.setHeader("Refresh", "1; URL=auth1.jsp");	
                 } // if
            
	         }//oauth	
	         
	         }//try
	         } // while database
	         catch(JSONException je1){
	        	 out.println("<a href='logsucess.jsp'>Click Here for HOME</a><br><br>Error Description: "+je1+"<br><br> SORRY invalid JSON format.. Your Raw Output:<br><br>"
	        	 		+ "<html style='background-color:#ff9900;'><font color='white'>"+strcon+"</font><br>");
	         }
	         catch(Exception e){
	        	out.println("<a href='logsucess.jsp'>Click Here for HOME</a><br><br>Error Description: "+e+"<br><br>Your Raw Output:<br><br>"
	        			+ "<html style='background-color:#ff9900;'><font color='white'>"+strcon+"</font><br><br><br><br>");
	        	 // out.println("<h2><center><font color='green'> Please Enter correct values</font></center></h3>");
	        	 }
      
	} //post
	private static String computeSignature(String baseString, String keyString) throws GeneralSecurityException, UnsupportedEncodingException {
		 
        SecretKey secretKey = null;
 
       byte[] keyBytes = keyString.getBytes();
        secretKey = new SecretKeySpec(keyBytes, "HmacSHA1");
 
        Mac mac = Mac.getInstance("HmacSHA1");
 
      mac.init(secretKey);
 
      byte[] text = baseString.getBytes();
 
      return new String(Base64.encodeBase64(mac.doFinal(text))).trim();
  }	 
} //class
	
