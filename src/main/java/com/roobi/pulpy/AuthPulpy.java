package com.roobi.pulpy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

import net.sf.json.JSON;
import net.sf.json.JSONSerializer;
import net.sf.json.xml.XMLSerializer;

import com.mysql.jdbc.Connection;

public class AuthPulpy extends HttpServlet {
	private static final long serialVersionUID = 1L;
  Connection con=null;
    public AuthPulpy() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   	 response.setHeader("Content-Type","text/html; charset=UTF-8");

		PrintWriter out=response.getWriter();
      
      String rf=request.getParameter("rf");String select2=request.getParameter("rm");
      String select=request.getParameter("select2");
      String select3=request.getParameter("select3");String endurl=request.getParameter("endurl");
      String p1=request.getParameter("p1");String pv1=request.getParameter("pv1");
      String p2=request.getParameter("p2");String pv2=request.getParameter("pv2");
      String p3=request.getParameter("p3");String pv3=request.getParameter("pv3");
      String p4=request.getParameter("p4");String pv4=request.getParameter("pv4");
      String p5=request.getParameter("p5");String pv5=request.getParameter("pv5");
      String p6=request.getParameter("p6");String pv6=request.getParameter("pv6");
      HttpSession session=request.getSession(true);
	  String appid=(String) session.getAttribute("id");
      try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			 String url = "jdbc:mysql://127.6.250.130:3306/mpulpy";
	            final String USER = "adminPQ1iFfN";
	            final String PASS = "J5JhBL-XC9NG";

            con = (Connection) DriverManager.getConnection(url,USER,PASS);
            String sam=null;
             PreparedStatement st=null;
             String str1="insert into config(id,resf,rm,endurl,p1,pv1,p2,pv2,p3,pv3,p4,pv4,p5,pv5,p6,pv6) values ('"+appid+"','"+select3+"','"+select+"','"+endurl+"','"+p1+"','"+pv1+"','"+p2+"','"+pv2+"','"+p3+"','"+pv3+"','"+p4+"','"+pv4+"','"+p5+"','"+pv5+"','"+p6+"','"+pv6+"')";
			 st=con.prepareStatement(str1);
			 st.executeUpdate();
			 out.println("up success");
		     st.close();
		     st=con.prepareStatement("SELECT * FROM authen t1 JOIN config t2 ON t1.id = t2.id WHERE t1.id=?");
		                 st.setString(1, appid);

