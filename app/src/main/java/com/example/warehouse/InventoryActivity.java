package com.example.warehouse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

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
            "Warehouse Names",
            "Warehouse Names",
            "Warehouse Names",
            "Warehouse Names",
            "Warehouse Names",
            "Warehouse Names",
            "Warehouse Names",
            "Warehouse Names",
            "Warehouse Names",
    };

    String[] warehouses = {
            "WarehouseDetails",
            "WarehouseDetails",
            "WarehouseDetails",
            "WarehouseDetails",
            "WarehouseDetails",
            "WarehouseDetails",
            "WarehouseDetails",
            "WarehouseDetails",
            "WarehouseDetails",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);

        recyclerView = findViewById(R.id.recycler_view_inventory);
        recyclerView.setHasFixedSize(false);

        LinearLayoutManager layoutManager = new LinearLayoutManager(InventoryActivity.this);
        inventoryAdapter = new InventoryAdapter(this, images, names, warehouses);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(inventoryAdapter);
    }
}