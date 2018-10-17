/**
 * The Happy class extends to Mood class to provide happiness
 * specific functionality.
 *
 * @author Shawna Dawson
 * @version 1.0
 * @since 2018-09-18
 */

package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class Happy extends Mood {

    /**
     * Constructor inherited from Mood class
     */
    Happy () {
        super();
    }

    /**
     * Sets date, inherited from Mood class
     * @param date
     */
    Happy (Date date) {
        super(date);
    }

    /**
     * Returns the designated Happy string
     *
     * @return ":)"
     */
    @Override
    public String getMood(){
        return ":)";
    }

}
