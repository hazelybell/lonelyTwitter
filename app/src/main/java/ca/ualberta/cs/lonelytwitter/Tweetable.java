package ca.ualberta.cs.lonelytwitter;

/**
 * Created by geng1 on 1/19/18.
 */

public interface Tweetable {
    public String getMood();
    public void setMood(String mood) throws TweetTooLongException;
}
