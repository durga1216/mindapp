package com.roobi.pulpy;

import org.scribe.builder.*;
import org.scribe.builder.api.*;
import org.scribe.model.*;
import org.scribe.oauth.*;
import java.util.Scanner;

public class FlickrExample
{
	 private static final String PROTECTED_RESOURCE_URL = "https://api.flickr.com/services/rest/";
	 private static final String PROTECTED_RESOURCE_URL1 ="https://up.flickr.com/services/upload/";
	  public static void main(String[] args)
	  {
	    // Replace these with your own api key and secret
	    String apiKey = "8cd156666f78aa30085da4a604a370c9";
	    String apiSecret = "a8ad3f781a1c6c9c";
	    OAuthService service = new ServiceBuilder().provider(FlickrApi.class).apiKey(apiKey).apiSecret(apiSecret).build();
	    Scanner in = new Scanner(System.in);

	    System.out.println("=== Flickr's OAuth Workflow ===");
	    System.out.println();

	    // Obtain the Request Token
	    System.out.println("Fetching the Request Token...");
	    Token requestToken = service.getRequestToken();
	    System.out.println("Got the Request Token!");
	    System.out.println();

	    System.out.println("Now go and authorize Scribe here:");
	    String authorizationUrl = service.getAuthorizationUrl(requestToken);
	    System.out.println(authorizationUrl + "&perms=write");
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
	    //OAuthRequest request = new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL);
	    OAuthRequest request = new OAuthRequest(Verb.POST, PROTECTED_RESOURCE_URL1);
	    request.addQuerystringParameter("method", "flickr.photos.getRecent");
	    //request.addHeader("photo", value);
	    service.signRequest(accessToken, request);
	    Response response = request.send();
	    System.out.println("Got it! Lets see what we found...");
	    System.out.println();
	    System.out.println(response.getBody());

	    System.out.println();
	    System.out.println("Thats it man! Go and build something awesome with Scribe! :)");
	  }
	}