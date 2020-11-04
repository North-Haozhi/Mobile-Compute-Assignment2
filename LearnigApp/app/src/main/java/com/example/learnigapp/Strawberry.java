package com.example.learnigapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class Strawberry extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strawberry);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences=getSharedPreferences("language",MODE_PRIVATE);
        String language = sharedPreferences.getString("language", "en");

        final TextView first=findViewById(R.id.first);
        final TextView name=findViewById(R.id.name);

        if (language.equals("en")){
            first.setText("S");
            name.setText("Strawberry");
        } else {
            first.setText("草");
            name.setText("草莓");
        }

    }
}