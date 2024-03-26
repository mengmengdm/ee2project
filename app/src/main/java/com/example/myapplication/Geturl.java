package com.example.myapplication;

import android.util.Log;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import com.google.gson.Gson;

public class Geturl {
    public static Response getRespone(final String url) {
        // get http in a new thread
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

        // wait for the previous works are done
        while (response[0] == null) {
            try {
                Thread.sleep(100); // wait
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
            // http request failed
            Log.e("HTTP_ERROR", "Unexpected code " + response);
        }
        return null;
    }
}
