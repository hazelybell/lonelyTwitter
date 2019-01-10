package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public abstract class Mood {
    // Standard getters and setters for the date
    protected Date date;
    public Date getDate(){
        return date;
    }
    public void setDate(Date date){
        this.date = date;
    }
    public abstract String format();
}
