package com.example.warehouse.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.warehouse.R;

public class MainActivity extends AppCompatActivity {

    Button button_client, button_manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_client = findViewById(R.id.client_btn);
        button_manager = findViewById(R.id.manager_btn);

        button_client.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_client = new Intent(MainActivity.this, UserLoginActivity.class);
                startActivity(intent_client);
            }
        });

        button_manager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ManagerHomeActivity.class);
                startActivity(intent);
            }
        });
    }
}