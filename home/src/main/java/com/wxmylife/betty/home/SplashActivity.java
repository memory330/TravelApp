package com.wxmylife.betty.home;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.wxmylife.betty.base.modularization.module.home.HomeIntent;
import com.wxmylife.betty.base.modularization.provider.IHomeProvider;
import com.wxmylife.betty.base.utils.ConstantUtil;
import com.wxmylife.betty.base.utils.PreferenceUtil;
import com.wxmylife.betty.base.utils.SystemUiVisibilityUtil;

/**
 * Created by wxmylife on 2017/4/25.
 */
@Route(path = IHomeProvider.HOME_ACT_SPLASH)
public class SplashActivity extends AppCompatActivity {

    private Unbinder bind;

    private Handler mHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        bind = ButterKnife.bind(this);
        mHandler = new Handler(getMainLooper());
        SystemUiVisibilityUtil.hideStatusBar(getWindow(), true);
        setUpSplash();
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
        bind.unbind();
    }
}
