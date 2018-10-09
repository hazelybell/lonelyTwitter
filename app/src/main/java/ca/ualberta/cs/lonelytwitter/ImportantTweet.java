/**
 * ImportantTweet is a specific Tweet class to perform
 * important tweet specific functions.
 *
 * @author Shawna
 * @version 1.0
 * @since 2018-09-18
 */

package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class ImportantTweet extends Tweet {

    /**
     * Constructor inherited from Tweet class
     */
    ImportantTweet() {
        super();
    }

    /**
     * Sets message, inherited from Tweet class
     */
    ImportantTweet(String message) {
        super(message);

    }

    /**
     * Returns true since the tweet is important
     *
     * @return true
     */
    @Override
    public Boolean isImportant() {
        return true;
    }
}
