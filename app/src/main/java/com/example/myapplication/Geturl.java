package com.example.myapplication;

import android.util.Log;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import com.google.gson.Gson;
public class Geturl {
    public static Response getRespone(final String url) {
        // 在新线程中执行网络请求
        final Response[] response = {null};
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient();

                Request request = new Request.Builder()
                        .url(url)
                        .build();
                try {
                    response[0] = client.newCall(request).execute();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // 等待响应完成
        while (response[0] == null) {
            try {
                Thread.sleep(100); // 等待100毫秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return response[0];
    }
    public static Data[] getContent(String url)
    {
        Response response = getRespone(url);
        if (response != null && response.isSuccessful()) {
            try {
                String responseBody = response.body().string();
                Gson gson = new Gson();
                Data[] dataArray = gson.fromJson(responseBody, Data[].class);
                Log.d("HTTP_RESPONSE", responseBody);
                Log.d("TAG",dataArray[0].getDate() );
                return dataArray;
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // 处理请求失败的情况
            Log.e("HTTP_ERROR", "Unexpected code " + response);
        }
        return null;
    }
}
