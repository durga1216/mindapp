package com.roobi.pulpy;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.UUID;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.codec.binary.Base64;
import org.apache.geronimo.mail.util.Base64Encoder;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Connection con = null;
		response.setHeader("Content-Type", "text/html;charset=UTF-8");
		InputStream inputStream = null;
		Map<String, String> config = Utils.getConfigFromFile(
				getServletContext(), "config.properties");
		PrintWriter out = response.getWriter();
		String oauth_verifier = request.getParameter("oauth_verifier");
		String oauth_token = request.getParameter("oauth_token");
		HttpSession session = request.getSession(true);
		String appid = (String) session.getAttribute("appid");
		String secret11 = (String) session.getAttribute("secret1");
		String isapp = "ss" + (String) session.getAttribute("secret1");
		String url = "null";
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = (Connection) DriverManager.getConnection(config.get("URL"),
					config.get("USER"), config.get("PASS"));
			if (isapp.equals("ssnull")) {
				PreparedStatement st2 = con
						.prepareStatement("SELECT * From oauth1app ORDER BY num DESC LIMIT 1");
				ResultSet rs2 = st2.executeQuery();
				while (rs2.next()) {
					url = rs2.getString("url");
					appid = rs2.getString("appid");
					secret11 = rs2.getString("secret");
				}
			}
			String[] tok1 = secret11.split("=");
			String sec1 = tok1[1];
			PreparedStatement st = null;
			st = con.prepareStatement("SELECT * From authen1 where appid=?");
			st.setString(1, appid);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String oauth_signature_method = rs.getString("osmeth");
				String url1 = rs.getString("ourl1");
				String ourl21 = rs.getString("ourl2");
				String ourl31 = rs.getString("ourl3");
				String oauth_consumer_key = rs.getString("ockey");
				String secret = rs.getString("oskey");
				String oreq1 = rs.getString("oreq");
				// ========initial=========
				if (oreq1.equals("GET")) {
					String uuid_string = UUID.randomUUID().toString();
					uuid_string = uuid_string.replaceAll("-", "");
					String oauth_nonce = uuid_string;
					String eurl = URLEncoder.encode(ourl31, "UTF-8");
					int millis = (int) System.currentTimeMillis() * -1;
					String oauth_timestamp = (new Long(
							System.currentTimeMillis() / 1000)).toString();
					String parameter_string = "oauth_consumer_key="
							+ oauth_consumer_key + "&oauth_nonce="
							+ oauth_nonce + "&oauth_signature_method="
							+ oauth_signature_method + "&oauth_timestamp="
							+ oauth_timestamp + "&oauth_token=" + oauth_token
							+ "&oauth_verifier=" + oauth_verifier
							+ "&oauth_version=1.0";
					String signature_base_string = oreq1 + "&" + eurl + "&"
							+ URLEncoder.encode(parameter_string, "UTF-8");
					String oauth_signature = "";
					String oauth_signature1 = "";
					// =========signature===========
					try {
						oauth_signature = computeSignature(
								signature_base_string, secret + "&" + sec1);
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
					String actok = ourl31 + "?" + parameter_string
							+ "&oauth_signature=" + oauth_signature1;
					// out.println(actok);
					HttpClient httpclient = new DefaultHttpClient();
					HttpResponse response1 = null;
					HttpGet get1 = new HttpGet(ourl31);
					response1 = httpclient.execute(get1);
					HttpPost post = new HttpPost(url1);
					post.setHeader("Authorization", authorization_header_string);
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
					String secrt = "";
					String tokn = "";
					String[] chk1 = tok.split("&");
					for (int i = 0; i < chk1.length; i++) {
						String[] stest = chk1[i].split("=");
						if (stest[0].equals("oauth_token")) {
							tokn = chk1[i];
						} else if (stest[0].equals("oauth_token_secret")) {
							secrt = chk1[i];
						}
					}
					session.setAttribute("access_token1", tokn);
					session.setAttribute("access_secret1", secrt);
					PreparedStatement st1 = con
							.prepareStatement("insert into oauth1(token,secret) values ('"
									+ tokn + "','" + secrt + "')");
					st1.executeUpdate();
					st1.close();
					out.println("<h2><center><font color='green'>Processing...</font></center></h3>");
					if (url.equals(null))
						response.setHeader("Refresh", "1; URL=auth.jsp");
					else
						response.setHeader("Refresh", "1; URL=" + url);
				} else {
					String uuid_string = UUID.randomUUID().toString();
					uuid_string = uuid_string.replaceAll("-", "");
					String oauth_nonce = uuid_string;
					String eurl = URLEncoder.encode(ourl31, "UTF-8");
					int millis = (int) System.currentTimeMillis() * -1;
					String oauth_timestamp = (new Long(
							System.currentTimeMillis() / 1000)).toString();
					String parameter_string = "oauth_consumer_key="
							+ oauth_consumer_key + "&oauth_nonce="
							+ oauth_nonce + "&oauth_signature_method="
							+ oauth_signature_method + "&oauth_timestamp="
							+ oauth_timestamp + "&oauth_token=" + oauth_token
							+ "&oauth_verifier=" + oauth_verifier
							+ "&oauth_version=1.0";
					String signature_base_string = oreq1 + "&" + eurl + "&"
							+ URLEncoder.encode(parameter_string, "UTF-8");
					String oauth_signature = "";
					String oauth_signature1 = "";
					// =========signature===========
					try {
						oauth_signature = computeSignature(
								signature_base_string, secret + "&" + sec1);
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
							+ "\",oauth_signature_method=\"HMAC-SHA1\",oauth_token=\""
							+ oauth_token
							+ "\",oauth_verifier=\""
							+ oauth_verifier
							+ "\",oauth_signature=\""
							+ URLEncoder.encode(oauth_signature, "UTF-8")
							+ "\",oauth_timestamp=\""
							+ oauth_timestamp
							+ "\",oauth_version=\"1.0\"";
					String actok = ourl31 + "?" + parameter_string
							+ "&oauth_signature=" + oauth_signature1;
					// out.println(actok);
					HttpClient httpclient = new DefaultHttpClient();
					HttpResponse response1 = null;
					HttpPost post = new HttpPost(ourl31);
					post.setHeader("Authorization", authorization_header_string);
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
					String secrt = "";
					String tokn = "";
					String[] chk1 = tok.split("&");
					for (int i = 0; i < chk1.length; i++) {
						String[] stest = chk1[i].split("=");
						if (stest[0].equals("oauth_token")) {
							tokn = chk1[i];
						} else if (stest[0].equals("oauth_token_secret")) {
							secrt = chk1[i];
						}
					}
					session.setAttribute("access_token1", tokn);
					session.setAttribute("access_secret1", secrt);
					PreparedStatement st1 = con
							.prepareStatement("insert into oauth1(token,secret) values ('"
									+ tokn + "','" + secrt + "')");
					st1.executeUpdate();
					st1.close();
					out.println("<h2><center><font color='green'>Processing...</font></center></h3>");
					if (url.equals(null))
						response.setHeader("Refresh", "1; URL=auth.jsp");
					else
						response.setHeader("Refresh", "1; URL=" + url);
				}
			}
		} catch (Exception e) {
			out.println(e);
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}
}
