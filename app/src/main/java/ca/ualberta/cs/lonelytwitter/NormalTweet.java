package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Represents a normal tweet
 *
 * @author chris
 * @version 1.5
 * @see Tweet
 */
public class NormalTweet extends Tweet {
    /**
     * Constructs a normal tweet object
     *
     * @param message tweet message
     * @throws TweetTooLongException thrown if tweet exceeds 140 characters
     */
    NormalTweet(String message) throws TweetTooLongException {
        super(message);
    }

    /**
     * Constructs a normal tweet object
     * @param message tweet message
     * @param date tweet date
     * @throws TweetTooLongException thrown if tweet exceeds 140 characters
     */
    NormalTweet(String message, Date date) throws TweetTooLongException {
        super(message, date);
    }

    /**
     * Check if the tweet is important
     *
     * @return tweet importance
     */
    @Override
    public boolean isImportant(){
        return false;
    }
}
