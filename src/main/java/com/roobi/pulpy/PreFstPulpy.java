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
 * Servlet implementation class PreFstPulpy
 */
@WebServlet("/PreFstPulpy")
public class PreFstPulpy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreFstPulpy() {
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
		String t1=(String) session1.getAttribute("fa1");String t2=(String) session1.getAttribute("fa2");
		String t3=(String) session1.getAttribute("fa3");String t7=(String) session1.getAttribute("fa7");
		String t4=(String) session1.getAttribute("fa4");String t8=(String) session1.getAttribute("fa8");
		String t5=(String) session1.getAttribute("fa5");String t9=(String) session1.getAttribute("fa9");
		String t6=(String) session1.getAttribute("fa6");String t10=(String) session1.getAttribute("fa10");
		String al=(String) session1.getAttribute("a1");
		String respf3=request.getParameter("rf");
		String thirdurl=request.getParameter("endurl");
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
          PreparedStatement st1=con.prepareStatement("select preid from preid");
          ResultSet rs1=st1.executeQuery();
          while(rs1.next())
          {
        	  int preid=rs1.getInt("preid");
        	  session1.setAttribute("preid", preid);
          }   
          int appid=(Integer)session1.getAttribute("preid");
          PreparedStatement st=con.prepareStatement("insert into prefirst(id,appid,endurl,flabel,fkey,f1,fv1,f2,fv2,f3,fv3,f4,fv4,f5,fv5,f6,fv6,f7,fv7,f8,fv8,f9,fv9,f10,fv10,resf) values ('"+id+"','"+appid+"','"+thirdurl+"','"+al+"','"+ak+"','"+t1+"','"+tv1+"','"+t2+"','"+tv2+"','"+t3+"','"+tv3+"','"+t4+"','"+tv4+"','"+t5+"','"+tv5+"','"+t6+"','"+tv6+"','"+t7+"','"+tv7+"','"+t8+"','"+tv8+"','"+t9+"','"+tv9+"','"+t10+"','"+tv10+"','"+respf3+"')");                
          st.executeUpdate();
          st.close();
         // out.println("INsert sucess");
          st=con.prepareStatement("SELECT * FROM  prefirst  WHERE appid=?");
          st.setInt(1, appid);
    
          ResultSet rs = st.executeQuery();
	         while(rs.next()){
           String resf1=rs.getString("resf");//String eurl=rs.getString("endurl");
           String thirdurl1=rs.getString("endurl"); String ak1=rs.getString("flabel");String ak2=rs.getString("fkey");
           String tp1=rs.getString("f1"); String tpv1=rs.getString("fv1");String tp2=rs.getString("f2"); String tpv2=rs.getString("fv2");
           String tp3=rs.getString("f3"); String tpv3=rs.getString("fv3");String tp4=rs.getString("f4"); String tpv4=rs.getString("fv4");
           String tp5=rs.getString("f5"); String tpv5=rs.getString("fv5");String tp6=rs.getString("f6"); String tpv6=rs.getString("fv6");
           String tp7=rs.getString("f7"); String tpv7=rs.getString("fv7");String tp8=rs.getString("f8"); String tpv8=rs.getString("fv8");
           String tp9=rs.getString("f9"); String tpv9=rs.getString("fv9");String tp10=rs.getString("f10"); String tpv10=rs.getString("fv10");     
           String resf3=rs.getString("resf");
	         //out.println(thirdurl1+"<br>"+ak1+"<br>"+ak2+"<br>"+authen1);
           String thirdurl11=null;

	        		 if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3) && !"null".equals(tp4) && !"null".equals(tp5) && !"null".equals(tp6))
	        		     thirdurl11=thirdurl1+"?"+ak1+"="+ak2+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2+"&"+tp3+"="+tpv3+"&"+tp4+"="+tpv4+"&"+tp5+"="+tpv5+"&"+tp6+"="+tpv6;
	        		 
	        		 else if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3) && !"null".equals(tp4) && !"null".equals(tp5))
		        		 thirdurl11=thirdurl1+"?"+ak1+"="+ak2+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2+"&"+tp3+"="+tpv3+"&"+tp4+"="+tpv4+"&"+tp5+"="+tpv5;
	        		 
	        		 else if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3) && !"null".equals(tp4))
		        		 thirdurl11=thirdurl1+"?"+ak1+"="+ak2+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2+"&"+tp3+"="+tpv3+"&"+tp4+"="+tpv4;
	        		 
	        		 else if(!"null".equals(tp1) && !"null".equals(tp2) && !"null".equals(tp3))
		        		 thirdurl11=thirdurl1+"?"+ak1+"="+ak2+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2+"&"+tp3+"="+tpv3;
	        		 
	        		 else if(!"null".equals(tp1) && !"null".equals(tp2))
		        		 thirdurl11=thirdurl1+"?"+ak1+"="+ak2+"&"+tp1+"="+tpv1+"&"+tp2+"="+tpv2;
	        		 
	        		 else if(!"null".equals(tp1))
		        		 thirdurl11=thirdurl1+"?"+ak1+"="+ak2+"&"+tp1+"="+tpv1;
	        		
	        		 else if(!"null".equals(ak1) && !"null".equals(ak2))
	        			      thirdurl11=thirdurl1+"?"+ak1+"="+ak2;
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
		          response.setHeader("Refresh", "1; URL=prebuilt1_xml.jsp");		
	       
  } 	//while 
} // try

 	 catch(Exception e){
 		 out.println(e);
 	 }
	}

}

