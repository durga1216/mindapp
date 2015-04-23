package com.roobi.pulpy;

import com.mindots.util.Utils;
import com.mysql.jdbc.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by susee on 22/4/15.
 */
@WebServlet(name = "Oauthmash")
public class Oauthmash extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Content-Type","text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        Map<String, String> config = Utils.getConfigFromFile(getServletContext(), "config.properties");
        ArrayList<String> masmeth=new ArrayList<String>();
        ArrayList<String> masurl=new ArrayList<String>();
        ArrayList<String> mastext=new ArrayList<String>();
        HttpSession session=request.getSession(true);
        String id=(String) session.getAttribute("id");
        String appid=(String) session.getAttribute("appid");
        for (int i=1;i<6;i++) {
            masmeth.add(""+request.getParameter("masmeth" + i));
            masurl.add(""+request.getParameter("masurl" + i));
            mastext.add(""+request.getParameter("mastext" + i));
        }
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = (Connection) DriverManager.getConnection(config.get("URL"), config.get("USER"), config.get("PASS"));
            PreparedStatement st=con.prepareStatement("insert into omash(id,appid,masmeth1,masmeth2,masmeth3,masmeth4,masmeth5,masurl1,masurl2,masurl3,masurl4,masurl5,mastext1,mastext2,mastext3,mastext4,mastext5) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            st.setString(1,id);
            st.setString(2,appid);
            for (int i=0,j=3;i<5;i++,j++){
                st.setString(j,masmeth.get(i));
            }
            for (int i=0,j=8;i<5;i++,j++){
                st.setString(j,masurl.get(i));
            }
            for (int i=0,j=13;i<5;i++,j++){
                st.setString(j,mastext.get(i));
            }
            st.executeUpdate();
            con.close();
            response.sendRedirect("mashup_response.jsp");
            //out.println("<center><br><br><h2> Configured Successful..!<br><br>Your APPID is "+appid+"..<br>" +
              //      "<br>Check this URL <a>https://mindapp-pulpy.rhcloud.com/OauthmashupPulpy</a></h2></center>");
        }catch (Exception e){
            out.println("Some Error "+e.getMessage());
        }
        //System.out.println("output" + mastext.get(0));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
