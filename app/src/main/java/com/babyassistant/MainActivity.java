package com.babyassistant;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.babyassistant.Helper.Constants;
import com.babyassistant.Helper.Token;
import com.babyassistant.Json.JSONUtils;
import com.babyassistant.Response.InfoGiziResponse;
import com.babyassistant.Response.MessageResponse;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private LinearLayout ll_home, ll_dashboard, ll_notif;
    private InfoGiziResponse infoGiziResponse;
    private MessageResponse messageResponse;

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

        get_info_gizi();

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
                            infoGiziResponse = JSONUtils.InfoGiziResponse(response);
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
                param.put("_token", token.getKeys());

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
                            infoGiziResponse = JSONUtils.InfoGiziResponse(response);
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
                param.put("_token", token.getKeys());

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
}
