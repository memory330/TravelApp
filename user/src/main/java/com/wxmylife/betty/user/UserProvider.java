package com.wxmylife.betty.user;

import android.content.Context;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.wxmylife.betty.base.modularization.provider.IUserProvider;

/**
 * Created by wxmylife on 2017/4/27.
 */
@Route(path = IUserProvider.USER_ACT_LOGIN)
public class UserProvider  implements IUserProvider{

    private Context mContext;


    @Override public void init(Context context) {
        this.mContext=context;
    }
}
