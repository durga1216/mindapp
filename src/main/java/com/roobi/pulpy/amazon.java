package com.roobi.pulpy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.mysql.jdbc.Connection;

public class amazon{

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
    	Class.forName("com.mysql.jdbc.Driver");
		Connection cn=(Connection) DriverManager.getConnection("jdbc:mysql://127.6.250.130:3306/mpulpy","adminPQ1iFfN","J5JhBL-XC9NG");
		//Connection cn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/mpulpy","root","root");
		Statement st=cn.createStatement();
		ResultSet rs=st.executeQuery("select * from mtest1");
		String[] id1=new String[3];int j=0;
		while(rs.next()){
				id1[j]=rs.getString("ids");
				j++;
		}
		int ino=id1.length;
		Thread[] thrd=new Thread[ino];
		for(int i=0;i<ino;i++){
		final String id=id1[i];
    	thrd[i]=new Thread() {
    	    public void run() {
    	        try {
    	        	while (true) {
    	        		Class.forName("com.mysql.jdbc.Driver");
    	        	System.out.println(id);
    	        		Connection cn=(Connection) DriverManager.getConnection("jdbc:mysql://127.6.250.130:3306/mpulpy","adminPQ1iFfN","J5JhBL-XC9NG");
    	        		//Connection cn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/mpulpy","root","root");
    	        		Statement st=cn.createStatement();
    	        		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    	        		DateFormat dateFormat1 = new SimpleDateFormat("HH:mm:ss");
    	        		 Date date = new Date();
    	        	     String dt=dateFormat.format(date);
    	        	     String tm=dateFormat1.format(date);
    	        	     HttpClient client = new DefaultHttpClient();
    	 				HttpGet get = new HttpGet("https://api.dailymotion.com/video/"+id+"?fields=views_last_hour");
    	 				HttpResponse response1 = client.execute(get);
    	 				BufferedReader br = new BufferedReader(
    	                         new InputStreamReader(response1.getEntity().getContent()));
    	       	     String line=null; String str="";
    	   	     while((line=br.readLine())!=null){
    	 	       	 str+=line;
    	 	       	 }
    	   	  JSONParser jsonParser = new JSONParser();
    	   	            JSONObject jsonObject = (JSONObject) jsonParser.parse(str);
    	   	         long value =  (Long) jsonObject.get("views_last_hour");
    	   	     st.executeUpdate("insert into mtest (m1,date,time,video_id) values ('"+value+"','"+dt+"','"+tm+"','"+id+"')");
    	                Thread.sleep(5 * 1000);
    	            }
    	        } catch(InterruptedException v) {
    	            System.out.println(v);
    	        } catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    	    }  
    	};
    	thrd[i].start();
    }}
    

}
