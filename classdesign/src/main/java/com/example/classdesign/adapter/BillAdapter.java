package com.example.classdesign.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.classdesign.BillActivity;
import com.example.classdesign.R;
import com.example.classdesign.entity.Database;
import com.example.classdesign.entity.Order;

import java.util.List;

public class BillAdapter extends RecyclerView.Adapter<BillAdapter.MyViewHolder> {
    private List<Order> lists;
    private BillActivity context;

    public BillAdapter(List<Order> lists, BillActivity context) {
        this.context = context;
        this.lists = lists;
    }

    @NonNull
    @Override
    public BillAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.bill, parent, false);
        return new BillAdapter.MyViewHolder(itemView);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.name.setText(lists.get(position).name);
        holder.price.setText(lists.get(position).price + "元");
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "催菜已收到，后厨正在努力", Toast.LENGTH_LONG).show();
            }
        });
        holder.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "退菜成功", Toast.LENGTH_LONG).show();
                Database.lists.remove(position);
                notifyItemRemoved(position);
                Database.sum -= lists.get(position).price;
                context.textView.setText(Database.sum + "元");
            }
        });
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView count;
        TextView price;
        Button button;
        Button button1;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            count = itemView.findViewById(R.id.count);
            price = itemView.findViewById(R.id.price);
            button = itemView.findViewById(R.id.urge);
            button1 = itemView.findViewById(R.id.drop);
        }
    }
}
