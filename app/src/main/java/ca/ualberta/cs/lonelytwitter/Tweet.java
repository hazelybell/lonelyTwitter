package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Ken on 21-Sep-2017.
 */

public abstract class Tweet {
    private String message;
    private Date date;
    public abstract Boolean isImportant();

    public Tweet(String message){
        this.message = message;
        this.date = new Date();
    }

    public Tweet(String message, Date date){
        this.message = message;
        this.date = date;
    }

    public void setMessage(String message) throws TweetTooLongException{
        if(message.length() > 140){
            throw new TweetTooLongException();
        } else {
            this.message = message;
        }
    }

    public void setDate(Date date){
        this.date = date;
    }

    public String getMessage(){
        return this.message;
    }

    public Date getDate(){
        return this.date;
    }


}
