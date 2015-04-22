package com.roobi.pulpy;

import com.mindots.util.Utils;
import org.apache.commons.codec.binary.*;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;

/**
 * Created by susee on 22/4/15.
 */
@WebServlet(name = "OauthmashupPulpy")
public class OauthmashupPulpy extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String appid=request.getParameter("appid");
        ArrayList<String> para=new ArrayList<String>();
        for (int i=1;i<6;i++) {
            para.add(""+request.getParameter("p" + i));
        }
        response.addHeader("Access-Control-Allow-Origin", "*");
        PrintWriter out=response.getWriter();
        Map<String, String> config = Utils.getConfigFromFile(getServletContext(), "config.properties");
        try{

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = (Connection) DriverManager.getConnection(config.get("URL"), config.get("USER"), config.get("PASS"));
            PreparedStatement st1=con.prepareStatement("SELECT * FROM authen1 t1 JOIN omash t2 ON t1.appid = t2.appid WHERE t1.appid=?");
            st1.setString(1,appid);
            ResultSet rs=st1.executeQuery();
            while(rs.next()) {

                String id=rs.getString("id");
                String auth=rs.getString("auth");

                //For basic auth
                String b2=rs.getString("b2");
                String b4=rs.getString("b4");
                String h1=rs.getString("h1");String hv1=rs.getString("hv1");
                String h2=rs.getString("h2");String hv2=rs.getString("hv2");
                String h3=rs.getString("h3");String hv3=rs.getString("hv3");
                String h4=rs.getString("h4");String hv4=rs.getString("hv4");
                String h5=rs.getString("h5");String hv5=rs.getString("hv5");

                //For APikey
                String ak1=rs.getString("a1");
                String ak2=rs.getString("a2");

                //Oauth1
                String oauth_signature_method=rs.getString("osmeth");
                String ourl1=rs.getString("ourl1");
                String ourl2=rs.getString("ourl2");
                String ourl3=rs.getString("ourl3");
                String oauth1_key=rs.getString("ockey");
                String oauth1_secret=rs.getString("oskey");
                String oreq1=rs.getString("oreq");

                //mashup
                ArrayList<String> masmeth=new ArrayList<String>();
                ArrayList<String> masurl=new ArrayList<String>();
                ArrayList<String> mastext=new ArrayList<String>();

                for (int i=1;i<6;i++) {
                    String checkmeth=""+rs.getString("masmeth" + i);
                    if(!checkmeth.equals("null")) {
                        masmeth.add(checkmeth);
                        masurl.add("" + rs.getString("masurl" + i));
                        mastext.add("" + rs.getString("mastext" + i));
                    }
                }

                String totalres = "{\"Mpulpy_total_result\":{";
                String[] qbacc = {"result1","result2","result3","result4","result5"};


                String oauth_token = "";
                String access_secret1 = "";
                String companyid = "";
                PreparedStatement st4 = con.prepareStatement("SELECT * From oauth1 ORDER BY no DESC LIMIT 1");
                ResultSet rs4 = st4.executeQuery();
                while (rs4.next()) {
                    oauth_token = rs4.getString("token");
                    access_secret1 = rs4.getString("secret");
                    companyid = rs4.getString("resp");
                }
                rs4.close();
                //String[] qburl = {endurl1, endurl2, endurl3, endurl4, endurl5};

                String[] tok11 = oauth_token.split("=");
                String oauthtk = tok11[1];
                String[] tok1 = access_secret1.split("=");
                String sec1 = tok1[1];

                //inputs
                for (int k = 0; k < masmeth.size(); k++) {

                    String eurl=para.get(k);
                    String rmethod = masmeth.get(k);
                    String endul = masurl.get(k);
                    totalres += "\"" + qbacc[k] + "\":";

                    String uuid_string = UUID.randomUUID().toString();
                    uuid_string = uuid_string.replaceAll("-", "");
                    String oauth_nonce = uuid_string;
                    String enurl = URLEncoder.encode(endul, "UTF-8");
                    String oauth_timestamp = (new Long(System.currentTimeMillis() / 1000)).toString();

                    String parameter_string = "";
                    if (eurl.equals("null")) {
                        parameter_string = eurl+"&oauth_consumer_key=" + oauth1_key + "&oauth_nonce=" + oauth_nonce + "&oauth_signature_method=" + oauth_signature_method + "&oauth_timestamp=" + oauth_timestamp + "&" + oauth_token + "&oauth_version=1.0";
                    } else {
                        parameter_string = "oauth_consumer_key=" + oauth1_key + "&oauth_nonce=" + oauth_nonce + "&oauth_signature_method=" + oauth_signature_method + "&oauth_timestamp=" + oauth_timestamp + "&" + oauth_token + "&oauth_version=1.0";
                    }
                    String[] tst1 = parameter_string.split("&");
                    Arrays.sort(tst1);
                    int no = tst1.length;
                    String tst3 = "";
                    for (int i = 1; i < no; i++) {
                        tst3 = tst3 + "&" + tst1[i];
                    }
                    String tst4 = tst1[0] + tst3;
                    String signature_base_string = rmethod + "&" + enurl + "&" + URLEncoder.encode(tst4, "UTF-8");
                    String oauth_signature = "";
                    String oauth_signature1 = "";
                    try {
                        oauth_signature = computeSignature(signature_base_string, oauth1_secret + "&" + sec1);  // note the & at the end. Normally the user access_token would go here, but we don't know it yet for request_token
                        oauth_signature1 = URLEncoder.encode(oauth_signature, "UTF-8");
                    } catch (GeneralSecurityException e) {
                        // TODO Auto-generated catch block
                    }

                    String actok = endul + "?" + tst4 + "&oauth_signature=" + oauth_signature1;
                    HttpClient httpclient = new DefaultHttpClient();
                    HttpGet get1 = new HttpGet(actok);
                    get1.setHeader("Accept", "application/json");
                    HttpResponse response1 = httpclient.execute(get1);
                    BufferedReader rd = new BufferedReader(new InputStreamReader(response1.getEntity().getContent()));
                    StringBuffer result = new StringBuffer();
                    String line = "";
                    String str1 = "";
                    while ((line = rd.readLine()) != null) {
                        result.append(line);
                    }
                    str1 = result.toString();
                    totalres += str1 + ",";
                }

                totalres = removeLastChar(totalres);
                totalres += "}}";
                out.println(totalres);
                PreparedStatement st5 = con.prepareStatement("DELETE From oauth1 ORDER BY no DESC LIMIT 1");
                st5.executeUpdate();
                con.close();
            }
        }catch(Exception e){

        }
    }
    private static String removeLastChar(String str) {
        return str.substring(0,str.length()-1);
    }
    public String method(String str) {
        if (str.length() > 0 && str.charAt(str.length()-1)=='x') {
            str = str.substring(0, str.length()-1);
        }
        return str;
    }
    private static String computeSignature(String baseString, String keyString) throws GeneralSecurityException, UnsupportedEncodingException {
        SecretKey secretKey = null;
        byte[] keyBytes = keyString.getBytes();
        secretKey = new SecretKeySpec(keyBytes, "HmacSHA1");
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(secretKey);
        byte[] text = baseString.getBytes();
        return new String(org.apache.commons.codec.binary.Base64.encodeBase64(mac.doFinal(text))).trim();
    }
}
