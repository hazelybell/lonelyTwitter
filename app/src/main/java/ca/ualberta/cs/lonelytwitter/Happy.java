package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;
import java.util.Date;

/**
 * Created by ansonli on 2015-09-14.
 */
public class Happy extends Mood {

    public Happy(Date date) {
        super(date);
    }

    public Happy() throws IOException {
        super();
    }

    public String getMood() {
        return "(Happy!)";
    }
}
