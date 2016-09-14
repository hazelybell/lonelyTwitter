package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by john on 13/09/16.
 */

public abstract class Tweet implements Tweetable{
    private String message;
    private Date date;
    private ArrayList<CurrentMood> TweetMoods;

    public Tweet(String message) {

        this.message = message;
    }

    public Tweet(String message, Date date) {

        this.message = message;
        this.date = date;
    }

    public void SetMessage(String message) throws TweetTooLongException {

       if(message.length() > 140){
           throw new TweetTooLongException();
        }

        this.message = message;
    }

    public String GetMessage(){

        return this.message;
    }

    public void SetDate(Date date){

        this.date = date;
    }

    public Date GetDate(){

        return this.date;
    }

    public void AddMood(CurrentMood mood)
    {
        this.TweetMoods.add(mood);
    }

    public ArrayList<CurrentMood> GetMoodsList(){
        return this.TweetMoods;
    }

    public abstract Boolean isImportant();

}
