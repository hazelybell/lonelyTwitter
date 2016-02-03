package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by romansky on 1/12/16.
 */
interface Tweetable {
    // getMessage returns the tweet message.
    String getMessage();
    Date getDate();
}
