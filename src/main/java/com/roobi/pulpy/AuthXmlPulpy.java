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
import org.apache.http.entity.StringEntity;
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
public class AuthXmlPulpy extends HttpServlet {
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

		response.setHeader("Content-Type","text/xml; charset=UTF-8");
	    response.addHeader("Access-Control-Allow-Origin", "*");  		
	    Connection con=null;
		 HttpSession session=request.getSession(true);
		 // String appid=(String) session.getAttribute("xx"); 
			String appid=request.getParameter("appid");
		//String eurl11=request.getParameter("eurl");
		String pid=request.getParameter("pid");
		String p1=request.getParameter("p1");String p2=request.getParameter("p2");
		String p3=request.getParameter("p3");String p4=request.getParameter("p4");
		String p5=request.getParameter("p5");String p6=request.getParameter("p6");
		String p7=request.getParameter("p7");String p8=request.getParameter("p8");
        String p9=request.getParameter("p9");String p10=request.getParameter("p10");
        String j1=request.getParameter("j1"); String jv1=request.getParameter("jv1");
        String j2=request.getParameter("j2"); String jv2=request.getParameter("jv2");
        String j3=request.getParameter("j3"); String jv3=request.getParameter("jv3");
        String j4=request.getParameter("j4"); String jv4=request.getParameter("jv4");
        String j5=request.getParameter("j5"); String jv5=request.getParameter("jv5");
        String j6=request.getParameter("j6"); String jv6=request.getParameter("jv6");
        String j7=request.getParameter("j7"); String jv7=request.getParameter("jv7");
        String j8=request.getParameter("j8"); String jv8=request.getParameter("jv8");
        String j9=request.getParameter("j9"); String jv9=request.getParameter("jv9");
        
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
	     String access_token=rs.getString("extoken");
            String rm1=rs.getString("rm");

        	String resf1=rs.getString("resf");String endurl1=rs.getString("endurl");
             String mname=rs.getString("baseurl");
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
	        		 
