package com.example.ryhtiplus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button buttonSetNotif;
    private TextView dateDisplayText;
    private TextView welcomeDisplayText;

    Calendar calendar;
    private int dayHour;
    private String welcomeText;
    private SimpleDateFormat dateFormat;
    private String date;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSetNotif = (Button)findViewById(R.id.buttonMainSetNotifActivity);
        buttonSetNotif.setOnClickListener(this);

        dateDisplayText = findViewById(R.id.dateDisplayText);
        welcomeDisplayText = findViewById(R.id.welcomeDisplayText);

        // Calendar and date settings
        calendar = Calendar.getInstance();
        dateFormat = new SimpleDateFormat("d/M/yyyy");
        date = dateFormat.format(calendar.getTime());
        dayHour = calendar.get(Calendar.HOUR_OF_DAY);

        welcomeText = getWelcomeText();

        dateDisplayText.setText(date);
        welcomeDisplayText.setText(getWelcomeText());
    }

    public String getWelcomeText(){
        if (dayHour > 3 && dayHour < 7) welcomeText = "Hyvää yötä";
        if (dayHour > 6 && dayHour < 12) welcomeText = "Hyvää huomenta";
        if (dayHour > 11 && dayHour < 17) welcomeText = "Hyvää päivää";
        if (dayHour > 16 && dayHour < 24) welcomeText = "Hyvää iltaa";
        if (dayHour > 23 || dayHour < 4 ) welcomeText = "Hyvää yötä";

        return welcomeText;
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
