package ca.ualberta.cs.lonelytwitter;

/**
 * Created by shida3 on 1/19/17.
 */

public interface Tweetable {
    public String getMessage();
    public void setMessage(String string) throws TweetTooLongException;
}
