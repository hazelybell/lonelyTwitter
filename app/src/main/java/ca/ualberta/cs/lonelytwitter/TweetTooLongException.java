package ca.ualberta.cs.lonelytwitter;

/**
 * Created by ysu3 on 1/17/17.
 */

public class TweetTooLongException extends Exception {
    public TweetTooLongException() {
    }

    public TweetTooLongException(String detailMessage) {
        super(detailMessage);
    }
}
