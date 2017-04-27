package com.wxmylife.betty.base.modularization.router;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.launcher.ARouter;
import com.wxmylife.betty.base.modularization.provider.IHomeProvider;
import com.wxmylife.betty.base.modularization.provider.IUserProvider;

/**
 * Created by wxmylife on 2017/4/21.
 */

public class ServiceManager {
    //自动注入
    @Autowired
    IHomeProvider homeProvider;

    @Autowired
    IUserProvider userProvider;
    //可以不使用@Autowired，手动发现服务
    // IModule1Provider module1Provider;
    // IModule2Provider module2Provider;
    // IModule3Provider module3Provider;



    public ServiceManager() {
        ARouter.getInstance().inject(this);
    }

    private static final class ServiceManagerHolder {
        private static final ServiceManager instance = new ServiceManager();
    }

    public static ServiceManager getInstance() {
        return ServiceManagerHolder.instance;
    }


    public IHomeProvider getHomeProvider() {
        return homeProvider;
    }


    public IUserProvider getUserProvider() {
        return userProvider;
    }
}
