package com.dbinc.aim.lenaWebcmxJson;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadLenaHwork {
	public static BufferedReader readHwork(String pl) throws Exception{
	//public BufferedReader readLPL() throws Exception{	
		BufferedReader br=null;
		
		//br = new BufferedReader(new FileReader("D:/lena-temp/LPL/web-sample.json"));
		br = new BufferedReader(new FileReader(pl));
		return br;
		
	}
}
