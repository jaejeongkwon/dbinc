package com.dbinc.jennifer.adapter;

import com.aries.extension.data.EventData;
import com.aries.extension.handler.EventHandler;
import com.aries.extension.util.LogUtil;
//import com.aries.extension.util.PropertyUtil;

public class EventAdapter implements EventHandler {
    public void on(EventData[] events) {
	
    	
        for(EventData data : events) {
        	/*
        	LogUtil.error("Domain Name : " + data.domainName);
        	LogUtil.error("Instance Name : " + data.instanceName);
        	LogUtil.error("Transaction ID : " + data.txid);
        	LogUtil.error("Service Name : " + data.serviceName);
        	LogUtil.error("Error Type : " + data.errorType);
        	LogUtil.error("Event Level : " + data.eventLevel);
            LogUtil.error("Detail : " + data.detailMessage);
            */
        	
            String eMsg = "[" + data.eventLevel   + "] "
                              + data.errorType    + " - " 
            		          + data.instanceName + " (" 
            		          + data.domainName   + ") : " 
            		          + data.metricsName   + " "
                              + data.detailMessage;
            
            // Event Mode: EVENT - message logging
            LogUtil.info(eMsg);
        }
    }
}