package com.dbinc.aim.lenaWebcmxJson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;

public class WebLenaReader {

	 public BufferedReader readJsonFromUrl(String urls) {
		 BufferedReader br=null;
		 
		 try {
		 URL curl = new URL (urls);
		 URLConnection conn = curl.openConnection();
		   
		 br =  new BufferedReader(new InputStreamReader (conn.getInputStream()));
		 } catch (Exception e){
			 br =  new BufferedReader(new StringReader ("# ConnectException"));
		 } 
		 
		 return br;
	}
}
 
