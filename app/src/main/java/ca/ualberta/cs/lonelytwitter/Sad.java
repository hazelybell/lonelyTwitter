package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by pensk on 2017/01/17.
 */

public class Sad extends Mood {
    public Sad() {
        super();
    }

    public Sad(Date date) {
        super(date);
    }
    public String format() {
        return "Sad";
    }
}
