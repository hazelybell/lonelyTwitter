package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by jblaz on 2017-09-14.
 */

public class SadMood extends Mood{
    public SadMood(){
        super();
    }
    public SadMood(Date date){
        super(date);
    }

    @Override
    public String isSadMood(){
        return "Sad";
    }
}
