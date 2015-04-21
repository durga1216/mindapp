package com.semantics3.api;

import org.json.JSONObject;

/**
 * Created by susee on 21/4/15.
 */
public class Test {
    public static void main(String args[]){
        String data="{\"qb_total_result\":{\"companyinfo_result\":{\"CompanyInfo\":{\"CompanyName\":\"mind\",\"LegalName\":\"mind\",\"CompanyAddr\":{\"Id\":\"1\",\"Line1\":\"madiwala\",\"City\":\"Bangalore\",\"Country\":\"IN\",\"CountrySubDivisionCode\":\"Karnataka\"},\"CustomerCommunicationAddr\":{\"Id\":\"1\",\"Line1\":\"madiwala\",\"City\":\"Bangalore\",\"Country\":\"IN\",\"CountrySubDivisionCode\":\"Karnataka\"},\"LegalAddr\":{\"Id\":\"1\",\"Line1\":\"madiwala\",\"City\":\"Bangalore\",\"Country\":\"IN\",\"CountrySubDivisionCode\":\"Karnataka\"},\"PrimaryPhone\":{\"FreeFormNumber\":\"8755457775\"},\"CompanyStartDate\":\"2015-04-11\",\"FiscalYearStartMonth\":\"January\",\"Country\":\"IN\",\"Email\":{\"Address\":\"jhytkwtc.v3u@20mail.it\"},\"WebAddr\":{},\"SupportedLanguages\":\"en\",\"NameValue\":[{\"Name\":\"NeoEnabled\",\"Value\":\"true\"},{\"Name\":\"IndustryType\",\"Value\":\"Milk substitutes manufacturing\"},{\"Name\":\"IndustryCode\",\"Value\":\"311511\"},{\"Name\":\"SubscriptionStatus\",\"Value\":\"TRIAL\"},{\"Name\":\"OfferingSku\",\"Value\":\"QuickBooks Online Plus\"},{\"Name\":\"PayrollFeature\",\"Value\":\"false\"},{\"Name\":\"AccountantFeature\",\"Value\":\"false\"}],\"domain\":\"QBO\",\"sparse\":false,\"Id\":\"1\",\"SyncToken\":\"5\",\"MetaData\":{\"CreateTime\":\"2015-04-11T16:24:47-07:00\",\"LastUpdatedTime\":\"2015-04-11T16:26:53-07:00\"}},\"time\":\"2015-04-20T23:17:21.496-07:00\"}}}\n";
        //String data="{\"qb_total_result\":\"dfasddfasd\"}";
        System.out.println("test");
        JSONObject object=new JSONObject(data);
        JSONObject object1=object.getJSONObject("qb_total_result");
        JSONObject object2=object1.getJSONObject("companyinfo_result");
        JSONObject object3=object2.getJSONObject("CompanyInfo");

        JSONObject object4=object3.getJSONObject("CompanyAddr");
        JSONObject object5=object3.getJSONObject("Email");
        JSONObject object6=object3.getJSONObject("PrimaryPhone");
        JSONObject object7=object3.getJSONObject("MetaData");

        String nnn=object3.getString("CompanyName");
        System.out.println(nnn);
    }
}
