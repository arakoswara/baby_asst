package com.babyassistant.Helper;

import android.content.Context;
import com.babyassistant.R;

public class Token {
    private Context _context;

    public Token(Context context)
    {
        this._context = context;
    }

    public String getKeys()
    {
        String keys = _context.getResources().getString(R.string.csrf_key);
        return keys;
    }
}
