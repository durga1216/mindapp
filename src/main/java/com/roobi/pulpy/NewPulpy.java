package com.roobi.pulpy;

import java.io.BufferedReader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import java.net.URLConnection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
public class NewPulpy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public NewPulpy() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/xml");
		PrintWriter out1=response.getWriter();
    try{
		String SOAPUrl = "http://59.162.33.102/ArzooWS/services/DOMFlightAvailability";
		String SOAPAction = "";
		URL url = new URL(SOAPUrl);
		URLConnection connection = url.openConnection();
		HttpURLConnection httpConn = (HttpURLConnection) connection;
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		String request1="<?xml version=\'1.0\' encoding=\'UTF-8\'?><soapenv:Envelope xmlns:soapenv=\'http://schemas.xmlsoap.org/soap/envelope/\' xmlns:xsd=\'http://www.w3.org/2001/XMLSchema\' xmlns:xsi=\'http://www.w3.org/2001/XMLSchema-instance\'> <soapenv:Body>  <getAvailability xmlns=\'http://avail.flight.arzoo.com\'>   <in0 xmlns=\'\'>  &lt;Request&gt;&lt;Origin&gt;BOM&lt;/Origin&gt;&lt;Destination&gt;BLR&lt;/Destination&gt;&lt;DepartDate&gt;2014-05-15&lt;/DepartDate&gt;&lt;ReturnDate&gt;2014-05-15&lt;/ReturnDate&gt;&lt;AdultPax&gt;1&lt;/AdultPax&gt;&lt;ChildPax&gt;0&lt;/ChildPax&gt;&lt;InfantPax&gt;0&lt;/InfantPax&gt;&lt;Currency&gt;INR&lt;/Currency&gt;&lt;Clientid&gt;77743613&lt;/Clientid&gt;&lt;Clientpassword&gt;*8DC945BE945EF739F56B6A5B5C5A48440B006F7A&lt;/Clientpassword&gt;&lt;Clienttype&gt;ArzooFWS1.1&lt;/Clienttype&gt;&lt;Preferredclass&gt;E&lt;/Preferredclass&gt;&lt;mode&gt;ONE&lt;/mode&gt;&lt;PreferredAirline&gt;AI,G8,IC,6E,9W,S2,IT,9H,I7,SG&lt;/PreferredAirline&gt;&lt;/Request&gt;    </in0>  </getAvailability></soapenv:Body></soapenv:Envelope>";			
		copy(request1, bout);
		byte[] b = bout.toByteArray();
		httpConn.setRequestProperty("Content-Length", String.valueOf(b.length));
		httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
		httpConn.setRequestProperty("SOAPAction", SOAPAction);
		httpConn.setRequestMethod("POST");
		httpConn.setDoOutput(true);
		httpConn.setDoInput(true);
		OutputStream out = httpConn.getOutputStream();
		out.write(b);
		out.close();
		InputStreamReader isr = new InputStreamReader(httpConn.getInputStream());
		BufferedReader in = new BufferedReader(isr);
		String inputLine;
		String str=null;
		StringBuffer strbfr = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			strbfr.append(inputLine);
			 str=strbfr.toString();
		}
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(false);
		org.w3c.dom.Document doc = null;
	    doc = factory.newDocumentBuilder().parse(new InputSource(new StringReader(str)));
		XPathFactory xFactory = XPathFactory.newInstance();
	    XPath xPath = xFactory.newXPath();
	    Object result = xPath.compile("/Envelope/Body/getAvailabilityResponse").evaluate(doc, XPathConstants.NODESET);
	    NodeList nodes = (NodeList) result;
	    System.out.println("Found " + nodes.getLength() + " matches");
	    for (int index = 0; index < nodes.getLength(); index++) {
	        Node node = nodes.item(index);
	        System.out.println(node);
	        if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element firstPersonElement = (Element) node;
                NodeList commontag = firstPersonElement.getElementsByTagName("out");
                Element com_name = (Element) commontag.item(0);
                NodeList textComList = com_name.getChildNodes();
                String common = ((Node) textComList.item(0)).getNodeValue().replaceAll("&","a");
                out1.println(common);
           
}
			    }	
    }  
    catch(Exception e){}

			
	}
	
	public static void copy(String a_inputstr, OutputStream out) throws IOException {
		// do not allow other threads to read from the
		// input or write to the output while copying is
		// taking place
		synchronized (out) {
			byte[] buffer = a_inputstr.getBytes();
			int bytesRead = buffer.length;//      in.read(buffer);
			out.write(buffer, 0, bytesRead);
		}
	}


}
