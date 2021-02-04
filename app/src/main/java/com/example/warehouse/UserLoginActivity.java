package com.example.warehouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserLoginActivity extends AppCompatActivity {

    Button btn_login;
    TextView text_reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        text_reg = findViewById(R.id.register_text);
        btn_login = findViewById(R.id.button_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserLoginActivity.this, ClientHomeActivity.class);
                startActivity(intent);
            }
        });

        text_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reg_intent = new Intent(UserLoginActivity.this, RegistrationActivity.class);
                startActivity(reg_intent);
            }
        });
    }
}