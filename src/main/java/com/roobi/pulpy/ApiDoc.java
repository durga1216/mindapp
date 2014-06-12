package com.roobi.pulpy;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mindots.util.Utils;
import java.sql.PreparedStatement;

public class ApiDoc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ApiDoc() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 Map<String, String> config = Utils.getConfigFromFile(getServletContext(), "config.properties");
	 PrintWriter out=response.getWriter();
		Connection con=null;
		 HttpSession session=request.getSession(true);
		 		try{
		String appid=request.getParameter("appid");		
	    Class.forName("com.mysql.jdbc.Driver").newInstance();
        con = (Connection) DriverManager.getConnection(config.get("URL"),config.get("USER"),config.get("PASS"));
	    PreparedStatement st=con.prepareStatement("SELECT * FROM authen1 t1 JOIN config t2 ON t1.appid = t2.appid JOIN xmlconfig t3 ON t1.appid=t3.appid  WHERE t1.appid=?");
	    st.setString(1, appid);
        ResultSet rs = st.executeQuery();
        PreparedStatement st1=con.prepareStatement("SELECT * FROM authen1 t1 JOIN secondconfig t2 ON t1.appid = t2.appid JOIN secxmlconfig t3 ON t1.appid=t3.appid  WHERE t1.appid=?");
	    st1.setString(1, appid);
        ResultSet rs1 = st1.executeQuery();
        PreparedStatement st2=con.prepareStatement("SELECT * FROM authen1 t1 JOIN thirdconfig t2 ON t1.appid = t2.appid JOIN thrdxmlconfig t3 ON t1.appid=t3.appid  WHERE t1.appid=?");
	    st2.setString(1, appid);
        ResultSet rs2 = st2.executeQuery();
        while(rs.next()){ 
        String id=rs.getString("id");	 String appname1=rs.getString("appname");
            String authen1=rs.getString("auth");String ba1=rs.getString("b1");String b2=rs.getString("b2");
            String ba3=rs.getString("b3");String b4=rs.getString("b4");String ak1=rs.getString("a1");
            String ak2=rs.getString("a2"); String cname=rs.getString("cname");
       	 String ckey=rs.getString("ckey"); String rmethod=rs.getString("rmethod");
       	 String csecname=rs.getString("csecname");
       	 String cseckey=rs.getString("cseckey");
       	 String sname=rs.getString("sname");
       	 String svalue=rs.getString("svalue");
       	 String aurl=rs.getString("aurl");
       	 String tokenurl=rs.getString("tokenurl");
       	 String tlabel=rs.getString("tlabel");
       	 String treplace=rs.getString("treplace");
       	 String el=rs.getString("el");
       	 String ev=rs.getString("ev");
         String rf1=rs.getString("rf");
         String h1=rs.getString("h1");String hv1=rs.getString("hv1");
         String h2=rs.getString("h2");String hv2=rs.getString("hv2");
         String h3=rs.getString("h3");String hv3=rs.getString("hv3");
         String h4=rs.getString("h4");String hv4=rs.getString("hv4");
         String h5=rs.getString("h5");String hv5=rs.getString("hv5");
	     String line=null;

            String rm1=rs.getString("rm");

        	String resf1=rs.getString("resf");String endurl1=rs.getString("endurl");
             String mname=rs.getString("baseurl");
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

            String xr=rs.getString("xr");String xrv=rs.getString("xrv");
            
 String x1=rs.getString("x1"); String xv1=rs.getString("xv1");String x2=rs.getString("x2"); String xv2=rs.getString("xv2");
 String x3=rs.getString("x3"); String xv3=rs.getString("xv3");String x4=rs.getString("x4"); String xv4=rs.getString("xv4");
 String x5=rs.getString("x5"); String xv5=rs.getString("xv5");String x6=rs.getString("x6"); String xv6=rs.getString("xv6");
 String x7=rs.getString("x7"); String xv7=rs.getString("xv7");String x8=rs.getString("x8"); String xv8=rs.getString("xv8");
 String x9=rs.getString("x9"); String xv9=rs.getString("xv9");String x10=rs.getString("x10"); String xv10=rs.getString("xv10");
 String x11=rs.getString("x11"); String xv11=rs.getString("xv11");String x12=rs.getString("x12"); String xv12=rs.getString("xv12");
 String x13=rs.getString("x13"); String xv13=rs.getString("xv13");String x14=rs.getString("x14"); String xv14=rs.getString("xv14");
 String x15=rs.getString("x15"); String xv15=rs.getString("xv15");String x16=rs.getString("x16"); String xv16=rs.getString("xv16");
 String x17=rs.getString("x17"); String xv17=rs.getString("xv17");String x18=rs.getString("x18"); String xv18=rs.getString("xv18");
 String x19=rs.getString("x19"); String xv19=rs.getString("xv19");String x20=rs.getString("x20"); String xv20=rs.getString("xv20");
 String x21=rs.getString("x21"); String xv21=rs.getString("xv21");String x22=rs.getString("x22"); String xv22=rs.getString("xv22");
 String x23=rs.getString("x23"); String xv23=rs.getString("xv23");String x24=rs.getString("x24"); String xv24=rs.getString("xv24");
 String x25=rs.getString("x25"); String xv25=rs.getString("xv25");String x26=rs.getString("x26"); String xv26=rs.getString("xv26");
 String x27=rs.getString("x27"); String xv27=rs.getString("xv27");String x28=rs.getString("x28"); String xv28=rs.getString("xv28");
 String x29=rs.getString("x29"); String xv29=rs.getString("xv29");String x30=rs.getString("x30"); String xv30=rs.getString("xv30");
 
if(!"null".equals(endurl1)){
	session.setAttribute("appname", appname1);
	session.setAttribute("authen", authen1);
    if(pa1!=null)
    	session.setAttribute("pa1",pa1);
    else if(pa2!=null)
    	session.setAttribute("pa2",pa2);
    else if(pa3!=null)
    	session.setAttribute("pa3",pa3);else if(pa4!=null)
        	session.setAttribute("pa4",pa4);else if(pa5!=null)
            	session.setAttribute("pa5",pa5);else if(pa6!=null)
                	session.setAttribute("pa6",pa6);else if(pa7!=null)
                    	session.setAttribute("pa7",pa7);else if(pa8!=null)
                        	session.setAttribute("pa8",pa8);else if(pa9!=null)
                            	session.setAttribute("pa9",pa9);else if(pa10!=null)
                                	session.setAttribute("pa10",pa10);
                                	
		 		}
 
 
 
 //second config
 
 
 
   /*   while(rs1.next){
                String securl1=rs1.getString("securl");String cycle1=rs1.getString("cycle");String secid=rs.getString("sec1"); String secval=rs.getString("sec2");
            String aks=rs1.getString("alabel1");String aksv=rs1.getString("akey1");String se1=rs.getString("s1"); String sev1=rs.getString("sv1");String se2=rs.getString("s2"); String sev2=rs.getString("sv2");
            String se3=rs1.getString("s3"); String sev3=rs1.getString("sv3");String se4=rs1.getString("s4"); String sev4=rs1.getString("sv4");
            String se5=rs1.getString("s5"); String sev5=rs1.getString("sv5");String se6=rs1.getString("s6"); String sev6=rs1.getString("sv6");
            String se7=rs1.getString("s7"); String sev7=rs1.getString("sv7");String se8=rs1.getString("s8"); String sev8=rs1.getString("sv8");
            String se9=rs1.getString("s9"); String sev9=rs1.getString("sv9");String se10=rs1.getString("s10"); String sev10=rs1.getString("sv10");
String resf2=rs1.getString("resf2");
            String secroot=rs1.getString("secroot");String secparent=rs1.getString("secparent"); //get from secxmlconfig
  
 String sx1=rs1.getString("sx1"); String sxv1=rs1.getString("sxv1");String sx2=rs1.getString("sx2"); String sxv2=rs1.getString("sxv2");
 String sx3=rs1.getString("sx3"); String sxv3=rs1.getString("sxv3");String sx4=rs1.getString("sx4"); String sxv4=rs1.getString("sxv4");
 String sx5=rs1.getString("sx5"); String sxv5=rs1.getString("sxv5");String sx6=rs1.getString("sx6"); String sxv6=rs1.getString("sxv6");
 String sx7=rs1.getString("sx7"); String sxv7=rs1.getString("sxv7");String sx8=rs1.getString("sx8"); String sxv8=rs1.getString("sxv8");
 String sx9=rs1.getString("sx9"); String sxv9=rs1.getString("sxv9");String sx10=rs1.getString("sx10"); String sxv10=rs1.getString("sxv10");
 String sx11=rs1.getString("sx11"); String sxv11=rs1.getString("sxv11");String sx12=rs1.getString("sx12"); String sxv12=rs1.getString("sxv12");
 String sx13=rs1.getString("sx13"); String sxv13=rs1.getString("sxv13");String sx14=rs1.getString("sx14"); String sxv14=rs1.getString("sxv14");
 String sx15=rs1.getString("sx15"); String sxv15=rs1.getString("sxv15");String sx16=rs1.getString("sx16"); String sxv16=rs1.getString("sxv16");
 String sx17=rs1.getString("sx17"); String sxv17=rs1.getString("sxv17");String sx18=rs1.getString("sx18"); String sxv18=rs1.getString("sxv18");
 String sx19=rs1.getString("sx19"); String sxv19=rs1.getString("sxv19");String sx20=rs1.getString("sx20"); String sxv20=rs1.getString("sxv20");
 String sx21=rs1.getString("sx21"); String sxv21=rs1.getString("sxv21");String sx22=rs1.getString("sx22"); String sxv22=rs1.getString("sxv22");
 String sx23=rs1.getString("sx23"); String sxv23=rs1.getString("sxv23");String sx24=rs1.getString("sx24"); String sxv24=rs1.getString("sxv24");
 String sx25=rs1.getString("sx25"); String sxv25=rs1.getString("sxv25");String sx26=rs1.getString("sx26"); String sxv26=rs1.getString("sxv26");
 String sx27=rs1.getString("sx27"); String sxv27=rs1.getString("sxv27");String sx28=rs1.getString("sx28"); String sxv28=rs1.getString("sxv28");
 String sx29=rs1.getString("sx29"); String sxv29=rs1.getString("sxv29");String sx30=rs1.getString("sx30"); String sxv30=rs1.getString("sxv30");
 
 
 
 }
 //get from thirdconfig
 
 
 while(rs2.next){
 String thirdurl1=rs2.getString("thrdurl");String thirdcycle1=rs2.getString("thrdcycle"); String akt1=rs2.getString("alabel");String akt2=rs2.getString("akey");
 String thrdid=rs2.getString("thrd1"); String thrdval=rs2.getString("thrd2");
 String tp1=rs2.getString("t1"); String tpv1=rs2.getString("tv1");String tp2=rs2.getString("t2"); String tpv2=rs2.getString("tv2");
 String tp3=rs2.getString("t3"); String tpv3=rs2.getString("tv3");String tp4=rs2.getString("t4"); String tpv4=rs2.getString("tv4");
 String tp5=rs2.getString("t5"); String tpv5=rs2.getString("tv5");String tp6=rs2.getString("t6"); String tpv6=rs2.getString("tv6");
 String tp7=rs2.getString("t7"); String tpv7=rs2.getString("tv7");String tp8=rs2.getString("t8"); String tpv8=rs2.getString("tv8");
 String tp9=rs2.getString("t9"); String tpv9=rs2.getString("tv9");String tp10=rs2.getString("t10"); String tpv10=rs2.getString("tv10");
 String resf3=rs2.getString("resf3");
 
 
 
 
 //get from thirdxmlconfig
 String thrdparent=rs2.getString("thrdparent");String thrdroot=rs2.getString("thrdroot");
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
 String tx21=rs2.getString("tx21"); String txv21=rs2.getString("txv21");String tx22=rs2.getString("tx22"); String txv22=rs2.getString("txv22");
 String tx23=rs2.getString("tx23"); String txv23=rs2.getString("txv23");String tx24=rs2.getString("tx24"); String txv24=rs2.getString("txv24");
 String tx25=rs2.getString("tx25"); String txv25=rs2.getString("txv25");String tx26=rs2.getString("tx26"); String txv26=rs2.getString("txv26");
 String tx27=rs2.getString("tx27"); String txv27=rs2.getString("txv27");String tx28=rs2.getString("tx28"); String txv28=rs2.getString("txv28");
 String tx29=rs2.getString("tx29"); String txv29=rs2.getString("txv29");String tx30=rs2.getString("tx30"); String txv30=rs2.getString("txv30");
        
        }//while  */
  
	
	} // try
	
	  catch(Exception e){}

}
}