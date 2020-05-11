package com.dbinc.jennifer.adapter;

import com.aries.extension.data.UserData;
import com.aries.extension.handler.LoginHandler;
import com.aries.extension.util.LogUtil;
import com.aries.extension.util.PropertyUtil;

public class LoginAdapter implements LoginHandler {
    public UserData preHandle(String userid, String password) {
    	LogUtil.error("[LoginAdapter] - " +
                PropertyUtil.getValue("login_adapter", "subject", "Unknown subject"));

        if(userid.equals("adm") && password.equals("password1")) {
            return new UserData(userid, password, "admin", "Tester");
        }

        return null;
    }

    public String redirect(String userid, String password) {
        return "/dashboard/realtimeAdmin";
    }
}
