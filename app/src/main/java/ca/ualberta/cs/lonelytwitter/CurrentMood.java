package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by john on 13/09/16.
 */
public  abstract class CurrentMood {
    private Date date;

    public CurrentMood(Date date){

        this.date = date;
    }

    public void SetDate(Date date){

        this.date = date;
    }

    public Date GetDate(){

        return this.date;
    }

    public abstract String DescribeMood();
}
