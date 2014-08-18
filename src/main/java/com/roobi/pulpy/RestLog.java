package com.roobi.pulpy;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
@Path("/log")
public class RestLog {
	 Connection con=null;
	    @GET
	    @Produces(MediaType.TEXT_XML)
	    @Path("/check/{a}/{b}")
	    public String addPlainText(@PathParam("a") String a, @PathParam("b") String b) {
	     String result11="";
	        try{
	    	    Class.forName("com.mysql.jdbc.Driver").newInstance();
	    	    con=DriverManager.getConnection("jdbc:mysql://127.6.250.130:3306/mpulpy","adminPQ1iFfN","J5JhBL-XC9NG");
	    	   //con=DriverManager.getConnection("jdbc:mysql://localhost/mpulpy","root","root");

         PreparedStatement st=null;
         String id="";
         String mail="";
         String pwd="";
         String fn="";
         st=con.prepareStatement("SELECT id,email,fn,pwd From login where email='"+a+"' && pwd='"+b+"'");
         ResultSet rs = st.executeQuery();
         if(rs != null){
         while(rs.next()){
	          id=rs.getString("id");
              mail=rs.getString("email");
              pwd=rs.getString("pwd");
              fn=rs.getString("fn");
         }}       
              if(a.equals(mail) && b.equals(pwd)){
             	 
             	 result11= "welcome "+fn;
                  }
             else{
            	 result11= "Invalid User";
          	 }

	    }//try  
         
         catch(Exception e){
        	 e.printStackTrace();
         }
			return result11;
	
	}

}

