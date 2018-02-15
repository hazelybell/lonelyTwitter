package ca.ualberta.cs.lonelytwitter;

/**
 * Created by critt on 2018-01-17.
 */

import java.util.Date;
import java.util.ArrayList;

public abstract class Tweet implements Tweetable{
    private String message;
    private Date date;
    private ArrayList<Mood> moods = new ArrayList<Mood>();

    Tweet() {

    }

    Tweet(String message) {
        this.message = message;
    }

    Tweet(String message, Date date) {
        this.message = message;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() > 160) {
            throw new TweetTooLongException();
        }
        this.message = message;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void addMood(Mood mood){
        this.moods.add(mood);
    }

    public abstract boolean isImportant();
    @Override
    public String toString(){
        return message;
    }
}