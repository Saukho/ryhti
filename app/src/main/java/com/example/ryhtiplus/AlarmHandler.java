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
    private ArrayList<Alarm> alarms;
    private Intent intent;
    private PendingIntent pendingIntent;
    private Context context;
    private AlarmManager alarmManager;

    public AlarmHandler(Context context, AlarmManager alarmManager){
        alarms = new ArrayList<>();

        this.context = context;
        this.alarmManager = alarmManager;
    }

    public void setNewAlarm(Alarm a){
        deleteAlarmsWithSameId(a);
        intent = new Intent(context, AlarmReciver.class);

        //asetan muutaman arvon jotka voin vetää ulos onRecive() alarmReciveressä
        //tää lähettää vissiin oikeaa tietoa mut alarmreciver ei vastaanota sitä emt miks
        intent.putExtra("titleText", a.getNotifTitle());
        intent.putExtra("textText", a.getNotifText());
        intent.putExtra("id", a.getId());
        Log.d("intentti", "setNewAlarm: "+a.getNotifText()+": "+a.getNotifTitle()+ ": "+a.getId());

        pendingIntent = PendingIntent.getBroadcast(context, a.getId(), intent, 0);
        long currentime = Calendar.getInstance().getTimeInMillis();
        alarms.add(a);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, currentime + a.getTime(), a.getTime(), pendingIntent);

    }

    public boolean checkIfAlarmIdExist(Alarm a){
        for(int i = 0; i < alarms.size() -1 ; i++){
            if(alarms.get(i).getId() == a.getId()){
                return true;
            }
        }
        return false;
    }

    public void deleteAlarmsWithSameId(Alarm a) {
        for (int i = 0; i < alarms.size() - 1; i++) {
            if (alarms.get(i).getId() == a.getId()) {
                intent = new Intent(context, AlarmReciver.class);

                pendingIntent = PendingIntent.getBroadcast(context, a.getId(), intent, 0);
                alarmManager.cancel(pendingIntent);
                alarms.remove(i);
            }
        }
    }

}
