package ca.ualberta.cs.lonelytwitter;

/**
 * Created by geng1 on 1/19/18.
 */

import java.util.Date;

public class MoodHappy extends CurrentMood {
    public MoodHappy(String mood){ super(mood);}

    public MoodHappy(String mood, Date date) {
        super(mood, date);
    }

    @Override
    public Boolean isHappy() {
        return Boolean.TRUE;
    }

    public String getCurrentMood(){
        return ("happy");
    }
}
