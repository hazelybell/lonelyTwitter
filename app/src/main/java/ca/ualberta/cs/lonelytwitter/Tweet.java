/*
 * CMPUT 301
 *
 * Version 1.3
 *
 * 1/22/19 6:33 PM
 *
 * Copyright (c) 2019. All rights reserved.
 */

package ca.ualberta.cs.lonelytwitter;

import com.google.gson.Gson;

import java.util.Date;
import java.util.UUID;

/**
 * A class which represents a single message and associated data
 * @author Ryan Jensen
 * @version 1.3
 */
public class Tweet {
    private String message;
    private Date date;

    public UUID getUnique() {
        return Unique;
    }

    public void setUnique(UUID unique) {
        Unique = unique;
    }

    private UUID Unique;

    /**
     * Creates a Tweet object with the provided message
     * @param message a String
     */
    public Tweet(String message){
        this.message = message;
        this.Unique = UUID.randomUUID();
    }
    public Tweet(){
        this.message = "";
    }
    /**
     * Changes the message stored to a new message, overwriting the previous message
     * @param message a new String
     */
    public void setMessage(String message){
        this.message = message;
    }

    /**
     * Obtains the message stored.
     * @return the current message
     */
    public String getMessage(){
        return message;
    }

    /**
     * Converts the Tweet object into a String object
     * @return Returns a string representing the message
     */
    @Override
    public String toString() {
        return message;
    }
}
