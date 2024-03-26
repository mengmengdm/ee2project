package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.Button;

import android.view.View;

import android.content.Intent;

import android.util.Log;

import java.io.IOException;
import java.lang.reflect.GenericArrayType;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mybutton1 = findViewById(R.id.button_go_to_current);
        Button mybutton2 = findViewById(R.id.button_go_to_history);
        Button mybutton3 = findViewById(R.id.fanon);
        Button mybutton4 = findViewById(R.id.fanoff);
        Button mybutton5 = findViewById(R.id.switchled);
        // listening on button1
        mybutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 //show new activity
                Intent intent = new Intent(getApplicationContext(), activity_current_information.class);
                startActivity(intent);
            }
        });

        mybutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //show new activity
                Intent intent = new Intent(getApplicationContext(), choose_week.class);
                startActivity(intent);
            }
        });

        mybutton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Geturl.getRespone("https://studev.groept.be/api/a23ib2c03/update_fan/1");
            }
        });
        mybutton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Geturl.getRespone("https://studev.groept.be/api/a23ib2c03/update_fan/0");
            }
        });
        mybutton5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //show new activity
                Intent intent = new Intent(getApplicationContext(), ChooseLedFunc.class);
                startActivity(intent);
            }
        });
    }
}