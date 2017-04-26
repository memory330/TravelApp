package com.wxmylife.betty.base.view.splash;

import android.content.Context;
import android.graphics.Color;

/**
 * Created by wxmylife on 2017/4/26.
 */

public class ContentView extends android.support.v7.widget.AppCompatImageView {

    public ContentView(Context context){
        super(context);
        initialize();
    }

    private void initialize(){
        // set the dummy content image
        // setImageResource(R.drawable.splash_shade);
        setBackgroundColor(Color.parseColor("#6EF3D6"));
    }
}
