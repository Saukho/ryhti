package com.example.ryhtiplus;

public class Notification {
    private int id;
    private long time;
    private String notifyTitle;
    private String notifyText;
    private boolean isEnabled;
    private int i = 0;
    //Tällä hetkellä käytetään tästä vain "time", poistetaan muut myöhemmin
    public Notification(int id, long time, String notifyTitle, String notifyText, boolean isEnabled){
        this.id = id;
        this.time = time;
        this.notifyTitle = notifyTitle;
        this.notifyText = notifyText;
        this.isEnabled = isEnabled;
    }

    public int getId(){
        return this.id;
    }

    public long getTime(){
        return this.time;
    }
}