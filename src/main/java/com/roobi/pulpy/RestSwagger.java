package com.roobi.pulpy;

import org.json.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by susee on 5/5/15.
 */
@Path("/swagger")
public class RestSwagger {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getdata(){
        String result="{\n" +
                "  \"swaggerVersion\": \"1.2\",\n" +
                "  \"basePath\": \"http://mindapp-pulpy.rhcloud.com\",\n" +
                "\"tags\":{\"name\":\"Mind pulpy\",\"description\":\"Get simplified data using appid\"},"+
                "  \"apis\": [\n" +
                "    {\n" +
                "      \"path\": \"/AuthXmlPulpy\",\n" +
                "      \"operations\": [\n" +
                "        {\n" +
                "          \"method\": \"GET\",\n" +
                "          \"summary\": \"Get the simplified result using mindpulpy\",\n" +
                "          \"type\": \"string\",\n" +
                "          \"nickname\": \"mashup result\",\n" +
                "          \"parameters\": [\n" +
                "            {\n" +
                "              \"name\": \"appid\",\n" +
                "              \"description\": \"Enter your unique appid.\",\n" +
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
        JSONObject object=new JSONObject();
        object.put("","");

        return Response.ok(result)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
                .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
    }
}
