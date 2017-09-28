/* Tweet
 *
 * Version 1.0
 *
 * September 27, 2017
 *
 * Copyright © 2017 Team X, CMPUT301, University of Alberta - All Rights Reserved.
 * You may use, distribute, or modify this code under terms and conditions of the Code of Student Behavior at University of Alberta.
 * You can find a cope of the license in this project. Otherwise please contact contact@abc.ca
 */

package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Represents a tweet
 * Created by hrai on 9/13/17.
 * @author team X
 * @version 1.5
 * @see NormalTweet
 * @see ImportantTweet
 * @since 1.0
 */

public abstract class Tweet implements Tweetable {
    private String message;
    private Date date;

    @Override
    public String toString() {
        return date.toString() + " | " + message;
    }

    public Tweet(String message){
        date = new Date();
        this.message = message;
    }

    /**
     * Constructs a Tweet object
     * @param message tweet message
     * @param date tweet date
     */

    public Tweet(String message, Date date){
        this.date = date;
        this.message = message;
    }


    public abstract Boolean isImportant();

    public String getMessage(){
        return message;
    }


    /**
     * Sets the tweet message.
     *
     * @param message tweet message
     * @throws TweetTooLongException
     */
    public void setMessage(String message) throws TweetTooLongException{
        if (message.length() < 140){
            this.message = message;
        }
        else{
            throw new TweetTooLongException();
        }
    }

    public String getMessage() { return this.message;}

    public Date getDate() {
        return date;
    }

    //public abstract Boolean isImportant();
}

