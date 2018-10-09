/**
 * NormalTweet is a specific Tweet class to perform
 * normal tweet specific functions.
 *
 * @author Shawna
 * @version 1.0
 * @since 2018-09-18
 */

package ca.ualberta.cs.lonelytwitter;

public class NormalTweet extends Tweet {

    /**
     * Constructor inherited from Tweet class
     */
    NormalTweet() {
        super();
    }

    /**
     * Sets message, inherited from Tweet class
     */
    NormalTweet(String message) {
        super(message);
    }

    /**
     * Returns false since the tweet is not important
     *
     * @return false
     */
    @Override
    public Boolean isImportant(){
        return false;
    }
}
