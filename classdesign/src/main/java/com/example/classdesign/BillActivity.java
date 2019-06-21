package com.example.classdesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.classdesign.adapter.BillAdapter;
import com.example.classdesign.entity.Database;

public class BillActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private BillAdapter adapter;
    public TextView textView;
    private Button button;
    private Button button1;
    private TextView no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);
        recyclerView = findViewById(R.id.bill);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        adapter = new BillAdapter(Database.lists, BillActivity.this);
        recyclerView.setAdapter(adapter);
        button = findViewById(R.id.settle);
        textView = findViewById(R.id.total);
        no = findViewById(R.id.no);

        no.setText(Database.tableName + "号桌");

        textView.setText(Database.sum + "元");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BillActivity.this, SettleActivity.class);
                startActivity(intent);
            }
        });
    }
}
