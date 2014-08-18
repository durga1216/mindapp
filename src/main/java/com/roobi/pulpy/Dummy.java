package com.roobi.pulpy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class Dummy {
	public static void main(String[] args) throws UnsupportedEncodingException{
		String oauth_signature_method = "HMAC-SHA1";
        String oauth_consumer_key = "afeb0d55fe704b24b8b653a189df9fb4";
        String secret="4fefca48ad6742b0b746fe0465153c82";
        String uurl="https://api.fitbit.com/oauth/request_token";
        uurl=URLEncoder.encode(uurl, "UTF-8");
          String uuid_string = UUID.randomUUID().toString();
        uuid_string = uuid_string.replaceAll("-", "");
        String oauth_nonce = uuid_string;
        int millis = (int) System.currentTimeMillis() * -1;// any relatively random alphanumeric string will work here. I used UUID minus "-" signs
        String oauth_timestamp = (new Long(System.currentTimeMillis()/1000)).toString(); // get current time in milliseconds, then divide by 1000 to get seconds
           // the parameter string must be in alphabetical order
         String parameter_string = "oauth_consumer_key=" + oauth_consumer_key + "&oauth_nonce=" + oauth_nonce + "&oauth_signature_method=" + oauth_signature_method + "&oauth_timestamp=" + oauth_timestamp + "&oauth_version=1.0";        
          //System.out.println("parameter_string=" + parameter_string);
         String signature_base_string = "POST&"+uurl+"&" + URLEncoder.encode(parameter_string, "UTF-8");
          System.out.println("signature_base_string=" + signature_base_string);
           String oauth_signature = "";
        try {
             oauth_signature = computeSignature(signature_base_string, secret+"&");  // note the & at the end. Normally the user access_token would go here, but we don't know it yet for request_token
              System.out.println("oauth_signature=" + URLEncoder.encode(oauth_signature, "UTF-8"));
         } catch (GeneralSecurityException e) {
            e.printStackTrace();
          }
        String uuid_string1 = UUID.randomUUID().toString();
        uuid_string1 = uuid_string1.replaceAll("-", "");
        String oauth_nonce1 = uuid_string1;
        // any relatively random alphanumeric string will work here. I used UUID minus "-" signs
        String oauth_timestamp1 = (new Long(System.currentTimeMillis()/1000)).toString();
         String authorization_header_string = "OAuth oauth_consumer_key=\"" + oauth_consumer_key + "\","
         		+ "oauth_nonce=\"" + oauth_nonce + "\",oauth_signature_method=\"HMAC-SHA1\",oauth_signature=\"" + URLEncoder.encode(oauth_signature, "UTF-8") + "\",oauth_timestamp=\"" + 
                oauth_timestamp + "\",oauth_version=\"1.0\"";
          System.out.println("authorization_header_string=" + authorization_header_string);

         String oauth_token = "";
           try {
        	   HttpClient client = new DefaultHttpClient();
				HttpPost post = new HttpPost("https://api.fitbit.com/oauth/request_token");
				post.setHeader("Authorization", authorization_header_string);
				HttpResponse response1 = client.execute(post);
				BufferedReader br = new BufferedReader(
                        new InputStreamReader(response1.getEntity().getContent()));
      	     String line=null; String str="";
      	    
  	   
  	     while((line=br.readLine())!=null){
	       	 str+=line;
	       	 }
               System.out.println(str);
        
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
