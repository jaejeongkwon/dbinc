package com.dbinc.aim.lenaPLjson;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ReadJob {
	static JSONArray jArr = null;
	static JSONArray darr  = null;
	
	public void actionPerformed(String gtime, String itemjson, JSONObject jOb){
		jArr = (JSONArray) jOb.get(itemjson);
		
		for (Object ob : jArr){
			JSONObject wi = (JSONObject)ob;
			System.out.println( gtime + "\t " + ItemLenaPL.makeItem(wi, itemjson));
			
			try{
				if (itemjson.equals("WAS") ){
					darr = (JSONArray) wi.get("datasources");
					ItemLenaPL.getDS(darr);	
				}
			} catch (NullPointerException e){

			}
		}
	}
}
