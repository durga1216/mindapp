package com.roobi.pulpy;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import net.sf.json.JSON;
import net.sf.json.JSONSerializer;
import net.sf.json.xml.XMLSerializer;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.mindots.util.Utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class MobiClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Connection con=null;
	

  	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*PrintWriter out=response.getWriter();
		HttpSession session=request.getSession(true);
		String appid=(String) session.getAttribute("id");
		String access_token=(String) session.getAttribute("access_token");
  		out.println(access_token);*/
  	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Map<String, String> config = Utils.getConfigFromFile(getServletContext(), "config.properties");
         PrintWriter out=response.getWriter();

		response.setHeader("Content-Type","text/xml; charset=UTF-8");
		Connection con=null;
		 HttpSession session=request.getSession(true);
		  String appid=(String) session.getAttribute("xx"); 
		  String eurl11=(String) session.getAttribute("el"); 
			//String appid=request.getParameter("appid");
		//String eurl11=request.getParameter("eurl");
		String pid=request.getParameter("pid");
		String p1=request.getParameter("p1");String p2=request.getParameter("p2");
		String p3=request.getParameter("p3");String p4=request.getParameter("p4");
		String p5=request.getParameter("p5");String p6=request.getParameter("p6");
		String p7=request.getParameter("p7");String p8=request.getParameter("p8");
        String p9=request.getParameter("p9");String p10=request.getParameter("p10");
        
		try{
			
	    Class.forName("com.mysql.jdbc.Driver").newInstance();
        con = (Connection) DriverManager.getConnection(config.get("URL"),config.get("USER"),config.get("PASS"));

	    PreparedStatement st=con.prepareStatement("SELECT * FROM authen1 t1 JOIN config t2 ON t1.appid = t2.appid JOIN xmlconfig t3 ON t1.appid=t3.appid  WHERE t1.appid=?");
	    st.setString(1, appid);
        ResultSet rs = st.executeQuery();
        PreparedStatement st1=con.prepareStatement("SELECT * FROM authen1 t1 JOIN secondconfig t2 ON t1.appid = t2.appid JOIN secxmlconfig t3 ON t1.appid=t3.appid  WHERE t1.appid=?");
	    st1.setString(1, appid);
        ResultSet rs1 = st1.executeQuery();
        PreparedStatement st2=con.prepareStatement("SELECT * FROM authen1 t1 JOIN thirdconfig t2 ON t1.appid = t2.appid JOIN thrdxmlconfig t3 ON t1.appid=t3.appid  WHERE t1.appid=?");
	    st2.setString(1, appid);
        ResultSet rs2 = st2.executeQuery();
        PreparedStatement st3=con.prepareStatement("SELECT * FROM authen1 t1 JOIN fourthconfig t2 ON t1.appid = t2.appid JOIN fourthxmlconfig t3 ON t1.appid=t3.appid  WHERE t1.appid=?");
	    st3.setString(1, appid);
        ResultSet rs3 = st3.executeQuery();
        if(eurl11.equals("1")){
        while(rs.next()){ // retrieve data from Database and join two tables namely(config&xmlconfig)
        	String id=rs.getString("id");	 String appname1=rs.getString("appname");
            String authen1=rs.getString("auth");String ba1=rs.getString("b1");String b2=rs.getString("b2");
            String ba3=rs.getString("b3");String b4=rs.getString("b4");String ak1=rs.getString("a1");
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
         String rf1=rs.getString("rf");
         String h1=rs.getString("h1");String hv1=rs.getString("hv1");
         String h2=rs.getString("h2");String hv2=rs.getString("hv2");
         String h3=rs.getString("h3");String hv3=rs.getString("hv3");
         String h4=rs.getString("h4");String hv4=rs.getString("hv4");
         String h5=rs.getString("h5");String hv5=rs.getString("hv5");
	     String line=null;

            String rm1=rs.getString("rm");
            
   	     String access_token=rs.getString("extoken");
        	String resf1=rs.getString("resf");String endurl1=rs.getString("endurl");
             String mname=rs.getString("baseurl");
             String sigckey=rs.getString("sigckey");
             String sigskey=rs.getString("sigskey");
            String pa1=rs.getString("p1");String pva1=rs.getString("pv1");
            String pa2=rs.getString("p2");String pva2=rs.getString("pv2");
            String pa3=rs.getString("p3");String pva3=rs.getString("pv3");
            String pa4=rs.getString("p4");String pva4=rs.getString("pv4");
            String pa5=rs.getString("p5");String pva5=rs.getString("pv5");
            String pa6=rs.getString("p6");String pva6=rs.getString("pv6");
            String pa7=rs.getString("p7");String pva7=rs.getString("pv7");
            String pa8=rs.getString("p8");String pva8=rs.getString("pv8");
            String pa9=rs.getString("p9");String pva9=rs.getString("pv9");
            String pa10=rs.getString("p10");String pva10=rs.getString("pv10");

            String xr=rs.getString("xr");String xrv=rs.getString("xrv");
            
 String x1=rs.getString("x1"); String xv1=rs.getString("xv1");String x2=rs.getString("x2"); String xv2=rs.getString("xv2");
 String x3=rs.getString("x3"); String xv3=rs.getString("xv3");String x4=rs.getString("x4"); String xv4=rs.getString("xv4");
 String x5=rs.getString("x5"); String xv5=rs.getString("xv5");String x6=rs.getString("x6"); String xv6=rs.getString("xv6");
 String x7=rs.getString("x7"); String xv7=rs.getString("xv7");String x8=rs.getString("x8"); String xv8=rs.getString("xv8");
 String x9=rs.getString("x9"); String xv9=rs.getString("xv9");String x10=rs.getString("x10"); String xv10=rs.getString("xv10");
 String x11=rs.getString("x11"); String xv11=rs.getString("xv11");String x12=rs.getString("x12"); String xv12=rs.getString("xv12");
 String x13=rs.getString("x13"); String xv13=rs.getString("xv13");String x14=rs.getString("x14"); String xv14=rs.getString("xv14");
 String x15=rs.getString("x15"); String xv15=rs.getString("xv15");String x16=rs.getString("x16"); String xv16=rs.getString("xv16");
 String x17=rs.getString("x17"); String xv17=rs.getString("xv17");String x18=rs.getString("x18"); String xv18=rs.getString("xv18");
 String x19=rs.getString("x19"); String xv19=rs.getString("xv19");String x20=rs.getString("x20"); String xv20=rs.getString("xv20");
 String x21=rs.getString("x21"); String xv21=rs.getString("xv21");String x22=rs.getString("x22"); String xv22=rs.getString("xv22");
 String x23=rs.getString("x23"); String xv23=rs.getString("xv23");String x24=rs.getString("x24"); String xv24=rs.getString("xv24");
 String x25=rs.getString("x25"); String xv25=rs.getString("xv25");String x26=rs.getString("x26"); String xv26=rs.getString("xv26");
 String x27=rs.getString("x27"); String xv27=rs.getString("xv27");String x28=rs.getString("x28"); String xv28=rs.getString("xv28");
 String x29=rs.getString("x29"); String xv29=rs.getString("xv29");String x30=rs.getString("x30"); String xv30=rs.getString("xv30");

 
  Document doc=null;  //TO Convert XMLSTRING TO DOCUMENT
       DocumentBuilder builder=null;
       DocumentBuilderFactory domFactory=DocumentBuilderFactory.newInstance();
       builder=domFactory.newDocumentBuilder();
       String eurl=null;
       String responseMsg=null;
       HttpClient client = new DefaultHttpClient();
   	String GetResponse=null;
   	String jsonxmlout=null;
   	String str="";
    Object obj;
       if(authen1.equals("No Auth")){ //No Authentication
	         if(rf1.equals("REST") && rm1.equals ("GET") && resf1.equals("XML") || resf1.equals("JSON") ){  //No Auth GET XML
	        	 
	             if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5) && !"null".equals(pa6) && !"null".equals(pa7) && !"null".equals(pa8) && !"null".equals(pa9) && !"null".equals(pa10)){
	         		 eurl=endurl1+"?"+pa1+"="+p1+"&"+pa2+"="+p2+"&"+pa3+"="+p3+"&"+pa4+"="+p4+"&"+pa5+"="+p5+"&"+pa6+"="+p6+"&"+pa7+"="+p7+"&"+pa8+"="+p8+"&"+pa9+"="+p9+"&"+pa10+"="+p10;}
	        		 
	             else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5) && !"null".equals(pa6) && !"null".equals(pa7) && !"null".equals(pa8) && !"null".equals(pa9)){
	         		 eurl=endurl1+"?"+pa1+"="+p1+"&"+pa2+"="+p2+"&"+pa3+"="+p3+"&"+pa4+"="+p4+"&"+pa5+"="+p5+"&"+pa6+"="+p6+"&"+pa7+"="+p7+"&"+pa8+"="+p8+"&"+pa9+"="+p9;}
	             
	             else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5) && !"null".equals(pa6) && !"null".equals(pa7) && !"null".equals(pa8)){
	         		 eurl=endurl1+"?"+pa1+"="+p1+"&"+pa2+"="+p2+"&"+pa3+"="+p3+"&"+pa4+"="+p4+"&"+pa5+"="+p5+"&"+pa6+"="+p6+"&"+pa7+"="+p7+"&"+pa8+"="+p8;}
	             
	             else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5) && !"null".equals(pa6) && !"null".equals(pa7)){
	         		 eurl=endurl1+"?"+pa1+"="+p1+"&"+pa2+"="+p2+"&"+pa3+"="+p3+"&"+pa4+"="+p4+"&"+pa5+"="+p5+"&"+pa6+"="+p6+"&"+pa7+"="+p7;}
	             
	            else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5) && !"null".equals(pa6)){
	         		 eurl=endurl1+"?"+pa1+"="+p1+"&"+pa2+"="+p2+"&"+pa3+"="+p3+"&"+pa4+"="+p4+"&"+pa5+"="+p5+"&"+pa6+"="+p6;}
	        		 
	        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5)){
		        		 eurl=endurl1+"?"+pa1+"="+p1+"&"+pa2+"="+p2+"&"+pa3+"="+p3+"&"+pa4+"="+p4+"&"+pa5+"="+p5;}
	        		 
	        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4)){
		        		 eurl=endurl1+"?"+pa1+"="+p1+"&"+pa2+"="+p2+"&"+pa3+"="+p3+"&"+pa4+"="+p4;}
	        		 
	        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3)){
		        		 eurl=endurl1+"?"+pa1+"="+p1+"&"+pa2+"="+p2+"&"+pa3+"="+p3;}
	        		 
	        		 else if(!"null".equals(pa1) && !"null".equals(pa2)){
		        		 eurl=endurl1+"?"+pa1+"="+p1+"&"+pa2+"="+p2;}
	             
	        		 else if("".equals(pa1) && !"null".equals(p1))
	                     eurl=endurl1+"/"+p1;
	             
	        		 else if(!"null".equals(pa1) && !"".equals(pa1)){
		        		 eurl=endurl1+"?"+pa1+"="+p1;}
	             
	        		 else if("null".equals(pa1))
	        			 eurl=endurl1;
	             eurl=eurl.replaceAll(" ", "%20"); 
	             
	                if(resf1.equals("XML")){
      	        	  doc=builder.parse(new URL(eurl).openStream());

                    }
	        		 
	        		 
	        		 else if(resf1.equals("JSON")){
		        			        		 
		        		 URL eurl1=new URL(eurl);
		        		 URLConnection uconn = eurl1.openConnection();
		        	     HttpURLConnection conn = (HttpURLConnection) uconn;
		        	     conn.connect();
		        	     Object content = conn.getContent();
		        	     InputStream stream = (InputStream) content;
		        	     BufferedReader br=new BufferedReader(new InputStreamReader(stream));
		        	     String strcon=null;
		        	     StringBuilder strb=new StringBuilder();
		        	     while ((line = br.readLine()) != null)    { 
	        	    	      strb.append(line);
	   	    		     }//while
	        	    	 strcon=strb.toString();
	        	    	 XMLSerializer serializer = new XMLSerializer();
	     	            JSON json = JSONSerializer.toJSON(strcon);
	     	            serializer.setRootName("root");
	     	            serializer.setTypeHintsEnabled(false);
	     	            str = serializer.write(json);

			               doc= builder.parse(new InputSource(new ByteArrayInputStream(str.getBytes("UTF-8"))));

	        		 }// else-if json
	                
 else if(rf1.equals("REST") && rm1.equals ("GET") && resf1.equals("XML-RPC"))
		        	     
	        	     {

		        	 		XmlRpcClient client1 = new XmlRpcClient( endurl1, false );

	        			HashMap mergeVars = new HashMap();
		        		 if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5) && !"null".equals(pa6) && !"null".equals(pa7) && !"null".equals(pa8) && !"null".equals(pa9) && !"null".equals(pa10)){
		        			 mergeVars.put(pa1,pva1);mergeVars.put(pa2,pva2);mergeVars.put(pa3,pva3);mergeVars.put(pa4,pva4);mergeVars.put(pa5,pva5);mergeVars.put(pa6,pva6);mergeVars.put(pa7,pva7);mergeVars.put(pa8,pva8);mergeVars.put(pa9,pva9);mergeVars.put(pa10,pva10);
		        		 }
		        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5) && !"null".equals(pa6) && !"null".equals(pa7) && !"null".equals(pa8) && !"null".equals(pa9)){
		        			 mergeVars.put(pa1,pva1);mergeVars.put(pa2,pva2);mergeVars.put(pa3,pva3);mergeVars.put(pa4,pva4);mergeVars.put(pa5,pva5);mergeVars.put(pa6,pva6);mergeVars.put(pa7,pva7);mergeVars.put(pa8,pva8);mergeVars.put(pa9,pva9);}
		        		 
		        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5) && !"null".equals(pa6) && !"null".equals(pa7) && !"null".equals(pa8)){
		        			 mergeVars.put(pa1,pva1);mergeVars.put(pa2,pva2);mergeVars.put(pa3,pva3);mergeVars.put(pa4,pva4);mergeVars.put(pa5,pva5);mergeVars.put(pa6,pva6);mergeVars.put(pa7,pva7);mergeVars.put(pa8,pva8);}
		        		 
		        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5) && !"null".equals(pa6) && !"null".equals(pa7)){
		        			 mergeVars.put(pa1,pva1);mergeVars.put(pa2,pva2);mergeVars.put(pa3,pva3);mergeVars.put(pa4,pva4);mergeVars.put(pa5,pva5);mergeVars.put(pa6,pva6);mergeVars.put(pa7,pva7);}
	        			
		        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5) && !"null".equals(pa6)){
		        			 mergeVars.put(pa1,pva1);mergeVars.put(pa2,pva2);mergeVars.put(pa3,pva3);mergeVars.put(pa4,pva4);mergeVars.put(pa5,pva5);mergeVars.put(pa6,pva6);}
		        		 
		        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5)){
			        		 mergeVars.put(pa1,pva1);mergeVars.put(pa2,pva2);mergeVars.put(pa3,pva3);mergeVars.put(pa4,pva4);mergeVars.put(pa5,pva5);}
		        		 
		        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4)){
		        			 mergeVars.put(pa1,pva1);mergeVars.put(pa2,pva2);mergeVars.put(pa3,pva3);mergeVars.put(pa4,pva4);}
		        		 
		        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3)){
		        			 mergeVars.put(pa1,pva1);mergeVars.put(pa2,pva2);mergeVars.put(pa3,pva3);}
		        		 
		        		 else if(!"null".equals(pa1) && !"null".equals(pa2)){
		        			 mergeVars.put(pa1,pva1);mergeVars.put(pa2,pva2);}
	        		 
		        		 else if(!"null".equals(pa1)){
		        			 mergeVars.put(pa1,pva1);}
		        			 
		        			 else if("null".equals(pa1)){mergeVars.put(ak1, ak2);}
	        				        	 
		        		 Object token = null;
		        			try {
		        				token = client1.invoke( mname,new Object[] {
		        						mergeVars
		        				});
		        			} catch (XmlRpcException e) {
		        				// TODO Auto-generated catch block
		        				e.printStackTrace();
		        			} catch (XmlRpcFault e) {
		        				// TODO Auto-generated catch block
		        				e.printStackTrace();
		        			}
			        		   String program=null;

		        		   Writer writer =new OutputStreamWriter(response.getOutputStream());
		        		   XmlRpcSerializer.serialize( token, writer );
		        		   writer.flush();

		        	 
				    //    doc= builder.parse(new InputSource(new ByteArrayInputStream(str.getBytes("UTF-8"))));
     
	        		 
	     		        
	        	 } //XML RPC        	 

	             
	               	  }} // No auth and GET
	         
	        	 	         
	         
	         
	         
	         else if(authen1.equals("API keys")){  //API Keys
	        	 
	        	 if(rf1.equals("REST") && rm1.equals ("GET") && resf1.equals("XML") || resf1.equals("JSON")){  //API XML get       		 

	        		 if(p1!=null && p2!=null && p3!=null && p4!=null && p5!=null && p6!=null && p7!=null && p8!=null && p9!=null && p10!=null){
	        		 eurl=endurl1+"?"+ak1+"="+ak2+"&"+pa1+"="+p1+"&"+pa2+"="+p2+"&"+pa3+"="+p3+"&"+pa4+"="+p4+"&"+pa5+"="+p5+"&"+pa6+"="+p6+"&"+pa7+"="+p7+"&"+pa8+"="+p8+"&"+pa9+"="+p9+"&"+pa10+"="+p10;}
	        		 
	        		 else if(p1!=null && p2!=null && p3!=null && p4!=null && p5!=null && p6!=null && p7!=null && p8!=null && p9!=null){
		        		 eurl=endurl1+"?"+ak1+"="+ak2+"&"+pa1+"="+p1+"&"+pa2+"="+p2+"&"+pa3+"="+p3+"&"+pa4+"="+p4+"&"+pa5+"="+p5+"&"+pa6+"="+p6+"&"+pa7+"="+p7+"&"+pa8+"="+p8+"&"+pa9+"="+p9;}
	        		 
	        		 else if(p1!=null && p2!=null && p3!=null && p4!=null && p5!=null && p6!=null && p7!=null && p8!=null){
		        		 eurl=endurl1+"?"+ak1+"="+ak2+"&"+pa1+"="+p1+"&"+pa2+"="+p2+"&"+pa3+"="+p3+"&"+pa4+"="+p4+"&"+pa5+"="+p5+"&"+pa6+"="+p6+"&"+pa7+"="+p7+"&"+pa8+"="+p8;}
	        		 
	        		 else if(p1!=null && p2!=null && p3!=null && p4!=null && p5!=null && p6!=null && p7!=null){
		        		 eurl=endurl1+"?"+ak1+"="+ak2+"&"+pa1+"="+p1+"&"+pa2+"="+p2+"&"+pa3+"="+p3+"&"+pa4+"="+p4+"&"+pa5+"="+p5+"&"+pa6+"="+p6+"&"+pa7+"="+p7;}
	        		 
	        		 else if(p1!=null && p2!=null && p3!=null && p4!=null && p5!=null && p6!=null){
		        		 eurl=endurl1+"?"+ak1+"="+ak2+"&"+pa1+"="+p1+"&"+pa2+"="+p2+"&"+pa3+"="+p3+"&"+pa4+"="+p4+"&"+pa5+"="+p5+"&"+pa6+"="+p6;}
	        		 
	        		 else if(p1!=null && p2!=null && p3!=null && p4!=null && p5!=null){
		        		 eurl=endurl1+"?"+ak1+"="+ak2+"&"+pa1+"="+p1+"&"+pa2+"="+p2+"&"+pa3+"="+p3+"&"+pa4+"="+p4+"&"+pa5+"="+p5;}
	        		 
	        		 else if(p1!=null && p2!=null && p3!=null && p4!=null){
		        		 eurl=endurl1+"?"+ak1+"="+ak2+"&"+pa1+"="+p1+"&"+pa2+"="+p2+"&"+pa3+"="+p3+"&"+pa4+"="+p4;}
	        		 
	        		 else if(p1!=null && p2!=null && p3!=null){
		        		 eurl=endurl1+"?"+ak1+"="+ak2+"&"+pa1+"="+p1+"&"+pa2+"="+p2+"&"+pa3+"="+p3;}
	        		 
	        		 else if(p1!=null && p2!=null){
		        		 eurl=endurl1+"?"+ak1+"="+ak2+"&"+pa1+"="+p1+"&"+pa2+"="+p2;}
	        		 
	        		 else if(p1!=null){
		        		 eurl=endurl1+"?"+ak1+"="+ak2+"&"+pa1+"="+p1;}
	        		 else if(p1==null){
	        			eurl=endurl1+"?"+ak1+"="+ak2;}
	        	 
	        		 eurl=eurl.replaceAll(" ","%20");
                     if(resf1.equals("XML")){
       	        	  doc=builder.parse(new URL(eurl).openStream());

                     }
	        		 
	        		 
	        		 else if(resf1.equals("JSON")){
	        			 line=null;String strcon=null;
		        	     StringBuilder strb=new StringBuilder();
		        		 URL eurl1=new URL(eurl);
		        		 URLConnection uconn = eurl1.openConnection();
		        	     HttpURLConnection conn = (HttpURLConnection) uconn;
		        	     conn.connect();
		        	     Object content = conn.getContent();
		        	     InputStream stream = (InputStream) content;
		        	     BufferedReader br=new BufferedReader(new InputStreamReader(stream));
		        	     while ((line = br.readLine()) != null)    { 
	        	    	      strb.append(line);
	   	    		     }//while
	        	    	 strcon=strb.toString();
	        	    	 XMLSerializer serializer = new XMLSerializer();
	     	            JSON json = JSONSerializer.toJSON(strcon);
	     	            serializer.setRootName("root");
	     	            serializer.setTypeHintsEnabled(false);
	     	            str = serializer.write(json);

		        	           // end-while  	
			               doc= builder.parse(new InputSource(new ByteArrayInputStream(str.getBytes("UTF-8"))));

	        	 }  //JSON
                     
	        		 else if(rf1.equals("REST") && rm1.equals ("GET") && resf1.equals("XML-RPC"))
		        	     
	        	     {

		        	 		XmlRpcClient client1 = new XmlRpcClient( endurl1, false );

	        			HashMap mergeVars = new HashMap();
		        		 if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5) && !"null".equals(pa6) && !"null".equals(pa7) && !"null".equals(pa8) && !"null".equals(pa9) && !"null".equals(pa10)){
		        			 mergeVars.put(ak1, ak2);mergeVars.put(pa1,pva1);mergeVars.put(pa2,pva2);mergeVars.put(pa3,pva3);mergeVars.put(pa4,pva4);mergeVars.put(pa5,pva5);mergeVars.put(pa6,pva6);mergeVars.put(pa7,pva7);mergeVars.put(pa8,pva8);mergeVars.put(pa9,pva9);mergeVars.put(pa10,pva10);
		        		 }
		        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5) && !"null".equals(pa6) && !"null".equals(pa7) && !"null".equals(pa8) && !"null".equals(pa9)){
		        			 mergeVars.put(ak1, ak2);mergeVars.put(pa1,pva1);mergeVars.put(pa2,pva2);mergeVars.put(pa3,pva3);mergeVars.put(pa4,pva4);mergeVars.put(pa5,pva5);mergeVars.put(pa6,pva6);mergeVars.put(pa7,pva7);mergeVars.put(pa8,pva8);mergeVars.put(pa9,pva9);}
		        		 
		        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5) && !"null".equals(pa6) && !"null".equals(pa7) && !"null".equals(pa8)){
		        			 mergeVars.put(ak1, ak2);mergeVars.put(pa1,pva1);mergeVars.put(pa2,pva2);mergeVars.put(pa3,pva3);mergeVars.put(pa4,pva4);mergeVars.put(pa5,pva5);mergeVars.put(pa6,pva6);mergeVars.put(pa7,pva7);mergeVars.put(pa8,pva8);}
		        		 
		        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5) && !"null".equals(pa6) && !"null".equals(pa7)){
		        			 mergeVars.put(ak1, ak2);mergeVars.put(pa1,pva1);mergeVars.put(pa2,pva2);mergeVars.put(pa3,pva3);mergeVars.put(pa4,pva4);mergeVars.put(pa5,pva5);mergeVars.put(pa6,pva6);mergeVars.put(pa7,pva7);}
	        			
		        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5) && !"null".equals(pa6)){
		        			 mergeVars.put(ak1, ak2);mergeVars.put(pa1,pva1);mergeVars.put(pa2,pva2);mergeVars.put(pa3,pva3);mergeVars.put(pa4,pva4);mergeVars.put(pa5,pva5);mergeVars.put(pa6,pva6);}
		        		 
		        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5)){
			        			 mergeVars.put(ak1, ak2);mergeVars.put(pa1,pva1);mergeVars.put(pa2,pva2);mergeVars.put(pa3,pva3);mergeVars.put(pa4,pva4);mergeVars.put(pa5,pva5);}
		        		 
		        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4)){
		        			 mergeVars.put(ak1, ak2);mergeVars.put(pa1,pva1);mergeVars.put(pa2,pva2);mergeVars.put(pa3,pva3);mergeVars.put(pa4,pva4);}
		        		 
		        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3)){
		        			 mergeVars.put(ak1, ak2);mergeVars.put(pa1,pva1);mergeVars.put(pa2,pva2);mergeVars.put(pa3,pva3);}
		        		 
		        		 else if(!"null".equals(pa1) && !"null".equals(pa2)){
		        			 mergeVars.put(ak1, ak2);mergeVars.put(pa1,pva1);mergeVars.put(pa2,pva2);}
	        		 
		        		 else if(!"null".equals(pa1)){
		        			 mergeVars.put(ak1, ak2);mergeVars.put(pa1,pva1);}
		        			 
		        			 else if("null".equals(pa1)){mergeVars.put(ak1, ak2);}
	        				        	 
		        		 Object token = null;
		        			try {
		        				token = client1.invoke( mname,new Object[] {
		        						mergeVars
		        				});
		        			} catch (XmlRpcException e) {
		        				// TODO Auto-generated catch block
		        				e.printStackTrace();
		        			} catch (XmlRpcFault e) {
		        				// TODO Auto-generated catch block
		        				e.printStackTrace();
		        			}
			        		   String program=null;

		        		   Writer writer =new OutputStreamWriter(response.getOutputStream());
		        		   XmlRpcSerializer.serialize( token, writer );
		        		   writer.flush();

		        	 
				    //    doc= builder.parse(new InputSource(new ByteArrayInputStream(str.getBytes("UTF-8"))));
            		 
	     		        
	        	 } //XML RPC        	 

	        	     
	        	 } //get
	        	 else if(rf1.equals("REST") && rm1.equals ("POST")){
	        		 String USER_AGENT = "Mozilla/5.0";
		        	 String url=endurl1;
		        		 try
		        		 {
		        			 HttpClient client1 = new DefaultHttpClient();
		        				HttpPost post = new HttpPost(url);
		        				post.setHeader("User-Agent", USER_AGENT);
		        				List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		        				urlParameters.add(new BasicNameValuePair(ak1, ak2));
		        				urlParameters.add(new BasicNameValuePair(pa1, pva1));
		        				urlParameters.add(new BasicNameValuePair(pa2, pva2));
		        				urlParameters.add(new BasicNameValuePair(pa3, pva3));
		        				urlParameters.add(new BasicNameValuePair(pa4, pva4));
		        				urlParameters.add(new BasicNameValuePair(pa5, pva5));
		        				urlParameters.add(new BasicNameValuePair(pa6, pva6));
		        				urlParameters.add(new BasicNameValuePair(pa7, pva7));
		        				urlParameters.add(new BasicNameValuePair(pa8, pva8));
		        				urlParameters.add(new BasicNameValuePair(pa9, pva9));
		        				urlParameters.add(new BasicNameValuePair(pa10, pva10));
		        				post.setEntity(new UrlEncodedFormEntity(urlParameters));
		        				HttpResponse response1 = client.execute(post);
		        				BufferedReader br = new BufferedReader(
		                                new InputStreamReader(response1.getEntity().getContent()));
		         
		        		StringBuffer result = new StringBuffer();
		        	     if(resf1.equals("XML")){
		        	     while((line=br.readLine())!=null){
		         	 	  	       		     str+=line;
		        	     }
				          doc= builder.parse(new InputSource(new ByteArrayInputStream(str.getBytes("UTF-8"))));
		        		 }
		        		 else if(resf1.equals("JSON")){
		        			 String strcon=null;
			        	     StringBuilder strb=new StringBuilder();
			        	     while ((line = br.readLine()) != null)    { 
		        	    	      strb.append(line);
		   	    		     }//while
		        	    	 strcon=strb.toString();
		        	    	 XMLSerializer serializer = new XMLSerializer();
		     	            JSON json = JSONSerializer.toJSON(strcon);
		     	            serializer.setRootName("root");
		     	            serializer.setTypeHintsEnabled(false);
		     	            str = serializer.write(json);
				               doc= builder.parse(new InputSource(new ByteArrayInputStream(str.getBytes("UTF-8"))));

		        		 } //if
		        		 }//try
		         	     catch(Exception e){
		 	    	     // out.println(e);}	
		         	 	// out.println(str); 	       		     

	        	 }//post 
	        	 
	        		 
	        		 
	        		 
	        	 
	         } // Main END of API Keys
       
	         }
       //Basic Authentication////
       
	         else if(authen1.equals("Signed Auth")){  //API Keys
	        	 if(rf1.equals("REST") && rm1.equals ("GET") && resf1.equals("XML") || resf1.equals("JSON")){  //API XML get
	        		 
	        		 if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5) && !"null".equals(pa6) && !"null".equals(pa7) && !"null".equals(pa8) && !"null".equals(pa9) && !"null".equals(pa10)){
		        		 eurl=pa1+"="+p1+"&"+pa2+"="+p2+"&"+pa3+"="+p3+"&"+pa4+"="+p4+"&"+pa5+"="+p5+"&"+pa6+"="+p6+"&"+pa7+"="+p7+"&"+pa8+"="+p8+"&"+pa9+"="+p9+"&"+pa10+"="+p10;}
	        		 
	        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5) && !"null".equals(pa6) && !"null".equals(pa7) && !"null".equals(pa8) && !"null".equals(pa9)){
		        		 eurl=pa1+"="+p1+"&"+pa2+"="+p2+"&"+pa3+"="+p3+"&"+pa4+"="+p4+"&"+pa5+"="+p5+"&"+pa6+"="+p6+"&"+pa7+"="+p7+"&"+pa8+"="+p8+"&"+pa9+"="+p9;}
	        		 
	        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5) && !"null".equals(pa6) && !"null".equals(pa7) && !"null".equals(pa8)){
		        		 eurl=pa1+"="+p1+"&"+pa2+"="+p2+"&"+pa3+"="+p3+"&"+pa4+"="+p4+"&"+pa5+"="+p5+"&"+pa6+"="+p6+"&"+pa7+"="+p7+"&"+pa8+"="+p8;}
	        		 
	        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5) && !"null".equals(pa6) && !"null".equals(pa7)){
		        		 eurl=pa1+"="+p1+"&"+pa2+"="+p2+"&"+pa3+"="+p3+"&"+pa4+"="+p4+"&"+pa5+"="+p5+"&"+pa6+"="+p6+"&"+pa7+"="+p7;}
	        		 
	        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5) && !"null".equals(pa6)){
	        		 eurl=pa1+"="+p1+"&"+pa2+"="+p2+"&"+pa3+"="+p3+"&"+pa4+"="+p4+"&"+pa5+"="+p5+"&"+pa6+"="+p6;}
	        		 
	        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5)){
		        		 eurl=pa1+"="+p1+"&"+pa2+"="+p2+"&"+pa3+"="+p3+"&"+pa4+"="+p4+"&"+pa5+"="+p5;}
	        		 
	        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4)){
		        		 eurl=pa1+"="+p1+"&"+pa2+"="+p2+"&"+pa3+"="+p3+"&"+pa4+"="+p4;}
	        		 
	        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3)){
		        		 eurl=pa1+"="+p1+"&"+pa2+"="+p2+"&"+pa3+"="+p3;}
	        		 
	        		 else if(!"null".equals(pa1) && !"null".equals(pa2)){
		        		 eurl=pa1+"="+p1+"&"+pa2+"="+p2;}
	        		 
	        		 else if(!"null".equals(pa1)){
		        		 eurl=pa1+"="+p1;}        		
	        		 
	        			eurl=eurl.replaceAll(" ", "%20"); 
	        			 SignedRequestsHelper helper;
	        		        try {
	        		            helper = SignedRequestsHelper.getInstance(endurl1, sigckey, sigskey);
	        		        } catch (Exception e) {
	        		            e.printStackTrace();
	        		            return;
	        		        }
	        		 String sigurl= helper.sign(eurl);
	        		 URL eurl1=new URL(sigurl);
	        		 URLConnection uconn = eurl1.openConnection();
	        	     HttpURLConnection conn = (HttpURLConnection) uconn;
	        	     conn.connect();
	        	     Object content = conn.getContent();
	        	     InputStream stream = (InputStream) content;
	        	      line=null; String strcon=null;
	        	     BufferedReader br=new BufferedReader(new InputStreamReader(stream));
	        	     StringBuilder strb=new StringBuilder();
	        	    if(resf1.equals("XML")){
	        	     while((line=br.readLine())!=null){
    	  	       	 str+=line;
    	  	       	 }
	        	     }
	        	     else if(resf1.equals("JSON")){
	        	    	 while ((line = br.readLine()) != null)    { 
	        	    	      strb.append(line);
	   	    		     }//while
	        	    	 strcon=strb.toString();
	        	    	 XMLSerializer serializer = new XMLSerializer();
	     	            JSON json = JSONSerializer.toJSON(strcon);
	     	            serializer.setRootName("root");
	     	            serializer.setTypeHintsEnabled(false);
	     	            str = serializer.write(json);
	        	    	 
	        	     } // else if
	        	   // out.println(str);
	        	    doc= builder.parse(new InputSource(new ByteArrayInputStream(str.getBytes("UTF-8"))));	
	        	     
	        	 }}
       
       
	        	  if(authen1.equals("Basic Auth")){ //m15
		        	 if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5) && !"null".equals(pa6) && !"null".equals(pa7) && !"null".equals(pa8) && !"null".equals(pa9) && !"null".equals(pa10)){
		        		 eurl=pa1+"="+pva1+"&"+pa2+"="+pva2+"&"+pa3+"="+pva3+"&"+pa4+"="+pva4+"&"+pa5+"="+pva5+"&"+pa6+"="+pva6+"&"+pa7+"="+pva7+"&"+pa8+"="+pva8+"&"+pa9+"="+pva9+"&"+pa10+"="+pva10;}
	        		 
	        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5) && !"null".equals(pa6) && !"null".equals(pa7) && !"null".equals(pa8) && !"null".equals(pa9)){
		        		 eurl=pa1+"="+pva1+"&"+pa2+"="+pva2+"&"+pa3+"="+pva3+"&"+pa4+"="+pva4+"&"+pa5+"="+pva5+"&"+pa6+"="+pva6+"&"+pa7+"="+pva7+"&"+pa8+"="+pva8+"&"+pa9+"="+pva9;}
	        		 
	        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5) && !"null".equals(pa6) && !"null".equals(pa7) && !"null".equals(pa8)){
		        		 eurl=pa1+"="+pva1+"&"+pa2+"="+pva2+"&"+pa3+"="+pva3+"&"+pa4+"="+pva4+"&"+pa5+"="+pva5+"&"+pa6+"="+pva6+"&"+pa7+"="+pva7+"&"+pa8+"="+pva8;}
	        		 
	        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5) && !"null".equals(pa6) && !"null".equals(pa7)){
		        		 eurl=pa1+"="+pva1+"&"+pa2+"="+pva2+"&"+pa3+"="+pva3+"&"+pa4+"="+pva4+"&"+pa5+"="+pva5+"&"+pa6+"="+pva6+"&"+pa7+"="+pva7;}
	        		 
	        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5) && !"null".equals(pa6)){
	        		 eurl=pa1+"="+pva1+"&"+pa2+"="+pva2+"&"+pa3+"="+pva3+"&"+pa4+"="+pva4+"&"+pa5+"="+pva5+"&"+pa6+"="+pva6;}
	        		 
	        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5)){
		        		 eurl=pa1+"="+pva1+"&"+pa2+"="+pva2+"&"+pa3+"="+pva3+"&"+pa4+"="+pva4+"&"+pa5+"="+pva5;}
	        		 
	        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4)){
		        		 eurl=pa1+"="+pva1+"&"+pa2+"="+pva2+"&"+pa3+"="+pva3+"&"+pa4+"="+pva4;}
	        		 
	        		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3)){
		        		 eurl=pa1+"="+pva1+"&"+pa2+"="+pva2+"&"+pa3+"="+pva3;}
	        		 
	        		 else if(!"null".equals(pa1) && !"null".equals(pa2)){
		        		 eurl=pa1+"="+pva1+"&"+pa2+"="+pva2;}
	        		 
	        		 else if(!"null".equals(pa1)){
		        		 eurl=pa1+"="+pva1;}
	        		 else if("null".equals(pa1))
	        			eurl="filter=''";
		        	 
		        	 
		        	 str="";
		        	 try{
			          if(rm1.equals("GET")){ 
			        		URL url1;

			              if(!"".equals(eurl))
		    	               url1 = new URL (endurl1+"?"+eurl);
			              else
			                   url1 =new URL(endurl1);
		              HttpURLConnection connection = (HttpURLConnection) url1.openConnection();
	                  connection.setDoOutput(true);
	                  connection.setDoInput(true);
		              connection.setRequestMethod("GET");
		              String encoding=null;
		            	 if(!"null".equals(b2)&& "null".equals(b4)){
		            		 encoding = new String(
		                    		 org.apache.commons.codec.binary.Base64.encodeBase64   
		                    		    (org.apache.commons.codec.binary.StringUtils.getBytesUtf8(b2+":"+""))
		                    		  );
		   	              connection.setRequestProperty  ("Authorization", "Basic " + encoding);

		            	 }
		            	 else if(!"null".equals(b4) && "null".equals(b2)){encoding = new String(
	        		 org.apache.commons.codec.binary.Base64.encodeBase64   
	     		    (org.apache.commons.codec.binary.StringUtils.getBytesUtf8(""+":"+b4))
	     		  );	              
		            	 connection.setRequestProperty  ("Authorization", "Basic " + encoding);
	}
		            	 else if(!"null".equals(b2) && !"null".equals(b4)){
		            		 encoding = new String(
		                    		 org.apache.commons.codec.binary.Base64.encodeBase64   
		                    		    (org.apache.commons.codec.binary.StringUtils.getBytesUtf8(b2+":"+b4))
		                    		  );
		   	              connection.setRequestProperty  ("Authorization", "Basic " + encoding);

		   	            	 } // else if encoding
		            	 else if("null".equals(b2) && "null".equals(b4)){
		            		 encoding=null;
		            	 }
		            	 
		              if(!"".equals(h1) && !"".equals(h2) && !"".equals(h3) && !"".equals(h4) && !"".equals(h5)){
		            	connection.setRequestProperty(h1, hv1);connection.setRequestProperty(h2, hv2); connection.setRequestProperty(h3, hv3);connection.setRequestProperty(h4, hv4);connection.setRequestProperty(h5, hv5);  
		              }
		              else if(!"".equals(h1) && !"".equals(h2) && !"".equals(h3) && !"".equals(h4)){
		            	connection.setRequestProperty(h1, hv1);connection.setRequestProperty(h2, hv2); connection.setRequestProperty(h3, hv3);connection.setRequestProperty(h4, hv4);  
		              }
		              else if(!"".equals(h1) && !"".equals(h2) && !"".equals(h3)){
			            	connection.setRequestProperty(h1, hv1);connection.setRequestProperty(h2, hv2); connection.setRequestProperty(h3, hv3);  
			              }
		              else if(!"".equals(h1) && !"".equals(h2)){
			            	connection.setRequestProperty(h1, hv1);connection.setRequestProperty(h2, hv2);  
			              }
		              else if(!"".equals(h1)){
			            	connection.setRequestProperty(h1, hv1);  
			              }
		               line=null;
		              InputStream content = (InputStream)connection.getInputStream();
		                 BufferedReader in   = new BufferedReader (new InputStreamReader (content));
		              if(resf1.equals("XML")){
		                    while((line=in.readLine())!=null){
		                    	str+=line;
		                    }} // while and xml
		              else if(resf1.equals("JSON")){
		            	  while((line=in.readLine())!=null){
		            		  JSON json = JSONSerializer.toJSON( line .replaceAll("\\s+","")  );  
			     	          XMLSerializer xmlSerializer = new XMLSerializer();  
			     	          xmlSerializer.setTypeHintsEnabled(false);
			     	          xmlSerializer.setSkipWhitespace(true);
			     	          xmlSerializer.setTrimSpaces(true);
			     	          xmlSerializer.setRemoveNamespacePrefixFromElements(true);
			     	          xmlSerializer.removeNamespace(line);
			     	          xmlSerializer.setForceTopLevelObject(false);
			     		      str = xmlSerializer.write( json );
		            	  }//while}
		              }//json
		              doc= builder.parse(new InputSource(new ByteArrayInputStream(str.getBytes("UTF-8"))));	
			          }//get
		              else if(rm1.equals("POST")){ 
		            	  URL url1 = new URL (endurl1);
		            	  HttpURLConnection connection = (HttpURLConnection) url1.openConnection();
		            	  connection.setDoInput(true);   
		            	  connection.setDoOutput(true);  
		            	  connection.setUseCaches(false);  
			              connection.setRequestMethod("POST");
		            	  connection.connect();  
		                  DataOutputStream wr = new DataOutputStream(connection.getOutputStream ());
			              wr.writeBytes(eurl);
			              wr.flush();
			              wr.close();
		              String encoding=null;
		            	 if(!"null".equals(b2)&& "null".equals(b4)){
		            		 encoding = new String(
		                    		 org.apache.commons.codec.binary.Base64.encodeBase64   
		                    		    (org.apache.commons.codec.binary.StringUtils.getBytesUtf8(b2+":"+""))
		                    		  );
		   	              connection.setRequestProperty  ("Authorization", "Basic " + encoding);

		            	 }
		            	 else if(!"null".equals(b4) && "null".equals(b2)){encoding = new String(
	           		 org.apache.commons.codec.binary.Base64.encodeBase64   
	        		    (org.apache.commons.codec.binary.StringUtils.getBytesUtf8(""+":"+b4))
	        		    
	        		  );	              connection.setRequestProperty  ("Authorization", "Basic " + encoding);
	}
		            	 else if(!"null".equals(b2) && !"null".equals(b4)){
		            		 encoding = new String(
		                    		 org.apache.commons.codec.binary.Base64.encodeBase64   
		                    		    (org.apache.commons.codec.binary.StringUtils.getBytesUtf8(b2+":"+b4))
		                    		  );
		   	              connection.setRequestProperty  ("Authorization", "Basic " + encoding);

		   	            	 } 
		            	 
		            	 else if("null".equals(b2) && "null".equals(b4)){encoding=null;}
		            	
		            	 
		              if(!"".equals(h1) && !"".equals(h2) && !"".equals(h3) && !"".equals(h4) && !"".equals(h5)){
			            	connection.setRequestProperty(h1, hv1);connection.setRequestProperty(h2, hv2); connection.setRequestProperty(h3, hv3);connection.setRequestProperty(h4, hv4);connection.setRequestProperty(h5, hv5);  
			              }
			              else if(!"".equals(h1) && !"".equals(h2) && !"".equals(h3) && !"".equals(h4)){
			            	connection.setRequestProperty(h1, hv1);connection.setRequestProperty(h2, hv2); connection.setRequestProperty(h3, hv3);connection.setRequestProperty(h4, hv4);  
			              }
			              else if(!"".equals(h1) && !"".equals(h2) && !"".equals(h3)){
				            	connection.setRequestProperty(h1, hv1);connection.setRequestProperty(h2, hv2); connection.setRequestProperty(h3, hv3);  
				              }
			              else if(!"".equals(h1) && !"".equals(h2)){
				            	connection.setRequestProperty(h1, hv1);connection.setRequestProperty(h2, hv2);  
				              }
			              else if(!"".equals(h1)){
				            	connection.setRequestProperty(h1, hv1);  
				              }
		              InputStream content = (InputStream)connection.getInputStream();
		              BufferedReader in   = new BufferedReader (new InputStreamReader (content));
	                  
	                  line=null;
		              if(resf1.equals("XML")){
		                    while((line=in.readLine())!=null){
		                    	str+=line;
		                    }} // while and xml
		              else if(resf1.equals("JSON")){
		            	  while((line=in.readLine())!=null){
		            		  JSON json = JSONSerializer.toJSON( line );  
			     	          XMLSerializer xmlSerializer = new XMLSerializer();  
			     	          xmlSerializer.setTypeHintsEnabled(false);
			     	          xmlSerializer.setSkipWhitespace(true);
			     	          xmlSerializer.setTrimSpaces(true);
			     	          xmlSerializer.setRemoveNamespacePrefixFromElements(true);
			     	          xmlSerializer.removeNamespace(line);
			     	          xmlSerializer.setForceTopLevelObject(false);
			     		      str = xmlSerializer.write( json );
		            	  } //out.println(xmlout);
		            	  }//while
		              doc= builder.parse(new InputSource(new ByteArrayInputStream(str.getBytes("UTF-8"))));
		              }//post
		           
		                            
		                	
		             
		             }//try
		              
		   	             catch(Exception e){
		   	            	// out.println("hhhhhhhhhhhh"+e);
		   	            	 }
		   	          
	        	 
		        	 
		         }// Basic Auth
       
       
       
       
	         else if(authen1.equals("Oauth2")){  //OAUTH authentication
	     		
		     		

	     		if(rm1.equals("GET")){ 
		     		if("Authorization:Bearer".equals(treplace)){

	     			HttpGet get=new HttpGet(endurl1);
				       get.addHeader("Authorization", "Bearer "+access_token);
			     		HttpResponse response1 = client.execute(get);
			     		BufferedReader rd = new BufferedReader(
			     				new InputStreamReader(response1.getEntity().getContent()));
			     			while ((line = rd.readLine()) != null) {
	                         GetResponse=line;		     			}
			     	}
			     	else if("QueryString".equals(treplace)){
			     		
			     		String param = null;
				     	   // List<NameValuePair> params = new LinkedList<NameValuePair>();

				     		 if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5) && !"null".equals(pa6))
				     			 param=tlabel+"="+access_token+"&"+pa1+"="+p1+"&"+pa2+"="+p2+"&"+pa3+"="+p3+"&"+pa4+"="+p4+"&"+pa5+"="+p5+"&"+p6+"="+p6;
				        		 
				             else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5))
		                         param=tlabel+"="+access_token+"&"+pa1+"="+p1+"&"+pa2+"="+p2+"&"+pa3+"="+p3+"&"+pa4+"="+p4+"&"+pa5+"="+p5;

				     	
				              else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4))
			                         param=tlabel+"="+access_token+"&"+pa1+"="+p1+"&"+pa2+"="+p2+"&"+pa3+"="+p3+"&"+pa4+"="+p4;

				              else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3))
			                         param=tlabel+"="+access_token+"&"+pa1+"="+p1+"&"+pa2+"="+p2+"&"+pa3+"="+p3;

				        	  else if(!"null".equals(pa1) && !"null".equals(pa2))
			                         param=tlabel+"="+access_token+"&"+pa1+"="+p1+"&"+pa2+"="+p2;

				              else if(!"null".equals(pa1))
			                         param=tlabel+"="+access_token+"&"+pa1+"="+p1;

				        	  else if("null".equals(pa1))
			                         param=tlabel+"="+access_token;
				     		 String pointurl=endurl1+"?"+param;
				     	    //String paramString = URLEncodedUtils.format(param, "utf-8");
						     	HttpGet get=new HttpGet(pointurl);
					            HttpResponse response1=client.execute(get);
					            BufferedReader rd = new BufferedReader
							    		  (new InputStreamReader(response1.getEntity().getContent()));
							    		    
							    		while ((line = rd.readLine()) != null) {
							    			GetResponse=line;
							    		}
							    			
					} // query string
	     		}//get

			     	

			    	else if(rm1.equals("POST")){
			     		HttpPost post=new HttpPost(endurl1);

			     		
			     		if("Authorization:Bearer".equals(treplace)){
			     			
			     			post.addHeader("Authorization", "Bearer "+access_token);
							HttpResponse response1=client.execute(post);
							BufferedReader rd = new BufferedReader(
				     				new InputStreamReader(response1.getEntity().getContent()));
				     			while ((line = rd.readLine()) != null) {
		                         GetResponse=line;		     			}
							}
			     		
			     		else if("QueryString".equals(treplace)){
				     		
			     			 List <NameValuePair> cod = new ArrayList <NameValuePair>();
				     		 if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5) && !"null".equals(pa6)){
						    	 cod.add(new BasicNameValuePair(tlabel,access_token));
					    	     cod.add(new BasicNameValuePair(pa1,p1));
					    	     cod.add(new BasicNameValuePair(pa2,p2));
					    	     cod.add(new BasicNameValuePair(pa3,p3));
					    	     cod.add(new BasicNameValuePair(pa4,p4));
					    	     cod.add(new BasicNameValuePair(pa5,p5));
					    	     cod.add(new BasicNameValuePair(pa6,p6));}


				     			 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4) && !"null".equals(pa5)){
				     				  cod.add(new BasicNameValuePair(tlabel,access_token));
						    	     cod.add(new BasicNameValuePair(pa1,p1));
						    	     cod.add(new BasicNameValuePair(pa2,p2));
						    	     cod.add(new BasicNameValuePair(pa3,p3));
						    	     cod.add(new BasicNameValuePair(pa4,p4));
						    	     cod.add(new BasicNameValuePair(pa5,p5));	}    
					     		
				     			 
				     			 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3) && !"null".equals(pa4)){cod.add(new BasicNameValuePair(tlabel,access_token));
					    	     cod.add(new BasicNameValuePair(pa1,p1));
					    	     cod.add(new BasicNameValuePair(pa2,p2));
					    	     cod.add(new BasicNameValuePair(pa3,p3));
					    	     cod.add(new BasicNameValuePair(pa4,p4));
					    	     }
						     		
					     		 
					     		 else if(!"null".equals(pa1) && !"null".equals(pa2) && !"null".equals(pa3)){cod.add(new BasicNameValuePair(tlabel,access_token));
						    	     cod.add(new BasicNameValuePair(pa1,p1));
						    	     cod.add(new BasicNameValuePair(pa2,p2));
						    	     cod.add(new BasicNameValuePair(pa3,p3));
						    	     }
							     		
						     		 
						     		 else if(!"null".equals(pa1) && !"null".equals(pa2)){cod.add(new BasicNameValuePair(tlabel,access_token));
							    	     cod.add(new BasicNameValuePair(pa1,p1));
							    	     cod.add(new BasicNameValuePair(pa2,p2));
							    	     }
								     		
							     		 
							     		 else if(!"null".equals(pa1)){
								     			cod.add(new BasicNameValuePair(tlabel,access_token));
									    	    cod.add(new BasicNameValuePair(pa1,p1));
									    	     
								     		 }
							     		 else if("null".equals(pa1)){
								     			cod.add(new BasicNameValuePair(tlabel,access_token));

							     		 }
						        post.setEntity(new UrlEncodedFormEntity(cod));
						        HttpResponse response1 = client.execute(post);
						        BufferedReader rd = new BufferedReader(new InputStreamReader(response1.getEntity().getContent()));
						        while ((line = rd.readLine()) != null) {
				                 GetResponse=line;	        }


			     		}
						   
			     		
	 
			     	}
	     		  

	         }
	        		
       
	       if(resf1.equals("JSON") && authen1.equals("Oauth2")){
	        	  JSON json = JSONSerializer.toJSON( GetResponse );  
	              XMLSerializer xmlSerializer = new XMLSerializer();  
	              xmlSerializer.setTypeHintsEnabled(false);
	              xmlSerializer.setSkipWhitespace(true);
	              xmlSerializer.setTrimSpaces(true);
	              xmlSerializer.setRemoveNamespacePrefixFromElements(true);
	              xmlSerializer.removeNamespace(GetResponse);
	              xmlSerializer.setForceTopLevelObject(false);
	              String xmlout=xmlSerializer.write(json);
	        	  doc=builder.parse(new InputSource(new ByteArrayInputStream(xmlout.getBytes("UTF-8"))));}
	         
	          
	         else if(resf1.equals("XML") && authen1.equals("Oauth2"))
	        	  doc=builder.parse(new InputSource(new ByteArrayInputStream(GetResponse.getBytes("UTF-8"))));

	        
	       
	        
	       
	          
	          
	          Document outdoc=DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
	        		 Element outevent=outdoc.createElement("MPulpy");
	        		 NodeList inevent=null;
	        		 XPath xPath=XPathFactory.newInstance().newXPath();
	        		 inevent=(NodeList) xPath.evaluate("//"+xr,doc,XPathConstants.NODESET); //using XPATH to simply xml from third party server
	                   if(inevent!=null){
	            	  
	              	for(int i=0;i<inevent.getLength();i++){
	              		Element outputEvent=outdoc.createElement("root"); // create mpulpy xml here
	              		Node inputEvent=inevent.item(i);
	              		       
	              	    if(!"null".equals(x1)){   //validation for not return null tag
	              		Element param1=outdoc.createElement(x1);  //create element
	                    if(xv1.equals(""))
	              		param1.setTextContent("null");
	              		else
	              		param1.setTextContent(xPath.evaluate(xv1, inputEvent)); // map our xml with third party server xml
	              		outputEvent.appendChild(param1);}
	              		
	              		if(!"null".equals(x2)){
  	              		Element param2=outdoc.createElement(x2);
	                    if(xv2.equals(""))
	              		param2.setTextContent("null");
	              		else
	              		param2.setTextContent(xPath.evaluate(xv2, inputEvent));
	              		outputEvent.appendChild(param2);}
	              		
	              		if(!"null".equals(x3)){
	              		Element param3=outdoc.createElement(x3);
	                    if(xv3.equals(""))
	              		param3.setTextContent("null");
	              		else
	              		param3.setTextContent(xPath.evaluate(xv3, inputEvent));
	              		outputEvent.appendChild(param3);}
	              		
	              		if(!"null".equals(x4)){
	              		Element param4=outdoc.createElement(x4);
	                    if(xv4.equals(""))
	              		param4.setTextContent("null");
	              		else
	              		param4.setTextContent(xPath.evaluate(xv4, inputEvent));
	              		outputEvent.appendChild(param4);}
	              		
              		    if(!"null".equals(x5)){
		              	Element param5=outdoc.createElement(x5);
	                    if(xv5.equals(""))
	              		param5.setTextContent("null");
	              		else
	              		param5.setTextContent(xPath.evaluate(xv5, inputEvent));
	              		outputEvent.appendChild(param5);}
	              		
	              		if(!"null".equals(x6)){
	              		Element param6=outdoc.createElement(x6);
	                    if(xv6.equals(""))
	              		param6.setTextContent("null");
	              		else
	              		param6.setTextContent(xPath.evaluate(xv6, inputEvent));
	              		outputEvent.appendChild(param6);}
	              		
	              		if(!"null".equals(x7)){
	              		Element param7=outdoc.createElement(x7);
	              		if(xv7.equals(""))
	              		param7.setTextContent("");
	              		else
	              		param7.setTextContent(xPath.evaluate(xv7, inputEvent));
	              		outputEvent.appendChild(param7);}
	              		
	              		if(!"null".equals(x8)){
	              		Element param8=outdoc.createElement(x8);
	              		if(xv8.equals(""))
	              		param8.setTextContent("");
	              		else
	              		param8.setTextContent(xPath.evaluate(xv8, inputEvent));
	              		outputEvent.appendChild(param8);}
	              		
	              		if(!"null".equals(x9)){
	              		Element param9=outdoc.createElement(x9);
	              		if(xv9.equals(""))
	              		param9.setTextContent("");
	              		else
	              		param9.setTextContent(xPath.evaluate(xv9, inputEvent));
	              		outputEvent.appendChild(param9);}
	              		
	              		if(!"null".equals(x10)){
	              		Element param10=outdoc.createElement(x10);
	              		if(xv10.equals(""))
	              		param10.setTextContent("null");
	              		else
	              		param10.setTextContent(xPath.evaluate(xv10, inputEvent));
	              		outputEvent.appendChild(param10);}
	              		
	              		if(!"null".equals(x11)){
	              		Element param11=outdoc.createElement(x11);
	              		if(xv11.equals(""))
	              		param11.setTextContent("null");
	              		else
	              		param11.setTextContent(xPath.evaluate(xv11, inputEvent));
	              		outputEvent.appendChild(param11);}
	              		
	              		if(!"null".equals(x12)){
	              		Element param12=outdoc.createElement(x12);
	              		if(xv12.equals(""))
	              		param12.setTextContent("null");
	              		else
	              		param12.setTextContent(xPath.evaluate(xv12, inputEvent));
	              		outputEvent.appendChild(param12);}
	              		
	              		if(!"null".equals(x13)){
	              		Element param13=outdoc.createElement(x13);
	              		if(xv13.equals(""))
	              		param13.setTextContent("null");
	              		else
	              		param13.setTextContent(xPath.evaluate(xv13, inputEvent));
	              		outputEvent.appendChild(param13);}
	              		
	              		if(!"null".equals(x14)){
	              		Element param14=outdoc.createElement(x14);
	              		if(xv14.equals(""))
	              		param14.setTextContent("null");
	              		else
	              		param14.setTextContent(xPath.evaluate(xv14, inputEvent));
	              		outputEvent.appendChild(param14);}
	              		
	              		if(!"null".equals(x15)){
	              		Element param15=outdoc.createElement(x15);
	              		if(xv15.equals(""))
	              		param15.setTextContent("null");
	              		else
	              		param15.setTextContent(xPath.evaluate(xv15, inputEvent));
	              		outputEvent.appendChild(param15);}
	              		
	              		if(!"null".equals(x16)){
	              		Element param16=outdoc.createElement(x16);
	              		if(xv16.equals(""))
	              		param16.setTextContent("null");
	              		else
	              		param16.setTextContent(xPath.evaluate(xv16, inputEvent));
	              		outputEvent.appendChild(param16);}
	              		
	              		if(!"null".equals(x17)){
	              		Element param17=outdoc.createElement(x17);
	              		if(xv17.equals(""))
	              		param17.setTextContent("null");
	              		else
	              		param17.setTextContent(xPath.evaluate(xv17, inputEvent));
	              		outputEvent.appendChild(param17);}
	              		
	              		if(!"null".equals(x18)){
	              		Element param18=outdoc.createElement(x18);
	              		if(xv18.equals(""))
	              		param18.setTextContent("null");
	              		else
	              		param18.setTextContent(xPath.evaluate(xv18, inputEvent));
	              		outputEvent.appendChild(param18);}
	              		
	              		if(!"null".equals(x19)){
	              		Element param19=outdoc.createElement(x19);
	              		if(xv19.equals(""))
	              		param19.setTextContent("null");
	              		else
	              		param19.setTextContent(xPath.evaluate(xv19, inputEvent));
	              		outputEvent.appendChild(param19);}
	              		
	              		if(!"null".equals(x20)){
	              		Element param20=outdoc.createElement(x20);
	              		if(xv20.equals(""))
	              		param20.setTextContent("null");
	              		else
	              		param20.setTextContent(xPath.evaluate(xv20, inputEvent));
	              		outputEvent.appendChild(param20);}
	              		
	              		
	              		if(!"null".equals(x21)){
	              		Element param21=outdoc.createElement(x21);
	              		if(xv21.equals(""))
	              		param21.setTextContent("null");
	              		else
	              		param21.setTextContent(xPath.evaluate(xv21, inputEvent));
	              		outputEvent.appendChild(param21);}
	              		
	              		if(!"null".equals(x22)){
	              		Element param22=outdoc.createElement(x22);
	              		if(xv22.equals(""))
	              		param22.setTextContent("null");
	              		else
	              		param22.setTextContent(xPath.evaluate(xv22, inputEvent));
	              		outputEvent.appendChild(param22);}
	              		
	              		if(!"null".equals(x23)){
	              		Element param23=outdoc.createElement(x23);
	              		if(xv23.equals(""))
	              		param23.setTextContent("null");
	              		else
	              		param23.setTextContent(xPath.evaluate(xv23, inputEvent));
	              		outputEvent.appendChild(param23);}
	              		
	              		if(!"null".equals(x24)){
	              		Element param24=outdoc.createElement(x24);
	              		if(xv24.equals(""))
	              		param24.setTextContent("null");
	              		else
	              		param24.setTextContent(xPath.evaluate(xv24, inputEvent));
	              		outputEvent.appendChild(param24);}
	              		
	              		if(!"null".equals(x25)){
	              		Element param25=outdoc.createElement(x25);
	              		if(xv25.equals(""))
	              		param25.setTextContent("null");
	              		else
	              		param25.setTextContent(xPath.evaluate(xv25, inputEvent));
	              		outputEvent.appendChild(param25);}
	              		
	              		if(!"null".equals(x26)){
	              		Element param26=outdoc.createElement(x26);
	              		if(xv26.equals(""))
	              		param26.setTextContent("null");
	              		else
	              		param26.setTextContent(xPath.evaluate(xv26, inputEvent));
	              		outputEvent.appendChild(param26);}
	              		
	              		if(!"null".equals(x27)){
	              		Element param27=outdoc.createElement(x27);
	              		if(xv27.equals(""))
	              		param27.setTextContent("null");
	              		else
	              		param27.setTextContent(xPath.evaluate(xv27, inputEvent));
	              		outputEvent.appendChild(param27);}
	              		
	              		if(!"null".equals(x28)){
	              		Element param28=outdoc.createElement(x28);
	              		if(xv28.equals(""))
	              		param28.setTextContent("null");
	              		else
	              		param28.setTextContent(xPath.evaluate(xv28, inputEvent));
	              		outputEvent.appendChild(param28);}
	              		
	              		if(!"null".equals(x29)){
	              		Element param29=outdoc.createElement(x29);
	              		if(xv29.equals(""))
	              		param29.setTextContent("null");
	              		else
	              		param29.setTextContent(xPath.evaluate(xv29, inputEvent));
	              		outputEvent.appendChild(param29);}
	              		
	              		if(!"null".equals(x30)){
	              		Element param30=outdoc.createElement(x30);
	              		if(xv30.equals(""))
	              		param30.setTextContent("null");
	              		else
	              		param30.setTextContent(xPath.evaluate(xv30, inputEvent));
	              		outputEvent.appendChild(param30);}
	             		
	              		outevent.appendChild(outputEvent);

		        	  	       		
	              	}   
	                   }
	                   outdoc.appendChild(outevent); //the full formed mpulpy xml now in document
	                   Transformer transformer1=null;
	                   try {
	           			 transformer1=TransformerFactory.newInstance().newTransformer();
	           		} catch (TransformerConfigurationException e) {
	           			// TODO Auto-generated catch block
	           		} 
	           	 transformer1.setOutputProperty(OutputKeys.INDENT,"yes");
	           	 transformer1.setOutputProperty(OutputKeys.METHOD,"xml");

	           	 StreamResult result=new StreamResult(new StringWriter());
	                DOMSource source=new DOMSource(outdoc);
	                try {
	            		transformer1.transform(source, result);  //transform mpulpy xml from document to xml string and make display in browser ->to send client(phonegap)
	            	} catch (TransformerException e) {
	            		e.printStackTrace();
	            	}
	                 Writer output=null;
	                // output=new BufferedWriter(new FileWriter("F:/workspace/mind.xml"));
	                 String xmloutput=result.getWriter().toString();
	                /* output.write(xmloutput);
	                 output.close();*/
	                 out.println(xmloutput);
	              	
        }//while
        }// first config
        
        //sec config
        else if(eurl11.equals("2")){
        	String line="";
            while(rs1.next()){ // retrieve data from Database and join two tables namely(secconfig&secxmlconfig)
            	
                
               
                String securl1=rs1.getString("securl");String cycle1=rs1.getString("cycle");String secid=rs1.getString("sec1"); String secval=rs1.getString("sec2");
                String ak1=rs1.getString("alabel1");
                String ak2=rs1.getString("akey1");String se1=rs1.getString("s1"); String sev1=rs1.getString("sv1");String se2=rs1.getString("s2"); String sev2=rs1.getString("sv2");
                String se3=rs1.getString("s3"); String sev3=rs1.getString("sv3");String se4=rs1.getString("s4"); String sev4=rs1.getString("sv4");
                String se5=rs1.getString("s5"); String sev5=rs1.getString("sv5");String se6=rs1.getString("s6"); String sev6=rs1.getString("sv6");
                String se7=rs1.getString("s7"); String sev7=rs1.getString("sv7");String se8=rs1.getString("s8"); String sev8=rs1.getString("sv8");
                String se9=rs1.getString("s9"); String sev9=rs1.getString("sv9");String se10=rs1.getString("s10"); String sev10=rs1.getString("sv10");
    String resf2=rs1.getString("resf2");

                String secroot=rs1.getString("secroot");String secparent=rs1.getString("secparent"); //get from secxmlconfig
      
     String sx1=rs1.getString("sx1"); String sxv1=rs1.getString("sxv1");String sx2=rs1.getString("sx2"); String sxv2=rs1.getString("sxv2");
     String sx3=rs1.getString("sx3"); String sxv3=rs1.getString("sxv3");String sx4=rs1.getString("sx4"); String sxv4=rs1.getString("sxv4");
     String sx5=rs1.getString("sx5"); String sxv5=rs1.getString("sxv5");String sx6=rs1.getString("sx6"); String sxv6=rs1.getString("sxv6");
     String sx7=rs1.getString("sx7"); String sxv7=rs1.getString("sxv7");String sx8=rs1.getString("sx8"); String sxv8=rs1.getString("sxv8");
     String sx9=rs1.getString("sx9"); String sxv9=rs1.getString("sxv9");String sx10=rs1.getString("sx10"); String sxv10=rs1.getString("sxv10");
     String sx11=rs1.getString("sx11"); String sxv11=rs1.getString("sxv11");String sx12=rs1.getString("sx12"); String sxv12=rs1.getString("sxv12");
     String sx13=rs1.getString("sx13"); String sxv13=rs1.getString("sxv13");String sx14=rs1.getString("sx14"); String sxv14=rs1.getString("sxv14");
     String sx15=rs1.getString("sx15"); String sxv15=rs1.getString("sxv15");String sx16=rs1.getString("sx16"); String sxv16=rs1.getString("sxv16");
     String sx17=rs1.getString("sx17"); String sxv17=rs1.getString("sxv17");String sx18=rs1.getString("sx18"); String sxv18=rs1.getString("sxv18");
     String sx19=rs1.getString("sx19"); String sxv19=rs1.getString("sxv19");String sx20=rs1.getString("sx20"); String sxv20=rs1.getString("sxv20");
     String sx21=rs1.getString("sx21"); String sxv21=rs1.getString("sxv21");String sx22=rs1.getString("sx22"); String sxv22=rs1.getString("sxv22");
     String sx23=rs1.getString("sx23"); String sxv23=rs1.getString("sxv23");String sx24=rs1.getString("sx24"); String sxv24=rs1.getString("sxv24");
     String sx25=rs1.getString("sx25"); String sxv25=rs1.getString("sxv25");String sx26=rs1.getString("sx26"); String sxv26=rs1.getString("sxv26");
     String sx27=rs1.getString("sx27"); String sxv27=rs1.getString("sxv27");String sx28=rs1.getString("sx28"); String sxv28=rs1.getString("sxv28");
     String sx29=rs1.getString("sx29"); String sxv29=rs1.getString("sxv29");String sx30=rs1.getString("sx30"); String sxv30=rs1.getString("sxv30");
     String secjsonxml=null;
     String secdurl=null;
     Document doc=null;  //TO Convert XMLSTRING TO DOCUMENT
     DocumentBuilder builder=null;
     DocumentBuilderFactory domFactory=DocumentBuilderFactory.newInstance();
     builder=domFactory.newDocumentBuilder();
  
 	 if(resf2.equals("XML") ){  //API XML get
		 if(!"null".equals(se1) && !"null".equals(se2) && !"null".equals(se3) && !"null".equals(se4) && !"null".equals(se5) && !"null".equals(se6)&& "entity".equals(cycle1)){
		     secdurl=securl1+"?"+ak1+"="+ak2+"&"+se1+"="+p1+"&"+se2+"="+p2+"&"+se3+"="+p3+"&"+se4+"="+p4+"&"+se5+"="+p5+"&"+se6+"="+p6;}
		 
		 else if(!"null".equals(se1) && !"null".equals(se2) && !"null".equals(se3) && !"null".equals(se4) && !"null".equals(se5)&& "entity".equals(cycle1)){
    		 secdurl=securl1+"?"+ak1+"="+ak2+"&"+se1+"="+p1+"&"+se2+"="+p2+"&"+se3+"="+p3+"&"+se4+"="+p4+"&"+se5+"="+p5;}
		 
		 else if(!"null".equals(se1) && !"null".equals(se2) && !"null".equals(se3) && !"null".equals(se4)&& "entity".equals(cycle1)){
    		 secdurl=securl1+"?"+ak1+"="+ak2+"&"+se1+"="+p1+"&"+se2+"="+p2+"&"+se3+"="+p3+"&"+se4+"="+p4;}
		 
		 else if(!"null".equals(se1) && !"null".equals(se2) && !"null".equals(se3)&& "entity".equals(cycle1)){
    		 secdurl=securl1+"?"+ak1+"="+ak2+"&"+se1+"="+p1+"&"+se2+"="+p2+"&"+se3+"="+p3;}
		 
		 else if(!"null".equals(se1) && !"null".equals(se2)&& "entity".equals(cycle1)){
    		 secdurl=securl1+"?"+ak1+"="+ak2+"&"+se1+"="+p1+"&"+se2+"="+p2;}
		 
		 else if(!"".equals(se1)&& "entity".equals(cycle1)){
    		 secdurl=securl1+"?"+ak1+"="+ak2+"&"+se1+"="+p1;}
		 
		 else if(!"".equals(ak1) && !"".equals(ak2)&& "".equals(se1) &&"entity".equals(cycle1))
		      secdurl=securl1+"?"+ak1+"="+ak2;
		 else if("".equals(ak1) && "".equals(ak2) && "entity".equals(cycle1))
			      secdurl=securl1+"/"+p1;	
		 doc=builder.parse(new URL(secdurl).openStream());
	       
	 }  //end if JSON
	 
	 else if(resf2.equals("JSON") ){  //API XML get
		 if(!"null".equals(se1) && !"null".equals(se2) && !"null".equals(se3) && !"null".equals(se4) && !"null".equals(se5) && !"null".equals(se6)&& "entity".equals(cycle1)){
		     secdurl=securl1+"?"+ak1+"="+ak2+"&"+se1+"="+p1+"&"+se2+"="+p2+"&"+se3+"="+p3+"&"+se4+"="+p4+"&"+se5+"="+p5+"&"+se6+"="+p6;}
		 
		 else if(!"null".equals(se1) && !"null".equals(se2) && !"null".equals(se3) && !"null".equals(se4) && !"null".equals(se5)&& "entity".equals(cycle1)){
    		 secdurl=securl1+"?"+ak1+"="+ak2+"&"+se1+"="+p1+"&"+se2+"="+p2+"&"+se3+"="+p3+"&"+se4+"="+p4+"&"+se5+"="+p5;}
		 
		 else if(!"null".equals(se1) && !"null".equals(se2) && !"null".equals(se3) && !"null".equals(se4)&& "entity".equals(cycle1)){
    		 secdurl=securl1+"?"+ak1+"="+ak2+"&"+se1+"="+p1+"&"+se2+"="+p2+"&"+se3+"="+p3+"&"+se4+"="+p4;}
		 
		 else if(!"null".equals(se1) && !"null".equals(se2) && !"null".equals(se3)&& "entity".equals(cycle1)){
    		 secdurl=securl1+"?"+ak1+"="+ak2+"&"+se1+"="+p1+"&"+se2+"="+p2+"&"+se3+"="+p3;}
		 
		 else if(!"null".equals(se1) && !"null".equals(se2)&& "entity".equals(cycle1)){
    		 secdurl=securl1+"?"+ak1+"="+ak2+"&"+se1+"="+p1+"&"+se2+"="+p2;}
		 
		 else if(!"null".equals(se1)&& "entity".equals(cycle1)){
    		 secdurl=securl1+"?"+ak1+"="+ak2+"&"+se1+"="+p1;}
		 
		
		 else if(!"null".equals(ak1) && !"null".equals(ak2)&& "null".equals(se1) &&"entity".equals(cycle1))
		      secdurl=securl1+"?"+ak1+"="+ak2;
		 else if("null".equals(ak1) && "null".equals(ak2) && "entity".equals(cycle1))
			      secdurl=securl1;	
		 
		 URL second_url=new URL(secdurl);
		 URLConnection uconn = second_url.openConnection();
	     HttpURLConnection conn = (HttpURLConnection) uconn;
	         conn.connect();
	         Object content = conn.getContent();
	         InputStream stream = (InputStream) content;
	         line=null;String strcon=null;String str=null;
    	     StringBuilder strb=new StringBuilder();
	         BufferedReader br=new BufferedReader(new InputStreamReader(stream));
    	     while ((line = br.readLine()) != null)    { 
	    	      strb.append(line);
   		     }//while
	    	 strcon=strb.toString();
	    	 XMLSerializer serializer = new XMLSerializer();
	            JSON json = JSONSerializer.toJSON(strcon);
	            serializer.setRootName("root");
	            serializer.setTypeHintsEnabled(false);
	            str = serializer.write(json);

	          // end-while 
		        doc= builder.parse(new InputSource(new ByteArrayInputStream(str.getBytes("UTF-8")))); 

	       
	 }  //end if JSON

 
 
  
       
        Document outdoc=DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Element outevent=outdoc.createElement("MPulpy");
        NodeList inevent=null;
        XPath xPath=XPathFactory.newInstance().newXPath();
        inevent=(NodeList) xPath.evaluate("//"+secroot,doc,XPathConstants.NODESET); 
        if(inevent!=null){
      	  
          	for(int i=0;i<inevent.getLength();i++){
          		Element outputEvent=outdoc.createElement("root"); // create mpulpy xml here
          		Node inputEvent=inevent.item(i);
          		       
          	    if(!"null".equals(sx1)){   //validation for not return null tag
          		Element param1=outdoc.createElement(sx1);  //create element
                if(sxv1.equals(""))
          		param1.setTextContent("null");
          		else
          		param1.setTextContent(xPath.evaluate(sxv1, inputEvent)); // map our xml with third party server xml
          		outputEvent.appendChild(param1);}
          		
          		if(!"null".equals(sx2)){
                Element param2=outdoc.createElement(sx2);
                if(sxv2.equals(""))
          		param2.setTextContent("null");
          		else
          		param2.setTextContent(xPath.evaluate(sxv2, inputEvent));
          		outputEvent.appendChild(param2);}
          		
          		if(!"null".equals(sx3)){
          		Element param3=outdoc.createElement(sx3);
                if(sxv3.equals(""))
          		param3.setTextContent("null");
          		else
          		param3.setTextContent(xPath.evaluate(sxv3, inputEvent));
          		outputEvent.appendChild(param3);}
          		
          		if(!"null".equals(sx4)){
          		Element param4=outdoc.createElement(sx4);
                if(sxv4.equals(""))
          		param4.setTextContent("null");
          		else
          		param4.setTextContent(xPath.evaluate(sxv4, inputEvent));
          		outputEvent.appendChild(param4);}
          		
      		    if(!"null".equals(sx5)){
              	Element param5=outdoc.createElement(sx5);
                if(sxv5.equals(""))
          		param5.setTextContent("null");
          		else
          		param5.setTextContent(xPath.evaluate(sxv5, inputEvent));
          		outputEvent.appendChild(param5);}
          		
          		if(!"null".equals(sx6)){
          		Element param6=outdoc.createElement(sx6);
                if(sxv6.equals(""))
          		param6.setTextContent("null");
          		else
          		param6.setTextContent(xPath.evaluate(sxv6, inputEvent));
          		outputEvent.appendChild(param6);}
          		
          		if(!"null".equals(sx7)){
          		Element param7=outdoc.createElement(sx7);
          		if(sxv7.equals(""))
          		param7.setTextContent("");
          		else
          		param7.setTextContent(xPath.evaluate(sxv7, inputEvent));
          		outputEvent.appendChild(param7);}
          		
          		if(!"null".equals(sx8)){
          		Element param8=outdoc.createElement(sx8);
          		if(sxv8.equals(""))
          		param8.setTextContent("");
          		else
          		param8.setTextContent(xPath.evaluate(sxv8, inputEvent));
          		outputEvent.appendChild(param8);}
          		
          		if(!"null".equals(sx9)){
          		Element param9=outdoc.createElement(sx9);
          		if(sxv9.equals(""))
          		param9.setTextContent("");
          		else
          		param9.setTextContent(xPath.evaluate(sxv9, inputEvent));
          		outputEvent.appendChild(param9);}
          		
          		if(!"null".equals(sx10)){
          		Element param10=outdoc.createElement(sx10);
          		if(sxv10.equals(""))
          		param10.setTextContent("null");
          		else
          		param10.setTextContent(xPath.evaluate(sxv10, inputEvent));
          		outputEvent.appendChild(param10);}
          		
          		if(!"null".equals(sx11)){
          		Element param11=outdoc.createElement(sx11);
          		if(sxv11.equals(""))
          		param11.setTextContent("null");
          		else
          		param11.setTextContent(xPath.evaluate(sxv11, inputEvent));
          		outputEvent.appendChild(param11);}
          		
          		if(!"null".equals(sx12)){
          		Element param12=outdoc.createElement(sx12);
          		if(sxv12.equals(""))
          		param12.setTextContent("null");
          		else
          		param12.setTextContent(xPath.evaluate(sxv12, inputEvent));
          		outputEvent.appendChild(param12);}
          		
          		if(!"null".equals(sx13)){
          		Element param13=outdoc.createElement(sx13);
          		if(sxv13.equals(""))
          		param13.setTextContent("null");
          		else
          		param13.setTextContent(xPath.evaluate(sxv13, inputEvent));
          		outputEvent.appendChild(param13);}
          		
          		if(!"null".equals(sx14)){
          		Element param14=outdoc.createElement(sx14);
          		if(sxv14.equals(""))
          		param14.setTextContent("null");
          		else
          		param14.setTextContent(xPath.evaluate(sxv14, inputEvent));
          		outputEvent.appendChild(param14);}
          		
          		if(!"null".equals(sx15)){
          		Element param15=outdoc.createElement(sx15);
          		if(sxv15.equals(""))
          		param15.setTextContent("null");
          		else
          		param15.setTextContent(xPath.evaluate(sxv15, inputEvent));
          		outputEvent.appendChild(param15);}
          		
          		if(!"null".equals(sx16)){
          		Element param16=outdoc.createElement(sx16);
          		if(sxv16.equals(""))
          		param16.setTextContent("null");
          		else
          		param16.setTextContent(xPath.evaluate(sxv16, inputEvent));
          		outputEvent.appendChild(param16);}
          		
          		if(!"null".equals(sx17)){
          		Element param17=outdoc.createElement(sx17);
          		if(sxv17.equals(""))
          		param17.setTextContent("null");
          		else
          		param17.setTextContent(xPath.evaluate(sxv17, inputEvent));
          		outputEvent.appendChild(param17);}
          		
          		if(!"null".equals(sx18)){
          		Element param18=outdoc.createElement(sx18);
          		if(sxv18.equals(""))
          		param18.setTextContent("null");
          		else
          		param18.setTextContent(xPath.evaluate(sxv18, inputEvent));
          		outputEvent.appendChild(param18);}
          		
          		if(!"null".equals(sx19)){
          		Element param19=outdoc.createElement(sx19);
          		if(sxv19.equals(""))
          		param19.setTextContent("null");
          		else
          		param19.setTextContent(xPath.evaluate(sxv19, inputEvent));
          		outputEvent.appendChild(param19);}
          		
          		if(!"null".equals(sx20)){
          		Element param20=outdoc.createElement(sx20);
          		if(sxv20.equals(""))
          		param20.setTextContent("null");
          		else
          		param20.setTextContent(xPath.evaluate(sxv20, inputEvent));
          		outputEvent.appendChild(param20);}
          		
          		
          		if(!"null".equals(sx21)){
          		Element param21=outdoc.createElement(sx21);
          		if(sxv21.equals(""))
          		param21.setTextContent("null");
          		else
          		param21.setTextContent(xPath.evaluate(sxv21, inputEvent));
          		outputEvent.appendChild(param21);}
          		
          		if(!"null".equals(sx22)){
          		Element param22=outdoc.createElement(sx22);
          		if(sxv22.equals(""))
          		param22.setTextContent("null");
          		else
          		param22.setTextContent(xPath.evaluate(sxv22, inputEvent));
          		outputEvent.appendChild(param22);}
          		
          		if(!"null".equals(sx23)){
          		Element param23=outdoc.createElement(sx23);
          		if(sxv23.equals(""))
          		param23.setTextContent("null");
          		else
          		param23.setTextContent(xPath.evaluate(sxv23, inputEvent));
          		outputEvent.appendChild(param23);}
          		
          		if(!"null".equals(sx24)){
          		Element param24=outdoc.createElement(sx24);
          		if(sxv24.equals(""))
          		param24.setTextContent("null");
          		else
          		param24.setTextContent(xPath.evaluate(sxv24, inputEvent));
          		outputEvent.appendChild(param24);}
          		
          		if(!"null".equals(sx25)){
          		Element param25=outdoc.createElement(sx25);
          		if(sxv25.equals(""))
          		param25.setTextContent("null");
          		else
          		param25.setTextContent(xPath.evaluate(sxv25, inputEvent));
          		outputEvent.appendChild(param25);}
          		
          		if(!"null".equals(sx26)){
          		Element param26=outdoc.createElement(sx26);
          		if(sxv26.equals(""))
          		param26.setTextContent("null");
          		else
          		param26.setTextContent(xPath.evaluate(sxv26, inputEvent));
          		outputEvent.appendChild(param26);}
          		
          		if(!"null".equals(sx27)){
          		Element param27=outdoc.createElement(sx27);
          		if(sxv27.equals(""))
          		param27.setTextContent("null");
          		else
          		param27.setTextContent(xPath.evaluate(sxv27, inputEvent));
          		outputEvent.appendChild(param27);}
          		
          		if(!"null".equals(sx28)){
          		Element param28=outdoc.createElement(sx28);
          		if(sxv28.equals(""))
          		param28.setTextContent("null");
          		else
          		param28.setTextContent(xPath.evaluate(sxv28, inputEvent));
          		outputEvent.appendChild(param28);}
          		
          		if(!"null".equals(sx29)){
          		Element param29=outdoc.createElement(sx29);
          		if(sxv29.equals(""))
          		param29.setTextContent("null");
          		else
          		param29.setTextContent(xPath.evaluate(sxv29, inputEvent));
          		outputEvent.appendChild(param29);}
          		
          		if(!"null".equals(sx30)){
          		Element param30=outdoc.createElement(sx30);
          		if(sxv30.equals(""))
          		param30.setTextContent("null");
          		else
          		param30.setTextContent(xPath.evaluate(sxv30, inputEvent));
          		outputEvent.appendChild(param30);}
           		outevent.appendChild(outputEvent);
          	}
          	}
       
	                   outdoc.appendChild(outevent); //the full formed mpulpy xml now in document
	                   Transformer transformer1=null;
	                   try {
	           			 transformer1=TransformerFactory.newInstance().newTransformer();
	           		} catch (TransformerConfigurationException e) {
	           			// TODO Auto-generated catch block
	           		} 
	           	 transformer1.setOutputProperty(OutputKeys.INDENT,"yes");
	           	 transformer1.setOutputProperty(OutputKeys.METHOD,"xml");

	           	 StreamResult result=new StreamResult(new StringWriter());
	                DOMSource source=new DOMSource(outdoc);
	                try {
	            		transformer1.transform(source, result);  //transform mpulpy xml from document to xml string and make display in browser ->to send client(phonegap)
	            	} catch (TransformerException e) {
	            		e.printStackTrace();
	            	}
	                 Writer output=null;
	                // output=new BufferedWriter(new FileWriter("F:/workspace/mind.xml"));
	                 String xmloutput=result.getWriter().toString();
	                /* output.write(xmloutput);
	                 output.close();*/
	                out.println(xmloutput);
            }//while
            }//second config
        
        //third config
        else if(eurl11.equals("3")){
        	String line="";
            while(rs2.next()){ // retrieve data from Database and join two tables namely(thrdconfig&thrdxmlconfig)
            	String thirdurl1=rs2.getString("thrdurl");String thirdcycle1=rs2.getString("thrdcycle"); String akt1=rs2.getString("alabel");String akt2=rs2.getString("akey");
            	 String thrdid=rs2.getString("thrd1"); String thrdval=rs2.getString("thrd2");
            	 String tp1=rs2.getString("t1"); String tpv1=rs2.getString("tv1");String tp2=rs2.getString("t2"); String tpv2=rs2.getString("tv2");
            	 String tp3=rs2.getString("t3"); String tpv3=rs2.getString("tv3");String tp4=rs2.getString("t4"); String tpv4=rs2.getString("tv4");
            	 String tp5=rs2.getString("t5"); String tpv5=rs2.getString("tv5");String tp6=rs2.getString("t6"); String tpv6=rs2.getString("tv6");
            	 String tp7=rs2.getString("t7"); String tpv7=rs2.getString("tv7");String tp8=rs2.getString("t8"); String tpv8=rs2.getString("tv8");
            	 String tp9=rs2.getString("t9"); String tpv9=rs2.getString("tv9");String tp10=rs2.getString("t10"); String tpv10=rs2.getString("tv10");
            	 String resf3=rs2.getString("resf3");
            	 //get from thirdxmlconfig
            	 String thrdparent=rs2.getString("thrdparent");String thrdroot=rs2.getString("thrdroot");
            	 String tx1=rs2.getString("tx1"); String txv1=rs2.getString("txv1");String tx2=rs2.getString("tx2"); String txv2=rs2.getString("txv2");
            	 String tx3=rs2.getString("tx3"); String txv3=rs2.getString("txv3");String tx4=rs2.getString("tx4"); String txv4=rs2.getString("txv4");
            	 String tx5=rs2.getString("tx5"); String txv5=rs2.getString("txv5");String tx6=rs2.getString("tx6"); String txv6=rs2.getString("txv6");
            	 String tx7=rs2.getString("tx7"); String txv7=rs2.getString("txv7");String tx8=rs2.getString("tx8"); String txv8=rs2.getString("txv8");
            	 String tx9=rs2.getString("tx9"); String txv9=rs2.getString("txv9");String tx10=rs2.getString("tx10"); String txv10=rs2.getString("txv10");
            	 String tx11=rs2.getString("tx11"); String txv11=rs2.getString("txv11");String tx12=rs2.getString("tx12"); String txv12=rs2.getString("txv12");
            	 String tx13=rs2.getString("tx13"); String txv13=rs2.getString("txv13");String tx14=rs2.getString("tx14"); String txv14=rs2.getString("txv14");
            	 String tx15=rs2.getString("tx15"); String txv15=rs2.getString("txv15");String tx16=rs2.getString("tx16"); String txv16=rs2.getString("txv16");
            	 String tx17=rs2.getString("tx17"); String txv17=rs2.getString("txv17");String tx18=rs2.getString("tx18"); String txv18=rs2.getString("txv18");
            	 String tx19=rs2.getString("tx19"); String txv19=rs2.getString("txv19");String tx20=rs2.getString("tx20"); String txv20=rs2.getString("txv20");
            	 String tx21=rs2.getString("tx21"); String txv21=rs2.getString("txv21");String tx22=rs2.getString("tx22"); String txv22=rs2.getString("txv22");
            	 String tx23=rs2.getString("tx23"); String txv23=rs2.getString("txv23");String tx24=rs2.getString("tx24"); String txv24=rs2.getString("txv24");
            	 String tx25=rs2.getString("tx25"); String txv25=rs2.getString("txv25");String tx26=rs2.getString("tx26"); String txv26=rs2.getString("txv26");
            	 String tx27=rs2.getString("tx27"); String txv27=rs2.getString("txv27");String tx28=rs2.getString("tx28"); String txv28=rs2.getString("txv28");
            	 String tx29=rs2.getString("tx29"); String txv29=rs2.getString("txv29");String tx30=rs2.getString("tx30"); String txv30=rs2.getString("txv30");
            	
            	Document doc1=null;  //TO Convert XMLSTRING TO DOCUMENT
                DocumentBuilder builder1=null;
                DocumentBuilderFactory domFactory1=DocumentBuilderFactory.newInstance();
                builder1=domFactory1.newDocumentBuilder();
                  	
                	
                    String thirdurl11=null;
                    String thrdjsonxmlout=null;
                    
                    
                   
                   	 if( resf3.equals("XML")){  //API XML get
                   		 

                   		 if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3) && !"null".equals(tp4) && !"null".equals(tp5) && !"null".equals(tp6)&& "entity".equals(thirdcycle1)){
                   		     thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+p1+"&"+tp2+"="+p2+"&"+tp3+"="+p3+"&"+tp4+"="+p4+"&"+tp5+"="+p5+"&"+tp6+"="+p6;}
                   		 
                   		 else if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3) && !"null".equals(tp4) && !"null".equals(tp5)&& "entity".equals(thirdcycle1)){
             	        		 thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+p1+"&"+tp2+"="+p2+"&"+tp3+"="+p3+"&"+tp4+"="+p4+"&"+tp5+"="+p5;}
                   		 
                   		 else if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3) && !"null".equals(tp4)&& "entity".equals(thirdcycle1)){
             	        		 thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+p1+"&"+tp2+"="+p2+"&"+tp3+"="+p3+"&"+tp4+"="+p4;}
                   		 
                   		 else if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3)&& "entity".equals(thirdcycle1)){
             	        		 thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+p1+"&"+tp2+"="+p2+"&"+tp3+"="+p3;}
                   		 
                   		 else if(!"null".equals(tp1) && !"null".equals(tp2)&& "entity".equals(thirdcycle1)){
             	        		 thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+p1+"&"+tp2+"="+p2;}
                   		 
                   		 else if(!"null".equals(tp1)&& "entity".equals(thirdcycle1)){
             	        		 thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+p1;}
                   		 
                   		 //else if(!"null".equals(thrdid)&& !"null".equals(thrdval) && "flow".equals(thirdcycle1)&&!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3)){
             	        	//	 thirdurl11=thirdurl1+"?"+oriapilabel+"="+oriapikey+"&"+prdid+"="+paid+"&"+tp1+"="+p1+"&"+tp2+"="+p2+"&"+tp3+"="+p3;}
                   		 
                   		// else if(!"null".equals(thrdid)&& !"null".equals(thrdval) && "flow".equals(thirdcycle1)&&!"null".equals(tp1) && !"null".equals(tp2)){
             	        	//	 thirdurl11=thirdurl1+"?"+oriapilabel+"="+oriapikey+"&"+prdid+"="+paid+"&"+tp1+"="+p1+"&"+tp2+"="+p2;}
                   		 
                   		// else if(!"null".equals(thrdid)&& !"null".equals(thrdval) && "flow".equals(thirdcycle1)&&!"null".equals(tp1)){
             	        	//	 thirdurl11=thirdurl1+"?"+oriapilabel+"="+oriapikey+"&"+prdid+"="+paid+"&"+tp1+"="+p1;}
                   		 
                   		 //else if(!"null".equals(thrdid)&& !"null".equals(thrdval) && "flow".equals(thirdcycle1))
                   			// thirdurl11=thirdurl1+"?"+oriapilabel+"="+oriapikey+"&"+prdid+"="+paid;
                   		
                   		 else if(!"null".equals(akt1) && !"null".equals(akt2)&& "entity".equals(thirdcycle1))
                   			      thirdurl11=thirdurl1+"?"+akt1+"="+akt2;
                   		 
                   		 else if("null".equals(akt1) && "null".equals(akt2))
                   			      thirdurl11=thirdurl1;
                   		 
                  		 doc1=builder1.parse(new URL(thirdurl11).openStream());

                   		
            	     
                   	 }//api keys and get	 
                   		
                   	if(resf3.equals("JSON")){  //API XML get
                  		 

                  		 if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3) && !"null".equals(tp4) && !"null".equals(tp5) && !"null".equals(tp6)&& "entity".equals(thirdcycle1)){
                  		     thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+p1+"&"+tp2+"="+p2+"&"+tp3+"="+p3+"&"+tp4+"="+p4+"&"+tp5+"="+p5+"&"+tp6+"="+p6;}
                  		 
                  		 else if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3) && !"null".equals(tp4) && !"null".equals(tp5)&& "entity".equals(thirdcycle1)){
            	        		 thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+p1+"&"+tp2+"="+p2+"&"+tp3+"="+p3+"&"+tp4+"="+p4+"&"+tp5+"="+p5;}
                  		 
                  		 else if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3) && !"null".equals(tp4)&& "entity".equals(thirdcycle1)){
            	        		 thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+p1+"&"+tp2+"="+p2+"&"+tp3+"="+p3+"&"+tp4+"="+p4;}
                  		 
                  		 else if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3)&& "entity".equals(thirdcycle1)){
            	        		 thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+p1+"&"+tp2+"="+p2+"&"+tp3+"="+p3;}
                  		 
                  		 else if(!"null".equals(tp1) && !"null".equals(tp2)&& "entity".equals(thirdcycle1)){
            	        		 thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+p1+"&"+tp2+"="+p2;}
                  		 
                  		 else if(!"null".equals(tp1)&& "entity".equals(thirdcycle1)){
            	        		 thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+p1;}
                  		 
                  		// else if(!"null".equals(thrdid)&& !"null".equals(thrdval) && "flow".equals(thirdcycle1)&&!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3)){
            	        	//	 thirdurl11=thirdurl1+"?"+oriapilabel+"="+oriapikey+"&"+prdid+"="+paid+"&"+tp1+"="+p1+"&"+tp2+"="+p2+"&"+tp3+"="+p3;}
                  		 
                  		 //else if(!"null".equals(thrdid)&& !"null".equals(thrdval) && "flow".equals(thirdcycle1)&&!"null".equals(tp1) && !"null".equals(tp2)){
            	        	//	 thirdurl11=thirdurl1+"?"+oriapilabel+"="+oriapikey+"&"+thrdid+"="+paid+"&"+tp1+"="+p1+"&"+tp2+"="+p2;}
                  		 
                  		 //else if(!"null".equals(thrdid)&& !"null".equals(thrdval) && "flow".equals(thirdcycle1)&&!"null".equals(tp1)){
            	        	//	 thirdurl11=thirdurl1+"?"+oriapilabel+"="+oriapikey+"&"+thrdid+"="+paid+"&"+tp1+"="+p1;}
                  		 
                  		 //else if(!"null".equals(thrdid)&& !"null".equals(thrdval) && "flow".equals(thirdcycle1))
                  			// thirdurl11=thirdurl1+"?"+oriapilabel+"="+oriapikey+"&"+thrdid+"="+paid;
                  		
                  		 else if(!"null".equals(akt1) && !"null".equals(akt2)&& "entity".equals(thirdcycle1))
                  			      thirdurl11=thirdurl1+"?"+akt1+"="+akt2;
                  		 
                  		 else if("null".equals(akt1) && "null".equals(akt2))
                  			      thirdurl11=thirdurl1;
                  		 
                  		 //out.println(thirdurl11);

                  		URL url1=new URL(thirdurl11);
        				 URLConnection uconn = url1.openConnection();
        				 String str="";
                         BufferedReader br = new BufferedReader(new InputStreamReader(uconn.getInputStream()));
                          line=null; String strcon=null;
    	        	     StringBuilder strb=new StringBuilder();
             		     FileWriter fw=null;
          	          while ((line = br.readLine()) != null)    { 
        	    	      strb.append(line);
   	    		     }//while
        	    	 strcon=strb.toString();
        	    	 XMLSerializer serializer = new XMLSerializer();
     	            JSON json = JSONSerializer.toJSON(strcon);
     	            serializer.setRootName("root");
     	            serializer.setTypeHintsEnabled(false);
     	            str = serializer.write(json);
