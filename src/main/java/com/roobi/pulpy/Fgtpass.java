package com.roobi.pulpy;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mindots.util.Utils;

/**
 * Servlet implementation class Fgtpass
 */
@WebServlet("/Fgtpass")
public class Fgtpass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Fgtpass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map<String, String> config = Utils.getConfigFromFile(getServletContext(), "config.properties");
	   	 response.setHeader("Content-Type","text/html;charset=UTF-8");
	    PrintWriter out=response.getWriter(); 
		String s1=request.getParameter("s1");
		Connection con=null;
try{
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = (Connection) DriverManager.getConnection(config.get("URL"),config.get("USER"),config.get("PASS"));
	        PreparedStatement st=null;PreparedStatement st1=null;
	        st1=con.prepareStatement("select * from login where email=?");
	        st1.setString(1, s1);
	        ResultSet rs=st1.executeQuery();
	        while(rs.next()){
	        	String mail=rs.getString("email");
	        	String pass=rs.getString("pwd");
	        	String fn=rs.getString("fn");
	      
	        String userName = "marketing@minddotss.com";
			  String host = "smtp.mandrillapp.com";
			String port="587";
			String text="Hi "+fn+",\nGreetings from Mind Dots!!"
			+"\n \nMindPulpy User Credentials"
			+"\n -      UserName: "+mail+"."
			+"\n -      PassWord: "+pass+"."
			+"\n \nIf you find any difficulties in using our platform / encounter any bugs then please drop an email to developer@minddotss.com \n"
			+"\n \nWith Love,"
			+"\n Product Engineering Team"
			+"\n Http://www.minddotss.com";
			String subject="From Mind Dots: User Credentials";
			String password="bfOjWW_1dPe6Y3a9odyWsQ";
			String[] to={mail};


			   // Get system properties object
			   Properties props = System.getProperties();
			   props.put("mail.smtp.user", userName);
			   props.put("mail.smtp.host", host);
			           if(!"".equals(port))
			   props.put("mail.smtp.port", port);

			   try{
				   Session session1 = Session.getDefaultInstance(props, null);
			       MimeMessage msg = new MimeMessage(session1);
			       msg.setText(text);
			       msg.setSubject(subject);
			       msg.setFrom(new InternetAddress("noreply@minddotss.com"));
			       msg.addRecipient(Message.RecipientType.TO, new InternetAddress(s1));
			       msg.saveChanges();
			                   Transport transport = session1.getTransport("smtp");
			                   transport.connect(host, userName, password);
			                   transport.sendMessage(msg, msg.getAllRecipients());
			                   transport.close();
			   }catch (MessagingException mex) {
			out.println(mex);      
			   }         
			   String alert="*Hi "+fn+".. Pls Check Ur Mail...!!";
	           	 RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
	                request.setAttribute("alert", alert); // set your String value in the attribute
	                dispatcher.forward( request, response );
			}
	        String alert="*Sorry Invalid User.. Please SignUp..!!";
          	 RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
               request.setAttribute("alert", alert); // set your String value in the attribute
               dispatcher.forward( request, response );
	        }
			catch(Exception e){
				out.println(e);
			}
	}

}
