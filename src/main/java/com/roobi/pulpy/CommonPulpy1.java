package com.roobi.pulpy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class CommonPulpy1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Content-Type","text/xml; charset=UTF-8");
		PrintWriter out=response.getWriter();
		String appid=request.getParameter("appid");
		String pid=request.getParameter("pid");String s1=request.getParameter("s1");String s2=request.getParameter("s2");
		String s3=request.getParameter("s3");String s4=request.getParameter("s4");
		String s5=request.getParameter("s5");String s6=request.getParameter("s6");
		String paid=request.getParameter("paid");String th1=request.getParameter("th1");String th2=request.getParameter("th2");
		String th3=request.getParameter("th3");String th4=request.getParameter("th4");
		String th5=request.getParameter("th5");String th6=request.getParameter("th6");
        Connection con=null;
		try{
	    Class.forName("com.mysql.jdbc.Driver").newInstance();
        String url1 = "jdbc:mysql://localhost/MPULPY";
        final String USER = "root";
        final String PASS = "root";
        con = DriverManager.getConnection(url1,USER,PASS);
	    PreparedStatement st=con.prepareStatement("SELECT * FROM authen c1  JOIN secondconfig c2 ON c1.id=c2.id JOIN secxmlconfig cx2 ON c1.id=cx2.id JOIN thirdconfig c3 ON c1.id=c3.id JOIN thrdxmlconfig cx3 on c1.id=cx3.id JOIN config c4 ON c1.id=c4.id  WHERE c1.id=?");
	    st.setString(1, appid);
        ResultSet rs = st.executeQuery();
        while(rs.next()){ // retrieve data from Database and join two tables namely(config&xmlconfig)
        	String id=rs.getString("id");	 String appname1=rs.getString("appname");
            String authen1=rs.getString("auth");String ba1=rs.getString("b1");String ba2=rs.getString("b2");
            String ba3=rs.getString("b3");String ba4=rs.getString("b4");;String rf1=rs.getString("rf");String rm1=rs.getString("rm");
                 String oriapilabel=rs.getString("a1"); String oriapikey=rs.getString("a2"); String resf1=rs.getString("resf");String endurl1=rs.getString("endurl");//get from secondconfig
            String securl1=rs.getString("securl");String cycle1=rs.getString("cycle");String secid=rs.getString("sec1"); String secval=rs.getString("sec2");
            String ak1=rs.getString("alabel1");String ak2=rs.getString("akey1");String se1=rs.getString("s1"); String sev1=rs.getString("sv1");String se2=rs.getString("s2"); String sev2=rs.getString("sv2");
            String se3=rs.getString("s3"); String sev3=rs.getString("sv3");String se4=rs.getString("s4"); String sev4=rs.getString("sv4");
            String se5=rs.getString("s5"); String sev5=rs.getString("sv5");String se6=rs.getString("s6"); String sev6=rs.getString("sv6");
            String se7=rs.getString("s7"); String sev7=rs.getString("sv7");String se8=rs.getString("s8"); String sev8=rs.getString("sv8");
            String se9=rs.getString("s9"); String sev9=rs.getString("sv9");String se10=rs.getString("s10"); String sev10=rs.getString("sv10");
  String secroot=rs.getString("secroot");String secparent=rs.getString("secparent"); //get from secxmlconfig
 String sx1=rs.getString("sx1"); String sxv1=rs.getString("sxv1");String sx2=rs.getString("sx2"); String sxv2=rs.getString("sxv2");
 String sx3=rs.getString("sx3"); String sxv3=rs.getString("sxv3");String sx4=rs.getString("sx4"); String sxv4=rs.getString("sxv4");
 String sx5=rs.getString("sx5"); String sxv5=rs.getString("sxv5");String sx6=rs.getString("sx6"); String sxv6=rs.getString("sxv6");
 String sx7=rs.getString("sx7"); String sxv7=rs.getString("sxv7");String sx8=rs.getString("sx8"); String sxv8=rs.getString("sxv8");
 String sx9=rs.getString("sx9"); String sxv9=rs.getString("sxv9");String sx10=rs.getString("sx10"); String sxv10=rs.getString("sxv10");
 String sx11=rs.getString("sx11"); String sxv11=rs.getString("sxv11");String sx12=rs.getString("sx12"); String sxv12=rs.getString("sxv12");
 String sx13=rs.getString("sx13"); String sxv13=rs.getString("sxv13");String sx14=rs.getString("sx14"); String sxv14=rs.getString("sxv14");
 String sx15=rs.getString("sx15"); String sxv15=rs.getString("sxv15");String sx16=rs.getString("sx16"); String sxv16=rs.getString("sxv16");
 String sx17=rs.getString("sx17"); String sxv17=rs.getString("sxv17");String sx18=rs.getString("sx18"); String sxv18=rs.getString("sxv18");
 String sx19=rs.getString("sx19"); String sxv19=rs.getString("sxv19");String sx20=rs.getString("sx20"); String sxv20=rs.getString("sxv20");
 String sx21=rs.getString("sx21"); String sxv21=rs.getString("sxv21");String sx22=rs.getString("sx22"); String sxv22=rs.getString("sxv22");
 String sx23=rs.getString("sx23"); String sxv23=rs.getString("sxv23");String sx24=rs.getString("sx24"); String sxv24=rs.getString("sxv24");
 String sx25=rs.getString("sx25"); String sxv25=rs.getString("sxv25");String sx26=rs.getString("sx26"); String sxv26=rs.getString("sxv26");
 String sx27=rs.getString("sx27"); String sxv27=rs.getString("sxv27");String sx28=rs.getString("sx28"); String sxv28=rs.getString("sxv28");
 String sx29=rs.getString("sx29"); String sxv29=rs.getString("sxv29");String sx30=rs.getString("sx30"); String sxv30=rs.getString("sxv30");
 //out.println(securl1);
 //get from thirdconfig
 String thirdurl1=rs.getString("thrdurl");String thirdcycle1=rs.getString("thrdcycle"); String akt1=rs.getString("alabel");String akt2=rs.getString("akey");
 String thrdid=rs.getString("thrd1"); String thrdval=rs.getString("thrd2");
 String tp1=rs.getString("t1"); String tpv1=rs.getString("tv1");String tp2=rs.getString("t2"); String tpv2=rs.getString("tv2");
 String tp3=rs.getString("t3"); String tpv3=rs.getString("tv3");String tp4=rs.getString("t4"); String tpv4=rs.getString("tv4");
 String tp5=rs.getString("t5"); String tpv5=rs.getString("tv5");String tp6=rs.getString("t6"); String tpv6=rs.getString("tv6");
 String tp7=rs.getString("t7"); String tpv7=rs.getString("tv7");String tp8=rs.getString("t8"); String tpv8=rs.getString("tv8");
 String tp9=rs.getString("t9"); String tpv9=rs.getString("tv9");String tp10=rs.getString("t10"); String tpv10=rs.getString("tv10");
 //get from thirdxmlconfig
 String thrdparent=rs.getString("thrdparent");String thrdroot=rs.getString("thrdroot");
 String tx1=rs.getString("tx1"); String txv1=rs.getString("txv1");String tx2=rs.getString("tx2"); String txv2=rs.getString("txv2");
 String tx3=rs.getString("tx3"); String txv3=rs.getString("txv3");String tx4=rs.getString("tx4"); String txv4=rs.getString("txv4");
 String tx5=rs.getString("tx5"); String txv5=rs.getString("txv5");String tx6=rs.getString("tx6"); String txv6=rs.getString("txv6");
 String tx7=rs.getString("tx7"); String txv7=rs.getString("txv7");String tx8=rs.getString("tx8"); String txv8=rs.getString("txv8");
 String tx9=rs.getString("tx9"); String txv9=rs.getString("txv9");String tx10=rs.getString("tx10"); String txv10=rs.getString("txv10");
 String tx11=rs.getString("tx11"); String txv11=rs.getString("txv11");String tx12=rs.getString("tx12"); String txv12=rs.getString("txv12");
 String tx13=rs.getString("tx13"); String txv13=rs.getString("txv13");String tx14=rs.getString("tx14"); String txv14=rs.getString("txv14");
 String tx15=rs.getString("tx15"); String txv15=rs.getString("txv15");String tx16=rs.getString("tx16"); String txv16=rs.getString("txv16");
 String tx17=rs.getString("tx17"); String txv17=rs.getString("txv17");String tx18=rs.getString("tx18"); String txv18=rs.getString("txv18");
 String tx19=rs.getString("tx19"); String txv19=rs.getString("txv19");String tx20=rs.getString("tx20"); String txv20=rs.getString("txv20");
 String tx21=rs.getString("tx21"); String txv21=rs.getString("txv21");String tx22=rs.getString("tx22"); String txv22=rs.getString("txv22");
 String tx23=rs.getString("tx23"); String txv23=rs.getString("txv23");String tx24=rs.getString("tx24"); String txv24=rs.getString("txv24");
 String tx25=rs.getString("tx25"); String txv25=rs.getString("txv25");String tx26=rs.getString("tx26"); String txv26=rs.getString("txv26");
 String tx27=rs.getString("tx27"); String txv27=rs.getString("txv27");String tx28=rs.getString("tx28"); String txv28=rs.getString("txv28");
 String tx29=rs.getString("tx29"); String txv29=rs.getString("txv29");String tx30=rs.getString("tx30"); String txv30=rs.getString("txv30");
// out.println(thirdurl1);
 
     String secdurl=null;
     if(authen1.equals("No Auth")){ //No Authentication
     if(rf1.equals("REST") && rm1.equals ("GET") && resf1.equals("XML")){  //No Auth GET XML
    	 if(!"null".equals(se1) && !"null".equals(se2) && !"null".equals(se3) && !"null".equals(se4) && !"null".equals(se5) && !"null".equals(se6)&& "entity".equals(cycle1)){
    		 secdurl=securl1+"?"+se1+"="+s1+"&"+se2+"="+s2+"&"+se3+"="+s3+"&"+se4+"="+s4+"&"+se5+"="+s5+"&"+se6+"="+s6;}
    		 
    		 else if(!"null".equals(se1) && !"null".equals(se2) && !"null".equals(se3) && !"null".equals(se4) && !"null".equals(se5)&& "entity".equals(cycle1)){
        		 secdurl=securl1+"?"+se1+"="+s1+"&"+se2+"="+s2+"&"+se3+"="+s3+"&"+se4+"="+s4+"&"+se5+"="+s5;}
    		 
    		 else if(!"null".equals(se1) && !"null".equals(se2) && !"null".equals(se3) && !"null".equals(se4)&& "entity".equals(cycle1)){
        		 secdurl=securl1+"?"+se1+"="+s1+"&"+se2+"="+s2+"&"+se3+"="+s3+"&"+se4+"="+s4;}
    		 
    	      
    		 else if(!"null".equals(se1) && !"null".equals(se2) && !"null".equals(se3)&& "entity".equals(cycle1)){
        		 secdurl=securl1+"?"+se1+"="+s1+"&"+se2+"="+s2+"&"+se3+"="+s3;}
    		 
    		 else if(!"null".equals(se1) && !"null".equals(se2)&& "entity".equals(cycle1)){
        		 secdurl=securl1+"?"+se1+"="+s1+"&"+se2+"="+s2;}
    		 
    		 else if(!"null".equals(se1)&& "entity".equals(cycle1)){
        		 secdurl=securl1+"?"+se1+"="+s1;}
    		 else if("null".equals(se1)&& "entity".equals(cycle1))
    			secdurl=securl1;
    		 else if("null".equals(secid) && "null".equals(pid) && "flow".equals(cycle1))
    		     secdurl=securl1+"/"+pid;
    	 
    		 else if(!"null".equals(se1) && !"null".equals(se2) && !"null".equals(se3)&& "flow".equals(cycle1)){
        		 secdurl=securl1+"?"+secid+"="+pid+"&"+se1+"="+s1+"&"+se2+"="+s2+"&"+se3+"="+s3;}
    		 
    		 else if(!"null".equals(se1) && !"null".equals(se2)&& "flow".equals(cycle1)){
        		 secdurl=securl1+"?"+secid+"="+pid+"&"+se1+"="+s1+"&"+se2+"="+s2;}
    		 
    		 else if(!"null".equals(se1)&& "flow".equals(cycle1)){
        		 secdurl=securl1+"?"+secid+"="+pid+"&"+se1+"="+s1;}
    	 
       		 else if("null".equals(se1)&& "entity".equals(cycle1))
    			secdurl=securl1;
    		 
    		 else if(!"null".equals(secid)&& !"null".equals(pid) && "null".equals(ak1) && "null".equals(ak2)&& "flow".equals(cycle1))
    			 secdurl=securl1+"?"+secid+"="+pid;
    		 else if(!"null".equals(ak1) && !"null".equals(ak2)&& "entity".equals(cycle1))
    			 secdurl=securl1+"?"+ak1+"="+ak2;


     
     }}
 
 else if(authen1.equals("API keys")){  //API Keys
	 if(rf1.equals("REST") && rm1.equals ("GET") && resf1.equals("XML")){  //API XML get
		 if(!"null".equals(se1) && !"null".equals(se2) && !"null".equals(se3) && !"null".equals(se4) && !"null".equals(se5) && !"null".equals(se6)&& "entity".equals(cycle1)){
		     secdurl=securl1+"?"+ak1+"="+ak2+"&"+se1+"="+s1+"&"+se2+"="+s2+"&"+se3+"="+s3+"&"+se4+"="+s4+"&"+se5+"="+s5+"&"+se6+"="+s6;}
		 
		 else if(!"null".equals(se1) && !"null".equals(se2) && !"null".equals(se3) && !"null".equals(se4) && !"null".equals(se5)&& "entity".equals(cycle1)){
    		 secdurl=securl1+"?"+ak1+"="+ak2+"&"+se1+"="+s1+"&"+se2+"="+s2+"&"+se3+"="+s3+"&"+se4+"="+s4+"&"+se5+"="+s5;}
		 
		 else if(!"null".equals(se1) && !"null".equals(se2) && !"null".equals(se3) && !"null".equals(se4)&& "entity".equals(cycle1)){
    		 secdurl=securl1+"?"+ak1+"="+ak2+"&"+se1+"="+s1+"&"+se2+"="+s2+"&"+se3+"="+s3+"&"+se4+"="+s4;}
		 
		 else if(!"null".equals(se1) && !"null".equals(se2) && !"null".equals(se3)&& "entity".equals(cycle1)){
    		 secdurl=securl1+"?"+ak1+"="+ak2+"&"+se1+"="+s1+"&"+se2+"="+s2+"&"+se3+"="+s3;}
		 
		 else if(!"null".equals(se1) && !"null".equals(se2)&& "entity".equals(cycle1)){
    		 secdurl=securl1+"?"+ak1+"="+ak2+"&"+se1+"="+s1+"&"+se2+"="+s2;}
		 
		 else if(!"null".equals(se1)&& "entity".equals(cycle1)){
    		 secdurl=securl1+"?"+ak1+"="+ak2+"&"+se1+"="+s1;}
		 
		 else if(!"null".equals(se1) && !"null".equals(se2) && !"null".equals(se3) && "flow".equals(cycle1)){
    		 secdurl=securl1+"?"+oriapilabel+"="+oriapikey+"&"+secid+"="+pid+"&"+se1+"="+s1+"&"+se2+"="+s2+"&"+se3+"="+s3;}
		 
		 else if(!"null".equals(se1) && !"null".equals(se2)&& "flow".equals(cycle1)){
    		 secdurl=securl1+"?"+oriapilabel+"="+oriapikey+"&"+secid+"="+pid+"&"+se1+"="+s1+"&"+se2+"="+s2;}
		 
		 else if(!"null".equals(se1)&& "flow".equals(cycle1)){
    		 secdurl=securl1+"?"+oriapilabel+"="+oriapikey+"&"+secid+"="+pid+"&"+se1+"="+s1;}
		 
		 else if(!"null".equals(secid)&& !"null".equals(pid) && "flow".equals(cycle1))
			 secdurl=securl1+"?"+secid+"="+pid;
		 else if("null".equals(secid) && "null".equals(pid) && "flow".equals(cycle1))
		     secdurl=securl1+"/"+pid;
		 else if(!"null".equals(ak1) && !"null".equals(ak2)&& "entity".equals(cycle1))
		      secdurl=securl1+"?"+ak1+"="+ak2;
		 else if("null".equals(ak1) && "null".equals(ak2) && "entity".equals(cycle1))
			      secdurl=securl1;		 

		 }}
  //out.println(secdurl);
 Document doc=null;  //TO Convert XMLSTRING TO DOCUMENT
 DocumentBuilder builder=null;
 DocumentBuilderFactory domFactory=DocumentBuilderFactory.newInstance();
 builder=domFactory.newDocumentBuilder();
        doc=builder.parse(new URL(secdurl).openStream());
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
          		
          	/*	if(!"null".equals(sx3)){
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
          		
          		/*if(!"null".equals(sx6)){
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
          		outputEvent.appendChild(param30);}*/
           		outevent.appendChild(outputEvent);
          	}}
        outdoc.appendChild(outevent);
          	
             	
          	// third API
          	
          	
          	
        	Document doc1=null;  //TO Convert XMLSTRING TO DOCUMENT
            DocumentBuilder builder1=null;
            DocumentBuilderFactory domFactory1=DocumentBuilderFactory.newInstance();
            builder1=domFactory1.newDocumentBuilder();
            String thirdurl11=null;
            if(authen1.equals("No Auth")){ //No Authentication
     	         if(rf1.equals("REST") && rm1.equals ("GET") && resf1.equals("XML")){  //No Auth GET XML

     	        	 if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3) && !"null".equals(tp4) && !"null".equals(tp5) && !"null".equals(tp6) && "entity".equals(thirdcycle1)){
     	        		 thirdurl11=thirdurl1+"?"+tp1+"="+th1+"&"+tp2+"="+th2+"&"+tp3+"="+th3+"&"+tp4+"="+th4+"&"+tp5+"="+th5+"&"+tp6+"="+th6;}
     	        		 
     	        		 else if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3) && !"null".equals(tp4) && !"null".equals(tp5)&& "entity".equals(thirdcycle1)){
     		        		 thirdurl11=thirdurl1+"?"+tp1+"="+th1+"&"+tp2+"="+th2+"&"+tp3+"="+th3+"&"+tp4+"="+th4+"&"+tp5+"="+th5;}
     	        		 
     	        		 else if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3) && !"null".equals(tp4)&& "entity".equals(thirdcycle1)){
     		        		 thirdurl11=thirdurl1+"?"+tp1+"="+th1+"&"+tp2+"="+th2+"&"+tp3+"="+th3+"&"+tp4+"="+th4;}
     	        		 
     	        		 else if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3)&& "entity".equals(thirdcycle1)){
     		        		 thirdurl11=thirdurl1+"?"+tp1+"="+th1+"&"+tp2+"="+th2+"&"+tp3+"="+th3;}
     	        		 
     	        		 else if(!"null".equals(tp1) && !"null".equals(tp2)&& "entity".equals(thirdcycle1)){
     		        		 thirdurl11=thirdurl1+"?"+tp1+"="+th1+"&"+tp2+"="+th2;}
     	        		 
     	        		 else if(!"null".equals(tp1)&& "entity".equals(thirdcycle1)){
     		        		 thirdurl11=thirdurl1+"?"+tp1+"="+th1;}
     	        		 else if("null".equals(tp1)&& "entity".equals(thirdcycle1))
     	        			thirdurl11=thirdurl1;
     	        	 
     	        		 else if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3)&& "flow".equals(thirdcycle1)){
     		        		 thirdurl11=thirdurl1+"?"+thrdid+"="+paid+"&"+tp1+"="+th1+"&"+tp2+"="+th2+"&"+tp3+"="+th3;}
     	        		 
     	        		 else if(!"null".equals(tp1) && !"null".equals(tp2)&& "flow".equals(thirdcycle1)){
     		        		 thirdurl11=thirdurl1+"?"+thrdid+"="+paid+"&"+tp1+"="+th1+"&"+tp2+"="+th2;}
     	        		 
     	        		 else if(!"null".equals(tp1)&& "flow".equals(thirdcycle1)){
     		        		 thirdurl11=thirdurl1+"?"+thrdid+"="+paid+"&"+tp1+"="+th1;}
     	        		 
     	        		 else if(!"null".equals(thrdid)&& !"null".equals(thrdval) && "null".equals(ak1) && "null".equals(ak2))
     	        			 thirdurl11=thirdurl1+"?"+thrdid+"="+paid;
     	        		 else if(!"null".equals(ak1) && !"null".equals(ak2))
     	        			 thirdurl11=thirdurl1+"?"+ak1+"="+ak2;
     	         }}
            else if(authen1.equals("API keys")){  //API Keys
           	 if(rf1.equals("REST") && rm1.equals ("GET") && resf1.equals("XML")){  //API XML get
           		 

           		 if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3) && !"null".equals(tp4) && !"null".equals(tp5) && !"null".equals(tp6)&& "entity".equals(thirdcycle1)){
           		     thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+th1+"&"+tp2+"="+th2+"&"+tp3+"="+th3+"&"+tp4+"="+th4+"&"+tp5+"="+th5+"&"+tp6+"="+th6;}
           		 
           		 else if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3) && !"null".equals(tp4) && !"null".equals(tp5)&& "entity".equals(thirdcycle1)){
     	        		 thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+th1+"&"+tp2+"="+th2+"&"+tp3+"="+th3+"&"+tp4+"="+th4+"&"+tp5+"="+th5;}
           		 
           		 else if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3) && !"null".equals(tp4)&& "entity".equals(thirdcycle1)){
     	        		 thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+th1+"&"+tp2+"="+th2+"&"+tp3+"="+th3+"&"+tp4+"="+th4;}
           		 
           		 else if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3)&& "entity".equals(thirdcycle1)){
     	        		 thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+th1+"&"+tp2+"="+th2+"&"+tp3+"="+th3;}
           		 
           		 else if(!"null".equals(tp1) && !"null".equals(tp2)&& "entity".equals(thirdcycle1)){
     	        		 thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+th1+"&"+tp2+"="+th2;}
           		 
           		 else if(!"null".equals(tp1)&& "entity".equals(thirdcycle1)){
     	        		 thirdurl11=thirdurl1+"?"+akt1+"="+akt2+"&"+tp1+"="+th1;}
           		 
           		 else if(!"null".equals(thrdid)&& !"null".equals(thrdval) && "flow".equals(thirdcycle1)&&!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3)){
     	        		 thirdurl11=thirdurl1+"?"+oriapilabel+"="+oriapikey+"&"+thrdid+"="+paid+"&"+tp1+"="+th1+"&"+tp2+"="+th2+"&"+tp3+"="+th3;}
           		 
           		 else if(!"null".equals(thrdid)&& !"null".equals(thrdval) && "flow".equals(thirdcycle1)&&!"null".equals(tp1) && !"null".equals(tp2)){
     	        		 thirdurl11=thirdurl1+"?"+oriapilabel+"="+oriapikey+"&"+thrdid+"="+paid+"&"+tp1+"="+th1+"&"+tp2+"="+th2;}
           		 
           		 else if(!"null".equals(thrdid)&& !"null".equals(thrdval) && "flow".equals(thirdcycle1)&&!"null".equals(tp1)){
     	        		 thirdurl11=thirdurl1+"?"+oriapilabel+"="+oriapikey+"&"+thrdid+"="+paid+"&"+tp1+"="+th1;}
           		 
           		 else if(!"null".equals(thrdid)&& !"null".equals(thrdval) && "flow".equals(thirdcycle1))
           			 thirdurl11=thirdurl1+"?"+oriapilabel+"="+oriapikey+"&"+thrdid+"="+paid;
           		
           		 else if(!"null".equals(akt1) && !"null".equals(akt2)&& "entity".equals(thirdcycle1))
           			      thirdurl11=thirdurl1+"?"+akt1+"="+akt2;}}
            
       //     out.println(thirdurl11);
            doc1=builder1.parse(new URL(thirdurl11).openStream());
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
         		
         	/*	if(!"null".equals(tx6)){
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
         		outputEvent1.appendChild(params30);}*/
             	outevent1.appendChild(outputEvent1);

       	  	       		
         	}   
              }
              outdoc1.appendChild(outevent1); //the full formed mpulpy xml now in document
        
               	  
      
               
          
              Element fromRoot = outdoc.getDocumentElement();
              Element toRoot = outdoc1.getDocumentElement();

              Node child = null;
              while ((child = fromRoot.getFirstChild()) != null) {
                  outdoc1.adoptNode(child);
                  toRoot.appendChild(child);
              }  
              
                                       
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
      output=new BufferedWriter(new FileWriter("F:/workspace/mind.xml"));
      String xmloutput=result.getWriter().toString();
      output.write(xmloutput);
      output.close();
      out.println(xmloutput);
   	
       	
		
    	
    	
    	
  }
	}
    
              
		catch(Exception e){
			
		}
	}

}
