package com.example.warehouse;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class InventoryAdapter extends RecyclerView.Adapter<InventoryAdapter.InventoryAdapterHolder> {

    private int[] images;
    private String[] names;
    private String[] warehouses;
    Context context;

    public InventoryAdapter(Context context, int[] images, String[] names, String[] warehouses) {
        this.images = images;
        this.names = names;
        this.warehouses = warehouses;
        this.context = context;
    }

    @NonNull
    @Override
    public InventoryAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.raw_layout, parent, false);
        InventoryAdapterHolder adapterHolder = new InventoryAdapterHolder(view);
        return adapterHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull InventoryAdapterHolder holder, int position) {

        holder.imageView.setImageResource(images[position]);
        holder.name.setText(names[position]);
        holder.warehouse.setText(warehouses[position]);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, InventoryItemActivity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return names.length;
    }

    public class InventoryAdapterHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name, warehouse;
        public InventoryAdapterHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.warehouse_image);
            name = itemView.findViewById(R.id.warehouse_name);
            warehouse = itemView.findViewById(R.id.warehouse_details);
        }
    }
}
