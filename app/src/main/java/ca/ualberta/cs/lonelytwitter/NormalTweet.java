package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by fady on 19/01/17.
 */

/**
 * This is the NormalTweet class. It is a subclass of Tweet
 */

public class NormalTweet extends Tweet {

    public NormalTweet(String message) {
        super(message);
    }

    public NormalTweet(Date date, String message) {
        super(date, message);
    }

    public NormalTweet() {
    }

    @Override
    public Boolean isImportant() {
        return false;
    }
}