	             eurl=eurl.replaceAll(" ","%20");
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
		        	     while ((line = br.readLine()) != null)    { 		  
		         	      JSON json = JSONSerializer.toJSON( line );  
		     	          XMLSerializer xmlSerializer = new XMLSerializer();  
		     	          xmlSerializer.setTypeHintsEnabled(false);
		     	          xmlSerializer.setSkipWhitespace(true);
		     	          xmlSerializer.setTrimSpaces(true);
		     	          xmlSerializer.setRemoveNamespacePrefixFromElements(true);
		     	          xmlSerializer.removeNamespace(line);
		     	          xmlSerializer.setForceTopLevelObject(false);
		     		      jsonxmlout = xmlSerializer.write( json );

		        	     }	      // end-while  	
			               doc= builder.parse(new InputSource(new ByteArrayInputStream(jsonxmlout.getBytes("UTF-8"))));

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
				               //doc= builder.parse(new InputSource(new ByteArrayInputStream(str.getBytes("UTF-8"))));
			                 PrintWriter out=response.getWriter();
			                 out.println(str);

		        		 } //if
		        		 }//try
		         	     catch(Exception e){
		 	    	     // out.println(e);}	
		         	 	// out.println(str); 	       		     

	        	 }//post 
	        	 
	        		 
	        		 
	        		 
	        	 
	         } // Main END of API Keys
       
       
       //Basic Authentication
       
       
       
       
	         else if(authen1.equals("Basic Auth")){ //m15
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
	        	 
        		 else if("null".equals(pa1))
        			eurl="";
	        	 
	        	 
		          if(rm1.equals("GET")){ 
		        	  
		        	  try{
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
	            	 }
	            	 else if(!"null".equals(b4) && "null".equals(b2)){encoding = new String(
        		 org.apache.commons.codec.binary.Base64.encodeBase64   
     		    (org.apache.commons.codec.binary.StringUtils.getBytesUtf8(""+":"+b4))
     		  );}
	            	 else if(!"null".equals(b2) && !"null".equals(b4)){
	            		 encoding = new String(
	                    		 org.apache.commons.codec.binary.Base64.encodeBase64   
	                    		    (org.apache.commons.codec.binary.StringUtils.getBytesUtf8(b2+":"+b4))
	                    		  );
	   	            	 } // else if encoding
	              connection.setRequestProperty  ("Authorization", "Basic " + encoding);
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
		          }//try
		          catch(Exception e){  //out.println(e);
		          }
		          }
		          }//get
		          
		          
	              else if(rm1.equals("POST")){ 
	            	  try{
	            	  URL url1 = new URL (endurl1);
	            	  HttpURLConnection connection = (HttpURLConnection) url1.openConnection();
	                  connection.setDoOutput(true);
	                  connection.setDoInput(true);
		              connection.setRequestMethod("POST");

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
	            	 }
	            	 else if(!"null".equals(b4) && "null".equals(b2)){encoding = new String(
           		 org.apache.commons.codec.binary.Base64.encodeBase64   
        		    (org.apache.commons.codec.binary.StringUtils.getBytesUtf8(""+":"+b4))
        		  );}
	            	 else if(!"null".equals(b2) && !"null".equals(b4)){
	            		 encoding = new String(
	                    		 org.apache.commons.codec.binary.Base64.encodeBase64   
	                    		    (org.apache.commons.codec.binary.StringUtils.getBytesUtf8(b2+":"+b4))
	                    		  );
	   	            	 } // else if encoding
	              connection.setRequestProperty  ("Authorization", "Basic " + encoding);
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
                  
                // String line=null;
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
		     		      //out.println(xmlout);
	            	  }  }//while
		               doc= builder.parse(new InputSource(new ByteArrayInputStream(str.getBytes("UTF-8"))));

	           
	                            
	                	
	              } //  try
	              
	   	             catch(Exception e){  //out.println(e);
	   	             }
	   	          
	         } //post
	              else if(rm1.equals("POST_JSON")){
		            	 // out.println("inside");
		            		  DefaultHttpClient httpClient = new DefaultHttpClient();
		            			HttpPost postRequest = new HttpPost(endurl1);
		            			if(j1!=null && j2!=null && j3!=null && j4!=null && j5!=null && j6!=null && j7!=null && j8!=null ){
				         			StringEntity input = new StringEntity("{\""+j1+"\":\""+jv1+"\",\""+j2+"\":\""+jv2+"\",\""+j3+"\":\""+jv3+"\",\""+j4+"\":\""+jv4+"\",\""+j5+"\":\""+jv5+"\",\""+j6+"\":\""+jv6+"\",\""+j7+"\":\""+jv7+"\",\""+j8+"\":\""+jv8+"\"}");
				         			input.setContentType("application/json");
				         			postRequest.setEntity(input);}
		            			else if(j1!=null && j2!=null && j3!=null && j4!=null && j5!=null && j6!=null && j7!=null ){
				         			StringEntity input = new StringEntity("{\""+j1+"\":\""+jv1+"\",\""+j2+"\":\""+jv2+"\",\""+j3+"\":\""+jv3+"\",\""+j4+"\":\""+jv4+"\",\""+j5+"\":\""+jv5+"\",\""+j6+"\":\""+jv6+"\",\""+j7+"\":\""+jv7+"\"}");
				         			input.setContentType("application/json");
				         			postRequest.setEntity(input);}
		            			else if(j1!=null && j2!=null && j3!=null && j4!=null && j5!=null && j6!=null ){
				         			StringEntity input = new StringEntity("{\""+j1+"\":\""+jv1+"\",\""+j2+"\":\""+jv2+"\",\""+j3+"\":\""+jv3+"\",\""+j4+"\":\""+jv4+"\",\""+j5+"\":\""+jv5+"\",\""+j6+"\":\""+jv6+"\"}");
				         			input.setContentType("application/json");
				         			postRequest.setEntity(input);}
		            			else if(j1!=null && j2!=null && j3!=null && j4!=null && j5!=null){
				         			StringEntity input = new StringEntity("{\""+j1+"\":\""+jv1+"\",\""+j2+"\":\""+jv2+"\",\""+j3+"\":\""+jv3+"\",\""+j4+"\":\""+jv4+"\",\""+j5+"\":\""+jv5+"\"}");
				         			input.setContentType("application/json");
				         			postRequest.setEntity(input);}
		            			else if(j1!=null && j2!=null && j3!=null && j4!=null){
				         			StringEntity input = new StringEntity("{\""+j1+"\":\""+jv1+"\",\""+j2+"\":\""+jv2+"\",\""+j3+"\":\""+jv3+"\",\""+j4+"\":\""+jv4+"\"}");
				         			input.setContentType("application/json");
				         			postRequest.setEntity(input);} // */
		            			else if(j1!=null && j2!=null && j3!=null ){
		            				StringEntity input = new StringEntity("{\""+j1+"\":\""+jv1+"\",\""+j2+"\":\""+jv2+"\",\""+j3+"\":\""+jv3+"\"}");
			            		   input.setContentType("application/json");
			            		   postRequest.setEntity(input); }
			         		 
			         		 else if(j1!=null && j2!=null){
			         			StringEntity input = new StringEntity("{\""+j1+"\":\""+jv1+"\",\""+j2+"\":\""+jv2+"\"}");
			         			input.setContentType("application/json");
			         			postRequest.setEntity(input);}
			         		 else if(j1!=null){
			         			StringEntity input = new StringEntity("{\""+j1+"\":\""+jv1+"\"}");
			         			input.setContentType("application/json");
			         			postRequest.setEntity(input);}
			            	   
			            	   String encoding = new String(
			          		   		 org.apache.commons.codec.binary.Base64.encodeBase64   
			          		   		    (org.apache.commons.codec.binary.StringUtils.getBytesUtf8(b2+":"+b4))
			          		   		  );
			          		postRequest.setHeader("Authorization","Basic " + encoding);
		            			
		            	 
		            			HttpResponse response1 = httpClient.execute(postRequest);
		            	 
		            			BufferedReader in = new BufferedReader(
		            	                        new InputStreamReader((response1.getEntity().getContent())));
		            		 line="";
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
		    		     		      //out.println(xmlout);
		    	            	  }}//while
		            			httpClient.getConnectionManager().shutdown();
		            			doc= builder.parse(new InputSource(new ByteArrayInputStream(str.getBytes("UTF-8"))));
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
	                 PrintWriter out=response.getWriter();
	                 out.println(xmloutput);
	              	
        }//while
       
        	
		}
		catch(Exception e){}
	}

}
