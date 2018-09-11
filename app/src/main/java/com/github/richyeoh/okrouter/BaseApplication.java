package com.github.richyeoh.okrouter;

import android.app.Application;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        changeWindowSize();
    }

    public void changeWindowSize() {
        WindowManager windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        Display defaultDisplay = windowManager.getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        displayMetrics.density = 8;
    }
}
