package com.example.ryhtiplus;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class SetNotifyActivity extends MainActivity{

    PendingIntent pendingIntent;
    AlarmManager alarmManager;
    EditText setHour;
    EditText setMinute;
    Switch isAlarmEnabled;
    Button setAlarmButton;
    Button cancelAlarmBtn;
    AlarmHandler alarmHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_notify);
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        setHour = findViewById(R.id.setHour);
        setMinute = findViewById(R.id.setMinute);
        isAlarmEnabled = (Switch) findViewById(R.id.isAlarmEnabled);
        setAlarmButton = (Button) findViewById(R.id.setAlarmButton);
        cancelAlarmBtn = (Button) findViewById(R.id.cancleAlarmBtn);
        alarmHandler = new AlarmHandler(this, alarmManager);
        isAlarmEnabled.setChecked(false);


    }

    @Override
    protected void onPause() {
        super.onPause();
        isAlarmEnabled.setChecked(true);

    }

    public void setAlarm(View view){
        int hour = 0;
        int minute = 0;
        //Tarkistaa, että tunti on kokonaisluku, muuten se on 0
        try {
             hour = Integer.parseInt(setHour.getText().toString());
        }catch (NumberFormatException ex) {

        }
        //Tarkistaa, että minuutit on kokonaisluku, muuten ilmoittaa siitä käyttäjälle
        try {
            minute = Integer.parseInt(setMinute.getText().toString());
        }catch (NumberFormatException ex) {
            Toast.makeText(SetNotifyActivity.this, "Anna minuutit kokonaislukuna", Toast.LENGTH_SHORT).show();
            return;
        }

        long setTime = turnHourToMls(hour) + turnMinuteToMls(minute);
        if(setTime  >= 60000){
            Alarm alarm = new Alarm(1, setTime, "Notification","Text",true);
            alarmHandler.setNewAlarm(alarm);
        } else {
            setTime = 1000;
            Alarm alarm = new Alarm(1, setTime,"Notification","Text",true);
            alarmHandler.setNewAlarm(alarm);
        }
        isAlarmEnabled.setChecked(true);
        isAlarmEnabled.setText("Päällä");
        Toast.makeText(SetNotifyActivity.this, "Muistutus on asetettu", Toast.LENGTH_SHORT).show();
    }

    public void cancleAlarm(View view){
        //tätä pitää vielä muokata
        /*Intent intent = new Intent(this, AlarmReciver.class);
        pendingIntent = PendingIntent.getBroadcast(this, Integer.valueOf(setId.getText().toString()) + 10, intent, 0);
        alarmManager.cancel(pendingIntent);
        Toast.makeText(MainActivity.this, "ALARM OFF", Toast.LENGTH_SHORT).show();*/
        isAlarmEnabled.setChecked(false);
        isAlarmEnabled.setText("Peruutettu");
        Toast.makeText(SetNotifyActivity.this, "Muistutus on peruttu", Toast.LENGTH_SHORT).show();
    }
    public long turnHourToMls(int h){
        long mls = h * 1000 * 60 * 60;
        return mls;
    }
    public long turnMinuteToMls(int m){
        long mls = m * 1000 * 60;
        return mls;
    }
    public long turnSecondsToMls(int m){
        long mls = m * 1000 * 60;
        return mls;
    }

}