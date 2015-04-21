package com.roobi.pulpy;

import com.mindots.util.Utils;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Map;

/**
 * Created by susee on 21/4/15.
 */
@WebServlet(name = "Insertsql")
public class Insertsql extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String data=request.getParameter("data");
        response.addHeader("Access-Control-Allow-Origin", "*");
        PrintWriter out=response.getWriter();
        Map<String, String> config = Utils.getConfigFromFile(getServletContext(), "config.properties");
        try{
            JSONObject object=new JSONObject(data);
            JSONObject object1=new JSONObject(object.getString("qb_total_result"));
            JSONObject object2=new JSONObject(object1.getString("companyinfo_result"));
            JSONObject object3=new JSONObject(object2.getString("CompanyInfo"));

            JSONObject object4=new JSONObject(object3.getString("CompanyAddr"));
            JSONObject object5=new JSONObject(object3.getString("Email"));
            JSONObject object6=new JSONObject(object3.getString("PrimaryPhone"));
            JSONObject object7=new JSONObject(object3.getString("MetaData"));

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = (Connection) DriverManager.getConnection(config.get("URL"), config.get("USER"), config.get("PASS"));
            PreparedStatement st1=con.prepareStatement("INSERT INTO qb_company_info (SupportedLanguages,Country,CreateTime,domain,Email,PrimaryPhone,CompanyAddr,CompanyName,CompanyStartDate,FiscalYearStartMonth) VALUES (?,?,?,?,?,?,?,?,?,?)");
            st1.setString(1,object3.getString("SupportedLanguages"));
            st1.setString(2,object3.getString("Country"));
            st1.setString(3, object7.getString("CreateTime"));
            st1.setString(4,object3.getString("domain"));
            st1.setString(5,object5.getString("Address"));

            st1.setString(6,object6.getString("FreeFormNumber"));
            st1.setString(7,object4.getString("Line1")+","+object4.getString("City"));
            st1.setString(8,object3.getString("CompanyName"));
            st1.setString(9,object3.getString("CompanyStartDate"));
            st1.setString(10,object3.getString("FiscalYearStartMonth"));
            st1.executeUpdate();
            out.println("inserted in database");
        }catch (Exception e){
            out.println("error"+e.getMessage());
        }
    }
}
