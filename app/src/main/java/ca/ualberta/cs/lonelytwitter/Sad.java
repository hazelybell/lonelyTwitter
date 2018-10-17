/**
 * The Sad class extends to Mood class to provide sadness
 * specific functionality.
 *
 * @author Shawna Dawson
 * @version 1.0
 * @since 2018-09-18
 */

package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class Sad extends Mood {

    /**
     * Constructor inherited from Mood class
     */
    Sad () {
        super();
    }

    /**
     * Sets date, inherited from Mood class
     * @param date
     */
    Sad (Date date) {
        super(date);
    }

    /**
     * Returns the designated Happy string
     *
     * @return ":("
     */
    @Override
    public String getMood(){
        return ":(";
    }

}
