package com.wxmylife.betty.base.modularization.module.user;

import android.app.Activity;
import com.wxmylife.betty.base.modularization.provider.IUserProvider;
import com.wxmylife.betty.base.modularization.router.ModuleManager;

/**
 * Created by wxmylife on 2017/4/27.
 */

public class UserService {

    private static boolean hasModule() {
        return ModuleManager.getInstance().hasModule(IUserProvider.USER_MAIN_SERVICE);
    }



}
