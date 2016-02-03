package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author romansky on 1/12/16.
 * This class holds the information for a tweet including the date and the message
 */
public abstract class Tweet {
    protected Date date;
    protected String message;
    protected ArrayList<Mood> moods;

    public abstract Boolean isImportant();

    public Tweet(Date date, String message, ArrayList moods) {
        this.date = date;
        this.message = message;
        this.moods = moods;
    }

    public Tweet(String message) {
        this.message = message;
        this.date = new Date();
    }

    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() > 140) {
            throw new TweetTooLongException();
        }
        this.message = message;
    }
    public Date getDate() {
        return this.date;
    }

    public String getMessage() {
        return this.message;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    @Override
    public String toString(){
        return date.toString() + " | " + message;
    }

}
