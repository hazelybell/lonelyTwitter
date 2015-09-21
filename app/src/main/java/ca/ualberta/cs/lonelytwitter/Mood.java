package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;
import java.util.Date;

/**
 * Created by ansonli on 2015-09-14.
 */
public abstract class Mood {

    private Date date;

    public Mood (Date date) {
        this.date = date;
    }

    public Mood () {
        date = new Date();
    }

    public abstract String getMood();

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
