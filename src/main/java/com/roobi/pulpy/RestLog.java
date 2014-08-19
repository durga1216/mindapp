package com.roobi.pulpy;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
@Path("/log")
public class RestLog {
	 Connection con=null;
	    @GET
	    @Produces(MediaType.TEXT_PLAIN)
	    @Path("/check/{a}/{b}")
	    public Response addPlainText(@PathParam("a") String a, @PathParam("b") String b) {
	     String result11="";
	        try{
	    	    Class.forName("com.mysql.jdbc.Driver").newInstance();
	    	  // con=DriverManager.getConnection("jdbc:mysql://127.6.250.130:3306/mpulpy","adminPQ1iFfN","J5JhBL-XC9NG");
	    	  
	    	  con=DriverManager.getConnection("jdbc:mysql://localhost/mpulpy","root","root");

         PreparedStatement st=null;
         String id="<?xml version=\"1.0\"?>";
         st=con.prepareStatement("SELECT * from mtest where video_id='"+a+"' ");
         ResultSet rs = st.executeQuery();
         if(rs != null){
        	 
         while(rs.next()){
        	 String t=rs.getString("time");
        	 String d=rs.getString("m1");
        	 String dt=rs.getString("date");
	          id=id+"<"+dt+"> <"+t+">"+d+"</"+t+"> </"+dt+">";
	          
	          
              
         }}       
             	 result11= id;

	    }//try  
         
         catch(Exception e){
        	 e.printStackTrace();
         }
	        return Response.ok(result11)
				      .header("Access-Control-Allow-Origin", "*")
				      .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
				      .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
	
	}

}

