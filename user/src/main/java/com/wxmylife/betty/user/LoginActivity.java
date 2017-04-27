package com.wxmylife.betty.user;

import android.view.View;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.wxmylife.betty.base.modularization.module.user.UserIntent;
import com.wxmylife.betty.base.modularization.provider.IUserProvider;
import com.wxmylife.betty.base.mvp.presenter.ActivityPresenter;

/**
 * Created by wxmylife on 2017/4/27.
 */
@Route(path = IUserProvider.USER_ACT_LOGIN)
public class LoginActivity extends ActivityPresenter<LoginDelegate> implements View.OnClickListener {


    @Override public void onClick(View view) {
        int viewId = view.getId();
        if (viewId == R.id.user_button_login) {
            viewDelegate.userToLogin();
        }else if (viewId==R.id.user_button_register){
            UserIntent.launchRegister();
        }
    }


    @Override protected void bindEvenListener() {
        super.bindEvenListener();
        viewDelegate.setOnClickListener(this, R.id.user_button_login,R.id.user_button_register);
    }


    @Override protected Class<LoginDelegate> getDelegateClass() {
        return LoginDelegate.class;
    }
}
