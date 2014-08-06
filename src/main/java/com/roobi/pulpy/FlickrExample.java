package com.roobi.pulpy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
public class FlickrExample {
 
	public static void main(String[] args) throws UnsupportedEncodingException {
		String oauth_signature_method = "HMAC-SHA1";
        String oauth_consumer_key = "8cd156666f78aa30085da4a604a370c9";
        String secret="a8ad3f781a1c6c9c";
          String uuid_string = UUID.randomUUID().toString();
        uuid_string = uuid_string.replaceAll("-", "");
        String oauth_nonce = uuid_string; 
        String url1="https://www.flickr.com/services/oauth/request_token";
        String eurl = URLEncoder.encode(url1, "UTF-8");
        int millis = (int) System.currentTimeMillis() * -1;// any relatively random alphanumeric string will work here. I used UUID minus "-" signs
          String oauth_timestamp = (new Long(millis/1000)).toString(); // get current time in milliseconds, then divide by 1000 to get seconds
         String parameter_string = "oauth_consumer_key=" + oauth_consumer_key + "&oauth_nonce=" + oauth_nonce + "&oauth_signature_method=" + oauth_signature_method + "&oauth_timestamp=" + oauth_timestamp + "&oauth_version=1.0";        
         // System.out.println("parameter_string=" + parameter_string);
         String signature_base_string = "GET&"+eurl+"&" + URLEncoder.encode(parameter_string, "UTF-8");
          System.out.println("signature_base_string=" + signature_base_string);
           String oauth_signature = "";
        try {
             oauth_signature = computeSignature(signature_base_string, secret+"&");  // note the & at the end. Normally the user access_token would go here, but we don't know it yet for request_token
             // System.out.println("oauth_signature=" + URLEncoder.encode(oauth_signature, "UTF-8"));
         } catch (GeneralSecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
         String authorization_header_string = "OAuth oauth_consumer_key=\"" + oauth_consumer_key + "\",oauth_signature_method=\"HMAC-SHA1\",oauth_timestamp=\"" + 
                oauth_timestamp + "\",oauth_nonce=\"" + oauth_nonce + "\",oauth_version=\"1.0\",oauth_signature=\"" + URLEncoder.encode(oauth_signature, "UTF-8") + "\"";
         // System.out.println("authorization_header_string=" + authorization_header_string);
          String uurl=url1+"?"+parameter_string+"&oauth_signature="+URLEncoder.encode(oauth_signature, "UTF-8");
          System.out.println(uurl);
         String oauth_token = "";
        HttpClient httpclient = new DefaultHttpClient();
           try {
        	   HttpGet get1=new HttpGet(uurl);
        	   HttpResponse response=httpclient.execute(get1);
            /* HttpPost httppost = new HttpPost(url1);
                httppost.setHeader("Authorization",authorization_header_string);
                ResponseHandler<String> responseHandler = new BasicResponseHandler();
               String responseBody = httpclient.execute(httppost, responseHandler);
              oauth_token = responseBody.substring(responseBody.indexOf("oauth_token=") + 12, responseBody.indexOf("&oauth_token_secret="));
                System.out.println(responseBody); // */
        	   System.out.println("Response Code : " + 
                       response.getStatusLine().getStatusCode());
 
		BufferedReader rd = new BufferedReader(
                       new InputStreamReader(response.getEntity().getContent()));
 
		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
 String tok=result.toString();
 String[] tok1=tok.split("&");
		System.out.println(tok1[0]+"---"+tok1[1]);
               
         } 
            catch(ClientProtocolException cpe)  {  System.out.println(cpe.getMessage());  }
           catch(IOException ioe) {   System.out.println(ioe.getMessage());  }
           //finally { httpclient.getConnectionManager().shutdown();  } 
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