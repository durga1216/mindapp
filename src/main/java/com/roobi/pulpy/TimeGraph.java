package com.roobi.pulpy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.mindots.util.Utils;
import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class TimeGraph
 */
@WebServlet("/TimeGraph")
public class TimeGraph extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimeGraph() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		response.setHeader("Content-Type","text/html;charset=UTF-8");
		Map<String, String> config = Utils.getConfigFromFile(getServletContext(), "config.properties");
		 Connection con1=null;
		 out.println("<a style='color:#ffffff;margin-left:1250px;font-size:22px;' href='logsucess.jsp'>Back</a></div>");
        out.println("<style>h2{margin-right:150px;color:#ffffff;}option{font-size:22px;}select,th,td,input[type='text']{ padding:7px;text-align:left;text-weight:bold;width:250px;color:#FF9900;font-weight:bold;}input[type='submit']{color:#FFFFFF;background-color:#FF9900;border:solid 2px;border-radius:20px;padding:10px;width:120px;height:40px;font-family:verdana;font-size:17px;margin-left:50px;}</style>");
		 out.println("<html><body bgcolor='#FF9900'><br><center><h2>ADD Video Id</h2><br><form action='TimeGraph' method='post'>"
			 		+ "<input type='text' name='id' placeholder='Enter Your video Id'>");
		
		 
		    out.println("</select><input type='submit' value='submit'><br></form>");
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		final PrintWriter out=response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		Connection cn=(Connection) DriverManager.getConnection("jdbc:mysql://127.6.250.130:3306/mpulpy","adminPQ1iFfN","J5JhBL-XC9NG");
		//Connection cn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/mpulpy","root","root");
		Statement st=cn.createStatement();
		ResultSet rs=st.executeQuery("select * from mtest1");
		String[] id1={};int j=0;
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
    	   	  //out.println("Startedddd");       
    	   	     Thread.sleep(600 * 1000);
    	            }
    	        } catch(InterruptedException v) {
    	            out.println(v);
    	        } catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
					out.println(e);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					out.println(e);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					out.println(e);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					out.println(e);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					out.println(e);
				}
    	    }  
    	};
    	//out.println("Started");
    	thrd[i].start();
		}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
