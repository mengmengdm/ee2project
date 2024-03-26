package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.databinding.ActivityChooseWeekBinding;
import com.example.myapplication.databinding.ActivityCurrentInformation2Binding;

public class choose_week extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_week);

        Button myButton1 = findViewById(R.id.button_back_main);
        Button myButton2 = findViewById(R.id.button_go_to_monday);
        Button myButton3 = findViewById(R.id.button_go_to_tuesday);
        Button myButton4 = findViewById(R.id.button_go_to_wednsday);
        Button myButton5 = findViewById(R.id.button_go_to_thursday);
        Button myButton6 = findViewById(R.id.button_go_to_friday);
        Button myButton7 = findViewById(R.id.button_go_to_saturday);
        Button myButton8 = findViewById(R.id.button_go_to_sunday);
        // 为按钮设置点击监听器
        myButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        myButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Display_Monday.class);
                openSecondActivity("Monday");
            }
        });

        myButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Display_Monday.class);
                openSecondActivity("Tuesday");
            }
        });
        myButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Display_Monday.class);
                openSecondActivity("Wednesday");
            }
        });
        myButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Display_Monday.class);
                openSecondActivity("Thursday");
            }
        });
        myButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Display_Monday.class);
                openSecondActivity("Friday");
            }
        });

        myButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建Intent以启动新的Activity
                Intent intent = new Intent(getApplicationContext(), Display_Monday.class);
                openSecondActivity("Saturday");
            }
        });

        myButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建Intent以启动新的Activity
                Intent intent = new Intent(getApplicationContext(), Display_Monday.class);
                openSecondActivity("Sunday");
            }
        });
    }

    public void openSecondActivity(String buttonKey)
    {
        Intent intent1 = new Intent(this, Display_Monday.class);
        intent1.putExtra("BUTTON_KEY", buttonKey);
        Intent intent2 = new Intent(this, DisplayData_Monday.class);
        intent2.putExtra("BUTTON_KEY", buttonKey);
        startActivity(intent1);
    }
}