package com.wxmylife.betty.user;

import android.widget.Button;
import com.wxmylife.betty.base.mvp.view.AppDelegate;

/**
 * Created by wxmylife on 2017/4/27.
 */

public class RegisterDelegate extends AppDelegate {

    @Override public int getRootLayoutId() {
        return R.layout.activity_register;
    }


    @Override public void initWidget() {
        super.initWidget();
        Button button=get(R.id.user_button_register);
        button.setText("这个是注册");
    }


    public void registerFinish(){
        Button button=get(R.id.user_button_register);
        button.setText("注册完成");
    }
}
