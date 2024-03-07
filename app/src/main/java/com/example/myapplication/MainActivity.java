package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.Button;

import android.view.View;

import android.content.Intent;

import android.util.Log;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String url = "https://studev.groept.be/api/a23ib2c03/test"; // 替换为你要获取内容的URL
        String content = Geturl.getContent(url);
        //testchange

        Button button = findViewById(R.id.button_go_to_current);

        // 为按钮设置点击监听器
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 创建Intent以启动新的Activity
                // intent = new Intent(MainActivity.this, activity_current_information.class);
                //startActivity(intent);
            }
        });

    }
}