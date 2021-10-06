package com.example.ryhtiplus;

import android.app.PendingIntent;

public class Alarm {
    private int id;
    private long time;
    private String notifTitle;
    private String notifText;
    private boolean isEnabled;
    private int i = 0;
    public Alarm(int id, long time, String notifTitle, String notifText, boolean isEnabled){
        this.id = id;
        this.time = time;
        this.notifTitle = notifTitle;
        this.notifText = notifText;
        this.isEnabled = isEnabled;
    }

    public int getId(){
        return this.id+10;
    }
    public long getTime(){
        return this.time;
    }
    public String getNotifTitle(){
        return this.notifTitle;
    }
    public String getNotifText(){
        return this.notifText;
    }
    public boolean getIsEnabled(){
        return this.isEnabled;
    }
}
