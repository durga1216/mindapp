package com.roobi.pulpy;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.converters.FileConverter;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.PostMethod;

import net.sf.json.JSON;
import net.sf.json.JSONSerializer;
import net.sf.json.xml.XMLSerializer;
public class FirstPulpy extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Connection con=null;

       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String pname=request.getParameter("t1");
		String kname=request.getParameter("t3");
		String api=request.getParameter("t4");
		String select=request.getParameter("select1");
		String sur=request.getParameter("t2");
		String p1=request.getParameter("t5");
		String pv1=request.getParameter("t8");
		String p2=request.getParameter("t6");
		String pv2=request.getParameter("t9");

		
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://127.6.250.130:3306/mpulpy";
       final String USER = "adminPQ1iFfN";
           final String PASS = "J5JhBL-XC9NG";
            con = DriverManager.getConnection(url,USER,PASS);
            PreparedStatement st=null;
			 st=con.prepareStatement("insert into Table1(ename,Key_Name,API_KEY,method,surl,p1,pv1,p2,pv2) values ('"+pname+"','"+kname+"','"+api+"','"+select+"','"+sur+"','"+p1+"','"+pv1+"','"+p2+"','"+pv2+"')");
		    /* st.setString(1, pname);
		     st.setString(2,ur);
		     st.setString(3, api);*/
		    st.executeUpdate();
		     st.close();
		     st=con.prepareStatement("SELECT id,Key_Name,API_KEY,surl,p1,p2,method,pv1,pv2 From Table1 ORDER BY ID DESC LIMIT 1");
	         ResultSet rs = st.executeQuery();
	         while(rs.next()){
             String appid=rs.getString("id");
             String kname1=rs.getString("Key_Name");
             String akey=rs.getString("API_KEY");
             String url1=rs.getString("surl");
             String pa1=rs.getString("p1");
             String pa2=rs.getString("p2");
             String mename=rs.getString("method");
             String pva1=rs.getString("pv1");
             String pva2=rs.getString("pv2");
             
             HttpSession session=request.getSession(true);
             session.setAttribute("id", appid);
	         
		    String purl=null;
               URL url2=null;   
				 purl=url1+"?"+kname1+"="+akey+"&"+pa1+"="+pv1+"&"+pa2+"="+pv2;
     
		 if(request.getParameter("first")!=null)
	{
				 if("GET".equals(select))
				 {
					 purl="http://api.trulia.com/webservices.php?library=LocationInfo&function=getCitiesInState&state=CA&apikey=623ujm9dasvca8yq8c4dtt7x";
				// purl=url1+"?"+kname1+"="+akey+"&"+pa1+"="+pv1+"&"+pa2+"="+pv2;
				 System.out.println(purl);
				 url2=new URL(purl);
				 URLConnection uconn = url2.openConnection();
                 BufferedReader in = new BufferedReader(new InputStreamReader(uconn.getInputStream()));
     		     String line=null;
     	          PrintWriter pw=new PrintWriter("F:/workspace/MindPulpy1/WebContent/sam.xml");
             	   while ((line = in.readLine()) != null) {
	       		     pw.write(line);
	       		     pw.flush();

	                                                                
				 }	
             	Runtime.getRuntime().exec("notepad F:/workspace/MindPulpy1/WebContent/sam.xml");
				 pw.close();
				 in.close();
				 }// nested if
				 else if("POST".equals(select))
				 {
					 purl=url1;
					 url2=new URL(purl);
					 URLConnection uconn=url2.openConnection();
					 uconn.setDoOutput(true);
	             	 OutputStreamWriter writer = new OutputStreamWriter(uconn.getOutputStream());
	                 writer.write(kname1+"="+akey+"&"+pa1+"="+pv1+"&"+pa2+"="+pv2);
	             	 writer.flush();
	             	 BufferedReader reader = new BufferedReader(new InputStreamReader(uconn.getInputStream()));
	             	 String line=null;
	         		 FileWriter fw=new FileWriter("F:/workspace/MindPulpy1/WebContent/sam.xml");
	             	 while ((line = reader.readLine()) != null) {
	       		     fw.write(line);
	       		     fw.flush();
	                                                                }
				 fw.close();
				 reader.close();
				 writer.close();
				 } //else if
				 
				 else if("XML REQUEST".equals(select)){
					  
					 HttpClient client =null;
				        PostMethod method =null;
						String airurl=url1;
						String response1 = "";
						String request_str = "<AvailRequest><Trip>ONE</Trip><Origin>BOM</Origin><Destination>DEL</Destination><DepartDate>2014-05-05</DepartDate><ReturnDate>2014-05-05</ReturnDate><AdultPax>1</AdultPax><ChildPax>0</ChildPax><InfantPax>0</InfantPax><Currency>INR</Currency><PreferredClass>E</PreferredClass><Eticket>true</Eticket><Clientid>77743613</Clientid><Clientpassword>*8DC945BE945EF739F56B6A5B5C5A48440B006F7A</Clientpassword><Clienttype>ArzooINTLWS1.0</Clienttype><PreferredAirline></PreferredAirline></AvailRequest>";
						MultiThreadedHttpConnectionManager connmngr=null;
						connmngr = new MultiThreadedHttpConnectionManager();
						client = new HttpClient(connmngr);
						method = new PostMethod( airurl );
						method.addParameter("xmlRequest",request_str);
						client.executeMethod( method );
						response1=method.getResponseBodyAsString();
						//out.println(response1);
						String line=null;
						BufferedReader re=new BufferedReader(new StringReader(response1));
						 FileWriter fw=new FileWriter("F:/workspace/MindPulpy1/WebContent/sam.xml");
				     	 while ((line = re.readLine()) != null) {
				   		     fw.write(line);
				   		     fw.flush();
				                                                          
						 }	
				     	 fw.close();
				     	Runtime.getRuntime().exec("notepad sam.xml");
				 }
				 
                 else if("SOAP REQUEST".equals(select)){
					 
				 }
				 
                 else if("HTTPS USERNAME AND PWD".equals(select)){
					 
				 }
		 		// Runtime.getRuntime().exec("notepad sam.xml");
     			 out.println("<h2><center><font color='green'>Processing...</font></center></h3>");
				 response.setHeader("Refresh", "1; URL=test.jsp");

	} // Main IF
			 
			 else if(request.getParameter("second")!=null)
	{
		     if("GET".equals(select))
		     {
		    	// purl="http://api.gifts.com/v2/search/criteria/category.json?api_key=u9zwp9hjd3dez59sz8r6fsj4";
		     purl=url1;
		    	 // purl=url1+"?"+kname1+"="+akey+"&"+pa1+"="+pv1+"&"+pa2+"="+pv2;
			  url2 = new URL(purl);
			  URLConnection uconn = url2.openConnection();
              BufferedReader in = new BufferedReader(new InputStreamReader(uconn.getInputStream()));
     		  String line=null;
     		  FileWriter fw=null;
     		 while ((line = in.readLine()) != null)    { 		  
     			 JSON json = JSONSerializer.toJSON( line );  
 	          XMLSerializer xmlSerializer = new XMLSerializer();  
 	          xmlSerializer.setTypeHintsEnabled(false);
 	          xmlSerializer.setSkipWhitespace(true);
 	          xmlSerializer.setTrimSpaces(true);
 	          xmlSerializer.setRemoveNamespacePrefixFromElements(true);
 	          xmlSerializer.removeNamespace(line);
 	          xmlSerializer.setForceTopLevelObject(false);
 		      String  xmlout = xmlSerializer.write( json );
			  fw=new FileWriter("F:/workspace/sam.xml");
			  fw.write(xmlout);
			 // fw.flush();
		     }
			  fw.close();
		     }// nested-if
		     else if("POST".equals(select)){
		    	 purl=url1;
		    	 url2=new URL(purl);
		    	 URLConnection uconn=url2.openConnection();
		    	 uconn.setDoOutput(true);
				 OutputStreamWriter writer=new OutputStreamWriter(uconn.getOutputStream());
				 writer.write(kname1+"="+akey+"&"+pa1+"="+pv1+"&"+pa2+"="+pv2);
             	 writer.flush();
		    	 BufferedReader reader=new BufferedReader(new InputStreamReader(uconn.getInputStream()));

				 String line=null;
    		      FileWriter fw=new FileWriter("F:/workspace/MindPulpy1/WebContent/sam.xml");

				 while ((line = reader.readLine()) != null) {
	                   JSON json = JSONSerializer.toJSON( line );  
	     	           XMLSerializer xmlSerializer = new XMLSerializer();  
	     	           xmlSerializer.setTypeHintsEnabled(false);
	     	           xmlSerializer.setSkipWhitespace(true);
	     	           xmlSerializer.setTrimSpaces(true);
	     	           xmlSerializer.setRemoveNamespacePrefixFromElements(true);
	     	           xmlSerializer.removeNamespace(line);
	     	           xmlSerializer.setForceTopLevelObject(false);
	     		       String  xmlout = xmlSerializer.write( json );
	 				   fw.write(xmlout);
	 				   fw.flush();
	             	    } //while
             	 
 				 fw.close();
 				 reader.close();
 				 writer.close();
               
		     }  // else -if
		     else if("HTTPS USERNAME AND PWD".equals(select)){
				 
			 }
	 		// Runtime.getRuntime().exec("notepad sam.xml");
			 out.println("<h2><center><font color='green'>Processing...</font></center></h3>");

		     response.setHeader("Refresh", "1; URL=test.jsp");

			 } //Main else if*/
		} //rs while
	         
		//try
	             
		
		}
	
		catch(Exception e){
			out.println(e);
		}
     

} //post
		} //class
