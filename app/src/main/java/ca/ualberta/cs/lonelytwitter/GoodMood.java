package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by noahkryzanowski on 2017-09-13.
 */

public class GoodMood extends Mood {
    public GoodMood(){
        super();
    }
    public GoodMood(Date date){
        super(date);
    }

    @Override
    public String isGoodMood(){
        return "Good";
    }
}
