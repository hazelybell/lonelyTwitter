package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by tymathieu on 2016-09-15.
 */
public abstract class CurrentMood {
    private Date date;

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public abstract String MyMood();
}
