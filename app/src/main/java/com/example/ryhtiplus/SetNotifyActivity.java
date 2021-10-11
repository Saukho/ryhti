package com.example.ryhtiplus;


import android.app.AlarmManager;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class SetNotifyActivity extends MainActivity{
    public static final String SHARED_PREFS = "sharedPrefs";

    AlarmManager alarmManager;
    EditText setHour;
    EditText setMinute;
    Switch isAlarmEnabled;
    Button setAlarmButton;
    Button cancelAlarmButton;
    static AlarmHandler alarmHandler;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_notify);
        sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        setHour = findViewById(R.id.setHour);
        setMinute = findViewById(R.id.setMinute);
        isAlarmEnabled = (Switch) findViewById(R.id.isAlarmEnabled);
        setAlarmButton = (Button) findViewById(R.id.setAlarmButton);
        cancelAlarmButton = (Button) findViewById(R.id.cancelAlarmButton);
        alarmHandler = new AlarmHandler(this, alarmManager);
        /**asetetaan tunnit ja minuutit SharedPref'sta*/
        try{
            setHour.setText(sharedPreferences.getString("SHARED_HOURS", ""));
        } catch (Exception e){
            Log.d("SetHoursExc",e.toString());
            return;
        }
        try{
            setMinute.setText(sharedPreferences.getString("SHARED_MINUTES", ""));
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

    public void setAlarm(View view){
        int hour = 0;
        int minute = 0;
        /**Tarkistaa, että tunti on kokonaisluku, muuten se on 0*/
        try {
            hour = Integer.parseInt(setHour.getText().toString());
        }catch (NumberFormatException ex) {

        }
        /**Tarkistaa, että minuutit on kokonaisluku, muuten ilmoittaa siitä käyttäjälle*/
        try {
            minute = Integer.parseInt(setMinute.getText().toString());
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

    public void cancelAlarm(View view){
        try {
            alarmHandler.cancelAlarm();
            isAlarmEnabled.setChecked(false);
            Toast.makeText(SetNotifyActivity.this, "Muistutus on peruttu", Toast.LENGTH_SHORT).show();
            setHour.setText("");
            setMinute.setText("");
            isAlarmEnabled.setChecked(false);
            isAlarmEnabled.setText("Peruutettu");
            sharedPreferences.edit().clear().apply();
        } catch (Exception e){
            Toast.makeText(SetNotifyActivity.this, "Muistutusta ei vielä ole asetettu", Toast.LENGTH_SHORT).show();
            Log.d("ExceptionCancelAlarm: ", e.toString());
            return;
        }
    }
    public long turnHourToMls(int h){
        long mls = h * 1000 * 60 * 60;
        return mls;
    }
    public long turnMinuteToMls(int m){
        long mls = m * 1000 * 60;
        return mls;
    }

}