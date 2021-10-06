package com.example.ryhtiplus;

package com.example.ryhtiplus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button buttonSetNotif;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSetNotif = (Button)findViewById(R.id.buttonMainSetNotifActivity);
        buttonSetNotif.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonMainSetNotifActivity:
                Intent nextActivity = new Intent(MainActivity.this, SetNotifActivity.class);
                startActivity(nextActivity);
                break;
        }
    }
}
