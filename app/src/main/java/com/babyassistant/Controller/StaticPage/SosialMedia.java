package com.babyassistant.Controller.StaticPage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.babyassistant.R;

public class SosialMedia extends AppCompatActivity {

    private WebView webView;
    private String sosial_media_id = "", url = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sosial_media);

        Intent intent = getIntent();
        webView = (WebView) findViewById(R.id.wvSosMed);

        sosial_media_id = intent.getStringExtra("sosial_media_id");
        if (sosial_media_id.equals("1"))
        {
            url = "https://www.facebook.com/araksr";
        }
        else if(sosial_media_id.equals("2"))
        {
            url = "https://www.instagram.com/_arakoswara_/";
        }
        else if(sosial_media_id.equals("3"))
        {
            url = "https://www.linkedin.com/in/ara-koswara-a4781597/";
        }
        else if(sosial_media_id.equals("4"))
        {
            url = "https://github.com/arakoswara";
        }

        webView.loadUrl(url);
    }
}
