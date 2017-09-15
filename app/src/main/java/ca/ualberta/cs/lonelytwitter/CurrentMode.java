package ca.ualberta.cs.lonelytwitter;

/**
 * Created by guanfang on 2017/9/14.
 */

public abstract class CurrentMode extends MoodHappy{
    public String getCurrentMood(String CurrentMood){

        String current = new String();
        if (CurrentMood=="happy"){
            MoodHappy moodHappy = new MoodHappy();
            current = moodHappy.GetHappyMood();
        }
        if (CurrentMood=="sad"){
            MoodSad moodSad = new MoodSad();
            current = moodSad.GetSadMood();
        }
        return current;
    }
}
