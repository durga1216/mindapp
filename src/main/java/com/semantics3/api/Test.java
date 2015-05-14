package com.semantics3.api;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by susee on 21/4/15.
 */
public class Test {
    public static void main(String args[]){
        String data="";
        JSONObject obj=new JSONObject();
        JSONArray arr=new JSONArray();
        obj.put("dfs","dfsd");
        obj.put("sdsd","sdfsd");
        arr.put(obj);arr.put(obj);
        System.out.println("test"+arr.toString());
        System.out.println("sdf");
    }
}
