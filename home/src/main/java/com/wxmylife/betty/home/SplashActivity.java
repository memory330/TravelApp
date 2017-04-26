package com.wxmylife.betty.home;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.wxmylife.betty.base.modularization.module.home.HomeIntent;
import com.wxmylife.betty.base.modularization.provider.IHomeProvider;
import com.wxmylife.betty.base.utils.ConstantUtil;
import com.wxmylife.betty.base.utils.LogUtil;
import com.wxmylife.betty.base.utils.PreferenceUtil;
import com.wxmylife.betty.base.utils.SystemUiVisibilityUtil;
import com.wxmylife.betty.base.view.splash.ContentView;
import com.wxmylife.betty.base.view.splash.SplashView;

/**
 * Created by wxmylife on 2017/4/25.
 */
@Route(path = IHomeProvider.HOME_ACT_SPLASH)
public class SplashActivity extends AppCompatActivity {

    private static final boolean DO_XML = false;

    private ViewGroup mMainView;
    private SplashView mSplashView;
    private View mContentView;
    private Handler mHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_splash);
        SystemUiVisibilityUtil.hideStatusBar(getWindow(), true);

        mHandler = new Handler(getMainLooper());

        if (DO_XML) {
            // inflate the view from XML and then get a reference to it
            setContentView(R.layout.activity_splash);
            mMainView = (ViewGroup) findViewById(R.id.main_view);
            mSplashView = (SplashView) findViewById(R.id.splash_view);
        } else {
            // create the main view
            mMainView = new FrameLayout(getApplicationContext());

            // create the splash view
            mSplashView = new SplashView(getApplicationContext());
            mSplashView.setRemoveFromParentOnEnd(
                true); // remove the SplashView from MainView once animation is completed
            mSplashView.setSplashBackgroundColor(
                getResources().getColor(R.color.splash_bg)); // the background color of the view
            mSplashView.setRotationRadius(getResources().getDimensionPixelOffset(
                R.dimen.splash_rotation_radius)); // radius of the big circle that the little circles will rotate on
            mSplashView.setCircleRadius(getResources().getDimensionPixelSize(
                R.dimen.splash_circle_radius)); // radius of each circle
            mSplashView.setRotationDuration(getResources().getInteger(
                R.integer.splash_rotation_duration)); // time for one rotation to be completed by the small circles
            mSplashView.setSplashDuration(getResources().getInteger(
                R.integer.splash_duration)); // total time taken for the circles to merge together and disappear
            mSplashView.setCircleColors(getResources().getIntArray(
                R.array.splash_circle_colors)); // the colors of each circle in order

            // add splash view to the parent view
            mMainView.addView(mSplashView);
            setContentView(mMainView);
        }
        startLoadingData();
    }


    private void startLoadingData() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                onLoadingDataEnded();
            }
        }, 1500);
    }


    private void onLoadingDataEnded() {
        Context context = getApplicationContext();
        // now that our data is loaded we can initialize the content view
        mContentView = new ContentView(context);
        // add the content view to the background
        mMainView.addView(mContentView, 0);

        // start the splash animation
        mSplashView.splashAndDisappear(new SplashView.ISplashListener() {
            @Override
            public void onStart() {
                // log the animation start event

            }


            @Override
            public void onUpdate(float completionFraction) {
                // log animation update events
                if (BuildConfig.DEBUG) {
                    LogUtil.e(
                        "splash at " + String.format("%.2f", (completionFraction * 100)) + "%");
                }
            }


            @Override
            public void onEnd() {
                // log the animation end event
                if (BuildConfig.DEBUG) {
                    LogUtil.e("splash ended");
                }
                finishTask();
                // free the view so that it turns into garbage
                mSplashView = null;
            }
        });

    }


    private void finishTask() {
        boolean isFirst = PreferenceUtil.getBoolean(ConstantUtil.KEY, true);
        if (isFirst) {
            HomeIntent.launchGuide();
        } else {
            HomeIntent.launchHome();
        }

        SplashActivity.this.finish();
    }


    @Override
    protected void onDestroy() {
        mHandler = null;
        super.onDestroy();
    }
}
