package com.github.miazga.bootcampapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Main_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void disable(View v) {
        System.out.println("Hello I am disabled");
        v.setEnabled(false);
    }

    public void launchGreeting(View v) {
        //launch a new activity
        Intent i = new Intent(Main_Activity.this, Greeting_Activity.class);
        String name = ((EditText)findViewById(R.id.mainName)).getText().toString();
        i.putExtra("individualName", name);
        startActivity(i);
    }
}