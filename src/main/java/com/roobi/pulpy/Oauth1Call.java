package com.roobi.pulpy;

import java.awt.Desktop;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
		response.setHeader("Content-Type","text/html;charset=UTF-8");
		InputStream is=null;
		PrintWriter tt=response.getWriter();
		tt.println("<body style='background-color=#ff9900;'>");
		tt.println("<p>for test</p></body>");
		//String apiSecret=request.getParameter("a");
		//String apiKey =request.getParameter("b");
		Part filePart = request.getPart("t5"); 
		if (filePart != null) {  
        is = filePart.getInputStream();}
		String RESOURCE_URL = "https://api.flickr.com/services/rest/";
		 String RESOURCE_URL1 ="https://up.flickr.com/services/upload/";
		  
		    // Replace these with your own api key and secret
		    String apiKey = "8cd156666f78aa30085da4a604a370c9";
		    String apiSecret = "a8ad3f781a1c6c9c";
		   
		    OAuthService service = new ServiceBuilder().provider(FlickrApi.class).apiKey(apiKey).apiSecret(apiSecret).build();
		    Scanner in = new Scanner(System.in);

		    System.out.println("Flickr");
		    System.out.println();
		    
		    // Obtain the Request Token
		    System.out.println("Fetching the Request Token...");
		    Token requestToken = service.getRequestToken();
		    String authorizationUrl = service.getAuthorizationUrl(requestToken);
		    System.out.println(authorizationUrl + "&perms=write");
		    String ur=authorizationUrl + "&perms=write";
		    if (Desktop.isDesktopSupported()) {
		        Desktop desktop = Desktop.getDesktop();
		        if (desktop.isSupported(Desktop.Action.BROWSE)) {
		            try {
		                desktop.browse(new URI(ur));
		            }
		            catch(IOException ioe) {
		                ioe.printStackTrace();
		            }
		            catch(URISyntaxException use) {
		                use.printStackTrace();
		            }
		        }
		    }
		    System.out.println("And paste the verifier here");
		    System.out.print(">>");
		    Verifier verifier = new Verifier(in.nextLine());
		    System.out.println();

		    // Trade the Request Token and Verfier for the Access Token
		    System.out.println("Trading the Request Token for an Access Token...");
		    Token accessToken = service.getAccessToken(requestToken, verifier);
		    System.out.println("Got the Access Token!");
		    System.out.println("(if your curious it looks like this: " + accessToken + " )");
		    System.out.println("(you can get the username, full name, and nsid by parsing the rawResponse: " + accessToken.getRawResponse() + ")");
		    //OAuthRequest request1 = new OAuthRequest(Verb.GET,RESOURCE_URL);
		    OAuthRequest request1 = new OAuthRequest(Verb.POST,RESOURCE_URL1);
		    request1.addQuerystringParameter("method", "flickr.photos.getRecent");
		    //request1.addOAuthParameter("photo", is);
		    service.signRequest(accessToken, request1);
		    Response response1 = request1.send();
		    System.out.println("Got it! Lets see what we found...");
		    System.out.println();
		    System.out.println(response1.getBody());
		    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String key="9f17ba0ed1e29e91e1e8829dd3e6f889";
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
       
	}

}
