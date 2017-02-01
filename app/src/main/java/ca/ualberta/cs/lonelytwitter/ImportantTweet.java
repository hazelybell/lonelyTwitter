package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by fady on 19/01/17.
 */

/**
 * This is ImportantTweet class. It is a subclass of Tweet
 */

public class ImportantTweet extends Tweet {
    public ImportantTweet(String message) {
        super(message);
    }

    public ImportantTweet(Date date, String message) {
        super(date, message);
    }

    public ImportantTweet() {
    }

    @Override
    public Boolean isImportant() {
        return true;
    }
}

