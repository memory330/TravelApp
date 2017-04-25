package com.wxmylife.betty.base.modularization.module.app;

import com.wxmylife.betty.base.modularization.provider.IAppProvider;
import com.wxmylife.betty.base.modularization.router.ModuleManager;

/**
 * Created by wxmylife on 2017/4/21.
 */

public class AppService {

    private static boolean hasModule(){
        return ModuleManager.getInstance().hasModule(IAppProvider.APP_MAIN_SERVICE);
    }
}
