package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseLedFunc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_led_func);

        Button mybutton1 = findViewById(R.id.button_back_main);
        Button Mode0 = findViewById(R.id.Mode0);
        Button Mode1 = findViewById(R.id.Mode1);
        Button Mode2  = findViewById(R.id.Mode2);
        Button Mode3 = findViewById(R.id.Mode3);

    mybutton1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }
    });

    Mode0.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Geturl.getRespone("https://studev.groept.be/api/a23ib2c03/update_led/0");
        }
    });

    Mode1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Geturl.getRespone("https://studev.groept.be/api/a23ib2c03/update_led/1");
        }
    });

    Mode2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Geturl.getRespone("https://studev.groept.be/api/a23ib2c03/update_led/2");
        }
    });

    Mode3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Geturl.getRespone("https://studev.groept.be/api/a23ib2c03/update_led/3");
        }
    });
    }
}