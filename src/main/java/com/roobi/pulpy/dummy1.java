package com.roobi.pulpy;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSON;
import net.sf.json.JSONSerializer;
import net.sf.json.xml.XMLSerializer;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

/**
 * Servlet implementation class dummy1
 */
@WebServlet("/dummy1")
public class dummy1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dummy1() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setHeader("Content-Type","text/html;charset=UTF-8");
		 String USER_AGENT = "Mozilla/5.0";
		//String url = "https://www.encodercloud.com/api/action";
		 String url=request.getParameter("t1");
		 String str="";
		 //String method=request.getParameter("t2");
		 String x1=request.getParameter("x1");
		 String xv1=request.getParameter("xv1");
		 String x2=request.getParameter("x2");
		 String xv2=request.getParameter("xv2");
		//	out.println("<br><br>"+x1+""+xv1+""+x2+""+xv2);
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);
		post.setHeader("User-Agent", USER_AGENT);
		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		urlParameters.add(new BasicNameValuePair(x1, xv1));
		urlParameters.add(new BasicNameValuePair(x2, xv2));
		urlParameters.add(new BasicNameValuePair("null","null"));
		post.setEntity(new UrlEncodedFormEntity(urlParameters));
		HttpResponse response1 = client.execute(post);
		//out.println("<br><br>POST URL : " + url);
		out.println("<br><br>Post parameters : " + post.getEntity());
	//	out.println("<br><br>Response Code : " +  response1.getStatusLine().getStatusCode());
		BufferedReader rd = new BufferedReader(
                        new InputStreamReader(response1.getEntity().getContent()));
 
		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
			JSON json = JSONSerializer.toJSON( line)  ;
  	          XMLSerializer xmlSerializer = new XMLSerializer();  
  	          xmlSerializer.setTypeHintsEnabled(false);
  	          xmlSerializer.setSkipWhitespace(true);
  	          xmlSerializer.setTrimSpaces(true);
  	          xmlSerializer.setRemoveNamespacePrefixFromElements(true);
  	          xmlSerializer.removeNamespace(line);
  	          xmlSerializer.setRootName("root");
  	          xmlSerializer.setForceTopLevelObject(false);
  		      str = xmlSerializer.write( json );
			
		}
 String xml1=result.toString();
 HttpSession session=request.getSession(true);
 session.setAttribute("user", "frds");
 session.setAttribute("xml1",str);
 

		out.println("<br><br>output: "+xml1);
	       // response.setHeader("Refresh", "1; URL=auth1.jsp");	

	}

}
