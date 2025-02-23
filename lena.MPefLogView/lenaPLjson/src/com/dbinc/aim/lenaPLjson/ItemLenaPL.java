package com.dbinc.aim.lenaPLjson;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ItemLenaPL {
	//common
	static String nname        	= "refNode";
	static String iname 		= "name";
	static String dname 		= "name";
	static String procCpuRate 	= "procCpuRate";
	static String procUsedMem 	= "procUsedMem";
	
	//WEB
	static String ActThread 	= "actThread";
	static String MaxThread 	= "maxThread";
	
	//WAS
	static String ajpActThread	= "ajpActThread";
	static String ajpMaxThread 	= "ajpMaxThread";
	static String httpActThread	= "httpActThread";
	static String httpMaxThread	= "httpMaxThread";
	static String usedHeap 		= "usedHeap";
	static String maxHeap   	= "maxHeap";
	
	//datasource
	static String actDbConn   	= "actDbConn";
	static String maxDbConn   	= "maxDbConn";
	
	//session
	static String actSession   	= "actSession";
	static String maxSession   	= "maxSession";
	
	public static String makeItem(JSONObject webObj, String itemjson){
		String setItem="";
		String tempItem="";
		String pcpur="";
		
		pcpur = webObj.get(procCpuRate).toString();
		
		if ( webObj.get(procCpuRate).toString().length() > 4 ) {
			pcpur = webObj.get(procCpuRate).toString().substring(0,3);
		} 
			
		if (itemjson.equals("WEB")){
			tempItem = webObj.get(ActThread) + " / " +  webObj.get(MaxThread) + "\t\t" + 
				    	pcpur + "\t\t" + webObj.get(procUsedMem);
		}
		
		if (itemjson.equals("WAS") ){
			tempItem = webObj.get(ajpActThread) + " / " + webObj.get(ajpMaxThread) + "\t\t" + 
					   webObj.get(httpActThread)  + " / " + webObj.get(httpMaxThread) + "\t\t" + 
					   webObj.get(usedHeap)  + " / " + webObj.get(maxHeap)+ "\t\t" +
					   pcpur + "\t\t" + webObj.get(procUsedMem);
		}

		if (itemjson.equals("SESSION") ){
			tempItem = webObj.get(actSession) + " / " + webObj.get(maxSession);
		}
		
		setItem = "(" + webObj.get(nname) +")" + " " + webObj.get(iname) + "\t\t" +  tempItem ;
		return setItem;
	}
	
	public static String makeTitle(String itemjson){
		String setTitle="";
		String tempItem="";
		
		if (itemjson.equals("WEB") ){
			tempItem = "   Act" + "/" +  "Max" + "\t\t" + 
		               "procCpuRate" + "\t \t" + "procUsedMem";
		}
		
		
		if (itemjson.equals("WAS") ){
			tempItem = " ajp" + "/" + "Max " + "\t\t" + 
					   "http"  + "/" + "Max " + "\t" + 
					   "usedHeap"  + "/" + "maxHeap" + "\t" +
					   "procCpuRate" + "\t" + "procUsedMem";
		}
		
		if (itemjson.equals("datasources") ){
			tempItem = "actDbConn" + "/" + "maxDbConn";
		}
		
		if (itemjson.equals("SESSION")){
			tempItem = "actSession" + "/" + "maxSession";
		}
		
		if (itemjson.equals("ALL") ){
			tempItem = "HTTP: Act" + "/" +  "Max" + "\t\t procCpuRate" + "\t\t" + "procUsedMem" + "\n "+
					   "   \t\t\t\t                    WAS: ajp" + "/" + "Max " + "\t http"  + "/" + "Max " + "\t usedHeap"  + "/" + "maxHeap" + "\t procCpuRate" + "\t" + "procUsedMem \n" + 
					   "   \t\t\t\t                    WAS - DatSource Name : actDbConn" + " / " + "maxDbConn \n" +
					   "   \t\t\t\t                    SESSION : actSession" + " / " + "maxSession" ;
		}
		
		setTitle = "   (node)" + " " + "instance" + "  \t    " +  tempItem ;
		
		return setTitle;
	}
	
	public static void getDS(JSONArray dOb){
		JSONObject aob ;
          
		for (Object dsObj: dOb.toArray()){			
			aob = (JSONObject) dsObj;
			System.out.println( " \t \t \t \t                      " + aob.get(dname) + " : "+ aob.get(actDbConn) + " / " + aob.get(maxDbConn));
			
			
		}
	}
	
}
