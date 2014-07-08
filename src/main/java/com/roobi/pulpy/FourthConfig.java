package com.roobi.pulpy;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSON;
import net.sf.json.JSONSerializer;
import net.sf.json.xml.XMLSerializer;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import com.mindots.util.Utils;

/**
 * Servlet implementation class FourthConfig
 */
@WebServlet("/FourthConfig")
public class FourthConfig extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FourthConfig() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		 Map<String, String> config = Utils.getConfigFromFile(getServletContext(), "config.properties");
			response.setHeader("Content-Type","text/html;charset=UTF-8");
		HttpSession session=request.getSession(true);
		HttpSession session4=request.getSession(true);
		String id=(String) session.getAttribute("id");
		String appid=(String) session.getAttribute("appid");
		String respf3=request.getParameter("select3");
		String fourthurl=request.getParameter("fourthurl"); String fourthcycle=request.getParameter("fourthcycle"); String fourth1=request.getParameter("fourth1");String fourth2=request.getParameter("fourth2");
		String t1=request.getParameter("f1");  String tv1=request.getParameter("fv1"); String t2=request.getParameter("f2"); String tv2=request.getParameter("fv2");
		String t3=request.getParameter("f3");  String tv3=request.getParameter("fv3"); String t4=request.getParameter("f4"); String tv4=request.getParameter("fv4");
		String t5=request.getParameter("f5");  String tv5=request.getParameter("fv5"); String t6=request.getParameter("f6"); String tv6=request.getParameter("fv6");
		String t7=request.getParameter("f7");  String tv7=request.getParameter("fv7"); String t8=request.getParameter("f8"); String tv8=request.getParameter("fv8");
		String t9=request.getParameter("f9");  String tv9=request.getParameter("fv9"); String t10=request.getParameter("f10"); String tv10=request.getParameter("fv10");
	   String al=request.getParameter("alabel"); String ak=request.getParameter("akey");
	   session4.setAttribute("fourthurl",fourthurl);session4.setAttribute("fourthcycle",fourthcycle);
	   session4.setAttribute("a2label",al);session4.setAttribute("a2key",ak);
		session4.setAttribute("f1",t1);session4.setAttribute("fv1",tv1);
	      session4.setAttribute("f2",t2);session4.setAttribute("fv2",tv2);
	      session4.setAttribute("f3",t3);session4.setAttribute("fv3",tv3);
	      session4.setAttribute("f4",t4);session4.setAttribute("fv4",tv4);
	      session4.setAttribute("f5",t5);session4.setAttribute("fv5",tv5);
	      session4.setAttribute("f6",t6);session4.setAttribute("fv6",tv6);
	      session4.setAttribute("f7",t7);session4.setAttribute("fv7",tv7);
	      session4.setAttribute("f8",t8);session4.setAttribute("fv8",tv8);
	      session4.setAttribute("f9",t9);session4.setAttribute("fv9",tv9);
	      session4.setAttribute("f10",t10);session4.setAttribute("fv10",tv10);
		Connection con=null;
  	        try {
           Class.forName("com.mysql.jdbc.Driver").newInstance();
           con = (Connection) DriverManager.getConnection(config.get("URL"),config.get("USER"),config.get("PASS"));
           PreparedStatement st=con.prepareStatement("insert into fourthconfig(id,appid,fourthurl,fourthcycle,alabel,akey,fourth1,fourth2,f1,fv1,f2,fv2,f3,fv3,f4,fv4,f5,fv5,f6,fv6,f7,fv7,f8,fv8,f9,fv9,f10,fv10,resf3) values ('"+id+"','"+appid+"','"+fourthurl+"','"+fourthcycle+"','"+al+"','"+ak+"','"+fourth1+"','"+fourth2+"','"+t1+"','"+tv1+"','"+t2+"','"+tv2+"','"+t3+"','"+tv3+"','"+t4+"','"+tv4+"','"+t5+"','"+tv5+"','"+t6+"','"+tv6+"','"+t7+"','"+tv7+"','"+t8+"','"+tv8+"','"+t9+"','"+tv9+"','"+t10+"','"+tv10+"','"+respf3+"')");                
           st.executeUpdate();
           st.close();
          // out.println("INsert sucess");
           st=con.prepareStatement("SELECT * FROM authen1 t1 JOIN config t2 ON t1.appid = t2.appid JOIN fourthconfig t3 on t1.appid=t3.appid WHERE t1.appid=?");
           st.setString(1, appid);
     
           ResultSet rs = st.executeQuery();
	         while(rs.next()){
  	        String id1=rs.getString("id");	 String appname1=rs.getString("appname");
            String authen1=rs.getString("auth");String ba1=rs.getString("b1");String ba2=rs.getString("b2");
            String ba3=rs.getString("b3");String ba4=rs.getString("b4");
            String oriapilabel=rs.getString("a1");String oriapikey=rs.getString("a2"); 
            
            String rf1=rs.getString("rf");String rm1=rs.getString("rm");
            String resf1=rs.getString("resf");//String eurl=rs.getString("endurl");
            /*String tp1=rs.getString("p1");String tpv1=rs.getString("pv1");
            String tp2=rs.getString("p2");String tpv2=rs.getString("pv2");  // retrieve all valued from config table
            String tp3=rs.getString("p3");String tpv3=rs.getString("pv3");
            String tp4=rs.getString("p4");String tpv4=rs.getString("pv4");
            String tp5=rs.getString("p5");String tpv5=rs.getString("pv5");
            String tp6=rs.getString("p6");;String tpv6=rs.getString("pv6"); */
             
           //out.println("inside while");
            //here will go to fetch second-config values
            String fourthurl1=rs.getString("fourthurl");String fourthcycle1=rs.getString("fourthcycle"); String ak1=rs.getString("alabel");String ak2=rs.getString("akey");
            String fourthid=rs.getString("fourth1"); String fourthval=rs.getString("fourth2");
            String tp1=rs.getString("f1"); String tpv1=rs.getString("fv1");String tp2=rs.getString("f2"); String tpv2=rs.getString("fv2");
            String tp3=rs.getString("f3"); String tpv3=rs.getString("fv3");String tp4=rs.getString("f4"); String tpv4=rs.getString("fv4");
            String tp5=rs.getString("f5"); String tpv5=rs.getString("fv5");String tp6=rs.getString("f6"); String tpv6=rs.getString("fv6");
            String tp7=rs.getString("f7"); String tpv7=rs.getString("fv7");String tp8=rs.getString("f8"); String tpv8=rs.getString("fv8");
            String tp9=rs.getString("f9"); String tpv9=rs.getString("fv9");String tp10=rs.getString("f10"); String tpv10=rs.getString("fv10");     
            String resf3=rs.getString("resf3");
	         //out.println(fourthurl1+"<br>"+ak1+"<br>"+ak2+"<br>"+authen1);
            String fourthurl11=null;
            if(authen1.equals("No Auth")){ //No Authentication
   	         if(rf1.equals("REST") && rm1.equals ("GET")){  //No Auth GET XML

   	        	 if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3) && !"null".equals(tp4) && !"null".equals(tp5) && !"null".equals(tp6) && "entity".equals(fourthcycle1)){
   	        		 fourthurl11=fourthurl1+"?"+tp1+"="+tpv1+"&"+tp2+"="+tpv2+"&"+tp3+"="+tpv3+"&"+tp4+"="+tpv4+"&"+tp5+"="+tpv5+"&"+tp6+"="+tpv6;}
   	        		 
   	        		 else if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3) && !"null".equals(tp4) && !"null".equals(tp5)&& "entity".equals(fourthcycle1)){
   		        		 fourthurl11=fourthurl1+"?"+tp1+"="+tpv1+"&"+tp2+"="+tpv2+"&"+tp3+"="+tpv3+"&"+tp4+"="+tpv4+"&"+tp5+"="+tpv5;}
   	        		 
   	        		 else if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3) && !"null".equals(tp4)&& "entity".equals(fourthcycle1)){
   		        		 fourthurl11=fourthurl1+"?"+tp1+"="+tpv1+"&"+tp2+"="+tpv2+"&"+tp3+"="+tpv3+"&"+tp4+"="+tpv4;}
   	        		 
   	        		 else if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3)&& "entity".equals(fourthcycle1)){
   		        		 fourthurl11=fourthurl1+"?"+tp1+"="+tpv1+"&"+tp2+"="+tpv2+"&"+tp3+"="+tpv3;}
   	        		 
   	        		 else if(!"null".equals(tp1) && !"null".equals(tp2)&& "entity".equals(fourthcycle1)){
   		        		 fourthurl11=fourthurl1+"?"+tp1+"="+tpv1+"&"+tp2+"="+tpv2;}
   	        		 
   	        		 else if(!"null".equals(tp1)&& "entity".equals(fourthcycle1)){
   		        		 fourthurl11=fourthurl1+"?"+tp1+"="+tpv1;}
   	        		 else if("null".equals(tp1)&& "entity".equals(fourthcycle1))
   	        			fourthurl11=fourthurl1;
   	        	 
   	        		 else if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3)&& "flow".equals(fourthcycle1)){
   		        		 fourthurl11=fourthurl1+"?"+fourthid+"="+fourthval+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2+"&"+tp3+"="+tpv3;}
   	        		 
   	        		 else if(!"null".equals(tp1) && !"null".equals(tp2)&& "flow".equals(fourthcycle1)){
   		        		 fourthurl11=fourthurl1+"?"+fourthid+"="+fourthval+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2;}
   	        		 
   	        		 else if(!"null".equals(tp1)&& "flow".equals(fourthcycle1)){
   		        		 fourthurl11=fourthurl1+"?"+fourthid+"="+fourthval+"&"+tp1+"="+tpv1;}
   	        		 
   	        		 else if(!"null".equals(fourthid)&& !"null".equals(fourthval) && "null".equals(ak1) && "null".equals(ak2))
   	        			 fourthurl11=fourthurl1+"?"+fourthid+"="+fourthval;
   	        		 else if(!"null".equals(ak1) && !"null".equals(ak2))
   	        			 fourthurl11=fourthurl1+"?"+ak1+"="+ak2;
  	        	 
   	        	 URL fourthurl2=new URL(fourthurl11);
           		 URLConnection uconn = fourthurl2.openConnection();
           	     HttpURLConnection conn = (HttpURLConnection) uconn;
           	     conn.connect();
           	     Object content = conn.getContent();
           	     InputStream stream = (InputStream) content;
           	     String line=null;
           	     String str="";
           	     BufferedReader br=new BufferedReader(new InputStreamReader(stream));
                    if(resf3.equals("XML")){
           	     while((line=br.readLine())!=null){
           	    	 str+=line;
           	      }} //if and while
                    else if(resf3.equals("JSON")){
                   	 while ((line = br.readLine()) != null) {
                    	  JSON json = JSONSerializer.toJSON( line );  
  		     	          XMLSerializer xmlSerializer = new XMLSerializer();  
  		     	          xmlSerializer.setTypeHintsEnabled(false);
  		     	          xmlSerializer.setSkipWhitespace(true);
  		     	          xmlSerializer.setTrimSpaces(true);
  		     	          xmlSerializer.setRemoveNamespacePrefixFromElements(true);
  		     	          xmlSerializer.removeNamespace(line);
  		     	          xmlSerializer.setForceTopLevelObject(false);
  		     		      str = xmlSerializer.write( json ); 
                    } } //else if and while                 
           	     session.setAttribute("xml1", str);
  	              out.println("<h2><center><font color='green'>Processing...</font></center></h3>");
	              response.setHeader("Refresh", "1; URL=fourth_xml_config.jsp");	
                                  	 }
