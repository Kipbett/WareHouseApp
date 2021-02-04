package com.example.warehouse.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.warehouse.adapter.InventoryAdapter;
import com.example.warehouse.R;
import com.google.android.material.navigation.NavigationView;

public class ClientHomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    RecyclerView recyclerView;
    InventoryAdapter inventoryAdapter;

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
        setContentView(R.layout.activity_client_home);

        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null){
            //getSupportFragmentManager().beginTransaction().replace(R.id.fragmenr_container, new WareHouses()).commit();
            Intent intent = new Intent(ClientHomeActivity.this, InventoryActivity.class);
            //startActivity(intent);
            navigationView.setCheckedItem(R.id.find_ware_house);
        }

        recyclerView = findViewById(R.id.recycler_view_inventory);
        recyclerView.setHasFixedSize(false);

        LinearLayoutManager layoutManager = new LinearLayoutManager(ClientHomeActivity.this);
        inventoryAdapter = new InventoryAdapter(this, images, names, warehouses);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(inventoryAdapter);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.find_ware_house:
                //getSupportFragmentManager().beginTransaction().replace(R.id.fragmenr_container, new WareHouses()).commit();
                Intent intent = new Intent(ClientHomeActivity.this, MapsActivity.class);
                startActivity(intent);
                break;

            case R.id.add_warehouses:
                Intent ware_intent = new Intent(ClientHomeActivity.this, AddWarehouseActivity.class);
                startActivity(ware_intent);
                break;

            case R.id.inventory:
                Intent intent_inventory = new Intent(ClientHomeActivity.this, InventoryActivity.class);
                startActivity(intent_inventory);
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        } else{
            super.onBackPressed();
        }

    }
}