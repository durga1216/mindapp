package com.roobi.pulpy;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;














import org.apache.http.Consts;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.*;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthConstants;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;
import org.scribe.model.OAuthConstants;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class OauthCallBackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public OauthCallBackServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();

		try{
			//	response.setContentType("application/json");
			HttpSession session1=request.getSession(true);
			String url=(String) session1.getAttribute("url");
			String id=(String) session1.getAttribute("id");
			String appname=(String) session1.getAttribute("appname");
			String apilabel=(String) session1.getAttribute("cname");
	 		String apikey=(String) session1.getAttribute("ckey");
	 		String apiseclabel=(String) session1.getAttribute("csecname");
	 		String apisecvalue=(String) session1.getAttribute("cseckey");
	 		String scope_label=(String) session1.getAttribute("sname");
	 		String scope_value=(String) session1.getAttribute("svalue");
	 		String aurl=(String) session1.getAttribute("aurl");
	 		String tokenurl=(String) session1.getAttribute("tokenurl");
	 		String tlabel=(String) session1.getAttribute("tlabel");
	 		String treplace=(String) session1.getAttribute("treplace");
	 		String el=(String) session1.getAttribute("el");
	 		String ev=(String) session1.getAttribute("ev");
	 		String rf1=(String)session1.getAttribute("rf1");
	 		String rm1=(String)session1.getAttribute("rm1");
			String code = request.getParameter(OAuthConstants.CODE);
			//pw.println(apikey+"<br>"+apisecvalue+"<br>"+tokenurl);
			String responseBody=null;
			String responseMsg=null;
			String access_token=null;
			try{
				

			if(rm1.equals("POST")){
				DefaultHttpClient httpclient=new DefaultHttpClient();

				HttpPost post = new HttpPost(tokenurl);
				post.addHeader("Accept", "application/json");
				List <NameValuePair> cod = new ArrayList <NameValuePair>();
		        cod.add(new BasicNameValuePair("code", code)); 
		        cod.add(new BasicNameValuePair("grant_type", "authorization_code")); 
		        cod.add(new BasicNameValuePair("client_id",apikey));
		        cod.add(new BasicNameValuePair("client_secret",apisecvalue)); 
		        cod.add(new BasicNameValuePair("redirect_uri","https://mindapp-pulpy.rhcloud.com/OauthCallBackServlet")); 
		       // post.setEntity(new UrlEncodedFormEntity(cod));
		        HttpResponse response1 = httpclient.execute(post);
		        ResponseHandler<String> handler = new BasicResponseHandler();

		        String body = handler.handleResponse(response1);
		        int code1 = response1.getStatusLine().getStatusCode();
pw.println(body);
pw.println(code);
		      /*  StringBuffer buffer = new StringBuffer();
		        BufferedReader reader = new BufferedReader(new InputStreamReader(post.getEntity().getContent()));
		  String dataLine = null;
		  while((dataLine = reader.readLine()) != null){
		              buffer.append(dataLine);
		  }
		 responseMsg =    buffer.toString();
         pw.println(responseMsg);
				/*post.addParameter("code", code);
				post.addParameter("grant_type", "authorization_code");
				post.addParameter("client_id",apikey);
				post.addParameter("client_secret",apisecvalue);
				post.addParameter("redirect_uri","https://mindapp-pulpy.rhcloud.com/OauthCallBackServlet");
				httpclient.executeMethod(post);
			    responseBody = post.getResponseBodyAsString();//}
			    pw.println(responseBody);*/
			
			    
			}
			  
			    
				 /*else if(rm1.equals("GET")){
				     	GetMethod get=new GetMethod(URIUtil.encodeQuery(tokenurl+"?code="+code+"&grant_type=authorization_code&client_id="+apikey+"&client_secret="+apisecvalue+"&redirect_uri=https://mindapp-pulpy.rhcloud.com/OauthCallBackServlet"));


				     	
					 get.setQueryString(new NameValuePair[] { 
			     			    new NameValuePair("code",code)});
					 get.setQueryString(new NameValuePair[] { 
			     			    new NameValuePair("grant_type","authorization_code")});
					 get.setQueryString(new NameValuePair[] { 
			     			    new NameValuePair("client_id",apikey)});
					 get.setQueryString(new NameValuePair[] { 
			     			    new NameValuePair("client_secret",apisecvalue)});
					 get.setQueryString(new NameValuePair[] { 
			     			    new NameValuePair("redirect_uri","http://localhost:8080/MindPulpy1/OauthCallBackServlet")});
			     		
				          httpclient.executeMethod(get);
				          responseBody=get.getResponseBodyAsString();
						  pw.println(responseBody);*/
	}
			catch(Exception e){pw.println(e);}
			
			             String line=null;
			             BufferedReader br=new BufferedReader(new StringReader(responseMsg));
			             while ((line = br.readLine()) != null) {
			            	 if(line.startsWith("{") || line.startsWith("[{")){
			            		 JSONObject json = null;
			     				 json = new JSONObject(responseBody);
			     		         access_token = json.getString("access_token"); 
			            	 }
			            	 else if(line.startsWith("<?") || line.endsWith("?>")){
			            		    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
					   		    	DocumentBuilder builder = factory.newDocumentBuilder();
					   		    	org.w3c.dom.Document document = builder.parse(new InputSource(new StringReader(responseBody)));  
					   		    	NodeList nl = document.getElementsByTagName("access_token"); 
					                Node n = nl.item(0);
					   		    	access_token = n.getFirstChild().getNodeValue();
			            	 }
			            	 else{
			            	 String[] pairs = line.split("&");
			                 for (String pair : pairs) {
			                     String[] kv = pair.split("=");
			                     if (kv.length != 2) {
			                         throw new RuntimeException("Unexpected auth response");
			                     } 
			                     else {
			                         if (kv[0].equals("access_token")) {
			                             access_token = kv[1];
			                         }}
			                         
			                 } }
			                 }
				
				
					   session1.setAttribute("access_token", access_token);
					   session1.setAttribute("id", id);
					   if(access_token.equals(""))
				            {pw.println("<br><br><center><b><h2><font color='green'>Authentication Error with "+appname+"</font></center></h2></b>");}
					   else{
					    response.setContentType("text/html;charset=utf-8");
			        	response.setCharacterEncoding("UTF-8");
			            pw.println("<br><br><center><b><h2><font color='green'>Sucessfully Authenticated with "+appname+"</font></center></h2></b>");
			            pw.println("<br><br><h3><center><a href='auth.jsp'>Continue with Config</a></center></h3>");
			            pw.println("<br><br><h3><center><a href='token.jsp'>Continue with App</a></center></h3>");}
			}
			catch(Exception e){
				pw.println(e);
			}

		
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
