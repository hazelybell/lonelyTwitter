package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by ysu3 on 1/17/17.
 */

public class NormalTweet extends Tweet {
    public NormalTweet(Date date, String Message) throws TweetTooLongException {
        super(date, Message);
    }

    public NormalTweet(String Message) {
        super(Message);
    }

    public boolean isImportant() {
        return Boolean.FALSE;
    }


}
