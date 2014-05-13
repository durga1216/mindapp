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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mindots.util.Utils;

public class LoginPulpy extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con=null; 

    public LoginPulpy() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> config = Utils.getConfigFromFile(getServletContext(), "config.properties");
	    PrintWriter out=response.getWriter(); 
		String s1=request.getParameter("s1");
		String s2=request.getParameter("s2");
		String s3=request.getParameter("s3");
		String s4=request.getParameter("s4");
		try{
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = (Connection) DriverManager.getConnection(config.get("URL"),config.get("USER"),config.get("PASS"));
	        PreparedStatement st=null;
			 st=con.prepareStatement("insert into login(email,fn,ln,pwd) values ('"+s1+"','"+s2+"','"+s3+"','"+s4+"')");
			 st.executeUpdate();
		     st.close();
		      String userName = "marketing@minddotss.com";
		  String host = "smtp.mandrillapp.com";
		String port="587";
		String text="Hi "+s2+",\nGreetings from Mind Dots!!"
				+"\n       USERNAME:\t"+s1+""
				+"\n       PASSWORD:\t"+s4+""
		+"\nThanks for being early adopter to our platform, currently MindPulpy is in beta stage. If you find any difficulties in using our platform / encounter any bugs then please drop an email to developer@minddotss.com \n"
		+"What you can you do with MindPulpy?"
		+"\n -      Integrate with your API’s or third party api’s."
		+"\n -      Simplify and standardize the output."
		+"\n -      Mix/ Mash up with different APIS."
		+"\n -      Create PhoneGap app using our UI Generation tools and feature your apps to our app galleries."
		+"\n \n With Love,"
		+"\n Product Engineering Team"
		+"\n Http://www.minddotss.com";
		String subject="From Mind Dots: Thanks for Signing-up";
		String password="bfOjWW_1dPe6Y3a9odyWsQ";
		String[] to={s1};


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
		       msg.setFrom(new InternetAddress("sales@minddotss.com"));
		       msg.addRecipient(Message.RecipientType.TO, new InternetAddress(s1));
	           msg.addRecipient(Message.RecipientType.CC, new InternetAddress("marketing@minddotss.com"));
		       msg.saveChanges();
		                   Transport transport = session1.getTransport("smtp");
		                   transport.connect(host, userName, password);
		                   transport.sendMessage(msg, msg.getAllRecipients());
		                   transport.close();
		   }catch (MessagingException mex) {
		out.println(mex);      
		   }
		     //out.println("insert sucess");
		     response.sendRedirect("login.jsp");

		}
		catch(Exception e){
			out.println(e);
		}
		

	}

}
