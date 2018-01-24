package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by geng1 on 1/19/18.
 */

public class MoodSad2 extends CurrentMood2 {

    MoodSad2(String mood) {
        super(mood);
    }

    MoodSad2(String mood, Date date) {
        super(mood, date);
    }


    @Override
    public Boolean isHappy() {
        return true;
    }
}