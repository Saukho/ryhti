package com.example.ryhtiplus;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;

import java.util.Calendar;

public class AlarmHandler {

    private Intent intent;
    private static PendingIntent pendingIntent;
    private Context context;
    private static AlarmManager alarmManager;
    private int notificationId = 1;

    public AlarmHandler(Context context, AlarmManager alarmManager){
        this.context = context;
        this.alarmManager = alarmManager;
        intent = new Intent(context, NotifyReceiver.class);
    }

    /**
     * @use
     * @author
     * @param n
     */


    public void setNewAlarm(Notification n){
        /**
         * Tämän avulla otetaan käyttöön Manifest-luokassa määritelty Receiver = käyttäjä saa muistutukset
         * */
        ComponentName receiver = new ComponentName(context, NotifyReceiver.class);
        PackageManager pm = context.getPackageManager();
        pm.setComponentEnabledSetting(receiver,
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP);
        intent.putExtra("id", notificationId);
        pendingIntent = PendingIntent.getBroadcast(context, 1, intent, 0);
        long currentime = Calendar.getInstance().getTimeInMillis();
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, currentime + n.getTime(), n.getTime(), pendingIntent);
    }

    public void cancelAlarm(){
        /**
       * Tämän avulla poistetaan Manifest-luokassa määritelty Receiver käytöstä = ei enää muistutuksia
       * */
        ComponentName receiver = new ComponentName(context, NotifyReceiver.class);
        PackageManager pm = context.getPackageManager();
        pm.setComponentEnabledSetting(receiver,
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP);
    }

}