package ca.ualberta.cs.lonelytwitter;

/**
 * Created by critt on 2018-01-17.
 */

import java.util.Date;
public class SadMood extends Mood {
    public SadMood(){
        super();
    }

    public SadMood(Date date){
        super(date);
    }

    @Override
    public String getMood(){
        return "I am very sad. :(";
    }
}
