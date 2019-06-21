package com.example.classdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private EditText password;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        password = findViewById(R.id.password);
        button = findViewById(R.id.login);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OpenActivity.class);
                if (name.getText().toString().equals("zk") && password.getText().toString().equals("zk")) {
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "用户名或密码错误", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
