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
 * Represents the Mood at a given time
 * @author Ryan Jensen
 * @version 1.1
 */
public abstract class Mood {
    // Standard getters and setters for the date
    protected Date date;

    /**
     * Obtains the date stored
     * @return the date
     */
    public Date getDate(){
        return date;
    }

    /**
     * Overwrite the current date with a new one
     * @param date the new date
     */
    public void setDate(Date date){
        this.date = date;
    }
    public abstract String format();
}
