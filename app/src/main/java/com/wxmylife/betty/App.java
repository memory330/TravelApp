package com.wxmylife.betty;

import com.alibaba.android.arouter.launcher.ARouter;
import com.wxmylife.betty.base.base.BaseApplication;
import com.wxmylife.betty.base.modularization.config.ModuleOptions;
import com.wxmylife.betty.base.modularization.provider.IHomeProvider;
import com.wxmylife.betty.base.modularization.router.ModuleManager;

/**
 * Created by wxmylife on 2017/4/25.
 */

public class App extends BaseApplication {

    @Override public void onCreate() {
        super.onCreate();
        initARouter();
    }


    private void initARouter() {
            ARouter.openLog();
            ARouter.openDebug();
            ARouter.printStackTrace();
        ARouter.init(this);
        ModuleOptions.ModuleBuilder builder=new ModuleOptions.ModuleBuilder(this)
            .addModule(IHomeProvider.HOME_MAIN_SERVICE,IHomeProvider.HOME_MAIN_SERVICE);

        ModuleManager.getInstance().init(builder.build());
    }
}
