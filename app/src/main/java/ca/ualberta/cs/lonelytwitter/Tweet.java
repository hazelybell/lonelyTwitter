/*
 * Tweet
 *
 * January 31, 2018
 *
 * Copyright (c) 2018 Team X, CMPUT301, University of Alberta - All Rights Reserved
 * You may use, distribute or modify the code under terms and conditions of the Code of Student Behaviour at University of Alberta
 * You can find a copy of the license in theis project. Otherwise, please contact contact@example.ca
 */

package ca.ualberta.cs.lonelytwitter;
import java.util.Date;
import java.util.ArrayList;

/**
 * Represents a tweet.
 *
 * @author chris
 * @version 1.5
 * @see NormalTweet
 * @see ImportantTweet
 */
public abstract class Tweet implements Tweetable{
    private String message;
    private Date date;
    private ArrayList<Mood> moods = new ArrayList<Mood>();

    /**
     * Constructs a tweet object.
     *
     * @param message tweet message
     * @throws TweetTooLongException thrown if tweet exceeds 140 characters
     */
    Tweet(String message) throws TweetTooLongException{
        if (message.length() > 140) {
            throw new TweetTooLongException();
        }
        this.message = message;
    }

    /**
     * Constructs a tweet object.
     *
     * @param message tweet message
     * @param date tweet date
     * @throws TweetTooLongException thrown if tweet exceeds 140 characters
     */
    Tweet(String message, Date date) throws TweetTooLongException{
        if (message.length() > 140) {
            throw new TweetTooLongException();
        }
        this.message = message;
        this.date = date;
    }

    /**
     * Gets the tweet date
     *
     * @return returns the tweet date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Gets the tweet message
     *
     * @return returns the tweet message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets tweet message.
     *
     * @param message tweet message
     * @throws TweetTooLongException thrown if tweet exceeds 140 characters
     */
    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() > 140) {
            throw new TweetTooLongException();
        }
        this.message = message;
    }

    /**
     * Sets the tweet date.
     *
     * @param date tweet date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Adds a tweet mood
     *
     * @param mood tweet mood
     */
    public void addMood(Mood mood){
        this.moods.add(mood);
    }

    /**
     * Checks if the tweet is important
     *
     * @return
     */
    public abstract boolean isImportant();
}