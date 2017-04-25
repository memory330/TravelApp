package com.wxmylife.betty.base.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import java.lang.reflect.Field;

/**
 * Created by wxmylife on 2017/4/20.
 */

public abstract class BaseFragment extends Fragment {

    private static final String TAG = BaseFragment.class.getSimpleName();

    private View mRootView;

    private FragmentActivity activity;

    protected boolean isPrepared;

    protected boolean isVisible;


    private Unbinder bind;

    public abstract
    @LayoutRes
    int getLayoutResId();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle state) {
        mRootView = inflater.inflate(getLayoutResId(), container, false);
        activity = getSupportActivity();
        return mRootView;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        bind = ButterKnife.bind(this, view);
        finishCreateView(savedInstanceState);
    }


    public abstract void finishCreateView(Bundle state);

    protected abstract View getContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);


    @Override
    public void onResume() {

        super.onResume();
    }




    @Override
    public void onAttach(Activity activity) {

        super.onAttach(activity);
        this.activity = (FragmentActivity) activity;
    }


    @Override
    public void onDetach() {

        super.onDetach();
        this.activity = null;
    }


    public FragmentActivity getSupportActivity() {

        return super.getActivity();
    }


    public android.app.ActionBar getSupportActionBar() {

        return getSupportActivity().getActionBar();
    }


    public Context getApplicationContext() {

        return this.activity == null
               ? (getActivity() == null ? null :
                  getActivity().getApplicationContext())
               : this.activity.getApplicationContext();
    }


    @Override public void onDestroyView() {
        super.onDestroyView();
        bind.unbind();
        try {
            Field childFragmentManager = Fragment.class.getDeclaredField("mChildFragmentManager");
            childFragmentManager.setAccessible(true);
            childFragmentManager.set(this, null);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Fragment数据的懒加载
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {

        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }


    protected void onVisible() {

        lazyLoad();
    }


    protected void lazyLoad() {}


    protected void onInvisible() {}


    protected void loadData() {}


    protected void showProgressBar() {}


    protected void hideProgressBar() {}


    protected void initRecyclerView() {}


    protected void initRefreshLayout() {}


    protected void finishTask() {}


    @SuppressWarnings("unchecked")
    public <T extends View> T $(int id) {

        return (T) mRootView.findViewById(id);
    }
}