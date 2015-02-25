package com.roobi.pulpy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import com.mindots.util.Utils;

/**
 * Servlet implementation class ClientOauth1
 */
@WebServlet("/ClientOauth1")
public class ClientOauth1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClientOauth1() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map<String, String> config = Utils.getConfigFromFile(
				getServletContext(), "config.properties");
		String url = request.getParameter("url");
		String appid = request.getParameter("appid");
		response.addHeader("Access-Control-Allow-Origin", "*");
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection con = (Connection) DriverManager.getConnection(
					config.get("URL"), config.get("USER"), config.get("PASS"));
			PreparedStatement st = con
					.prepareStatement("SELECT * From authen1 where appid='"
							+ appid + "'");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String callback = "https://mindapp-pulpy.rhcloud.com/Oauth1Call";
				String osmeth = rs.getString("osmeth");
				String url1 = rs.getString("ourl1");
				String ourl21 = rs.getString("ourl2");
				String oauth_consumer_key = rs.getString("ockey");
				String secret = rs.getString("oskey");
				String oreq1 = rs.getString("oreq");
				if (oreq1.equals("GET")) {
					String uuid_string = UUID.randomUUID().toString();
					uuid_string = uuid_string.replaceAll("-", "");
					String oauth_nonce = uuid_string;
					String eurl = URLEncoder.encode(url1, "UTF-8");
					long oauth_timestamp = System.currentTimeMillis() / 1000;
					String parameter_string = "oauth_callback="
							+ URLEncoder.encode(callback, "UTF-8")
							+ "&oauth_consumer_key=" + oauth_consumer_key
							+ "&oauth_nonce=" + oauth_nonce
							+ "&oauth_signature_method=" + osmeth
							+ "&oauth_timestamp=" + oauth_timestamp
							+ "&oauth_version=1.0";
					String signature_base_string = oreq1 + "&" + eurl + "&"
							+ URLEncoder.encode(parameter_string, "UTF-8");
					String oauth_signature = "";
					try {
						oauth_signature = computeSignature(
								signature_base_string, secret + "&");
					} catch (GeneralSecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					String uurl = url1 + "?" + parameter_string
							+ "&oauth_signature="
							+ URLEncoder.encode(oauth_signature, "UTF-8");
					String oauth_token = "";
					HttpClient httpclient = new DefaultHttpClient();
					HttpResponse response1 = null;
					try {

						HttpGet get1 = new HttpGet(uurl);
						response1 = httpclient.execute(get1);

						BufferedReader rd = new BufferedReader(
								new InputStreamReader(response1.getEntity()
										.getContent()));

						StringBuffer result = new StringBuffer();
						String line = "";
						while ((line = rd.readLine()) != null) {
							result.append(line);
						}
						String tok = result.toString();
						String sec1 = "";
						String[] chk1 = tok.split("&");
						for (int i = 0; i < chk1.length; i++) {
							String[] stest = chk1[i].split("=");
							if (stest[0].equals("oauth_token")) {
								oauth_token = chk1[i];
							} else if (stest[0].equals("oauth_token_secret")) {
								sec1 = chk1[i];
							}
						}
						HttpSession session = request.getSession(true);
						session.setAttribute("samp", tok + "\n\n" + uurl
								+ "\n\n");
						PreparedStatement st2 = null;
						st2 = con
								.prepareStatement("insert into oauth1app(appid,url,secret) values ('"
										+ appid
										+ "','"
										+ url
										+ "','"
										+ sec1
										+ "')");
						st2.executeUpdate();
						st2.close();

					} catch (ClientProtocolException cpe) {
						System.out.println(cpe.getMessage());
					} catch (IOException ioe) {
						System.out.println(ioe.getMessage());
					} finally {
						httpclient.getConnectionManager().shutdown();
					}

					String author = ourl21 + "?" + oauth_token + "&perms=write";
					response.setContentType("text/plain");
					response.setCharacterEncoding("UTF-8");
					response.getWriter().print(author);
				} else {
					String uuid_string = UUID.randomUUID().toString();
					uuid_string = uuid_string.replaceAll("-", "");
					String oauth_nonce = uuid_string;
					String eurl = URLEncoder.encode(url1, "UTF-8");
					int millis = (int) System.currentTimeMillis() * -1;
					String oauth_timestamp = (new Long(
							System.currentTimeMillis() / 1000)).toString();
					String parameter_string = "oauth_consumer_key="
							+ oauth_consumer_key + "&oauth_nonce="
							+ oauth_nonce + "&oauth_signature_method=" + osmeth
							+ "&oauth_timestamp=" + oauth_timestamp
							+ "&oauth_version=1.0";
					String signature_base_string = oreq1 + "&" + eurl + "&"
							+ URLEncoder.encode(parameter_string, "UTF-8");
					String oauth_signature = "";
					String oauth_signature1 = "";
					try {
						oauth_signature = computeSignature(
								signature_base_string, secret + "&");
						oauth_signature1 = URLEncoder.encode(oauth_signature,
								"UTF-8");
					} catch (GeneralSecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					String authorization_header_string = "OAuth oauth_consumer_key=\""
							+ oauth_consumer_key
							+ "\","
							+ "oauth_nonce=\""
							+ oauth_nonce
							+ "\",oauth_signature_method=\"HMAC-SHA1\",oauth_signature=\""
							+ URLEncoder.encode(oauth_signature, "UTF-8")
							+ "\",oauth_timestamp=\""
							+ oauth_timestamp
							+ "\",oauth_version=\"1.0\"";
					String uurl = url1 + "?" + parameter_string
							+ "&oauth_signature="
							+ URLEncoder.encode(oauth_signature, "UTF-8");
					System.out.println(uurl);
					String oauth_token = "";
					HttpClient httpclient = new DefaultHttpClient();
					HttpResponse response1 = null;
					try {
						HttpPost post = new HttpPost(url1);
						post.setHeader("Authorization",
								authorization_header_string);
						response1 = httpclient.execute(post);

						BufferedReader rd = new BufferedReader(
								new InputStreamReader(response1.getEntity()
										.getContent()));

						StringBuffer result = new StringBuffer();
						String line = "";
						while ((line = rd.readLine()) != null) {
							result.append(line);
						}
						String tok = result.toString();
						String sec1 = "";
						String[] chk1 = tok.split("&");
						for (int i = 0; i < chk1.length; i++) {
							String[] stest = chk1[i].split("=");
							if (stest[0].equals("oauth_token")) {
								oauth_token = chk1[i];
							} else if (stest[0].equals("oauth_token_secret")) {
								sec1 = chk1[i];
							}
						}
						PreparedStatement st2 = null;
						st2 = con
								.prepareStatement("insert into oauth1app(appid,url,secret) values ('"
										+ appid
										+ "','"
										+ url
										+ "','"
										+ sec1
										+ "')");
						st2.executeUpdate();
						st2.close();

					} catch (ClientProtocolException cpe) {
						System.out.println(cpe.getMessage());
					} catch (IOException ioe) {
						System.out.println(ioe.getMessage());
					} finally {
						httpclient.getConnectionManager().shutdown();
					}
					// =======Authorization=======

					String author = ourl21 + "?" + oauth_token + "&perms=write";
					response.setContentType("text/plain");
					response.setCharacterEncoding("UTF-8");
					response.getWriter().print(author);
				}
			}
			con.close();
		} catch (Exception e) {
		}
	}

	private static String computeSignature(String baseString, String keyString)
			throws GeneralSecurityException, UnsupportedEncodingException {
		SecretKey secretKey = null;
		byte[] keyBytes = keyString.getBytes();
		secretKey = new SecretKeySpec(keyBytes, "HmacSHA1");
		Mac mac = Mac.getInstance("HmacSHA1");
		mac.init(secretKey);
		byte[] text = baseString.getBytes();
		return new String(Base64.encodeBase64(mac.doFinal(text))).trim();
	}
}
