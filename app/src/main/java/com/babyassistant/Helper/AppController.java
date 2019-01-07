package com.babyassistant.Helper;

import android.app.Application;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class AppController extends Application {

    private static AppController mInstance;
    private RequestQueue mRequestQueue;
    public static final String TAG = AppController.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();

        FontsOverride.setDefaultFont(this, "DEFAULT", "fonts/Quicksand-Light.ttf");
        FontsOverride.setDefaultFont(this, "MONOSPACE", "fonts/Quicksand-Light.ttf");
        FontsOverride.setDefaultFont(this, "SERIF", "fonts/Quicksand-Light.ttf");
        FontsOverride.setDefaultFont(this, "SANS_SERIF", "fonts/Quicksand-Light.ttf");
    }

    public static synchronized AppController getInstance()
    {
        return mInstance;
    }

    public RequestQueue getRequestQueue()
    {
        if (mRequestQueue == null)
        {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req)
    {
        req.setTag(TAG);
        req.setRetryPolicy(new DefaultRetryPolicy(
                60 * 10 * 1000, 0,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        getRequestQueue().add(req);
    }
}