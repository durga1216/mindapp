package com.roobi.pulpy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Map;
import java.util.UUID;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import com.mindots.util.Utils;

/**
 * Servlet implementation class Quickcall
 */
@WebServlet("/Quickcall")
public class Quickcall extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Quickcall() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    response.addHeader("Access-Control-Allow-Origin", "*");  	
		String appid=request.getParameter("appid");
		String url=request.getParameter("url");
		String ourl1="https://oauth.intuit.com/oauth/v1/get_request_token";
		String ockey="qyprdX6G2AFPGqXc0KZ3eeq3gxNBfY";
		String oskey="F99WcjcynTlh13CtdQJy9xU5mLg31DETm7EQNgZ6";
		String oreq="GET";
		String osmeth="HMAC-SHA1";
		String ourl2="https://appcenter.intuit.com/Connect/Begin";
		//function
		Map<String, String> config = Utils.getConfigFromFile(getServletContext(), "config.properties");
		String uuid_string = UUID.randomUUID().toString();
			uuid_string = uuid_string.replaceAll("-", "");
			String oauth_nonce = uuid_string; 
			String eurl1 = URLEncoder.encode(ourl1, "UTF-8");
			long oauth_timestamp = System.currentTimeMillis()/1000;
			String parameter_string="";
			String call="https://mindapp-pulpy.rhcloud.com/Quickbook";
			//For checking the callback is required or not
			parameter_string = "oauth_callback="+URLEncoder.encode(call, "UTF-8")+"&oauth_consumer_key=" + ockey + "&oauth_nonce=" + oauth_nonce + "&oauth_signature_method=" + osmeth + "&oauth_timestamp=" + oauth_timestamp + "&oauth_version=1.0";        
			String signature_base_string = oreq+"&"+eurl1+"&" + URLEncoder.encode(parameter_string, "UTF-8");
			String oauth_signature = "";String oauth_signature1 = "";
			try {
				oauth_signature = computeSignature(signature_base_string, oskey+"&");  // note the & at the end. Normally the user access_token would go here, but we don't know it yet for request_token
				oauth_signature1 =URLEncoder.encode(oauth_signature, "UTF-8");
			}catch (GeneralSecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String authorization_header_string = "OAuth oauth_consumer_key=\"" + ockey + "\","
					+ "oauth_nonce=\"" + oauth_nonce + "\",oauth_signature_method=\"HMAC-SHA1\",oauth_signature=\"" + URLEncoder.encode(oauth_signature, "UTF-8") + "\",oauth_timestamp=\"" + 
                oauth_timestamp + "\",oauth_version=\"1.0\"";
			String uurl=ourl1+"?"+parameter_string+"&oauth_signature="+URLEncoder.encode(oauth_signature, "UTF-8");
			System.out.println(uurl);
			String oauth_token = "";
			HttpClient httpclient = new DefaultHttpClient();
			HttpResponse response1=null;
			try {
				HttpGet get1=new HttpGet(uurl);
				response1=httpclient.execute(get1);
				BufferedReader rd = new BufferedReader(
                            new InputStreamReader(response1.getEntity().getContent()));
     		StringBuffer result = new StringBuffer();
     		String line = "";
     		while ((line = rd.readLine()) != null) {
     			result.append(line);
     		}
     		String tok=result.toString();
     		String sec1="";
     		String[] chk1=tok.split("&");
    		for(int i=0;i<chk1.length;i++){
    			String[] stest=chk1[i].split("=");
    			if(stest[0].equals("oauth_token")){
    				oauth_token=chk1[i];
    			}else if(stest[0].equals("oauth_token_secret")){
    				sec1=chk1[i];
    			}
    		}
			Class.forName("com.mysql.jdbc.Driver").newInstance();
	    	Connection con = (Connection) DriverManager.getConnection(config.get("URL"),config.get("USER"),config.get("PASS"));
	    	PreparedStatement st=con.prepareStatement("insert into oauth1sec (secret,url) values('"+sec1+"','"+url+"')");
	    	st.executeUpdate();
		} 
		catch(Exception cpe)  {   
			
		}
		String author=ourl2+"?"+oauth_token+"&perms=write";
		response.setContentType("text/plain");
   	 	response.setCharacterEncoding("UTF-8");
   	 	response.getWriter().print(author);
	}
	private static String computeSignature(String baseString, String keyString) throws GeneralSecurityException, UnsupportedEncodingException {	 
	    SecretKey secretKey = null;
	    byte[] keyBytes = keyString.getBytes();
	    secretKey = new SecretKeySpec(keyBytes, "HmacSHA1");
	    Mac mac = Mac.getInstance("HmacSHA1");
	    mac.init(secretKey);
	    byte[] text = baseString.getBytes();
	    return new String(Base64.encodeBase64(mac.doFinal(text))).trim();
	}	 

}
