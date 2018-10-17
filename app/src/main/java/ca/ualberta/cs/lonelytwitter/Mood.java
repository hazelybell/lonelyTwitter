/**
 * Mood abstract class allows for setting and getting the
 * date and mood type for a mood object
 * @author Shawna Dawson
 * @version 1.0
 * @since 2018-09-18
 */

package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public abstract class Mood {

    private Date date;

    /**
     * Creates new blank date
     */
    Mood () {
        this.date = new Date();
    }

    /**
     * Creates new set date
     * @param date
     */
    Mood (Date date) {
        this.date = date;
    }

    // getters and setters
    /**
     * Returns the mood object's date
     * @return
     */
    public Date getDate() {
        return this.date;
    }

    /**
     * Sets date to new value
     * @param newDate
     */
    public void setDate(Date newDate) {
        this.date = newDate;
    }

    /**
     * Sub classes must implement class to return mood type
     * @return mood
     */
    public abstract String getMood();
}
