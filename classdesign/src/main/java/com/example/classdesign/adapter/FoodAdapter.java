package com.example.classdesign.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.classdesign.DetailActivity;
import com.example.classdesign.OrderActivity;
import com.example.classdesign.R;
import com.example.classdesign.entity.Database;
import com.example.classdesign.entity.Food;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.MyViewHolder>{
    private List<Food> foods;
    private OrderActivity context;
    public FoodAdapter(List<Food> foods, OrderActivity context){
        this.foods = foods;
        this.context = context;
    }

    @NonNull
    @Override
    public FoodAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.order, parent, false);
        return new FoodAdapter.MyViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return foods.size();
    }

    @Override
    public void onBindViewHolder(@NonNull FoodAdapter.MyViewHolder holder, final int position) {
        holder.title.setText(foods.get(position).name);
        holder.suttitle.setText("价格:"+foods.get(position).price+"元");
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,foods.get(position).name,Toast.LENGTH_SHORT).show();
                Database.orderLists(foods.get(position).name,foods.get(position).price);
            }
        });
        holder.pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(context, DetailActivity.class);
               Database.content = foods.get(position).content;
               context.startActivity(intent);
            }
        });
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView suttitle;
        ImageButton pic;
        Button button;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.news_title);
            suttitle = itemView.findViewById(R.id.news_subtitle);
            pic =itemView.findViewById(R.id.news_pic);
            button = itemView.findViewById(R.id.tianjia);
        }
    }

}
