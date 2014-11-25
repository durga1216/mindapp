package com.roobi.pulpy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import com.mindots.util.Utils;

/**
 * Servlet implementation class MailChimp
 */
@WebServlet("/MailChimp")
public class MailChimp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MailChimp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map<String, String> config = Utils.getConfigFromFile(getServletContext(), "config.properties");
		PrintWriter out=response.getWriter();
		String access_token="";String xxml="<?xml version=\"1.0\" ?><result>";
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
	        Connection con = (Connection) DriverManager.getConnection(config.get("URL"),config.get("USER"),config.get("PASS"));
			PreparedStatement st3=con.prepareStatement("SELECT * From oauthtoken ORDER BY count DESC LIMIT 1");
	        ResultSet rs3 = st3.executeQuery();
	        while(rs3.next()){
	        	access_token=rs3.getString("token");
	        }
	        HttpClient client=new DefaultHttpClient();
			String str="";String line="";
			HttpGet get=new HttpGet("https://login.mailchimp.com/oauth2/metadata");
			get.addHeader("Authorization","OAuth "+access_token+"");
			HttpResponse response1 = client.execute(get);
			BufferedReader rd = new BufferedReader(
					new InputStreamReader(response1.getEntity().getContent()));
			while ((line = rd.readLine()) != null) {
				str+=line;		     			
			}
			//out.println(str);
			JSONObject obj=new JSONObject(str);
			String domain=obj.getString("dc");
			//get the id for the list
			String str1="";String line1="";
			HttpPost post=new HttpPost("https://"+domain+".api.mailchimp.com/2.0/lists/list.json");
			StringEntity se1=new StringEntity("{\"apikey\": \""+access_token+"-"+domain+"\"}");
			post.setEntity(se1);
			HttpResponse response2 = client.execute(post);
			BufferedReader rd1 = new BufferedReader(
					new InputStreamReader(response2.getEntity().getContent()));
			while ((line1 = rd1.readLine()) != null) {
				str1+=line1;		     			
			}
			//out.println(str1);
			JSONObject obj1=new JSONObject(str1);
			JSONArray arr=(JSONArray)obj1.getJSONArray("data");
			JSONObject obj2=new JSONObject(arr.get(0).toString());
			String id1=obj2.getString("id");
			//get the list of emails 
			String str2="";String line2="";
			HttpPost post1=new HttpPost("https://"+domain+".api.mailchimp.com/2.0/lists/members.json");
			StringEntity se2=new StringEntity("{\"apikey\": \""+access_token+"-"+domain+"\",\"id\":\""+id1+"\"}");
			post1.setEntity(se2);
			HttpResponse response3 = client.execute(post1);
			BufferedReader rd2 = new BufferedReader(
					new InputStreamReader(response3.getEntity().getContent()));
			while ((line2 = rd2.readLine()) != null) {
				str2+=line2;		     			
			}
			//out.println(str2);
			JSONObject obj3=new JSONObject(str);
			JSONArray arr1=(JSONArray)obj3.getJSONArray("data");
			for(int i=0;i<arr1.length();i++){
				JSONObject obj4=new JSONObject(arr1.get(i).toString());
				String email=obj4.getString("email");
				xxml+="<root><email>"+email+"</email></root>";
				//out.println(email);
			}
			xxml+="</result>";
			out.println(xxml);
		}
		catch(Exception e){
			out.println(e);
		}
	}

}
