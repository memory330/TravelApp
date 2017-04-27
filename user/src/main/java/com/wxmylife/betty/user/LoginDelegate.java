package com.wxmylife.betty.user;

import com.wxmylife.betty.base.mvp.view.AppDelegate;
import com.wxmylife.betty.base.utils.LogUtil;

/**
 * Created by wxmylife on 2017/4/27.
 */

public class LoginDelegate extends AppDelegate {
    @Override public int getRootLayoutId() {
        return  R.layout.activity_login;
    }


    @Override public void initWidget() {
        super.initWidget();
    }

    public void userToLogin(){
        LogUtil.e("用户执行登陆");
    }
}
