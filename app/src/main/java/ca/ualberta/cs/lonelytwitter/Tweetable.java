package ca.ualberta.cs.lonelytwitter;

/**
 * Represents a tweet interface
 *
 * @author chris
 */
public interface Tweetable {
    public String getMessage();

    /**
     * Sets the tweet message
     *
     * @param message tweet message
     * @throws TweetTooLongException thrown if tweet exceeds 140 characters
     */
    public void setMessage(String message) throws TweetTooLongException;
}
