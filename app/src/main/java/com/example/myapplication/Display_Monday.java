package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Display_Monday extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DisplayData_Monday displayView = new DisplayData_Monday(this);
        setContentView(R.layout.activity_display_monday);

        String buttonKey = getIntent().getStringExtra("BUTTON_KEY");

        TextView textView = findViewById(R.id.WeekDay);

        if ("Monday".equals(buttonKey)) {
            textView.setText("Monday");
        } else if ("Tuesday".equals(buttonKey)) {
            textView.setText("Tuesday");
        }else if ("Wednesday".equals(buttonKey)) {
            textView.setText("Wednesday");
        }else if ("Thursday".equals(buttonKey)) {
            textView.setText("Thursday");
        }else if ("Friday".equals(buttonKey)) {
            textView.setText("Friday");
        }


        Button mybutton1 = findViewById(R.id.button_back_main);
        Button mybutton2 = findViewById(R.id.button_back_choose_week);
        // 为按钮设置点击监听器
        mybutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建Intent以启动新的Activity
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        mybutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建Intent以启动新的Activity
                Intent intent = new Intent(getApplicationContext(), choose_week.class);
                startActivity(intent);
            }
        });
    }
}