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
        TextView textView = findViewById(R.id.value_temperature);
        Data[] dataArray = Geturl.getContent("https://studev.groept.be/api/a23ib2c03/get_latest_sensordata");
        textView.setText(dataArray[0].getHumidity());

    }

}