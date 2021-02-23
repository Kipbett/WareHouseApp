package com.example.warehouse.ui.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.warehouse.adapter.ListViewAdapter;
import com.example.warehouse.R;
import com.example.warehouse.ui.client.WarehouseDetailsActivity;

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
                "Warehouse One",
                "Warehouse Two",
                "Warehouse Three",
                "Warehouse Four",
                "Warehouse Five",
                "Warehouse Six",
                "Warehouse Seven",
                "Warehouse Eight",
                "Warehouse Nine",
        };

        String[] details = {
                "Warehouse Loation 1",
                "Warehouse Loation 2",
                "Warehouse Loation 3",
                "Warehouse Loation 4",
                "Warehouse Loation 5",
                "Warehouse Loation 6",
                "Warehouse Loation 7",
                "Warehouse Loation 8",
                "Warehouse Loation 9",
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