package com.example.ryhtiplus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{
    /**
     buttons to set alarm, links and listview
     *
     *
     */
    private Button listViewBtn;
    private Button linkViewBtn;
    private Button setNotify;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setNotify = (Button) findViewById(R.id.setNotifyActivity);
        setNotify.setOnClickListener(this);
        listViewBtn = (Button) findViewById(R.id.listViewBtn);
        listViewBtn.setOnClickListener(this);
        linkViewBtn = (Button) findViewById(R.id.linkViewBtn);
        linkViewBtn.setOnClickListener(this);


//        listViewBtn.setOnClickListener(new AdapterView.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, ListActivity.class);
//                startActivity(intent);
//            }
//        });
//
//
//        linkViewBtn = (Button) findViewById(R.id.linkViewBtn);
//
//        linkViewBtn.setOnClickListener(new AdapterView.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent linkinIntent = new Intent(MainActivity.this, LinkView.class);
//                startActivity(linkinIntent);
//            }
//        });
//        }

    }
        @Override
        public void onClick (View view){
            switch (view.getId()) {
                case R.id.setNotifyActivity:
                    Intent nextActivity = new Intent(MainActivity.this, SetNotifyActivity.class);
                    startActivity(nextActivity);
                    break;
                case R.id.listViewBtn:
                    Intent intent = new Intent(MainActivity.this, ListActivity.class);
                    startActivity(intent);
                    break;
                case R.id.linkViewBtn:
                    Intent linkinIntent = new Intent(MainActivity.this, LinkView.class);
                    startActivity(linkinIntent);
                    break;
            }
        }
    }
