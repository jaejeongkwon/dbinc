package com.dbinc.aim.lenaPLjson;

import java.io.BufferedReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class PasingJsonAll {
	public void actionPerformed(BufferedReader br, String term ) throws Exception{	
		JSONParser parser = new JSONParser();
		try {  	
            JSONObject jOb ;
            String line;
            
            System.out.println("============================================================================================================================================");
			System.out.println("       TIME \t\t" + ItemLenaPL.makeTitle("ALL") );
			System.out.println("============================================================================================================================================");
			
			
			String [] it = {"WEB","WAS","SESSION"};
			
			ReadJob rj = new ReadJob();
			
			while ((line = br.readLine()) != null) {
    			jOb = (JSONObject) parser.parse(line);
    			
    			System.out.println(" ");
    			String gtime = jOb.get("TIMESTAMP").toString();
    			
    			for (int i=0; i < it.length ;i++){
	    			if ( term.equals("month") ) {
		    			rj.actionPerformed(gtime, it[i], jOb);
		    			
	    			}else if (gtime.contains(UiLPL.get2day()) ){
	    			//if (gtime.contains("2020-11-23") ){ 
	    				rj.actionPerformed(gtime, it[i], jOb);
	    			}
    			}
    	    }
    		
    		System.out.println("============================================================================================================================================");
/*			
    		System.out.println("============================================================================================================================================");
			System.out.println("       TIME \t\t" + ItemLenaPL.makeTitle("ALL") );
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
