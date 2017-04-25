package com.wxmylife.betty.base.modularization.module.home;

import android.app.Activity;
import com.wxmylife.betty.base.modularization.provider.IHomeProvider;
import com.wxmylife.betty.base.modularization.router.ModuleManager;

/**
 * Created by wxmylife on 2017/4/21.
 */

public class HomeService {

    private static boolean hasModule() {
        return ModuleManager.getInstance().hasModule(IHomeProvider.HOME_MAIN_SERVICE);
    }


    public static void selectedTab(Activity activity, int position) {
        if (!hasModule()) return;
        // ServiceManager.getInstance().getHomeProvider().selectedTab(activity, position);
    }
}
