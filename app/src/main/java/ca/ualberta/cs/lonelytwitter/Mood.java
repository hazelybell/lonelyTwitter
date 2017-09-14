package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by enzozafra on 2017-09-13.
 */

public abstract class Mood {
    private Date date;

    public Mood() {
        this.date = new Date();
    }

    public Mood(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public abstract String showMood();
}
