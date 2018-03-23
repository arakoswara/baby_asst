package com.babyassistant.Json;

import com.babyassistant.Response.InfoGiziResponse;
import com.babyassistant.Response.MessageResponse;
import com.google.gson.Gson;

public class JSONUtils {

    public static InfoGiziResponse InfoGiziResponse(String data)
    {
        if (data.contains("data"))
        {
            return new Gson().fromJson(data, InfoGiziResponse.class);
        }
        return new InfoGiziResponse();
    }

    public static MessageResponse MessageResponse(String data)
    {
        if (data.contains("message"))
        {
            return new Gson().fromJson(data, MessageResponse.class);
        }
        return new MessageResponse();
    }
}
