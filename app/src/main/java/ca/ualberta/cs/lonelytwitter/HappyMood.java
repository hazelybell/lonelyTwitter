package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by maharshmellow on 2017-09-12.
 */

public class HappyMood extends Mood {

    public HappyMood(){
        super();
    }

    public HappyMood(Date date) {
        super(date);
    }

    public String strMood(){
        return "Happy";
    }


}
