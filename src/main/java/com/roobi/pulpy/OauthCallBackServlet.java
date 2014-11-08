package com.roobi.pulpy;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
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

import com.mindots.util.Utils;

public class OauthCallBackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public OauthCallBackServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		Map<String, String> config = Utils.getConfigFromFile(getServletContext(), "config.properties");
		
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			  Connection con = (Connection) DriverManager.getConnection(config.get("URL"),config.get("USER"),config.get("PASS"));
			//	response.setContentType("application/json");
			String url1=request.getParameter("url");
			HttpSession session1=request.getSession(true);
			String url="ss"+(String) session1.getAttribute("url");
			String id=(String) session1.getAttribute("id");
			String appname="";String tokenurl="";String rm1="";String apikey="";
			String apisecvalue="";
			pw.println("before if"+id);
			if(url.equals("ssnull")){
				pw.println("inside if");
			PreparedStatement st3=con.prepareStatement("SELECT * From facebook ORDER BY count DESC LIMIT 1");
	        ResultSet rs3 = st3.executeQuery();
	        while(rs3.next()){
	        	id=rs3.getString("id");
	        	url=rs3.getString("url");
	        }
	        PreparedStatement st=con.prepareStatement("SELECT * From authen1 t1 where t1.appid=?");
		    st.setString(1, id);
	        ResultSet rs = st.executeQuery();
	        while(rs.next()){ 
		   	     String authen1=rs.getString("auth");
		   	     appname=rs.getString("appname");
		         String cname1=rs.getString("cname");
	           	  apikey=rs.getString("ckey");
	           	 String csecname1=rs.getString("csecname");
	           	  apisecvalue=rs.getString("cseckey");
	           	 String sname1=rs.getString("sname");
	           	 String svalue1=rs.getString("svalue");
	           	 String aurl1=rs.getString("aurl");
	           	  tokenurl=rs.getString("tokenurl");
	           	 String tlabel1=rs.getString("tlabel");
	           	 String treplace1=rs.getString("treplace");
	           	 String el1=rs.getString("el");
	           	 String ev1=rs.getString("ev");
	           	 String rf1=rs.getString("rf");
	           	  rm1=rs.getString("rmethod");
	        }
	        }else{
			 appname=(String) session1.getAttribute("appname");
			String apilabel=(String) session1.getAttribute("cname");
	 		 apikey=(String) session1.getAttribute("ckey");
	 		String apiseclabel=(String) session1.getAttribute("csecname");
	 		 apisecvalue=(String) session1.getAttribute("cseckey");
	 		String scope_label=(String) session1.getAttribute("sname");
	 		String scope_value=(String) session1.getAttribute("svalue");
	 		String aurl=(String) session1.getAttribute("aurl");
	 		 tokenurl=(String) session1.getAttribute("tokenurl");
	 		String tlabel=(String) session1.getAttribute("tlabel");
	 		String treplace=(String) session1.getAttribute("treplace");
	 		String el=(String) session1.getAttribute("el");
	 		String ev=(String) session1.getAttribute("ev");
	 		 rm1=(String)session1.getAttribute("rm1");
	 		String suma=(String)session1.getAttribute("sumatest");
	        }
			String code = request.getParameter(OAuthConstants.CODE);
			String responseBody=null;
			String responseMsg=null;
			String access_token=null;
			pw.println(rm1);
			pw.println(apikey);
			pw.println(tokenurl);
	        String line = "";
			HttpClient client=new DefaultHttpClient();
            pw.println("<body style='background-color:#ff9900;'>");


			if(rm1.equals("POST")){

				HttpPost post = new HttpPost(tokenurl);
				try{
				List <NameValuePair> cod = new ArrayList <NameValuePair>(5);
		        cod.add(new BasicNameValuePair("code", code)); 
		        cod.add(new BasicNameValuePair("grant_type", "authorization_code")); 
		        cod.add(new BasicNameValuePair("client_id",apikey));
		        cod.add(new BasicNameValuePair("client_secret",apisecvalue)); 
		        cod.add(new BasicNameValuePair("redirect_uri","https://mindapp-pulpy.rhcloud.com/OauthCallBackServlet")); 
		        post.setEntity(new UrlEncodedFormEntity(cod));
		        HttpResponse response1 = client.execute(post);
		        BufferedReader rd = new BufferedReader(new InputStreamReader(response1.getEntity().getContent()));
		        while ((responseMsg = rd.readLine()) != null) {
                 responseBody=responseMsg;		   }
		        pw.println(responseBody);
				}
				catch(Exception e){pw.println(e);}
			}
			  
			    
				 else if(rm1.equals("GET")){
					 HttpGet get=new HttpGet(tokenurl+"?code="+code+"&grant_type=authorization_code&client_id="+apikey+"&client_secret="+apisecvalue+"&redirect_uri=https://mindapp-pulpy.rhcloud.com/OauthCallBackServlet");
				    	 List <NameValuePair> cod = new ArrayList <NameValuePair>();
				    	 cod.add(new BasicNameValuePair("code",code));
				    	 cod.add(new BasicNameValuePair("grant_type","authorization_code"));
				    	 cod.add(new BasicNameValuePair("client_id",apikey));
				    	 cod.add(new BasicNameValuePair("client_secret",apisecvalue)); 
					     cod.add(new BasicNameValuePair("redirect_uri","https://mindapp-pulpy.rhcloud.com/OauthCallBackServlet")); 
					     HttpResponse response1 = client.execute(get);
					     BufferedReader rd = new BufferedReader
					    		  (new InputStreamReader(response1.getEntity().getContent()));
					    		    
					    		while ((responseMsg = rd.readLine()) != null) {
                                responseBody=responseMsg;			
	    		} 

	     
				     
				 }
			             BufferedReader br=new BufferedReader(new StringReader(responseBody));
			             while ((line = br.readLine()) != null) {
			            	 pw.println(line);
			            	 if(line.startsWith("{") || line.startsWith("[{") || line.endsWith("}")){
			            		 JSONObject json = null;
			            		 pw.println(responseBody);
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
				
				
					   session1.setAttribute("access_token111", access_token);
					   session1.setAttribute("id", id);
							
					             PreparedStatement st1=null;
					             st1=con.prepareStatement("insert into oauthtoken(id,token) values ('"+id+"','"+access_token+"')");				 
					             st1.executeUpdate();
							     st1.close();
					   if(access_token.equals(""))
				            {pw.println("<br><br><center><b><h2><font color='white'>Authentication Error with "+appname+"</font></center></h2></b>");}
					   else{
					    response.setContentType("text/html;charset=utf-8");
			        	response.setCharacterEncoding("UTF-8");
			            pw.println("<br><br><center><b><h2><font color='#ffffff;'>Sucessfully Authenticated with "+appname+"</font></center></h2></b>");
			            pw.println("<br><br><h3><center><a style='color:#ffffff;' href='auth.jsp'>Continue with Config</a></center></h3>");
			            pw.println("<br><br><h3><center><a style='color:#ffffff;' href='token.jsp'>Continue with App</a></center></h3></body>");
			            pw.println("<br><br><h3><center><a style='color:#ffffff;' href='https://mindapp-pulpy.rhcloud.com/PreBuild'>Continue with Oauth Simplify APP</a></center></h3></body>");
			            pw.println("<br><br><h3><center><a style='color:#ffffff;' href='https://mindapp-pulpy.rhcloud.com/PreRaw'>Continue with Oauth Raw APP</a></center></h3></body>");
			            pw.println("<br><br><h3><center><a style='color:#ffffff;' href='"+url+"'>Continue</a></center></h3></body>");

					   }
			}
			catch(Exception e){
				pw.println(e);
			}

		
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
