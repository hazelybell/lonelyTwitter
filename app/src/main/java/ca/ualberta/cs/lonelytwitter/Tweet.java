package ca.ualberta.cs.lonelytwitter;

/**
 * Created by geng1 on 1/19/18.
 */

import java.util.Date;

public abstract class Tweet implements Tweetable{

    private String mood;
    private Date date;

    Tweet(){

    }

    public Tweet(String mood){
        this.mood = mood;
    }

    public Tweet(String mood, Date date){
        this.mood = mood;
        this.date = date;
    }

    public Date getDate(){
        return date;
    }

    public String getMood(){
        return mood;
    }

    public void setMood(String mood) throws TweetTooLongException{
        if(mood.length() > 160){
            // throw an error
            throw new TweetTooLongException();
        }
        this.mood = mood;
    }

    public void setDate(Date date){
        this.date = date;
    }

    public abstract boolean isMood2();

}
