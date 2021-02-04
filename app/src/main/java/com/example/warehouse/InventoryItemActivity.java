package com.example.warehouse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class InventoryItemActivity extends AppCompatActivity {

    private TextView text_name, warehouse_name, date_put,number_items;
    private Button button_add, button_remove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory_item);

        text_name = findViewById(R.id.item_name);
        warehouse_name = findViewById(R.id.warehouse_name_item);
        date_put = findViewById(R.id.date_put);
        number_items = findViewById(R.id.number);

        button_add = findViewById(R.id.add_btn);
        button_remove = findViewById(R.id.remove_btn);

        Toolbar toolbar = findViewById(R.id.tool_bar_header);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(InventoryItemActivity.this, "Add Items to warehouse", Toast.LENGTH_SHORT).show();
                Intent intent_add = new Intent(InventoryItemActivity.this, AddItemActivity.class);
                startActivity(intent_add);
            }
        });

        button_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(InventoryItemActivity.this, "Remove Items from Warehouse", Toast.LENGTH_SHORT).show();
                Intent intent_add = new Intent(InventoryItemActivity.this, RemoveItemActivity.class);
                startActivity(intent_add);
            }
        });
    }
}