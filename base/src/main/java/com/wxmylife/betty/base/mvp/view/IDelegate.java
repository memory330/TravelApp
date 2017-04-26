package com.wxmylife.betty.base.mvp.view;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by wxmylife on 2017/4/26.
 *
 * 视图层接口
 */

public interface IDelegate {

    void onCreate(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    int getOptionsMenuId();

    Toolbar getToolbar();

    View getRootView();

    void initWidget();

}