//out.println(str);
          	              
          	     // end-while 
        	    	  	  doc1= builder1.parse(new InputSource(new ByteArrayInputStream(str.getBytes("UTF-8")))); 

           	     
                  	 
                       	
                    }


             	     Document outdoc1=DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
             		 Element outevent1=outdoc1.createElement("MPulpy");
             		 NodeList inevent1=null;
             		 XPath xPath1=XPathFactory.newInstance().newXPath();
             		 inevent1=(NodeList) xPath1.evaluate("//"+thrdparent,doc1,XPathConstants.NODESET); //using XPATH to simply xml from third party server
                      if(inevent1!=null){
               	  
                 	for(int i=0;i<inevent1.getLength();i++){
                 		Element outputEvent1=outdoc1.createElement("root"); // create mpulpy xml here
                 		Node inputEvent1=inevent1.item(i);
                 		       
                 	    if(!"null".equals(tx1)){   //validation for not return null tag
                 		Element params1=outdoc1.createElement(tx1);  //create element
                       if(txv1.equals(""))
                 		params1.setTextContent("null");
                 		else
                 		params1.setTextContent(xPath1.evaluate(txv1, inputEvent1)); // map our xml with third party server xml
                 		outputEvent1.appendChild(params1);}
                 		
                 		if(!"null".equals(tx2)){
                   		Element params2=outdoc1.createElement(tx2);
                       if(txv2.equals(""))
                 		params2.setTextContent("null");
                 		else
                 		params2.setTextContent(xPath1.evaluate(txv2, inputEvent1));
                 		outputEvent1.appendChild(params2);}
                 		
                 		if(!"null".equals(tx3)){
                 		Element params3=outdoc1.createElement(tx3);
                          if(txv3.equals(""))
                 		params3.setTextContent("null");
                 		else
                 		params3.setTextContent(xPath1.evaluate(txv3, inputEvent1));
                 		outputEvent1.appendChild(params3);}
                 		
                 		if(!"null".equals(tx4)){
                 		Element params4=outdoc1.createElement(tx4);
                         if(txv4.equals(""))
                 		params4.setTextContent("null");
                 		else
                 		params4.setTextContent(xPath1.evaluate(txv4, inputEvent1));
                 		outputEvent1.appendChild(params4);}
                 		
             		    if(!"null".equals(tx5)){
                     	Element params5=outdoc1.createElement(tx5);
                       if(txv5.equals(""))
                 		params5.setTextContent("null");
                 		else
                 		params5.setTextContent(xPath1.evaluate(txv5, inputEvent1));
                 		outputEvent1.appendChild(params5);}
                 		
                 		if(!"null".equals(tx6)){
                 		Element params6=outdoc1.createElement(tx6);
                       if(txv6.equals(""))
                 		params6.setTextContent("null");
                 		else
                 		params6.setTextContent(xPath1.evaluate(txv6, inputEvent1));
                 		outputEvent1.appendChild(params6);}
                 		
                 		if(!"null".equals(tx7)){
                 		Element params7=outdoc1.createElement(tx7);
                 		if(txv7.equals(""))
                 		params7.setTextContent("");
                 		else
                 		params7.setTextContent(xPath1.evaluate(txv7, inputEvent1));
                 		outputEvent1.appendChild(params7);}
                 		
                 		if(!"null".equals(tx8)){
                 		Element params8=outdoc1.createElement(tx8);
                 		if(txv8.equals(""))
                 		params8.setTextContent("");
                 		else
                 		params8.setTextContent(xPath1.evaluate(txv8, inputEvent1));
                 		outputEvent1.appendChild(params8);}
                 		
                 		if(!"null".equals(tx9)){
                 		Element params9=outdoc1.createElement(tx9);
                 		if(txv9.equals(""))
                 		params9.setTextContent("");
                 		else
                 		params9.setTextContent(xPath1.evaluate(txv9, inputEvent1));
                 		outputEvent1.appendChild(params9);}
                 		
                 		if(!"null".equals(tx10)){
                 		Element params10=outdoc1.createElement(tx10);
                 		if(txv10.equals(""))
                 		params10.setTextContent("null");
                 		else
                 		params10.setTextContent(xPath1.evaluate(txv10, inputEvent1));
                 		outputEvent1.appendChild(params10);}
                 		
                 		if(!"null".equals(tx11)){
                 		Element params11=outdoc1.createElement(tx11);
                 		if(txv11.equals(""))
                 		params11.setTextContent("null");
                 		else
                 		params11.setTextContent(xPath1.evaluate(txv11, inputEvent1));
                 		outputEvent1.appendChild(params11);}
                 		
                 		if(!"null".equals(tx12)){
                 		Element params12=outdoc1.createElement(tx12);
                 		if(txv12.equals(""))
                 		params12.setTextContent("null");
                 		else
                 		params12.setTextContent(xPath1.evaluate(txv12, inputEvent1));
                 		outputEvent1.appendChild(params12);}
                 		
                 		if(!"null".equals(tx13)){
                 		Element params13=outdoc1.createElement(tx13);
                 		if(txv13.equals(""))
                 		params13.setTextContent("null");
                 		else
                 		params13.setTextContent(xPath1.evaluate(txv13, inputEvent1));
                 		outputEvent1.appendChild(params13);}
                 		
                 		if(!"null".equals(tx14)){
                 		Element params14=outdoc1.createElement(tx14);
                 		if(txv14.equals(""))
                 		params14.setTextContent("null");
                 		else
                 		params14.setTextContent(xPath1.evaluate(txv14, inputEvent1));
                 		outputEvent1.appendChild(params14);}
                 		
                 		if(!"null".equals(tx15)){
                 		Element params15=outdoc1.createElement(tx15);
                 		if(txv15.equals(""))
                 		params15.setTextContent("null");
                 		else
                 		params15.setTextContent(xPath1.evaluate(txv15, inputEvent1));
                 		outputEvent1.appendChild(params15);}
                 		
                 		if(!"null".equals(tx16)){
                 		Element params16=outdoc1.createElement(tx16);
                 		if(txv16.equals(""))
                 		params16.setTextContent("null");
                 		else
                 		params16.setTextContent(xPath1.evaluate(txv16, inputEvent1));
                 		outputEvent1.appendChild(params16);}
                 		
                 		if(!"null".equals(tx17)){
                 		Element params17=outdoc1.createElement(tx17);
                 		if(txv17.equals(""))
                 		params17.setTextContent("null");
                 		else
                 		params17.setTextContent(xPath1.evaluate(txv17, inputEvent1));
                 		outputEvent1.appendChild(params17);}
                 		
                 		if(!"null".equals(tx18)){
                 		Element params18=outdoc1.createElement(tx18);
                 		if(txv18.equals(""))
                 		params18.setTextContent("null");
                 		else
                 		params18.setTextContent(xPath1.evaluate(txv18, inputEvent1));
                 		outputEvent1.appendChild(params18);}
                 		
                 		if(!"null".equals(tx19)){
                 		Element params19=outdoc1.createElement(tx19);
                 		if(txv19.equals(""))
                 		params19.setTextContent("null");
                 		else
                 		params19.setTextContent(xPath1.evaluate(txv19, inputEvent1));
                 		outputEvent1.appendChild(params19);}
                 		
                 		if(!"null".equals(tx20)){
                 		Element params20=outdoc1.createElement(tx20);
                 		if(txv20.equals(""))
                 		params20.setTextContent("null");
                 		else
                 		params20.setTextContent(xPath1.evaluate(txv20, inputEvent1));
                 		outputEvent1.appendChild(params20);}
                 		
                 		
                 		if(!"null".equals(tx21)){
                 		Element params21=outdoc1.createElement(tx21);
                 		if(txv21.equals(""))
                 		params21.setTextContent("null");
                 		else
                 		params21.setTextContent(xPath1.evaluate(txv21, inputEvent1));
                 		outputEvent1.appendChild(params21);}
                 		
                 		if(!"null".equals(tx22)){
                 		Element params22=outdoc1.createElement(tx22);
                 		if(txv22.equals(""))
                 		params22.setTextContent("null");
                 		else
                 		params22.setTextContent(xPath1.evaluate(txv22, inputEvent1));
                 		outputEvent1.appendChild(params22);}
                 		
                 		if(!"null".equals(tx23)){
                 		Element params23=outdoc1.createElement(tx23);
                 		if(txv23.equals(""))
                 		params23.setTextContent("null");
                 		else
                 		params23.setTextContent(xPath1.evaluate(txv23, inputEvent1));
                 		outputEvent1.appendChild(params23);}
                 		
                 		if(!"null".equals(tx24)){
                 		Element params24=outdoc1.createElement(tx24);
                 		if(txv24.equals(""))
                 		params24.setTextContent("null");
                 		else
                 		params24.setTextContent(xPath1.evaluate(txv24, inputEvent1));
                 		outputEvent1.appendChild(params24);}
                 		
                 		if(!"null".equals(tx25)){
                 		Element params25=outdoc1.createElement(tx25);
                 		if(txv25.equals(""))
                 		params25.setTextContent("null");
                 		else
                 		params25.setTextContent(xPath1.evaluate(txv25, inputEvent1));
                 		outputEvent1.appendChild(params25);}
                 		
                 		if(!"null".equals(tx26)){
                 		Element params26=outdoc1.createElement(tx26);
                 		if(txv26.equals(""))
                 		params26.setTextContent("null");
                 		else
                 		params26.setTextContent(xPath1.evaluate(txv26, inputEvent1));
                 		outputEvent1.appendChild(params26);}
                 		
                 		if(!"null".equals(tx27)){
                 		Element params27=outdoc1.createElement(tx27);
                 		if(txv27.equals(""))
                 		params27.setTextContent("null");
                 		else
                 		params27.setTextContent(xPath1.evaluate(txv27, inputEvent1));
                 		outputEvent1.appendChild(params27);}
                 		
                 		if(!"null".equals(tx28)){
                 		Element params28=outdoc1.createElement(tx28);
                 		if(txv28.equals(""))
                 		params28.setTextContent("null");
                 		else
                 		params28.setTextContent(xPath1.evaluate(txv28, inputEvent1));
                 		outputEvent1.appendChild(params28);}
                 		
                 		if(!"null".equals(tx29)){
                 		Element params29=outdoc1.createElement(tx29);
                 		if(txv29.equals(""))
                 		params29.setTextContent("null");
                 		else
                 		params29.setTextContent(xPath1.evaluate(txv29, inputEvent1));
                 		outputEvent1.appendChild(params29);}
                 		
                 		if(!"null".equals(tx30)){
                 		Element params30=outdoc1.createElement(tx30);
                 		if(txv30.equals(""))
                 		params30.setTextContent("null");
                 		else
                 		params30.setTextContent(xPath1.evaluate(txv30, inputEvent1));
                 		outputEvent1.appendChild(params30);}
                     	outevent1.appendChild(outputEvent1);

               	  	       		
                 	}   
                      }
                      outdoc1.appendChild(outevent1); //the full formed mpulpy xml now in document
	                   Transformer transformer1=null;
	                   try {
	           			 transformer1=TransformerFactory.newInstance().newTransformer();
	           		} catch (TransformerConfigurationException e) {
	           			// TODO Auto-generated catch block
	           		} 
	           	 transformer1.setOutputProperty(OutputKeys.INDENT,"yes");
	           	 transformer1.setOutputProperty(OutputKeys.METHOD,"xml");

	           	 StreamResult result=new StreamResult(new StringWriter());
	                DOMSource source=new DOMSource(outdoc1);
	                try {
	            		transformer1.transform(source, result);  //transform mpulpy xml from document to xml string and make display in browser ->to send client(phonegap)
	            	} catch (TransformerException e) {
	            		e.printStackTrace();
	            	}
	                 Writer output=null;
	                // output=new BufferedWriter(new FileWriter("F:/workspace/mind.xml"));
	                 String xmloutput=result.getWriter().toString();
	                /* output.write(xmloutput);
	                 output.close();*/
	                out.println(xmloutput);
	                
            }
            }
        else if(eurl11.equals("4")){
        	String line="";
            while(rs3.next()){ // retrieve data from Database and join two tables namely(thrdconfig&thrdxmlconfig)
            	String thirdurl1=rs3.getString("fourthurl");String thirdcycle1=rs3.getString("fourthcycle"); String akt1=rs3.getString("alabel");String akt2=rs3.getString("akey");
            	 String thrdid=rs3.getString("fourth1"); String thrdval=rs3.getString("fourth2");
            	 String tp1=rs3.getString("f1"); String tpv1=rs3.getString("fv1");String tp2=rs3.getString("f2"); String tpv2=rs3.getString("fv2");
            	 String tp3=rs3.getString("f3"); String tpv3=rs3.getString("fv3");String tp4=rs3.getString("f4"); String tpv4=rs3.getString("fv4");
            	 String tp5=rs3.getString("f5"); String tpv5=rs3.getString("fv5");String tp6=rs3.getString("f6"); String tpv6=rs3.getString("fv6");
            	 String tp7=rs3.getString("f7"); String tpv7=rs3.getString("fv7");String tp8=rs3.getString("f8"); String tpv8=rs3.getString("fv8");
            	 String tp9=rs3.getString("f9"); String tpv9=rs3.getString("fv9");String tp10=rs3.getString("f10"); String tpv10=rs3.getString("fv10");
            	 String resf3=rs3.getString("resf3");
            	 //get from thirdxmlconfig
            	 String thrdparent=rs3.getString("fourthparent");String thrdroot=rs3.getString("fourthroot");
            	 String tx1=rs3.getString("fx1"); String txv1=rs3.getString("fxv1");String tx2=rs3.getString("fx2"); String txv2=rs3.getString("fxv2");
            	 String tx3=rs3.getString("fx3"); String txv3=rs3.getString("fxv3");String tx4=rs3.getString("fx4"); String txv4=rs3.getString("fxv4");
            	 String tx5=rs3.getString("fx5"); String txv5=rs3.getString("fxv5");String tx6=rs3.getString("fx6"); String txv6=rs3.getString("fxv6");
            	 String tx7=rs3.getString("fx7"); String txv7=rs3.getString("fxv7");String tx8=rs3.getString("fx8"); String txv8=rs3.getString("fxv8");
            	 String tx9=rs3.getString("fx9"); String txv9=rs3.getString("fxv9");String tx10=rs3.getString("fx10"); String txv10=rs3.getString("fxv10");
            	 String tx11=rs3.getString("fx11"); String txv11=rs3.getString("fxv11");String tx12=rs3.getString("fx12"); String txv12=rs3.getString("fxv12");
            	 String tx13=rs3.getString("fx13"); String txv13=rs3.getString("fxv13");String tx14=rs3.getString("fx14"); String txv14=rs3.getString("fxv14");
            	 String tx15=rs3.getString("fx15"); String txv15=rs3.getString("fxv15");String tx16=rs3.getString("fx16"); String txv16=rs3.getString("fxv16");
            	 String tx17=rs3.getString("fx17"); String txv17=rs3.getString("fxv17");String tx18=rs3.getString("fx18"); String txv18=rs3.getString("fxv18");
            	 String tx19=rs3.getString("fx19"); String txv19=rs3.getString("fxv19");String tx20=rs3.getString("fx20"); String txv20=rs3.getString("fxv20");
            	 String tx21=rs3.getString("fx21"); String txv21=rs3.getString("fxv21");String tx22=rs3.getString("fx22"); String txv22=rs3.getString("fxv22");
            	 String tx23=rs3.getString("fx23"); String txv23=rs3.getString("fxv23");String tx24=rs3.getString("fx24"); String txv24=rs3.getString("fxv24");
            	 String tx25=rs3.getString("fx25"); String txv25=rs3.getString("fxv25");String tx26=rs3.getString("fx26"); String txv26=rs3.getString("fxv26");
            	 String tx27=rs3.getString("fx27"); String txv27=rs3.getString("fxv27");String tx28=rs3.getString("fx28"); String txv28=rs3.getString("fxv28");
            	 String tx29=rs3.getString("fx29"); String txv29=rs3.getString("fxv29");String tx30=rs3.getString("fx30"); String txv30=rs3.getString("fxv30");
            	
            	Document doc1=null;  //TO Convert XMLSTRING TO DOCUMENT
                DocumentBuilder builder1=null;
                DocumentBuilderFactory domFactory1=DocumentBuilderFactory.newInstance();
                builder1=domFactory1.newDocumentBuilder();
                  	
                	
                    String thirdurl11=null;
                    String thrdjsonxmlout=null;
                    
                    
                   
                   	 if( resf3.equals("XML")){  //API XML get
                   		 

                   		 if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3) && !"null".equals(tp4) && !"null".equals(tp5) && !"null".equals(tp6)&& "entity".equals(thirdcycle1)){
                   		     thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+p1+"&"+tp2+"="+p2+"&"+tp3+"="+p3+"&"+tp4+"="+p4+"&"+tp5+"="+p5+"&"+tp6+"="+p6;}
                   		 
                   		 else if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3) && !"null".equals(tp4) && !"null".equals(tp5)&& "entity".equals(thirdcycle1)){
             	        		 thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+p1+"&"+tp2+"="+p2+"&"+tp3+"="+p3+"&"+tp4+"="+p4+"&"+tp5+"="+p5;}
                   		 
                   		 else if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3) && !"null".equals(tp4)&& "entity".equals(thirdcycle1)){
             	        		 thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+p1+"&"+tp2+"="+p2+"&"+tp3+"="+p3+"&"+tp4+"="+p4;}
                   		 
                   		 else if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3)&& "entity".equals(thirdcycle1)){
             	        		 thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+p1+"&"+tp2+"="+p2+"&"+tp3+"="+p3;}
                   		 
                   		 else if(!"null".equals(tp1) && !"null".equals(tp2)&& "entity".equals(thirdcycle1)){
             	        		 thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+p1+"&"+tp2+"="+p2;}
                   		 
                   		 else if(!"null".equals(tp1)&& "entity".equals(thirdcycle1)){
             	        		 thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+p1;}
                   		 
                   		 //else if(!"null".equals(thrdid)&& !"null".equals(thrdval) && "flow".equals(thirdcycle1)&&!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3)){
             	        	//	 thirdurl11=thirdurl1+"?"+oriapilabel+"="+oriapikey+"&"+prdid+"="+paid+"&"+tp1+"="+p1+"&"+tp2+"="+p2+"&"+tp3+"="+p3;}
                   		 
                   		// else if(!"null".equals(thrdid)&& !"null".equals(thrdval) && "flow".equals(thirdcycle1)&&!"null".equals(tp1) && !"null".equals(tp2)){
             	        	//	 thirdurl11=thirdurl1+"?"+oriapilabel+"="+oriapikey+"&"+prdid+"="+paid+"&"+tp1+"="+p1+"&"+tp2+"="+p2;}
                   		 
                   		// else if(!"null".equals(thrdid)&& !"null".equals(thrdval) && "flow".equals(thirdcycle1)&&!"null".equals(tp1)){
             	        	//	 thirdurl11=thirdurl1+"?"+oriapilabel+"="+oriapikey+"&"+prdid+"="+paid+"&"+tp1+"="+p1;}
                   		 
                   		 //else if(!"null".equals(thrdid)&& !"null".equals(thrdval) && "flow".equals(thirdcycle1))
                   			// thirdurl11=thirdurl1+"?"+oriapilabel+"="+oriapikey+"&"+prdid+"="+paid;
                   		
                   		 else if(!"null".equals(akt1) && !"null".equals(akt2)&& "entity".equals(thirdcycle1))
                   			      thirdurl11=thirdurl1+"?"+akt1+"="+akt2;
                   		 
                   		 else if("null".equals(akt1) && "null".equals(akt2))
                   			      thirdurl11=thirdurl1;
                   		 
                  		 doc1=builder1.parse(new URL(thirdurl11).openStream());

                   		
            	     
                   	 }//api keys and get	 
                   		
                   	if(resf3.equals("JSON")){  //API XML get
                  		 

                  		 if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3) && !"null".equals(tp4) && !"null".equals(tp5) && !"null".equals(tp6)&& "entity".equals(thirdcycle1)){
                  		     thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+p1+"&"+tp2+"="+p2+"&"+tp3+"="+p3+"&"+tp4+"="+p4+"&"+tp5+"="+p5+"&"+tp6+"="+p6;}
                  		 
                  		 else if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3) && !"null".equals(tp4) && !"null".equals(tp5)&& "entity".equals(thirdcycle1)){
            	        		 thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+p1+"&"+tp2+"="+p2+"&"+tp3+"="+p3+"&"+tp4+"="+p4+"&"+tp5+"="+p5;}
                  		 
                  		 else if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3) && !"null".equals(tp4)&& "entity".equals(thirdcycle1)){
            	        		 thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+p1+"&"+tp2+"="+p2+"&"+tp3+"="+p3+"&"+tp4+"="+p4;}
                  		 
                  		 else if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3)&& "entity".equals(thirdcycle1)){
            	        		 thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+p1+"&"+tp2+"="+p2+"&"+tp3+"="+p3;}
                  		 
                  		 else if(!"null".equals(tp1) && !"null".equals(tp2)&& "entity".equals(thirdcycle1)){
            	        		 thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+p1+"&"+tp2+"="+p2;}
                  		 
                  		 else if(!"null".equals(tp1)&& "entity".equals(thirdcycle1)){
            	        		 thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+p1;}
                  		 
                  		// else if(!"null".equals(thrdid)&& !"null".equals(thrdval) && "flow".equals(thirdcycle1)&&!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3)){
            	        	//	 thirdurl11=thirdurl1+"?"+oriapilabel+"="+oriapikey+"&"+prdid+"="+paid+"&"+tp1+"="+p1+"&"+tp2+"="+p2+"&"+tp3+"="+p3;}
                  		 
                  		 //else if(!"null".equals(thrdid)&& !"null".equals(thrdval) && "flow".equals(thirdcycle1)&&!"null".equals(tp1) && !"null".equals(tp2)){
            	        	//	 thirdurl11=thirdurl1+"?"+oriapilabel+"="+oriapikey+"&"+thrdid+"="+paid+"&"+tp1+"="+p1+"&"+tp2+"="+p2;}
                  		 
                  		 //else if(!"null".equals(thrdid)&& !"null".equals(thrdval) && "flow".equals(thirdcycle1)&&!"null".equals(tp1)){
            	        	//	 thirdurl11=thirdurl1+"?"+oriapilabel+"="+oriapikey+"&"+thrdid+"="+paid+"&"+tp1+"="+p1;}
                  		 
                  		 //else if(!"null".equals(thrdid)&& !"null".equals(thrdval) && "flow".equals(thirdcycle1))
                  			// thirdurl11=thirdurl1+"?"+oriapilabel+"="+oriapikey+"&"+thrdid+"="+paid;
                  		
                  		 else if(!"null".equals(akt1) && !"null".equals(akt2)&& "entity".equals(thirdcycle1))
                  			      thirdurl11=thirdurl1+"?"+akt1+"="+akt2;
                  		 
                  		 else if("null".equals(akt1) && "null".equals(akt2))
                  			      thirdurl11=thirdurl1;
                  		 

                  		URL third=new URL(thirdurl11);
          		        URLConnection uconn = third.openConnection();
          	            HttpURLConnection conn = (HttpURLConnection) uconn;
          	            conn.connect();
          	            Object content = conn.getContent();
          	            InputStream stream = (InputStream) content;
          	            BufferedReader in=new BufferedReader(new InputStreamReader(stream));
          	           while ((line = in.readLine()) != null)    { 		  
           	       JSON json = JSONSerializer.toJSON( line );  
        	           XMLSerializer xmlSerializer = new XMLSerializer();  
        	           xmlSerializer.setTypeHintsEnabled(false);
        	           xmlSerializer.setSkipWhitespace(true);
        	           xmlSerializer.setTrimSpaces(true);
        	           xmlSerializer.setRemoveNamespacePrefixFromElements(true);
        	           xmlSerializer.removeNamespace(line);
        	           xmlSerializer.setForceTopLevelObject(false);
        		       thrdjsonxmlout = xmlSerializer.write( json );

          	              }
          	     // end-while 
        	    	  	  doc1= builder1.parse(new InputSource(new ByteArrayInputStream(thrdjsonxmlout.getBytes("UTF-8")))); 

           	     
                  	 
                       	
                    }


             	     Document outdoc1=DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
             		 Element outevent1=outdoc1.createElement("MPulpy");
             		 NodeList inevent1=null;
             		 XPath xPath1=XPathFactory.newInstance().newXPath();
             		 inevent1=(NodeList) xPath1.evaluate("//"+thrdparent,doc1,XPathConstants.NODESET); //using XPATH to simply xml from third party server
                      if(inevent1!=null){
               	  
                 	for(int i=0;i<inevent1.getLength();i++){
                 		Element outputEvent1=outdoc1.createElement("root"); // create mpulpy xml here
                 		Node inputEvent1=inevent1.item(i);
                 		       
                 	    if(!"null".equals(tx1)){   //validation for not return null tag
                 		Element params1=outdoc1.createElement(tx1);  //create element
                       if(txv1.equals(""))
                 		params1.setTextContent("null");
                 		else
                 		params1.setTextContent(xPath1.evaluate(txv1, inputEvent1)); // map our xml with third party server xml
                 		outputEvent1.appendChild(params1);}
                 		
                 		if(!"null".equals(tx2)){
                   		Element params2=outdoc1.createElement(tx2);
                       if(txv2.equals(""))
                 		params2.setTextContent("null");
                 		else
                 		params2.setTextContent(xPath1.evaluate(txv2, inputEvent1));
                 		outputEvent1.appendChild(params2);}
                 		
                 		if(!"null".equals(tx3)){
                 		Element params3=outdoc1.createElement(tx3);
                          if(txv3.equals(""))
                 		params3.setTextContent("null");
                 		else
                 		params3.setTextContent(xPath1.evaluate(txv3, inputEvent1));
                 		outputEvent1.appendChild(params3);}
                 		
                 		if(!"null".equals(tx4)){
                 		Element params4=outdoc1.createElement(tx4);
                         if(txv4.equals(""))
                 		params4.setTextContent("null");
                 		else
                 		params4.setTextContent(xPath1.evaluate(txv4, inputEvent1));
                 		outputEvent1.appendChild(params4);}
                 		
             		    if(!"null".equals(tx5)){
                     	Element params5=outdoc1.createElement(tx5);
                       if(txv5.equals(""))
                 		params5.setTextContent("null");
                 		else
                 		params5.setTextContent(xPath1.evaluate(txv5, inputEvent1));
                 		outputEvent1.appendChild(params5);}
                 		
                 		if(!"null".equals(tx6)){
                 		Element params6=outdoc1.createElement(tx6);
                       if(txv6.equals(""))
                 		params6.setTextContent("null");
                 		else
                 		params6.setTextContent(xPath1.evaluate(txv6, inputEvent1));
                 		outputEvent1.appendChild(params6);}
                 		
                 		if(!"null".equals(tx7)){
                 		Element params7=outdoc1.createElement(tx7);
                 		if(txv7.equals(""))
                 		params7.setTextContent("");
                 		else
                 		params7.setTextContent(xPath1.evaluate(txv7, inputEvent1));
                 		outputEvent1.appendChild(params7);}
                 		
                 		if(!"null".equals(tx8)){
                 		Element params8=outdoc1.createElement(tx8);
                 		if(txv8.equals(""))
                 		params8.setTextContent("");
                 		else
                 		params8.setTextContent(xPath1.evaluate(txv8, inputEvent1));
                 		outputEvent1.appendChild(params8);}
                 		
                 		if(!"null".equals(tx9)){
                 		Element params9=outdoc1.createElement(tx9);
                 		if(txv9.equals(""))
                 		params9.setTextContent("");
                 		else
                 		params9.setTextContent(xPath1.evaluate(txv9, inputEvent1));
                 		outputEvent1.appendChild(params9);}
                 		
                 		if(!"null".equals(tx10)){
                 		Element params10=outdoc1.createElement(tx10);
                 		if(txv10.equals(""))
                 		params10.setTextContent("null");
                 		else
                 		params10.setTextContent(xPath1.evaluate(txv10, inputEvent1));
                 		outputEvent1.appendChild(params10);}
                 		
                 		if(!"null".equals(tx11)){
                 		Element params11=outdoc1.createElement(tx11);
                 		if(txv11.equals(""))
                 		params11.setTextContent("null");
                 		else
                 		params11.setTextContent(xPath1.evaluate(txv11, inputEvent1));
                 		outputEvent1.appendChild(params11);}
                 		
                 		if(!"null".equals(tx12)){
                 		Element params12=outdoc1.createElement(tx12);
                 		if(txv12.equals(""))
                 		params12.setTextContent("null");
                 		else
                 		params12.setTextContent(xPath1.evaluate(txv12, inputEvent1));
                 		outputEvent1.appendChild(params12);}
                 		
                 		if(!"null".equals(tx13)){
                 		Element params13=outdoc1.createElement(tx13);
                 		if(txv13.equals(""))
                 		params13.setTextContent("null");
                 		else
                 		params13.setTextContent(xPath1.evaluate(txv13, inputEvent1));
                 		outputEvent1.appendChild(params13);}
                 		
                 		if(!"null".equals(tx14)){
                 		Element params14=outdoc1.createElement(tx14);
                 		if(txv14.equals(""))
                 		params14.setTextContent("null");
                 		else
                 		params14.setTextContent(xPath1.evaluate(txv14, inputEvent1));
                 		outputEvent1.appendChild(params14);}
                 		
                 		if(!"null".equals(tx15)){
                 		Element params15=outdoc1.createElement(tx15);
                 		if(txv15.equals(""))
                 		params15.setTextContent("null");
                 		else
                 		params15.setTextContent(xPath1.evaluate(txv15, inputEvent1));
                 		outputEvent1.appendChild(params15);}
                 		
                 		if(!"null".equals(tx16)){
                 		Element params16=outdoc1.createElement(tx16);
                 		if(txv16.equals(""))
                 		params16.setTextContent("null");
                 		else
                 		params16.setTextContent(xPath1.evaluate(txv16, inputEvent1));
                 		outputEvent1.appendChild(params16);}
                 		
                 		if(!"null".equals(tx17)){
                 		Element params17=outdoc1.createElement(tx17);
                 		if(txv17.equals(""))
                 		params17.setTextContent("null");
                 		else
                 		params17.setTextContent(xPath1.evaluate(txv17, inputEvent1));
                 		outputEvent1.appendChild(params17);}
                 		
                 		if(!"null".equals(tx18)){
                 		Element params18=outdoc1.createElement(tx18);
                 		if(txv18.equals(""))
                 		params18.setTextContent("null");
                 		else
                 		params18.setTextContent(xPath1.evaluate(txv18, inputEvent1));
                 		outputEvent1.appendChild(params18);}
                 		
                 		if(!"null".equals(tx19)){
                 		Element params19=outdoc1.createElement(tx19);
                 		if(txv19.equals(""))
                 		params19.setTextContent("null");
                 		else
                 		params19.setTextContent(xPath1.evaluate(txv19, inputEvent1));
                 		outputEvent1.appendChild(params19);}
                 		
                 		if(!"null".equals(tx20)){
                 		Element params20=outdoc1.createElement(tx20);
                 		if(txv20.equals(""))
                 		params20.setTextContent("null");
                 		else
                 		params20.setTextContent(xPath1.evaluate(txv20, inputEvent1));
                 		outputEvent1.appendChild(params20);}
                 		
                 		
                 		if(!"null".equals(tx21)){
                 		Element params21=outdoc1.createElement(tx21);
                 		if(txv21.equals(""))
                 		params21.setTextContent("null");
                 		else
                 		params21.setTextContent(xPath1.evaluate(txv21, inputEvent1));
                 		outputEvent1.appendChild(params21);}
                 		
                 		if(!"null".equals(tx22)){
                 		Element params22=outdoc1.createElement(tx22);
                 		if(txv22.equals(""))
                 		params22.setTextContent("null");
                 		else
                 		params22.setTextContent(xPath1.evaluate(txv22, inputEvent1));
                 		outputEvent1.appendChild(params22);}
                 		
                 		if(!"null".equals(tx23)){
                 		Element params23=outdoc1.createElement(tx23);
                 		if(txv23.equals(""))
                 		params23.setTextContent("null");
                 		else
                 		params23.setTextContent(xPath1.evaluate(txv23, inputEvent1));
                 		outputEvent1.appendChild(params23);}
                 		
                 		if(!"null".equals(tx24)){
                 		Element params24=outdoc1.createElement(tx24);
                 		if(txv24.equals(""))
                 		params24.setTextContent("null");
                 		else
                 		params24.setTextContent(xPath1.evaluate(txv24, inputEvent1));
                 		outputEvent1.appendChild(params24);}
                 		
                 		if(!"null".equals(tx25)){
                 		Element params25=outdoc1.createElement(tx25);
                 		if(txv25.equals(""))
                 		params25.setTextContent("null");
                 		else
                 		params25.setTextContent(xPath1.evaluate(txv25, inputEvent1));
                 		outputEvent1.appendChild(params25);}
                 		
                 		if(!"null".equals(tx26)){
                 		Element params26=outdoc1.createElement(tx26);
                 		if(txv26.equals(""))
                 		params26.setTextContent("null");
                 		else
                 		params26.setTextContent(xPath1.evaluate(txv26, inputEvent1));
                 		outputEvent1.appendChild(params26);}
                 		
                 		if(!"null".equals(tx27)){
                 		Element params27=outdoc1.createElement(tx27);
                 		if(txv27.equals(""))
                 		params27.setTextContent("null");
                 		else
                 		params27.setTextContent(xPath1.evaluate(txv27, inputEvent1));
                 		outputEvent1.appendChild(params27);}
                 		
                 		if(!"null".equals(tx28)){
                 		Element params28=outdoc1.createElement(tx28);
                 		if(txv28.equals(""))
                 		params28.setTextContent("null");
                 		else
                 		params28.setTextContent(xPath1.evaluate(txv28, inputEvent1));
                 		outputEvent1.appendChild(params28);}
                 		
                 		if(!"null".equals(tx29)){
                 		Element params29=outdoc1.createElement(tx29);
                 		if(txv29.equals(""))
                 		params29.setTextContent("null");
                 		else
                 		params29.setTextContent(xPath1.evaluate(txv29, inputEvent1));
                 		outputEvent1.appendChild(params29);}
                 		
                 		if(!"null".equals(tx30)){
                 		Element params30=outdoc1.createElement(tx30);
                 		if(txv30.equals(""))
                 		params30.setTextContent("null");
                 		else
                 		params30.setTextContent(xPath1.evaluate(txv30, inputEvent1));
                 		outputEvent1.appendChild(params30);}
                     	outevent1.appendChild(outputEvent1);

               	  	       		
                 	}   
                      }
                      outdoc1.appendChild(outevent1); //the full formed mpulpy xml now in document
	                   Transformer transformer1=null;
	                   try {
	           			 transformer1=TransformerFactory.newInstance().newTransformer();
	           		} catch (TransformerConfigurationException e) {
	           			// TODO Auto-generated catch block
	           		} 
	           	 transformer1.setOutputProperty(OutputKeys.INDENT,"yes");
	           	 transformer1.setOutputProperty(OutputKeys.METHOD,"xml");

	           	 StreamResult result=new StreamResult(new StringWriter());
	                DOMSource source=new DOMSource(outdoc1);
	                try {
	            		transformer1.transform(source, result);  //transform mpulpy xml from document to xml string and make display in browser ->to send client(phonegap)
	            	} catch (TransformerException e) {
	            		e.printStackTrace();
	            	}
	                 Writer output=null;
	                // output=new BufferedWriter(new FileWriter("F:/workspace/mind.xml"));
	                 String xmloutput=result.getWriter().toString();
	                /* output.write(xmloutput);
	                 output.close();*/
	                out.println(xmloutput);
	                
            }
            }
		}
		catch(Exception e){out.println(e);}
	}

}
