package com.roobi.pulpy;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ApiDoc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ApiDoc() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 Map<String, String> config = Utils.getConfigFromFile(getServletContext(), "config.properties");
		Connection con=null;
		 HttpSession session=request.getSession(true);
		 		try{
	    Class.forName("com.mysql.jdbc.Driver").newInstance();
        con = (Connection) DriverManager.getConnection(config.get("URL"),config.get("USER"),config.get("PASS"));
	    PreparedStatement st=con.prepareStatement("SELECT * FROM authen1 t1 JOIN config t2 ON t1.appid = t2.appid JOIN xmlconfig t3 ON t1.appid=t3.appid JOIN secondconfig t4 ON t1.appid=t4.appid JOIN secxmlconfig t5 ON t1.appid=t5.appid JOIN thirdconfig t6 ON t1.appid=t6.appid JOIN thrdxmlconfig t7 ON t1.appid=t7.appid  WHERE t1.appid=?");
	    st.setString(1, appid);
        ResultSet rs = st.executeQuery();
        while(rs.next()){ 
        
        
        }//while
	
	} // try
	
	  catch(Exception e){}

}
}