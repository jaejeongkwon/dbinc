package com.dbinc.aim.lenaPLjson;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class UiLPL {
	public String SelEngine() throws Exception{
		
		String sEngine = null;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("======================================");
		System.out.println("1.LENA - ALL  ");
		System.out.println("2.LENA - HTTP  ");
		System.out.println("3.LENA - WAS  ");
		System.out.println("4.LENA - SESSION  ");
		System.out.println("======================================");
		System.out.print("Select Engine : ");
		int sle = sc.nextInt();
		
		switch(sle) {
		case 1:
				sEngine = "ALL";
			break; 
		case 2:
				sEngine = "WEB";
			break;
		case 3:
				sEngine = "WAS";
			break;
		case 4:
				sEngine = "SESSION";
			break;	
		default : sEngine = "WEB"; 
		}
		
	return sEngine;
	}
	
	public int SelLog() throws Exception{
		Scanner sc = new Scanner(System.in);
					
		System.out.println("======================================");
		System.out.print("Select LOG : ");
		int sle = sc.nextInt();
		
		return sle;
	}
	
    public String SelDay() throws Exception{
    	String selDay = null;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("======================================");
		System.out.println("1.Today  ");
		System.out.println("2.View Selected Monthly log");
		System.out.println("======================================");
		System.out.print("Select Log Date : ");
		int sle = sc.nextInt();
		
		switch(sle) {
		case 1:
				selDay = "today";
			break; 
		case 2:
				selDay = "month";
			break;
		default : selDay = "1"; 
		}
		
		return selDay;
	}
    
    public static String getTimeStamp(String dformat) {
    	if (dformat=="") {
    		dformat="yyyy-MM-dd HH:mm:ss";
    	}
    	SimpleDateFormat sdf = new SimpleDateFormat(dformat);
    	Calendar time = Calendar.getInstance();
    	String TIMESTAMP = sdf.format(time.getTime());
    	
        return TIMESTAMP;
    }
	
    public static String get2day() {
    	String t2day = null;
    	Calendar cal = Calendar.getInstance();
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	t2day = sdf.format(cal.getTime());
    	
        return t2day;
    }
}
