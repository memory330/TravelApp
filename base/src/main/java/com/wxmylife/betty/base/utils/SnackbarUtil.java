package com.wxmylife.betty.base.utils;

import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by wxmylife on 2017/4/25.
 */

public class SnackbarUtil {

    public static void showMessage(View view, String text) {

        Snackbar.make(view, text, Snackbar.LENGTH_SHORT).show();
    }

}
