package com.babyassistant.Controller.Profile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.babyassistant.MainActivity;
import com.babyassistant.R;

public class Register extends AppCompatActivity {

    private LinearLayout ll_login;
    private EditText et_email;
    private Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ll_login = (LinearLayout) findViewById(R.id.llToLogin);
        ll_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Register.this, Login.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
