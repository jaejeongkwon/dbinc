package com.dbinc.aim.lenaWebcmxJson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ChangeWorkerName {
	
	public String stateWR(String status) throws Exception{
		
		int skey = Integer.parseInt(status);
		
		switch(skey) {
		case 0:
			return "Idel";
		case 1:
			return "Active";
		case 2:
			return "Recover";
		case 3:
			return "Force";
		case 4:
			return "Busy";
		case 5:
			return "Error";
		case 6:
			return "Probe";
		default :
			return "idel"; 
		}
		
	}
	
	public String changeWR(String wor, String wkey) {
		String sip=null;
		String spt=null;
		String ptemp=null;
		String ttemp=null;
		
		
		try {
			if ( wor.contains(wkey)){
				//was host ip
				int iip = wor.indexOf("worker." + wkey + ".host=");
				//worker.54a4cd51cd9f06381.host=192.168.41.132
				ptemp = wor.substring( iip , wor.substring(iip).indexOf("|")+iip);
				sip = ptemp.substring( ptemp.indexOf("=")+1 , ptemp.length());
				
				//was ajp port 
				int ipt = wor.indexOf("worker." + wkey + ".port=");
				//worker.54a4cd51cd9f06381.port=9109
				ttemp = wor.substring( ipt , wor.substring(ipt).indexOf("|")+ipt);
				spt = ttemp.substring( ttemp.indexOf("=")+1 , ttemp.length());
				}
			} catch (Exception e){
				
			}
		return sip +":"+ spt;
	}
	
	public String storeCF(String pl) throws Exception{
		
		File wp = new File (pl);
		BufferedReader br = new BufferedReader(new FileReader(wp));
		
		String wpf=null;
		StringBuilder sb = new StringBuilder();
		
		while ((wpf = br.readLine()) != null){
			sb.append(wpf + "|");
		}
		
		br.close();
		
		return sb.toString();
	}

}

