package com.wxmylife.betty.base.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by wxmylife on 2017/4/20.
 */

public abstract class BaseActivity extends AppCompatActivity {



    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置布局内容
        setContentView(getLayoutId());
        //初始化黄油刀控件绑定框架
        //初始化控件
        initViews(savedInstanceState);
        //初始化ToolBar
        initToolBar();
    }




    public abstract int getLayoutId();

    public abstract void initViews(Bundle savedInstanceState);

    public abstract void initToolBar();


    public void loadData() {}


    public void showProgressBar() {}


    public void hideProgressBar() {}


    public void initRecyclerView() {}


    public void initRefreshLayout() {}


    @Override
    protected void onDestroy() {

        super.onDestroy();
    }
}
