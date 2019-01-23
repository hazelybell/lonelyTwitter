/*
 * CMPUT 301
 *
 * Version 1.3
 *
 * 1/22/19 6:39 PM
 *
 * Copyright (c) 2019. All rights reserved.
 */

package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Represents the Happy Mood
 * @author Ryan Jensen
 * @version 1.1
 * @see Mood
 */
public class Happy extends Mood {
    // Constructors, default day is epoch time

    /**
     * Create a new Happy object, with the date set at epoch time
     */
    public Happy(){
        this.date = new Date(0);
    }

    /**
     * Create a new Happy object, with the date set as the given date
     * @param date the given date
     */
    public Happy(Date date){
        this.date = date;
    }
    // Do the format. May need to add a String input, since otherwise this is no better than an emoticon

    /**
     * Returns a String representing the given mood
     * @return String
     */
    public String format(){
        return "I am happy! :)";
    }
}
