package com.babyassistant;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.squareup.picasso.Picasso;

public class SplashScreen extends AppCompatActivity {

    private ImageView logo;
    int progressBarStatus = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // set logo
        logo = (ImageView)findViewById(R.id.logo_splash_screen);
        Picasso.with(this).load(R.drawable.logo).into(logo);

        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.downloadBar);
        progressBar.setProgress(0);
        progressBar.setMax(100);

        final Handler progressBarHandler = new Handler();

        new Thread(new Runnable() {
            public void run() {
                while (progressBarStatus < 100) {
                    progressBarStatus = progressBarStatus+10;

                    try {
                        Thread.sleep(1000);
                    }
                        catch (InterruptedException e) {e.printStackTrace();
                    }

                    progressBarHandler.post(new Runnable() {
                        public void run() {
                            progressBar.setProgress(progressBarStatus);
                        }
                    });
                }

                if (progressBarStatus == 100)
                {
                    Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }).start();
    }
}
