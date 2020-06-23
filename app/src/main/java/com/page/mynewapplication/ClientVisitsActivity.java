package com.page.mynewapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class ClientVisitsActivity extends AppCompatActivity {
    ArrayList<String> listPath;
    int[] logos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clint_visits);


    }
}