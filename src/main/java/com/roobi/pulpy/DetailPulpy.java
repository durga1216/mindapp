package com.roobi.pulpy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.http.HttpSession;

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

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
public class DetailPulpy extends HttpServlet {
	private static final long serialVersionUID = 1L;
        Connection con=null;
    public DetailPulpy() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/xml");
		PrintWriter out=response.getWriter();
		String appid=request.getParameter("appId");
		String parentId=request.getParameter("parentId");
		String loc=request.getParameter("loc");
		//HttpSession session=request.getSession(true);
		//String loc=(String) session.getAttribute("loc");
		DocumentBuilder builder = null;
        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();  
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url1 = "jdbc:mysql://localhost/mpulpy";
       final String USER = "adminPQ1iFfN";
            final String PASS = "J5JhBL-XC9NG";
        con = DriverManager.getConnection(url1,USER,PASS);
	    PreparedStatement st=con.prepareStatement("SELECT * FROM table1 t1 JOIN table3 t3 ON t1.id = t3.id JOIN table2 t2 ON t1.id=t2.id WHERE t1.id=?");
	    st.setString(1, appid);
         ResultSet rs = st.executeQuery();
         while(rs.next()){
        	 String kname=rs.getString("Key_Name");
        	 String API_KEY=rs.getString("API_KEY");
        	 String id=rs.getString("id");
        	 String eid=rs.getString("eid");
        	 String durl=rs.getString("durl");
             String p1=rs.getString("p1");
             String p2=rs.getString("p2");
        	 String ptag=rs.getString("ptag");
             String descr=rs.getString("descr");
             String oid=rs.getString("oid");
             String oname=rs.getString("oname");
             String odesc=rs.getString("odesc");
        	 String curl=durl+"?"+kname+"="+API_KEY+"&"+p1+"="+loc;
        	// out.println(url);
        	// out.println("Hello");

      //   if(parentId.equals(eid)){
          // out.println(curl);
        	 try {    //Method 2
                 builder = domFactory.newDocumentBuilder();
                } catch (ParserConfigurationException e2) {
                 e2.printStackTrace();
                }
                Document doc = null;
                try {
                 doc = builder.parse(new URL(curl).openStream());
                } catch (SAXException e2) {
                 e2.printStackTrace();
                }
              Document outdoc=DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
               Element outevent=outdoc.createElement("events");
               NodeList inevent=null;
       		XPath xPath =  XPathFactory.newInstance().newXPath();

               inevent=(NodeList) xPath.evaluate("//*", doc,XPathConstants.NODESET);
              if(inevent!=null){
            	  
              	for(int i=0;i<inevent.getLength();i++){
              		Element outputEvent=outdoc.createElement("event");
              		Node inputEvent=inevent.item(i);
              		
              		String nl=xPath.evaluate(eid, inputEvent);
                //   if(parentId.equals(nl)){
              		/*Element longdes=outdoc.createElement("Long_Description");
 					if(descr.equals(""))
              		longdes.setTextContent("");
              		else
                    longdes.setTextContent(xPath.evaluate(descr, inputEvent));    
                   	outputEvent.appendChild(longdes);*/
                   	
                   	Element orid=outdoc.createElement("Organizer_Id");
                   	if(oid.equals(""))
                    orid.setTextContent("");
                   	else
                   	orid.setTextContent(xPath.evaluate(oid, inputEvent));
                   	outputEvent.appendChild(orid);
                   	
                   	Element orname=outdoc.createElement("Organizer_name");
                   	if(oname.equals(""))
                    orname.setTextContent("");
                   	else
                   	orname.setTextContent(xPath.evaluate(oname, inputEvent));
                   	outputEvent.appendChild(orname);
                   	
                   	Element ordes=outdoc.createElement("Organizer_desc");
                   	if(odesc.equals(""))
                    ordes.setTextContent("");
                   	else
                   	ordes.setTextContent(xPath.evaluate(odesc, inputEvent));
                   	outputEvent.appendChild(ordes);
              		outevent.appendChild(outputEvent);
                }
              }
                    outdoc.appendChild(outevent);
              		Transformer transformer=null;
                    try {
            			 transformer=TransformerFactory.newInstance().newTransformer();
            		} catch (TransformerConfigurationException e) {
            			
            			e.printStackTrace();
            		} 
            	 transformer.setOutputProperty(OutputKeys.INDENT,"yes");
            	 transformer.setOutputProperty(OutputKeys.METHOD,"xml");

            	 StreamResult result=new StreamResult(new StringWriter());
                 DOMSource source=new DOMSource(outdoc);
                 try {
             		transformer.transform(source, result);
             	} catch (TransformerException e) {
             		// TODO Auto-generated catch block
             		e.printStackTrace();
             	}
                  Writer output=null;
                  output=new BufferedWriter(new FileWriter("F:/workspace/mind1.xml"));
                  String xmloutput=result.getWriter().toString();
                  output.write(xmloutput);
                  output.close();
                  out.println(xmloutput);
                	

              //} IF(eventID=PARENTID)

               
               

     
         
		}
         
		}
              
		catch(Exception e){
			out.println(e);
		}

         }
		
}
	
