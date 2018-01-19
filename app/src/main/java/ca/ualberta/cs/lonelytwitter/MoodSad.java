package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by geng1 on 1/19/18.
 */

public class MoodSad extends CurrentMood {
    public MoodSad(String mood) {
        super(mood);
    }

    public MoodSad(String mood, Date date) {
        super(mood, date);
    }

    @Override
    public Boolean isHappy() {
        return Boolean.FALSE;
    }

    public String getCurrentMood(){
        return ("sad");
    }
}