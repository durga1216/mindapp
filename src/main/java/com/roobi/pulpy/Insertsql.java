package com.roobi.pulpy;

import com.mindots.util.Utils;

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
import java.sql.ResultSet;
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
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = (Connection) DriverManager.getConnection(config.get("URL"), config.get("USER"), config.get("PASS"));
            PreparedStatement st1=con.prepareStatement("INSERT INTO qb_company_info (SupportedLanguages,Country,CreateTime,domain,Email,PrimaryPhone,CompanyAddr,CompanyName,CompanyStartDate,FiscalYearStartMonth,) VALUES (?,?,?,?,?,?,?,?,?,?)");
            st1.setString(0,"test");
            st1.setString(1,"test");
            st1.setString(2,"test");
            st1.setString(3,"test");
            st1.setString(4,"test");

            st1.setString(5,"test");
            st1.setString(6,"test");
            st1.setString(7,"test");
            st1.setString(8,"test");
            st1.setString(9,"test");
            st1.executeUpdate();
            out.println("inserted");
        }catch (Exception e){
            out.println("error"+e.getMessage());
        }
    }
}
