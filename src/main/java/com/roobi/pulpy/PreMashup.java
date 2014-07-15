package com.roobi.pulpy;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.mindots.util.Utils;

/**
 * Servlet implementation class PreMashup
 */
@WebServlet("/PreMashup")
public class PreMashup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreMashup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> config = Utils.getConfigFromFile(getServletContext(), "config.properties");
        PrintWriter out=response.getWriter();

		response.setHeader("Content-Type","text/xml; charset=UTF-8");
		Connection con=null;
		 HttpSession session1=request.getSession(true);
		 int appid=(Integer) session1.getAttribute("preid"); 
		//  int appid=2;
		  String co=request.getParameter("conf");
		try{
	    Class.forName("com.mysql.jdbc.Driver").newInstance();
       con = (Connection) DriverManager.getConnection(config.get("URL"),config.get("USER"),config.get("PASS"));
	    PreparedStatement st=con.prepareStatement("SELECT * FROM prefirst t1 JOIN prefstxml t2 ON t1.appid = t2.appid WHERE t1.appid=?");
	    st.setInt(1, appid);
       ResultSet rs = st.executeQuery();
       PreparedStatement st1=con.prepareStatement("SELECT * FROM presecond t1 JOIN presecxml t2 ON t1.appid = t2.appid  WHERE t1.appid=?");
       st1.setInt(1, appid);
       ResultSet rs1 = st1.executeQuery();
       PreparedStatement st2=con.prepareStatement("SELECT * FROM prethird t1 JOIN prethrdxml t2 ON t1.appid = t2.appid  WHERE t1.appid=?");
       st2.setInt(1, appid);
       ResultSet rs2 = st2.executeQuery();
      if(co.equals("1")){
       	String line="";
           while(rs.next()){ 
        	   // retrieve data from Database and join two tables namely(thrdconfig&thrdxmlconfig)
           	String thirdurl1=rs.getString("endurl");String akt1=rs.getString("flabel");String akt2=rs.getString("fkey");
           	 String tp1=rs.getString("f1"); String tpv1=rs.getString("fv1");String tp2=rs.getString("f2"); String tpv2=rs.getString("fv2");
           	 String tp3=rs.getString("f3"); String tpv3=rs.getString("fv3");String tp4=rs.getString("f4"); String tpv4=rs.getString("fv4");
           	 String tp5=rs.getString("f5"); String tpv5=rs.getString("fv5");String tp6=rs.getString("f6"); String tpv6=rs.getString("fv6");
           	 String tp7=rs.getString("f7"); String tpv7=rs.getString("fv7");String tp8=rs.getString("f8"); String tpv8=rs.getString("fv8");
           	 String tp9=rs.getString("f9"); String tpv9=rs.getString("fv9");String tp10=rs.getString("f10"); String tpv10=rs.getString("fv10");
           	 String resf3=rs.getString("resf");
           	 String thrdparent=rs.getString("fxr");
           	 String tx1=rs.getString("fx1"); String txv1=rs.getString("fxv1");String tx2=rs.getString("fx2"); String txv2=rs.getString("fxv2");
           	 String tx3=rs.getString("fx3"); String txv3=rs.getString("fxv3");String tx4=rs.getString("fx4"); String txv4=rs.getString("fxv4");
           	 String tx5=rs.getString("fx5"); String txv5=rs.getString("fxv5");String tx6=rs.getString("fx6"); String txv6=rs.getString("fxv6");
           	 String tx7=rs.getString("fx7"); String txv7=rs.getString("fxv7");String tx8=rs.getString("fx8"); String txv8=rs.getString("fxv8");
           	 String tx9=rs.getString("fx9"); String txv9=rs.getString("fxv9");String tx10=rs.getString("fx10"); String txv10=rs.getString("fxv10");
           	 String tx11=rs.getString("fx11"); String txv11=rs.getString("fxv11");String tx12=rs.getString("fx12"); String txv12=rs.getString("fxv12");
           	 String tx13=rs.getString("fx13"); String txv13=rs.getString("fxv13");String tx14=rs.getString("fx14"); String txv14=rs.getString("fxv14");
           	 String tx15=rs.getString("fx15"); String txv15=rs.getString("fxv15");String tx16=rs.getString("fx16"); String txv16=rs.getString("fxv16");
           	 String tx17=rs.getString("fx17"); String txv17=rs.getString("fxv17");String tx18=rs.getString("fx18"); String txv18=rs.getString("fxv18");
           	 String tx19=rs.getString("fx19"); String txv19=rs.getString("fxv19");String tx20=rs.getString("fx20"); String txv20=rs.getString("fxv20");
           	
           	Document doc1=null;  //TO Convert XMLSTRING TO DOCUMENT
               DocumentBuilder builder1=null;
               DocumentBuilderFactory domFactory1=DocumentBuilderFactory.newInstance();
               builder1=domFactory1.newDocumentBuilder();
       	
                   String thirdurl11=null;
                   String thrdjsonxmlout=null;
                  	 if( resf3.equals("XML")){  //API XML get
                  		 

                  		 if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3) && !"null".equals(tp4) && !"null".equals(tp5) && !"null".equals(tp6)){
                  		     thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2+"&"+tp3+"="+tpv3+"&"+tp4+"="+tpv4+"&"+tp5+"="+tpv5+"&"+tp6+"="+tpv6;}
                  		 
                  		 else if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3) && !"null".equals(tp4) && !"null".equals(tp5)){
            	        		 thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2+"&"+tp3+"="+tpv3+"&"+tp4+"="+tpv4+"&"+tp5+"="+tpv5;}
                  		 
                  		 else if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3) && !"null".equals(tp4)){
            	        		 thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2+"&"+tp3+"="+tpv3+"&"+tp4+"="+tpv4;}
                  		 
                  		 else if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3)){
            	        		 thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2+"&"+tp3+"="+tpv3;}
                  		 
                  		 else if(!"null".equals(tp1) && !"null".equals(tp2)){
            	        		 thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2;}
                  		 
                  		 else if(!"null".equals(tp1)){
            	        		 thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+tpv1;}
                  	
                  		 else if(!"null".equals(akt1) && !"null".equals(akt2))
                  			      thirdurl11=thirdurl1+"?"+akt1+"="+akt2;
                  		 
                  		 else if("null".equals(akt1) && "null".equals(akt2))
                  			      thirdurl11=thirdurl1;
                  		 
                  		 //out.println("url"+thirdurl11);
                 		 doc1=builder1.parse(new URL(thirdurl11).openStream());

                  		
           	     
                  	 }//api keys and get	 
                  		
                  	if(resf3.equals("JSON")){  //API XML get
                 		 

                 		 if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3) && !"null".equals(tp4) && !"null".equals(tp5) && !"null".equals(tp6)){
                 		     thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2+"&"+tp3+"="+tpv3+"&"+tp4+"="+tpv4+"&"+tp5+"="+tpv5+"&"+tp6+"="+tpv6;}
                 		 
                 		 else if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3) && !"null".equals(tp4) && !"null".equals(tp5)){
           	        		 thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2+"&"+tp3+"="+tpv3+"&"+tp4+"="+tpv4+"&"+tp5+"="+tpv5;}
                 		 
                 		 else if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3) && !"null".equals(tp4)){
           	        		 thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2+"&"+tp3+"="+tpv3+"&"+tp4+"="+tpv4;}
                 		 
                 		 else if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3)){
           	        		 thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2+"&"+tp3+"="+tpv3;}
                 		 
                 		 else if(!"null".equals(tp1) && !"null".equals(tp2)){
           	        		 thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2;}
                 		 
                 		 else if(!"null".equals(tp1)){
           	        		 thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+tpv1;}
                 		
                 		 else if(!"null".equals(akt1) && !"null".equals(akt2))
                 			      thirdurl11=thirdurl1+"?"+akt1+"="+akt2;
                 		 
                 		 else if("null".equals(akt1) && "null".equals(akt2))
                 			      thirdurl11=thirdurl1;
                 		 
                 		StringBuilder strb=new StringBuilder();String strcon="";
                 		URL third=new URL(thirdurl11);
         		        URLConnection uconn = third.openConnection();
         	            HttpURLConnection conn = (HttpURLConnection) uconn;
         	            conn.connect();
         	            Object content = conn.getContent();
         	            InputStream stream = (InputStream) content;
         	            BufferedReader in=new BufferedReader(new InputStreamReader(stream));
         	           while ((line = in.readLine()) != null)    { 		  
	        	    	      strb.append(line);
	   	    		     }//while
	        	    	 strcon=strb.toString();
	        	    	 XMLSerializer serializer = new XMLSerializer();
	     	            JSON json = JSONSerializer.toJSON(strcon);
	     	            serializer.setRootName("root");
	     	            serializer.setTypeHintsEnabled(false);
	     	           thrdjsonxmlout= serializer.write(json);
       		       //thrdjsonxmlout = xmlSerializer.write( json );

         	              
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
                		

                	    if(!"null".equals(tx1)){  
                	    	//out.println("sudds");//validation for not return null tag
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
	                 String xmloutput=result.getWriter().toString();
	                out.println(xmloutput);
	                
           }
           }
      else if(co.equals("2")){
         	String line="";
             while(rs1.next()){ // retrieve data from Database and join two tables namely(thrdconfig&thrdxmlconfig)
             	String thirdurl1=rs1.getString("securl");String akt1=rs1.getString("slabel");String akt2=rs1.getString("skey");
             	 String tp1=rs1.getString("s1"); String tpv1=rs1.getString("sv1");String tp2=rs1.getString("s2"); String tpv2=rs1.getString("sv2");
             	 String tp3=rs1.getString("s3"); String tpv3=rs1.getString("sv3");String tp4=rs1.getString("s4"); String tpv4=rs1.getString("sv4");
             	 String tp5=rs1.getString("s5"); String tpv5=rs1.getString("sv5");String tp6=rs1.getString("s6"); String tpv6=rs1.getString("sv6");
             	 String tp7=rs1.getString("s7"); String tpv7=rs1.getString("sv7");String tp8=rs1.getString("s8"); String tpv8=rs1.getString("sv8");
             	 String tp9=rs1.getString("s9"); String tpv9=rs1.getString("sv9");String tp10=rs1.getString("s10"); String tpv10=rs1.getString("sv10");
             	 String resf3=rs1.getString("resf3");
             	 String thrdparent=rs1.getString("sxr");
             	 String tx1=rs1.getString("sx1"); String txv1=rs1.getString("sxv1");String tx2=rs1.getString("sx2"); String txv2=rs1.getString("sxv2");
             	 String tx3=rs1.getString("sx3"); String txv3=rs1.getString("sxv3");String tx4=rs1.getString("sx4"); String txv4=rs1.getString("sxv4");
             	 String tx5=rs1.getString("sx5"); String txv5=rs1.getString("sxv5");String tx6=rs1.getString("sx6"); String txv6=rs1.getString("sxv6");
             	 String tx7=rs1.getString("sx7"); String txv7=rs1.getString("sxv7");String tx8=rs1.getString("sx8"); String txv8=rs1.getString("sxv8");
             	 String tx9=rs1.getString("sx9"); String txv9=rs1.getString("sxv9");String tx10=rs1.getString("sx10"); String txv10=rs1.getString("sxv10");
             	 String tx11=rs1.getString("sx11"); String txv11=rs1.getString("sxv11");String tx12=rs1.getString("sx12"); String txv12=rs1.getString("sxv12");
             	 String tx13=rs1.getString("sx13"); String txv13=rs1.getString("sxv13");String tx14=rs1.getString("sx14"); String txv14=rs1.getString("sxv14");
             	 String tx15=rs1.getString("sx15"); String txv15=rs1.getString("sxv15");String tx16=rs1.getString("sx16"); String txv16=rs1.getString("sxv16");
             	 String tx17=rs1.getString("sx17"); String txv17=rs1.getString("sxv17");String tx18=rs1.getString("sx18"); String txv18=rs1.getString("sxv18");
             	 String tx19=rs1.getString("sx19"); String txv19=rs1.getString("sxv19");String tx20=rs1.getString("sx20"); String txv20=rs1.getString("sxv20");
             	
             	Document doc1=null;  //TO Convert XMLSTRING TO DOCUMENT
                 DocumentBuilder builder1=null;
                 DocumentBuilderFactory domFactory1=DocumentBuilderFactory.newInstance();
                 builder1=domFactory1.newDocumentBuilder();
         	
                     String thirdurl11=null;
                     String thrdjsonxmlout=null;
                    	 if( resf3.equals("XML")){  //API XML get
                    		 

                    		 if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3) && !"null".equals(tp4) && !"null".equals(tp5) && !"null".equals(tp6)){
                    		     thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2+"&"+tp3+"="+tpv3+"&"+tp4+"="+tpv4+"&"+tp5+"="+tpv5+"&"+tp6+"="+tpv6;}
                    		 
                    		 else if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3) && !"null".equals(tp4) && !"null".equals(tp5)){
              	        		 thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2+"&"+tp3+"="+tpv3+"&"+tp4+"="+tpv4+"&"+tp5+"="+tpv5;}
                    		 
                    		 else if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3) && !"null".equals(tp4)){
              	        		 thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2+"&"+tp3+"="+tpv3+"&"+tp4+"="+tpv4;}
                    		 
                    		 else if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3)){
              	        		 thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2+"&"+tp3+"="+tpv3;}
                    		 
                    		 else if(!"null".equals(tp1) && !"null".equals(tp2)){
              	        		 thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2;}
                    		 
                    		 else if(!"".equals(tp1)){
              	        		 thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+tpv1;}
                    	
                    		 else if(!"".equals(akt1) && !"".equals(akt2))
                    			      thirdurl11=thirdurl1+"?"+akt1+"="+akt2;
                    		 
                    		 else if("".equals(tp1))
                    			      thirdurl11=thirdurl1+"/"+tpv1;
                    		 
                   		 doc1=builder1.parse(new URL(thirdurl11).openStream());

                    		
             	     
                    	 }//api keys and get	 
                    		
                    	if(resf3.equals("JSON")){  //API XML get
                   		 

                   		 if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3) && !"null".equals(tp4) && !"null".equals(tp5) && !"null".equals(tp6)){
                   		     thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2+"&"+tp3+"="+tpv3+"&"+tp4+"="+tpv4+"&"+tp5+"="+tpv5+"&"+tp6+"="+tpv6;}
                   		 
                   		 else if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3) && !"null".equals(tp4) && !"null".equals(tp5)){
             	        		 thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2+"&"+tp3+"="+tpv3+"&"+tp4+"="+tpv4+"&"+tp5+"="+tpv5;}
                   		 
                   		 else if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3) && !"null".equals(tp4)){
             	        		 thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2+"&"+tp3+"="+tpv3+"&"+tp4+"="+tpv4;}
                   		 
                   		 else if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3)){
             	        		 thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2+"&"+tp3+"="+tpv3;}
                   		 
                   		 else if(!"null".equals(tp1) && !"null".equals(tp2)){
             	        		 thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2;}
                   		 
                   		 else if(!"null".equals(tp1)){
             	        		 thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+tpv1;}
                   		
                   		 else if(!"null".equals(akt1) && !"null".equals(akt2))
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
  	                 String xmloutput=result.getWriter().toString();
  	                out.println(xmloutput);
  	                
             }
             }
      else if(co.equals("3")){
         	String line="";
             while(rs2.next()){ // retrieve data from Database and join two tables namely(thrdconfig&thrdxmlconfig)
             	String thirdurl1=rs2.getString("thrdurl");String akt1=rs2.getString("alabel");String akt2=rs2.getString("akey");
             	 String tp1=rs2.getString("t1"); String tpv1=rs2.getString("tv1");String tp2=rs2.getString("t2"); String tpv2=rs2.getString("tv2");
             	 String tp3=rs2.getString("t3"); String tpv3=rs2.getString("tv3");String tp4=rs2.getString("t4"); String tpv4=rs2.getString("tv4");
             	 String tp5=rs2.getString("t5"); String tpv5=rs2.getString("tv5");String tp6=rs2.getString("t6"); String tpv6=rs2.getString("tv6");
             	 String tp7=rs2.getString("t7"); String tpv7=rs2.getString("tv7");String tp8=rs2.getString("t8"); String tpv8=rs2.getString("tv8");
             	 String tp9=rs2.getString("t9"); String tpv9=rs2.getString("tv9");String tp10=rs2.getString("t10"); String tpv10=rs2.getString("tv10");
             	 String resf3=rs2.getString("resf3");
             	 String thrdparent=rs2.getString("txr");
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
             	
             	Document doc1=null;  //TO Convert XMLSTRING TO DOCUMENT
                 DocumentBuilder builder1=null;
                 DocumentBuilderFactory domFactory1=DocumentBuilderFactory.newInstance();
                 builder1=domFactory1.newDocumentBuilder();
         	
                     String thirdurl11=null;
                     String thrdjsonxmlout=null;
                    	 if( resf3.equals("XML")){  //API XML get
                    		 

                    		 if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3) && !"null".equals(tp4) && !"null".equals(tp5) && !"null".equals(tp6)){
                    		     thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2+"&"+tp3+"="+tpv3+"&"+tp4+"="+tpv4+"&"+tp5+"="+tpv5+"&"+tp6+"="+tpv6;}
                    		 
                    		 else if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3) && !"null".equals(tp4) && !"null".equals(tp5)){
              	        		 thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2+"&"+tp3+"="+tpv3+"&"+tp4+"="+tpv4+"&"+tp5+"="+tpv5;}
                    		 
                    		 else if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3) && !"null".equals(tp4)){
              	        		 thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2+"&"+tp3+"="+tpv3+"&"+tp4+"="+tpv4;}
                    		 
                    		 else if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3)){
              	        		 thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2+"&"+tp3+"="+tpv3;}
                    		 
                    		 else if(!"null".equals(tp1) && !"null".equals(tp2)){
              	        		 thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2;}
                    		 
                    		 else if(!"null".equals(tp1)){
              	        		 thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+tpv1;}
                    	
                    		 else if(!"null".equals(akt1) && !"null".equals(akt2))
                    			      thirdurl11=thirdurl1+"?"+akt1+"="+akt2;
                    		 
                    		 else if("null".equals(akt1) && "null".equals(akt2))
                    			      thirdurl11=thirdurl1;
                    		 
                   		 doc1=builder1.parse(new URL(thirdurl11).openStream());

                    		
             	     
                    	 }//api keys and get	 
                    		
                    	if(resf3.equals("JSON")){  //API XML get
                   		 

                   		 if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3) && !"null".equals(tp4) && !"null".equals(tp5) && !"null".equals(tp6)){
                   		     thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2+"&"+tp3+"="+tpv3+"&"+tp4+"="+tpv4+"&"+tp5+"="+tpv5+"&"+tp6+"="+tpv6;}
                   		 
                   		 else if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3) && !"null".equals(tp4) && !"null".equals(tp5)){
             	        		 thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2+"&"+tp3+"="+tpv3+"&"+tp4+"="+tpv4+"&"+tp5+"="+tpv5;}
                   		 
                   		 else if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3) && !"null".equals(tp4)){
             	        		 thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2+"&"+tp3+"="+tpv3+"&"+tp4+"="+tpv4;}
                   		 
                   		 else if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3)){
             	        		 thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2+"&"+tp3+"="+tpv3;}
                   		 
                   		 else if(!"null".equals(tp1) && !"null".equals(tp2)){
             	        		 thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2;}
                   		 
                   		 else if(!"null".equals(tp1)){
             	        		 thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+tpv1;}
                   		
                   		 else if(!"null".equals(akt1) && !"null".equals(akt2))
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
  	                 String xmloutput=result.getWriter().toString();
  	                out.println(xmloutput);
  	                
             }
             }
		}
		catch(Exception e){
		//	out.println(e);
		}
	}

}
