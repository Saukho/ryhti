package com.example.ryhtiplus;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class LinkView extends AppCompatActivity {
    private Button linkView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link_view);

        linkView = findViewById(R.id.linkView);


    }
}