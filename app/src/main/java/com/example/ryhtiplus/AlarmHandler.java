package com.example.ryhtiplus;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import java.util.ArrayList;
import java.util.Calendar;

public class AlarmHandler {
    private Intent intent;
    private PendingIntent pendingIntent;
    private Context context;
    private AlarmManager alarmManager;
    private int notificationId = 1;

    public AlarmHandler(Context context, AlarmManager alarmManager){
        this.context = context;
        this.alarmManager = alarmManager;
    }

    public void setNewAlarm(Alarm a){
        intent = new Intent(context, AlarmReciver.class);
        intent.putExtra("id", notificationId);
        pendingIntent = PendingIntent.getBroadcast(context, a.getId(), intent, 0);
        long currentime = Calendar.getInstance().getTimeInMillis();
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, currentime + a.getTime(), a.getTime(), pendingIntent);
    }

}