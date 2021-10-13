package com.example.ryhtiplus;

/**
 * @author roman, pavel, mihail, sami
 */
import android.app.AlarmManager;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

public class SetNotifyActivity extends MainActivity{
    public static final String SHARED_PREFS = "sharedPrefs";

    AlarmManager alarmManager;
    Switch isAlarmEnabled;
    Button setAlarmButton;
    Button cancelAlarmButton;
    static AlarmHandler alarmHandler;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    TimePicker timePicker;

    /**
     *
     * @param savedInstanceState
     */
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_notify);
        sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        timePicker = findViewById(R.id.timePicker);
        isAlarmEnabled = (Switch) findViewById(R.id.isAlarmEnabled);
        setAlarmButton = (Button) findViewById(R.id.setAlarmButton);
        cancelAlarmButton = (Button) findViewById(R.id.cancelAlarmButton);
        alarmHandler = new AlarmHandler(this, alarmManager);
        timePicker.setIs24HourView(true);
        timePicker.setHour(0);
        timePicker.setMinute(0);

        //asetetaan tunnirert ja minuutit SharedPref'sta
        try{
            timePicker.setHour(Integer.valueOf(sharedPreferences.getString("SHARED_HOURS", "")));
        } catch (Exception e){
            Log.d("SetHoursExc",e.toString());
            return;
        }
        try{
            timePicker.setMinute(Integer.valueOf(sharedPreferences.getString("SHARED_MINUTES", "")));
        } catch (Exception e){
            Log.d("SetMinutesExc",e.toString());
            return;
        }
        try{
            isAlarmEnabled.setChecked(Boolean.parseBoolean(sharedPreferences.getString("SHARED_BOOLEAN", "")));
        } catch (Exception e){
            Log.d("SetHoursExc",e.toString());
            return;
        }
    }

    /**
     *
     * @param view
     */
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void setAlarm(View view){
        int hour = 0;
        int minute = 0;
        /**Tarkistaa, että tunti on kokonaisluku, muuten se on 0*/
        try {
            hour = timePicker.getHour();
        }catch (NumberFormatException ex) {

        }
        /**Tarkistaa, että minuutit on kokonaisluku, muuten ilmoittaa siitä käyttäjälle*/
        try {
            minute = timePicker.getMinute();
        }catch (NumberFormatException ex) {
            Toast.makeText(SetNotifyActivity.this, "Anna minuutit kokonaislukuna", Toast.LENGTH_SHORT).show();
            return;
        }
        long setTime = turnHourToMls(hour) + turnMinuteToMls(minute);
        alarmHandler.setNewAlarm(setTime);
        editor = sharedPreferences.edit();
        editor.putString("SHARED_HOURS",String.valueOf(hour));
        editor.putString("SHARED_MINUTES",String.valueOf(minute));
        isAlarmEnabled.setChecked(true);
        editor.putString("SHARED_BOOLEAN",String.valueOf(isAlarmEnabled.isChecked()));
        Log.d("isAlarmEnabled: ", String.valueOf(isAlarmEnabled.isChecked()));
        editor.apply();
        isAlarmEnabled.setChecked(true);
        isAlarmEnabled.setText("Päällä");
        Toast.makeText(SetNotifyActivity.this, "Muistutus on asetettu", Toast.LENGTH_SHORT).show();
    }

    /**
     *
     * @param view
     */
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void cancelAlarm(View view){
        try {
            alarmHandler.cancelAlarm();
            isAlarmEnabled.setChecked(false);
            Toast.makeText(SetNotifyActivity.this, "Muistutus on peruttu", Toast.LENGTH_SHORT).show();
            timePicker.setHour(0);
            timePicker.setMinute(0);
            isAlarmEnabled.setChecked(false);
            isAlarmEnabled.setText("Peruutettu");
            sharedPreferences.edit().clear().apply();
        } catch (Exception e){
            Toast.makeText(SetNotifyActivity.this, "Muistutusta ei vielä ole asetettu", Toast.LENGTH_SHORT).show();
            Log.d("ExceptionCancelAlarm: ", e.toString());
            return;
        }
    }

    /**
     *
     * @param h
     * @return
     */
    public long turnHourToMls(int h){
        long mls = h * 1000 * 60 * 60;
        return mls;
    }

    /**
     *
     * @param m
     * @return
     */
    public long turnMinuteToMls(int m){
        long mls = m * 1000 * 60;
        return mls;
    }

}