package com.roobi.pulpy;
import java.awt.Window;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
public class amazon{
    private static final String AWS_ACCESS_KEY_ID = "AKIAJC5GPGCEOQPDJN5Q";

    private static final String AWS_SECRET_KEY = "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";

    private static final String ENDPOINT = "ecs.amazonaws.com";

    private static final String ITEM_ID = "0545010225";

    public static void main(String[] args) {
        /*
         * Set up the signed requests helper 
         */
        SignedRequestsHelper helper;
        try {
            helper = SignedRequestsHelper.getInstance(ENDPOINT, AWS_ACCESS_KEY_ID, AWS_SECRET_KEY);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        
        String requestUrl = null;
        String title = null;

        System.out.println("Map form example:");
        Map<String, String> params = new HashMap<String, String>();
        params.put("Service", "AWSECommerceService");
        params.put("Version", "2009-03-31");
        params.put("Operation", "ItemSearch");
        params.put("Keywords", "moto g");
        params.put("SearchIndex", "Electronics");
        params.put("AssociateTag", "123");
        params.put("ResponseGroup", "Medium");

        requestUrl = helper.sign(params);
        System.out.println("Signed Request is \"" + requestUrl + "\"");
        title = fetchTitle(requestUrl);
        //System.out.println("Signed Title is \"" + title + "\"");
        System.out.println();

        System.out.println("String form example:");
        String queryString = "Service=AWSECommerceService&Version=2009-03-31&Operation=ItemLookup&AssociateTag=123&ResponseGroup=Small&ItemId="
                + ITEM_ID;
        requestUrl = helper.sign(queryString);
        System.out.println("Request is \"" + requestUrl + "\"");

        title = fetchTitle(requestUrl);
       // System.out.println("Title is \"" + title + "\"");
        System.out.println();

    }

    private static String fetchTitle(String requestUrl) {
        String strcon = null;
        try {
        	URL second_url=new URL(requestUrl);
   		 URLConnection uconn = second_url.openConnection();
   	     HttpURLConnection conn = (HttpURLConnection) uconn;
   	         conn.connect();
   	         Object content = conn.getContent();
   	         InputStream stream = (InputStream) content;
   	         String line=null; 
       	     StringBuilder strb=new StringBuilder();
   	         BufferedReader br=new BufferedReader(new InputStreamReader(stream));
   	         while ((line = br.readLine()) != null)    { 
   	    	      strb.append(line);
     		     }//while
   	    	 strcon=strb.toString();
   	    	// System.out.println(strcon);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return strcon;
    }

}
