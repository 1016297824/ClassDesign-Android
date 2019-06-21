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

import com.example.classdesign.adapter.OpenAdapter;
import com.example.classdesign.entity.Table;

import java.util.ArrayList;
import java.util.List;

public class OpenActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private OpenAdapter kaiAdapter;
    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open);
        recyclerView = findViewById(R.id.table_recycleview);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        kaiAdapter = new OpenAdapter(listTables(),OpenActivity.this);
        recyclerView.setAdapter(kaiAdapter);
        button1 = findViewById(R.id.openbutton);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OpenActivity.this,OrderActivity.class);
                startActivity(intent);
            }
        });

    }

    private List<Table> listTables(){
        Table table = new Table(1,"容量：8","可开台");
        Table table1 = new Table(2,"容量：8","可开台");
        Table table2 = new Table(3,"容量：8","可开台");
        Table table3 = new Table(4,"容量：8","可开台");
        Table table4 = new Table(5,"容量：8","可开台");
        Table table5 = new Table(6,"容量：8","可开台");
        Table table6 = new Table(7,"容量：8","可开台");
        Table table7 = new Table(8,"容量：8","可开台");
        Table table8 = new Table(9,"容量：8","可开台");
        Table table9 = new Table(10,"容量：8","可开台");
        List<Table> tableList = new ArrayList<>();
        tableList.add(table);
        tableList.add(table1);
        tableList.add(table2);
        tableList.add(table3);
        tableList.add(table4);
        tableList.add(table5);
        tableList.add(table6);
        tableList.add(table7);
        tableList.add(table8);
        tableList.add(table9);
        return tableList;
    }
}
