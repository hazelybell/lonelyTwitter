package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;
import java.util.Date;

/**
 * Created by ansonli on 2015-09-14.
 */
public class Sad extends Mood
{

    public Sad (Date date) {
        super(date);
    }


    public Sad() throws IOException {
        super();
    }

    public String getMood() {
        return "(Sad...)";
    }
}
