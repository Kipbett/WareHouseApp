package com.example.warehouse.ui.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.warehouse.R;
import com.example.warehouse.adapter.OrdersAdaptor;

public class OrdersActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private OrdersAdaptor ordersAdaptor;

    String[] item_name = {
            "item 1",
            "item 2",
            "item 3",
            "item 4",
            "item 5",
    };
    double[] item_price = {
            1000,
            2000,
            3150,
            3200,
            4500,
    };
    double[] item_count = {
            20,
            34,
            45,
            45,
            56,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);

        Toolbar toolbar = findViewById(R.id.tool_bar_header_order);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        TextView order_title = toolbar.findViewById(R.id.toolbar_title_order);

        recyclerView = findViewById(R.id.recycler_view_orders);
        recyclerView.setHasFixedSize(false);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(OrdersActivity.this);
        ordersAdaptor = new OrdersAdaptor(this, item_name, item_price, item_count);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(ordersAdaptor);

    }
}