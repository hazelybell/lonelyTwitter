package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public abstract class Mood {

    private Date date;

    Mood () {
        this.date = new Date();
    }

    Mood (Date date) {
        this.date = date;
    }

    // getters and setters

    public Date getDate(){ return this.date; }

    public void setDate(Date newDate){
        this.date = newDate;
    }

    public abstract String getMood();
}
