package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by noahkryzanowski on 2017-09-13.
 */

public class BadMood extends Mood{
    public BadMood(){
        super();
    }
    public BadMood(Date date){
        super(date);
    }

    @Override
    public String isGoodMood(){
        return "Bad";
    }
}