if(rf1.equals("REST") && rm1.equals ("POST")){  // No Auth XML post
	        		 
             		 String USER_AGENT = "Mozilla/5.0";
   	        	 String url=fourthurl1;	 	        		         		
   	        		//out.println(eurl);
   	        	     String str="";
   	        		 try
   	        		 {
   	        			 HttpClient client = new DefaultHttpClient();
   	        				HttpPost post = new HttpPost(url);
   	        				post.setHeader("User-Agent", USER_AGENT);
   	        				List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
   	        				urlParameters.add(new BasicNameValuePair(tp1, tpv1));
   	        				urlParameters.add(new BasicNameValuePair(tp2, tpv2));
   	        				urlParameters.add(new BasicNameValuePair(tp3, tpv3));
   	        				urlParameters.add(new BasicNameValuePair(tp4, tpv4));
   	        				urlParameters.add(new BasicNameValuePair(tp5, tpv5));
   	        				urlParameters.add(new BasicNameValuePair(tp6, tpv6));
   	        				urlParameters.add(new BasicNameValuePair(tp7, tpv7));
   	        				urlParameters.add(new BasicNameValuePair(tp8, tpv8));
   	        				urlParameters.add(new BasicNameValuePair(tp9, tpv9));
   	        				urlParameters.add(new BasicNameValuePair(tp10, tpv10));
   	        				post.setEntity(new UrlEncodedFormEntity(urlParameters));
   	        				HttpResponse response1 = client.execute(post);
   	        				BufferedReader br = new BufferedReader(
   	                                new InputStreamReader(response1.getEntity().getContent()));
   	         
   	        		StringBuffer result = new StringBuffer();
   	        		String line = "";
   	        	     if(resf1.equals("XML")){
   	        	     while((line=br.readLine())!=null){
   	         	 	  	       		     str+=line;}
   	        		 }
   	        		 else if(resf1.equals("JSON")){
   	        			 while ((line = br.readLine()) != null)    { 
   	 	        	    	
   	   	         		  JSON json = JSONSerializer.toJSON( line)  ;
   	   	     	          XMLSerializer xmlSerializer = new XMLSerializer();  
   	   	     	          xmlSerializer.setTypeHintsEnabled(false);
   	   	     	          xmlSerializer.setSkipWhitespace(true);
   	   	     	          xmlSerializer.setTrimSpaces(true);
   	   	     	          xmlSerializer.setRemoveNamespacePrefixFromElements(true);
   	   	     	          xmlSerializer.removeNamespace(line);
   	   	     	          xmlSerializer.setRootName("root");
   	   	     	          xmlSerializer.setForceTopLevelObject(false);
   	   	     		      str = xmlSerializer.write( json );
   	        		 } //while
   	        		 } //if
   	        		 }//try
   	         	     catch(Exception e){
   	 	    	      out.println(e);}	
   	        		 session.setAttribute("xml1", str);
   	     			 out.println("<h2><center><font color='green'>Processing...</font></center></h3>");

   	     		        response.setHeader("Refresh", "1; URL=auth1.jsp");	
   	               	} // NO Auth post    
            }
            
            else if(authen1.equals("API keys")){  //API Keys
	        	 if(rf1.equals("REST") && rm1.equals ("GET")){  //API XML get

	        		 if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3) && !"null".equals(tp4) && !"null".equals(tp5) && !"null".equals(tp6)&& "entity".equals(fourthcycle1))
	        		     fourthurl11=fourthurl1+"?"+ak1+"="+ak2+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2+"&"+tp3+"="+tpv3+"&"+tp4+"="+tpv4+"&"+tp5+"="+tpv5+"&"+tp6+"="+tpv6;
	        		 
	        		 else if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3) && !"null".equals(tp4) && !"null".equals(tp5)&& "entity".equals(fourthcycle1))
		        		 fourthurl11=fourthurl1+"?"+ak1+"="+ak2+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2+"&"+tp3+"="+tpv3+"&"+tp4+"="+tpv4+"&"+tp5+"="+tpv5;
	        		 
	        		 else if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3) && !"null".equals(tp4)&& "entity".equals(fourthcycle1))
		        		 fourthurl11=fourthurl1+"?"+ak1+"="+ak2+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2+"&"+tp3+"="+tpv3+"&"+tp4+"="+tpv4;
	        		 
	        		 else if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3)&& "entity".equals(fourthcycle1))
		        		 fourthurl11=fourthurl1+"?"+ak1+"="+ak2+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2+"&"+tp3+"="+tpv3;
	        		 
	        		 else if(!"null".equals(tp1) && !"null".equals(tp2)&& "entity".equals(fourthcycle1))
		        		 fourthurl11=fourthurl1+"?"+ak1+"="+ak2+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2;
	        		 
	        		 else if(!"null".equals(tp1)&& "entity".equals(fourthcycle1))
		        		 fourthurl11=fourthurl1+"?"+ak1+"="+ak2+"&"+tp1+"="+tpv1;
	        		 
	        		 else if(!"null".equals(fourthid)&& !"null".equals(fourthval) && "flow".equals(fourthcycle1)&&!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3))
		        		 fourthurl11=fourthurl1+"?"+oriapilabel+"="+oriapikey+"&"+fourthid+"="+fourthval+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2+"&"+tp3+"="+tpv3;
	        		 
	        		 else if(!"null".equals(fourthid)&& !"null".equals(fourthval) && "flow".equals(fourthcycle1)&&!"null".equals(tp1) && !"null".equals(tp2))
		        		 fourthurl11=fourthurl1+"?"+oriapilabel+"="+oriapikey+"&"+fourthid+"="+fourthval+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2;
	        		 
	        		 else if(!"null".equals(fourthid)&& !"null".equals(fourthval) && "flow".equals(fourthcycle1)&&!"null".equals(tp1))
		        		 fourthurl11=fourthurl1+"?"+oriapilabel+"="+oriapikey+"&"+fourthid+"="+fourthval+"&"+tp1+"="+tpv1;
	        		 
	        		 else if(!"null".equals(fourthid)&& !"null".equals(fourthval) && "flow".equals(fourthcycle1))
	        			 fourthurl11=fourthurl1+"?"+oriapilabel+"="+oriapikey+"&"+fourthid+"="+fourthval;
	        		
	        		 else if(!"null".equals(ak1) && !"null".equals(ak2)&& "entity".equals(fourthcycle1))
	        			      fourthurl11=fourthurl1+"?"+ak1+"="+ak2;
	        		 out.println(fourthurl11);
	        		 URL url1=new URL(fourthurl11);
    				 URLConnection uconn = url1.openConnection();
    				 String str="";
                     BufferedReader br = new BufferedReader(new InputStreamReader(uconn.getInputStream()));
         		     String line=null;
         		     FileWriter fw=null;
         		     if(resf3.equals("XML")){
         		         while((line=br.readLine())!=null){
        	       		     str+=line;
           	         }} //if and while
         		     else if(resf3.equals("JSON")){ 
         		    	 while ((line = br.readLine()) != null) {
                	      JSON json = JSONSerializer.toJSON( line );  
		     	          XMLSerializer xmlSerializer = new XMLSerializer();  
		     	          xmlSerializer.setTypeHintsEnabled(false);
		     	          xmlSerializer.setSkipWhitespace(true);
		     	          xmlSerializer.setTrimSpaces(true);
		     	          xmlSerializer.setRemoveNamespacePrefixFromElements(true);
		     	          xmlSerializer.removeNamespace(line);
		     	          xmlSerializer.setForceTopLevelObject(false);
		     		      str = xmlSerializer.write( json );
         		    	 }} //elseif and while
         		     
         		  session.setAttribute("xml1", str);
	              out.println("<h2><center><font color='green'>Processing...</font></center></h3>");
 		          response.setHeader("Refresh", "1; URL=fourth_xml_config.jsp");		
	          } //GET
	        	 if(rf1.equals("REST") && rm1.equals ("POST")){  // apikey XML post
	        	  		String str="";	 	        		         		

		          		 String USER_AGENT = "Mozilla/5.0";
			        	 String url=fourthurl1;	 	        		         		
			        		//out.println(eurl);
			        		 try
			        		 {
			        			 HttpClient client = new DefaultHttpClient();
			        				HttpPost post = new HttpPost(url);
			        				post.setHeader("User-Agent", USER_AGENT);
			        				List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
			        				urlParameters.add(new BasicNameValuePair(ak1, ak2));
			        				urlParameters.add(new BasicNameValuePair(tp1, tpv1));
	    	        				urlParameters.add(new BasicNameValuePair(tp2, tpv2));
	    	        				urlParameters.add(new BasicNameValuePair(tp3, tpv3));
	    	        				urlParameters.add(new BasicNameValuePair(tp4, tpv4));
	    	        				urlParameters.add(new BasicNameValuePair(tp5, tpv5));
	    	        				urlParameters.add(new BasicNameValuePair(tp6, tpv6));
	    	        				urlParameters.add(new BasicNameValuePair(tp7, tpv7));
	    	        				urlParameters.add(new BasicNameValuePair(tp8, tpv8));
	    	        				urlParameters.add(new BasicNameValuePair(tp9, tpv9));
	    	        				urlParameters.add(new BasicNameValuePair(tp10, tpv10));
			        				post.setEntity(new UrlEncodedFormEntity(urlParameters));
			        				HttpResponse response1 = client.execute(post);
			        				BufferedReader br = new BufferedReader(
			                                new InputStreamReader(response1.getEntity().getContent()));
			         
			        		StringBuffer result = new StringBuffer();
			        		String line = "";
			        	     if(resf1.equals("XML")){
			        	     while((line=br.readLine())!=null){
			         	 	  	       		     str+=line;}
			        		 }
			        		 else if(resf1.equals("JSON")){
			        			 while ((line = br.readLine()) != null)    { 
			 	        	    	
			   	         		  JSON json = JSONSerializer.toJSON( line)  ;
			   	     	          XMLSerializer xmlSerializer = new XMLSerializer();  
			   	     	          xmlSerializer.setTypeHintsEnabled(false);
			   	     	          xmlSerializer.setSkipWhitespace(true);
			   	     	          xmlSerializer.setTrimSpaces(true);
			   	     	          xmlSerializer.setRemoveNamespacePrefixFromElements(true);
			   	     	          xmlSerializer.removeNamespace(line);
			   	     	          xmlSerializer.setRootName("root");
			   	     	          xmlSerializer.setForceTopLevelObject(false);
			   	     		      str = xmlSerializer.write( json );
			        		 } //while
			        		 } //if
			        		 }//try
			         	     catch(Exception e){
			 	    	      out.println(e);}	
			        		 session.setAttribute("xml1", str);
			     			 out.println("<h2><center><font color='green'>Processing...</font></center></h3>");

			     		        response.setHeader("Refresh", "1; URL=auth1.jsp");	
			               	}//post api key
		        	 
	        }  //Main if API keys

   } 	//while 
} // try

  	 catch(Exception e){
  		 out.println(e);
  	 }
	}

}

