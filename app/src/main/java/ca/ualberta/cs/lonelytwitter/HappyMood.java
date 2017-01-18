package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by ysu3 on 1/17/17.
 */

public class HappyMood extends Mood {

    public HappyMood(Date date) {
        super(date);
    }

    public String print_mood() {
        return "Good mood";
    }

    public void setMood(String mood){
        super.setMood(mood);
    }
}
