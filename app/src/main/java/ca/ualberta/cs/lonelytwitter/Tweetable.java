package ca.ualberta.cs.lonelytwitter;

/**
 * Created by fady on 19/01/17.
 */


/**
 * This is an interface
 *
 */
public interface Tweetable {
    String getMessage();
    void setMessage(String string) throws TweetTooLongException;


}
