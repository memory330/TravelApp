package com.wxmylife.betty.home;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.wxmylife.betty.base.modularization.module.home.HomeIntent;
import com.wxmylife.betty.base.modularization.provider.IHomeProvider;
import com.wxmylife.betty.base.utils.ConstantUtil;
import com.wxmylife.betty.base.utils.PreferenceUtil;
import com.wxmylife.betty.base.utils.SystemUiVisibilityUtil;
import com.wxmylife.betty.base.view.splash.SplashView;
import com.wxmylife.betty.base.view.splash.WowView;

/**
 * Created by wxmylife on 2017/4/25.
 */
@Route(path = IHomeProvider.HOME_ACT_SPLASH)
public class SplashActivity extends AppCompatActivity {


    private SplashView mSplashView;
    private WowView mWowView;

    private Handler mHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        SystemUiVisibilityUtil.hideStatusBar(getWindow(), true);

        mHandler = new Handler(getMainLooper());

        mSplashView = (SplashView) findViewById(R.id.wowSplash);
        mWowView = (WowView) findViewById(R.id.wowView);
        mSplashView.startAnimate();


        mSplashView.setOnEndListener(new SplashView.OnEndListener() {
            @Override
            public void onEnd(SplashView splashView) {
                mSplashView.setVisibility(View.GONE);
                mWowView.setVisibility(View.VISIBLE);
                mWowView.startAnimate(mSplashView.getDrawingCache());
                finishTask();
            }
        });
        // setUpSplash();
    }


    private void setUpSplash() {

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finishTask();
            }
        }, 1500);
        // Observable.timer(2000, TimeUnit.MILLISECONDS)
        //     .compose(bindToLifecycle())
        //     .observeOn(AndroidSchedulers.mainThread())
        //     .subscribe(aLong -> {
        //         finishTask();
        //     });
    }


    private void finishTask() {

        boolean isFirst = PreferenceUtil.getBoolean(ConstantUtil.KEY, false);
        if (isFirst) {
            HomeIntent.launchHome();
        } else {
            HomeIntent.launchGuide();
        }

        SplashActivity.this.finish();
    }


    @Override
    protected void onDestroy() {

        super.onDestroy();
    }
}
