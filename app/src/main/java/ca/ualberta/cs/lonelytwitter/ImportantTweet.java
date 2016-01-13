package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by romansky on 1/12/16.
 */
public class ImportantTweet extends Tweet implements Tweetable {
    @Override
    public Boolean isImportant() {
        return Boolean.TRUE;
    }

    public ImportantTweet(Date date, String message) {
        super(date, message);
    }

    public ImportantTweet(String message) {
        super(message);
    }

    public Date getDate() {
        return this.date;
    }

    public String getMessage() {
        return "!IMPORTANT! " + this.message;
    }
}
