package com.roobi.pulpy;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mindots.util.Utils;

/**
 * Servlet implementation class FourthXmlConfig
 */
@WebServlet("/FourthXmlConfig")
public class FourthXmlConfig extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FourthXmlConfig() {
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
		 Map<String, String> config = Utils.getConfigFromFile(getServletContext(), "config.properties");
	   	 response.setHeader("Content-Type","text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession(true);
		HttpSession session4=request.getSession(true);
		String id=(String) session.getAttribute("id");
		String appid=(String) session.getAttribute("appid");
		String fourthroot=request.getParameter("fourthroot"); String fourthparent=request.getParameter("fourthparent");
		String fx1=request.getParameter("fx1");String fxv1=request.getParameter("fxv1");
		String fx2=request.getParameter("fx2");String fxv2=request.getParameter("fxv2");
		String fx3=request.getParameter("fx3");String fxv3=request.getParameter("fxv3");
		String fx4=request.getParameter("fx4");String fxv4=request.getParameter("fxv4");
		String fx5=request.getParameter("fx5");String fxv5=request.getParameter("fxv5");
		String fx6=request.getParameter("fx6");String fxv6=request.getParameter("fxv6");
		String fx7=request.getParameter("fx7");String fxv7=request.getParameter("fxv7");
		String fx8=request.getParameter("fx8");String fxv8=request.getParameter("fxv8");
		String fx9=request.getParameter("fx9");String fxv9=request.getParameter("fxv9");
		String fx10=request.getParameter("fx10");String fxv10=request.getParameter("fxv10");
		String fx11=request.getParameter("fx11");String fxv11=request.getParameter("fxv11");
		String fx12=request.getParameter("fx12");String fxv12=request.getParameter("fxv12");
		String fx13=request.getParameter("fx13");String fxv13=request.getParameter("fxv13");
		String fx14=request.getParameter("fx14");String fxv14=request.getParameter("fxv14");
		String fx15=request.getParameter("fx15");String fxv15=request.getParameter("fxv15");
		String fx16=request.getParameter("fx16");String fxv16=request.getParameter("fxv16");
		String fx17=request.getParameter("fx17");String fxv17=request.getParameter("fxv17");
		String fx18=request.getParameter("fx18");String fxv18=request.getParameter("fxv18");
		String fx19=request.getParameter("fx19");String fxv19=request.getParameter("fxv19");
		String fx20=request.getParameter("fx20");String fxv20=request.getParameter("fxv20");
		String fx21=request.getParameter("fx21");String fxv21=request.getParameter("fxv21");
		String fx22=request.getParameter("fx22");String fxv22=request.getParameter("fxv22");
		String fx23=request.getParameter("fx23");String fxv23=request.getParameter("fxv23");
		String fx24=request.getParameter("fx24");String fxv24=request.getParameter("fxv24");
		String fx25=request.getParameter("fx25");String fxv25=request.getParameter("fxv25");
		String fx26=request.getParameter("fx26");String fxv26=request.getParameter("fxv26");
		String fx27=request.getParameter("fx27");String fxv27=request.getParameter("fxv27");
		String fx28=request.getParameter("fx28");String fxv28=request.getParameter("fxv28");
		String fx29=request.getParameter("fx29");String fxv29=request.getParameter("fxv29");
		String fx30=request.getParameter("fx30");String fxv30=request.getParameter("fxv30");
		session4.setAttribute("fourthroot",fourthroot);session4.setAttribute("fourthparent",fourthparent);
		session4.setAttribute("fx1",fx1);session4.setAttribute("fxv1",fxv1);
	      session4.setAttribute("fx2",fx2);session4.setAttribute("fxv2",fxv2);
	      session4.setAttribute("fx3",fx3);session4.setAttribute("fxv3",fxv3);
	      session4.setAttribute("fx4",fx4);session4.setAttribute("fxv4",fxv4);
	      session4.setAttribute("fx5",fx5);session4.setAttribute("fxv5",fxv5);
	      session4.setAttribute("fx6",fx6);session4.setAttribute("fxv6",fxv6);
	      session4.setAttribute("fx7",fx7);session4.setAttribute("fxv7",fxv7);
	      session4.setAttribute("fx8",fx8);session4.setAttribute("fxv8",fxv8);
	      session4.setAttribute("fx9",fx9);session4.setAttribute("fxv9",fxv9);
	      session4.setAttribute("fx10",fx10);session4.setAttribute("fxv10",fxv10);
	      session4.setAttribute("fx11",fx11);session4.setAttribute("fxv11",fxv11);
	      session4.setAttribute("fx12",fx12);session4.setAttribute("fxv12",fxv12);
	      session4.setAttribute("fx13",fx13);session4.setAttribute("fxv13",fxv13);
	      session4.setAttribute("fx14",fx14);session4.setAttribute("fxv14",fxv14);
	      session4.setAttribute("fx15",fx15);session4.setAttribute("fxv15",fxv15);
         Connection con=null;
        	 try {
                 Class.forName("com.mysql.jdbc.Driver").newInstance();
                 con = (Connection) DriverManager.getConnection(config.get("URL"),config.get("USER"),config.get("PASS"));
                 PreparedStatement st=con.prepareStatement("insert into fourthxmlconfig(id,appid,fourthroot,fourthparent,fx1,fxv1,fx2,fxv2,fx3,fxv3,fx4,fxv4,fx5,fxv5,fx6,fxv6,fx7,fxv7,fx8,fxv8,fx9,fxv9,fx10,fxv10,fx11,fxv11,fx12,fxv12,fx13,fxv13,fx14,fxv14,fx15,fxv15,fx16,fxv16,fx17,fxv17,fx18,fxv18,fx19,fxv19,fx20,fxv20,fx21,fxv21,fx22,fxv22,fx23,fxv23,fx24,fxv24,fx25,fxv25,fx26,fxv26,fx27,fxv27,fx28,fxv28,fx29,fxv29,fx30,fxv30) values ('"+id+"','"+appid+"','"+fourthroot+"','"+fourthparent+"','"+fx1+"','"+fxv1+"','"+fx2+"','"+fxv2+"','"+fx3+"','"+fxv3+"','"+fx4+"','"+fxv4+"','"+fx5+"','"+fxv5+"','"+fx6+"','"+fxv6+"','"+fx7+"','"+fxv7+"','"+fx8+"','"+fxv8+"','"+fx9+"','"+fxv9+"','"+fx10+"','"+fxv10+"','"+fx11+"','"+fxv11+"','"+fx12+"','"+fxv12+"','"+fx13+"','"+fxv13+"','"+fx14+"','"+fxv14+"','"+fx15+"','"+fxv15+"','"+fx16+"','"+fxv16+"','"+fx17+"','"+fxv17+"','"+fx18+"','"+fxv18+"','"+fx19+"','"+fxv19+"','"+fx20+"','"+fxv20+"','"+fx21+"','"+fxv21+"','"+fx22+"','"+fxv22+"','"+fx23+"','"+fxv23+"','"+fx24+"','"+fxv24+"','"+fx25+"','"+fxv25+"','"+fx26+"','"+fxv26+"','"+fx27+"','"+fxv27+"','"+fx28+"','"+fxv28+"','"+fx29+"','"+fxv29+"','"+fx30+"','"+fxv30+"')");                
                 st.executeUpdate();
                 st.close();
                 st=con.prepareStatement("SELECT * FROM authen1 t1 JOIN config t2 ON t1.appid = t2.appid JOIN fourthconfig t3 on t1.appid=t3.appid WHERE t1.appid=?");
                 st.setString(1, appid);
           
                 ResultSet rs = st.executeQuery();
     	         while(rs.next()){
        	     String id1=rs.getString("id");
                 RequestDispatcher dispatcher = request.getRequestDispatcher("final.jsp");
                 request.setAttribute("id", appid); // set your String value in the attribute
                 dispatcher.forward( request, response );
     	         }
	              out.println("<h2><center><font color='green'>Processing...</font></center></h3>");
                // response.setHeader("Refresh", "1; URL=final.jsp");
                }
         catch(Exception e){}
		
		
	}

}