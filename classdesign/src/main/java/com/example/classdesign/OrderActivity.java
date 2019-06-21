package com.example.classdesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.classdesign.adapter.FoodAdapter;
import com.example.classdesign.entity.Food;
import com.example.classdesign.entity.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FoodAdapter adapter;
    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        recyclerView = findViewById(R.id.act_main_recyclerview);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        adapter = new FoodAdapter(ListFoods(), OrderActivity.this);
        recyclerView.setAdapter(adapter);
        button1 = findViewById(R.id.tiaodingdan);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderActivity.this,BillActivity.class);
                startActivity(intent);
            }
        });
    }

    private List<Food> ListFoods(){
        List<Food> list = new ArrayList<>();
        for(int i=0;i<10;i++){
            Food food = new Food(i+1,"菜"+(i+1),12,"本店特色菜！");
            list.add(food);
        }
        return list;
    }
}
