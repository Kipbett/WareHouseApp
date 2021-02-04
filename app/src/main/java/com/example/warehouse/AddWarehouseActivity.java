package com.example.warehouse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;

public class AddWarehouseActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ListViewAdapter listViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_warehouse);
        //ListItem listItem = new ListItem(R.drawable.archive, "First Warehouse", "The Nearest One");

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

        String[] details = {
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

        /*List<ListItem> listItems = new ArrayList<>();
        listItems.add(new ListItem(R.drawable.archive, "First Warehouse", "The Nearest One"));
        listItems.add(new ListItem(R.drawable.ikea, "Second Warehouse", "The Nearest One"));
        listItems.add(new ListItem(R.drawable.industrial, "Third Warehouse", "The Nearest One"));
        listItems.add(new ListItem(R.drawable.archive, "Fourth Warehouse", "The Nearest One"));
        listItems.add(new ListItem(R.drawable.industrial, "Fifth Warehouse", "The Nearest One"));
        listItems.add(new ListItem(R.drawable.ikea, "Sixth Warehouse", "The Nearest One"));
        listItems.add(new ListItem(R.drawable.archive, "Seventh Warehouse", "The Nearest One"));*/

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(false);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(AddWarehouseActivity.this);
        listViewAdapter = new ListViewAdapter(this, images, names, details);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(listViewAdapter);

        listViewAdapter.setOnItemClickListener(new ListViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(AddWarehouseActivity.this, WarehouseDetailsActivity.class);
                startActivity(intent);
            }
        });

    }
}