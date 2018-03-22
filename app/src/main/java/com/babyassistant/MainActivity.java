package com.babyassistant;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private LinearLayout ll_home, ll_dashboard, ll_notif;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    ll_home.setVisibility(View.VISIBLE);
                    ll_dashboard.setVisibility(View.GONE);
                    ll_notif.setVisibility(View.GONE);

                    return true;
                case R.id.navigation_dashboard:

                    ll_dashboard.setVisibility(View.VISIBLE);
                    ll_home.setVisibility(View.GONE);
                    ll_notif.setVisibility(View.GONE);

                    return true;
                case R.id.navigation_notifications:

                    ll_notif.setVisibility(View.VISIBLE);
                    ll_dashboard.setVisibility(View.GONE);
                    ll_home.setVisibility(View.GONE);

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        ll_home = (LinearLayout) findViewById(R.id.llHome);
        ll_dashboard = (LinearLayout) findViewById(R.id.llDashboard);
        ll_notif = (LinearLayout) findViewById(R.id.llNotif);
    }

    @Override
    protected void onResume() {
        super.onResume();

        ll_home.setVisibility(View.VISIBLE);
        ll_dashboard.setVisibility(View.GONE);
        ll_notif.setVisibility(View.GONE);
    }
}
