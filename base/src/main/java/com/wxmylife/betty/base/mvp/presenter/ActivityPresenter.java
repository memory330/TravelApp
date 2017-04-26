package com.wxmylife.betty.base.mvp.presenter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import com.wxmylife.betty.base.mvp.view.IDelegate;
import com.wxmylife.betty.base.utils.LogUtil;

/**
 * Created by wxmylife on 2017/4/26.
 * Presenter层的实现基类
 */

public abstract class ActivityPresenter<T extends IDelegate> extends AppCompatActivity {

    protected T viewDelegate;


    protected abstract Class<T> getDelegateClass();


    public ActivityPresenter() {
        try {
            viewDelegate = getDelegateClass().newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException("create IDelegate error");
        } catch (IllegalAccessException e) {
            throw new RuntimeException("create IDelegate error");
        }
    }


    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewDelegate.onCreate(getLayoutInflater(),null,savedInstanceState);
        setContentView(viewDelegate.getRootView());
        initToolbar();
        viewDelegate.initWidget();
        bindEvenListener();
    }

    protected void bindEvenListener(){

    }

    protected  void initToolbar(){
        Toolbar toolbar=viewDelegate.getToolbar();
        if (toolbar!=null){
            setSupportActionBar(toolbar);
        }
    }


    @Override protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        LogUtil.e("onRestoreInstanceState");
        if (viewDelegate == null) {
            try {
                viewDelegate = getDelegateClass().newInstance();
            } catch (InstantiationException e) {
                throw new RuntimeException("create IDelegate error");
            } catch (IllegalAccessException e) {
                throw new RuntimeException("create IDelegate error");
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (viewDelegate.getOptionsMenuId() != 0) {
            getMenuInflater().inflate(viewDelegate.getOptionsMenuId(), menu);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewDelegate = null;
    }


}
