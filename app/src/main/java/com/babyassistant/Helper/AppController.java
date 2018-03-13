package com.babyassistant.Helper;

import android.app.Application;

public class AppController extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        FontsOverride.setDefaultFont(this, "DEFAULT", "fonts/Quicksand-Light.ttf");
        FontsOverride.setDefaultFont(this, "MONOSPACE", "fonts/Quicksand-Light.ttf");
        FontsOverride.setDefaultFont(this, "SERIF", "fonts/Quicksand-Light.ttf");
        FontsOverride.setDefaultFont(this, "SANS_SERIF", "fonts/Quicksand-Light.ttf");
    }
}