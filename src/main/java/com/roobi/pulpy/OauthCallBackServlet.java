package com.roobi.pulpy;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
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
		try{
		PrintWriter pw=response.getWriter();
		HttpSession session1=request.getSession(true);
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
		System.out.println("verifier:"+code);
		String responseBody=null;
		String access_token=null;
		HttpClient httpclient = new HttpClient();
			 if(rm1.equals("POST")){
			PostMethod post = new PostMethod(tokenurl);
			post.addParameter("code", code);
			post.addParameter("grant_type", "authorization_code");
			post.addParameter("client_id",apikey);
			post.addParameter("client_secret",apisecvalue);
			post.addParameter("redirect_uri","https://mind-inputs.rhcloud.com/OauthCallBackServlet");
			httpclient.executeMethod(post);
		    responseBody = post.getResponseBodyAsString();}
		  //  pw.println(responseBody);}
		    
			 else if(rm1.equals("GET")){
			     	GetMethod get=new GetMethod(tokenurl+"?code="+code+"&grant_type=authorization_code&client_id="+apikey+"&client_secret="+apisecvalue+"&redirect_uri=http://localhost:8080/MindPulpy1/OauthCallBackServlet");

				/* get.setQueryString(new NameValuePair[] { 
		     			    new NameValuePair("code",code)});
				 get.setQueryString(new NameValuePair[] { 
		     			    new NameValuePair("grant_type","authorization_code")});
				 get.setQueryString(new NameValuePair[] { 
		     			    new NameValuePair("client_id",apikey)});
				 get.setQueryString(new NameValuePair[] { 
		     			    new NameValuePair("client_secret",apisecvalue)});
				 get.setQueryString(new NameValuePair[] { 
		     			    new NameValuePair("redirect_uri","http://localhost:8080/MindPulpy1/OauthCallBackServlet")});*/
		     		
			         httpclient.executeMethod(get);
			         responseBody=get.getResponseBodyAsString();}
				 
			 JSONObject json = null;
				json = new JSONObject(responseBody);
		        access_token = json.getString("access_token");
			 
			
		//Token accessToken = service.getAccessToken(OAuthConstants.EMPTY_TOKEN,new Verifier(code));
		   //pw.println("Got Token:"+responseBody);  
		          // if(rm1.equals("JSON")){
//}
		   		    /* else if(rm1.equals("XML")){
		   		    	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		   		    	DocumentBuilder builder = factory.newDocumentBuilder();
		   		    	org.w3c.dom.Document document = builder.parse(new InputSource(new StringReader(responseBody)));  
		   		    	NodeList nl = document.getElementsByTagName("access_token"); 
		                Node n = nl.item(0);
		   		    	access_token = n.getFirstChild().getNodeValue(); // in some environments safer way

		   		     }*/

		            session1.setAttribute("access_token", access_token);	    
		            request.getRequestDispatcher("auth.jsp").include(request, response);
		        
		

		}
		catch(Exception e){}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
