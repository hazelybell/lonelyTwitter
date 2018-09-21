/* CMPUT 301 F18 Lab 2
 * Written by Aida Radu
 * Sept. 20 2018
 */

/* Child MoodModel class representing a sad mood */

package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class Sad extends MoodModel {

    public Sad(Date date_in) {
        super(date_in);
    }

    public Sad() {
        super();
    }

    @Override
    public String getMood() {
        return "I am Sad";
    }
}
