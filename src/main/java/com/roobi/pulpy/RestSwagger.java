package com.roobi.pulpy;

import org.json.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by susee on 5/5/15.
 */
@Path("/swagger")
public class RestSwagger {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{usrid}")
    public Response getdata(@PathParam("usrid") String usrid) {
        String result = "{\n" +
                "  \"swaggerVersion\": \"1.2\",\n" +
                "  \"basePath\": \"http://mindapp-pulpy.rhcloud.com\",\n" +
                "  \"apis\": [\n" +
                "    {\n" +
                "       \"tags\":[  \n" +
                "               \"mind\"\n" +
                "            ]," +
                "      \"path\": \"/AuthXmlPulpy\",\n" +
                "      \"operations\": [\n" +
                "        {\n" +
                "          \"method\": \"GET\",\n" +
                "          \"summary\": \"Get the simplified result using mindpulpy\",\n" +
                "          \"type\": \"string\",\n" +
                "          \"nickname\": \"mashup result\",\n" +
                "          \"produces\":[  \n" +
                "               \"application/xml\",\n" +
                "               \"application/json\"\n" +
                "            ]," +
                "          \"parameters\": [\n" +
                "            {\n" +
                "              \"name\": \"appid\",\n" +
                "              \"description\": \"Enter your unique appid.\",\n" +
                "              \"required\": true,\n" +
                "              \"type\": \"string\",\n" +
                "              \"paramType\": \"query\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"name\": \"p1\",\n" +
                "              \"description\": \"Enter your parameter1.\",\n" +
                "              \"required\": true,\n" +
                "              \"type\": \"string\",\n" +
                "              \"paramType\": \"query\"\n" +
                "            }\n" +
                "          ]\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ],\n" +
                "  \"models\": {}\n" +
                "}";
        String output = "{\n" +
                "  \"swaggerVersion\": \"1.2\",\n" +
                "  \"basePath\": \"http://mindapp-pulpy.rhcloud.com\",\n" +
                "  \"apis\": [\n" +
                "    {\n" +
                "\"tags\":{\"name\":\"mind\",\"description\":\"Get simplified data using appid\"},\n" +
                "      \"path\": \"/AuthXmlPulpy\",\n" +
                "      \"operations\": [\n";
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://127.6.250.130:3306/mpulpy", "adminPQ1iFfN", "J5JhBL-XC9NG");
            PreparedStatement st = con.prepareStatement("SELECT appid From xmlconfig where id='" + usrid + "'");
            ResultSet rs = st.executeQuery();
            ArrayList<String> arrapid = new ArrayList<String>();
            if (rs != null) {
                while (rs.next()) {
                    String apid = rs.getString("appid");
                    arrapid.add(apid);
                }
            }

            for (int i = 0; i < arrapid.size(); i++) {
                PreparedStatement st1 = con.prepareStatement("SELECT * From config where appid='" + arrapid.get(i) + "'");
                ResultSet rs1 = st1.executeQuery();
                ArrayList<String> parm = new ArrayList<String>();
                output += "        {\n" +
                        "          \"method\": \"GET\",\n" +
                        "          \"summary\": \"Mindpulpy simplified result for Appid " + arrapid.get(i) + "\",\n" +
                        "          \"type\": \"string\",\n" +
                        "          \"nickname\": \"Simplified result\",\n" +
                        "          \"produces\":[  \n" +
                        "               \"application/xml\",\n" +
                        "               \"application/json\"\n" +
                        "            ]," +
                        "          \"parameters\": [\n" +
                        "            {\n" +
                        "              \"name\": \"appid\",\n" +
                        "              \"value\": \"" + arrapid.get(i) + "\",\n" +
                        "              \"description\": \"Enter your unique appid.\",\n" +
                        "              \"required\": true,\n" +
                        "              \"type\": \"string\",\n" +
                        "              \"paramType\": \"query\"\n" +
                        "            },";

                if (rs1 != null) {
                    while (rs1.next()) {
                        for (int n = 1; n < 11; n++) {
                            String par = "" + rs1.getString("p" + n);
                            if (!par.equals("null")) {
                                parm.add(par);
                                output += "    \n        {\n" +
                                        "              \"name\": \"p" + n + "\",\n" +
                                        "              \"description\": \"Enter " + par + ".\",\n" +
                                        "              \"required\": true,\n" +
                                        "              \"type\": \"string\",\n" +
                                        "              \"paramType\": \"query\"\n" +
                                        "            },";
                            }
                        }
                    }
                }
                output=removeLastChar(output);
                output += "\n          ]\n" +
                        "        },";
            }
            output=removeLastChar(output);
            output += "      ]\n" +
                    "    }\n" +
                    "  ],\n" +
                    "  \"models\": {}\n" +
                    "}";
        }//try
        catch (Exception e) {
            e.printStackTrace();
        }
        return Response.ok(output)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
                .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
    }
    private static String removeLastChar(String str) {
        return str.substring(0, str.length()-1);
    }
}
