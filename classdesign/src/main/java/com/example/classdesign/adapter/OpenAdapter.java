package com.example.classdesign.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.classdesign.OpenActivity;
import com.example.classdesign.R;
import com.example.classdesign.entity.Database;
import com.example.classdesign.entity.Table;

import java.util.List;

public class OpenAdapter extends RecyclerView.Adapter<OpenAdapter.MyViewHolder>{

    private List<Table> tables;
    private OpenActivity context;

    public OpenAdapter(List<Table> tables, OpenActivity context){
        this.tables = tables;
        this.context = context;
    }

    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.table, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        holder.title.setText(tables.get(position).no+"号桌");
        holder.button.setText("开台");
        holder.pic.setImageResource(R.drawable.table);
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Database.tableName=position+1+"";
                if(holder.button.getText().equals("开台")){
                    holder.button.setText("关台");
                    holder.button.setTextColor(Color.RED);
                    Toast.makeText(context,(position+1)+"号桌开台成功",Toast.LENGTH_LONG).show();
                }else {
                    holder.button.setText("开台");
                    holder.button.setTextColor(Color.parseColor("#3399FF"));
                    Toast.makeText(context,tables.get(position).no+"号桌退台成功",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return tables.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView pic;
        Button button;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.news_title);
            pic = itemView.findViewById(R.id.table_pic);
            button = itemView.findViewById(R.id.open);
        }
    }
}
