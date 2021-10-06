package com.example.ryhtiplus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button listViewBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewBtn = (Button) findViewById(R.id.listViewBtn);

        listViewBtn.setOnClickListener(new AdapterView.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivity();
            }
        });

    }

    public void openActivity(){
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
    }
}
