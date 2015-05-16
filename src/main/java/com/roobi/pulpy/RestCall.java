package com.roobi.pulpy;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by susee on 16/5/15.
 */
@Path("/response")
public class RestCall {
    @Produces(MediaType.TEXT_PLAIN)
    public Response getres(String body) {
        String result = "";
        try {
            JSONObject object = new JSONObject();
            String url = object.getString("method_url");
            String method = object.getString("method_type");
            String authen = object.getString("authen");
            //Adding the parameter to Array list
            ArrayList<String> param_label = new ArrayList<String>();
            ArrayList<String> param_value = new ArrayList<String>();
            JSONArray array1 = new JSONArray("" + object.getString("method_param"));
            for (int i = 0; i < array1.length(); i++) {
                JSONObject object1 = array1.getJSONObject(i);
                param_label.add(object1.getString("param_label"));
                param_value.add(object1.getString("param_value"));
            }
            //Adding the header json array to Array list
            ArrayList<String> header_label = new ArrayList<String>();
            ArrayList<String> header_value = new ArrayList<String>();
            JSONArray array2 = object.getJSONArray("method_header");
            for (int i = 0; i < array2.length(); i++) {
                JSONObject object1 = array2.getJSONObject(i);
                header_label.add(object1.getString("header_label"));
                header_value.add(object1.getString("header_value"));
            }

            HttpClient client = new DefaultHttpClient();
            if (method.toLowerCase().equals("get")) {
                String parstr = "?";
                //Constructing the parameters to get url
                for (int i = 0; i < param_label.size(); i++) {
                    parstr += param_label.get(i) + "=" + param_value.get(i) + "&";
                }
                parstr = removeLastChar(parstr);
                // Add the parameter to url
                HttpGet get = new HttpGet(url + parstr);
                // Adding the header to get
                for (int i = 0; i < header_label.size(); i++) {
                    get.addHeader(header_label.get(i), header_value.get(i));
                }
                HttpResponse response = client.execute(get);
                // get the response from the http
                BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                String line = "";
                while ((line = reader.readLine()) != null) {
                    result += line;
                }
            } else if (method.toLowerCase().equals("post")) {
                HttpPost post = new HttpPost(url);
                //Adding header to post
                for (int i = 0; i < header_label.size(); i++) {
                    post.addHeader(header_label.get(i), header_value.get(i));
                }
                //Adding the params to post
                List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
                for (int i = 0; i < param_label.size(); i++) {
                    urlParameters.add(new BasicNameValuePair(param_label.get(i), param_value.get(i)));
                }
                //Adding post entity to post
                if (param_label.size() != 0)
                    post.setEntity(new UrlEncodedFormEntity(urlParameters));
                HttpResponse response = client.execute(post);
                //Getting the response from the Http request
                BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                String line = "";
                while ((line = reader.readLine()) != null) {
                    result += line;
                }
            }
        } catch (Exception e) {
            result=e.getMessage();
        }
        return Response.ok(result)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
                .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
    }

    private static String removeLastChar(String str) {
        return str.substring(0, str.length() - 1);
    }
}

