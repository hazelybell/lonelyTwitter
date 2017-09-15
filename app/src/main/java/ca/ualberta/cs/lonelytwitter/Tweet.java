package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by sbergen on 9/14/17.
 */

public abstract class Tweet implements Tweetable{
    private String message;
    private Date date;
    private ArrayList<Mood> moodList;

    public Tweet(String message){
        this.message = message;
        this.date = new Date();
        moodList = new ArrayList<Mood>();
    }

    public Tweet(String message, Date date){
        this.message = message;
        this.date = date;
        moodList = new ArrayList<Mood>();
    }

    public void addMood(Mood mood){
        moodList.add(mood);
    }

    public ArrayList<Mood> getMoods(){
        return moodList;
    }

    public void setDate(Date date){
        this.date = date;
    }

    public void setMessage(String message) throws TweetTooLongException{
        if (message.length() <= 140){
            this.message = message;
        }else{
            throw new TweetTooLongException();
        }

    }

    public Date getDate(){
        return date;
    }

    public String getMessage(){
        return message;
    }

    public abstract Boolean isImportant();
}
