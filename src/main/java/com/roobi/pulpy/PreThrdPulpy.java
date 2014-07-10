package com.roobi.pulpy;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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

import net.sf.json.JSON;
import net.sf.json.JSONSerializer;
import net.sf.json.xml.XMLSerializer;

import com.mindots.util.Utils;

/**
 * Servlet implementation class PreThrdPulpy
 */
@WebServlet("/PreThrdPulpy")
public class PreThrdPulpy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreThrdPulpy() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		 Map<String, String> config = Utils.getConfigFromFile(getServletContext(), "config.properties");
			response.setHeader("Content-Type","text/html;charset=UTF-8");
		HttpSession session=request.getSession(true);
		HttpSession session1=request.getSession(true);
		String id=(String) session.getAttribute("id");
		//String appid=(String) session.getAttribute("appid1");
		String appid="MPAPP_0507";
		String t1=(String) session1.getAttribute("ta1");String t2=(String) session1.getAttribute("ta2");
		String t3=(String) session1.getAttribute("ta3");String t7=(String) session1.getAttribute("ta7");
		String t4=(String) session1.getAttribute("ta4");String t8=(String) session1.getAttribute("ta8");
		String t5=(String) session1.getAttribute("ta5");String t9=(String) session1.getAttribute("ta9");
		String t6=(String) session1.getAttribute("ta6");String t10=(String) session1.getAttribute("ta10");
		String al=(String) session1.getAttribute("a1");String thirdcycle=(String) session1.getAttribute("cycle");
		String respf3=request.getParameter("rf");
		String thirdurl=request.getParameter("thrdurl");
		String ak=request.getParameter("a2");
		  String tv1=request.getParameter("p1"); String tv2=request.getParameter("p2");
		  String tv3=request.getParameter("p3"); 	 String tv4=request.getParameter("p4");
		  String tv5=request.getParameter("p5");   String tv6=request.getParameter("p6");
		  String tv7=request.getParameter("p7");  String tv8=request.getParameter("p8");
		 String tv9=request.getParameter("p9"); String tv10=request.getParameter("p10");
	    
		Connection con=null;
 	        try {
          Class.forName("com.mysql.jdbc.Driver").newInstance();
          con = (Connection) DriverManager.getConnection(config.get("URL"),config.get("USER"),config.get("PASS"));
          PreparedStatement st=con.prepareStatement("insert into prethird(id,appid,thrdurl,thrdcycle,alabel,akey,t1,tv1,t2,tv2,t3,tv3,t4,tv4,t5,tv5,t6,tv6,t7,tv7,t8,tv8,t9,tv9,t10,tv10,resf3) values ('"+id+"','"+appid+"','"+thirdurl+"','"+thirdcycle+"','"+al+"','"+ak+"','"+t1+"','"+tv1+"','"+t2+"','"+tv2+"','"+t3+"','"+tv3+"','"+t4+"','"+tv4+"','"+t5+"','"+tv5+"','"+t6+"','"+tv6+"','"+t7+"','"+tv7+"','"+t8+"','"+tv8+"','"+t9+"','"+tv9+"','"+t10+"','"+tv10+"','"+respf3+"')");                
          st.executeUpdate();
          st.close();
         // out.println("INsert sucess");
          st=con.prepareStatement("SELECT * FROM  prethird  WHERE appid=?");
          st.setString(1, "MPAPP_0507");
    
          ResultSet rs = st.executeQuery();
	         while(rs.next()){
           String thirdurl1=rs.getString("thrdurl");String thirdcycle1=rs.getString("thrdcycle"); String ak1=rs.getString("alabel");String ak2=rs.getString("akey");
           String tp1=rs.getString("t1"); String tpv1=rs.getString("tv1");String tp2=rs.getString("t2"); String tpv2=rs.getString("tv2");
           String tp3=rs.getString("t3"); String tpv3=rs.getString("tv3");String tp4=rs.getString("t4"); String tpv4=rs.getString("tv4");
           String tp5=rs.getString("t5"); String tpv5=rs.getString("tv5");String tp6=rs.getString("t6"); String tpv6=rs.getString("tv6");
           String tp7=rs.getString("t7"); String tpv7=rs.getString("tv7");String tp8=rs.getString("t8"); String tpv8=rs.getString("tv8");
           String tp9=rs.getString("t9"); String tpv9=rs.getString("tv9");String tp10=rs.getString("t10"); String tpv10=rs.getString("tv10");     
           String resf3=rs.getString("resf3");
	         //out.println(thirdurl1+"<br>"+ak1+"<br>"+ak2+"<br>"+authen1);
           String thirdurl11=null;

	        		 if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3) && !"null".equals(tp4) && !"null".equals(tp5) && !"null".equals(tp6)&& "entity".equals(thirdcycle1))
	        		     thirdurl11=thirdurl1+"?"+ak1+"="+ak2+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2+"&"+tp3+"="+tpv3+"&"+tp4+"="+tpv4+"&"+tp5+"="+tpv5+"&"+tp6+"="+tpv6;
	        		 
	        		 else if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3) && !"null".equals(tp4) && !"null".equals(tp5)&& "entity".equals(thirdcycle1))
		        		 thirdurl11=thirdurl1+"?"+ak1+"="+ak2+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2+"&"+tp3+"="+tpv3+"&"+tp4+"="+tpv4+"&"+tp5+"="+tpv5;
	        		 
	        		 else if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3) && !"null".equals(tp4)&& "entity".equals(thirdcycle1))
		        		 thirdurl11=thirdurl1+"?"+ak1+"="+ak2+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2+"&"+tp3+"="+tpv3+"&"+tp4+"="+tpv4;
	        		 
	        		 else if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3)&& "entity".equals(thirdcycle1))
		        		 thirdurl11=thirdurl1+"?"+ak1+"="+ak2+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2+"&"+tp3+"="+tpv3;
	        		 
	        		 else if(!"null".equals(tp1) && !"null".equals(tp2)&& "entity".equals(thirdcycle1))
		        		 thirdurl11=thirdurl1+"?"+ak1+"="+ak2+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2;
	        		 
	        		 else if(!"null".equals(tp1)&& "entity".equals(thirdcycle1))
		        		 thirdurl11=thirdurl1+"?"+ak1+"="+ak2+"&"+tp1+"="+tpv1;
	        		
	        		 else if(!"null".equals(ak1) && !"null".equals(ak2)&& "entity".equals(thirdcycle1))
	        			      thirdurl11=thirdurl1+"?"+ak1+"="+ak2;
	        		 
	        		 out.println(thirdurl11);
	        		 URL url1=new URL(thirdurl11);
	    
   				 URLConnection uconn = url1.openConnection();
   				 String str="";
                    BufferedReader br = new BufferedReader(new InputStreamReader(uconn.getInputStream()));
        		     String line=null;
        		     FileWriter fw=null;
        		     if(resf3.equals("XML")){
        		         while((line=br.readLine())!=null){
       	       		     str+=line;
          	         }} //if and while
        		     else if(resf3.equals("JSON")){ 
        		    	 while ((line = br.readLine()) != null) {
               	      JSON json = JSONSerializer.toJSON( line );  
		     	          XMLSerializer xmlSerializer = new XMLSerializer();  
		     	          xmlSerializer.setTypeHintsEnabled(false);
		     	          xmlSerializer.setSkipWhitespace(true);
		     	          xmlSerializer.setTrimSpaces(true);
		     	          xmlSerializer.setRemoveNamespacePrefixFromElements(true);
		     	          xmlSerializer.removeNamespace(line);
		     	          xmlSerializer.setForceTopLevelObject(false);
		     		      str = xmlSerializer.write( json );
        		    	 }} //elseif and while
        		     
        		  session.setAttribute("xml1", str);
	              out.println("<h2><center><font color='green'>Processing...</font></center></h3>");
		          response.setHeader("Refresh", "1; URL=prebuilt3_xml.jsp");		
	       
  } 	//while 
} // try

 	 catch(Exception e){
 		 out.println(e);

 	 }
	}

}

