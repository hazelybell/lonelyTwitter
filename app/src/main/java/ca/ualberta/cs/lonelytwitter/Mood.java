package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public abstract class Mood {
    private Date date;

    public Mood(){
        date = new Date();
    }

    public Mood(Date in){
        date = in;
    }

    public abstract String format();

    public Date getDate(){
        return date;
    }

    public void setDate(Date d){
        date = d;
    }
}
