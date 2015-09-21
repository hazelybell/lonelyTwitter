package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;


/**
 * Created by ansonli on 2015-09-14.
 */
public abstract class Tweet {
    private String text;
    private Date date;
    private ArrayList<Mood> moodList;

    public Tweet(String tweet, Date date) {
        text = tweet;
        this.date = date;
        moodList = new ArrayList<Mood>();
    }

    public Tweet (String text) {
        this.text = text;
        date = new Date();
        moodList = new ArrayList<Mood>();
    }

    public String getText() {
        return text;
    }

    // x.y in java is basically x=> y in C
    public void setText (String text) throws IOException {
        if (text.length() <= 140) {
            this.text = text;
        } else {
            throw new IOException("Tweet was too long!");
        } 
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public abstract Boolean isImportant();

    public void addMood(Mood mood)
    {
        moodList.add(mood);
    }

    public ArrayList<Mood> showMoods() {
        return moodList;
    }

}
