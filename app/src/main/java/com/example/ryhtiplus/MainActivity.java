package com.example.ryhtiplus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{
    private Button listViewBtn;
    private Button setNotify;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setNotify = (Button)findViewById(R.id.setNotifyActivity);
        setNotify.setOnClickListener(this);
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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.setNotifyActivity:
                Intent nextActivity = new Intent(MainActivity.this, SetNotifyActivity.class);
                startActivity(nextActivity);
                break;
        }
    }
}
