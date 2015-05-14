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
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by susee on 14/5/15.
 */
@WebServlet(name = "SaveConsole")
public class SaveConsole extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Map<String, String> config = Utils.getConfigFromFile(getServletContext(), "config.properties");
        HttpSession session = request.getSession(true);
        String id = (String) session.getAttribute("id");

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = (Connection) DriverManager.getConnection(config.get("URL"), config.get("USER"), config.get("PASS"));
            PreparedStatement st = con.prepareStatement("insert into csauthen(id,appName,baseUrl,authen,apiLabel,apiKey,basicUser,basicPass,h1,h2,h3,h4,h5,hv1,hv2,hv3,hv4,hv5) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            st.setString(1, id);
            st.setString(2, "" + request.getParameter("appName"));
            st.setString(3, "" + request.getParameter("baseUrl"));
            st.setString(4, "" + request.getParameter("authen"));
            st.setString(5, "" + request.getParameter("apiLabel"));
            st.setString(6, "" + request.getParameter("apiKey"));
            st.setString(7, "" + request.getParameter("basicUser"));
            st.setString(8, "" + request.getParameter("basicPass"));

            for (int i = 1, j = 9; i < 6; i++, j++) {
                st.setString(j, "" + request.getParameter("h" + i));
            }
            for (int i = 1, j = 14; i < 6; i++, j++) {
                st.setString(j, "" + request.getParameter("hv" + i));
            }
            st.executeUpdate();

            PreparedStatement st1 = con.prepareStatement("SELECT * From csauthen ORDER BY conid DESC LIMIT 1");
            ResultSet resultSet = st1.executeQuery();
            String conid = "";
            while (resultSet.next()) {
                conid = ""+resultSet.getInt("conid");
            }

            for (int i = 1; i < 6; i++) {
                String mashurl = "" + request.getParameter("masurl" + i);
                if (!mashurl.equals("null")) {
                    PreparedStatement st2 = con.prepareStatement("insert into csmethod(conid,masmeth,masurl,mastext) values (?,?,?,?)");
                    st2.setString(1, conid);
                    st2.setString(2, "" + request.getParameter("masmeth" + i));
                    st2.setString(3, mashurl);
                    st2.setString(4, "" + request.getParameter("mastext" + i));
                    st2.executeUpdate();
                }
            }

            con.close();
            out.println("<center><br><br><h2> Configured Successful..!<br><br>Your APPID is " + conid + "..<br>" +
                    "<br></center>");
        } catch (Exception e) {
            out.println("Some Error " + e.getMessage());
        }
    }
}
