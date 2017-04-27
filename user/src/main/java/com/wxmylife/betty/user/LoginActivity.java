package com.wxmylife.betty.user;

import android.os.Bundle;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.wxmylife.betty.base.base.BaseActivity;
import com.wxmylife.betty.base.modularization.provider.IUserProvider;

/**
 * Created by wxmylife on 2017/4/27.
 */
@Route(path = IUserProvider.USER_ACT_LOGIN)
public class LoginActivity extends BaseActivity {

    @Override public int getLayoutId() {
        return R.layout.activity_login;
    }


    @Override public void initViews(Bundle savedInstanceState) {

    }


    @Override public void initToolBar() {

    }
}
