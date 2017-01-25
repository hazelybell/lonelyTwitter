package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by ysu3 on 1/17/17.
 */

public abstract class Tweet implements Tweetable{
    private Date date;
    private String Message;
    private ArrayList<Mood> moodArray = new ArrayList<Mood>();

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) throws TweetTooLongException {
        if (Message.length() > 144){
            throw new TweetTooLongException();
        }
        else{
            Message = message;
        }
    }

    public Tweet(Date date, String Message) throws TweetTooLongException {
        this.date = date;
        this.setMessage(Message);
    }

    public Tweet(String Message) {
        this.Message = Message;
        this.date = new Date();
    }

    public void add_mood(Mood mood){
        moodArray.add(mood);
    }

    public abstract boolean isImportant();

    @Override
    public String toString(){
        return date.toString() + " | " + Message;
    }
}
