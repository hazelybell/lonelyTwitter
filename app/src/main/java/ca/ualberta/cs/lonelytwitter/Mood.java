package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Ken on 21-Sep-2017.
 */

public abstract class Mood {
    private Date date;
    public abstract String getMood();

    public Mood(){
        this.date = new Date();
    }

    public Mood(Date date) {
        this.date = date;
    }

    public void setDate(Date date){
        this.date = date;
    }

    public Date getDate() {
        return this.date;
    }
}
