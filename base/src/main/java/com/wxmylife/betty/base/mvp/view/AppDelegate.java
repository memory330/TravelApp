package com.wxmylife.betty.base.mvp.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by wxmylife on 2017/4/26.
 * 视图层基类
 */

public abstract class AppDelegate implements IDelegate{

    protected final SparseArray<View> mViews=new SparseArray<>();

    protected View rootView;

    public abstract int getRootLayoutId();


    @Override
    public void onCreate(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int rootLayoutId=getRootLayoutId();
        rootView=inflater.inflate(rootLayoutId,container,false);
    }


    @Override public int getOptionsMenuId() {
        return 0;
    }


    @Override public Toolbar getToolbar() {
        return null;
    }


    @Override public View getRootView() {
        return rootView;
    }


    public void setRootView(View rootView) {
        this.rootView = rootView;
    }


    @Override public void initWidget() {

    }

    public <T extends View> T bindView(int id) {
        T view = (T) mViews.get(id);
        if (view == null) {
            view = (T) rootView.findViewById(id);
            mViews.put(id, view);
        }
        return view;
    }

    public <T extends View> T get(int id) {
        return (T) bindView(id);
    }


    public void setOnClickListener(View.OnClickListener listener, int... ids) {
        if (ids == null) {
            return;
        }
        for (int id : ids) {
            get(id).setOnClickListener(listener);
        }
    }

    public <T extends Activity> T getActivity() {
        return (T) rootView.getContext();
    }
}
