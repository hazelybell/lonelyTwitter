package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * @author baydala on 1/12/16.
 * Class to hold the set mood of a tweet
 */
public abstract class Mood {
    public String mood;
    public Date date;

    public Mood(String mood, Date date) {
        this.mood = mood;
        this.date = date;
    }

    public Mood(String mood) {
        this.mood = mood;
        this.date = new Date();
    }

    public String getMood() {
        return mood;
    }

}

