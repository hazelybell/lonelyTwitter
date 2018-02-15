package ca.ualberta.cs.lonelytwitter;

/**
 * Created by critt on 2018-01-17.
 */

import java.util.Date;
public class HappyMood extends Mood {
    public HappyMood(){
        super();
    }

    public HappyMood(Date date){
        super(date);
    }

    @Override
    public String getMood(){
        return "I am so happy! :)";
    }
}
