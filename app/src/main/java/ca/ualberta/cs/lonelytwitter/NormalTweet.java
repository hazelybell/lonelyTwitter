package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Ken on 21-Sep-2017.
 */

public class NormalTweet extends Tweet{
    public NormalTweet(String message){
        super(message);
    }

    public NormalTweet(String message, Date date){
        super(message, date);
    }

    @Override
    public Boolean isImportant(){
        return Boolean.FALSE;
    }
}
