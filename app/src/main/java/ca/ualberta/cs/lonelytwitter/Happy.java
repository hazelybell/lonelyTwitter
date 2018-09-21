/* CMPUT 301 F18 Lab 2
 * Written by Aida Radu
 * Sept. 20 2018
 */

/* Child MoodModel class representing a happy mood */

package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class Happy extends MoodModel {

    public Happy(Date date_in) {
        super(date_in);
    }

    public Happy() {
        super();
    }

    @Override
    public String getMood() {
        return "I am Happy";
    }
}
