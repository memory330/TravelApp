package com.wxmylife.betty.base.modularization.module.home;

import com.wxmylife.betty.base.modularization.config.ModuleBundle;
import com.wxmylife.betty.base.modularization.provider.IHomeProvider;
import com.wxmylife.betty.base.modularization.router.ModuleManager;
import com.wxmylife.betty.base.modularization.router.ModuleRouter;

/**
 * Created by wxmylife on 2017/4/21.
 */

public class HomeIntent {

    private static boolean hasModule() {
        return ModuleManager.getInstance().hasModule(IHomeProvider.HOME_MAIN_SERVICE);
    }

    public static void launchHome() {
        ModuleBundle bundle=new ModuleBundle();
        // bundle.put(IHomeProvider.HOME_TABTYPE,tabType);
        ModuleRouter.newInstance(IHomeProvider.HOME_ACT_HOME)
            .withBundle(bundle)
            .navigation();
    }

    public static void launchGuide() {
        ModuleBundle bundle=new ModuleBundle();
        // bundle.put(IHomeProvider.HOME_TABTYPE,tabType);
        ModuleRouter.newInstance(IHomeProvider.HOME_ACT_GUIDE)
            .withBundle(bundle)
            .navigation();
    }
}
