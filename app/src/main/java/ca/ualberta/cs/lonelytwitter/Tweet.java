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
     * Constructs a tweet object, without a date
     *
     * @param message tweet message
     */
    Tweet(String message) {
        this.message = message;
    }

    /**
     * Constructs a tweet object.
     *
     * @param message tweet message
     * @param date tweet date
     */
    Tweet(String message, Date date) {
        this.message = message;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

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
        if (message.length() > 160) {
            throw new TweetTooLongException();
        }
        this.message = message;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void addMood(Mood mood){
        this.moods.add(mood);
    }

    public abstract boolean isImportant();
    @Override
    public String toString(){
        return message;
    }
}