/**
 * TweetTooLongException defines the message to be returned
 * to the user if a message is entered that is too long.
 * @author Shawna Dawson
 * @version 1.0
 * @since 2018-09-18
 */

package ca.ualberta.cs.lonelytwitter;

public class TweetTooLongException extends Exception {

    TweetTooLongException() {
        super("This message is too long! Please keep your tweets within 140 characters.");
        //below is optional
    }
}
