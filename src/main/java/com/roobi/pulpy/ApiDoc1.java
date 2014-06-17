package com.roobi.pulpy;

import java.io.IOException;
import java.io.PrintWriter;
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

import com.mindots.util.Utils;

/**
 * Servlet implementation class ApiDoc1
 */
@WebServlet("/ApiDoc1")
public class ApiDoc1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApiDoc1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setHeader("Content-Type","text/html;charset=UTF-8");
		Map<String, String> config = Utils.getConfigFromFile(getServletContext(), "config.properties");
		 Connection con1=null;
		 out.println("<a style='color:#ffffff;margin-left:1250px;font-size:22px;' href='logsucess.jsp'>Back</a></div>");
        out.println("<style>h2{margin-right:150px;color:#ffffff;}option{font-size:22px;}select,th,td,input[type='text']{ padding:7px;text-align:left;text-weight:bold;width:250px;color:#FF9900;font-weight:bold;}input[type='submit']{color:#FFFFFF;background-color:#FF9900;border:solid 2px;border-radius:20px;padding:10px;width:120px;height:40px;font-family:verdana;font-size:17px;margin-left:50px;}</style>");
		 out.println("<html><body bgcolor='#FF9900'><br><center><h2>API Documentation</h2><br><form action='ApiDoc1' method='post'>"
			 		+ "<input type='text' name='usrid' placeholder='Enter Your APPID'>");
		
		 
		    out.println("</select><input type='submit' value='submit'><br></form>");



	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		response.setHeader("Content-Type","text/html;charset=UTF-8");
		Map<String, String> config = Utils.getConfigFromFile(getServletContext(), "config.properties");
		 Connection con=null;
		 Connection con1=null;
		 out.println("<a style='color:#ffffff;margin-left:1250px;font-size:22px;' href='logsucess.jsp'>Back</a></div>");
		out.println("<style>h2{margin-right:150px;color:#ffffff;}th{font-size:25px;color:#ffffff;font-weight:bold;}input[type='text']{padding:7px;text-align:left;text-weight:bold;width:250px;color:#FF9900;font-weight:bold;}select,td{ padding:7px;text-align:left;text-weight:bold;width:250px;color:#ffffff;font-weight:bold;}input[type='submit']{color:#FFFFFF;background-color:#FF9900;border:solid 2px;border-radius:20px;padding:10px;width:120px;height:40px;font-family:verdana;font-size:17px;margin-left:50px;}</style>");
		 out.println("<html><body bgcolor='#FF9900'><br><center><h2>API Documentation</h2><br><form action='ApiDoc1' method='post'>"
			 		+ "<input type='text' name='usrid' placeholder='Enter Your APPID'>");
			
			    out.println("<input type='submit' value='submit'>\n</form>");

		       
		String id=request.getParameter("usrid");
		 try{
			    Class.forName("com.mysql.jdbc.Driver").newInstance();
		        con = (Connection) DriverManager.getConnection(config.get("URL"),config.get("USER"),config.get("PASS"));
		        con1 = (Connection) DriverManager.getConnection(config.get("URL"),config.get("USER"),config.get("PASS"));
		        PreparedStatement st2=con1.prepareStatement("SELECT * FROM authen1 t1 JOIN secondconfig t2 ON t1.appid = t2.appid JOIN secxmlconfig t3 ON t1.appid=t3.appid  WHERE t1.appid=?");
			    st2.setString(1,id);
		        ResultSet rs2 = st2.executeQuery();
			    PreparedStatement st=con.prepareStatement("SELECT * FROM authen1 t1 JOIN config t2 ON t1.appid = t2.appid JOIN xmlconfig t3 ON t1.appid=t3.appid  WHERE t1.appid=?");
			    st.setString(1,id);

		        ResultSet rs = st.executeQuery();
		        PreparedStatement st3=con.prepareStatement("SELECT * FROM authen1 t1 JOIN thirdconfig t2 ON t1.appid = t2.appid JOIN thrdxmlconfig t3 ON t1.appid=t3.appid  WHERE t1.appid=?");
			    st3.setString(1, id);
		        ResultSet rs3 = st3.executeQuery();
		     
		        while(rs.next()){ // retrieve data from Database and join two tables namely(config&xmlconfig)
		        	String apppid=rs.getString("appid");
		        	String ak2=rs.getString("a2");String appname1=rs.getString("appname");
		            String authen1=rs.getString("auth");String ak1=rs.getString("a1");
		        	String pa1=rs.getString("p1");String pva1=rs.getString("pv1");
		            String pa2=rs.getString("p2");String pva2=rs.getString("pv2");
		            String pa3=rs.getString("p3");String pva3=rs.getString("pv3");
		            String pa4=rs.getString("p4");String pva4=rs.getString("pv4");
		            String pa5=rs.getString("p5");String pva5=rs.getString("pv5");
		            String pa6=rs.getString("p6");String pva6=rs.getString("pv6");
		            String pa7=rs.getString("p7");String pva7=rs.getString("pv7");
		            String pa8=rs.getString("p8");String pva8=rs.getString("pv8");
		            String pa9=rs.getString("p9");String pva9=rs.getString("pv9");
		            String pa10=rs.getString("p10");String pva10=rs.getString("pv10");
		            String rm1=rs.getString("rm");
		        	String resf1=rs.getString("resf");String endurl1=rs.getString("endurl");
		            String xr=rs.getString("xr");String xrv=rs.getString("xrv");		            
		            String x1=rs.getString("x1"); String xv1=rs.getString("xv1");String x2=rs.getString("x2"); String xv2=rs.getString("xv2");
		            String x3=rs.getString("x3"); String xv3=rs.getString("xv3");String x4=rs.getString("x4"); String xv4=rs.getString("xv4");
		            String x5=rs.getString("x5"); String xv5=rs.getString("xv5");String x6=rs.getString("x6"); String xv6=rs.getString("xv6");
		            String x7=rs.getString("x7"); String xv7=rs.getString("xv7");String x8=rs.getString("x8"); String xv8=rs.getString("xv8");
		            String x9=rs.getString("x9"); String xv9=rs.getString("xv9");String x10=rs.getString("x10"); String xv10=rs.getString("xv10");
		            out.println("<div><table align='left' border='0' bordercolor='#000000' style='margin-left:150px;'>");
		            out.println("<br><tr><th></th><th>First Configuration Details</th><tr>");
		            out.println("<tr><td>App_id:</td><td>"+apppid+"</td><tr>");
		            out.println("<tr><td>App_name:</td><td>"+appname1+"</td><tr>");
		            out.println("<tr><td>Client side Url:</td><td>https://mindapp-pulpy.rhcloud.com/AuthXmlPulpy</td><tr>");
		            out.println("<tr><td>Auth_type:</td><td>"+authen1+"</td><tr>");
		            out.println("<tr><td>Api_label:</td><td>"+ak1+"</td><tr>");
		            out.println("<tr><td>Api_key:</td><td>"+ak2+"</td><tr>");
		            out.println("<tr><td>Request_method:</td><td>"+rm1+"</td><tr>");
		            out.println("<tr><td>Response_Format:</td><td>"+resf1+"</td><tr>");
		            out.println("<tr><td>End_Url:</td><td>"+endurl1+"</td><tr>");
		            if(!pa1.equals("")&&!pa1.equals("null")){
		            out.println("<tr><td>param_1_label:</td><td>"+pa1+"</td></tr>");
		            out.println("<tr><td>param_1_value:</td><td>"+pva1+"</td></tr>");}
		            if(!pa2.equals("")&&!pa2.equals("null")){
			            out.println("<tr><td>param_2_label:</td><td>"+pa2+"</td></tr>");
			            out.println("<tr><td>param_2_value:</td><td>"+pva2+"</td></tr>");}
		            if(!pa3.equals("")&&!pa3.equals("null")){
			            out.println("<tr><td>param_3_label:</td><td>"+pa3+"</td></tr>");
			            out.println("<tr><td>param_3_value:</td><td>"+pva3+"</td></tr>");}
		            if(!pa4.equals("")&&!pa4.equals("null")){
			            out.println("<tr><td>param_4_label:</td><td>"+pa4+"</td></tr>");
			            out.println("<tr><td>param_4_value:</td><td>"+pva4+"</td></tr>");}
		            if(!pa5.equals("")&&!pa5.equals("null")){
			            out.println("<tr><td>param_5_label:</td><td>"+pa5+"</td></tr>");
			            out.println("<tr><td>param_5_value:</td><td>"+pva5+"</td></tr>");}
		            if(!pa6.equals("")&&!pa6.equals("null")){
			            out.println("<tr><td>param_6_label:</td><td>"+pa6+"</td></tr>");
			            out.println("<tr><td>param_6_value:</td><td>"+pva6+"</td></tr>");}
		            if(!pa7.equals("")&&!pa7.equals("null")){
			            out.println("<tr><td>param_7_label:</td><td>"+pa7+"</td></tr>");
			            out.println("<tr><td>param_7_value:</td><td>"+pva7+"</td></tr>");}
		            if(!pa8.equals("")&&!pa8.equals("null")){
			            out.println("<tr><td>param_8_label:</td><td>"+pa8+"</td></tr>");
			            out.println("<tr><td>param_8_value:</td><td>"+pva8+"</td></tr>");}
		            if(!xr.equals("")&&!xr.equals("null")){
		            out.println("<tr><td>xml_Parant_tag</td><td>"+xr+"</td></tr>");}
		            if(!x1.equals("")&&!x1.equals("null")){
			            out.println("<tr><td>xml_1_label:</td><td>"+x1+"</td></tr>");
			            out.println("<tr><td>xml_1_value:</td><td>"+xv1+"</td></tr>");}
			            if(!x2.equals("")&&!x2.equals("null")){
				            out.println("<tr><td>xml_2_label:</td><td>"+x2+"</td></tr>");
				            out.println("<tr><td>xml_2_value:</td><td>"+xv2+"</td></tr>");}
			            if(!x3.equals("")&&!x3.equals("null")){
				            out.println("<tr><td>xml_3_label:</td><td>"+x3+"</td></tr>");
				            out.println("<tr><td>xml_3_value:</td><td>"+xv3+"</td></tr>");}
			            if(!x4.equals("")&&!x4.equals("null")){
				            out.println("<tr><td>xml_4_label:</td><td>"+x4+"</td></tr>");
				            out.println("<tr><td>xml_4_value:</td><td>"+xv4+"</td></tr>");}
			            if(!x5.equals("")&&!x5.equals("null")){
				            out.println("<tr><td>xml_5_label:</td><td>"+x5+"</td></tr>");
				            out.println("<tr><td>xml_5_value:</td><td>"+xv5+"</td></tr>");}
			            if(!x6.equals("")&&!x6.equals("null")){
				            out.println("<tr><td>xml_6_label:</td><td>"+x6+"</td></tr>");
				            out.println("<tr><td>xml_6_value:</td><td>"+xv6+"</td></tr>");}
			            if(!x7.equals("")&&!x7.equals("null")){
				            out.println("<tr><td>xml_7_label:</td><td>"+x7+"</td></tr>");
				            out.println("<tr><td>xml_7_value:</td><td>"+xv7+"</td></tr>");}
			            if(!x8.equals("")&&!x8.equals("null")){
				            out.println("<tr><td>xml_8_label:</td><td>"+x8+"</td></tr>");
				            out.println("<tr><td>xml_8_value:</td><td>"+xv8+"</td></tr>");}
				      
		            out.println("</table><div>");
		            break;
		        		        }
		        while(rs2.next()){
		         	String akey1=rs2.getString("akey1");String alabel1=rs2.getString("alabel1");
		            String securl1=rs2.getString("securl");String cycle1=rs2.getString("cycle");
		        	String sa1=rs2.getString("s1");String sva1=rs2.getString("sv1");
		            String sa2=rs2.getString("s2");String sva2=rs2.getString("sv2");
		            String sa3=rs2.getString("s3");String sva3=rs2.getString("sv3");
		            String sa4=rs2.getString("s4");String sva4=rs2.getString("sv4");
		            String sa5=rs2.getString("s5");String sva5=rs2.getString("sv5");
		            String sa6=rs2.getString("s6");String sva6=rs2.getString("sv6");
		            String sa7=rs2.getString("s7");String sva7=rs2.getString("sv7");
		            String sa8=rs2.getString("s8");String sva8=rs2.getString("sv8");
		            String sa9=rs2.getString("s9");String sva9=rs2.getString("sv9");
		            String sa10=rs2.getString("s10");String sva10=rs2.getString("sv10");
		            String secroot=rs2.getString("secroot");String secparent=rs2.getString("secparent"); //get from secxmlconfig
		            
		            String sx1=rs2.getString("sx1"); String sxv1=rs2.getString("sxv1");String sx2=rs2.getString("sx2"); String sxv2=rs2.getString("sxv2");
		            String sx3=rs2.getString("sx3"); String sxv3=rs2.getString("sxv3");String sx4=rs2.getString("sx4"); String sxv4=rs2.getString("sxv4");
		            String sx5=rs2.getString("sx5"); String sxv5=rs2.getString("sxv5");String sx6=rs2.getString("sx6"); String sxv6=rs2.getString("sxv6");
		            String sx7=rs2.getString("sx7"); String sxv7=rs2.getString("sxv7");String sx8=rs2.getString("sx8"); String sxv8=rs2.getString("sxv8");
		            String sx9=rs2.getString("sx9"); String sxv9=rs2.getString("sxv9");String sx10=rs2.getString("sx10"); String sxv10=rs2.getString("sxv10");
		            out.println("<br><br><table align='left' border='0' bordercolor='#000000' style='margin-left:150px;'>");
		            out.println("<tr><th></th><th>Second Configuration Details</th><tr>");
		            out.println("<tr><td>Sec Api-label:</td><td>"+alabel1+"</td><tr>");
		            out.println("<tr><td>sec Api-key:</td><td>"+akey1+"</td><tr>");
		            out.println("<tr><td>Cycle Type:</td><td>"+cycle1+"</td><tr>");
		            out.println("<tr><td>sec End_Url:</td><td>"+securl1+"</td><tr>");
		            if(!sa1.equals("")&&!sa1.equals("null")){
		            out.println("<tr><td>param_1_label:</td><td>"+sa1+"</td></tr>");
		            out.println("<tr><td>param_1_value:</td><td>"+sva1+"</td></tr>");}
		            if(!sa2.equals("")&&!sa2.equals("null")){
			            out.println("<tr><td>param_2_label:</td><td>"+sa2+"</td></tr>");
			            out.println("<tr><td>param_2_value:</td><td>"+sva2+"</td></tr>");}
		            if(!sa3.equals("")&&!sa3.equals("null")){
			            out.println("<tr><td>param_3_label:</td><td>"+sa3+"</td></tr>");
			            out.println("<tr><td>param_3_value:</td><td>"+sva3+"</td></tr>");}
		            if(!sa4.equals("")&&!sa4.equals("null")){
			            out.println("<tr><td>param_4_label:</td><td>"+sa4+"</td></tr>");
			            out.println("<tr><td>param_4_value:</td><td>"+sva4+"</td></tr>");}
		            if(!sa5.equals("")&&!sa5.equals("null")){
			            out.println("<tr><td>param_5_label:</td><td>"+sa5+"</td></tr>");
			            out.println("<tr><td>param_5_value:</td><td>"+sva5+"</td></tr>");}
		            if(!sa6.equals("")&&!sa6.equals("null")){
			            out.println("<tr><td>param_6_label:</td><td>"+sa6+"</td></tr>");
			            out.println("<tr><td>param_6_value:</td><td>"+sva6+"</td></tr>");}
		            if(!sa7.equals("")&&!sa7.equals("null")){
			            out.println("<tr><td>param_7_label:</td><td>"+sa7+"</td></tr>");
			            out.println("<tr><td>param_7_value:</td><td>"+sva7+"</td></tr>");}
		            if(!sa8.equals("")&&!sa8.equals("null")){
			            out.println("<tr><td>param_8_label:</td><td>"+sa8+"</td></tr>");
			            out.println("<tr><td>param_8_value:</td><td>"+sva8+"</td></tr>");}
		            if(!secroot.equals("")&&!secroot.equals("null")){
		            out.println("<tr><td>xml_Parant_tag</td><td>"+secroot+"</td></tr>");}
		            if(!!sx1.equals("")&&!sx1.equals("null")){
			            out.println("<tr><td>xml_1_label:</td><td>"+sx1+"</td></tr>");
			            out.println("<tr><td>xml_1_value:</td><td>"+sxv1+"</td></tr>");}
			            if(!sx2.equals("")&&!sx2.equals("null")){
				            out.println("<tr><td>xml_2_label:</td><td>"+sx2+"</td></tr>");
				            out.println("<tr><td>xml_2_value:</td><td>"+sxv2+"</td></tr>");}
			            if(!sx3.equals("")&&!sx3.equals("null")){
				            out.println("<tr><td>xml_3_label:</td><td>"+sx3+"</td></tr>");
				            out.println("<tr><td>xml_3_value:</td><td>"+sxv3+"</td></tr>");}
			            if(!sx4.equals("")&&!sx4.equals("null")){
				            out.println("<tr><td>xml_4_label:</td><td>"+sx4+"</td></tr>");
				            out.println("<tr><td>xml_4_value:</td><td>"+sxv4+"</td></tr>");}
			            if(!sx5.equals("")&&!sx5.equals("null")){
				            out.println("<tr><td>xml_5_label:</td><td>"+sx5+"</td></tr>");
				            out.println("<tr><td>xml_5_value:</td><td>"+sxv5+"</td></tr>");}
			            if(!sx6.equals("")&&!sx6.equals("null")){
				            out.println("<tr><td>xml_6_label:</td><td>"+sx6+"</td></tr>");
				            out.println("<tr><td>xml_6_value:</td><td>"+sxv6+"</td></tr>");}
			            if(!sx7.equals("")&&!sx7.equals("null")){
				            out.println("<tr><td>xml_7_label:</td><td>"+sx7+"</td></tr>");
				            out.println("<tr><td>xml_7_value:</td><td>"+sxv7+"</td></tr>");}
			            if(!sx8.equals("")&&!sx8.equals("null")){
				            out.println("<tr><td>xml_8_label:</td><td>"+sx8+"</td></tr>");
				            out.println("<tr><td>xml_8_value:</td><td>"+sxv8+"</td></tr>");}
				      
		            out.println("</table></div>");
		          
		        
		        }
		        while(rs3.next()){ // retrieve data from Database and join two tables namely(thrdconfig&thrdxmlconfig)
	            	String thirdurl1=rs3.getString("thrdurl");String thirdcycle1=rs3.getString("thrdcycle"); String akt1=rs3.getString("alabel");String akt2=rs3.getString("akey");
	            	 String thrdid=rs3.getString("thrd1"); String thrdval=rs3.getString("thrd2");
	            	 String tp1=rs3.getString("t1"); String tpv1=rs3.getString("tv1");String tp2=rs3.getString("t2"); String tpv2=rs3.getString("tv2");
	            	 String tp3=rs3.getString("t3"); String tpv3=rs3.getString("tv3");String tp4=rs3.getString("t4"); String tpv4=rs3.getString("tv4");
	            	 String tp5=rs3.getString("t5"); String tpv5=rs3.getString("tv5");String tp6=rs3.getString("t6"); String tpv6=rs3.getString("tv6");
	            	 String tp7=rs3.getString("t7"); String tpv7=rs3.getString("tv7");String tp8=rs3.getString("t8"); String tpv8=rs3.getString("tv8");
	            	 String tp9=rs3.getString("t9"); String tpv9=rs3.getString("tv9");String tp10=rs3.getString("t10"); String tpv10=rs3.getString("tv10");
	            	 String resf3=rs3.getString("resf3");
	            	 //get from thirdxmlconfig
	            	 String thrdparent=rs3.getString("thrdparent");String thrdroot=rs3.getString("thrdroot");
	            	 String tx1=rs3.getString("tx1"); String txv1=rs3.getString("txv1");String tx2=rs3.getString("tx2"); String txv2=rs3.getString("txv2");
	            	 String tx3=rs3.getString("tx3"); String txv3=rs3.getString("txv3");String tx4=rs3.getString("tx4"); String txv4=rs3.getString("txv4");
	            	 String tx5=rs3.getString("tx5"); String txv5=rs3.getString("txv5");String tx6=rs3.getString("tx6"); String txv6=rs3.getString("txv6");
	            	 String tx7=rs3.getString("tx7"); String txv7=rs3.getString("txv7");String tx8=rs3.getString("tx8"); String txv8=rs3.getString("txv8");
	            	 String tx9=rs3.getString("tx9"); String txv9=rs3.getString("txv9");String tx10=rs3.getString("tx10"); String txv10=rs3.getString("txv10");
		        
	            	 out.println("<br><br><table align='left' border='0' bordercolor='#000000' style='margin-left:150px;'>");
			            out.println("<tr><th></th><th>Third Configuration Details</th><tr>");
			            out.println("<tr><td>Third Api-label:</td><td>"+akt1+"</td><tr>");
			            out.println("<tr><td>Third Api-key:</td><td>"+akt2+"</td><tr>");
			            out.println("<tr><td>Third Cycle Type:</td><td>"+thirdcycle1+"</td><tr>");
			            out.println("<tr><td>Third End_Url:</td><td>"+thirdurl1+"</td><tr>");
			            if(!tp1.equals("")&&!tp1.equals("null")){
			            out.println("<tr><td>param_1_label:</td><td>"+tp1+"</td></tr>");
			            out.println("<tr><td>param_1_value:</td><td>"+tpv1+"</td></tr>");}
			            if(!tp2.equals("")&&!tp2.equals("null")){
				            out.println("<tr><td>param_2_label:</td><td>"+tp2+"</td></tr>");
				            out.println("<tr><td>param_2_value:</td><td>"+tpv2+"</td></tr>");}
			            if(!tp3.equals("")&&!tp3.equals("null")){
				            out.println("<tr><td>param_3_label:</td><td>"+tp3+"</td></tr>");
				            out.println("<tr><td>param_3_value:</td><td>"+tpv3+"</td></tr>");}
			            if(!tp4.equals("")&&!tp4.equals("null")){
				            out.println("<tr><td>param_4_label:</td><td>"+tp4+"</td></tr>");
				            out.println("<tr><td>param_4_value:</td><td>"+tpv4+"</td></tr>");}
			            if(!tp5.equals("")&&!tp5.equals("null")){
				            out.println("<tr><td>param_5_label:</td><td>"+tp5+"</td></tr>");
				            out.println("<tr><td>param_5_value:</td><td>"+tpv5+"</td></tr>");}
			            if(!tp6.equals("")&&!tp6.equals("null")){
				            out.println("<tr><td>param_6_label:</td><td>"+tp6+"</td></tr>");
				            out.println("<tr><td>param_6_value:</td><td>"+tpv6+"</td></tr>");}
			            if(!tp7.equals("")&&!tp7.equals("null")){
				            out.println("<tr><td>param_7_label:</td><td>"+tp7+"</td></tr>");
				            out.println("<tr><td>param_7_value:</td><td>"+tpv7+"</td></tr>");}
			            if(!tp8.equals("")&&!tp8.equals("null")){
				            out.println("<tr><td>param_8_label:</td><td>"+tp8+"</td></tr>");
				            out.println("<tr><td>param_8_value:</td><td>"+tpv8+"</td></tr>");}
			            if(!thrdparent.equals("")&&!thrdparent.equals("null")){
			            out.println("<tr><td>xml_Parant_tag</td><td>"+thrdparent+"</td></tr>");}
			            if(!!tx1.equals("")&&!tx1.equals("null")){
				            out.println("<tr><td>xml_1_label:</td><td>"+tx1+"</td></tr>");
				            out.println("<tr><td>xml_1_value:</td><td>"+txv1+"</td></tr>");}
				            if(!tx2.equals("")&&!tx2.equals("null")){
					            out.println("<tr><td>xml_2_label:</td><td>"+tx2+"</td></tr>");
					            out.println("<tr><td>xml_2_value:</td><td>"+txv2+"</td></tr>");}
				            if(!tx3.equals("")&&!tx3.equals("null")){
					            out.println("<tr><td>xml_3_label:</td><td>"+tx3+"</td></tr>");
					            out.println("<tr><td>xml_3_value:</td><td>"+txv3+"</td></tr>");}
				            if(!tx4.equals("")&&!tx4.equals("null")){
					            out.println("<tr><td>xml_4_label:</td><td>"+tx4+"</td></tr>");
					            out.println("<tr><td>xml_4_value:</td><td>"+txv4+"</td></tr>");}
				            if(!tx5.equals("")&&!tx5.equals("null")){
					            out.println("<tr><td>xml_5_label:</td><td>"+tx5+"</td></tr>");
					            out.println("<tr><td>xml_5_value:</td><td>"+txv5+"</td></tr>");}
				            if(!tx6.equals("")&&!tx6.equals("null")){
					            out.println("<tr><td>xml_6_label:</td><td>"+tx6+"</td></tr>");
					            out.println("<tr><td>xml_6_value:</td><td>"+txv6+"</td></tr>");}
				            if(!tx7.equals("")&&!tx7.equals("null")){
					            out.println("<tr><td>xml_7_label:</td><td>"+tx7+"</td></tr>");
					            out.println("<tr><td>xml_7_value:</td><td>"+txv7+"</td></tr>");}
				            if(!tx8.equals("")&&!tx8.equals("null")){
					            out.println("<tr><td>xml_8_label:</td><td>"+tx8+"</td></tr>");
					            out.println("<tr><td>xml_8_value:</td><td>"+txv8+"</td></tr>");}
					      
			            out.println("</table></div>");
		        
		        }
		        
	
		 }
	catch(Exception e)
	{
		}
	}

}
