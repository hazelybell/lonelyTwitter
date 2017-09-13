package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by alsobaie on 9/12/17.
 */

public class HappyMood extends Mood{

    public HappyMood() {
        super();
    }

    public HappyMood(Date date) {
        super(date);
    }

    public String whatMood(){
        return "Happy";
    }

}
