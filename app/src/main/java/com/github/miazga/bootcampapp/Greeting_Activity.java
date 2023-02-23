package com.github.miazga.bootcampapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class Greeting_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geeting);

        Intent i = getIntent();
        String individualName = i.getStringExtra("individualName");
        ((TextView)findViewById(R.id.textView)).setText("Greetings " + individualName + "!");
    }
}