	         ResultSet rs = st.executeQuery();
	         while(rs.next()){
   	         String id=rs.getString("id");	 String appname1=rs.getString("appname");
             String authen1=rs.getString("auth");String ba1=rs.getString("b1");String ba2=rs.getString("b2");
             String ba3=rs.getString("b3");String ba4=rs.getString("b4");String ak1=rs.getString("a1");
             String ak2=rs.getString("a2"); String cname=rs.getString("cname");
        	 String ckey=rs.getString("ckey"); String rmethod=rs.getString("rmethod");
        	 String csecname=rs.getString("csecname");
        	 String cseckey=rs.getString("cseckey");
        	 String sname=rs.getString("sname");
        	 String svalue=rs.getString("svalue");
        	 String aurl=rs.getString("aurl");
        	 String tokenurl=rs.getString("tokenurl");
        	 String tlabel=rs.getString("tlabel");
        	 String treplace=rs.getString("treplace");
        	 String el=rs.getString("el");
        	 String ev=rs.getString("ev");
             String rf1=rs.getString("rf");String rm1=rs.getString("rm");
             String resf1=rs.getString("resf");String endurl1=rs.getString("endurl");
             String pa1=rs.getString("p1");String pva1=rs.getString("pv1");
             String pa2=rs.getString("p2");String pva2=rs.getString("pv2");
             String pa3=rs.getString("p3");String pva3=rs.getString("pv3");
             String pa4=rs.getString("p4");String pva4=rs.getString("pv4");
             String pa5=rs.getString("p5");String pva5=rs.getString("pv5");
             String pa6=rs.getString("p6");;String pva6=rs.getString("pv6");

	         String eurl=null;
	        if(authen1.equals("No Auth")){ //No Authentication
	         if(rf1.equals("REST") && rm1.equals ("GET") && resf1.equals("XML")){  //No Auth GET XML
	        	
	        	 if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5) && !"null".equals(pa6)){
	        		 eurl=endurl1+"?"+pa1+"="+pva1+"&"+pa2+"="+pva2+"&"+pa3+"="+pva3+"&"+pa4+"="+pva4+"&"+pa5+"="+pva5+"&"+pa6+"="+pva6;}
	        		 
	        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5)){
		        		 eurl=endurl1+"?"+pa1+"="+pva1+"&"+pa2+"="+pva2+"&"+pa3+"="+pva3+"&"+pa4+"="+pva4+"&"+pa5+"="+pva5;}
	        		 
	        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4)){
		        		 eurl=endurl1+"?"+pa1+"="+pva1+"&"+pa2+"="+pva2+"&"+pa3+"="+pva3+"&"+pa4+"="+pva4;}
	        		 
	        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3)){
		        		 eurl=endurl1+"?"+pa1+"="+pva1+"&"+pa2+"="+pva2+"&"+pa3+"="+pva3;}
	        		 
	        		 else if(!"null".equals(pa1) && !"null".equals(pa2)){
		        		 eurl=endurl1+"?"+"&"+pa1+"="+pva1+"&"+pa2+"="+pva2;}
	        		 
	        		 else if(!"null".equals(pa1)){
		        		 eurl=endurl1+"?"+"&"+pa1+"="+pva1;}
	        		 else if("null".equals(pa1))
	        			eurl=endurl1;
	        	 out.println("eurl");
	        	 URL eurl1=new URL(eurl);
	        	 try{
        		 URLConnection uconn = eurl1.openConnection();
        	     HttpURLConnection conn = (HttpURLConnection) uconn;
        	     conn.connect();
        	     Object content = conn.getContent();
        	     InputStream stream = (InputStream) content;
        	     String line=null;
        	     String str=null;
	        	 out.println("test2");

        	     BufferedReader br=new BufferedReader(new InputStreamReader(stream));
        			ServletContext servletContext = getServletContext();
        			String contextPath = servletContext.getRealPath(File.separator);
        			out.println("<br/>File system context path (in TestServlet): " + contextPath);

     	         PrintWriter pw1=new PrintWriter("webapp/xml/sam.xml");
        	     while((line=br.readLine())!=null){
        	    	 pw1.write(line);
 	       		     pw1.flush();
 	        	   //out.println(line);

        	      }
	        	    pw1.close();
	         }
	        	    catch(Exception e){
	    	        	 out.println(e);
	    	        	 }	
               	    //Runtime.getRuntime().exec("notepad F:/workspace/MindPulpy1/WebContent/sam.xml");
               	 out.println("<html><h1><center><font color='green'>Processing...</font></center></h2><html>");
    		     response.setHeader("Refresh", "1; URL=auth1.jsp"); }}
	         
	        	 	         
	         
	         
	         
	         else if(authen1.equals("API keys")){  //API Keys
	        	 if(rf1.equals("REST") && rm1.equals ("GET") && resf1.equals("XML")){  //API XML get
	        		 

	        		 if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5) && !"null".equals(pa6)){
	        		 eurl=endurl1+"?"+ak1+"="+ak2+"&"+pa1+"="+pva1+"&"+pa2+"="+pva2+"&"+pa3+"="+pva3+"&"+pa4+"="+pva4+"&"+pa5+"="+pva5+"&"+pa6+"="+pva6;}
	        		 
	        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5)){
		        		 eurl=endurl1+"?"+ak1+"="+ak2+"&"+pa1+"="+pva1+"&"+pa2+"="+pva2+"&"+pa3+"="+pva3+"&"+pa4+"="+pva4+"&"+pa5+"="+pva5;}
	        		 
	        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4)){
		        		 eurl=endurl1+"?"+ak1+"="+ak2+"&"+pa1+"="+pva1+"&"+pa2+"="+pva2+"&"+pa3+"="+pva3+"&"+pa4+"="+pva4;}
	        		 
	        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3)){
		        		 eurl=endurl1+"?"+ak1+"="+ak2+"&"+pa1+"="+pva1+"&"+pa2+"="+pva2+"&"+pa3+"="+pva3;}
	        		 
	        		 else if(!"null".equals(pa1) && !"null".equals(pa2)){
		        		 eurl=endurl1+"?"+ak1+"="+ak2+"&"+pa1+"="+pva1+"&"+pa2+"="+pva2;}
	        		 
	        		 else if(!"null".equals(pa1)){
		        		 eurl=endurl1+"?"+ak1+"="+ak2+"&"+pa1+"="+pva1;}
	        		 else if("null".equals(pa1))
	        			eurl=endurl1+"?"+ak1+"="+ak2;
	        		 out.println(eurl);
	        		 try{
	        		 URL eurl1=new URL(eurl);
	        		 URLConnection uconn = eurl1.openConnection();
	        	     HttpURLConnection conn = (HttpURLConnection) uconn;
	        	     conn.connect();
	        	     Object content = conn.getContent();
	        	     InputStream stream = (InputStream) content;
	        	     String line=null;
	        	     String str=null;
	        	     BufferedReader br=new BufferedReader(new InputStreamReader(stream));
	     	         PrintWriter pw1=new PrintWriter("webapp/xml/sam.xml");
	        	     while((line=br.readLine())!=null){
	        	    	 pw1.write(line);
	 	       		     pw1.flush();
	 	        	   // out.println(line);

	        	      }
		        	    pw1.close();
	        		 }
	        		 catch(Exception e){
	    	        	 out.println(e);
	    	        	 }
	        	    
	        		 out.println("susee");   		
	               	//Runtime.getRuntime().exec("notepad F:/workspace/MindPulpy1/WebContent/sam.xml");
	               	out.println("<html><h1><center><font color='green'>Processing...</font></center></h2><html>");
	   		        response.setHeader("Refresh", "1; URL=auth1.jsp"); }}
	         
	         
	         else if(authen1.equals("Oauth2")){
	     		HttpClient httpclient = new HttpClient();
                String Response=null;
	        	HttpSession session1=request.getSession(true);
		     	String access_token=(String)session1.getAttribute("access_token");
		     	out.println("Inside Oauth:"+access_token+"TokenUrl:"+tokenurl);
		     	String GetResponse=null;

		     	if(rm1.equals("GET")){ 
		     	//GetMethod get=new GetMethod(tokenurl);
		     	GetMethod get=new GetMethod(endurl);
		     	if("Authorization:Bearer".equals(treplace)){
			       get.setRequestHeader("Authorization", "Bearer "+access_token);
			       httpclient.executeMethod(get);
			       GetResponse=get.getResponseBodyAsString();

		     	}
		     	else if("QueryString".equals(treplace)){
		     		get.setQueryString(new NameValuePair[] { 
		     			    new NameValuePair(tlabel, access_token)
		     			    
		     			}); 
			         httpclient.executeMethod(get);
			         GetResponse=get.getResponseBodyAsString();}

		     	}

		    	else if(rm1.equals("POST")){
		     		PostMethod post=new PostMethod(tokenurl);
		     		
		     		if("Authorization:Bearer".equals(treplace)){
						post.setRequestHeader("Authorization", "Bearer "+access_token);
						httpclient.executeMethod(post);
					    GetResponse=post.getResponseBodyAsString();}
		     		
		     		else if("QueryString".equals(treplace)){
			     		post.addParameter(tlabel,access_token);
						httpclient.executeMethod(post);
					   GetResponse=post.getResponseBodyAsString();}
 
		     	}
			       out.println(GetResponse);

			    //PrintWriter out1 = new PrintWriter("F:/workspace/MindPulpy1/WebContent/sam.xml");
               // out1.println(Response);
                //out1.close();
  		          	 
	           /*	Runtime.getRuntime().exec("notepad F:/workspace/MindPulpy1/WebContent/sam.xml");
               	out.println("<h2><center><font color='green'>Processing...</font></center></h3>");
   		        response.setHeader("Refresh", "1; URL=auth1.jsp");*/
	         }
	         }  
      }
      catch(Exception e1){}
      
     
      

}
}
