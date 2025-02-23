package com.dbinc.aim.lenaPLjson;

import java.io.BufferedReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ParsingJSON {
	public void actionPerformed(BufferedReader br, String itemjson, String term ) throws Exception{	
		JSONParser parser = new JSONParser();
		try {  	
            JSONObject jOb ;
            String line;
            
            System.out.println("============================================================================================================================================");
			System.out.println("       TIME \t\t" + ItemLenaPL.makeTitle(itemjson) );
			System.out.println("============================================================================================================================================");
			
			ReadJob rj = new ReadJob();
			
    		while ((line = br.readLine()) != null) {
    			jOb = (JSONObject) parser.parse(line);
    			
    			System.out.println(" ");
    			String gtime = jOb.get("TIMESTAMP").toString();
    			
	    		if ( term.equals("month") ) {
	    			rj.actionPerformed(gtime, itemjson, jOb);
		    	
	    		} else if (gtime.contains(UiLPL.get2day()) ){ 
	    		//if (gtime.contains("2020-11-23") ){
	    			rj.actionPerformed(gtime, itemjson, jOb);
	    		}
    	    }
    		
    		System.out.println("============================================================================================================================================");
    		/*			
    		System.out.println("============================================================================================================================================");
			System.out.println("       TIME \t\t" + ItemLenaPL.makeTitle(itemjson) );
			System.out.println("============================================================================================================================================");
			*/
			
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
