package com.roobi.pulpy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.XML;

public class SamplePulpy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public SamplePulpy() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		
try{
    	//response.setContentType("text/xml");
    	URL url = new URL ("http://api.8coupons.com/v1/getdealtype");
        URLConnection uconn = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(uconn.getInputStream()));
	    String line=null;
	       pw.println(line);
	       System.out.println(line);
    }
catch(Exception e){}
    		 /*JSONObject json = null;
			try {
				json = new JSONObject(line);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		 String xml=null;
			try {
				xml = XML.toString(json);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		 pw.println("Hai");
    		 System.out.println("Hai");
        	 System.out.println(xml);*/
        
	}
}
