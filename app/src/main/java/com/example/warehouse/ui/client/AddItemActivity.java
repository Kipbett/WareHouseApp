package com.example.warehouse.ui.client;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.warehouse.R;

public class AddItemActivity extends AppCompatActivity {

    private EditText number;
    private Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        Toolbar toolbar = findViewById(R.id.tool_bar_header);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        number = findViewById(R.id.number_add);
        add_button = findViewById(R.id.add_btn);

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddItemActivity.this, "Added Item", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
