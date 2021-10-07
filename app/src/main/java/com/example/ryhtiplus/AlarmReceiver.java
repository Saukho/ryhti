package com.example.ryhtiplus;


import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.os.Build;

import androidx.core.app.NotificationCompat;

public class AlarmReceiver extends BroadcastReceiver {
    private  static final String CHANNEL_ID = "SAMPLE_CHANNEL";
    private static Ringtone ringtone;
    @Override
    // implement onReceive() method
    public void onReceive(Context context, Intent   intent) {
        int id = intent.getIntExtra("id",0);
        NotificationManager notifyManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            //for API 26+
            CharSequence channel_name = "My Notification";
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, channel_name, NotificationManager.IMPORTANCE_DEFAULT);
            channel.enableLights(true);
            channel.enableVibration(true);
            notifyManager.createNotificationChannel(channel);

        }
        //call MainActivity when notification is pressed
        Intent mainIntent = new Intent(context, SetNotifyActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(
                context, 0,mainIntent,0
        );

        //prepare notification
        NotificationCompat.Builder notifBuilder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(android.R.drawable.ic_dialog_alert)
                .setContentTitle("Muista ylläpitää ryhtiä!")
                .setContentText("Tämä on muistutus!")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(contentIntent)
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .setAutoCancel(true);
        //notify
        notifyManager.notify(id, notifBuilder.build());
    }
}
