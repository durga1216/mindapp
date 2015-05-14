package com.roobi.pulpy;

import net.sf.json.JSONObject;
import org.json.JSONArray;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by susee on 14/5/15.
 */
@Path("/console")
public class RestConsole {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{id}")
    public Response addPlainText(@PathParam("id") String id) {
        String result11="no res";
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con= DriverManager.getConnection("jdbc:mysql://127.6.250.130:3306/mpulpy", "adminPQ1iFfN", "J5JhBL-XC9NG");
            PreparedStatement st=con.prepareStatement("SELECT * From csauthen where id='" + id + "'");
            ResultSet rs = st.executeQuery();
            String conid="";
            JSONObject obj=new JSONObject();
            JSONArray arr=new JSONArray();
            if(rs != null){
                while(rs.next()){
                    JSONObject object=new JSONObject();
                    object.put("app_name",""+rs.getString("appName"));
                    object.put("base_url",""+rs.getString("baseUrl"));
                    object.put("auth_type",""+rs.getString("authen"));
                    for (int i = 1; i < 6; i++) {
                        String head=""+rs.getString("h"+i);
                        if (!head.equals("null"))
                            object.put("header"+i,head);
                    }
                    PreparedStatement st1=con.prepareStatement("SELECT * From csmethod where conid='" + rs.getInt("conid") + "'");
                    ResultSet rs1 = st1.executeQuery();
                    JSONArray array=new JSONArray();
                    while (rs1.next()){
                        JSONObject object1=new JSONObject();
                        object1.put("method_type",rs1.getString("mashmeth"));
                        object1.put("method_url",rs1.getString("mashurl"));
                        JSONObject object2=new JSONObject();
                        String[] mastext=rs1.getString("mastext").split("&");
                        for (int i=0;i<mastext.length;i++){
                            String[] param=mastext[i].split("=");
                            object2.put("param_label"+i,param[0]);
                        }
                        object1.put("parameters",object2);
                        array.put(object1);
                    }
                    object.put("methods",array);
                    arr.put(object);
                }
                obj.put("result",arr);
            }
            result11= obj.toString();
            con.close();
        }//try
        catch(Exception e){
            result11= e.getMessage();
        }
        return Response.ok(result11)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
                .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
    }
}

