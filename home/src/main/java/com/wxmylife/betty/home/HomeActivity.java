package com.wxmylife.betty.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.wxmylife.betty.base.base.BaseActivity;
import com.wxmylife.betty.base.modularization.module.user.UserIntent;
import com.wxmylife.betty.base.modularization.provider.IHomeProvider;
import com.wxmylife.betty.base.utils.ConstantUtil;
import com.wxmylife.betty.base.utils.PreferenceUtil;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by wxmylife on 2017/4/25.
 */
@Route(path = IHomeProvider.HOME_ACT_HOME)
public class HomeActivity extends BaseActivity
    implements NavigationView.OnNavigationItemSelectedListener {

    private NavigationView _NavigationView;
    private DrawerLayout _DrawerLayout;

    private long exitTime;


    @Override public int getLayoutId() {
        return R.layout.activity_home;
    }


    @Override public void initViews(Bundle savedInstanceState) {
        initViewsId();
        //初始化Fragment
        // initFragments();
        //初始化侧滑菜单
        initNavigationView();
    }


    private void initViewsId() {
        _NavigationView= (NavigationView) findViewById(R.id.navigation_view);
        _DrawerLayout= (DrawerLayout) findViewById(R.id.drawer_layout);
    }


    private void initNavigationView() {
        _NavigationView.setNavigationItemSelectedListener(this);
        View headerView = _NavigationView.getHeaderView(0);
        CircleImageView userAvatar= (CircleImageView) headerView.findViewById(R.id.user_avatar_view);
        userAvatar.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                UserIntent.launchLogin();
            }
        });
    }


    /**
     * DrawerLayout侧滑菜单开关
     */
    public void toggleDrawer() {

        if (_DrawerLayout.isDrawerOpen(GravityCompat.START)) {
            _DrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            _DrawerLayout.openDrawer(GravityCompat.START);
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        _DrawerLayout.closeDrawer(GravityCompat.START);
        switch (item.getItemId()) {

        }
        return false;
    }


    @Override public void initToolBar() {

    }


    /**
     * 监听back键处理DrawerLayout和SearchView
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (_DrawerLayout.isDrawerOpen(_DrawerLayout.getChildAt(1))) {
                _DrawerLayout.closeDrawers();
            } else {
                // if (mHomePageFragment != null) {
                //     if (mHomePageFragment.isOpenSearchView()) {
                //         mHomePageFragment.closeSearchView();
                //     } else {
                //         exitApp();
                //     }
                // } else {
                    exitApp();
                // }
            }
        }

        return true;
    }


    /**
     * 双击退出App
     */
    private void exitApp() {

        if (System.currentTimeMillis() - exitTime > 2000) {
            // SnackbarUtil.showMessage(getr,"再按一次退出");
            exitTime = System.currentTimeMillis();
        } else {
            PreferenceUtil.remove(ConstantUtil.SWITCH_MODE_KEY);
            finish();
        }
    }


    /**
     * 解决App重启后导致Fragment重叠的问题
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //super.onSaveInstanceState(outState);
    }



}
