package com.roobi.pulpy;

import java.awt.Desktop;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.FlickrApi;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

import com.mindots.util.Utils;

/**
 * Servlet implementation class Oauth1Call
 */
@WebServlet("/Oauth1Call")
public class Oauth1Call extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Oauth1Call() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con=null;  
	   	 response.setHeader("Content-Type","text/html;charset=UTF-8");
	   	InputStream inputStream=null;
		 Map<String, String> config = Utils.getConfigFromFile(getServletContext(), "config.properties");
        PrintWriter out=response.getWriter();
		String oauth_verifier=request.getParameter("oauth_verifier");
		HttpSession session=request.getSession(true);
		String id=(String) session.getAttribute("id");
	    String appid=(String) session.getAttribute("appid");
session.setAttribute("oauth_verifier", oauth_verifier);
	    Token requestToken=(Token) session.getAttribute("tok");
	    out.println("<h2><center><font color='green'>Processing...</font></center></h3>");
        response.setHeader("Refresh", "1; URL=auth.jsp");
       
}
	 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*String key="9f17ba0ed1e29e91e1e8829dd3e6f889";
		String secret="5e636fa8d8f0968b";
		int millis = (int) System.currentTimeMillis() * -1;
        int time = (int) millis / 1000;
        String nonce=String.valueOf(millis); 
        String tstmp=String.valueOf(time);
        String reqstr="GET&https%3A%2F%2Fwww.flickr.com%2Fservices%2Foauth%2Frequest_token&"
        		+ "oauth_consumer_key%3D"+key+""
        		+ "%26oauth_nonce%3D"+nonce+""
        		+ "%26oauth_signature_method%3DHMAC-SHA1"
        		+ "%26oauth_timestamp%3D"+tstmp+""
        		+ "%26oauth_version%3D1.0";
        try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = (Connection) DriverManager.getConnection(config.get("URL"),config.get("USER"),config.get("PASS"));
             PreparedStatement st=null;
             st=con.prepareStatement("SELECT * From authen1 where appid=?");
             st.setString(1, appid);
	         ResultSet rs = st.executeQuery();
	         while(rs.next()){
             String oapp1=rs.getString("oapp"); String oreq1=rs.getString("oreq");
        	 String ockey1=rs.getString("ockey"); String oskey1=rs.getString("oskey");
        	 String ourl1=rs.getString("ourl"); String omethod1=rs.getString("omethod");   
            // String omethod1="flickr.test.login";
            String RESOURCE_URL =ourl1; String apiKey= ockey1; String apiSecret = oskey1;
    	  // String RESOURCE_URL ="https://api.flickr.com/services/rest/"; String apiKey = "9f17ba0ed1e29e91e1e8829dd3e6f889";String apiSecret = "5e636fa8d8f0968b"; 
	      // String call="http://localhost:8071/mindapp/Oauth1Call";
	       String call="https://mindapp-pulpy.rhcloud.com/Oauth1Call";
	    OAuthService service = new ServiceBuilder().provider(FlickrApi.class).apiKey(apiKey).apiSecret(apiSecret).callback(call).build(); 
	    Verifier verifier = new Verifier(oauth_verifier);
	    Token accessToken = service.getAccessToken(requestToken, verifier);
	    OAuthRequest request1 = new OAuthRequest(Verb.GET,RESOURCE_URL);
	    request1.addQuerystringParameter("method", omethod1);
	    service.signRequest(accessToken, request1);
	    Response response1 = request1.send();
	    String res=response1.getBody();
	    session.setAttribute("xml1", res);
          out.println("<h2><center><font color='green'>Processing...</font></center></h3>");
		        response.setHeader("Refresh", "1; URL=auth1.jsp");
	         }    
 } catch (Exception e) {
	 out.println("ewwwwww"+e);
	}*/
	}

}
