package com.example.ryhtiplus;


import android.app.Activity;
import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;


import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    PendingIntent pendingIntent;
    AlarmManager alarmManager;
    EditText setHour;
    EditText setMinute;
    EditText setId;
    Button alarmInfo;
    Switch isAlarmEnabled;
    Button setAlarmButton;
    Button cancleAlarmBtn;
    EditText notifTitle;
    EditText notifText;
    AlarmHandler alarmHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createNotificationChannel();
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        setHour = findViewById(R.id.setHour);
        setMinute = findViewById(R.id.setMinute);
        setId = findViewById(R.id.alarmIdSetter);
        alarmInfo = (Button) findViewById(R.id.getAlarmInfo);
        isAlarmEnabled = (Switch) findViewById(R.id.isAlarmEnabled);
        setAlarmButton = (Button) findViewById(R.id.setAlarmButton);
        cancleAlarmBtn = (Button) findViewById(R.id.cancleAlarmBtn);
        notifText = (EditText) findViewById(R.id.alarmContextText);
        notifTitle = (EditText) findViewById(R.id.alarmContextTitle);

        alarmHandler = new AlarmHandler(this, alarmManager);

        setId.setText("1");
        setMinute.setText("0");
        setHour.setText("0");
    }


    public void getAlarmInfoOnDisplay(View view){

    }

    public void setAlarm(View view){

        Toast.makeText(MainActivity.this, "ALARM ON", Toast.LENGTH_SHORT).show();

        long setTime = turnHourToMls(Integer.valueOf(setHour.getText().toString())) + turnMinuteToMls(Integer.valueOf(setMinute.getText().toString()));

        if(setTime  >= 60000){
            Alarm alarm = new Alarm(Integer.valueOf(setId.getText().toString()), setTime, notifTitle.getText().toString(), notifText.getText().toString(), true);
            alarmHandler.setNewAlarm(alarm);
        } else {
            setTime = 1000;
            Alarm alarm = new Alarm(Integer.valueOf(setId.getText().toString()), setTime, notifTitle.getText().toString(), notifText.getText().toString(), true);
            alarmHandler.setNewAlarm(alarm);

        }
    }

    public void cancleAlarmById(View view){
        Intent intent = new Intent(this, AlarmReciver.class);

        pendingIntent = PendingIntent.getBroadcast(this, Integer.valueOf(setId.getText().toString()) + 10, intent, 0);
        alarmManager.cancel(pendingIntent);
        Toast.makeText(MainActivity.this, "ALARM OFF", Toast.LENGTH_SHORT).show();
    }

    public long turnHourToMls(int h){
        long mls = h * 1000 * 60 * 60;
        return mls;
    }
    public long turnMinuteToMls(int m){
        long mls = m * 1000 * 60;
        return mls;
    }

    public void createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = "alarm";
            String description  = "description";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("alarm",name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

}