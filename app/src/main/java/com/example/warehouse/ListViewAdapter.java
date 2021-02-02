package com.example.warehouse;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ListViewAdapter extends RecyclerView.Adapter<ListViewAdapter.ListViewHolder>{

    private OnItemClickListener mitemClickListener;

    //private ArrayList<ListItem> listItems = null;
    private int[] images;
    private String[] names;
    private String[] details;
    Context context;


    public ListViewAdapter(Context context, int[] images, String[] names, String[] details) {
        this.images = images;
        this.names = names;
        this.details = details;
        //this.listItems = listItems;
        this.context = context;
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        mitemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.raw_layout, parent, false);

        //ListViewHolder listViewHolder = new ListViewHolder(view);
        return new ListViewHolder(view, mitemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        /*ListItem listItem = listItems.get(position);
        holder.imageView.setImageResource(listItem.getImageResource());
        holder.text_name.setText(listItem.getWarehouseName());
        holder.text_details.setText(listItem.getWaregouseDetails());*/

        holder.imageView.setImageResource(images[position]);
        holder.text_name.setText(names[position]);
        holder.text_details.setText(details[position]);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, WarehouseDetailsActivity.class);
                Toast.makeText(context, "Selected a List", Toast.LENGTH_SHORT).show();
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public OnItemClickListener getItemClickListener() {
        return mitemClickListener;
    }

    public class ListViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView text_name, text_details;
        public ListViewHolder(View itemView, OnItemClickListener listener) {
            super(itemView);

            imageView = itemView.findViewById(R.id.warehouse_image);
            text_details = itemView.findViewById(R.id.warehouse_details);
            text_name = itemView.findViewById(R.id.warehouse_name);



            /*itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                            Intent intent = new Intent(context, WarehouseDetailsActivity.class);
                            context.startActivity(intent);
                        }
                    }
                }
            });*/
        }

        /*@Override
        public void onClick(View v) {
            Intent intent = new Intent(context, WarehouseDetailsActivity.class);
            context.startActivity(intent);
        }*/
    }
}
