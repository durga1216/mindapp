package com.roobi.pulpy;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.io.StringReader;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.http.HttpRequest;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.XML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class JsonToXmlPulpy extends HttpServlet {
	private static final long serialVersionUID = 1L;
     public JsonToXmlPulpy() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Content-Type","application/json; charset=UTF-8");
		PrintWriter out=response.getWriter();
		DocumentBuilder builder = null;
        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance(); 
        domFactory.setIgnoringElementContentWhitespace(true);

        try{
                	DocumentBuilder docBuilder = null;
                    URL url = new URL ("https://api.evvnt.com/events");
                    String encoding = new String(
                    		 org.apache.commons.codec.binary.Base64.encodeBase64   
                    		    (org.apache.commons.codec.binary.StringUtils.getBytesUtf8("minddots:9eed9bcc4ffbbc03324f139e977903ba"))
                    		  );
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                   HttpRequest httprequest;
                    
                    connection.setRequestMethod("GET");
                    connection.setDoOutput(true);
                    connection.setRequestProperty  ("Authorization", "Basic " + encoding);
                    InputStream content = (InputStream)connection.getInputStream();
                    BufferedReader in   = 
                        new BufferedReader (new InputStreamReader (content));
                   
                    String line=null;
                    while((line=in.readLine())!=null){
                    	/*JSON json = JSONSerializer.toJSON( line );  
          	          XMLSerializer xmlSerializer = new XMLSerializer();  
          	          xmlSerializer.setTypeHintsEnabled(false);
          	          xmlSerializer.setSkipWhitespace(true);
          	          xmlSerializer.setTrimSpaces(true);
          	          xmlSerializer.setRemoveNamespacePrefixFromElements(true);
          	          xmlSerializer.removeNamespace(line);
          	          xmlSerializer.setForceTopLevelObject(false);
          	          String xmlout=xmlSerializer.write(json);*/
                   /* final JSONTokener jt=new JSONTokener(line);  
                    final JSONArray jsonArray = new JSONArray(jt);  
                    final String xml1 = XML.toString(jsonArray,"doc");*/
                    out.println(line);
                    //System.out.println(xml1);
                    }
        		         }
        catch(Exception e){
        	out.println(e);
        }

	}

}
