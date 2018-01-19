package ca.ualberta.cs.lonelytwitter;

/**
 * Created by geng1 on 1/19/18.
 */

import java.util.Date;

public class NormalTweet extends Tweet2 {
    NormalTweet(String message){
        super(message);

    }

    NormalTweet(String message, Date date){
        super(message,date);
    }

    @Override
    public boolean isImportant(){
        return false;
    }
}
