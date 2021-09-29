package com.example.ryhtiplus;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private int notificationId = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view){
        TimePicker timePicker = findViewById(R.id.timePicker);

        Intent intent = new Intent(this, SendNotification.class);
        intent.putExtra("notificationId", notificationId);
        intent.putExtra("message", "Muista ryhdistä!");

        //PendingIntent = "By giving a PendingIntent to another application, you are granting it the
        // right to perform the operation you have specified as if the other application was yourself"
        PendingIntent notificationIntent = PendingIntent.getBroadcast(
                this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT
        );

        //AlarmManager = "These allow you to schedule your application to be run at some point in the future"
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        //Set notification
        if(view.getId() == R.id.setBtn){
            int hour = timePicker.getCurrentHour();
            int minute = timePicker.getCurrentMinute();
            //set time

            Calendar time = Calendar.getInstance();
            time.set(Calendar.MINUTE, minute);
            time.set(Calendar.HOUR_OF_DAY, hour);
            time.set(Calendar.SECOND, 0);
            //get time in milliseconds
            long notificationTime = time.getTimeInMillis();

            alarmManager.set(AlarmManager.RTC_WAKEUP, notificationTime, notificationIntent);
            Toast.makeText(this, "Muistutus on asetettu!", Toast.LENGTH_SHORT).show();
        }
        //Cancel
        if(view.getId() == R.id.cancelBtn){
            alarmManager.cancel(notificationIntent);
            Toast.makeText(this,"Muistutus on peruttu",Toast.LENGTH_SHORT).show();
        }
    }
}