package com.roobi.pulpy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
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
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
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

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
public class BookingPulpy extends HttpServlet {
	private static final long serialVersionUID = 1L;
     public BookingPulpy() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Content-Type","text/xml; charset=UTF-8");
		Connection con=null;

		PrintWriter out=response.getWriter();
		String appid=request.getParameter("appId");
		String parentId=request.getParameter("parentId");
		String loc=request.getParameter("loc");
		
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url1 = "jdbc:mysql://localhost/MPULPY";
       final String USER = "adminPQ1iFfN";
            final String PASS = "J5JhBL-XC9NG";
        con = DriverManager.getConnection(url1,USER,PASS);
	    PreparedStatement st=con.prepareStatement("SELECT * FROM table1 t1 JOIN tab4 ta4 ON t1.id=ta4.id JOIN table4 t4 ON t1.id = t4.id JOIN tab3 ta3 ON t1.id=ta3.id JOIN table3 t3 ON t1.id=t3.id JOIN table2 t2 ON t1.id=t2.id WHERE t1.id=?");
	    st.setString(1, appid);
         ResultSet rs = st.executeQuery();
         while(rs.next()){
        	 String kname=rs.getString("Key_Name");
        	 String surl=rs.getString("surl");
        	 String API_KEY=rs.getString("API_KEY");
        	 String mname=rs.getString("method");
        	 String p1=rs.getString("p1");
             String p2=rs.getString("p2");
        	 String id=rs.getString("id");
        	 String eid=rs.getString("eid");
        	 String burl=rs.getString("burl");
             String ptag3=rs.getString("ptag3");
        	 String ptag4=rs.getString("ptag4");
             String tid=rs.getString("tid");
             String ttype=rs.getString("ttype");
             String tdesc=rs.getString("tdesc");
             String tprice=rs.getString("tprice");
             String edate=rs.getString("edate");
             String durl=rs.getString("durl");
             String descr=rs.getString("descr");
             String oid=rs.getString("oid");
             String oname=rs.getString("oname");
             String odesc=rs.getString("odesc");
             String curl=null;
              String line=null;
             if(mname.equals("get") || (mname.equals("GET"))){
            	 curl=burl;
            	 //curl=burl+"?"+kname+"="+API_KEY+"&"+eid+"="+parentId;
            	 URL url11 = new URL(curl);
                 URLConnection uconn = url11.openConnection();
                 BufferedReader in = new BufferedReader(new InputStreamReader(uconn.getInputStream()));
     		     line=(String) in.readLine();
            	 }
            	 else if(mname.equals("post") || (mname.equals("POST")))
            	 {
            	 curl=burl;
            	 URL url2=new URL(curl);
    	    	 URLConnection uconn=url2.openConnection();
    	    	 uconn.setDoOutput(true);
    			 OutputStreamWriter writer=new OutputStreamWriter(uconn.getOutputStream());
    			// writer.write(kname+"="+API_KEY+"&"+eid+"="+parentId);
             	 writer.flush();
             	  BufferedReader in = new BufferedReader(new InputStreamReader(uconn.getInputStream()));
    		     line=(String) in.readLine();
            	 }
            	
     
         
        	   /* URL url11 = new URL(burl);
                 URLConnection uconn = url11.openConnection();
                 BufferedReader in = new BufferedReader(new InputStreamReader(uconn.getInputStream()));
 		         String line=(String) in.readLine();*/
 		        Document doc=null;
 	 			DocumentBuilder builder = null;
 	 	        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance(); 	
 	 	        builder=domFactory.newDocumentBuilder();
 	 	      if(line.startsWith("<?")  && line.endsWith("?>")){
 	 	          doc = builder.parse(new URL(burl).openStream()); 
	  		     //  doc=builder.parse(new InputSource(new ByteArrayInputStream(line.getBytes("UTF-8"))));

 	 	      }
 	 		    else{
 	 		       JSON json = JSONSerializer.toJSON( line );  
 	  	           XMLSerializer xmlSerializer = new XMLSerializer();  
 	  	           xmlSerializer.setTypeHintsEnabled(false);
 	  	           xmlSerializer.setSkipWhitespace(true);
 	  	           xmlSerializer.setTrimSpaces(true);
 	  	           xmlSerializer.setRemoveNamespacePrefixFromElements(true);
 	  	           xmlSerializer.removeNamespace(line);
 	  	           xmlSerializer.setForceTopLevelObject(false);
 	  		       String  xmlout = xmlSerializer.write( json );
 	  		       doc=builder.parse(new InputSource(new ByteArrayInputStream(xmlout.getBytes("UTF-8"))));
 	 		     }
 	 	        
               Document outdoc=DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
               Element outevent=outdoc.createElement("events");
               NodeList inevent=null;
       		   XPath xPath =  XPathFactory.newInstance().newXPath();

               inevent=(NodeList) xPath.evaluate(ptag4, doc,XPathConstants.NODESET);
              if(inevent!=null){
            	  
              	for(int i=0;i<inevent.getLength();i++){
              		Element outputEvent=outdoc.createElement("event");
              		Node inputEvent=inevent.item(i);
              		
              	  //  String nl=xPath.evaluate(eid, inputEvent);
                 //  if(parentId.equals(nl)){
              		Element ticid=outdoc.createElement("Ticket_Id");
 					if(tid.equals(""))
              		ticid.setTextContent("");
              		else
                    ticid.setTextContent(xPath.evaluate(tid, inputEvent));    
                   	outputEvent.appendChild(ticid);
                   	
                   	Element titype=outdoc.createElement("Ticket_Type");
                   	if(ttype.equals(""))
                    titype.setTextContent("");
                   	else
                   	titype.setTextContent(xPath.evaluate(ttype, inputEvent));
                   	outputEvent.appendChild(titype);
                   	
                  /*	Element tidesc=outdoc.createElement("Ticket_Description");
                   	if(tdesc.equals(""))
                    tidesc.setTextContent("");
                   	else
                   	tidesc.setTextContent(xPath.evaluate(tdesc, inputEvent));
                   	outputEvent.appendChild(tidesc);*/
                   	
                   	Element tiprice=outdoc.createElement("Ticket_Price");
                   	if(tprice.equals(""))
                    tiprice.setTextContent("");
                   	else
                   	tiprice.setTextContent(xPath.evaluate(tprice, inputEvent));
                   	outputEvent.appendChild(tiprice);
                   	
                   	Element endate=outdoc.createElement("End_Date");
                   	if(edate.equals(""))
                    endate.setTextContent("");
                   	else
                   	endate.setTextContent(xPath.evaluate(edate, inputEvent));
                   	outputEvent.appendChild(endate);
              		outevent.appendChild(outputEvent);
             //      }
                   }
              }
                    outdoc.appendChild(outevent);
                    
               String aurl=null;
                String line1=null;
                if(mname.equals("get") || (mname.equals("GET"))){
               	 aurl=durl;
               	 //aurl=durl+"?"+kname+"="+API_KEY+"&"+eid+"="+parentId;
               	 URL url11 = new URL(aurl);
                    URLConnection uconn = url11.openConnection();
                    BufferedReader in = new BufferedReader(new InputStreamReader(uconn.getInputStream()));
        		     line1=(String) in.readLine();
               	 }
               	 else if(mname.equals("post") || (mname.equals("POST")))
               	 {
               	 aurl=durl;
               	 URL url2=new URL(aurl);
       	    	 URLConnection uconn=url2.openConnection();
       	    	 uconn.setDoOutput(true);
       			 OutputStreamWriter writer=new OutputStreamWriter(uconn.getOutputStream());
       			// writer.write(kname+"="+API_KEY+"&"+eid+"="+parentId);
                	 writer.flush();
                	  BufferedReader in = new BufferedReader(new InputStreamReader(uconn.getInputStream()));
       		     line1=(String) in.readLine();
               	 }
               	


                   
    		        Document doc1=null;
    	 			DocumentBuilder builder1 = null;
    	 	        DocumentBuilderFactory domFactory1 = DocumentBuilderFactory.newInstance(); 	
    	 	        builder1=domFactory1.newDocumentBuilder();
    	 	      if(line1.startsWith("<?")  && line1.endsWith("?>")){
    	 	          doc1 = builder1.parse(new URL(durl).openStream()); 		   
    	 	       }
    	 		     else{
    	 		       JSON json = JSONSerializer.toJSON( line1 );  
    	  	           XMLSerializer xmlSerializer = new XMLSerializer();  
    	  	           xmlSerializer.setTypeHintsEnabled(false);
    	  	           xmlSerializer.setSkipWhitespace(true);
    	  	           xmlSerializer.setTrimSpaces(true);
    	  	           xmlSerializer.setRemoveNamespacePrefixFromElements(true);
    	  	           xmlSerializer.removeNamespace(line1);
    	  	           xmlSerializer.setForceTopLevelObject(false);
    	  		       String  xmlout = xmlSerializer.write( json );
    	  		       doc1=builder1.parse(new InputSource(new ByteArrayInputStream(xmlout.getBytes("UTF-8"))));
    	 		     }
                       Document outdoc1=DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
                       Element outevent1=outdoc1.createElement("events");
                       NodeList inevent1=null;
               		 XPath xPath1 =  XPathFactory.newInstance().newXPath();

                       inevent1=(NodeList) xPath1.evaluate(ptag3, doc1,XPathConstants.NODESET);
                      if(inevent1!=null){
                        for(int i=0;i<inevent1.getLength();i++){
                        	Element outputEvent1=outdoc1.createElement("event");
                      		Node inputEvent1=inevent1.item(i);
                      		String nl1=xPath1.evaluate(eid, inputEvent1);

                         //  if(parentId.equals(nl1)){
                            /* Element longdes=outdoc1.createElement("Description");
              				 if(descr.equals(""))
                           	 longdes.setTextContent("");
                           	 else
                             longdes.setTextContent(xPath1.evaluate(descr, inputEvent1));    
                             outputEvent1.appendChild(longdes);*/
                                	
                      		Element orid=outdoc1.createElement("Organizer_Id");
                           	if(oid.equals(""))
                            orid.setTextContent("");
                           	else
                           	orid.setTextContent(xPath1.evaluate(oid, inputEvent1));
                           	outputEvent1.appendChild(orid);
                           	
                           	Element orname=outdoc1.createElement("Organizer_name");
                           	if(oname.equals(""))
                            orname.setTextContent("");
                           	else
                           	orname.setTextContent(xPath1.evaluate(oname, inputEvent1));
                           	outputEvent1.appendChild(orname);
                           	
                         	Element ordes=outdoc1.createElement("Organizer_desc");
                           	if(odesc.equals(""))
                            ordes.setTextContent("");
                           	else
                           	ordes.setTextContent(xPath1.evaluate(odesc, inputEvent1));
                           	outputEvent1.appendChild(ordes);
                      		outevent1.appendChild(outputEvent1);
                        //    }
                        }
                      }
                      outdoc1.appendChild(outevent1);
                      
              		 NodeList nodes=outdoc.getElementsByTagName("event");
                      NodeList nodes1=outdoc1.getElementsByTagName("event");
                      
                      NodeList ndListFirstFile = outdoc.getElementsByTagName("event");
                      for(int i=0;i<ndListFirstFile.getLength();i++){
                    // Node nodedes=outdoc.importNode(outdoc1.getElementsByTagName("Description").item(i),true);
                      Node nodeid = outdoc.importNode(outdoc1.getElementsByTagName("Organizer_Id").item(i), true);
                      Node nodename = outdoc.importNode(outdoc1.getElementsByTagName("Organizer_name").item(i), true);
                     Node nodeorgdes=outdoc.importNode(outdoc1.getElementsByTagName("Organizer_desc").item(i),true);
                    //  ndListFirstFile.item(i).appendChild(nodedes);
                      ndListFirstFile.item(i).appendChild(nodeid);
                      ndListFirstFile.item(i).appendChild(nodename);
                      ndListFirstFile.item(i).appendChild(nodeorgdes);
                      
                      }
                      Transformer transformer1=null;
                      try {
              			 transformer1=TransformerFactory.newInstance().newTransformer();
              		} catch (TransformerConfigurationException e) {
              			// TODO Auto-generated catch block
              			e.printStackTrace();
              		} 
              	 transformer1.setOutputProperty(OutputKeys.INDENT,"yes");
              	 transformer1.setOutputProperty(OutputKeys.METHOD,"xml");

              	 StreamResult result=new StreamResult(new StringWriter());
                   DOMSource source=new DOMSource(outdoc);
                   try {
               		transformer1.transform(source, result);
               	} catch (TransformerException e) {
               		// TODO Auto-generated catch block
               		e.printStackTrace();
               	}
                    Writer output=null;
                    output=new BufferedWriter(new FileWriter("F:/workspace/mind.xml"));
                    String xmloutput=result.getWriter().toString();
                    output.write(xmloutput);
                    output.close();
                    out.println(xmloutput);
                	

              }


               
		
      
         
		}
              
		catch(Exception e){
			out.println(e);
		}


	}

}
