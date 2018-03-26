package com.babyassistant.Json;

import com.babyassistant.Response.InfoResponse;
import com.babyassistant.Response.MessageResponse;
import com.babyassistant.Response.PromoResponse;
import com.google.gson.Gson;

public class JSONUtils {

    public static InfoResponse InfoResponse(String data)
    {
        if (data.contains("data"))
        {
            return new Gson().fromJson(data, InfoResponse.class);
        }
        return new InfoResponse();
    }

    public static PromoResponse PromoResponse(String data)
    {
        if (data.contains("data"))
        {
            return new Gson().fromJson(data, PromoResponse.class);
        }
        return new PromoResponse();
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
