package com.roobi.pulpy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import net.sf.json.JSON;
import net.sf.json.JSONSerializer;
import net.sf.json.xml.XMLSerializer;



public class JsonToXml extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public JsonToXml() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	response.setHeader("Content-Type","application/json; charset=UTF-8");
		PrintWriter pw=response.getWriter();
		 try{
		    	
		         	 
			 URL url2=new URL("http://api.amp.active.com/v3/plan/search.json");
			 URLConnection uconn=url2.openConnection();
			 uconn.setDoOutput(true);
         	 OutputStreamWriter writer = new OutputStreamWriter(uconn.getOutputStream());
             writer.write("api_key=hgxk9ga6za9w824jrs9cn384&keyword=london");
         	 writer.flush();
         	 BufferedReader reader = new BufferedReader(new InputStreamReader(uconn.getInputStream()));
         	 String line=null;
         	 while ((line = reader.readLine()) != null) {
                 pw.println(line);
                                                            }
		 reader.close();
		 writer.close();
	   
    		
    	 }
        	

    	 
	    
	catch(Exception e){}
	}
	

}
