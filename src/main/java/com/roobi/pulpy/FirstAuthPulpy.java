package com.roobi.pulpy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.Map;
import java.util.UUID;

import sun.misc.BASE64Encoder;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.FlickrApi;
import org.scribe.builder.api.FreelancerApi;
import org.scribe.builder.api.LinkedInApi;
import org.scribe.builder.api.TumblrApi;
import org.scribe.builder.api.TwitterApi;
import org.scribe.model.SignatureType;
import org.scribe.model.Token;
import org.scribe.oauth.OAuthService;

import com.mindots.util.Utils;

@MultipartConfig(maxFileSize = 16177215)
// upload file up to 16MB
public class FirstAuthPulpy extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FirstAuthPulpy() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Connection con = null;
		response.setHeader("Content-Type", "text/html;charset=UTF-8");
		InputStream inputStream = null;
		Map<String, String> config = Utils.getConfigFromFile(
				getServletContext(), "config.properties");
		PrintWriter out = response.getWriter();
		String appname = request.getParameter("app1");
		String descr = request.getParameter("descr");
		String authen = request.getParameter("authen");
		String select1 = request.getParameter("select1");
		String select2 = request.getParameter("select2");
		HttpSession session = request.getSession(true);
		String id = (String) session.getAttribute("id");
		Part filePart = request.getPart("logo");
		inputStream = filePart.getInputStream();
		String osmeth = request.getParameter("osmeth");
		String oreq = request.getParameter("oreq");
		String ockey = request.getParameter("ockey");
		String oskey = request.getParameter("oskey");
		String ourl1 = request.getParameter("ourl1");
		String ourl2 = request.getParameter("ourl2");
		String sig = request.getParameter("sig");
		String sigskey = request.getParameter("sigskey");
		String sigckey = request.getParameter("sigckey");
		String message = request.getParameter("sigtext");
		String sigmeth = request.getParameter("sigmeth");
		String ourl3 = request.getParameter("ourl3");
		String b1 = request.getParameter("b1");
		String b2 = request.getParameter("b2");
		String b3 = request.getParameter("b3");
		String b4 = request.getParameter("b4");
		String h1 = request.getParameter("h1");
		String hv1 = request.getParameter("hv1");
		String h2 = request.getParameter("h2");
		String hv2 = request.getParameter("hv2");
		String h3 = request.getParameter("h3");
		String hv3 = request.getParameter("hv3");
		String h4 = request.getParameter("h4");
		String hv4 = request.getParameter("hv4");
		String h5 = request.getParameter("h5");
		String hv5 = request.getParameter("hv5");
		String a1 = request.getParameter("a1");
		String a2 = request.getParameter("a2");
		String sformat = request.getParameter("sformat");
		String cname = request.getParameter("cname");
		String ckey = request.getParameter("ckey");
		String csecname = request.getParameter("csecname");
		String cseckey = request.getParameter("cseckey");
		String sname = request.getParameter("sname");
		String svalue = request.getParameter("svalue");
		String aurl = request.getParameter("aurl");
		String tokenurl = request.getParameter("tokenurl");
		String tlabel = request.getParameter("tlabel");
		String treplace = request.getParameter("treplace");
		String redir=request.getParameter("redir");
		String el = request.getParameter("el");
		String ev = request.getParameter("ev");
		HttpSession session2 = request.getSession(true);
		session2.setAttribute("appname", appname);
		session2.setAttribute("apikey", a2);
		session2.setAttribute("apiname", a1);
		session2.setAttribute("authtype", authen);
		String signature = "";
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = (Connection) DriverManager.getConnection(config.get("URL"),
					config.get("USER"), config.get("PASS"));
			PreparedStatement st = null;
			st = con.prepareStatement("insert into authen1(id,appname,descr,auth,rf,rmethod,a1,a2,b1,b2,b3,b4,h1,hv1,h2,hv2,h3,hv3,h4,hv4,h5,hv5,cname,ckey,csecname,cseckey,sname,svalue,aurl,tokenurl,tlabel,treplace,el,ev,osmeth,oreq,ockey,oskey,ourl1,ourl2,ourl3,sigckey,sigskey,sigmeth,logo,sig,message,sformat,redir) values ('"
					+ id
					+ "','"
					+ appname
					+ "','"
					+ descr
					+ "','"
					+ authen
					+ "','"
					+ select1
					+ "','"
					+ select2
					+ "','"
					+ a1
					+ "','"
					+ a2
					+ "','"
					+ b1
					+ "','"
					+ b2
					+ "','"
					+ b3
					+ "','"
					+ b4
					+ "','"
					+ h1
					+ "','"
					+ hv1
					+ "','"
					+ h2
					+ "','"
					+ hv2
					+ "','"
					+ h3
					+ "','"
					+ hv3
					+ "','"
					+ h4
					+ "','"
					+ hv4
					+ "','"
					+ h5
					+ "','"
					+ hv5
					+ "','"
					+ cname
					+ "','"
					+ ckey
					+ "','"
					+ csecname
					+ "','"
					+ cseckey
					+ "','"
					+ sname
					+ "','"
					+ svalue
					+ "','"
					+ aurl
					+ "','"
					+ tokenurl
					+ "','"
					+ tlabel
					+ "','"
					+ treplace
					+ "','"
					+ el
					+ "','"
					+ ev
					+ "','"
					+ osmeth
					+ "','"
					+ oreq
					+ "','"
					+ ockey
					+ "','"
					+ oskey
					+ "','"
					+ ourl1
					+ "','"
					+ ourl2
					+ "','"
					+ ourl3
					+ "','"
					+ sigckey
					+ "','"
					+ sigskey
					+ "','"
					+ sigmeth
					+ "',?,'" + sig + "','" + message + "','" + sformat + "','" + redir + "')");
			st.setBlob(1, inputStream);
			st.executeUpdate();
			st.close();

			st = con.prepareStatement("SELECT * From authen1 ORDER BY appid DESC LIMIT 1");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String appid1 = rs.getString("appid");
				String authen1 = rs.getString("auth");
				session.setAttribute("appid", appid1);
				if ("No Auth".equals(authen1) || "Basic Auth".equals(authen1)
						|| "API keys".equals(authen1)) {
					out.println("<html style='background-color:#ff9900;'><h2><center><font color='#000000;'>Processing...</font></center></h3><br><br><br><br>"
							+ "<br><br><br><br><center><img style='height:100px;width:100px;' src='images/load.gif'></center><html>");
					response.setHeader("Refresh", "1; URL=auth.jsp");
				} else if ("Signed Auth".equals(authen1)) {

					HttpSession session1 = request.getSession();
					String timestamp = (String) session1
							.getAttribute("timestamp");
					String nonce = (String) session1.getAttribute("nonce");
					session1.setAttribute("timestamp", timestamp);
					session1.setAttribute("nonce", nonce);
					String result = "";
					if ("HMAC-SHA1".equals(sig)) {
						SecretKeySpec signingKey = new SecretKeySpec(
								sigskey.getBytes(), "HMACSHA1");
						Mac mac = Mac.getInstance("HMACSHA1");
						mac.init(signingKey);
						byte[] rawHmac = mac.doFinal(message.getBytes());
						if (sformat.equals("URL-Encoded")) {
							result = new BASE64Encoder().encode(rawHmac);
							signature = URLEncoder.encode(result, "UTF-8");
						} else if (sformat.equals("HexaDecimal"))
							signature = new String(Hex.encodeHex(rawHmac));
						session.setAttribute("signature", signature);
					} else if ("HMAC-SHA256".equals(sig)) {
						Mac mac = Mac.getInstance("HmacSHA256");
						mac.init(new SecretKeySpec(sigskey.getBytes(),
								"HmacSHA256"));
						byte[] rawHmac = mac.doFinal(message.getBytes());
						if (sformat.equals("URL-Encoded")) {
							result = new BASE64Encoder().encode(rawHmac);
							signature = URLEncoder.encode(result, "UTF-8");
						} else if (sformat.equals("HexaDecimal"))
							signature = new String(Hex.encodeHex(mac
									.doFinal(message.getBytes())));
						session.setAttribute("signature", signature);
					} else if ("MD5".equals(sig)) {
						MessageDigest md = MessageDigest.getInstance("MD5");
						md.update(message.getBytes());
						signature = String.format("%032x",
								new BigInteger(1, md.digest()));
					}
					PreparedStatement st1 = null;
					st1 = con
							.prepareStatement("insert into signature(sig) values ('"
									+ signature + "')");
					st1.executeUpdate();
					st1.close();
					out.println("<html style='background-color:#ff9900;'><h2><center><font color='#000000;'>Processing...</font></center></h3><br><br><br><br>"
							+ "<br><br><br><br><center><img style='height:100px;width:100px;' src='images/load.gif'></center><html>");
					response.setHeader("Refresh", "1; URL=auth.jsp");

				} // signed authentication
				else if ("Oauth1".equals(authen1)) {
					String callback = "https://mindapp-pulpy.rhcloud.com/Oauth1Call";
					String oauth_signature_method = rs.getString("osmeth");
					String url1 = rs.getString("ourl1");
					String ourl21 = rs.getString("ourl2");
					String oauth_consumer_key = rs.getString("ockey");
					String secret = rs.getString("oskey");
					String oreq1 = rs.getString("oreq");
					if (oreq1.equals("GET")) {
						String uuid_string = UUID.randomUUID().toString();
						uuid_string = uuid_string.replaceAll("-", "");
						String oauth_nonce = uuid_string;
						String eurl1 = URLEncoder.encode(url1, "UTF-8");
						long oauth_timestamp = System.currentTimeMillis() / 1000;
						System.out.println(oauth_timestamp);
						String parameter_string = "oauth_callback="
								+ URLEncoder.encode(callback, "UTF-8")
								+ "&oauth_consumer_key=" + ockey
								+ "&oauth_nonce=" + oauth_nonce
								+ "&oauth_signature_method=" + osmeth
								+ "&oauth_timestamp=" + oauth_timestamp
								+ "&oauth_version=1.0";
						String signature_base_string = oreq + "&" + eurl1 + "&"
								+ URLEncoder.encode(parameter_string, "UTF-8");
						String oauth_signature = "";
						String oauth_signature1 = "";
						System.out.println(signature_base_string);
						try {
							oauth_signature = computeSignature(
									signature_base_string, oskey + "&");
							oauth_signature1 = URLEncoder.encode(
									oauth_signature, "UTF-8");
						} catch (GeneralSecurityException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						session.setAttribute("oauth_signature1",
								oauth_signature1);
						session.setAttribute("parameter_string",
								parameter_string);
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
								} else if (stest[0]
										.equals("oauth_token_secret")) {
									sec1 = chk1[i];
								}
							}
							session.setAttribute("samp", tok + "\n\n" + uurl
									+ "\n\n");
							session.setAttribute("secret1", sec1);
						} catch (ClientProtocolException cpe) {
							System.out.println(cpe.getMessage());
						} catch (IOException ioe) {
							System.out.println(ioe.getMessage());
						}
						String author = ourl21 + "?" + oauth_token
								+ "&perms=write";
						response.sendRedirect(author);
					} else {
						String uuid_string = UUID.randomUUID().toString();
						uuid_string = uuid_string.replaceAll("-", "");
						String oauth_nonce = uuid_string;
						String eurl = URLEncoder.encode(url1, "UTF-8");
						int millis = (int) System.currentTimeMillis() * -1;
						String oauth_timestamp = (new Long(
								System.currentTimeMillis() / 1000)).toString();
						String authorization_header_string = "";
						if (oauth_signature_method.equals("PLAINTEXT")) {
							authorization_header_string = "OAuth oauth_version=\"1.0\",oauth_consumer_key=\""
									+ ockey
									+ "\","
									+ "oauth_nonce=\""
									+ oauth_nonce
									+ "\",oauth_callback=\""
									+ URLEncoder.encode(callback, "UTF-8")
									+ "\",oauth_signature_method=\""
									+ oauth_signature_method
									+ "\",oauth_signature=\""
									+ secret
									+ "%2526\",oauth_timestamp=\""
									+ oauth_timestamp + "\"";
						} else {
							String parameter_string = "oauth_consumer_key="
									+ oauth_consumer_key + "&oauth_nonce="
									+ oauth_nonce + "&oauth_signature_method="
									+ oauth_signature_method
									+ "&oauth_timestamp=" + oauth_timestamp
									+ "&oauth_version=1.0";
							// System.out.println("parameter_string=" +
							// parameter_string);
							String signature_base_string = oreq1
									+ "&"
									+ eurl
									+ "&"
									+ URLEncoder.encode(parameter_string,
											"UTF-8");
							System.out.println("signature_base_string="
									+ signature_base_string);
							String oauth_signature = "";
							String oauth_signature1 = "";
							try {
								oauth_signature = computeSignature(
										signature_base_string, secret + "&");
								oauth_signature1 = URLEncoder.encode(
										oauth_signature, "UTF-8");
							} catch (GeneralSecurityException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							session.setAttribute("oauth_signature1",
									oauth_signature1);
							session.setAttribute("parameter_string",
									parameter_string);
							authorization_header_string = "OAuth oauth_callback="
									+ URLEncoder.encode(callback, "UTF-8")
									+ ",oauth_consumer_key=\""
									+ oauth_consumer_key
									+ "\","
									+ "oauth_nonce=\""
									+ oauth_nonce
									+ "\",oauth_signature_method=\"HMAC-SHA1\",oauth_signature=\""
									+ URLEncoder.encode(oauth_signature,
											"UTF-8")
									+ "\",oauth_timestamp=\""
									+ oauth_timestamp
									+ "\",oauth_version=\"1.0\"";
							String uurl = url1
									+ "?"
									+ parameter_string
									+ "&oauth_signature="
									+ URLEncoder.encode(oauth_signature,
											"UTF-8");
						}
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
								} else if (stest[0]
										.equals("oauth_token_secret")) {
									sec1 = chk1[i];
								}
							}
							session.setAttribute("secret1", sec1);

						} catch (ClientProtocolException cpe) {
							System.out.println(cpe.getMessage());
						} catch (IOException ioe) {
							System.out.println(ioe.getMessage());
						}
						String author = ourl21 + "?" + oauth_token
								+ "&perms=write";
						response.sendRedirect(author);
					}
				}

				else if ("Oauth2".equals(authen1)) {
					String cname1 = rs.getString("cname");
					String ckey1 = rs.getString("ckey");
					String csecname1 = rs.getString("csecname");
					String cseckey1 = rs.getString("cseckey");
					String sname1 = rs.getString("sname");
					String svalue1 = rs.getString("svalue");
					String aurl1 = rs.getString("aurl");
					String tokenurl1 = rs.getString("tokenurl");
					String tlabel1 = rs.getString("tlabel");
					String treplace1 = rs.getString("treplace");
					String el1 = rs.getString("el");
					String ev1 = rs.getString("ev");
					String rf1 = rs.getString("rf");
					String url = "name";
					String rmethod1 = rs.getString("rmethod");
					session.setAttribute("cname", cname1);
					session.setAttribute("ckey", ckey1);
					session.setAttribute("url", url);
					session.setAttribute("csecname", csecname1);
					session.setAttribute("cseckey", cseckey1);
					session.setAttribute("sname", sname1);
					session.setAttribute("svalue", svalue1);
					session.setAttribute("aurl", aurl1);
					session.setAttribute("tokenurl", tokenurl1);
					session.setAttribute("tlabel", tlabel1);
					session.setAttribute("treplace", treplace1);
					session.setAttribute("el", el1);
					session.setAttribute("ev", ev1);
					session.setAttribute("rf1", rf1);
					session.setAttribute("rm1", rmethod1);
					if (sname1.equals("") && el1.equals(""))
						response.sendRedirect(aurl
								+ "?redirect_uri=https://mindapp-pulpy.rhcloud.com/OauthCallBackServlet&response_type=code&client_id="
								+ ckey1);
					else if (!sname1.equals("") && el1.equals(""))
						response.sendRedirect(aurl
								+ "?redirect_uri=https://mindapp-pulpy.rhcloud.com/OauthCallBackServlet&response_type=code&client_id="
								+ ckey1 + "&" + sname1 + "=" + svalue1);
					else if (sname1.equals("") && !el1.equals(""))
						response.sendRedirect(aurl
								+ "?redirect_uri=https://mindapp-pulpy.rhcloud.com/OauthCallBackServlet&response_type=code&client_id="
								+ ckey1 + "&" + el1 + "=" + ev1);
					else if (!sname1.equals("") && !el1.equals(""))
						response.sendRedirect(aurl
								+ "?redirect_uri=https://mindapp-pulpy.rhcloud.com/OauthCallBackServlet&response_type=code&client_id="
								+ ckey1 + "&" + sname1 + "=" + svalue1 + "&"
								+ el1 + "=" + ev1);

				}
			}
		} catch (Exception e) {
			out.println(e);
			// out.println("<html><body bgcolor='#FF9900'><h2 style='color:#ffffff;'><center>You can configure only one time with the same id</h2><h3 style='color:#ffffff;'><a href='logout.jsp'>signout</a></h3></center></body></html>");
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
