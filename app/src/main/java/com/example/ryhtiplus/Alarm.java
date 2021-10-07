package com.example.ryhtiplus;

public class Alarm {
    private int id;
    private long time;
    private String notifyTitle;
    private String notifyText;
    private boolean isEnabled;
    private int i = 0;
    public Alarm(int id, long time, String notifyTitle, String notifyText, boolean isEnabled){
        this.id = id;
        this.time = time;
        this.notifyTitle = notifyTitle;
        this.notifyText = notifyText;
        this.isEnabled = isEnabled;
    }

    public int getId(){
        return this.id+10;
    }
    public long getTime(){
        return this.time;
    }
    public String getNotifyTitle(){
        return this.notifyTitle;
    }
    public String getNotifyText(){
        return this.notifyText;
    }
    public boolean getIsEnabled(){
        return this.isEnabled;
    }
}
