package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by ysu3 on 1/17/17.
 */

public class BadMood extends Mood {
    private String mood;

    public BadMood(Date date) {
        super(date);
    }

    public String print_mood() {
        return "Bad Mood";
    }

    public void setMood(){
        super.setMood("Bad mood");
    }
}
