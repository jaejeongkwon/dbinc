package com.dbinc.aim.lenaWebcmxJson;

import java.io.BufferedReader;
/**
 * 
 * @author jaejeongk
 * version : LENA 1.3.x
 * LENA http server���� �����ϴ� cmx-status�� ȣ���Ͽ� runtime ���ɵ����͸� �޾Ƽ� 
 * command window�� �����ִ� source�̴�.
 *
 */
public class LenaWebRPView {
	public static void main(String[] args) throws Exception {
		String SID = "";
		String SPT = "";
		String SWORK = "";
		
		SID = args[0];
		SPT = args[1];
		SWORK = args[2];
		
		BufferedReader br=null;
		BufferedReader swork=null;
		
		swork = ReadLenaHwork.readHwork(SWORK);
		
		ParsingJSON pj = new ParsingJSON();
		
		String curls  = "http://127.0.0.2:" + SPT + "/cmx-status?format=json&cmd=monitor";
		
		WebLenaReader wlr = new WebLenaReader();
		br = wlr.readJsonFromUrl(curls);
		
		try {
			 pj.actionPerformed(br, SID, swork, SWORK );
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
