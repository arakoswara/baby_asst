package com.babyassistant;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.babyassistant.Adapter.ViewPageAdapter;
import com.babyassistant.Controller.StaticPage.About;
import com.babyassistant.Helper.Constants;
import com.babyassistant.Helper.Token;
import com.babyassistant.Json.JSONUtils;
import com.babyassistant.Response.InfoResponse;
import com.babyassistant.Response.MessageResponse;
import com.babyassistant.Response.PromoResponse;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    private LinearLayout ll_home, ll_dashboard, ll_notif, ll_about;
    private InfoResponse infoGiziResponse;
    private MessageResponse messageResponse;
    private PromoResponse promoResponse;
    private ViewPager mViewPager;
    private ViewPageAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(myToolbar);

        get_promo_banner();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        ll_home = (LinearLayout) findViewById(R.id.llHome);
        ll_dashboard = (LinearLayout) findViewById(R.id.llDashboard);
        ll_notif = (LinearLayout) findViewById(R.id.llNotif);
        ll_about = (LinearLayout) findViewById(R.id.llAbout);

        /*
        * About
         */
        ll_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, About.class);
                startActivity(intent);
            }
        });
    }

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
    protected void onResume() {
        super.onResume();

        ll_home.setVisibility(View.VISIBLE);
        ll_dashboard.setVisibility(View.GONE);
        ll_notif.setVisibility(View.GONE);
    }

    private void get_info_gizi()
    {
        StringRequest sr = new StringRequest(Request.Method.POST, Constants.INFOGIZI,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response)
                    {
                        Log.d("response ", response);
                        if (!response.contains("message"))
                        {
                            infoGiziResponse = JSONUtils.InfoResponse(response);
                            for (int i = 0; i < infoGiziResponse.data.size(); i++)
                            {
                                Log.d("title ", infoGiziResponse.data.get(i).title);
                            }
                        }
                        else
                        {
                            messageResponse = JSONUtils.MessageResponse(response);
                            Toast.makeText(getApplicationContext(), messageResponse.message, Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("error ", error.getMessage()+"~");
                    }
                })
        {
            @Override
            protected  Map<String, String> getParams()
            {
                Map<String, String> param = new HashMap<String, String>();
                Token token = new Token(getBaseContext());
                param.put("token", token.getKeys());

                return param;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/x-www-form-urlencoded");
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(sr);
    }

    private void get_info_penyakit()
    {
        StringRequest sr = new StringRequest(Request.Method.POST, Constants.INFOPENYAKIT,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response)
                    {
                        Log.d("response ", response);
                        if (!response.contains("message"))
                        {
                            infoGiziResponse = JSONUtils.InfoResponse(response);
                            for (int i = 0; i < infoGiziResponse.data.size(); i++)
                            {
                                Log.d("title ", infoGiziResponse.data.get(i).title);
                            }
                        }
                        else
                        {
                            messageResponse = JSONUtils.MessageResponse(response);
                            Toast.makeText(getApplicationContext(), messageResponse.message, Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("error ", error.getMessage());
                    }
                })
        {
            @Override
            protected  Map<String, String> getParams()
            {
                Map<String, String> param = new HashMap<String, String>();
                Token token = new Token(getBaseContext());
                param.put("token", token.getKeys());

                return param;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/x-www-form-urlencoded");
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(sr);
    }

    private void get_promo_banner()
    {
        StringRequest sr = new StringRequest(Request.Method.GET, Constants.GETPROMO,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response)
                    {
                        Log.d("response_promo ", response);
                        if (!response.contains("message"))
                        {
                            promoResponse = JSONUtils.PromoResponse(response);

                            for (int i = 0; i < promoResponse.data.size(); i++)
                            {
                                setPromo();
                            }

                            get_info_gizi();
                            get_info_penyakit();
                        }
                        else
                        {
                            messageResponse = JSONUtils.MessageResponse(response);
                            Toast.makeText(getApplicationContext(), messageResponse.message, Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("error ", error.getMessage());
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(sr);
    }

    private void setPromo()
    {
        mViewPager = (ViewPager) findViewById(R.id.pager_promo);
        mAdapter = new ViewPageAdapter(MainActivity.this, promoResponse.data);
        mViewPager.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

        mViewPager.setCurrentItem(0);
        mViewPager.addOnPageChangeListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()) {
            case R.id.action_home:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_home, menu);
        return true;
    }



    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
