/* CMPUT 301 F18 Lab 2
 * Written by Aida Radu
 * Sept. 20 2018
 */

/* Base class representing the current mood */

package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public abstract class MoodModel {
    protected Date date;

    public MoodModel(Date date_in) {
        this.date = date_in;
    }

    public MoodModel() {
        this.date = new Date();
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public abstract String getMood();
}
