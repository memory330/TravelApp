package com.wxmylife.betty.base.modularization.provider;

import android.support.v4.app.Fragment;

/**
 * Created by wxmylife on 2017/4/21.
 */

public interface IFragmentProvider extends IBaseProvider {

    Fragment newInstance(Object... args);
}
