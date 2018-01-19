package ca.ualberta.cs.lonelytwitter;

/**
 * Created by geng1 on 1/19/18.
 */

import java.util.Date;

public class Mood2 extends Tweet{
    Mood2(String mood){
        super(mood);
    }

    Mood2(String mood, Date date){
        super(mood,date);
    }


    @Override
    public boolean isMood2(){
        return true;
    }
}
