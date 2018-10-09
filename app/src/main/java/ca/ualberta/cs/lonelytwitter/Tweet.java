/**
 * Tweet class allows for setting and getting the
 * date and tweet text for a tweet object
 * @author Shawna Dawson
 * @version 1.2
 * @since 2018-09-18
 */

package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

//later changed to abstract as an example
public abstract class Tweet implements Tweetable {

    private Date date;
    private String message;
    private static final Integer MAX_CHARS = 140;

    /**
     * Creates and sets a default message and date
     */
    Tweet() {
        this.date = new Date();
        this.message = "I am default message";
    }

    /**
     * Creates and sets a given message and
     * default date
     */
    Tweet(String message) {
        // this is overloading
        this.date = new Date();
        this.message = message; //Tweet my Tweet = new Tweet("Blaurgh");
    }

    // getters and setters

    /**
     * Return date
     * @return this.date
     */
    public Date getDate() {
        return this.date;
    }

    /**
     * Returns tweet text/message
     * @return this.message
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * Sets a new message
     * @param message
     * @throws TweetTooLongException
     */
    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() <= this.MAX_CHARS) {
            this.message = message;
        } else {
            throw new TweetTooLongException();
        }
    }

    /**
     * Subclasses must implement class to return a
     * boolean value indicating importance
     * @return isImportant
     */
    public abstract Boolean isImportant();

    /**
     * Returns the message as a string
     * @return this.getMessage
     */
    public String toString(){
        return this.getMessage();
    }
}