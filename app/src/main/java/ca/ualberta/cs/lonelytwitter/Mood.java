package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by maharshmellow on 2017-09-12.
 */

public abstract class Mood {

    private Date date;

    public Mood(){
        // set default date if no date is passed in
        this.date = new Date();
    }

    public Mood(Date date){
        this.date = date;
    }

    public Date getDate(){
        return this.date;
    }

    public void setDate(Date date){
        this.date = date;
    }

    public abstract String strMood();       // returns the string representation of the mood


}
