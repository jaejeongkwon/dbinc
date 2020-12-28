package com.dbinc.aim.lenaPLjson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ListLenaPLog {
	public BufferedReader storeBr(String pl) throws Exception{
		BufferedReader br=null;
		br = new BufferedReader(new FileReader(pl));
		return br;
	}
	
	public static void showFilesInDIr(String dirPath) {
	    File dir = new File(dirPath);
	    File files[] = dir.listFiles();

	    for (int i = 0; i < files.length; i++) {
	        File file = files[i];
	        if (file.isDirectory()) {
	            showFilesInDIr(file.getPath());
	        } else {
	            System.out.println("file: " + file);
	        }
	    }
	}
	
	public static String readDF(String lenaPD, String ind) throws Exception{
		String rlpd = null;
		
		/**
		 * local test (2/2) 
		 * File dir = new File("D:/lena-temp/LPL");
		 */
		File dir = new File(lenaPD);
		
	    File files[] = dir.listFiles();

	    for (int i = 0; i < files.length; i++) {
	    	File file = files[i];
	    	
	        if (file.isDirectory()) {
	            showFilesInDIr(file.getPath());
	        } else if (file.getName().endsWith(".log")){
	            System.out.println(i +": " + file);
	        }
	    }
	    
	    UiLPL ulpl = new UiLPL();
	    
	    if (ind.equals("-1")) {
	    	rlpd = files[ulpl.SelLog()].toString();
	    }else {
	    	rlpd = files[ Integer.parseInt(ind) ].toString();
	    }
	    
	    return rlpd;
	}
}
