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
import com.mysql.jdbc.PreparedStatement;

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
	    PreparedStatement st=(PreparedStatement) con.prepareStatement("SELECT * FROM authen1 t1 JOIN config t2 ON t1.appid = t2.appid JOIN xmlconfig t3 ON t1.appid=t3.appid JOIN secondconfig t4 ON t1.appid=t4.appid JOIN secxmlconfig t5 ON t1.appid=t5.appid JOIN thirdconfig t6 ON t1.appid=t6.appid JOIN thrdxmlconfig t7 ON t1.appid=t7.appid  WHERE t1.appid=?");
	    st.setString(1, appid);
        ResultSet rs = st.executeQuery();
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
                String securl1=rs.getString("securl");String cycle1=rs.getString("cycle");String secid=rs.getString("sec1"); String secval=rs.getString("sec2");
            String aks=rs.getString("alabel1");String aksv=rs.getString("akey1");String se1=rs.getString("s1"); String sev1=rs.getString("sv1");String se2=rs.getString("s2"); String sev2=rs.getString("sv2");
            String se3=rs.getString("s3"); String sev3=rs.getString("sv3");String se4=rs.getString("s4"); String sev4=rs.getString("sv4");
            String se5=rs.getString("s5"); String sev5=rs.getString("sv5");String se6=rs.getString("s6"); String sev6=rs.getString("sv6");
            String se7=rs.getString("s7"); String sev7=rs.getString("sv7");String se8=rs.getString("s8"); String sev8=rs.getString("sv8");
            String se9=rs.getString("s9"); String sev9=rs.getString("sv9");String se10=rs.getString("s10"); String sev10=rs.getString("sv10");
String resf2=rs.getString("resf2");
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
 //get from thirdconfig
 String thirdurl1=rs.getString("thrdurl");String thirdcycle1=rs.getString("thrdcycle"); String akt1=rs.getString("alabel");String akt2=rs.getString("akey");
 String thrdid=rs.getString("thrd1"); String thrdval=rs.getString("thrd2");
 String tp1=rs.getString("t1"); String tpv1=rs.getString("tv1");String tp2=rs.getString("t2"); String tpv2=rs.getString("tv2");
 String tp3=rs.getString("t3"); String tpv3=rs.getString("tv3");String tp4=rs.getString("t4"); String tpv4=rs.getString("tv4");
 String tp5=rs.getString("t5"); String tpv5=rs.getString("tv5");String tp6=rs.getString("t6"); String tpv6=rs.getString("tv6");
 String tp7=rs.getString("t7"); String tpv7=rs.getString("tv7");String tp8=rs.getString("t8"); String tpv8=rs.getString("tv8");
 String tp9=rs.getString("t9"); String tpv9=rs.getString("tv9");String tp10=rs.getString("t10"); String tpv10=rs.getString("tv10");
 String resf3=rs.getString("resf3");
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
        out.println(endurl1);
        
        }//while
	
	} // try
	
	  catch(Exception e){}

}
}