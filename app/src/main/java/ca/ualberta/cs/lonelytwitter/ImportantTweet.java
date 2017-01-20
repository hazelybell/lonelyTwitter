package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by shida3 on 1/19/17.
 */

public class ImportantTweet extends Tweet {
    public ImportantTweet(String message) {
        super(message);
    }

    public ImportantTweet(Date date, String message) {
        super(date, message);
    }

    @Override
    public Boolean isImportant(){
        return true;
    }
}
