package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author romansky on 1/12/16.
 * This class holds tweets that are set as normal
 */
public class NormalTweet extends Tweet implements Tweetable {
    public NormalTweet(Date date, String message, ArrayList moods) {
        super(date, message, moods);
    }

    public NormalTweet(String message) {
        super(message);
    }

    public Date getDate() {
        return this.date;
    }

    public String getMessage() {
        return this.message;
    }

    @Override
    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}