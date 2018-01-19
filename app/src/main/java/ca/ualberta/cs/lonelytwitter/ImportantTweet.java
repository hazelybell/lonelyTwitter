package ca.ualberta.cs.lonelytwitter;

/**
 * Created by geng1 on 1/19/18.
 */

import java.util.Date;

public class ImportantTweet extends Tweet{

    ImportantTweet(String message){
        super(message);
    }

    ImportantTweet(String message, Date date){
        super(message,date);
    }


    @Override
    public boolean isImportant(){
        return true;
    }
}

