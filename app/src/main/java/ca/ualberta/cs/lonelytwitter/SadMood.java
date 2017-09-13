package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by alsobaie on 9/12/17.
 */

public class SadMood extends Mood{

    public SadMood() {
        super();
    }

    public SadMood(Date date) {
        super(date);
    }

    public String whatMood(){
        return "Sad";
    }

}
