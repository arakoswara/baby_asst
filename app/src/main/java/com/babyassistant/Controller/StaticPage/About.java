package com.babyassistant.Controller.StaticPage;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.babyassistant.R;

public class About extends AppCompatActivity {

    private LinearLayout ll_facebook, ll_instagram, ll_linkedin, ll_github;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ll_facebook = (LinearLayout) findViewById(R.id.llFacebook);
        ll_instagram = (LinearLayout) findViewById(R.id.llInstagram);
        ll_linkedin = (LinearLayout) findViewById(R.id.llLinkedin);
        ll_github = (LinearLayout) findViewById(R.id.llGithub);

        ll_facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(About.this, SosialMedia.class);
                intent.putExtra("sosial_media_id", "1");
                startActivity(intent);
            }
        });

        ll_instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(About.this, SosialMedia.class);
                intent.putExtra("sosial_media_id", "2");
                startActivity(intent);
            }
        });

        ll_linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(About.this, SosialMedia.class);
                intent.putExtra("sosial_media_id", "3");
                startActivity(intent);
            }
        });

        ll_github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(About.this, SosialMedia.class);
                intent.putExtra("sosial_media_id", "4");
                startActivity(intent);
            }
        });
    }
}
