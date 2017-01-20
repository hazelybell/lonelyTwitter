package ca.ualberta.cs.lonelytwitter;

import java.util.Date;


public abstract class Tweet implements Tweetable{
    private Date date;
    private String message;

    public Tweet(String message){
        this.message = message;
        this.date = new Date();
    }

    public Tweet(Date date, String message){
        this.date = date;
        this.message = message;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setMessage(String message) throws TweetTooLongException {
        if(message.length() > 140){
            throw new TweetTooLongException();
        }else {
            this.message = message;
        }
    }

    public Date getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }

    public Tweet(){
        super();
        this.date = new Date();
    }

    public abstract Boolean isImportant();
}
