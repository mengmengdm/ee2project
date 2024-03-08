package com.example.myapplication;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplication.databinding.ActivityCurrentInformation2Binding;

public class activity_current_information extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityCurrentInformation2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityCurrentInformation2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



    }


}