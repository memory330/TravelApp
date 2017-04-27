package com.wxmylife.betty.base.modularization.module.user;

import com.wxmylife.betty.base.modularization.provider.IHomeProvider;
import com.wxmylife.betty.base.modularization.provider.IUserProvider;
import com.wxmylife.betty.base.modularization.router.ModuleManager;
import com.wxmylife.betty.base.modularization.router.ModuleRouter;

/**
 * Created by wxmylife on 2017/4/27.
 */

public class UserIntent {

    private static boolean hasModule() {
        return ModuleManager.getInstance().hasModule(IHomeProvider.HOME_MAIN_SERVICE);
    }

    public static void launchLogin() {
        ModuleRouter.newInstance(IUserProvider.USER_ACT_LOGIN)
            .navigation();
    }


    public static void launchRegister() {
        ModuleRouter.newInstance(IUserProvider.USER_ACT_REGISTER)
            .navigation();
    }
}
