package com.example.warehouse.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.warehouse.adapter.InventoryAdapter;
import com.example.warehouse.R;

public class InventoryActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    InventoryAdapter inventoryAdapter;
    DrawerLayout drawerLayout;

    int[] images = {
            R.drawable.archive,
            R.drawable.industrial,
            R.drawable.ikea,
            R.drawable.archive,
            R.drawable.ikea,
            R.drawable.industrial,
            R.drawable.archive,
            R.drawable.industrial,
            R.drawable.ikea
    };

    String[] names = {
            "item 1",
            "item 1",
            "item 1",
            "item 1",
            "item 1",
            "item 1",
            "item 1",
            "item 1",
            "item 1"
    };

    String[] warehouses = {
            "Upper Hill",
            "Langata 1",
            "Kasarani",
            "Kasarani",
            "Kibra",
            "Westlands",
            "Bahati",
            "Rongai",
            "Kibra",
    };

    int[] number= {
            23,23,45,45,43,43,45,67, 56
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);

        Toolbar toolbar = findViewById(R.id.tool_bar_header);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        TextView mTitle = toolbar.findViewById(R.id.toolbar_title);

        recyclerView = findViewById(R.id.recycler_view_inventory);
        recyclerView.setHasFixedSize(false);

        LinearLayoutManager layoutManager = new LinearLayoutManager(InventoryActivity.this);
        inventoryAdapter = new InventoryAdapter(this, images, names, warehouses, number);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(inventoryAdapter);
    }
}