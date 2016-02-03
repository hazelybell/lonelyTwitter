package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * @author baydala on 1/12/16.
 * This class will hold tweets that are set as Happy
 */
public class HappyMood extends Mood {
    public HappyMood(String mood, Date date) {
        super(mood, date);
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setMood(String mood) {
        this.mood = "Happy";
    }

}
