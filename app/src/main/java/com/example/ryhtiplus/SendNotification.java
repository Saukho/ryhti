package com.example.ryhtiplus;

import static android.os.Build.*;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.core.app.NotificationCompat;

public class SendNotification extends BroadcastReceiver {

    private  static final String CHANNEL_ID = "SAMPLE_CHANNEL";

    @Override
    public void onReceive(Context context, Intent intent) {
        int  notificationId = intent.getIntExtra("notificationId", 0);

        //call MainActivity when notification is pressed
        Intent mainIntent = new Intent(context, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(
                context, 0,mainIntent,0
        );

        //NotificationManager = "Class to notify the user of events that happen"
        NotificationManager nManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            //for API 26+
            CharSequence channel_name = "My Notification";
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, channel_name, NotificationManager.IMPORTANCE_DEFAULT);
            nManager.createNotificationChannel(channel);

        }

        //prepare notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(android.R.drawable.ic_dialog_alert)
                .setContentTitle("Muista ylläpitämään ryhtiä!")
                .setContentText("Tämä on muistutus!")
                .setContentIntent(contentIntent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true);
        //notify
        nManager.notify(notificationId, builder.build());
    }
}
