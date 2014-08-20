package com.roobi.pulpy;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.UUID;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.codec.binary.Base64;
import org.apache.geronimo.mail.util.Base64Encoder;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.FlickrApi;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

import com.mindots.util.Utils;

/**
 * Servlet implementation class Oauth1Call
 */
@WebServlet("/Oauth1Call")
public class Oauth1Call extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Oauth1Call() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Connection con=null;  
	   	 response.setHeader("Content-Type","text/html;charset=UTF-8");
	   	InputStream inputStream=null;
		 Map<String, String> config = Utils.getConfigFromFile(getServletContext(), "config.properties");
        PrintWriter out=response.getWriter();
		String oauth_verifier=request.getParameter("oauth_verifier");
		String oauth_token=request.getParameter("oauth_token");
		HttpSession session=request.getSession(true);
		String id=(String) session.getAttribute("id");
	    String appid=(String) session.getAttribute("appid");
	    String secret11=(String ) session.getAttribute("secret1");
	    //out.println(secret11);
	    String[] tok1=secret11.split("=");
	    String sec1=tok1[1];
	    //System.out.println(sec1);
	    //String oauth_signature1=(String) session.getAttribute("oauth_signature1");
	   // String parameter_string=(String) session.getAttribute("parameter_string");
	    try{
			  Class.forName("com.mysql.jdbc.Driver").newInstance();
			  con = (Connection) DriverManager.getConnection(config.get("URL"),config.get("USER"),config.get("PASS"));
	             PreparedStatement st=null;
	             st=con.prepareStatement("SELECT * From authen1 where appid=?");
	             st.setString(1, appid);
		         ResultSet rs = st.executeQuery();
		         while(rs.next()){
		        	 String oauth_signature_method=rs.getString("osmeth");String url1=rs.getString("ourl1");
	            	 String ourl21=rs.getString("ourl2");String ourl31=rs.getString("ourl3");
	            	 String oauth_consumer_key=rs.getString("ockey"); String secret=rs.getString("oskey");
	            	 String oreq1=rs.getString("oreq");
	            	 //========initial=========
	            	 if(oreq1.equals("GET")){
	            	 String uuid_string = UUID.randomUUID().toString();
	                 uuid_string = uuid_string.replaceAll("-", "");
	                 String oauth_nonce = uuid_string; 
	                 String eurl = URLEncoder.encode(ourl31, "UTF-8");
	                 int millis = (int) System.currentTimeMillis() * -1;// any relatively random alphanumeric string will work here. I used UUID minus "-" signs
	                 String oauth_timestamp = (new Long(System.currentTimeMillis()/1000)).toString();
	                  String parameter_string = "oauth_consumer_key=" + oauth_consumer_key + "&oauth_nonce=" + oauth_nonce + "&oauth_signature_method=" + oauth_signature_method + "&oauth_timestamp=" + oauth_timestamp + "&oauth_token="+oauth_token+"&oauth_verifier="+oauth_verifier+"&oauth_version=1.0";        
	                  String signature_base_string = oreq1+"&"+eurl+"&" + URLEncoder.encode(parameter_string, "UTF-8");
	                   System.out.println("signature_base_string=" + signature_base_string);
	                    String oauth_signature = "";String oauth_signature1 = "";
	                    //=========signature===========
	                 try {
	                      oauth_signature = computeSignature(signature_base_string, secret+"&"+sec1);  // note the & at the end. Normally the user access_token would go here, but we don't know it yet for request_token
	                       oauth_signature1 = URLEncoder.encode(oauth_signature, "UTF-8");
	                  } catch (GeneralSecurityException e) {
	                     // TODO Auto-generated catch block
	                     e.printStackTrace();
	                   }
	                 String authorization_header_string = "OAuth oauth_consumer_key=\"" + oauth_consumer_key + "\","
	                     		+ "oauth_nonce=\"" + oauth_nonce + "\",oauth_signature_method=\"HMAC-SHA1\",oauth_signature=\"" + URLEncoder.encode(oauth_signature, "UTF-8") + "\",oauth_timestamp=\"" + 
	                            oauth_timestamp + "\",oauth_version=\"1.0\"";
	                  String actok=ourl31+"?"+parameter_string+"&oauth_signature="+oauth_signature1;
	            	// out.println(actok);
	            	 HttpClient httpclient = new DefaultHttpClient();
	                 HttpResponse response1=null;
	                 	   HttpGet get1=new HttpGet(ourl31);
	                 	    response1=httpclient.execute(get1);
	                      HttpPost post = new HttpPost(url1);
	                      post.setHeader("Authorization", authorization_header_string);
	      				 response1 = httpclient.execute(post);
	                    	
	                       		BufferedReader rd = new BufferedReader(
	                                new InputStreamReader(response1.getEntity().getContent()));
	          
	         		StringBuffer result = new StringBuffer();
	         		String line = "";
	         		while ((line = rd.readLine()) != null) {
	         			result.append(line);
	         		}
	         		String tok=result.toString();
	         		 
	         		//out.println(tok);
	         		String[] acctok=tok.split("&");
	         		
	         		session.setAttribute("access_token1", acctok[1]);
	         		session.setAttribute("access_secret1", acctok[2]);
		         
	    out.println("<h2><center><font color='green'>Processing...</font></center></h3>");
        response.setHeader("Refresh", "1; URL=auth.jsp");   //*/
	            	 }         
		         else{
		        	 String uuid_string = UUID.randomUUID().toString();
	                 uuid_string = uuid_string.replaceAll("-", "");
	                 String oauth_nonce = uuid_string; 
	                 String eurl = URLEncoder.encode(ourl31, "UTF-8");
	                 int millis = (int) System.currentTimeMillis() * -1;// any relatively random alphanumeric string will work here. I used UUID minus "-" signs
	                 String oauth_timestamp = (new Long(System.currentTimeMillis()/1000)).toString();
	                  String parameter_string = "oauth_consumer_key=" + oauth_consumer_key + "&oauth_nonce=" + oauth_nonce + "&oauth_signature_method=" + oauth_signature_method + "&oauth_timestamp=" + oauth_timestamp + "&oauth_token="+oauth_token+"&oauth_verifier="+oauth_verifier+"&oauth_version=1.0";        
	                  String signature_base_string = oreq1+"&"+eurl+"&" + URLEncoder.encode(parameter_string, "UTF-8");
	                   System.out.println("signature_base_string=" + signature_base_string);
	                    String oauth_signature = "";String oauth_signature1 = "";
	                    //=========signature===========
	                 try {
	                      oauth_signature = computeSignature(signature_base_string, secret+"&"+sec1);  // note the & at the end. Normally the user access_token would go here, but we don't know it yet for request_token
	                       oauth_signature1 = URLEncoder.encode(oauth_signature, "UTF-8");
	                  } catch (GeneralSecurityException e) {
	                     // TODO Auto-generated catch block
	                     e.printStackTrace();
	                   }
	                 String authorization_header_string = "OAuth oauth_consumer_key=\"" + oauth_consumer_key + "\","
	                     		+ "oauth_nonce=\"" + oauth_nonce + "\",oauth_signature_method=\"HMAC-SHA1\",oauth_token=\""+oauth_token+"\",oauth_verifier=\""+oauth_verifier+"\",oauth_signature=\"" + URLEncoder.encode(oauth_signature, "UTF-8") + "\",oauth_timestamp=\"" + 
	                            oauth_timestamp + "\",oauth_version=\"1.0\"";
	                  String actok=ourl31+"?"+parameter_string+"&oauth_signature="+oauth_signature1;
	            	// out.println(actok);
	            	 HttpClient httpclient = new DefaultHttpClient();
	                 HttpResponse response1=null;
	                 HttpPost post = new HttpPost(ourl31);
                     post.setHeader("Authorization", authorization_header_string);
     				 response1 = httpclient.execute(post);
                   	
                      		BufferedReader rd = new BufferedReader(
                               new InputStreamReader(response1.getEntity().getContent()));
         
        		StringBuffer result = new StringBuffer();
        		String line = "";
        		while ((line = rd.readLine()) != null) {
        			result.append(line);
        		}
        		String tok=result.toString();
        		 
        		//out.println(tok);
        		String[] acctok=tok.split("&");
        		
        		session.setAttribute("access_token1", acctok[1]);
        		session.setAttribute("access_secret1", acctok[2]);
	         
   out.println("<h2><center><font color='green'>Processing...</font></center></h3>");
   response.setHeader("Refresh", "1; URL=auth.jsp");   //*/
	         }
		         }
	    }
	    catch(Exception e){
	    	out.println(e);
	    }
       
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
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String key="9f17ba0ed1e29e91e1e8829dd3e6f889";
		String secret="5e636fa8d8f0968b";
		int millis = (int) System.currentTimeMillis() * -1;
        int time = (int) millis / 1000;
        String nonce=String.valueOf(millis); 
        String tstmp=String.valueOf(time);
        String reqstr="GET&https%3A%2F%2Fwww.flickr.com%2Fservices%2Foauth%2Frequest_token&"
        		+ "oauth_consumer_key%3D"+key+""
        		+ "%26oauth_nonce%3D"+nonce+""
        		+ "%26oauth_signature_method%3DHMAC-SHA1"
        		+ "%26oauth_timestamp%3D"+tstmp+""
        		+ "%26oauth_version%3D1.0"
        		+ "%26oauth_callback%3Dhttps%253A%252F%252Fmindapp-pulpy.rhcloud.com%252FOauth1Call";
        MessageDigest md;
        StringBuffer sb = new StringBuffer();
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(reqstr.getBytes());
	        byte byteData[] = md.digest();
	        
	        for (int i = 0; i < byteData.length; i++) {
	         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
	        }
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String sig=sb.toString();
       String url1="https://www.flickr.com/services/oauth/request_token?"
       		+ "oauth_nonce="+nonce+"&"
       		+ "oauth_timestamp="+tstmp+"&"
       		+ "oauth_consumer_key="+key+"&"
       		+ "oauth_signature_method=HMAC-SHA1&"
       		+ "oauth_version=1.0&"
       		+ "oauth_signature="+sig+"&"
       		+ "oauth_callback=https%253A%252F%252Fmindapp-pulpy.rhcloud.com%252FOauth1Call";
       URL eurl1=new URL(url1);
		 URLConnection uconn = eurl1.openConnection();
	     HttpURLConnection conn = (HttpURLConnection) uconn;
	     conn.connect();
	     Object content = conn.getContent();
        /*try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = (Connection) DriverManager.getConnection(config.get("URL"),config.get("USER"),config.get("PASS"));
             PreparedStatement st=null;
             st=con.prepareStatement("SELECT * From authen1 where appid=?");
             st.setString(1, appid);
	         ResultSet rs = st.executeQuery();
	         while(rs.next()){
             String oapp1=rs.getString("oapp"); String oreq1=rs.getString("oreq");
        	 String ockey1=rs.getString("ockey"); String oskey1=rs.getString("oskey");
        	 String ourl1=rs.getString("ourl"); String omethod1=rs.getString("omethod");   
            // String omethod1="flickr.test.login";
            String RESOURCE_URL =ourl1; String apiKey= ockey1; String apiSecret = oskey1;
    	  // String RESOURCE_URL ="https://api.flickr.com/services/rest/"; String apiKey = "9f17ba0ed1e29e91e1e8829dd3e6f889";String apiSecret = "5e636fa8d8f0968b"; 
	      // String call="http://localhost:8071/mindapp/Oauth1Call";
	       String call="https://mindapp-pulpy.rhcloud.com/Oauth1Call";
	    OAuthService service = new ServiceBuilder().provider(FlickrApi.class).apiKey(apiKey).apiSecret(apiSecret).callback(call).build(); 
	    Verifier verifier = new Verifier(oauth_verifier);
	    Token accessToken = service.getAccessToken(requestToken, verifier);
	    OAuthRequest request1 = new OAuthRequest(Verb.GET,RESOURCE_URL);
	    request1.addQuerystringParameter("method", omethod1);
	    service.signRequest(accessToken, request1);
	    Response response1 = request1.send();
	    String res=response1.getBody();
	    session.setAttribute("xml1", res);
          out.println("<h2><center><font color='green'>Processing...</font></center></h3>");
		        response.setHeader("Refresh", "1; URL=auth1.jsp");
	         }    
 } catch (Exception e) {
	 out.println("ewwwwww"+e);
	 
	 =======ex=======
	 String key="9f17ba0ed1e29e91e1e8829dd3e6f889";
		String secret="5e636fa8d8f0968b";
		int millis = (int) System.currentTimeMillis() * -1;
        int time = (int) millis / 1000;
        String nonce=String.valueOf(millis); 
        String tstmp=String.valueOf(time);
        String url1="https://www.flickr.com/services/oauth/request_token";
        String parm="oauth_nonce="+nonce+""
        		+ "&oauth_timestamp="+tstmp+""
        		+ "&oauth_consumer_key="+key+""
        		+ "&oauth_signature_method=HMAC-SHA1"
        		+ "&oauth_version=1.0";
        String mth="GET";
        String sig="";
        //============End of initial===========
        try {
			String eurl = URLEncoder.encode(url1, "UTF-8");
			String eparm= URLEncoder.encode(parm, "UTF-8");
			String basestr=mth+"&"+eurl+"&"+eparm;
			System.out.println(basestr);
			sig=basestr;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
       // ============for signature============
        MessageDigest md;
        String sig1="";
		try {
			md = MessageDigest.getInstance("SHA1");
			md.update(secret.getBytes());
			md.update(sig.getBytes());
	        byte byteData[] = md.digest();
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < byteData.length; i++) {
	         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
	        }
	 
	        System.out.println("signature: " + sb.toString());
	        sig1=sb.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //======== send request=========
        String url2="https://www.flickr.com/services/oauth/request_token?"
        		+ "oauth_nonce="+nonce+""
        		+ "&oauth_timestamp="+tstmp+""
        		+ "&oauth_consumer_key="+key+""
        		+ "&oauth_signature_method=HMAC-SHA1"
        		+ "&oauth_version=1.0"
        		+ "&oauth_signature="+sig1+"";
       System.out.println(url2);
       
       String key="9f17ba0ed1e29e91e1e8829dd3e6f889";
		String secret="5e636fa8d8f0968b";
		int millis = (int) System.currentTimeMillis() * -1;
        int time = (int) millis / 1000;
        String nonce=String.valueOf(millis); 
        String tstmp=String.valueOf(time);
        String reqstr="GET&https%3A%2F%2Fwww.flickr.com%2Fservices%2Foauth%2Frequest_token&"
        		+ "oauth_consumer_key%3D"+key+""
        		+ "%26oauth_nonce%3D"+nonce+""
        		+ "%26oauth_signature_method%3DHMAC-SHA1"
        		+ "%26oauth_timestamp%3D"+tstmp+""
        		+ "%26oauth_version%3D1.0";
        	//	+ "%26oauth_callback%3Dhttps%3A%2F%2Fmindapp-pulpy.rhcloud.com%2FOauth1Call";
        
        
        /*MessageDigest md;
        StringBuffer sb = new StringBuffer();
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(reqstr.getBytes());
	        byte byteData[] = md.digest();
	        
	        for (int i = 0; i < byteData.length; i++) {
	         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
	        }
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   // 
        //String secretKey="30ade8cc0a1a6080343d3995a74f3e35";
        // get a hash key from the raw key bytes
        SecretKeySpec signingKey = new SecretKeySpec(secret.getBytes(), "HMACSHA1");
        String stringToStore="";
        // get a hasher instance and initialize with the signing key
        Mac mac;
		try {
			mac = Mac.getInstance("HMACSHA1");
			mac.init(signingKey);

	        // compute the hmac on input data bytes
	        byte[] rawHmac = mac.doFinal(reqstr.getBytes());
	        
	        // base64-encode the hmac
	       // result = Encoding.EncodeBase64(rawHmac);
	       // String result = new Base64Encoder().encode(rawHmac);
	        stringToStore = new String(Base64.encode(rawHmac));
	        System.out.println(stringToStore);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        String sig=stringToStore;
       String url1="https://www.flickr.com/services/oauth/request_token?"
       		+ "oauth_nonce="+nonce+"&"
       		+ "oauth_timestamp="+tstmp+"&"
       		+ "oauth_consumer_key="+key+"&"
       		+ "oauth_signature_method=HMAC-SHA1&"
       		+ "oauth_version=1.0&"
       		+ "oauth_signature="+sig;//+"&"
       		//+ "oauth_callback=https%3A%2F%2Fmindapp-pulpy.rhcloud.com%2FOauth1Call";
       response.sendRedirect(url1);
 
	}*/
	}

}
