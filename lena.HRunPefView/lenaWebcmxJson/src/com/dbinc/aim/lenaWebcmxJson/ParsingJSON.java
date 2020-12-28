package com.dbinc.aim.lenaWebcmxJson;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ParsingJSON {
	public void actionPerformed(BufferedReader br, String hinst, BufferedReader wr, String pwork) throws Exception{
		JSONParser parser = new JSONParser();
		
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
		try {  	
            JSONObject jOb ;
            JSONArray  jArr;
            JSONObject webObj;
            String line;
            
            System.out.println("============================================================================================================================================");
			System.out.println("       TIME \t" + ItemLenaWPL.makeTitle() );
			System.out.println("============================================================================================================================================");
			
    		while ((line = br.readLine()) != null) {
    			
    			if (line.indexOf("#") != -1){
    				System.out.println("                     " + hinst + ": " + line);
    				break;
    			}
    			
    			jOb = (JSONObject) parser.parse(line);
    			
    			String gtime = dayTime.format( new Date( Long.parseLong(jOb.get("currentTime").toString())) );
	    		System.out.println( gtime + "  " + hinst + ": " + ItemLenaWPL.makeItem(jOb, "web", wr, pwork));
    			
	    		// sub data
	    		jArr = (JSONArray) jOb.get("wasInfos");
	    		
	    		if (jArr.size() == 0){
    				System.out.println("                     " + hinst + ": There is no linked WAS. (no ajp)");
    				break;
    			}
	    		
    			webObj = (JSONObject) jArr.get(0);
    			
    			
	    		
	    		for (Object ob : jArr){
	    			JSONObject wi = (JSONObject)ob;
	    			webObj.get("wasInfos");
	    			System.out.println( gtime + "  " + hinst + ": " + ItemLenaWPL.makeItem(wi, "wasInfos", wr, pwork));
	    		}
    	    }
    		
    		System.out.println("============================================================================================================================================");
			
    	} catch (IOException e) {
    		e.printStackTrace();
    	} catch (ParseException e) {
    		e.printStackTrace();
    	}finally {
    	    if(br!=null) {
    	    	br.close();
    	    }
    	}
	}

}
