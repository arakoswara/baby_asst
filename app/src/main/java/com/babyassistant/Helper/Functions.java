package com.babyassistant.Helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;

import com.babyassistant.R;

public class Functions {
    public static Context mContext;
    public static Typeface AppsFont;

    public static void AssignGlobalVariables(Context context) {

    }

    public static void setPreferences(Context context, String key, String value) {
        SharedPreferences.Editor editor = context.getSharedPreferences(context.getResources().getString(R.string.app_name), context.MODE_PRIVATE).edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static String getPreferences(Context context, String key)
    {
        SharedPreferences prefs = context.getSharedPreferences(context.getResources().getString(R.string.app_name), context.MODE_PRIVATE);
        return prefs.getString(key,null);
    }
}
