package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by enzozafra on 2017-09-13.
 */

public class SadMood extends Mood {

    public SadMood() {
        super();
    }


    public SadMood(Date date) {
        super(date);
    }

    @Override
    public String showMood() {
        return "I am sad :(";
    }


}
