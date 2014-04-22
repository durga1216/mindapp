package com.roobi.pulpy;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSON;
import net.sf.json.JSONSerializer;
import net.sf.json.xml.XMLSerializer;
public class TicketPulpy extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public TicketPulpy() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
        HttpSession session=request.getSession(true);
		String appid=(String) session.getAttribute("id");
		String burl=request.getParameter("t1");
		String tp=request.getParameter("tp");
		String tv=request.getParameter("tv");
		
		Connection con=null;
		try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://127.6.250.130:3306/mpulpy";
       final String USER = "adminPQ1iFfN";
           final String PASS = "J5JhBL-XC9NG";
            con = DriverManager.getConnection(url,USER,PASS);
            PreparedStatement st=con.prepareStatement("insert into tab4(id,burl,tp,tv) values ('"+appid+"','"+burl+"','"+tp+"','"+tv+"')");                
            st.executeUpdate();
            out.println("Insert Success");
            st=con.prepareStatement("SELECT * From tab4 ta4 JOIN table1 t1 ON  ta4.id=t1.id where ta4.id=?");
            st.setString(1, appid);

	        ResultSet rs = st.executeQuery();
	        while(rs.next()){
	        	String burl1=rs.getString("burl");
	        	 String kname1=rs.getString("Key_Name");
	        	 String akey=rs.getString("API_KEY");
	             String pa1=rs.getString("tp");
	             String pv1=rs.getString("tv");
	             String purl=null;
	             URL url2=null;
	             String mename=rs.getString("method");
	             if(request.getParameter("first")!=null)
	         	{
	         				 if(mename.equals("get")|| mename.equals("GET"))
	         				 {
	         					 purl=burl1;
	         				 //purl=burl1+"?"+kname1+"="+akey+"&"+pa1+"="+pv1;
	         				 url2=new URL(purl);
	         				 URLConnection uconn = url2.openConnection();
	                          BufferedReader in = new BufferedReader(new InputStreamReader(uconn.getInputStream()));
	              		     String line=null;
	              		     FileWriter fw=null;
	              		    
	              		     fw=new FileWriter("F:/workspace/MindPulpy1/WebContent/book.xml");
	                      	 while ((line = in.readLine()) != null) {
	         	       		     fw.write(line);
	         	       		     fw.flush();
	                      	 }                                                  
	         				 
	         				 fw.close();
	         		 		//  Runtime.getRuntime().exec("notepad F:/workspace/MindPulpy1/WebContent/book.xml");
   
	              		     
	         				 }// nested if
	         				 else if(mename.equals("post") || mename.equals("POST"))
	         				 {
	         					 purl=burl1;
	         					 url2=new URL(purl);
	         					 URLConnection uconn=url2.openConnection();
	         					 uconn.setDoOutput(true);
	         	             	 OutputStreamWriter writer = new OutputStreamWriter(uconn.getOutputStream());
	         	                // writer.write(kname1+"="+akey+"&"+pa1+"="+pv1);
	         	             	 writer.flush();
	         	             	 BufferedReader reader = new BufferedReader(new InputStreamReader(uconn.getInputStream()));
	         	             	 String line=null;
	         	             	 FileWriter fw=null;
	         	             	 
	         	         		 fw=new FileWriter("F:/workspace/MindPulpy1/WebContent/book.xml");
	         	             	 while ((line = reader.readLine()) != null) {
	         	       		     fw.write(line);
	                             fw.flush();
	                             } 
	         	             	       	             	
	         	             	 fw.close();
	         	             		
	         	             	 
	         				 reader.close();
	         				 writer.close();
	         				 } //else if
	              			 
	         	} // Main IF
	         			 
	         			 else if(request.getParameter("second")!=null)
	         	{
	         		     if(mename.equals("get") || mename.equals("GET"))
	         		     {
	         		    	 purl=burl1;
	         		     // purl=burl1+"?"+kname1+"="+akey+"&"+pa1+"="+pv1;
	         			  url2 = new URL(purl);
	         			  URLConnection uconn = url2.openConnection();
	                       BufferedReader in = new BufferedReader(new InputStreamReader(uconn.getInputStream()));
	              		  String line=(String) in.readLine();
	              		  JSON json = JSONSerializer.toJSON( line );  
	          	          XMLSerializer xmlSerializer = new XMLSerializer();  
	          	          xmlSerializer.setTypeHintsEnabled(false);
	          	          xmlSerializer.setSkipWhitespace(true);
	          	          xmlSerializer.setTrimSpaces(true);
	          	          xmlSerializer.setRemoveNamespacePrefixFromElements(true);
	          	          xmlSerializer.removeNamespace(line);
	          	          xmlSerializer.setForceTopLevelObject(false);
	          		      String  xmlout = xmlSerializer.write( json );
	         			  FileWriter fw=new FileWriter("F:/workspace/MindPulpy1/WebContent/book.xml");
	         			  fw.write(xmlout);
	         			  
	         			  fw.close();
        		 		//  Runtime.getRuntime().exec("notepad F:/workspace/MindPulpy1/WebContent/book.xml");

	         		     }
// nested-if
	         		     else if(mename.equals("post") || mename.equals("POST")){
	         		    	 purl=burl1;
	         		    	 url2=new URL(burl1);
	         		    	 URLConnection uconn=url2.openConnection();
	         		    	 uconn.setDoOutput(true);
	         				 OutputStreamWriter writer=new OutputStreamWriter(uconn.getOutputStream());
	         				 writer.write(kname1+"="+akey+"&"+pa1+"="+pv1);
	                      	 writer.flush();
	         		    	 BufferedReader reader=new BufferedReader(new InputStreamReader(uconn.getInputStream()));

	         				 String line=null;
	             		      FileWriter fw=new FileWriter("F:/workspace/MindPulpy1/WebContent/book.xml");

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
	         	             	    } //while
	                      	 
	          				 fw.close();
	         		 	//	  Runtime.getRuntime().exec("notepad book.xml");

	          				 reader.close();
	          				 writer.close();
	                        
	         		       // else -if
	         	 		 
	         }
	         	}

	        }
            out.println("<h2><center><font color='green'>Processing...</font></center></h2>");
			response.setHeader("Refresh", "2; URL=test3.jsp");   
		}
		catch(Exception e){
			out.println(e);
		}
		

	}

}
