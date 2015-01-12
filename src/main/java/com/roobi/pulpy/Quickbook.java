package com.roobi.pulpy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import com.mindots.util.Utils;

/**
 * Servlet implementation class Quickbook
 */
@WebServlet("/Quickbook")
public class Quickbook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Quickbook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		Map<String, String> config = Utils.getConfigFromFile(getServletContext(), "config.properties");
		try{
			String oauth_verifier=request.getParameter("oauth_verifier");
			String oauth_token=request.getParameter("oauth_token");
			String companyid=request.getParameter("realmId");
			String oauth_consumer_key="qyprdWyrr9gTlXvXn4r9NntGHANcKb";
			String secret="Ei7sHIP05haZfWNLJQFxyL7PvVX5pjT0eyNx8HxH";
			String oauth_signature_method="HMAC-SHA1";
			String ourl31="https://oauth.intuit.com/oauth/v1/get_access_token";
			String oreq1="GET";
			String sec1="";
			String url="";
			Class.forName("com.mysql.jdbc.Driver").newInstance();
	    	Connection con = (Connection) DriverManager.getConnection(config.get("URL"),config.get("USER"),config.get("PASS"));
	    	PreparedStatement st=con.prepareStatement("SELECT * From oauth1sec ORDER BY no DESC LIMIT 1");
	    	ResultSet rs = st.executeQuery();
	    	while(rs.next()){
	    		String secret11=rs.getString("secret");
	    		url=rs.getString("url");
	    		String[] tok1=secret11.split("=");
	    		sec1=tok1[1];
	    	}
			//input
	    	String uuid_string = UUID.randomUUID().toString();
            uuid_string = uuid_string.replaceAll("-", "");
            String oauth_nonce = uuid_string; 
            String eurl = URLEncoder.encode(ourl31, "UTF-8");
            long oauth_timestamp = System.currentTimeMillis()/1000;
            String parameter_string="";
            String call="https://mindapp-pulpy.rhcloud.com/Quickbook";
           	parameter_string = "oauth_callback="+URLEncoder.encode(call, "UTF-8")+"&oauth_consumer_key=" + oauth_consumer_key + "&oauth_nonce=" + oauth_nonce + "&oauth_signature_method=" + oauth_signature_method + "&oauth_timestamp=" + oauth_timestamp + "&oauth_token="+oauth_token+"&oauth_verifier="+oauth_verifier+"&oauth_version=1.0";        
            String signature_base_string = oreq1+"&"+eurl+"&" + URLEncoder.encode(parameter_string, "UTF-8");
            System.out.println("signature_base_string=" + signature_base_string);
            String oauth_signature = "";String oauth_signature1 = "";
               //=========signature===========
            try {
                    oauth_signature = computeSignature(signature_base_string, secret+"&"+sec1);  // note the & at the end. Normally the user access_token would go here, but we don't know it yet for request_token
                    oauth_signature1 = URLEncoder.encode(oauth_signature, "UTF-8");
            } catch (GeneralSecurityException e) {
                // TODO Auto-generated catch block
                	 e.printStackTrace();
            }
            String authorization_header_string = "OAuth oauth_consumer_key=\"" + oauth_consumer_key + "\","
                		+ "oauth_nonce=\"" + oauth_nonce + "\",oauth_signature_method=\"HMAC-SHA1\",oauth_signature=\"" + URLEncoder.encode(oauth_signature, "UTF-8") + "\",oauth_timestamp=\"" + 
                       oauth_timestamp + "\",oauth_version=\"1.0\"";
            String actok=ourl31+"?"+parameter_string+"&oauth_signature="+oauth_signature1;
            HttpClient httpclient1 = new DefaultHttpClient();
            HttpResponse response1=null;
            HttpGet get1=new HttpGet(actok);
            response1=httpclient1.execute(get1);
            BufferedReader rd = new BufferedReader(new InputStreamReader(response1.getEntity().getContent())); 
            StringBuffer result = new StringBuffer();
            String line = "";
            while ((line = rd.readLine()) != null) {
            	result.append(line);
		 	}
            String tok=result.toString();
            String secrt="";String tokn="";
            String[] chk1=tok.split("&");
            for(int i=0;i<chk1.length;i++){
            	String[] stest=chk1[i].split("=");
            	if(stest[0].equals("oauth_token")){
            		tokn=chk1[i];
    			 }else if(stest[0].equals("oauth_token_secret")){
    				 secrt=chk1[i];
    			 }
    		 }
	  		 PreparedStatement st2=con.prepareStatement("insert into oauth1 (token,secret,resp) values ('"+tokn+"','"+secrt+"','"+companyid+"')");
		   	 st2.executeUpdate();
		   	 st2.close();
		   	 out.println("<body style='background-color:#ff9900;'>");
		   	 out.println("<br><br><center><b><h2><font color='#ffffff;'>Sucessfully Authenticated with Mind Pulpy</font></center></h2></b>");
		   	 out.println("<br><br><h3><center><a style='color:#ffffff;' href='"+url+"'>Continue with Connectors</a></center></h3></body>");

		}
		catch(Exception e){
			
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    response.addHeader("Access-Control-Allow-Origin", "*");  
	    PrintWriter out=response.getWriter();
		Map<String, String> config = Utils.getConfigFromFile(getServletContext(), "config.properties");
		try{
			String oauth_consumer_key="qyprdWyrr9gTlXvXn4r9NntGHANcKb";
			String secret="Ei7sHIP05haZfWNLJQFxyL7PvVX5pjT0eyNx8HxH";
			String oauth_signature_method="HMAC-SHA1";
			String rmethod="GET";
			String oauth_token="";
			String access_secret1="";
			String eurl="null";
			String companyid="";
			Class.forName("com.mysql.jdbc.Driver").newInstance();
	    	Connection con = (Connection) DriverManager.getConnection(config.get("URL"),config.get("USER"),config.get("PASS"));
	    	PreparedStatement st4=con.prepareStatement("SELECT * From oauth1 ORDER BY no DESC LIMIT 1");
			ResultSet rs4=st4.executeQuery();
   			while(rs4.next()){
   				oauth_token=rs4.getString("token");
   				access_secret1=rs4.getString("secret");
   				companyid=rs4.getString("resp");
   			}
   			rs4.close();
			String endurl1="https://quickbooks.api.intuit.com/v3/company/"+companyid+"/invoice/1";
   			String[] tok11=oauth_token.split("=");
   			String oauthtk=tok11[1];
   			String[] tok1=access_secret1.split("=");
   			String sec1=tok1[1];
			//inputs
   			String uuid_string = UUID.randomUUID().toString();
			uuid_string = uuid_string.replaceAll("-", "");
			String oauth_nonce = uuid_string; 
			String enurl = URLEncoder.encode(endurl1, "UTF-8");
			String oauth_timestamp = (new Long(System.currentTimeMillis()/1000)).toString();
			String parameter_string ="";
			if(eurl.equals("null")){
				parameter_string ="oauth_consumer_key=" + oauth_consumer_key + "&oauth_nonce=" + oauth_nonce + "&oauth_signature_method=" + oauth_signature_method + "&oauth_timestamp=" + oauth_timestamp +"&"+oauth_token+"&oauth_version=1.0";        
			}
			else{
				parameter_string = eurl+"&oauth_consumer_key=" + oauth_consumer_key + "&oauth_nonce=" + oauth_nonce + "&oauth_signature_method=" + oauth_signature_method + "&oauth_timestamp=" + oauth_timestamp +"&"+oauth_token+"&oauth_version=1.0";        
			}
			String[] tst1=parameter_string.split("&");Arrays.sort(tst1);
			int no=tst1.length;String tst3="";
			for(int i=1;i<no;i++){
				tst3=tst3+"&"+tst1[i];
			}
			String tst4=tst1[0]+tst3;
			String signature_base_string = rmethod+"&"+enurl+"&" + URLEncoder.encode(tst4, "UTF-8");
			String oauth_signature = "";String oauth_signature1 = "";
			try {
				oauth_signature = computeSignature(signature_base_string, secret+"&"+sec1);  // note the & at the end. Normally the user access_token would go here, but we don't know it yet for request_token
				oauth_signature1 = URLEncoder.encode(oauth_signature, "UTF-8");
			} catch (GeneralSecurityException e) {
				// TODO Auto-generated catch block
			}
			String actok=endurl1+"?"+tst4+"&oauth_signature="+oauth_signature1;
			HttpClient httpclient = new DefaultHttpClient();
			HttpGet get1=new HttpGet(actok);
			HttpResponse response1=httpclient.execute(get1);
			BufferedReader rd = new BufferedReader(new InputStreamReader(response1.getEntity().getContent()));
			StringBuffer result = new StringBuffer();
			String line = "";String str1="";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			str1=result.toString();
			out.println(str1);
		}catch(Exception e){
			
		}
	}
	private static String computeSignature(String baseString, String keyString) throws GeneralSecurityException, UnsupportedEncodingException {	 
	    SecretKey secretKey = null;
	    byte[] keyBytes = keyString.getBytes();
	    secretKey = new SecretKeySpec(keyBytes, "HmacSHA1");
	    Mac mac = Mac.getInstance("HmacSHA1");
	    mac.init(secretKey);
	    byte[] text = baseString.getBytes();
	    return new String(Base64.encodeBase64(mac.doFinal(text))).trim();
	}	 
}
