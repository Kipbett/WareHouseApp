package com.example.warehouse.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.warehouse.R;

public class OrdersAdaptor extends RecyclerView.Adapter<OrdersAdaptor.OrderAdaptorHolder> {

    private String[] item_name;
    private double[] item_count, item_price;
    private Context context;

    public OrdersAdaptor(Context context, String[] item_name, double[] item_count, double[] item_price) {
        this.item_name = item_name;
        this.item_count = item_count;
        this.item_price = item_price;
        this.context = context;
    }

    protected class OrderAdaptorHolder extends RecyclerView.ViewHolder{

        TextView itemName, itemCount, itemPrice;

        public OrderAdaptorHolder(@NonNull View itemView) {
            super(itemView);

            itemName = itemView.findViewById(R.id.item_name);
            itemCount = itemView.findViewById(R.id.item_count);
            itemPrice = itemView.findViewById(R.id.item_price);
        }
    }

    @NonNull
    @Override
    public OrderAdaptorHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context)
                .inflate(R.layout.order_layout, parent, false);
        OrderAdaptorHolder adaptorHolder = new OrderAdaptorHolder(v);

        return adaptorHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAdaptorHolder holder, int position) {

        holder.itemName.setText(item_name[position]);
        holder.itemCount.setText((int) item_count[position]);
        holder.itemPrice.setText((int) item_price[position]);

    }


    @Override
    public int getItemCount() {
        return item_name.length;
    }
}
