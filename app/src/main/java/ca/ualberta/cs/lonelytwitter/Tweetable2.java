package ca.ualberta.cs.lonelytwitter;

/**
 * Created by geng1 on 1/19/18.
 */

public interface Tweetable2 {
    public String getMessage();
    public void setMessage(String message) throws TweetTooLongException;
}
