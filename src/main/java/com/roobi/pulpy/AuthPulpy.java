package com.roobi.pulpy;

import java.io.BufferedReader;
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
import java.util.Map;

import javax.servlet.RequestDispatcher;
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

import com.mindots.util.Utils;
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
   	 response.setHeader("Content-Type","text/html;charset=UTF-8");

		PrintWriter out=response.getWriter();
		 Map<String, String> config = Utils.getConfigFromFile(getServletContext(), "config.properties");

      String rf=request.getParameter("rf");String select2=request.getParameter("rm");
      String select=request.getParameter("select2");
      String select3=request.getParameter("select3");String burl=request.getParameter("baseurl");String endurl=request.getParameter("endurl");
      String p1=request.getParameter("p1");String pv1=request.getParameter("pv1");
      String p2=request.getParameter("p2");String pv2=request.getParameter("pv2");
      String p3=request.getParameter("p3");String pv3=request.getParameter("pv3");
      String p4=request.getParameter("p4");String pv4=request.getParameter("pv4");
      String p5=request.getParameter("p5");String pv5=request.getParameter("pv5");
      String p6=request.getParameter("p6");String pv6=request.getParameter("pv6");
      String p7=request.getParameter("p7");String pv7=request.getParameter("pv7");
      String p8=request.getParameter("p8"); String pv8=request.getParameter("pv8");
      String p9=request.getParameter("p9");String pv9=request.getParameter("pv9");
      String p10=request.getParameter("p10");String pv10=request.getParameter("pv10");
      HttpSession session=request.getSession(true);
      HttpSession session3=request.getSession(true);
	  String id=(String) session.getAttribute("id");
	  String appid=(String) session.getAttribute("appid"); 
	  session3.setAttribute("reqmeth",select);
      session3.setAttribute("resfor",select3);
      session3.setAttribute("endurl",endurl);
      session3.setAttribute("p1",p1);session3.setAttribute("pv1",pv1);
      session3.setAttribute("p2",p2);session3.setAttribute("pv2",pv2);
      session3.setAttribute("p3",p3);session3.setAttribute("pv3",pv3);
      session3.setAttribute("p4",p4);session3.setAttribute("pv4",pv4);
      session3.setAttribute("p5",p5);session3.setAttribute("pv5",pv5);
      session3.setAttribute("p6",p6);session3.setAttribute("pv6",pv6);
      session3.setAttribute("p7",p7);session3.setAttribute("pv7",pv7);
      session3.setAttribute("p8",p8);session3.setAttribute("pv8",pv8);
      session3.setAttribute("p9",p9);session3.setAttribute("pv9",pv9);
      session3.setAttribute("p10",p10);session3.setAttribute("pv10",pv10);



      try{
  		//out.println("start");

    	    response.setContentType("text/html");
			Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = (Connection) DriverManager.getConnection(config.get("URL"),config.get("USER"),config.get("PASS"));
            String sam=null;
             PreparedStatement st=null;
			 st=con.prepareStatement("insert into config(id,appid,resf,rm,baseurl,endurl,p1,pv1,p2,pv2,p3,pv3,p4,pv4,p5,pv5,p6,pv6,p7,pv7,p8,pv8,p9,pv9,p10,pv10) values ('"+id+"','"+appid+"','"+select3+"','"+select+"','"+burl+"','"+endurl+"','"+p1+"','"+pv1+"','"+p2+"','"+pv2+"','"+p3+"','"+pv3+"','"+p4+"','"+pv4+"','"+p5+"','"+pv5+"','"+p6+"','"+pv6+"','"+p7+"','"+pv7+"','"+p8+"','"+pv8+"','"+p9+"','"+pv9+"','"+p10+"','"+pv10+"')");
			 st.executeUpdate();
		     st.close();
		  		out.println("start2");
		     st=con.prepareStatement("SELECT * FROM authen1 t1 JOIN config t2 ON t1.appid = t2.appid WHERE t1.appid=?");
		                 st.setString(1, appid);

	         ResultSet rs = st.executeQuery();
	         while(rs.next()){
   	         String id1=rs.getString("id");	 String appname1=rs.getString("appname");
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
             String resf1=rs.getString("resf");String baseurl=rs.getString("baseurl");String endurl1=rs.getString("endurl");
             String pa1=rs.getString("p1");String pva1=rs.getString("pv1");
             String pa2=rs.getString("p2");String pva2=rs.getString("pv2");
             String pa3=rs.getString("p3");String pva3=rs.getString("pv3");
             String pa4=rs.getString("p4");String pva4=rs.getString("pv4");
             String pa5=rs.getString("p5");String pva5=rs.getString("pv5");
             String pa6=rs.getString("p6");;String pva6=rs.getString("pv6");
             String pa7=rs.getString("p7");;String pva7=rs.getString("pv7");
             String pa8=rs.getString("p8");;String pva8=rs.getString("pv8");
             String pa9=rs.getString("p9");;String pva9=rs.getString("pv9");
             String pa10=rs.getString("p10");;String pva10=rs.getString("pv10");

	         String eurl=null;
	              
	               
	               
	         
	         if(authen1.equals("API keys") || authen1.equals("No Auth")){  //API Keys
	        	 if(rf1.equals("REST") && rm1.equals ("GET") && resf1.equals("XML")){  //API XML get
	        		 
	        		 if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5) && !"null".equals(pa6) && !"null".equals(pa7) && !"null".equals(pa8) && !"null".equals(pa9) && !"null".equals(pa10)){
		        		 eurl=endurl1+"?"+ak1+"="+ak2+"&"+pa1+"="+pva1+"&"+pa2+"="+pva2+"&"+pa3+"="+pva3+"&"+pa4+"="+pva4+"&"+pa5+"="+pva5+"&"+pa6+"="+pva6+"&"+pa7+"="+pva7+"&"+pa8+"="+pva8+"&"+pa9+"="+pva9+"&"+pa10+"="+pva10;}
	        		 
	        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5) && !"null".equals(pa6) && !"null".equals(pa7) && !"null".equals(pa8) && !"null".equals(pa9)){
		        		 eurl=endurl1+"?"+ak1+"="+ak2+"&"+pa1+"="+pva1+"&"+pa2+"="+pva2+"&"+pa3+"="+pva3+"&"+pa4+"="+pva4+"&"+pa5+"="+pva5+"&"+pa6+"="+pva6+"&"+pa7+"="+pva7+"&"+pa8+"="+pva8+"&"+pa9+"="+pva9;}
	        		 
	        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5) && !"null".equals(pa6) && !"null".equals(pa7) && !"null".equals(pa8)){
		        		 eurl=endurl1+"?"+ak1+"="+ak2+"&"+pa1+"="+pva1+"&"+pa2+"="+pva2+"&"+pa3+"="+pva3+"&"+pa4+"="+pva4+"&"+pa5+"="+pva5+"&"+pa6+"="+pva6+"&"+pa7+"="+pva7+"&"+pa8+"="+pva8;}
	        		 
	        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5) && !"null".equals(pa6) && !"null".equals(pa7)){
		        		 eurl=endurl1+"?"+ak1+"="+ak2+"&"+pa1+"="+pva1+"&"+pa2+"="+pva2+"&"+pa3+"="+pva3+"&"+pa4+"="+pva4+"&"+pa5+"="+pva5+"&"+pa6+"="+pva6+"&"+pa7+"="+pva7;}
	        		 
	        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5) && !"null".equals(pa6)){
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
	        		 
	        		 else if("null".equals(ak1) && "null".equals(ak2))
	        			 eurl=endurl1;	        		
	        	//	out.println(eurl);
	        	     String str="";
	        		 try
	        		 {
	        		 URL eurl1=new URL(eurl);
	        		 URLConnection uconn = eurl1.openConnection();
	        	     HttpURLConnection conn = (HttpURLConnection) uconn;
	        	     conn.connect();
	        	     Object content = conn.getContent();
	        	     InputStream stream = (InputStream) content;
	        	     String line=null;
	        	     BufferedReader br=new BufferedReader(new InputStreamReader(stream));
	        	     while((line=br.readLine())!=null){
	         	    	// pw1.write(line);
	  	       		     //pw1.flush();
	  	       		     str+=line;
	  	        	   //out.println(line);

	         	      }
	         	     
	 	        	//    pw1.close();
	 	         }
	 	        	    catch(Exception e){
	 	    	        	 out.println(e);
	 	    	        	 }	
	 	        	 request.setAttribute("PassingObj", eurl);
	 	        	 request.setAttribute("Passing", str);
	 	     		    RequestDispatcher disp = getServletContext().getRequestDispatcher("/auth1.jsp");
	 	     		    disp.forward(request, response);
	               	}
	        	 
	         
	         
                 if(rf1.equals("REST") && rm1.equals ("GET") && resf1.equals("JSON")){  //API JSON get
	        		 

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
	        		 else if("null".equals(ak1) && "null".equals(ak2))
	        			 eurl=endurl1;
	        		 out.println(eurl);
	        		 
	        	     String str="";

	        		 URL eurl1=new URL(eurl);
	        		 try
	        		 {
	        		 URLConnection uconn = eurl1.openConnection();
	        	     HttpURLConnection conn = (HttpURLConnection) uconn;
	        	     conn.connect();
	        	     Object content = conn.getContent();
	        	     InputStream stream = (InputStream) content;
	        	     String line="";
	        	     BufferedReader br=new BufferedReader(new InputStreamReader(stream));
	        		  FileWriter fw=null;

	        	     while ((line = br.readLine()) != null)    { 
	        	    	
	         		  JSON json = JSONSerializer.toJSON( line .replaceAll("\\s+","")  );  
	     	          XMLSerializer xmlSerializer = new XMLSerializer();  
	     	          xmlSerializer.setTypeHintsEnabled(false);
	     	          xmlSerializer.setSkipWhitespace(true);
	     	          xmlSerializer.setTrimSpaces(true);
	     	          xmlSerializer.setRemoveNamespacePrefixFromElements(true);
	     	          xmlSerializer.removeNamespace(line);
	     	          xmlSerializer.setForceTopLevelObject(false);
	     		      String  xmlout = xmlSerializer.write( json );
	    			 // fw=new FileWriter("F:/workspace/MindPulpy1/Webcontent/sam.xml");
	    			  //fw.write(xmlout);
	    			 // fw.flush();
	     		     request.setAttribute("Passing", xmlout);
		     		    RequestDispatcher disp = getServletContext().getRequestDispatcher("/auth1.jsp");
		     		    disp.forward(request, response);
	    		     }
	    			//  fw.close();
                 }       		
	    	       	    catch(Exception e){
		    	        	 out.println(e);
		    	        	 }	
		         }
	           
	         	         
	         }
	         
	         
	         else if(authen1.equals("Oauth2")){
	     		HttpClient httpclient = new HttpClient();
                String Response=null;
	        	HttpSession session1=request.getSession(true);
		     	String access_token=(String)session1.getAttribute("access_token");
		     //	out.println("Inside Oauth:"+access_token+"TokenUrl:"+tokenurl);
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
		     		
		     		 if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5) && !"null".equals(pa6))
		     			{get.setQueryString(new NameValuePair[] { 
			     			    new NameValuePair(tlabel, access_token),new NameValuePair(pa1,pva1),new NameValuePair(pa2,pva2),new NameValuePair(pa3,pva3),new NameValuePair(pa4,pva4),new NameValuePair(pa5,pva5),new NameValuePair(pa6,pva6)});
		     		  }
		        		 
		                 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5))
		                	 get.setQueryString(new NameValuePair[] { 
		 		     			    new NameValuePair(tlabel, access_token),new NameValuePair(pa1,pva1),new NameValuePair(pa2,pva2),new NameValuePair(pa3,pva3),new NameValuePair(pa4,pva4),new NameValuePair(pa5,pva5)});
		     	
		        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4))
		        			 get.setQueryString(new NameValuePair[] { 
		        			 		    new NameValuePair(tlabel, access_token),new NameValuePair(pa1,pva1),new NameValuePair(pa2,pva2),new NameValuePair(pa3,pva3),new NameValuePair(pa4,pva4)});
		     	
		        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3))
		        			 get.setQueryString(new NameValuePair[] { 
		 		     			    new NameValuePair(tlabel, access_token),new NameValuePair(pa1,pva1),new NameValuePair(pa2,pva2),new NameValuePair(pa3,pva3)});
		        		 
		        		 else if(!"null".equals(pa1) && !"null".equals(pa2))
		        			 get.setQueryString(new NameValuePair[] { 
		 		     			    new NameValuePair(tlabel, access_token),new NameValuePair(pa1,pva1),new NameValuePair(pa2,pva2)});
		        		 
		        		 else if(!"null".equals(pa1))
		        			 get.setQueryString(new NameValuePair[] { 
		 		     			    new NameValuePair(tlabel, access_token),new NameValuePair(pa1,pva1)});
		        		 
		        		 else if("null".equals(pa1))
		     		          get.setQueryString(new NameValuePair[] { 
		     			            new NameValuePair(tlabel, access_token)}); 
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
					   
		     		  /*   post.addParameter((tlabel,access_token);
		     		     post.addParameter(p1,pva1);
		     		     post.addParameter(p2,pva2);
		     		     post.addParameter(p3,pva3);
		     		     post.addParameter(p3,pva3);
		     		     post.addParameter(p4,pva4);
		     		     post.addParameter(p4,pva6);}*/
 
		     	}
                 if(authen1.equals("Oauth2") && resf1.equals("JSON")){
                  JSON json = JSONSerializer.toJSON( GetResponse );  
   	              XMLSerializer xmlSerializer = new XMLSerializer();  
   	              xmlSerializer.setTypeHintsEnabled(false);
   	              xmlSerializer.setSkipWhitespace(true);
   	              xmlSerializer.setTrimSpaces(true);
   	              xmlSerializer.setRemoveNamespacePrefixFromElements(true);
   	              xmlSerializer.removeNamespace(GetResponse);
   	              xmlSerializer.setForceTopLevelObject(false);
   	              String xmlout=xmlSerializer.write(json);
   	           //   PrintWriter out1 = new PrintWriter("F:/workspace/MindPulpy1/WebContent/sam.xml");
                 // out1.println(xmlout);
                 // out1.close();
   	           request.setAttribute("Passing",xmlout);
   		    RequestDispatcher disp = getServletContext().getRequestDispatcher("/auth1.jsp");
   		    disp.forward(request, response);
                 }
                 
                 if(authen1.equals("Oauth2") && resf1.equals("XML")){
			    //PrintWriter out1 = new PrintWriter("F:/workspace/MindPulpy1/WebContent/sam.xml");
                //out1.println(GetResponse);
                //out1.close();
                	 request.setAttribute("Passing", GetResponse);
	        		    RequestDispatcher disp = getServletContext().getRequestDispatcher("/auth1.jsp");
	        		    disp.forward(request, response);
                 }
            
	         //  	Runtime.getRuntime().exec("notepad F:/workspace/MindPulpy1/WebContent/sam.xml");
               //	out.println("<h2><center><font color='green'>Processing...</font></center></h3>");
   		        //response.setHeader("Refresh", "1; URL=auth1.jsp");
	         }
	         
	         
	         // next condition starts here
	         }  
      }
      catch(Exception e){
    	  out.println(e);
      }
      
     
      

}
}
