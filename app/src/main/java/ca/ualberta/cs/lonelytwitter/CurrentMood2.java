package ca.ualberta.cs.lonelytwitter;

import java.util.Date;
import java.util.TooManyListenersException;

/**
 * Created by geng1 on 1/19/18.
 */

public abstract class CurrentMood2 {

    private String mood;
    private Date date;  //access modifier

    CurrentMood2(){

    }

    public CurrentMood2(String mood){
        this.mood = mood;
        this.date = new Date();
    }

    public CurrentMood2(String mood,Date date){
        this.mood =mood;
        this.date=date;
    }

    public void setDate(Date date){
        this.date=date;
    }

    public void setMood(String mood) throws TweetTooLongException{
        if (mood.length() <= 140){
            this.mood=mood;
        }
        else{
            throw new TweetTooLongException();
        }
    }

    public Date getDate(){
        return date;
    }

    public String getMood(){
        return mood;
    }

    public abstract Boolean isHappy();


}