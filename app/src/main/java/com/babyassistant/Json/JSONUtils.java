package com.babyassistant.Json;

import com.babyassistant.Response.InfoGiziResponse;
import com.google.gson.Gson;

public class JSONUtils {

    public static InfoGiziResponse InfoGiziResponse(String data)
    {
        if (data.equals(""))
        {
            return new Gson().fromJson(data, InfoGiziResponse.class);
        }
        return new InfoGiziResponse();
    }
}
