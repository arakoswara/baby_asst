package com.babyassistant.Response;

import java.util.List;

public class PromoResponse {
    public Integer code;
    public Boolean error;
    public List<Datum> data = null;

    public class Datum {
        public Integer id;
        public String title;
        public String description;
        public Integer status;
        public String image;
        public String image_url;
        public Object created_at;
        public Object updated_at;

    }
}
