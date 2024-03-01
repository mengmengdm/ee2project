package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
        Response response = Geturl.getContent(url);
        if (response != null && response.isSuccessful()) {
            try {
                String responseBody = response.body().string();
                // 在这里处理响应体
                Log.d("HTTP_RESPONSE", responseBody);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // 处理请求失败的情况
            Log.e("HTTP_ERROR", "Unexpected code " + response);
        }

    }


}