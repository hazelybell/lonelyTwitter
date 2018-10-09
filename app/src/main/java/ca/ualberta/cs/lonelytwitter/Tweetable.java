/**
 * Tweetable interface to define basic functionality
 * required of tweets
 * @author Shawna Dawson
 * @version 1.0
 * @since 2018-09-18
 */

package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public interface Tweetable {
    public String getMessage();
    public Date getDate();
}
