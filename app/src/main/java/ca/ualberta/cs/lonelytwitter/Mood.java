package ca.ualberta.cs.lonelytwitter;

/**
 * Created by critt on 2018-01-17.
 */

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Calendar;
public abstract class Mood {
    private Date date;

    public Mood(){
        this.date = new GregorianCalendar(2018, Calendar.FEBRUARY, 17).getTime();
    }

    public Mood(Date date){
        this.date = date;
    }

    public Date getDate(){
        return date;
    }

    public void setDate(Date date){
        this.date = date;
    }

    public abstract String getMood();
}
