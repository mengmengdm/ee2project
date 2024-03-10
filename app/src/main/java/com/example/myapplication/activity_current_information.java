package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplication.databinding.ActivityCurrentInformation2Binding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class activity_current_information extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityCurrentInformation2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityCurrentInformation2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Button mybutton1 = findViewById(R.id.button_main);



        // 为按钮设置点击监听器
        mybutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建Intent以启动新的Activity
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        new Thread(new Runnable() {
            @Override
            public void run() {
                final String content = Geturl.getContent("https://studev.groept.be/api/a23ib2c03/get_New");
                String last_value = new String();

                // 更新UI元素必须在主线程中执行
                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {


                        // 这里你可以更新UI，比如设置TextView的文本为获取的内容

                        String new_value = new String();
                        Log.d("test","23454");
                        try {
                            JSONArray array = new JSONArray(content);
                            JSONObject jsonObject = array.getJSONObject(0);
                            new_value = jsonObject.getString("LastValue");
                            TextView textView = findViewById(R.id.value_temperature);
                            textView.setText(new_value);

                            // 现在你可以使用jsonObject来访问JSON对象中的数据了
                        } catch (JSONException e) {
                            e.printStackTrace();
                            // 处理错误，例如，如果jsonString不是有效的JSON格式
                        }

                        Log.d("current value",new_value);
                        Log.d("HTTP_RESPONSE", content); // 或者先简单地打印出来
                    }
                });
            }
        }).start();
    }






}