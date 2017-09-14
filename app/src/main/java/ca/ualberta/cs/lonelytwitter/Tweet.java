package ca.ualberta.cs.lonelytwitter;

import java.util.Date;
import java.util.List;

/**
 * Created by enzozafra on 2017-09-13.
 */

public abstract class Tweet implements Tweetable{
    private String message;
    private Date date;
    private List<Mood> listMood;

    public Tweet(String message, List<Mood> listMood) {
        this.message = message;
        this.date = new Date();
        this.listMood = listMood;
    }

    public Tweet(String message, List<Mood> listMood, Date date) {
        this.message = message;
        this.date = date;
        this.listMood = listMood;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) throws TweetTooLongException{
        if (message.length() <= 140) {
            this.message = message;
        }
        else {
            throw new TweetTooLongException();
        }
    }

    public Date getDate() {
        return date;
    }

    public List<Mood> getListMood() {
        return listMood;
    }

    public void setListMood(List<Mood> listMood) {
        this.listMood = listMood;
    }

    public abstract Boolean isImportant();


}
