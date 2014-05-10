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
		
		try{
		    Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = (Connection) DriverManager.getConnection(config.get("URL"),config.get("USER"),config.get("PASS"));
		    PreparedStatement st=con.prepareStatement("SELECT * FROM authen1 c1 JOIN config c2 ON c1.id=c2.id");
	        ResultSet rs = st.executeQuery();
	        out.println("<br><br><br><center><h2>Mind Pulpy</h2></center><body bgcolor='#FF9900'><br><br><table align='center' border='1' bordercolor='#000000' width=100><tr><th>Base_Url</th><th>Key_Label</th><th>Key_Value</th></tr>");
	        while(rs.next()){
	        	ak1=rs.getString("a1");
	            ak2=rs.getString("a2");
	            endurl=rs.getString("endurl");
	            String[] baseurl=endurl.split("/");
	            out.println("<tr><td>"+baseurl[1]+"//"+baseurl[2]+"</td><td>"+ak1+"</td><td>"+ak2+"</td></tr>");

	        }
	        out.println("</table></body>");
	        
		}
	    catch(Exception e){}
	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
}
}