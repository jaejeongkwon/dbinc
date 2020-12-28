package com.dbinc.aim.lenaWebcmxJson;

import org.json.simple.JSONObject;

import java.io.BufferedReader;

public class ItemLenaWPL {
	//http conn
	static String totalFAccess     	= "totalAccess";
	static String totalTraffic     	= "totalTraffic";
	static String activeThreads    	= "activeThreads";
	static String maxThreads      	= "maxThreads";
	static String idleThreads      	= "idleThreads";
	//wasinfos
	static String jvmRoute			= "jvmRoute";
	static String state  			= "state";
	static String activeConnections	= "activeConnections";
	static String idleConnections  	= "idleConnections";
	static String maxConnections   	= "maxConnections";
	static String totalError      	= "totalError";
	static String totalRAccess      = "totalAccess";
	static String webpid      		= "pid";
	
	static String userCpuUsage      = "userCpuUsage";
	static String systemCpuUsage    = "systemCpuUsage";


	
	public static String makeItem(JSONObject jobt, String itemjson, BufferedReader wr, String pwork) throws Exception{
		String setItem="";
		String tempItem="";

		ChangeWorkerName cn = new ChangeWorkerName();
		
		try {
		if (itemjson == "wasInfos"){
			// http to was
			tempItem = "                    " + 
//					   jobt.get(jvmRoute).toString()  + "  --  " + jobt.get(state).toString() + "  ||  " +
                       cn.changeWR(cn.storeCF(pwork) , jobt.get(jvmRoute).toString() )  + "  --  " + String.format("%-7s", cn.stateWR( jobt.get(state).toString() ) ) + "  ||  " +
					   jobt.get(activeConnections).toString() + " / " + jobt.get(idleConnections).toString() + " // " + jobt.get(maxConnections).toString() + "  ||  " +
					   jobt.get(totalRAccess).toString()  + " , " + jobt.get(totalError).toString() ;
		} else {
			//client to http
			tempItem = 
			           jobt.get(activeThreads).toString() + " / " + jobt.get(idleThreads).toString() + " // " +jobt.get(maxThreads).toString() + " || " +
				  	   jobt.get(totalFAccess).toString()  + " , " + jobt.get(totalTraffic).toString() + " || " +
			           jobt.get(userCpuUsage).toString()  + " , " + jobt.get(systemCpuUsage).toString() ;
		}
		
		setItem = tempItem;
		} catch (Exception e){
			
		}
		return setItem;
	}
	
	public static String makeTitle(){
		String setTitle="";
		String tempItem="";
		
			//client to http
			tempItem = "  to HTTP: active/idle//Max(Thread) || Total: Access,Traffic || User CPU , System CPU \n " +   
			"                --------------------------------------------------------------------------------------------------------------------------\n" +
			"                                                    to WAS: jvmRoute  -- State || active/idle//Max(Connections) || Total: Access , Error"; 
		
		setTitle = tempItem;
		
		return setTitle;
	}
}
