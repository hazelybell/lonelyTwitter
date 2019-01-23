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
 * A type of Mood which represents Anger
 * @author Ryan Jensen
 * @version 1.1
 * @see Mood
 */
public class Anger extends Mood {
    // Standard constructors for the class

    /**
     * Creates a default Anger object. The default time is epoch time.
     */
    public Anger(){
        this.date = new Date(0);
    }

    /**
     * Creates an Anger object with the time set to the given date
     * @param date the given date
     */
    public Anger(Date date){
        this.date = date;
    }
    // Do the format. May need to add a String input, since otherwise this is no better than an emoticon

    /**
     * Returns a String representing Anger
     *
     */
    public String format(){
        return "I am angry! :(";
    }
}
