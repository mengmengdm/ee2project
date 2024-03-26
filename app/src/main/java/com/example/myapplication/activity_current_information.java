package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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
    private Runnable mRunnable;
    private Handler mHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHandler = new Handler();
        binding = ActivityCurrentInformation2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Button mybutton1 = findViewById(R.id.button_main);
        //Data[] dataArray = Geturl.getContent("https://studev.groept.be/api/a23ib2c03/get_sensordata");
        TextView temperature_value = findViewById(R.id.temperature_value);
        //temperature_value.setText(dataArray[0].getTemperature());
        TextView humidity_value = findViewById(R.id.humidity_value);
        TextView people_value = findViewById(R.id.people_value);
        TextView noise_value = findViewById(R.id.noise_value);
        //humidity_value.setText(dataArray[0].getHumidity());
        mRunnable = new Runnable() {
            @Override
            public void run() {
                // get new data from database
                Data[] dataArray = Geturl.getContent("https://studev.groept.be/api/a23ib2c03/get_latest");
                temperature_value.setText(dataArray[0].getTemperature()+"°C");
                humidity_value.setText(dataArray[0].getHumidity()+"%");
                people_value.setText(dataArray[0].getPeople());
                noise_value.setText(dataArray[0].getSound());
                // delay 5s and refresh again
                mHandler.postDelayed(this, 2000);
            }
        };
        mHandler.post(mRunnable);
        mybutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建Intent以启动新的Activity
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        
    }
    protected void onDestroy() {
        super.onDestroy();
        // remove all runables
        mHandler.removeCallbacksAndMessages(null);
    }

}