package com.roobi.pulpy;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBContext;
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

import java.sql.*;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
public class RefPulpy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
        public RefPulpy() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
   
	    
	}
	

	private String expression(String string, Node inputEvent) {
		// TODO Auto-generated method stub
		return null;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//response.setContentType("text/xml");
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession(true);
        Connection con=null;
		String appid=(String) session.getAttribute("id");
		out.println(appid);
		String eid=request.getParameter("eid");
        String tit=request.getParameter("t1");
        String p_tag=request.getParameter("t");
        String cat=request.getParameter("t2");
        String sd=request.getParameter("t3");
		String ld=request.getParameter("t4");
	    String date=request.getParameter("t5");
        String time=request.getParameter("t6");
	    String addr=request.getParameter("t7");
		String addr1=request.getParameter("t8");
		String city=request.getParameter("t9");
		String pcode=request.getParameter("t10");
		String state=request.getParameter("t11");
		String country=request.getParameter("t12");

       // int e1=1;
		try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://127.6.250.130:3306/mpulpy";
       final String USER = "adminPQ1iFfN";
           final String PASS = "J5JhBL-XC9NG";
            con = DriverManager.getConnection(url,USER,PASS);
            PreparedStatement st=con.prepareStatement("insert into table2(id,p_tag,eid,title,cat,sd,ld,date,time,addr,addr1,city,pcode,state,country) values ('"+appid+"','"+p_tag+"','"+eid+"','"+tit+"','"+cat+"','"+sd+"','"+ld+"','"+date+"','"+time+"','"+addr+"','"+addr1+"','"+city+"','"+pcode+"','"+state+"','"+country+"')");                
            st.executeUpdate();
            out.println("Insert Success");
            out.println("<h2><center><font color='green'>Processing...</font></center></h2>");
			response.setHeader("Refresh", "2; URL=testbase2.jsp"); 
           
		}
		catch(Exception e){
			out.println(e);
		}
              
              
		
		// Method 1
		

	/*	DocumentBuilderFactory docFactory=DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = null;
		try {
			docBuilder = docFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Document doc1=docBuilder.newDocument();
		
 
		Element rootElement=doc1.createElement("events");
	    doc1.appendChild(rootElement);
	    
	    Element eventElement=doc1.createElement("event");
	    rootElement.appendChild(eventElement);
	    
	    Element id=doc1.createElement("id");
	  //  id.appendChild(doc.createTextNode("78787627"));

	    eventElement.appendChild(id);
	    
	    Element background_color=doc1.createElement("background_color");
	   // background_color.appendChild(doc.createTextNode("#000000"));

	    eventElement.appendChild(background_color);
	    
	    Element box_background_color=doc1.createElement("box_background_color");
	    eventElement.appendChild(box_background_color);
	    
	   Element box_border_color=doc1.createElement("box_border_color");
	    eventElement.appendChild(box_border_color);
	    
	    Element box_header_background_color=doc1.createElement("box_header_background_color");
	    eventElement.appendChild(box_header_background_color);
	    
	    Element box_header_text_color=doc1.createElement("box_header_text_color");
	    eventElement.appendChild(box_header_text_color);
	    
	    Element box_text_color=doc1.createElement("box_text_color");
	    eventElement.appendChild(box_text_color);
	    
	    Element capacity=doc1.createElement("capacity");
	    eventElement.appendChild(capacity);
	    
	    Element category=doc1.createElement("category");
	    eventElement.appendChild(category);
	    
	    Element created=doc1.createElement("created");
	    eventElement.appendChild(created);
	    
	    Element description=doc1.createElement("description");
	    eventElement.appendChild(description);
	    
	    Element distance=doc1.createElement("distance");
	    eventElement.appendChild(distance);
	    
	    Element end_date=doc1.createElement("end_date");
	    eventElement.appendChild(end_date);
	    
	    Element link_color=doc1.createElement("link_color");
	    eventElement.appendChild(link_color);
	    
	    Element locale=doc1.createElement("locale");
	    eventElement.appendChild(locale);
	    
	    Element logo=doc1.createElement("id");
	    eventElement.appendChild(logo);
	    
	    Element modified=doc1.createElement("modified");
	    eventElement.appendChild(modified);
	    
	    Element num_attendee_rows=doc1.createElement("num_attendee_rows");
	    eventElement.appendChild(num_attendee_rows);
	    
	    Element organizer=doc1.createElement("organizer");
	    eventElement.appendChild(organizer);
	    
	    Element description1=doc1.createElement("description1");
	    organizer.appendChild(description1);
	    
	    Element oid=doc1.createElement("oid");
	    organizer.appendChild(oid);
	    
	    Element long_description=doc1.createElement("long_description1");
	    organizer.appendChild(long_description);
	    
	    Element name=doc1.createElement("name");
	    organizer.appendChild(name);
	    
	    Element url3=doc1.createElement("url");
	    organizer.appendChild(url3);
	    
	    
	    Element privacy=doc1.createElement("privacy");
	    eventElement.appendChild(privacy);
	    		     		    		    
	    Element repeats=doc1.createElement("repeats");
	    eventElement.appendChild(repeats);
	    
	    Element start_date=doc1.createElement("start_date");
	    eventElement.appendChild(start_date);
	    
	    Element status=doc1.createElement("status");
	    eventElement.appendChild(status);
	    
	    Element tickets=doc1.createElement("tickets");
	    eventElement.appendChild(tickets);
	    
	    Element currency=doc1.createElement("currency");
	    tickets.appendChild(currency);
	    
	    Element tdescription=doc1.createElement("tdescription");
	    tickets.appendChild(tdescription);
	    
	    Element display_price=doc1.createElement("display_price");
	    tickets.appendChild(display_price);
	    
	    Element tend_date=doc1.createElement("ticket_end_date");
	    tickets.appendChild(tend_date);
	    
	    Element tid=doc1.createElement("ticket_id");
	    tickets.appendChild(tid);
	    
	    Element include_fee=doc1.createElement("include_fee");
	    tickets.appendChild(include_fee);
	    
	    Element max=doc1.createElement("max");
	    tickets.appendChild(max);
	    
	    Element min=doc1.createElement("min");
	    tickets.appendChild(min);
	    
	    Element ticket_name=doc1.createElement("name");
	    tickets.appendChild(ticket_name);
	    
	    Element price=doc1.createElement("price");
	    tickets.appendChild(price);
	    
	    Element type=doc1.createElement("type");
	    tickets.appendChild(type);
	    
	    Element visible=doc1.createElement("visible");
	    tickets.appendChild(visible);
	    
	    Element timezone=doc1.createElement("timezone");
	    eventElement.appendChild(timezone);
	    
	    Element timezone_offset=doc1.createElement("timezone_offset");
	    eventElement.appendChild(timezone_offset);
	    
	    Element title=doc1.createElement("title");
	    eventElement.appendChild(title);
	    
	    Element url11=doc1.createElement("url1");
	    eventElement.appendChild(url11);
	    
	    Element venue=doc1.createElement("venue");
	    eventElement.appendChild(venue);
	    
	    Element Latitude=doc1.createElement("Latitude");
	    venue.appendChild(Latitude);
	    
	    Element Longitude=doc1.createElement("Longitude");
	    venue.appendChild(Longitude);
	    
	    Element address=doc1.createElement("address");
	    venue.appendChild(address);
	    
	    Element address_2=doc1.createElement("address_2");
	    venue.appendChild(address_2);
	    
	    Element city=doc1.createElement("city");
	    venue.appendChild(city);
	    
	    Element country=doc1.createElement("country");
	    venue.appendChild(country);
	    
	    Element country_code=doc1.createElement("country_code");
	    venue.appendChild(country_code);
	    
	    Element venue_id=doc1.createElement("venue_id");
	    venue.appendChild(venue_id);
	    
	    Element venue_name=doc1.createElement("venue_name");
	    venue.appendChild(venue_name);
	    
	    Element postal_code=doc1.createElement("postal_code");
	    venue.appendChild(Latitude);
	    
	    Element region=doc1.createElement("region");
	    venue.appendChild(region);
	    
	    Transformer transformer=null;
        try {
			 transformer=TransformerFactory.newInstance().newTransformer();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
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
     output=new BufferedWriter(new FileWriter("F:/workspace/ref.xml"));
     String xmloutput=result.getWriter().toString();
     output.write(xmloutput);
     output.close();
     out.println(xmloutput);
		} 	 
        
            }
		}
        catch(Exception e){
       	 
        }*/
			}
}
