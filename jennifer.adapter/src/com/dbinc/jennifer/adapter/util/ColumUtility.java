package com.dbinc.jennifer.adapter.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ColumUtility {
    public static String getTimeStamp(String dformat) {
    	if (dformat=="") {
    		dformat="yyyyMMddHHmmss";
    	}
    	SimpleDateFormat sdf = new SimpleDateFormat(dformat);
    	Calendar time = Calendar.getInstance();
    	String TIMESTAMP = sdf.format(time.getTime());
    	
        return TIMESTAMP;
    }
    
	public static String changeKeyword(String ORGS, String keyword, String switchword) {
		String CK="";
		CK=ORGS.replace(keyword, switchword);
		
		return CK;
	}
	
	public static String setPK(String eMsg, String pn) {
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		/*
		 * VARCHAR(20) 
		 */
		
		String PK="";
		/*
		String EL=eMsg.substring(11, 12);
		int pi=pn.length();
		
		PK="J" + EL + getTimeStamp("yyDHHmmssS")+ pn.substring((pi-5), (pi-1));
		  */
		PK="JNF" + getTimeStamp("yyyyMMddHHmmssS");
		
		return PK;
	}
}
