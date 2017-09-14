package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by watts1 on 9/12/17.
 */

public abstract class Tweet {

    private String message;
    private Date date;
    private ArrayList<Mood> listOfMoods;

    public Tweet(String message){
        this.message = message;
        this.date = new Date();
    }

    public Tweet(String message, Date date) {
        this.message = message;
        this.date = date;
    }

    public Tweet(String message, Date date, ArrayList<Mood> listOfMoods) {
        this.message = message;
        this.date = date;
        this.listOfMoods = listOfMoods;
    }

    public abstract Boolean isImportant();





    public void setMessage(String message) throws TweetTooLongException{
        if (message.length() > 140){
            throw new TweetTooLongException();
        } else {
            this.message = message;
        }
    }

    public String getMessage(){
        return this.message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setListOfMood(ArrayList<Mood> listOfMoods){
        this.listOfMoods = listOfMoods;
    }
}
