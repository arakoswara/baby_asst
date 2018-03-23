package com.babyassistant.Response;

import java.util.List;

public class InfoGiziResponse {
    public Integer code;
    public Boolean error;
    public List<Datum> data = null;

    public class Datum {
        public Integer id;
        public String title;
        public String description;
        public Object createdAt;
        public Object updatedAt;
        public Integer status;
    }
}
