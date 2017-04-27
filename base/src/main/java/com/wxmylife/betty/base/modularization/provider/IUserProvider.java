package com.wxmylife.betty.base.modularization.provider;

/**
 * Created by wxmylife on 2017/4/27.
 */

public interface IUserProvider extends IBaseProvider{

    //Service
    String USER_MAIN_SERVICE = "/user/main/service";
    //登陆
    String USER_ACT_LOGIN = "/user/act/login";
    //组册
    String USER_ACT_REGISTER= "/user/act/register";
}
