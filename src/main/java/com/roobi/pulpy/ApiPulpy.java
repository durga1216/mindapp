package com.roobi.pulpy;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mindots.util.Utils;

public class ApiPulpy extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ApiPulpy() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		 Map<String, String> config = Utils.getConfigFromFile(getServletContext(), "config.properties");
		PrintWriter out=response.getWriter();
		Connection con=null;
		String ak1=null;String ak2=null,endurl="";
		 HttpSession session=request.getSession(true);
		  String id1=(String) session.getAttribute("id");
		
		try{
		    Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = (Connection) DriverManager.getConnection(config.get("URL"),config.get("USER"),config.get("PASS"));
		    PreparedStatement st=con.prepareStatement("SELECT * FROM authen1 c1 JOIN config c2 ON c1.id=c2.id WHERE c1.id=?");
		    st.setString(1,id1);
		    PreparedStatement st1=con.prepareStatement("SELECT * FROM authen1 c1 JOIN secondconfig c2 ON c1.id=c2.id WHERE c1.id=?");
		    st.setString(1,id1);
		    ResultSet rs = st.executeQuery();
		    ResultSet rs1 = st1.executeQuery();
	        out.println("<br><br><br><body bgcolor='#FF9900'><div id='re' style='color:#FFFFFF; font-family:verdana; font-size:40px;'><center>Mind Pulpy</center></div><br><br><div id='re1' style='color:#FFFFFF; font-family:verdana; font-size:25px;'><center>API Usage<center><div><br><br><table align='center' border='1' bordercolor='#FFFFFF' style='color:#FFFFFF; font-size:20px; font-family:verdana; width:100%;'><tr><th>Base_Url</th><th>Key_Label</th><th>Key_Value</th></tr>");
	        while(rs.next()){
	        	ak1=rs.getString("a1");
	            ak2=rs.getString("a2");
	            endurl=rs.getString("endurl");
	            String[] baseurl=endurl.split("/");
	            out.println("<tr><td>"+baseurl[0]+"//"+baseurl[2]+"</td><td>"+ak1+"</td><td>"+ak2+"</td></tr>");

	        }
	        while(rs1.next()){
	        	ak1=rs.getString("alabel1");
	            ak2=rs.getString("akey1");
	            endurl=rs.getString("securl");
	            String[] baseurl=endurl.split("/");
	            out.println("<tr><td>"+baseurl[0]+"//"+baseurl[2]+"</td><td>"+ak1+"</td><td>"+ak2+"</td></tr>");

	        }
	        out.println("</table></body>");
	        
		}
	    catch(Exception e){}
	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
}
}