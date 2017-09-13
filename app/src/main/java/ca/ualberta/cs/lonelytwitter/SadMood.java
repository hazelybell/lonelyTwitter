package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by maharshmellow on 2017-09-12.
 */

public class SadMood extends Mood {

    public SadMood(){
        super();
    }

    public SadMood(Date date) {
        super(date);
    }

    public String strMood(){
        return "Sad";
    }
}
