package com.example.ryhtiplus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView buttonSetNotif;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void onSetNotifActivityClicked(View view){
        Intent nextActivity = new Intent(MainActivity.this, SetNotifActivity.class);
        startActivity(nextActivity);

    }
}
