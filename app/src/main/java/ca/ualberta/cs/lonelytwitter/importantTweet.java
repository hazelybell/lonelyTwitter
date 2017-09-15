package ca.ualberta.cs.lonelytwitter;

import android.text.BoringLayout;

import java.util.Date;

/**
 * Created by noahkryzanowski on 2017-09-13.
 */

public class importantTweet extends Tweet {
    public importantTweet(String message){
        super(message);
    }

    public importantTweet(String message, Date date){
        super(message, date);
    }

    @Override
    public Boolean isImportant(){
        return Boolean.TRUE;
    }
}
