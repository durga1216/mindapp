package com.roobi.pulpy;

import org.scribe.builder.*;
import org.scribe.builder.api.*;
import org.scribe.model.*;
import org.scribe.oauth.*;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

import javax.servlet.http.HttpSession;

public class FlickrExample
{
	private static final String PROTECTED_RESOURCE_URL = "https://api.flickr.com/services/rest/";

	  public static void main(String[] args)
	  {
	    // Replace these with your own api key and secret
	    String apiKey = "9f17ba0ed1e29e91e1e8829dd3e6f889";
	    String apiSecret = "5e636fa8d8f0968b";
	    String call="http://localhost:8071/mindapp/Oauth1Call";
	    //String call="https://mindapp-pulpy.rhcloud.com/Oauth1Call";
	    OAuthService service = new ServiceBuilder().provider(FlickrApi.class).apiKey(apiKey).apiSecret(apiSecret).callback(call).build();
	    Scanner in = new Scanner(System.in);

	    System.out.println("=== Flickr's OAuth Workflow ===");
	    System.out.println();

	    // Obtain the Request Token
	    System.out.println("Fetching the Request Token...");
	    Token requestToken = service.getRequestToken();
	    System.out.println("Got the Request Token!");
	    System.out.println(requestToken);
	    System.out.println("Now go and authorize Scribe here:");
	    String authorizationUrl = service.getAuthorizationUrl(requestToken);
	    System.out.println(authorizationUrl + "&perms=read");
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
	    System.out.println(verifier);

	    // Trade the Request Token and Verfier for the Access Token
	    System.out.println("Trading the Request Token for an Access Token...");
	    Token accessToken = service.getAccessToken(requestToken, verifier);
	    System.out.println("Got the Access Token!");
	    System.out.println("(if your curious it looks like this: " + accessToken + " )");
	    System.out.println("(you can get the username, full name, and nsid by parsing the rawResponse: " + accessToken.getRawResponse() + ")");
	    System.out.println();

	    // Now let's go and ask for a protected resource!
	    System.out.println("Now we're going to access a protected resource...");
	    OAuthRequest request = new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL);
	    request.addQuerystringParameter("method", "flickr.test.login");
	    service.signRequest(accessToken, request);
	    Response response = request.send();
	    System.out.println("Got it! Lets see what we found...");
	    System.out.println();
	    System.out.println(response.getBody());

	    System.out.println();
	    System.out.println("Thats it man! Go and build something awesome with Scribe! :)");
	  }
	}