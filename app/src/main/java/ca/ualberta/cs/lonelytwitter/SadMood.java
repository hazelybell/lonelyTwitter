package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by baydala on 1/12/16.
 */

/**
 * Class to hold tweets that are set as sad
 */
public class SadMood extends Mood {
    public SadMood(String mood, Date date) {
        super(mood, date);
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setMood(String mood) {
        this.mood = "sad";
    }

}
